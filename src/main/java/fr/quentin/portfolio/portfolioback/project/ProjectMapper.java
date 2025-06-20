package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.exception.ResourceNotFoundException;
import fr.quentin.portfolio.portfolioback.core.generic.GenericMapperAbstract;
import fr.quentin.portfolio.portfolioback.files.File;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectCommandDto;
import fr.quentin.portfolio.portfolioback.project.dtos.ProjectQueryDto;
import fr.quentin.portfolio.portfolioback.tags.Tag;
import fr.quentin.portfolio.portfolioback.tags.TagRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Project mapper.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ProjectMapper extends GenericMapperAbstract<Project, ProjectQueryDto, ProjectCommandDto> {
    private TagRepository tagRepository;

    /**
     * Sets tag repository.
     *
     * @param tagRepository the tag repository
     */
    @Autowired
    public void setTagRepository(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    @Mapping(source = "idsTag", target = "tags", qualifiedByName = "findTagById")
    @Mapping(target = "coverImage", ignore = true)
    @Mapping(target = "files", ignore = true)
    public abstract Project toEntity(ProjectCommandDto dto);

    /**
     * Find tag by id tag.
     *
     * @param idTag the id tag
     * @return the tag
     */
    @Named("findTagById")
    protected Tag findTagById(long idTag) {
        return tagRepository.findById(idTag)
            .orElseThrow(() -> new ResourceNotFoundException("Tag", idTag));
    }

    /**
     * File name to abstract ressource file.
     *
     * @param multipartFile the multipart file
     * @return the file
     */
    protected File fileNameToAbstractRessource(MultipartFile multipartFile) {
        if (multipartFile == null) return null;
        return new File(multipartFile.getOriginalFilename(), null);
    }

    protected <T> List<T> mapList(List<T> list) {
        return list == null ? new ArrayList<>() : list;
    }
}
