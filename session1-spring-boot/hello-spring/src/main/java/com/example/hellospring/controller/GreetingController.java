package com.example.hellospring.controller;

import com.example.hellospring.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greetings")
public class GreetingController {
    
    private final GreetingService greetingService;
    
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    
    @GetMapping
    public GreetingResponse greet(
            @RequestParam(defaultValue = "World") String name) {
        String message = greetingService.createGreeting(name);
        return new GreetingResponse(message);
    }
    
    @GetMapping("/formal")
    public GreetingResponse greetFormal(
            @RequestParam(defaultValue = "World") String name) {
        String message = greetingService.createFormalGreeting(name);
        return new GreetingResponse(message);
    }
    
    public record GreetingResponse(String message) {}
}

