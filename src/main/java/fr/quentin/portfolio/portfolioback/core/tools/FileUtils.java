package fr.quentin.portfolio.portfolioback.core.tools;

import fr.quentin.portfolio.portfolioback.files.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUtils {
    private static final Path rootLocation = Paths.get("files");

    public static File upload(MultipartFile file) throws IOException {
        if (file == null) return null;

        String pathFile = "%s-%s".formatted(UUID.randomUUID(), file.getOriginalFilename());
        Path destinationFile = rootLocation.resolve(pathFile).normalize().toAbsolutePath();
        Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
        return new File(file.getOriginalFilename(), pathFile);
    }

    public static List<File> upload(List<MultipartFile> files) throws IOException {
        if (files == null || files.isEmpty()) return new ArrayList<>();

        List<File> listFiles = new ArrayList<>();
        for (MultipartFile file : files)
            listFiles.add(upload(file));
        return listFiles;
    }

    public static void delete(File file) throws IOException {
        System.out.println(file);
        Files.deleteIfExists(rootLocation.resolve(file.getStoredFileName()));
    }

    public static void delete(List<File> files) throws IOException {
        for (File file : files) {
            Files.deleteIfExists(rootLocation.resolve(file.getStoredFileName()));
        }
    }
}
