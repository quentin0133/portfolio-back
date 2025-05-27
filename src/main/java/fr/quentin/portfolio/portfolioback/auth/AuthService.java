package fr.quentin.portfolio.portfolioback.auth;

import fr.quentin.portfolio.portfolioback.auth.dtos.LoginCommandDto;
import fr.quentin.portfolio.portfolioback.auth.dtos.LoginQueryDto;
import org.springframework.security.core.AuthenticationException;

/**
 * The interface Auth service.
 */
public interface AuthService {
    /**
     * Authenticate login query dto.
     *
     * @param login the login
     * @return the login query dto
     * @throws AuthenticationException the authentication exception
     */
    LoginQueryDto authenticate(LoginCommandDto login) throws AuthenticationException;
}
