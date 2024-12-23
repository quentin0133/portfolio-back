package fr.quentin.portfolio.portfolioback.core.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String label, long id) {
        super("%s not found with id %d".formatted(label, id));
    }
}
