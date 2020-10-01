package pl.mg.bootiful.bootifultracingserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BootifulTracingServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootifulTracingServiceBApplication.class, args);
    }

    @Bean
    WebClient http(WebClient.Builder builder) {
        return builder.build();
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> ready(WebClient httpClient) {
        return event -> {
            httpClient.get()
                    .uri("http://localhost:8080/hello")
                    .retrieve()
                    .bodyToFlux(String.class)
                    .subscribe(System.out::println);
        };
    }

}
