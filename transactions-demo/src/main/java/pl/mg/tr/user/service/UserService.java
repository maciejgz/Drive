package pl.mg.tr.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
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

}
