package fr.quentin.portfolio.portfolioback.setting;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Setting.
 */
@Entity
@Table(name = "settings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Setting {
    @Id
    @Column(name = "setting_key", length = 50)
    private String key;

    @Version
    private int version;

    @Column(name = "setting_value", nullable = false)
    private String value;

    @Column(nullable = false)
    private boolean isProtected;
}
