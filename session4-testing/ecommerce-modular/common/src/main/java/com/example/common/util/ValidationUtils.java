package com.example.common.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility class for validation operations.
 * Provides helper methods for common validation tasks.
 */
public final class ValidationUtils {
    
    private ValidationUtils() {
        // Utility class - prevent instantiation
    }
    
    /**
     * Validates an object and returns a set of violation messages.
     * 
     * @param validator The Jakarta Validation validator
     * @param object The object to validate
     * @return Set of violation messages, empty if valid
     */
    public static Set<String> getViolationMessages(Validator validator, Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        return violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
    }
    
    /**
     * Checks if an object is valid according to Jakarta Validation constraints.
     * 
     * @param validator The Jakarta Validation validator
     * @param object The object to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValid(Validator validator, Object object) {
        return validator.validate(object).isEmpty();
    }
    
    /**
     * Validates an object and throws IllegalArgumentException if invalid.
     * 
     * @param validator The Jakarta Validation validator
     * @param object The object to validate
     * @throws IllegalArgumentException if validation fails
     */
    public static void validateOrThrow(Validator validator, Object object) {
        Set<String> violations = getViolationMessages(validator, object);
        if (!violations.isEmpty()) {
            String message = String.join("; ", violations);
            throw new IllegalArgumentException("Validation failed: " + message);
        }
    }
}

