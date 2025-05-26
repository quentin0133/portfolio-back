package fr.quentin.portfolio.portfolioback.tags.types;

import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagTypeService {
    Page<TagTypeDto> findAll(Pageable pageable);

    List<TagTypeDto> findAll();

    TagTypeDto save(TagTypeDto dto);

    TagTypeDto update(TagTypeDto dto);

    void deleteById(long id);

    TagTypeDto findById(long id);
}
