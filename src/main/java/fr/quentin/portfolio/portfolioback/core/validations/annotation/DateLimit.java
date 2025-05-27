package fr.quentin.portfolio.portfolioback.core.validations.annotation;

import fr.quentin.portfolio.portfolioback.core.validations.validators.DateLimitValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * The interface Date limit.
 */
@Documented
@Constraint(validatedBy = DateLimitValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateLimit {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "the date limit is invalid";

    /**
     * Min string.
     *
     * @return the string
     */
    String min() default "";

    /**
     * Max string.
     *
     * @return the string
     */
    String max() default "";

    /**
     * Max offset int.
     *
     * @return the int
     */
    int maxOffset() default Integer.MAX_VALUE;

    /**
     * Min offset int.
     *
     * @return the int
     */
    int minOffset() default Integer.MIN_VALUE;

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
