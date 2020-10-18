package pl.mg.bootiful.bootifulcentralizedcinfigurationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BootifulCentralizedConfigurationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootifulCentralizedConfigurationClientApplication.class, args);
	}

}
