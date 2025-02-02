package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    Page<ProjectDto> findAll(Pageable pageable);

    List<ProjectDto> findAll();

    ProjectDto save(ProjectPostDto dto);

    ProjectDto update(ProjectPostDto dto) throws ResourceNotFoundException;

    void deleteById(long id) throws ResourceNotFoundException;

    ProjectDto findById(long id);
}
