package fr.quentin.portfolio.portfolioback.files;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class FileMapper {

    public static File mapMultipartFileToByteArray(MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                return new File(file.getBytes(), file.getName(), file.getContentType());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error encoding file in Base64", e);
        }
        return null;
    }

    public static List<File> mapMultipartFileToByteArray(List<MultipartFile> files) {
        try {
            List<File> fileList = new ArrayList<>();
            for (MultipartFile file : files) {
                if (file != null && !file.isEmpty()) {
                    fileList.add(new File(file.getBytes(), file.getName(), file.getContentType()));
                }
            }
            return fileList;
        } catch (Exception e) {
            throw new RuntimeException("Error encoding file in Base64", e);
        }
    }

    public static String mapByteArrayToBase64(byte[] file) {
        try {
            if (file != null) {
                return Base64.getEncoder().encodeToString(file);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error encoding file in Base64", e);
        }
        return null;
    }
}
