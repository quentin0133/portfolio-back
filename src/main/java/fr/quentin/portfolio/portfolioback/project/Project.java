package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.core.enums.ProjectCategory;
import fr.quentin.portfolio.portfolioback.core.enums.ProjectStatus;
import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import fr.quentin.portfolio.portfolioback.files.File;
import fr.quentin.portfolio.portfolioback.resource.link.ResourceLink;
import fr.quentin.portfolio.portfolioback.tags.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Project.
 */
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project extends BaseEntity {
    @NotBlank
    @Column(length = 100, nullable = false, unique = true)
    private String title;

    @NotBlank
    @Column(length = 550)
    private String summary;

    @ElementCollection(fetch = FetchType.EAGER)
    @Size(groups = Default.class, min = 1)
    private List<@NotBlank @Size(groups = Default.class, max = 300) String> features;

    @Embedded
    @Column(nullable = false)
    private File coverImage;

    @ElementCollection
    @CollectionTable(
        name = "project_files",
        joinColumns = @JoinColumn(name = "project_id"),
        foreignKey = @ForeignKey(name = "fk_files_project")
    )
    private List<File> files;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectCategory category;

    private LocalDate startDate;

    @Column(length = 11)
    private String idVideo;

    @ElementCollection
    @CollectionTable(
        name = "project_git_links",
        joinColumns = @JoinColumn(name = "project_id"),
        foreignKey = @ForeignKey(name = "fk_git_links_project")
    )
    private List<ResourceLink> gitLinks = new ArrayList<>();

    @Column(length = 500)
    private String demoLink;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status;

    @ManyToMany
    @JoinTable(
        name = "projects_tags",
        joinColumns = @JoinColumn(name = "fk_project_id"),
        inverseJoinColumns = @JoinColumn(name = "fk_tag_id")
    )
    @OrderBy("tagType ASC")
    private List<Tag> tags;
}
