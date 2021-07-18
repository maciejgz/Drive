package pl.mg.ks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.internals.QueryableStoreProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableBinding(AnalyticsBinding.class)
@Slf4j
public class KafkaStreamApplication {

    @Component
    public static class PageViewEventSource implements ApplicationRunner {

        private final MessageChannel pageViewsOut;

        public PageViewEventSource(AnalyticsBinding binding) {
            this.pageViewsOut = binding.pageViewsOut();
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            List<String> names = Arrays.asList("jlong", "pweb", "some", "name", "sask", "quantuo");
            List<String> pages = Arrays.asList("blog", "sitemap", "initilizr", "news", "colon", "about");

            Runnable runnable = () -> {
                String rPage = pages.get(new Random().nextInt(pages.size()));

                String rUser = names.get(new Random().nextInt(names.size()));

                PageViewEvent event = new PageViewEvent(rUser, rPage, Math.random() > 0.5 ? 10 : 1000);
                Message<PageViewEvent> message = MessageBuilder
                        .withPayload(event)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, event.getUserId().getBytes())
                        .build();
                try {
                    this.pageViewsOut.send(message);
                    log.info("sent {}", message);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            };
            Executors.newScheduledThreadPool(1).scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
        }
    }

    @Component
    @Slf4j
    public static class PageViewEventProcessor {

        @StreamListener
        @SendTo(AnalyticsBinding.PAGE_COUNTS_OUT)
        public KStream<String, Long> process(@Input(AnalyticsBinding.PAGE_VIEWS_IN) KStream<String, PageViewEvent> events) {
            return events
                    .filter((key, value) -> value.getDuration() > 10)
                    .map((key, value) -> new KeyValue<>(value.getPage(), "0"))
                    .groupByKey()
                    //.windowedBy(TimeWindows.of(Duration.ofHours(1)))
                    .count(Materialized.as(AnalyticsBinding.PAGE_COUNT_MV))
                    .toStream();
        }
    }

    @Component
    @Slf4j
    public static class PageCountSink {
        @StreamListener
        public void process(@Input((AnalyticsBinding.PAGE_COUNT_IN)) KTable<String, Long> counts) {
            counts.toStream()
                    .foreach((key, value) -> log.debug(key + " " + value));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamApplication.class, args);
    }
}

interface AnalyticsBinding {

    String PAGE_VIEWS_OUT = "pvout";
    String PAGE_VIEWS_IN = "pvin";
    String PAGE_COUNT_MV = "pcmv";
    String PAGE_COUNTS_OUT = "pcout";
    String PAGE_COUNT_IN = "pcin";

    //page views
    @Input(value = PAGE_VIEWS_IN)
    KStream<String, PageViewEvent> pageViewsIn();

    @Output(value = PAGE_VIEWS_OUT)
    MessageChannel pageViewsOut();

    //page counts
    @Output(value = PAGE_COUNTS_OUT)
    KStream<String, Long> pageCountOut();

    @Input(value = PAGE_COUNT_IN)
    KTable<String, Long> pageCountIn();

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class PageViewEvent {
    private String userId, page;
    private long duration;
}
