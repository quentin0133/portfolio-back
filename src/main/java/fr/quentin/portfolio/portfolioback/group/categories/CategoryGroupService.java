package fr.quentin.portfolio.portfolioback.group.categories;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupDto;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupPostDto;

import java.util.List;

public interface CategoryGroupService {
    List<CategoryGroupDto> findAll();

    CategoryGroupDto save(CategoryGroupPostDto dto);

    CategoryGroupDto update(CategoryGroupPostDto dto) throws ResourceNotFoundException;

    void deleteById(long id) throws ResourceNotFoundException;

    CategoryGroupDto findById(long id) throws ResourceNotFoundException;
}
