package fr.quentin.portfolio.portfolioback.core.exception;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FileWrongFormatException extends RuntimeException {
    public FileWrongFormatException(String fileName, String... fileType) {
        super("The file '%s' has the wrong format, the next format are accepted : %s"
            .formatted(fileName, Arrays.stream(fileType).collect(Collectors.joining(", "))));
    }
}
