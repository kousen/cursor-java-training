package com.example.common.config;

import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Validation configuration.
 * Provides a Validator bean for programmatic validation.
 */
@Configuration
public class ValidationConfig {
    
    /**
     * Creates a Validator bean for programmatic validation.
     * Useful for service-layer validation.
     * 
     * @return Validator instance
     */
    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.afterPropertiesSet();
        return factory.getValidator();
    }
}

