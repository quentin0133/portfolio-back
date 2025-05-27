package fr.quentin.portfolio.portfolioback.core.validations.annotation;

import fr.quentin.portfolio.portfolioback.core.validations.validators.FileNotEmptyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The interface File not empty.
 */
@Documented
@Constraint(validatedBy = FileNotEmptyValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FileNotEmpty {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "the file must not be empty";

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
