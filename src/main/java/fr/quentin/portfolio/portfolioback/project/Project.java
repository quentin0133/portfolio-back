package fr.quentin.portfolio.portfolioback.project;

import fr.quentin.portfolio.portfolioback.categories.Category;
import fr.quentin.portfolio.portfolioback.files.File;
import fr.quentin.portfolio.portfolioback.core.enums.ProjectStatus;
import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    @Size(min = 1)
    private List<@NotBlank @Size(max = 300) String> features;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_project_id", nullable = false)
    private File coverImage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;

    @ManyToMany
    @JoinTable(
        name = "project_category",
        joinColumns = @JoinColumn(name = "fk_project_id"),
        inverseJoinColumns = @JoinColumn(name = "fk_category_id")
    )
    @OrderBy("categoryGroup.id ASC")
    private List<Category> categories;

    private LocalDate startDate;

    private String idVideo;

    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid URL format")
    private String gitLink;

    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid URL format")
    private String demoLink;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ProjectStatus status;
}
