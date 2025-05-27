package fr.quentin.portfolio.portfolioback.email.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Email dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto implements Serializable {
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String name;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String email;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String message;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String subject;
}
