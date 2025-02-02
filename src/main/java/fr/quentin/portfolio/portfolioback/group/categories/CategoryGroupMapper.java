package fr.quentin.portfolio.portfolioback.group.categories;

import fr.quentin.portfolio.portfolioback.core.generic.GenericMapper;
import fr.quentin.portfolio.portfolioback.files.File;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupDto;
import fr.quentin.portfolio.portfolioback.group.categories.dtos.CategoryGroupPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryGroupMapper extends GenericMapper<CategoryGroup, CategoryGroupDto, CategoryGroupPostDto> {
}
