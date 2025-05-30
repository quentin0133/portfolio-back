package fr.quentin.portfolio.portfolioback.tags.types.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseQueryDto;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Tag type dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagTypeDto extends BaseQueryDto {
    @Size(groups = Default.class, max = 40)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String name;

    @Size(groups = Default.class, max = 7)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String textColorLight;

    @Size(groups = Default.class, max = 7)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String backgroundColorLight;

    @Size(groups = Default.class, max = 7)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String textColorDark;

    @Size(groups = Default.class, max = 7)
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String backgroundColorDark;
}
