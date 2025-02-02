package fr.quentin.portfolio.portfolioback.core.enums;

import lombok.Getter;

@Getter
public enum ProjectStatus {
    IN_PROGRESS("En cours"),
    FINISHED("Terminé"),
    ON_BREAK("En pause"),
    ARCHIVED("Archivé");

    private final String description;

    ProjectStatus(String description) {
        this.description = description;
    }
}
