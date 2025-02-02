package fr.quentin.portfolio.portfolioback.core;

import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiStatusController {
    private UserDetailsService userDetailsService;

    @GetMapping("/ping")
    public ResponseEntity<Void> ping() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/verify-token", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> isTokenValid(HttpServletRequest request) {
        String token = JwtUtils.getTokenFromRequest(request);
        if (token != null && JwtUtils.validateToken(token, getUserDetailsFromToken(token)))
            return ResponseEntity.ok("Le token est valide");
        throw new CredentialsExpiredException("Le token n'est pas valide");
    }

    private UserDetails getUserDetailsFromToken(String token) {
        String username = JwtUtils.extractUsername(token);
        return userDetailsService.loadUserByUsername(username);
    }
}
