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
public class TagPostDto extends BaseDto {
    private String name;
    private long idTagType;
}
