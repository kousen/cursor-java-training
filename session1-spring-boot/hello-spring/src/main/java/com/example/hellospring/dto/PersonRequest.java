package com.example.hellospring.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PersonRequest(
    @NotBlank(message = "First name is required")
    String firstName,
    
    @NotBlank(message = "Last name is required")
    String lastName,
    
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    String email
) {}

