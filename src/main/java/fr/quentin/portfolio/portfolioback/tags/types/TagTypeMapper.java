package fr.quentin.portfolio.portfolioback.tags.types;

import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.tags.types.dtos.TagTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagTypeMapper extends GenericMapper<TagType, TagTypeDto, TagTypeDto> {
}
