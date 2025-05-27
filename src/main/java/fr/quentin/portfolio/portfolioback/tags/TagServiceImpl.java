package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.ValidationUtils;
import fr.quentin.portfolio.portfolioback.project.ProjectRepository;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagCommandDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagQueryDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Tag service.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository repository;
    private final TagMapper mapper;

    private final ProjectRepository projectRepository;

    @Override
    public Page<TagQueryDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public List<TagQueryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public TagQueryDto save(TagCommandDto dto) {
        if (repository.existsByName(dto.getName()))
            throw new DuplicateKeyException(dto.getName());

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public TagQueryDto update(TagCommandDto dto) {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Tag", dto.getId());

        // Duplicate name check
        ValidationUtils.checkDuplicateByName(
            dto.getName(),
            dto.getId(),
            repository::findByName,
            Tag::getId
        );

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Tag", id);
        if (projectRepository.existsByTags_Id(id)) throw new ResourceConstraintViolationException("Tag", "Project", id);
        repository.deleteById(id);
    }

    @Override
    public TagQueryDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Tag", id));
    }
}
