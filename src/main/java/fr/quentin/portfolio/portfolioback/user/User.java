package fr.quentin.portfolio.portfolioback.user;

import fr.quentin.portfolio.portfolioback.core.generic.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type User.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_users")
public class User extends BaseEntity {
    @Column(unique = true, length = 30)
    private String username;

    @Column(length = 60)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
}
