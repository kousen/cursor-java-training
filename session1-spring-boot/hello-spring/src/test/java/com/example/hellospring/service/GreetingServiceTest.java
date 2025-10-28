package com.example.hellospring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GreetingService Tests")
class GreetingServiceTest {
    
    private GreetingService greetingService;
    
    @BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }
    
    @Test
    @DisplayName("Should create greeting with provided name")
    void shouldCreateGreetingWithName() {
        String result = greetingService.createGreeting("Alice");
        
        assertThat(result)
            .isNotNull()
            .contains("Alice")
            .startsWith("Hello");
    }
    
    @Test
    @DisplayName("Should create formal greeting with provided name")
    void shouldCreateFormalGreetingWithName() {
        String result = greetingService.createFormalGreeting("Alice");
        
        assertThat(result)
            .isNotNull()
            .contains("Alice")
            .contains("Good day");
    }
    
    @Test
    @DisplayName("Should handle empty name")
    void shouldHandleEmptyName() {
        String result = greetingService.createGreeting("");
        assertThat(result).isNotNull();
        
        String formalResult = greetingService.createFormalGreeting("");
        assertThat(formalResult).isNotNull();
    }
    
    @Test
    @DisplayName("Should handle null name")
    void shouldHandleNullName() {
        String result = greetingService.createGreeting(null);
        assertThat(result).isNotNull();
        
        String formalResult = greetingService.createFormalGreeting(null);
        assertThat(formalResult).isNotNull();
    }
    
    @Test
    @DisplayName("Should handle special characters in name")
    void shouldHandleSpecialCharactersInName() {
        String result = greetingService.createGreeting("O'Brien");
        assertThat(result).contains("O'Brien");
    }
}

