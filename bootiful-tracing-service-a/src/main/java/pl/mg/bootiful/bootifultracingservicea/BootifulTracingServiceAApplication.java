package pl.mg.bootiful.bootifultracingservicea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BootifulTracingServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootifulTracingServiceAApplication.class, args);
    }

    @GetMapping(value = "/hello")
    String hello() {
        return "hello";
    }

}