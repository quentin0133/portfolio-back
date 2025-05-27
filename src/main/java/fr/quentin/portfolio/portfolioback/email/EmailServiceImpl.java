package fr.quentin.portfolio.portfolioback.email;

import fr.quentin.portfolio.portfolioback.email.dtos.EmailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * The type Email service.
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Value("${spring.mail.receiver}")
    private String emailReceiver;

    @Override
    public void sendEmail(EmailDto emailDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailReceiver);
        helper.setFrom(emailSender);
        helper.setSubject("Portfolio : " + emailDto.getSubject());
        helper.setText("Nom: %s\nEmail: %s\nMessage: %s".formatted(emailDto.getName(), emailDto.getEmail(), emailDto.getMessage()));

        mailSender.send(message);
    }
}
