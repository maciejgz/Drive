package pl.mg.drive.userweb.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppEventsListeners {

    @EventListener
    public void applicationStartedEventListener(ApplicationStartedEvent event) {
        log.debug("application started event");
    }

}
