package pl.mg.tr.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class UserTransactionsListener {

    /**
     * Catches user creation rollback event
     * @param event
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void rollBackUserCreation(UserCreatedEvent event) {
        String username = event.getUserDto().getUsername();
        log.debug("user {} not created", username);
    }
}
