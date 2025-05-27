package fr.quentin.portfolio.portfolioback.core.exception;

import fr.quentin.portfolio.portfolioback.tags.ResourceConstraintViolationException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.security.SignatureException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * Handle messaging exception response entity.
     *
     * @param me the me
     * @return the response entity
     */
    @ExceptionHandler(MessagingException.class)
    protected ResponseEntity<Object> handleMessagingException(MessagingException me) {
        if (me.getMessage().contains("Daily user sending quota exceeded") || me.getMessage().contains("rate limit exceeded"))
            return getResponseEntity(me, HttpStatus.TOO_MANY_REQUESTS);
        return getResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle bad request exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({DuplicateKeyException.class, ResourceConstraintViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<Object> handleBadRequestExceptions(Exception ex) {
        return getResponseEntity(ex, HttpStatus.CONFLICT);
    }

    /**
     * Handle not found exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({ResourceNotFoundException.class, NoResourceFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseEntity<Object> handleNotFoundExceptions(Exception ex) {
        return getResponseEntity(ex, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle forbidden exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({AuthenticationException.class, SignatureException.class})
    protected ResponseEntity<Object> handleForbiddenException(Exception ex) {
        return getResponseEntity(ex, HttpStatus.FORBIDDEN);
    }

    /**
     * Handle generic exceptions response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleGenericExceptions(Exception ex) {
        return getResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> getResponseEntity(Exception ex, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("errors", status.value());
        body.put("status", ex.getMessage());

        log.error(ex.toString());
        Arrays.stream(ex.getStackTrace()).forEach(stackTrace -> log.error(stackTrace.toString()));

        return new ResponseEntity<>(body, status);
    }

    private ResponseEntity<Object> getResponseEntity(String message, HttpStatus status) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("errors", status.value());
        body.put("status", message);

        return new ResponseEntity<>(body, status);
    }

    /**
     * Handle binding response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity<Object> handleBinding(BindException ex) {
        log.error(ex.toString());
        Arrays.stream(ex.getStackTrace()).forEach(stackTrace -> log.error(stackTrace.toString()));

        String error = ex.getBindingResult().getFieldErrors().stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .collect(Collectors.joining(", "));

        return getResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
