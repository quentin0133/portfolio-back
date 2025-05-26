package fr.quentin.portfolio.portfolioback.tags.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagDto extends BaseDto {
    private String name;
    private TagTypeDto tagType;
}
