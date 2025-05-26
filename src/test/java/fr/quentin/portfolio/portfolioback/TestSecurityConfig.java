package fr.quentin.portfolio.portfolioback;

import fr.quentin.portfolio.portfolioback.core.interceptor.JwtAuthFilter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestSecurityConfig {
    @Bean
    public JwtAuthFilter jwtAuthFilter() {
        return mock(JwtAuthFilter.class);
    }
}

