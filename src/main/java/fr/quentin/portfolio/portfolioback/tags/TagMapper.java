package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagCommandDto;
import fr.quentin.portfolio.portfolioback.tags.dtos.TagQueryDto;
import fr.quentin.portfolio.portfolioback.tags.types.TagType;
import fr.quentin.portfolio.portfolioback.tags.types.TagTypeRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The type Tag mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class TagMapper implements GenericMapper<Tag, TagQueryDto, TagCommandDto> {
    private TagTypeRepository tagTypeRepository;

    /**
     * Sets tag type repository.
     *
     * @param tagTypeRepository the tag type repository
     */
    @Autowired
    public void setTagTypeRepository(TagTypeRepository tagTypeRepository) {
        this.tagTypeRepository = tagTypeRepository;
    }

    @Override
    @Mapping(source = "idTagType", target = "tagType", qualifiedByName = "findTagTypeById")
    public abstract Tag toEntity(TagCommandDto dto);

    /**
     * Find category by id tag type.
     *
     * @param idTagType the id tag type
     * @return the tag type
     */
    @Named("findTagTypeById")
    protected TagType findCategoryById(long idTagType) {
        return tagTypeRepository.findById(idTagType)
            .orElseThrow(() -> new ResourceNotFoundException("TagType", idTagType));
    }
}
