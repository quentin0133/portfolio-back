package fr.quentin.portfolio.portfolioback.resource.link.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type ResourceLink query dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResourceLinkDto {
    @Size(groups = Default.class, max = 60, message = "the size of this property is limited to 60 characters")
    private String label;

    @Pattern(groups = Default.class, regexp = "^(http|https)://.*$", message = "invalid URL format")
    @Size(groups = Default.class, max = 500, message = "the size of this property is limited to 500 characters")
    private String link;
}
