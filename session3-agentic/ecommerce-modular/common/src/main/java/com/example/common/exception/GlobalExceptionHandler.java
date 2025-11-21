package com.example.common.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;

/**
 * Global exception handler for consistent error responses across all REST controllers.
 * Uses RFC 7807 Problem Details for HTTP APIs standard.
 * 
 * @RestControllerAdvice is preferred over @ControllerAdvice for REST APIs because:
 * - It includes @ResponseBody by default, automatically serializing responses to JSON
 * - More concise and appropriate for RESTful services
 * - Eliminates need to wrap responses in ResponseEntity for JSON serialization
 * 
 * ProblemDetails (RFC 7807) is preferred over custom DTOs because:
 * - Standard format recognized by HTTP clients and tooling
 * - Built-in Spring Boot support (Spring Boot 3.1+)
 * - Consistent structure: type, title, status, detail, instance
 * - Better integration with API documentation tools
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFound(NotFoundException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND, ex.getMessage()
        );
        problemDetail.setTitle("Resource Not Found");
        problemDetail.setProperty("resource", ex.getResource());
        problemDetail.setProperty("id", ex.getId());
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(DuplicateResourceException.class)
    public ProblemDetail handleDuplicateResource(DuplicateResourceException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.CONFLICT, ex.getMessage()
        );
        problemDetail.setTitle("Duplicate Resource");
        problemDetail.setProperty("resource", ex.getResource());
        problemDetail.setProperty("field", ex.getField());
        problemDetail.setProperty("value", ex.getValue());
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        problemDetail.setTitle("Invalid Argument");
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(IllegalStateException.class)
    public ProblemDetail handleIllegalState(IllegalStateException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        problemDetail.setTitle("Invalid State");
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, "Validation failed"
        );
        problemDetail.setTitle("Validation Error");
        
        // Add field-specific errors as custom properties
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            problemDetail.setProperty(
                error.getField(),
                error.getDefaultMessage()
            );
        });
        
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ProblemDetail handleConstraintViolation(
            ConstraintViolationException ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        problemDetail.setTitle("Constraint Violation");
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericException(Exception ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "An unexpected error occurred: " + ex.getMessage()
        );
        problemDetail.setTitle("Internal Server Error");
        problemDetail.setInstance(URI.create(getPath(request)));
        return problemDetail;
    }
    
    private String getPath(WebRequest request) {
        String description = request.getDescription(false);
        return description.replace("uri=", "");
    }
}

