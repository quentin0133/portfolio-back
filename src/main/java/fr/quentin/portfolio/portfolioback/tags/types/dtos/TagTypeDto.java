package fr.quentin.portfolio.portfolioback.tags.types.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagTypeDto extends BaseDto {
    private String name;
    private String textColorLight;
    private String backgroundColorLight;
    private String textColorDark;
    private String backgroundColorDark;
}
