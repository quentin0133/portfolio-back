package fr.quentin.portfolio.portfolioback.resource.link;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type ResourceLink.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceLink {
    @NotBlank
    @Column(length = 60, nullable = false, unique = true)
    private String label;

    @Column(length = 500, nullable = false)
    private String link;
}
