package pl.mg.drive.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DriveDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveDiscoveryApplication.class, args);
    }

}
