package fr.quentin.portfolio.portfolioback.core.runner;

import fr.quentin.portfolio.portfolioback.user.User;
import fr.quentin.portfolio.portfolioback.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * The type Data seeder.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataSeeder implements CommandLineRunner {

    @Value("${app.default.username}")
    private String defaultUsername;

    @Value("${app.default.password}")
    private String defaultPassword;

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername(defaultUsername)) {
            User user = new User();
            user.setUsername(defaultUsername);
            user.setPassword(passwordEncoder.encode(defaultPassword));
            user.getRoles().add("ROLE_ADMIN");

            userRepository.save(user);
        }

        File dir = new File("files");
        if (!dir.exists()) {
            boolean created = dir.mkdirs();
            if(created) log.info("'files' folder created at the root of the project!");
            else log.error("Impossible to create the ‘files’ folder!");
        }
    }
}
