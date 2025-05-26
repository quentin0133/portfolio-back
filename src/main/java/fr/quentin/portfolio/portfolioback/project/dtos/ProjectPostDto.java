package fr.quentin.portfolio.portfolioback.project.dtos;

import fr.quentin.portfolio.portfolioback.core.enums.ProjectCategory;
import fr.quentin.portfolio.portfolioback.core.enums.ProjectStatus;
import fr.quentin.portfolio.portfolioback.core.generic.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectPostDto extends BaseDto {
    private String title;

    private String summary;

    private List<String> features;

    private MultipartFile coverImage;

    private ProjectCategory category;

    private LocalDate startDate;

    private String idVideo;

    private String gitLink;

    private String demoLink;

    private ProjectStatus status;

    private List<Long> idsTag;
}
