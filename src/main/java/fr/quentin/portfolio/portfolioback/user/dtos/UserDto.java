package fr.quentin.portfolio.portfolioback.user.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

/**
 * The type User dto.
 */
public record UserDto(long id,
                      @Size(groups = Default.class, max = 30, message = "the size of this property is limited to 30 characters")
                      String username,
                      @Size(groups = Default.class, max = 30, message = "the size of this property is limited to 30 characters")
                      String password,
                      List<String> roles)
    implements Serializable {
}
