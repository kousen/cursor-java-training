package com.legacy.utils;

// Legacy utility class with issues:
// - Using double for currency calculations
// - No rounding strategies
// - Magic numbers
public class NumberUtil {

    // Using double for money - precision issues
    public static double calculateDiscount(double price, double discountPercent) {
        return price * (discountPercent / 100);
    }

    // No validation for negative numbers
    public static double calculateTotal(double price, int quantity) {
        return price * quantity; // Could overflow or give wrong results
    }

    // Using == for double comparison - bad practice
    public static boolean isZero(double value) {
        return value == 0.0;
    }

    // Magic numbers
    public static double calculateTax(double amount) {
        return amount * 0.08; // Magic number for tax rate
    }

    // No proper rounding
    public static double round(double value) {
        return (int) (value * 100) / 100.0; // Loses precision
    }

    // Inefficient
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1); // No memoization
    }

    // No validation
    public static double divide(double a, double b) {
        return a / b; // Division by zero not handled
    }
}
