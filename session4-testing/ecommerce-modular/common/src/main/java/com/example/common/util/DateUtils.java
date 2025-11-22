package com.example.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Utility class for date and time operations.
 * Provides helper methods for common date/time tasks.
 */
public final class DateUtils {
    
    private static final DateTimeFormatter ISO_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private DateUtils() {
        // Utility class - prevent instantiation
    }
    
    /**
     * Formats a LocalDateTime to ISO format string.
     * 
     * @param dateTime The LocalDateTime to format
     * @return Formatted string in ISO format, or null if input is null
     */
    public static String formatIso(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(ISO_FORMATTER) : null;
    }
    
    /**
     * Formats a LocalDateTime to display format (yyyy-MM-dd HH:mm:ss).
     * 
     * @param dateTime The LocalDateTime to format
     * @return Formatted string, or null if input is null
     */
    public static String formatDisplay(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DISPLAY_FORMATTER) : null;
    }
    
    /**
     * Calculates the difference in seconds between two LocalDateTime values.
     * 
     * @param start The start time
     * @param end The end time
     * @return Difference in seconds
     */
    public static long secondsBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            return 0;
        }
        return ChronoUnit.SECONDS.between(start, end);
    }
    
    /**
     * Calculates the difference in minutes between two LocalDateTime values.
     * 
     * @param start The start time
     * @param end The end time
     * @return Difference in minutes
     */
    public static long minutesBetween(LocalDateTime start, LocalDateTime end) {
        if (start == null || end == null) {
            return 0;
        }
        return ChronoUnit.MINUTES.between(start, end);
    }
    
    /**
     * Checks if a LocalDateTime is in the past.
     * 
     * @param dateTime The LocalDateTime to check
     * @return true if in the past, false otherwise
     */
    public static boolean isPast(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isBefore(LocalDateTime.now());
    }
    
    /**
     * Checks if a LocalDateTime is in the future.
     * 
     * @param dateTime The LocalDateTime to check
     * @return true if in the future, false otherwise
     */
    public static boolean isFuture(LocalDateTime dateTime) {
        return dateTime != null && dateTime.isAfter(LocalDateTime.now());
    }
}

