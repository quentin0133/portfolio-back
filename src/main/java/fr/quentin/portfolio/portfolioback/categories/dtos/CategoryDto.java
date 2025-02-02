package fr.quentin.portfolio.portfolioback.categories.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto extends BaseDto {
    private String title;

    private CategoryGroupDto categoryGroup;
}
