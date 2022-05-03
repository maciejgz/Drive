package pl.mg.drive.dgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableEurekaClient
@EnableWebFluxSecurity
public class DriveGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveGatewayApplication.class, args);
    }

}
