package com.example.common.dto;

import java.util.List;

/**
 * Paginated response DTO.
 * Wraps a list of items with pagination metadata.
 * 
 * @param <T> The type of items in the page
 */
public record PageResponse<T>(
    List<T> content,
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
    /**
     * Creates a PageResponse from Spring Data Page.
     * 
     * @param content The page content
     * @param page Current page number (0-indexed)
     * @param size Page size
     * @param totalElements Total number of elements
     * @return PageResponse instance
     */
    public static <T> PageResponse<T> of(List<T> content, int page, int size, long totalElements) {
        int totalPages = (int) Math.ceil((double) totalElements / size);
        return new PageResponse<>(
            content,
            page,
            size,
            totalElements,
            totalPages,
            page < totalPages - 1,
            page > 0
        );
    }
    
    /**
     * Creates an empty PageResponse.
     * 
     * @param page Current page number
     * @param size Page size
     * @return Empty PageResponse
     */
    public static <T> PageResponse<T> empty(int page, int size) {
        return new PageResponse<>(
            List.of(),
            page,
            size,
            0,
            0,
            false,
            false
        );
    }
}

