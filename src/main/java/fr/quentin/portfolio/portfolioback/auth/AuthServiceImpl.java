package fr.quentin.portfolio.portfolioback.auth;

import fr.quentin.portfolio.portfolioback.auth.dtos.LoginCommandDto;
import fr.quentin.portfolio.portfolioback.auth.dtos.LoginQueryDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

/**
 * The type Auth service.
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
  private static final String URL_CHECK_HCAPTCHA = "https://hcaptcha.com/siteverify";

  private final AuthMapper mapper;
  private final AuthenticationManager authenticationManager;

  @Value("${hcaptcha.secret.key}")
  private String secretKeyCaptcha;

  @Value("${hcaptcha.enabled}")
  private boolean isEnabledHCaptcha;

  @Override
  public LoginQueryDto authenticate(LoginCommandDto login) throws AuthenticationException {
    if (!verifyHcaptcha(login.captchaToken()))
      throw new BadCredentialsException("Invalid captcha");

    Authentication authenticate =
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.username(), login.password()));

    if (authenticate.isAuthenticated()) {
      log.info(
          "Successful authentication for user {} at {}",
          login.username(),
          LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
      );
      return mapper.toLoginResponse((UserSecurity) authenticate.getPrincipal());
    }

    throw new BadCredentialsException("Invalid credentials");
  }

  private boolean verifyHcaptcha(String token) {
    if (!isEnabledHCaptcha) return true;

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("response", token);
    map.add("secret", secretKeyCaptcha);

    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

    ResponseEntity<Map> response = restTemplate.postForEntity(URL_CHECK_HCAPTCHA, request, Map.class);
    Map<String, Object> body = response.getBody();

    return (Boolean) body.get("success");
  }
}
