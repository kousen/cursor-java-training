package com.example.common.exception;

/**
 * Exception thrown when attempting to create a resource that already exists.
 * Used for unique constraint violations (e.g., duplicate username, email, SKU).
 */
public class DuplicateResourceException extends RuntimeException {
    
    private final String resource;
    private final String field;
    private final String value;
    
    public DuplicateResourceException(String resource, String field, String value) {
        super(String.format("%s with %s '%s' already exists", resource, field, value));
        this.resource = resource;
        this.field = field;
        this.value = value;
    }
    
    public DuplicateResourceException(String message) {
        super(message);
        this.resource = null;
        this.field = null;
        this.value = null;
    }
    
    public String getResource() {
        return resource;
    }
    
    public String getField() {
        return field;
    }
    
    public String getValue() {
        return value;
    }
}

