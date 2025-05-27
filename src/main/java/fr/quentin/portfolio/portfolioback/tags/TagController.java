package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnCreate;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagCommandDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Tag controller.
 */
@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService service;

    /**
     * Find all response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"page", "size"})
    public ResponseEntity<Page<TagQueryDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TagQueryDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagQueryDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Save response entity.
     *
     * @param dto the dto
     * @return the response entity
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagQueryDto> save(@Validated(OnCreate.class) @RequestBody TagCommandDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    /**
     * Update response entity.
     *
     * @param dto the dto
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagQueryDto> update(@Validated(OnUpdate.class) @RequestBody TagCommandDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.update(dto));
    }

    /**
     * Delete by id response entity.
     *
     * @param id the id
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) throws ResourceNotFoundException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
