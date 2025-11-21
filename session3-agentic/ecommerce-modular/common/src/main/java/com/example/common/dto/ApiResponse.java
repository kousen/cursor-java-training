package com.example.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

/**
 * Standard API response wrapper for successful responses.
 * Provides consistent response structure across all modules.
 * 
 * @param <T> The type of data being returned
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
    T data,
    String message,
    LocalDateTime timestamp
) {
    /**
     * Creates a successful API response with data.
     * 
     * @param data The response data
     * @return ApiResponse instance
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, null, LocalDateTime.now());
    }
    
    /**
     * Creates a successful API response with data and message.
     * 
     * @param data The response data
     * @param message Optional message
     * @return ApiResponse instance
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(data, message, LocalDateTime.now());
    }
    
    /**
     * Creates a message-only API response (no data).
     * 
     * @param message The message
     * @return ApiResponse instance
     */
    public static <T> ApiResponse<T> message(String message) {
        return new ApiResponse<>(null, message, LocalDateTime.now());
    }
}

