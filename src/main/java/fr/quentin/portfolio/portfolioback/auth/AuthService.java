package fr.quentin.portfolio.portfolioback.auth;

import fr.quentin.portfolio.portfolioback.auth.dtos.LoginDto;
import fr.quentin.portfolio.portfolioback.auth.dtos.LoginResponseDto;
import org.springframework.security.core.AuthenticationException;

public interface AuthService {
  LoginResponseDto authenticate(LoginDto login) throws AuthenticationException;
}
