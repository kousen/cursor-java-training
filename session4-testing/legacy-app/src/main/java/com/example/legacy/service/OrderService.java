package com.example.legacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    // Field injection - code smell
    @Autowired
    private EmailService emailService;

    public void processOrder(String orderId, String userId, List<String> productIds) {
        // Legacy date handling
        Date now = new Date();
        System.out.println("Processing order " + orderId + " at " + now);

        double total = 0.0;
        for (String productId : productIds) {
            // Tight coupling and logic mixed with IO
            if (inventoryService.checkStock(productId)) {
                double price = inventoryService.getPrice(productId);
                total += price;
                inventoryService.decrementStock(productId);
            } else {
                throw new RuntimeException("Product out of stock: " + productId);
            }
        }

        // Hardcoded logic
        if (total > 1000) {
            System.out.println("Applying discount for big order");
            total = total * 0.9;
        }

        boolean paymentSuccess = paymentService.charge(userId, total);
        if (!paymentSuccess) {
            throw new RuntimeException("Payment failed");
        }

        // Side effect without return value
        emailService.sendConfirmation(userId, "Order " + orderId + " processed successfully");
    }

    // Static method dependency - hard to mock
    public static String generateOrderId() {
        return "ORD-" + System.currentTimeMillis();
    }
}
