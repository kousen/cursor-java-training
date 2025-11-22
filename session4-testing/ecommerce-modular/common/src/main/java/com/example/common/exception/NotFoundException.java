package com.example.common.exception;

/**
 * Exception thrown when a requested resource is not found.
 * Used across all service modules for consistent error handling.
 */
public class NotFoundException extends RuntimeException {
    
    private final String resource;
    private final Long id;
    
    public NotFoundException(String resource, Long id) {
        super(String.format("%s with id %d not found", resource, id));
        this.resource = resource;
        this.id = id;
    }
    
    public NotFoundException(String message) {
        super(message);
        this.resource = null;
        this.id = null;
    }
    
    public String getResource() {
        return resource;
    }
    
    public Long getId() {
        return id;
    }
}

