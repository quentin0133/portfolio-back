package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnCreate;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectCommandDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectQueryDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * The type Project controller.
 */
@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {
    private ProjectService service;

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectQueryDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Find all response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"page", "size"})
    public ResponseEntity<Page<ProjectQueryDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectQueryDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Save response entity.
     *
     * @param dto the dto
     * @return the response entity
     * @throws IOException the io exception
     */
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectQueryDto> save(@Validated(OnCreate.class) @ModelAttribute ProjectCommandDto dto) throws IOException {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Upload files response entity.
     *
     * @param id    the id
     * @param files the files
     * @return the response entity
     * @throws IOException the io exception
     */
    @PutMapping(value = "/upload/{id}/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FileDto>> uploadFiles(@PathVariable long id, @RequestParam("files") List<MultipartFile> files) throws IOException {
        return ResponseEntity.ok(service.uploadFiles(id, files));
    }

    /**
     * Update response entity.
     *
     * @param dto the dto
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     * @throws IOException               the io exception
     */
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectQueryDto> update(@Validated(OnUpdate.class) @ModelAttribute ProjectCommandDto dto) throws ResourceNotFoundException, IOException {
        return ResponseEntity.ok(service.update(dto));
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     * @throws IOException               the io exception
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) throws ResourceNotFoundException, IOException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
