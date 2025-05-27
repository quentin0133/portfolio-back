package fr.quentin.portfolio.portfolioback.email;

import fr.quentin.portfolio.portfolioback.email.dtos.EmailDto;
import jakarta.mail.MessagingException;

/**
 * The interface Email service.
 */
public interface EmailService {
    /**
     * Send email.
     *
     * @param emailDto the email dto
     * @throws MessagingException the messaging exception
     */
    void sendEmail(EmailDto emailDto) throws MessagingException;
}
