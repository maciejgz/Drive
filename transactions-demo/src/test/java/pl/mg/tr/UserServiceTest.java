package pl.mg.tr;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mg.tr.user.service.User;
import pl.mg.tr.user.service.UserRepository;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void firstTest() {
        assertEquals(3, userRepository.findAll().size());
    }

    @Test
    public void addUser() {
        User saved = userRepository.save(new User(new Random().nextLong(), "aaa", "bbb"));
        assertNotNull(saved);
        assertEquals(4, userRepository.findAll().size());
    }

    @Test
    public void removeUser() {
        userRepository.deleteById(1L);
        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void secondGetTest() {
        assertEquals(3, userRepository.findAll().size());
        assertNotNull(userRepository.findById(1L));
    }
}
