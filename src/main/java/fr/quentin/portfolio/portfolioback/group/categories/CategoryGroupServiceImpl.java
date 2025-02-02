package fr.quentin.portfolio.portfolioback.group.categories;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupDto;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupPostDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryGroupServiceImpl implements CategoryGroupService {
    private CategoryGroupRepository repository;
    private CategoryGroupMapper mapper;

    @Override
    public List<CategoryGroupDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public CategoryGroupDto save(CategoryGroupPostDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public CategoryGroupDto update(CategoryGroupPostDto dto) throws ResourceNotFoundException {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Category", dto.getId());
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Category", id);
        repository.deleteById(id);
    }

    @Override
    public CategoryGroupDto findById(long id) throws ResourceNotFoundException {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Category", id));
    }
}
