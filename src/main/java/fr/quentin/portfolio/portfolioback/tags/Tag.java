package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import fr.quentin.portfolio.portfolioback.tags.types.TagType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Tag.
 */
@Entity
@Table(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private TagType tagType;
}
