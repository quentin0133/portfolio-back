package fr.quentin.portfolio.portfolioback.core.validations.annotation;

import fr.quentin.portfolio.portfolioback.core.validations.validators.FileTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The interface File type.
 */
@Documented
@Constraint(validatedBy = FileTypeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileType {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "Invalid file type";

    /**
     * File types string [ ].
     *
     * @return the string [ ]
     */
    String[] fileTypes();

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

