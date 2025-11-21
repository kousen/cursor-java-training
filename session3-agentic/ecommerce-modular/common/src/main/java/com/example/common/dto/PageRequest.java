package com.example.common.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

/**
 * Pagination request DTO for list endpoints.
 * Provides standard pagination parameters.
 */
public record PageRequest(
    @Min(0) int page,
    @Min(1) @Max(100) int size,
    String sortBy,
    String sortDirection
) {
    /**
     * Creates a PageRequest with default values.
     * 
     * @return PageRequest with page=0, size=20, no sorting
     */
    public static PageRequest defaults() {
        return new PageRequest(0, 20, null, null);
    }
    
    /**
     * Creates a PageRequest with custom page and size.
     * 
     * @param page Page number (0-indexed)
     * @param size Page size
     * @return PageRequest instance
     */
    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size, null, null);
    }
    
    /**
     * Creates a PageRequest with sorting.
     * 
     * @param page Page number (0-indexed)
     * @param size Page size
     * @param sortBy Field to sort by
     * @param sortDirection "asc" or "desc"
     * @return PageRequest instance
     */
    public static PageRequest of(int page, int size, String sortBy, String sortDirection) {
        return new PageRequest(page, size, sortBy, sortDirection);
    }
    
    /**
     * Returns the sort direction as a boolean for use with Spring Data.
     * 
     * @return true for ascending, false for descending (defaults to ascending)
     */
    public boolean isAscending() {
        return sortDirection == null || !sortDirection.equalsIgnoreCase("desc");
    }
}

