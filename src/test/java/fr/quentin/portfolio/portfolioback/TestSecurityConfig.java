package fr.quentin.portfolio.portfolioback;

import fr.quentin.portfolio.portfolioback.core.interceptor.JwtAuthFilter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

/**
 * The type Test security config.
 */
@TestConfiguration
public class TestSecurityConfig {
    /**
     * Jwt auth filter jwt auth filter.
     *
     * @return the jwt auth filter
     */
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return mock(JwtAuthFilter.class);
    }
}

