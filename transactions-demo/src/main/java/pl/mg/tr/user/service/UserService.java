package pl.mg.tr.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional(rollbackFor = {UserException.class})
    public UserDto addUser(UserDto user) throws UserException, UsernameException {
        var mapper = new ModelMapper();
        userRepository.save(new User(new Random().nextLong(), "u1", "p1"));
        applicationEventPublisher.publishEvent(new UserCreatedEvent(user));
        //imitating checked exception
        if (user.getUsername().startsWith("rollback")) {
            throw new UserException();
        } else if (user.getUsername().startsWith("exception")) {
            // imitating runtime exception
            throw new UsernameException();
        } else if (user.getUsername().startsWith("runtime")) {
            // imitating runtime exception
            throw new RuntimeException();
        }
        return mapper.map(userRepository.save(mapper.map(user, User.class)), UserDto.class);
    }

    /**
     * Support async method creating transaction and stopping for some time
     */
    @Async
    @Transactional(propagation = Propagation.REQUIRED)
    public void createTransactionSupportMethod() {
        userRepository.save(new User(new Random().nextLong(), "support_method", "bbb"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userRepository.save(new User(new Random().nextLong(), "support_method2", "bbb"));
    }

    /**
     * Requires transaction. If not exists - create a new one.
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagationRequired() {
        userRepository.save(new User(new Random().nextLong(), "required", "bbb"));
    }

    /**
     * Uses existing transaction if exists. If there is not transaction - run without
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public void propagationSupported() {
        userRepository.save(new User(new Random().nextLong(), "supports", "bbb"));
    }

    /**
     * Use transaction if exists, if not - throw new exception: IllegalTransactionStateException.
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public void propagationMandatory() {
        userRepository.save(new User(new Random().nextLong(), "mandatory", "bbb"));
    }

    /**
     * If there is a transaction - throws exception
     */
    @Transactional(propagation = Propagation.NEVER)
    public void propagationNever() {
        userRepository.save(new User(new Random().nextLong(), "never", "bbb"));
    }

    /**
     * If a current transaction exists, first Spring suspends it, and then the business logic is executed without a
     * transaction.
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void propagationNotSupported() {
        userRepository.save(new User(new Random().nextLong(), "not_supported", "bbb"));
    }

    /**
     * If transaction exists, stops it and save previously done actions. Eventual rollback is done to the savepoint.
     */
    @Transactional(propagation = Propagation.NESTED)
    public void propagationNested() {
        userRepository.save(new User(new Random().nextLong(), "nested", "bbb"));
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    @Async
    public void longRunningTransaction() {
        User user = userRepository.getOne(123L);
        user.setUsername("long_run_process_before");
        userRepository.save(user);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        user.setUsername("long_run_process_after");
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Async
    public void shortTransaction() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = userRepository.getOne(123L);
        user.setUsername("short_running_process");
    }
}
