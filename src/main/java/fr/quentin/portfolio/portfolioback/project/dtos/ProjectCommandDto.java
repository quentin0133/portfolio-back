package fr.quentin.portfolio.portfolioback.project.dtos;

import fr.quentin.portfolio.portfolioback.core.enums.ProjectCategory;
import fr.quentin.portfolio.portfolioback.core.enums.ProjectStatus;
import fr.quentin.portfolio.portfolioback.core.generic.BaseCommandDto;
import fr.quentin.portfolio.portfolioback.core.validations.annotation.DateLimit;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import fr.quentin.portfolio.portfolioback.resource.link.dtos.ResourceLinkDto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Project command dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectCommandDto extends BaseCommandDto {
    @NotNull(groups = Default.class, message = "this property can't be null")
    @Size(groups = Default.class, max = 100, message = "the size of this property is limited to 100 characters")
    private String title;

    @NotNull(groups = Default.class, message = "this property can't be null")
    @Size(groups = Default.class, max = 550, message = "the size of this property is limited to 550 characters")
    private String summary;

    @NotEmpty(groups = Default.class, message = "this property can't be empty or null")
    private List<
            @NotBlank(groups = Default.class, message = "the feature can't be blank")
            @Size(groups = Default.class, max = 300, message = "the size of the elements of this property is limited to 300 characters")
            String
        > features;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private ProjectCategory category;

    @DateLimit(max = "1")
    private LocalDate startDate;

    @Size(groups = Default.class, max = 11, message = "the size of this property is limited to 11 characters")
    private String idVideo;

    private List<ResourceLinkDto> gitLinks = new ArrayList<>();

    @Pattern(groups = Default.class, regexp = "^(http|https)://.*$", message = "invalid URL format")
    @Size(groups = Default.class, max = 500, message = "the size of this property is limited to 500 characters")
    private String demoLink;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private ProjectStatus status;

    private List<Long> idsTag;
}
