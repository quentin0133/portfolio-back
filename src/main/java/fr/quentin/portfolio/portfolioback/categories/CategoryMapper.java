package fr.quentin.portfolio.portfolioback.categories;

import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryDto;
import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryPostDto;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapperAbstract;
import fr.quentin.portfolio.portfolioback.group.categories.CategoryGroup;
import fr.quentin.portfolio.portfolioback.group.categories.CategoryGroupRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper extends GenericMapperAbstract<Category, CategoryDto, CategoryPostDto> {
    @Autowired
    private CategoryGroupRepository categoryGroupRepository;

    @Override
    @Mapping(source = "idCategoryGroup", target = "categoryGroup", qualifiedByName = "findCategoryGroupById")
    public abstract Category toEntity(CategoryPostDto dto);

    @Override
    public abstract CategoryDto toDto(Category entity);


    @Named("findCategoryGroupById")
    protected CategoryGroup findCategoryGroupById(long idCategoryGroup) {
        return categoryGroupRepository.findById(idCategoryGroup)
            .orElseThrow(() -> new ResourceNotFoundException("CategoryGroup", idCategoryGroup));
    }
}
