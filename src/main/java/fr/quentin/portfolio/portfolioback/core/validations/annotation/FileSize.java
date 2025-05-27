package fr.quentin.portfolio.portfolioback.core.validations.annotation;

import fr.quentin.portfolio.portfolioback.core.validations.validators.FileTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The interface File size.
 */
@Documented
@Constraint(validatedBy = FileTypeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileSize {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "Invalid file size";

    /**
     * Max long.
     *
     * @return the long
     */
    long max() default 10 * 1024 * 1024; // 10 mo

    /**
     * Groups class [ ].
     *
     * @return the class [ ]
     */
    Class<?>[] groups() default {};

    /**
     * Payload class [ ].
     *
     * @return the class [ ]
     */
    Class<? extends Payload>[] payload() default {};
}