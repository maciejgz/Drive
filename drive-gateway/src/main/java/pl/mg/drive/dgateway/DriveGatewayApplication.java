package pl.mg.drive.dgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DriveGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveGatewayApplication.class, args);
    }

}
