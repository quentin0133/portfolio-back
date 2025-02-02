package fr.quentin.portfolio.portfolioback.core.generic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;

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
