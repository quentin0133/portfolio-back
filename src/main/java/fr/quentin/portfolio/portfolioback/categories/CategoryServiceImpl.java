package fr.quentin.portfolio.portfolioback.categories;

import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryDto;
import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryPostDto;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository repository;
    private CategoryMapper mapper;

    @Override
    public List<CategoryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CategoryDto save(CategoryPostDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public CategoryDto update(CategoryPostDto dto) throws ResourceNotFoundException {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Category", dto.getId());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Category", id);
        repository.deleteById(id);
    }

    @Override
    public CategoryDto findById(long id) throws ResourceNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }
}
