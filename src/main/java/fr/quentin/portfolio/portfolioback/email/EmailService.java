package fr.quentin.portfolio.portfolioback.email;

import fr.quentin.portfolio.portfolioback.email.dtos.EmailDto;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(EmailDto emailDto) throws MessagingException;
}
