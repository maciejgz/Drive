package pl.mg.tr.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) throws UserException, UsernameException {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @ExceptionHandler({UserException.class})
    public void handleException() {
        log.error("user exception handled");
    }
}
