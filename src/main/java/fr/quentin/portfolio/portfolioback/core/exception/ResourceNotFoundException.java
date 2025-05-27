package fr.quentin.portfolio.portfolioback.core.exception;

/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Instantiates a new Resource not found exception.
     *
     * @param label the label
     * @param id    the id
     */
    public ResourceNotFoundException(String label, long id) {
        super("%s not found with id %d".formatted(label, id));
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param label the label
     * @param id    the id
     */
    public ResourceNotFoundException(String label, String id) {
        super("%s not found with id %s".formatted(label, id));
    }
}
