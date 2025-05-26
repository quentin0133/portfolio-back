package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.FileWrongFormatException;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.FileUtils;
import fr.quentin.portfolio.portfolioback.core.tools.ValidationUtils;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public ProjectDto save(ProjectPostDto dto) throws IOException {
        if (repository.existsByTitle(dto.getTitle())) {
            throw new DuplicateKeyException(dto.getTitle());
        }

        if (ValidationUtils.checkFileType(dto.getCoverImage(), "image/*"))
            throw new FileWrongFormatException("coverImage", "image");

        Project project = mapper.toEntity(dto);

        // Upload cover image
        project.setCoverImage(FileUtils.upload(dto.getCoverImage()));

        return mapper.toDto(repository.save(project));
    }

    @Override
    public ProjectDto update(ProjectPostDto dto) throws ResourceNotFoundException, IOException {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Project", dto.getId());

        // Duplicate title check
        ValidationUtils.checkDuplicateByName(
            dto.getTitle(),
            dto.getId(),
            repository::findByTitle,
            Project::getId
        );

        if (ValidationUtils.checkFileType(dto.getCoverImage(), "image/*"))
            throw new FileWrongFormatException(dto.getCoverImage().getName(), "image");

        Project project = mapper.toEntity(dto);
        Project oldProject = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Project", dto.getId()));

        // Upload cover image
        if (dto.getCoverImage() != null) {
            FileUtils.delete(oldProject.getCoverImage());
            project.setCoverImage(FileUtils.upload(dto.getCoverImage()));
        }

        return mapper.toDto(repository.save(project));
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException, IOException {
        Project project = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", id));

        if (project.getCoverImage() != null) {
            FileUtils.delete(project.getCoverImage());
        }

        if (project.getFiles() != null) {
            FileUtils.delete(project.getFiles());
        }

        repository.deleteById(id);
    }

    @Override
    public ProjectDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Project", id));
    }

    @Override
        public List<FileDto> uploadFiles(long id, List<MultipartFile> files) throws IOException {
        Project project = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", id));

        // Upload files
        if (files != null && !files.isEmpty()) {
            FileUtils.delete(project.getFiles());
            project.setFiles(FileUtils.upload(files));
        }

        return mapper.toDto(repository.saveAndFlush(project)).getFiles();
    }
}
