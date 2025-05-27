package fr.quentin.portfolio.portfolioback.tags.types.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseQueryDto;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(groups = Default.class, message = "this property can't be null")
    private String name;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String textColorLight;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String backgroundColorLight;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String textColorDark;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String backgroundColorDark;
}
