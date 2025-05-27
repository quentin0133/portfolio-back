package fr.quentin.portfolio.portfolioback.core.generic;

import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Base query dto.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseQueryDto implements Serializable {
    @NotNull(groups = OnUpdate.class, message = "this property can't be null when updating")
    private Long id;

    @NotNull(groups = OnUpdate.class, message = "this property can't be null when updating")
    private Integer version;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BaseQueryDto baseQueryDto)) return false;
        return Objects.equals(id, baseQueryDto.id) && Objects.equals(version, baseQueryDto.version);
    }

    @Override
    public int hashCode() {
        return 31 * Long.hashCode(id) + version;
    }
}
