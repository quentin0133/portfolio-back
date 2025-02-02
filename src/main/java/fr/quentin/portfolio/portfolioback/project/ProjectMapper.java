package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.categories.Category;
import fr.quentin.portfolio.portfolioback.categories.CategoryMapper;
import fr.quentin.portfolio.portfolioback.categories.CategoryRepository;
import fr.quentin.portfolio.portfolioback.core.enums.ProjectStatus;
import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapperAbstract;
import fr.quentin.portfolio.portfolioback.files.FileMapper;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = { CategoryMapper.class, FileMapper.class })
public abstract class ProjectMapper extends GenericMapperAbstract<Project, ProjectDto, ProjectPostDto> {
    private CategoryRepository categoryRepository;

    @Override
    @Mapping(source = "idsCategory", target = "categories", qualifiedByName = "findCategoryById")
    @Mapping(source = "coverImage", target = "coverImage")
    @Mapping(source = "files", target = "files")
    public abstract Project toEntity(ProjectPostDto dto);

    @Override
    @Mapping(source = "status", target = "status", qualifiedByName = "statusToString")
    public abstract ProjectDto toDto(Project entity);

    @Named("findCategoryById")
    protected Category findCategoryById(long idCategory) {
        return categoryRepository.findById(idCategory)
            .orElseThrow(() -> new ResourceNotFoundException("CategoryGroup", idCategory));
    }

    @Named("statusToString")
    protected String statusToString(ProjectStatus projectStatus) {
        return projectStatus.getDescription();
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
