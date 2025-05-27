package fr.quentin.portfolio.portfolioback.setting.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * The type Setting public dto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingPublicDto implements Serializable {
    private int version;

    private String key;

    private String value;

    @JsonIgnore
    private boolean isProtected;
}
