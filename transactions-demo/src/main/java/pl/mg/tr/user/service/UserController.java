package pl.mg.tr.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping(value = "/propagation_required")
    public ResponseEntity<String> propagationRequired() {
        userService.propagationRequired();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_supported_without")
    public ResponseEntity<String> propagationSupportedWithout() {
        userService.propagationSupported();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_supported_with")
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<String> propagationSupportedWith() {
        userService.propagationSupported();
        return ResponseEntity.ok("");
    }


    @PostMapping(value = "/propagation_mandatory_with")
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<String> propagationMandatoryWith() {
        userService.propagationMandatory();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_mandatory_without")
    public ResponseEntity<String> propagationMandatoryWithout() {
        userService.propagationMandatory();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_never_without")
    public ResponseEntity<String> propagationNeverWithout() {
        userService.propagationNever();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_never_with")
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<String> propagationNeverWith() {
        userService.propagationNever();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_not_supported_with")
    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity<String> propagationNotSupportedWith() {
        userService.propagationNotSupported();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_not_supported_without")
    public ResponseEntity<String> propagationNotSupportedWithout() {
        userService.propagationNotSupported();
        return ResponseEntity.ok("");
    }

    @PostMapping(value = "/propagation_nested")
    public ResponseEntity<String> propagationNested() {
        userService.propagationNested();
        return ResponseEntity.ok("");
    }

    @ExceptionHandler({UserException.class})
    public void handleException() {
        log.error("user exception handled");
    }


    /**
     * Synchronization scenario: jeden wątek wykonuje długo trwającą operację na encji
     * a drugi proces w tym samym czasie aktualizuje tę samą encję.
     *
     * @return
     */
    @PostMapping(value = "/synchronization_scenario")
    public ResponseEntity<String> synchronizationScenario() throws UsernameException, UserException {
        //create user
        UserDto userDto = new UserDto(123L, "long_running", "pass");
        userService.addUser(userDto);
        //get user and start editing with long running transaction in async
        userService.longRunningTransaction();
        //open another, short transaction and close in async
        userService.shortTransaction();


        return ResponseEntity.ok("");
    }
}
