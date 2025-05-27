package fr.quentin.portfolio.portfolioback.tags.types;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnCreate;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Tag type controller.
 */
@RestController
@RequestMapping("/api/tag-types")
@RequiredArgsConstructor
public class TagTypeController {
    private final TagTypeService service;

    /**
     * Find all response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"page", "size"})
    public ResponseEntity<Page<TagTypeDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TagTypeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    /**
     * Find by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagTypeDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    /**
     * Save response entity.
     *
     * @param dto the dto
     * @return the response entity
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagTypeDto> save(@Validated(OnCreate.class) @RequestBody TagTypeDto dto) {
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
    public ResponseEntity<TagTypeDto> update(@Validated(OnUpdate.class) @RequestBody TagTypeDto dto) throws ResourceNotFoundException {
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
