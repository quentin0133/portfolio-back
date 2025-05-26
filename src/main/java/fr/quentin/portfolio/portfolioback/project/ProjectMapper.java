package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapperAbstract;
import fr.quentin.portfolio.portfolioback.files.File;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectPostDto;
import fr.quentin.portfolio.portfolioback.tags.Tag;
import fr.quentin.portfolio.portfolioback.tags.TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProjectMapper extends GenericMapperAbstract<Project, ProjectDto, ProjectPostDto> {
    private TagRepository tagRepository;

    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Mapping(source = "idsTag", target = "tags", qualifiedByName = "findTagById")
    @Mapping(source = "coverImage", target = "coverImage")
    @Mapping(target = "files", ignore = true)
    public abstract Project toEntity(ProjectPostDto dto);

    @Named("findTagById")
    protected Tag findTagById(long idTag) {
        return tagRepository.findById(idTag)
            .orElseThrow(() -> new ResourceNotFoundException("Tag", idTag));
    }

    protected File fileNameToAbstractRessource(MultipartFile multipartFile) {
        if (multipartFile == null) return null;
        return new File(multipartFile.getOriginalFilename(), null);
    }
}
