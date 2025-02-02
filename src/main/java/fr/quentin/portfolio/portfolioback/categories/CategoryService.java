package fr.quentin.portfolio.portfolioback.categories;

import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryDto;
import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryPostDto;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto save(CategoryPostDto dto);

    CategoryDto update(CategoryPostDto dto) throws ResourceNotFoundException;

    void deleteById(long id) throws ResourceNotFoundException;

    CategoryDto findById(long id) throws ResourceNotFoundException;
}
