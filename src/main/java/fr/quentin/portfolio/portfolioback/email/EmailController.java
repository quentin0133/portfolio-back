package fr.quentin.portfolio.portfolioback.email;

import fr.quentin.portfolio.portfolioback.email.dtos.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Email controller.
 */
@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    /**
     * Send email response entity.
     *
     * @param emailDto the email dto
     * @return the response entity
     * @throws MessagingException the messaging exception
     */
    @PostMapping("/send")
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailDto emailDto) throws MessagingException {
        emailService.sendEmail(emailDto);
        return ResponseEntity.noContent().build();
    }
}
