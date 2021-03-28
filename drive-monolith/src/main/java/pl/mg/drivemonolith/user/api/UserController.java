package pl.mg.drivemonolith.user.api;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mg.drivemonolith.config.security.KeycloackService;
import pl.mg.drivemonolith.user.model.User;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @GetMapping(value = "")
    @PreAuthorize(value = "isAuthenticated()")
    public ResponseEntity<User> getUser(Authentication authentication) {
        String username = KeycloackService.extractUsername(authentication);

        User user = new User(UUID.fromString(authentication.getName()), username);
        return ResponseEntity.ok(user);
    }

}
