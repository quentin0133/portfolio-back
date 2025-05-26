package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {
    private ProjectService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"page", "size"})
    public ResponseEntity<Page<ProjectDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> save(@ModelAttribute ProjectPostDto dto) throws IOException {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(value = "/upload/{id}/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FileDto>> uploadFiles(@PathVariable long id, @RequestParam("files") List<MultipartFile> files) throws IOException {
        return ResponseEntity.ok(service.uploadFiles(id, files));
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDto> update(@ModelAttribute ProjectPostDto dto) throws ResourceNotFoundException, IOException {
        return ResponseEntity.ok(service.update(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) throws ResourceNotFoundException, IOException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
