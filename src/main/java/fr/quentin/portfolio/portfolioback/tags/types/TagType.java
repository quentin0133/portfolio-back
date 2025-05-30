package fr.quentin.portfolio.portfolioback.tags.types;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Tag type.
 */
@Entity
@Table(name = "tag_types")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TagType extends BaseEntity {
    @Column(unique = true, nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 7)
    private String textColorLight; // hexa with strong color

    @Column(nullable = false, length = 7)
    private String textColorDark; // hexa with strong color

    @Column(nullable = false, length = 7)
    private String backgroundColorLight; // hexa with strong color

    @Column(nullable = false, length = 7)
    private String backgroundColorDark; // hexa with strong color
}
