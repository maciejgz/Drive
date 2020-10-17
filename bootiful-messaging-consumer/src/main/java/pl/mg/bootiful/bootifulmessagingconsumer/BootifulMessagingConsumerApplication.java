package pl.mg.bootiful.bootifulmessagingconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@SpringBootApplication
@EnableBinding(Sink.class)
public class BootifulMessagingConsumerApplication {

    @StreamListener(Sink.INPUT)
    public void newMessage(Message<String> message) {
        System.out.println(message.getPayload());
    }

    public static void main(String[] args) {
        SpringApplication.run(BootifulMessagingConsumerApplication.class, args);
    }

}
