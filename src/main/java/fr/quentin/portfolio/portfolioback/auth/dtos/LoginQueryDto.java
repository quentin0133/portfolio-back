package fr.quentin.portfolio.portfolioback.auth.dtos;

import java.io.Serializable;
import java.util.List;

/**
 * The type Login query dto.
 */
public record LoginQueryDto(UserDto user, String token) implements Serializable {
    /**
     * The type User dto.
     */
    public record UserDto(long id, String username, List<String> roles)
            implements Serializable {
    }
}
