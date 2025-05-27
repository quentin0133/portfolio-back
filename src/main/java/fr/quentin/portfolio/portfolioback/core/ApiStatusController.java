package fr.quentin.portfolio.portfolioback.core;

import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import fr.quentin.portfolio.portfolioback.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Api status controller.
 */
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiStatusController {
    private UserService userService;

    /**
     * Ping response entity.
     *
     * @return the response entity
     */
    @GetMapping("/ping")
    public ResponseEntity<Void> ping() {
        return ResponseEntity.noContent().build();
    }

    /**
     * Is token valid response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @GetMapping(value = "/verify-token", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> isTokenValid(HttpServletRequest request) {
        String token = JwtUtils.getTokenFromRequest(request);
        if (token != null && JwtUtils.validateToken(token, userService.getUserDetailsFromToken(token)))
            return ResponseEntity.ok("The token is valid");
        throw new CredentialsExpiredException("The token is invalid");
    }
}
