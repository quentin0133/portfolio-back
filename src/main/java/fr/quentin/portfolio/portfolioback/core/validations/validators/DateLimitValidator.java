package fr.quentin.portfolio.portfolioback.core.validations.validators;

import fr.quentin.portfolio.portfolioback.core.validations.annotation.DateLimit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * The type Date limit validator.
 */
public class DateLimitValidator implements ConstraintValidator<DateLimit, LocalDate> {
    private LocalDate minDate = LocalDate.MIN;
    private LocalDate maxDate = LocalDate.MAX;

    @Override
    public void initialize(DateLimit constraintAnnotation) {
        if (!constraintAnnotation.min().isBlank() && constraintAnnotation.minOffset() != Integer.MIN_VALUE)
            throw new IllegalArgumentException("Invalid date validator, you can't assign both min and minOffset");
        if (!constraintAnnotation.max().isBlank() && constraintAnnotation.maxOffset() != Integer.MAX_VALUE)
            throw new IllegalArgumentException("Invalid date validator, you can't assign both max and maxOffset");

        if (constraintAnnotation.min().isBlank() && constraintAnnotation.minOffset() == Integer.MIN_VALUE)
            throw new IllegalArgumentException("Invalid date validator, you need to assign min or minOffset");
        if (constraintAnnotation.max().isBlank() && constraintAnnotation.maxOffset() == Integer.MAX_VALUE)
            throw new IllegalArgumentException("Invalid date validator, you need to assign max or maxOffset");

        String min = constraintAnnotation.min();
        if (!min.isBlank()) {
            try {
                minDate = LocalDate.parse(min);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for 'min'. Expected format is yyyy-MM-dd");
            }
        }

        String max = constraintAnnotation.max();
        if (!max.isBlank()) {
            try {
                maxDate = LocalDate.parse(max);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for 'max'. Expected format is yyyy-MM-dd");
            }
        }

        int minOffset = constraintAnnotation.minOffset();
        if (minOffset != Integer.MIN_VALUE)
            minDate = LocalDate.now().minusDays(minOffset);

        int maxOffset = constraintAnnotation.maxOffset();
        if (maxOffset != Integer.MAX_VALUE)
            maxDate = LocalDate.now().plusDays(maxOffset);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) return true;
        return !localDate.isBefore(minDate) && !localDate.isAfter(maxDate);
    }
}
