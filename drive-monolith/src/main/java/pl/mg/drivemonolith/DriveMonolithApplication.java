package pl.mg.drivemonolith;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableTransactionManagement
//@EnableAspectJAutoProxy
@Slf4j
public class DriveMonolithApplication {


    public static void main(String[] args) {
        SpringApplication.run(DriveMonolithApplication.class, args);
    }

}
