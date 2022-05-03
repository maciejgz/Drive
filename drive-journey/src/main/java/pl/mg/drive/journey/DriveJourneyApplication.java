package pl.mg.drive.journey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DriveJourneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriveJourneyApplication.class, args);
	}

}
