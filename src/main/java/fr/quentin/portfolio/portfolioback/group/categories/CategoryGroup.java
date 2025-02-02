package fr.quentin.portfolio.portfolioback.group.categories;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import fr.quentin.portfolio.portfolioback.files.File;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories_group")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryGroup extends BaseEntity {
    @NotBlank
    @Column(length = 40, nullable = false)
    private String title;

    @NotBlank
    @Column(length = 20, nullable = false)
    private String backgroundColor; // Hex color

    @NotBlank
    @Column(length = 20, nullable = false)
    private String textColor; // Hex color

    @NotBlank
    @Column(length = 20, nullable = false)
    private String backgroundColorDark; // Hex color

    @NotBlank
    @Column(length = 20, nullable = false)
    private String textColorDark; // Hex color
}
