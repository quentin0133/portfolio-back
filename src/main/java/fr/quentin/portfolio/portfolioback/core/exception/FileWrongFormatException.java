package fr.quentin.portfolio.portfolioback.core.exception;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type File wrong format exception.
 */
public class FileWrongFormatException extends RuntimeException {
    /**
     * Instantiates a new File wrong format exception.
     *
     * @param fileName the file name
     * @param fileType the file type
     */
    public FileWrongFormatException(String fileName, String... fileType) {
        super("The file '%s' has the wrong format, the next format are accepted : %s"
            .formatted(fileName, Arrays.stream(fileType).collect(Collectors.joining(", "))));
    }
}
