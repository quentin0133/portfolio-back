package fr.quentin.portfolio.portfolioback.core.enums;

import lombok.Getter;

/**
 * The enum Project status.
 */
@Getter
public enum ProjectStatus {
    /**
     * In progress project status.
     */
    IN_PROGRESS,
    /**
     * Maintained project status.
     */
    MAINTAINED,
    /**
     * Archived project status.
     */
    ARCHIVED,
    /**
     * Cancelled project status.
     */
    CANCELLED
}
