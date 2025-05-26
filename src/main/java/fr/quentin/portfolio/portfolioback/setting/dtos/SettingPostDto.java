package fr.quentin.portfolio.portfolioback.setting.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingPostDto {
    private String key;

    private int version;

    private String value;

    private boolean isProtected;
}
