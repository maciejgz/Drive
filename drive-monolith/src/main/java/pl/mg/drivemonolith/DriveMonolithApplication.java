package pl.mg.drivemonolith;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
//@EnableAspectJAutoProxy
@Slf4j
public class DriveMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(DriveMonolithApplication.class, args);
    }

}
