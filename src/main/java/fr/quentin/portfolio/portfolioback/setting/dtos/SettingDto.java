package fr.quentin.portfolio.portfolioback.setting.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingDto {
    private String key;

    private int version;

    private String value;

    @JsonIgnore
    private boolean isProtected;
}
