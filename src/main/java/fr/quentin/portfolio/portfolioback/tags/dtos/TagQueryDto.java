package fr.quentin.portfolio.portfolioback.tags.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseCommandDto;
import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Tag query dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagQueryDto extends BaseCommandDto {
    private String name;
    private TagTypeDto tagType;
}
