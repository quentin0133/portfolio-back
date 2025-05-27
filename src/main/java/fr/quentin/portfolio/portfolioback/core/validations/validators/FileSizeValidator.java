package fr.quentin.portfolio.portfolioback.core.validations.validators;

import fr.quentin.portfolio.portfolioback.core.validations.annotation.FileSize;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

/**
 * The type File size validator.
 */
public class FileSizeValidator implements ConstraintValidator<FileSize, MultipartFile> {
    /**
     * The Max.
     */
    long max;

    @Override
    public void initialize(FileSize constraintAnnotation) {
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("the file size is too heavy, max : %d".formatted(max))
            .addConstraintViolation();
        return multipartFile.getSize() < max;
    }
}
