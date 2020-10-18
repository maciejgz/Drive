package pl.mg.bootiful.bootifulcentralizedconfigurationclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootifulCentralizedConfigurationClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootifulCentralizedConfigurationClientApplication.class, args);
    }


    @Bean
    ApplicationListener<ApplicationReadyEvent> read(@Value("${greetings}") String message) {
        return event -> {
            System.out.println(message);
        };
    }

}
