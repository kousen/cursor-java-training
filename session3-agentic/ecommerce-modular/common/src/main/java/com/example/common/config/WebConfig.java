package com.example.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web configuration for cross-cutting web concerns.
 * Provides CORS configuration and other web-related settings.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    /**
     * Configures CORS (Cross-Origin Resource Sharing).
     * Allows all origins, methods, and headers by default.
     * Individual modules can override this if needed.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}

