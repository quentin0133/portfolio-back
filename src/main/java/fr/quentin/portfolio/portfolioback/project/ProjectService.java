package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    Page<ProjectDto> findAll(Pageable pageable);

    List<ProjectDto> findAll();

    ProjectDto save(ProjectPostDto dto) throws IOException;

    ProjectDto update(ProjectPostDto dto) throws ResourceNotFoundException, IOException;

    void deleteById(long id) throws ResourceNotFoundException, IOException;

    ProjectDto findById(long id);

    List<FileDto> uploadFiles(long id, List<MultipartFile> files) throws IOException;
}
