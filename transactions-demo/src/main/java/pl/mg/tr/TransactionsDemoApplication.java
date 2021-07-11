package pl.mg.tr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionsDemoApplication.class, args);
    }

}
