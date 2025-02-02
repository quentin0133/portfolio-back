package fr.quentin.portfolio.portfolioback.categories;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import fr.quentin.portfolio.portfolioback.group.categories.CategoryGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntity {
    @NotBlank
    @Column(length = 40, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "fk_category_id", nullable = false)
    private CategoryGroup categoryGroup;
}
