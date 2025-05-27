package fr.quentin.portfolio.portfolioback.files.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type File dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String fileName;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String storedFileName;
}
