package fr.quentin.portfolio.portfolioback.tags;

/**
 * The type Resource constraint violation exception.
 */
public class ResourceConstraintViolationException extends RuntimeException {
    /**
     * Instantiates a new Resource constraint violation exception.
     *
     * @param resource1 the resource 1
     * @param resource2 the resource 2
     * @param id        the id
     */
    public ResourceConstraintViolationException(String resource1, String resource2, long id) {
        super("Unable to delete " + resource1 + " n° " + id + " : it is used by " + resource2);
    }
}
