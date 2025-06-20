package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectCommandDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * The interface Project service.
 */
public interface ProjectService {
    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<ProjectQueryDto> findAll(Pageable pageable);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProjectQueryDto> findAll();

    /**
     * Save project query dto.
     *
     * @param dto the dto
     * @param coverImage the cover image
     * @return the project query dto
     * @throws IOException the io exception
     */
    ProjectQueryDto save(ProjectCommandDto dto, MultipartFile coverImage) throws IOException;

    /**
     * Update project query dto.
     *
     * @param dto the dto
     * @return the project query dto
     * @throws ResourceNotFoundException the resource not found exception
     * @throws IOException               the io exception
     */
    ProjectQueryDto update(ProjectCommandDto dto, MultipartFile coverImage) throws ResourceNotFoundException, IOException;

    /**
     * Delete by id.
     *
     * @param id the id
     * @throws ResourceNotFoundException the resource not found exception
     * @throws IOException               the io exception
     */
    void deleteById(long id) throws ResourceNotFoundException, IOException;

    /**
     * Find by id project query dto.
     *
     * @param id the id
     * @return the project query dto
     */
    ProjectQueryDto findById(long id);

    /**
     * Upload files list.
     *
     * @param id    the id
     * @param files the files
     * @return the list
     * @throws IOException the io exception
     */
    List<FileDto> uploadFiles(long id, List<MultipartFile> files) throws IOException;
}
