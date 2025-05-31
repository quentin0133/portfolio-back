package fr.quentin.portfolio.portfolioback.core.tools;

import fr.quentin.portfolio.portfolioback.files.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type File utils.
 */
public class FileUtils {
    private FileUtils() {
    }

    /**
     * Upload file.
     *
     * @param file the file
     * @return the file
     * @throws IOException the io exception
     */
    public static File upload(MultipartFile file, String pathFile) throws IOException {
        if (file == null) return null;

        String originalFileName = file.getOriginalFilename();
        String generatedFile = "%s-%s".formatted(UUID.randomUUID(), originalFileName);

        Path rootPath = Paths.get(pathFile);

        if (!Files.exists(rootPath)) {
            Files.createDirectories(rootPath);
            System.out.println("Created a rootPath: " + rootPath);
        }

        Path destinationFile = rootPath.resolve(generatedFile);
        Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

        return new File(originalFileName, generatedFile);
    }

    /**
     * Upload list.
     *
     * @param files the files
     * @return the list
     * @throws IOException the io exception
     */
    public static List<File> upload(List<MultipartFile> files, String pathFile) throws IOException {
        if (files == null || files.isEmpty()) return new ArrayList<>();

        List<File> listFiles = new ArrayList<>();
        for (MultipartFile file : files)
            listFiles.add(upload(file, pathFile));
        return listFiles;
    }

    /**
     * Delete.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public static void delete(File file, String filePath) throws IOException {
        if (file == null) return;

        Path path = Paths.get(filePath).resolve(file.getStoredFileName()).normalize();

        if (!Files.exists(path))
            throw new FileNotFoundException("File not found: " + path);

        Files.delete(path);
    }

    /**
     * Delete.
     *
     * @param files the files
     * @throws IOException the io exception
     */
    public static void delete(List<File> files, String pathFile) throws IOException {
        for (File file : files) {
            delete(file, pathFile);
        }
    }
}
