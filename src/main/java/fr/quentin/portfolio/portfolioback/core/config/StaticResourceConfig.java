package fr.quentin.portfolio.portfolioback.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type Static resource config.
 */
@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {
    @Value("${file.storage.path}")
    private String uploadDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("%s/**".formatted(uploadDir))
            .addResourceLocations("file:%s/".formatted(uploadDir));
    }
}
