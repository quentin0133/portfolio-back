package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.FileWrongFormatException;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository repository;
    private ProjectMapper mapper;

    @Override
    public Page<ProjectDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public List<ProjectDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ProjectDto save(ProjectPostDto dto) {
        if (dto.getCoverImage().getContentType() == null ||
            !dto.getCoverImage().getContentType().startsWith("image/"))
            throw new FileWrongFormatException(dto.getCoverImage().getName(), "image");

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProjectDto update(ProjectPostDto dto) throws ResourceNotFoundException {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Project", dto.getId());
        if (dto.getCoverImage().getContentType() == null ||
            !dto.getCoverImage().getContentType().startsWith("image/"))
            throw new FileWrongFormatException(dto.getCoverImage().getName(), "image");

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException {
        if (!repository.existsById(id)) throw new ResourceNotFoundException("Project", id);
        repository.deleteById(id);
    }

    @Override
    public ProjectDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Project", id));
    }
}
