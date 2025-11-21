package com.example.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Jackson JSON serialization configuration.
 * Ensures consistent JSON serialization across all modules.
 */
@Configuration
public class JacksonConfig {
    
    /**
     * Configures ObjectMapper with:
     * - Java 8 Time module support (LocalDateTime, etc.)
     * - Pretty printing disabled (for production)
     * - ISO date/time formatting
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        return builder
                .modules(new JavaTimeModule())
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .featuresToDisable(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS)
                .build();
    }
}

