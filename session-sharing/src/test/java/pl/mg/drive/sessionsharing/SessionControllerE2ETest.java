package pl.mg.drive.sessionsharing;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import redis.clients.jedis.Jedis;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionControllerE2ETest {

    private Jedis jedis;
    private static TestRestTemplate testRestTemplate;
    private static TestRestTemplate testRestTemplateSecondInstance;
    private static TestRestTemplate testRestTemplateWithAuth;
    private final String testUrl = "http://localhost:8081/";
    private final String testUrlSecondInstance = "http://localhost:8082/";

    @BeforeClass
    public static void initRestTemplate() {
        testRestTemplate = new TestRestTemplate();
        testRestTemplateWithAuth = new TestRestTemplate("admin", "password");
        testRestTemplateSecondInstance = new TestRestTemplate();
    }

    @Before
    public void clearRedisData() {
        jedis = new Jedis("192.168.99.102", 6379);
        jedis.flushDB();
    }

    @Test
    @DisplayName(value = "Verify redis connection and emptiness")
    public void testRedisIsEmpty() {
        Set<String> result = jedis.keys("*");
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName(value = "unauthenticated user access to the protected resource")
    public void testUnauthenticatedCantAccess() {
        ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
    }

    @Test
    @DisplayName(value = "login to one instance, pass JSESSIONID to another request, access without JSESSIONID")
    public void testRedisControlsSession() {
        ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
        assertEquals("hello admin", result.getBody()); //login worked

        Set<String> redisResult = jedis.keys("*");
        assertTrue(redisResult.size() > 0); //redis is populated with session data

        String sessionCookie = result.getHeaders().get("Set-Cookie").get(0).split(";")[0];
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionCookie);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
        assertEquals("hello admin", result.getBody()); //access with session works worked

        jedis.flushAll(); //clear all keys in redis

        result = testRestTemplate.exchange(testUrl, HttpMethod.GET, httpEntity, String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
        //access denied after sessions are removed in redis
    }

    @Test
    @DisplayName(value = "pass session to another instance")
    public void testPassingAuthenticationToAnotherInstance() {
        ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
        assertEquals("hello admin", result.getBody()); //login to first instance

        Set<String> redisResult = jedis.keys("*");
        assertTrue(redisResult.size() > 0); //redis is populated with session data

        String sessionCookie = result.getHeaders().get("Set-Cookie").get(0).split(";")[0];
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionCookie);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        result = testRestTemplateSecondInstance.exchange(testUrlSecondInstance, HttpMethod.GET, httpEntity, String.class);
        assertEquals("hello admin", result.getBody());
    }

}
