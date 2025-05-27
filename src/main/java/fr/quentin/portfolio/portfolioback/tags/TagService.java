package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.tags.dtos.TagCommandDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagQueryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * The interface Tag service.
 */
public interface TagService {
    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<TagQueryDto> findAll(Pageable pageable);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<TagQueryDto> findAll();

    /**
     * Save tag query dto.
     *
     * @param dto the dto
     * @return the tag query dto
     */
    TagQueryDto save(TagCommandDto dto);

    /**
     * Update tag query dto.
     *
     * @param dto the dto
     * @return the tag query dto
     */
    TagQueryDto update(TagCommandDto dto);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(long id);

    /**
     * Find by id tag query dto.
     *
     * @param id the id
     * @return the tag query dto
     */
    TagQueryDto findById(long id);
}
