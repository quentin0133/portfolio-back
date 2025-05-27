package fr.quentin.portfolio.portfolioback.setting.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Setting admin dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingAdminDto implements Serializable {
    private int version;

    private String key;

    private String value;

    private boolean isProtected;
}
