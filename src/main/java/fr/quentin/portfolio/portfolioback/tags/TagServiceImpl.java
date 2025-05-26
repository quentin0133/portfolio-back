package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagPostDto;
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
public class TagServiceImpl implements TagService {
    private final TagRepository repository;
    private final TagMapper mapper;

    @Override
    public Page<TagDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public List<TagDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public TagDto save(TagPostDto dto) {
        if (repository.existsByName(dto.getName())) {
            throw new DuplicateKeyException(dto.getName());
        }

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public TagDto update(TagPostDto dto) {
        if (repository.existsByName(dto.getName())) {
            throw new DuplicateKeyException(dto.getName());
        }

        return mapper.toDto(repository.saveAndFlush(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Tag", id);
        repository.deleteById(id);
    }

    @Override
    public TagDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Tag", id));
    }
}
