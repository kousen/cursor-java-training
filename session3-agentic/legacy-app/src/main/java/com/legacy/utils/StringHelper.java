package com.legacy.utils;

import java.util.Date;

// Legacy utility class with issues:
// - Static methods everywhere (hard to test)
// - Poor naming
// - Deprecated API usage
// - No proper error handling
public class StringHelper {

    // Using deprecated Date API
    public static String formatDate(Date date) {
        return date.toString(); // Poor formatting
    }

    // SQL injection vulnerability
    public static String buildQuery(String table, String condition) {
        return "SELECT * FROM " + table + " WHERE " + condition;
    }

    // No validation
    public static String sanitize(String input) {
        // Incomplete sanitization - security issue
        return input.replace("'", "''");
    }

    // Magic number
    public static String truncate(String str) {
        if (str.length() > 50) { // Magic number
            return str.substring(0, 50) + "...";
        }
        return str;
    }

    // Poor naming
    public static String doSomething(String s1, String s2) {
        return s1 + " - " + s2;
    }

    // No null checks
    public static boolean isEmpty(String str) {
        return str.length() == 0; // NullPointerException risk
    }

    // Inefficient string concatenation
    public static String buildString(String[] parts) {
        String result = "";
        for (String part : parts) {
            result = result + part + ", ";
        }
        return result;
    }
}
