package pl.mg.drivemonolith.config.security;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.security.core.Authentication;

import java.security.Principal;

public class KeycloackService {

    public static String extractUsername(Authentication authentication) {
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) authentication;
        final Principal principal = (Principal) authentication.getPrincipal();
        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            IDToken idToken = kPrincipal.getKeycloakSecurityContext().getToken();
            return idToken.getPreferredUsername();
        } else {
            throw new IllegalArgumentException();
        }
    }

}
