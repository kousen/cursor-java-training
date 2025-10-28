package com.example.hellospring.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    
    public String createGreeting(String name) {
        return String.format("Hello, %s! Welcome to Spring Boot with Cursor.", name);
    }
    
    public String createFormalGreeting(String name) {
        return String.format("Good day, %s. It's a pleasure to meet you.", name);
    }
}

