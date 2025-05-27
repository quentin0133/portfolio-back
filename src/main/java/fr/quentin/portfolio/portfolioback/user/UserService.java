package fr.quentin.portfolio.portfolioback.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The interface User service.
 */
public interface UserService extends UserDetailsService {
    /**
     * Gets user details from token.
     *
     * @param token the token
     * @return the user details from token
     */
    UserDetails getUserDetailsFromToken(String token);
}
