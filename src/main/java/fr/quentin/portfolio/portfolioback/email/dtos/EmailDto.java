package fr.quentin.portfolio.portfolioback.email.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String name;
    private String email;
    private String message;
    private String subject;
}
