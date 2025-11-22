package com.example.legacy.service;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    public boolean checkStock(String productId) {
        return true; // Dummy implementation
    }

    public double getPrice(String productId) {
        return 100.0; // Dummy implementation
    }

    public void decrementStock(String productId) {
        // Dummy implementation
    }
}

@Service
class PaymentService {
    public boolean charge(String userId, double amount) {
        return true; // Dummy implementation
    }
}

@Service
class EmailService {
    public void sendConfirmation(String userId, String message) {
        System.out.println("Sending email to " + userId + ": " + message);
    }
}
