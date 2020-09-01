package pl.mg.drive.userweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mg.drive.userweb.dao.User;
import pl.mg.drive.userweb.dao.UserRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class UserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = User.builder().name(name).email(name.toLowerCase() + "@domain.com").build();
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
