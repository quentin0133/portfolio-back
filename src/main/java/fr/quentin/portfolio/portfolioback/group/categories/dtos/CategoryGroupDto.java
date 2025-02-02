package fr.quentin.portfolio.portfolioback.group.categories.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryGroupDto extends BaseDto {
    private String title;

    private String backgroundColor; // Hex color

    private String textColor; // Hex color

    private String backgroundColorDark; // Hex color

    private String textColorDark; // Hex color
}
