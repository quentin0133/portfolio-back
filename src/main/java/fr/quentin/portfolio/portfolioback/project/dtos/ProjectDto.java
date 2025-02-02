package fr.quentin.portfolio.portfolioback.project.dtos;

import fr.quentin.portfolio.portfolioback.categories.dtos.CategoryDto;
import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import fr.quentin.portfolio.portfolioback.files.dtos.FileDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDto extends BaseDto {
    private String title;

    private String summary;

    private List<String> features;

    private FileDto coverImage;

    private List<FileDto> files;

    private List<CategoryDto> categories;

    private LocalDate startDate;

    private String idVideo;

    private String gitLink;

    private String demoLink;

    private String status;
}
