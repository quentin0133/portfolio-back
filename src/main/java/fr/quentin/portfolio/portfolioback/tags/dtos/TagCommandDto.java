package fr.quentin.portfolio.portfolioback.tags.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseQueryDto;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String name;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private long idTagType;
}
