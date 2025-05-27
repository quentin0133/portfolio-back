package fr.quentin.portfolio.portfolioback.user;

import fr.quentin.portfolio.portfolioback.auth.UserSecurity;
import fr.quentin.portfolio.portfolioback.core.tools.JwtUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type User service.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).map(UserSecurity::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails getUserDetailsFromToken(String token) {
        String username = JwtUtils.extractUsername(token);
        return loadUserByUsername(username);
    }
}