package fr.quentin.portfolio.portfolioback.auth.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;

/**
 * The type Login command dto.
 */
public record LoginCommandDto(
    @NotNull(groups = Default.class, message = "this property can't be null") String username,
    @NotNull(groups = Default.class, message = "this property can't be null") String password
) {
}
