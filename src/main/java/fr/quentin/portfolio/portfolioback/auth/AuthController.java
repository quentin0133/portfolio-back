package fr.quentin.portfolio.portfolioback.auth;

import fr.quentin.portfolio.portfolioback.auth.dtos.LoginCommandDto;
import fr.quentin.portfolio.portfolioback.auth.dtos.LoginQueryDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     * Login to access the admin methods
     *
     * @param login credentials
     * @return username and roles
     */
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<LoginQueryDto> authenticate(@Valid @RequestBody LoginCommandDto login) {
        return ResponseEntity.ok(authService.authenticate(login));
    }
}
