package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagPostDto;
import fr.quentin.portfolio.portfolioback.tags.types.TagType;
import fr.quentin.portfolio.portfolioback.tags.types.TagTypeRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class TagMapper implements GenericMapper<Tag, TagDto, TagPostDto> {
    private TagTypeRepository tagTypeRepository;

    @Autowired
    public void setTagTypeRepository(TagTypeRepository tagTypeRepository) {
        this.tagTypeRepository = tagTypeRepository;
    }

    @Override
    @Mapping(source = "idTagType", target = "tagType", qualifiedByName = "findTagTypeById")
    public abstract Tag toEntity(TagPostDto dto);

    @Named("findTagTypeById")
    protected TagType findCategoryById(long idTagType) {
        return tagTypeRepository.findById(idTagType)
            .orElseThrow(() -> new ResourceNotFoundException("TagType", idTagType));
    }
}
