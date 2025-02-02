package fr.quentin.portfolio.portfolioback.categories.dtos;

import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryPostDto extends BaseDto {
    private String title;

    private long idCategoryGroup;
}
