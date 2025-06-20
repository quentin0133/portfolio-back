package fr.quentin.portfolio.portfolioback.core.generic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * The type Base entity.
 */
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEntity {
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    /**
     * The Version.
     */
    @Version
    protected int version;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BaseEntity baseEntity)) return false;
        return id == baseEntity.id && version == baseEntity.version;
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(id) + version;
    }
}
