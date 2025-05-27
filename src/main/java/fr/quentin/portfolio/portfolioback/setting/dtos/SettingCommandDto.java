package fr.quentin.portfolio.portfolioback.setting.dtos;

import fr.quentin.portfolio.portfolioback.core.validations.groups.Default;
import fr.quentin.portfolio.portfolioback.core.validations.groups.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Setting command dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingCommandDto {
    @NotNull(groups = OnUpdate.class, message = "this property can't be null when updating")
    private int version;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String key;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private String value;

    @NotNull(groups = Default.class, message = "this property can't be null")
    private boolean isProtected;
}
