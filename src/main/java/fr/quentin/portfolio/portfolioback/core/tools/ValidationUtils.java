package fr.quentin.portfolio.portfolioback.core.tools;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Utility class for performing common data validation operations across the application.
 * <p>
 * This class provides reusable static methods to validate inputs
 * </p>
 *
 * <p>
 * Intended for use in service layer where input validation is required
 * before further processing.
 * </p>
 *
 * @author Quentin YAHIA
 * @since 1.0
 */
public class ValidationUtils {
    private ValidationUtils() {
    }

    /**
     * Checks for duplicate entities based on a unique name constraint.
     *
     * This utility method helps enforce uniqueness on a given name field
     * by querying the data store for existing entities with the same name.
     * If an entity with the same name exists and does not match the current id,
     * a {@link DuplicateKeyException} is thrown.
     *
     * @param name          The name to check for uniqueness.
     * @param currentId     The ID of the current entity (used to ignore self when updating).
     * @param finderByName  A function that returns a list of matching entities for a given name.
     * @param idExtractor   A function that extracts the ID from an entity.
     * @param <T>           The type of the entity.
     * @param <I>           The type of the entity ID.
     *
     * @throws DuplicateKeyException if a duplicate name is found with a different ID.
     */
    public static <T, I> void checkDuplicateByName(
        String name,
        I currentId,
        Function<String, List<T>> finderByName,
        Function<T, I> idExtractor
    ) {
        List<T> results = finderByName.apply(name);
        if (!results.isEmpty() && (results.size() > 1 || !idExtractor.apply(results.get(0)).equals(currentId))) {
            throw new DuplicateKeyException(name);
        }
    }

    /**
     * Validates that all provided files have a content type matching at least one of the accepted types.
     * Wildcards (*) are supported in accepted types (e.g., "image/*", "application/pdf").
     *
     * @param files             The list of {@link MultipartFile} to validate.
     * @param acceptedFileTypes The list of accepted MIME type patterns.
     * @return true if all files match at least one accepted type, otherwise false.
     */
    public static boolean checkFilesType(List<MultipartFile> files, List<String> acceptedFileTypes) {
        if (files.isEmpty()) return false;

        List<Pattern> regexPatterns = getPatterns(acceptedFileTypes);

        // Each input must match at least one pattern
        return files.stream().allMatch(file ->
            regexPatterns.stream().anyMatch(p -> {
                String contentType = file.getContentType();
                if (contentType == null)
                    return false;
                return p.matcher(contentType).matches();
            })
        );
    }

    /**
     * Validates that a single file's content type matches at least one of the accepted types.
     * Wildcards (*) are supported in accepted types (e.g., "image/*").
     *
     * @param file              The {@link MultipartFile} to validate.
     * @param acceptedFileTypes A vararg of accepted MIME type patterns.
     * @return true if the file matches at least one accepted type, otherwise false.
     */
    public static boolean checkFileType(MultipartFile file, String ...acceptedFileTypes) {
        if (file == null || file.getContentType() == null)
            return false;

        List<Pattern> regexPatterns = getPatterns(acceptedFileTypes);
        return regexPatterns.stream().anyMatch(p -> p.matcher(file.getContentType()).matches());
    }

    /**
     * Converts a list of accepted MIME type patterns into compiled {@link Pattern} objects.
     * Supports '*' as a wildcard. All other characters are escaped for literal matching.
     *
     * @param acceptedFileTypes The list of accepted MIME type patterns.
     * @return A list of compiled regex patterns.
     */
    private static List<Pattern> getPatterns(List<String> acceptedFileTypes) {
        List<Pattern> regexPatterns = new ArrayList<>();
        for (String acceptedFileType : acceptedFileTypes) {
            String pattern = acceptedFileType.trim();

            // Escape regex special chars except '*'
            String escaped = Pattern.quote(pattern).replace("\\*", ".*");
            Pattern compiled = Pattern.compile("^" + escaped + "$");
            regexPatterns.add(compiled);
        }
        return regexPatterns;
    }

    /**
     * Overloaded version of {@link #getPatterns(List)} that accepts an array of strings.
     *
     * @param acceptedFileTypes An array of accepted MIME type patterns.
     * @return A list of compiled regex patterns.
     */
    private static List<Pattern> getPatterns(String[] acceptedFileTypes) {
        return getPatterns(Arrays.stream(acceptedFileTypes).toList());
    }
}
