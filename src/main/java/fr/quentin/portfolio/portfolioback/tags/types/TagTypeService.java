package fr.quentin.portfolio.portfolioback.tags.types;

import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Tag type service.
 */
public interface TagTypeService {
    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<TagTypeDto> findAll(Pageable pageable);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<TagTypeDto> findAll();

    /**
     * Save tag type dto.
     *
     * @param dto the dto
     * @return the tag type dto
     */
    TagTypeDto save(TagTypeDto dto);

    /**
     * Update tag type dto.
     *
     * @param dto the dto
     * @return the tag type dto
     */
    TagTypeDto update(TagTypeDto dto);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(long id);

    /**
     * Find by id tag type dto.
     *
     * @param id the id
     * @return the tag type dto
     */
    TagTypeDto findById(long id);
}
