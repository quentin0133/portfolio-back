package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.FileWrongFormatException;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.tools.FileUtils;
import fr.quentin.portfolio.portfolioback.core.tools.ValidationUtils;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectCommandDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectQueryDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * The type Project service.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository repository;
    private final ProjectMapper mapper;

    @Value("${file.storage.path}")
    private String uploadDir;

    @Override
    public Page<ProjectQueryDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public List<ProjectQueryDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ProjectQueryDto save(ProjectCommandDto dto, MultipartFile coverImage) throws IOException {
        if (repository.existsByTitle(dto.getTitle()))
            throw new DuplicateKeyException(dto.getTitle());
        if (ValidationUtils.checkFileType(coverImage, "image/*"))
            throw new FileWrongFormatException(coverImage.getName(), "image");

        Project project = mapper.toEntity(dto);

        if (coverImage != null && !coverImage.isEmpty()) {
            FileUtils.delete(project.getCoverImage(), uploadDir);
            project.setCoverImage(FileUtils.upload(coverImage, uploadDir));
        }

        return mapper.toDto(repository.save(project));
    }

    @Override
    public ProjectQueryDto update(ProjectCommandDto dto, MultipartFile coverImage) throws ResourceNotFoundException, IOException {
        if (!repository.existsById(dto.getId())) throw new ResourceNotFoundException("Project", dto.getId());
        if (ValidationUtils.checkFileType(coverImage, "image/*"))
            throw new FileWrongFormatException(coverImage.getName(), "image");

        // Duplicate title check
        ValidationUtils.checkDuplicateByName(
            dto.getTitle(),
            dto.getId(),
            repository::findByTitle,
            Project::getId
        );

        Project project = mapper.toEntity(dto);

        if (coverImage != null && !coverImage.isEmpty()) {
            FileUtils.delete(project.getCoverImage(), uploadDir);
            project.setCoverImage(FileUtils.upload(coverImage, uploadDir));
        }

        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public void deleteById(long id) throws ResourceNotFoundException, IOException {
        Project project = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", id));

        if (project.getCoverImage() != null) {
            FileUtils.delete(project.getCoverImage(), uploadDir);
        }

        if (project.getFiles() != null) {
            FileUtils.delete(project.getFiles(), uploadDir);
        }

        repository.deleteById(id);
    }

    @Override
    public ProjectQueryDto findById(long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(() -> new ResourceNotFoundException("Project", id));
    }

    @Override
    public List<FileDto> uploadFiles(long id, List<MultipartFile> files) throws IOException {
        Project project = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", id));

        // Upload files
        if (files != null && !files.isEmpty()) {
            FileUtils.delete(project.getFiles(), uploadDir);
            project.setFiles(FileUtils.upload(files, uploadDir));
        }

        return mapper.toDto(repository.saveAndFlush(project)).getFiles();
    }
}
