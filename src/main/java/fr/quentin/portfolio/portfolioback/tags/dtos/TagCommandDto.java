package fr.quentin.portfolio.portfolioback.tags.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseQueryDto;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Tag command dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagCommandDto extends BaseQueryDto {
    @Size(groups = Default.class, max = 40)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String name;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private long idTagType;
}
