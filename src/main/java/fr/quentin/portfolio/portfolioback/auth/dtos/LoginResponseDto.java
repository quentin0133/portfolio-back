package fr.quentin.portfolio.portfolioback.auth.dtos;

import java.io.Serializable;
import java.util.List;

public record LoginResponseDto(UserDto user, String token) implements Serializable {
    public record UserDto(long id, int version, String username, List<String> roles)
            implements Serializable {
    }
}
