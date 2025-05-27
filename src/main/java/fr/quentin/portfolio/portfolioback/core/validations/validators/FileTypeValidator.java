package fr.quentin.portfolio.portfolioback.core.validations.validators;

import fr.quentin.portfolio.portfolioback.core.tools.ValidationUtils;
import fr.quentin.portfolio.portfolioback.core.validations.annotation.FileType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type File type validator.
 */
public class FileTypeValidator implements ConstraintValidator<FileType, MultipartFile> {
    private String[] fileTypes;

    @Override
    public void initialize(FileType constraintAnnotation) {
        this.fileTypes = constraintAnnotation.fileTypes();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context
            .buildConstraintViolationWithTemplate("the file type is not valid, accepted files : %s"
                .formatted(Arrays.stream(fileTypes).collect(Collectors.joining(", "))))
            .addConstraintViolation();
        return ValidationUtils.checkFileType(file, fileTypes);
    }
}