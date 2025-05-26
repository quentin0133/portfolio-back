package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.tags.dtos.TagDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagPostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Page<TagDto> findAll(Pageable pageable);

    List<TagDto> findAll();

    TagDto save(TagPostDto dto);

    TagDto update(TagPostDto dto);

    void deleteById(long id);

    TagDto findById(long id);
}
