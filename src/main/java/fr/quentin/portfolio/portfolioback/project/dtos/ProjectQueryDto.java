package fr.quentin.portfolio.portfolioback.project.dtos;

import fr.quentin.portfolio.portfolioback.core.enums.ProjectCategory;
import fr.quentin.portfolio.portfolioback.core.generic.BaseQueryDto;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import fr.quentin.portfolio.portfolioback.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Project query dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectQueryDto extends BaseQueryDto {
    private String title;

    private String summary;

    private List<String> features;

    private FileDto coverImage;

    private List<FileDto> files;

    private ProjectCategory category;

    private LocalDate startDate;

    private String idVideo;

    private String gitLink;

    private String demoLink;

    private String status;

    private List<Tag> tags;
}
