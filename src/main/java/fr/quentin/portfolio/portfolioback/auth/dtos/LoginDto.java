package fr.quentin.portfolio.portfolioback.auth.dtos;

import java.io.Serializable;

public record LoginDto(String username, String password) implements Serializable {
}
