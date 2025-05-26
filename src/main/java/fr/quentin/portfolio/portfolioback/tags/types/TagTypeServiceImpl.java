package fr.quentin.portfolio.portfolioback.TagTypes.types;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.ValidationUtils;
import fr.quentin.portfolio.portfolioback.project.Project;
import fr.quentin.portfolio.portfolioback.tags.types.TagType;
import fr.quentin.portfolio.portfolioback.tags.types.TagTypeMapper;
import fr.quentin.portfolio.portfolioback.tags.types.TagTypeRepository;
import fr.quentin.portfolio.portfolioback.tags.types.TagTypeService;
import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagTypeServiceImpl implements TagTypeService {
    private final TagTypeRepository repository;
    private final TagTypeMapper mapper;

    @Override
    public Page<TagTypeDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public List<TagTypeDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public TagTypeDto save(TagTypeDto dto) {
        if (repository.existsByName(dto.getName())) {
            throw new DuplicateKeyException(dto.getName());
        }

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public TagTypeDto update(TagTypeDto dto) {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Project", dto.getId());

        // Duplicate name check
        ValidationUtils.checkDuplicateByName(
            dto.getName(),
            dto.getId(),
            repository::findByName,
            TagType::getId
        );

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("TagType", id);
        repository.deleteById(id);
    }

    @Override
    public TagTypeDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("TypeType", id));
    }
}
