package fr.quentin.portfolio.portfolioback.tags;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import fr.quentin.portfolio.portfolioback.tags.types.TagType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.annotation.Order;

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
