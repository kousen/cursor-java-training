package com.example.hellospring.controller;

import com.example.hellospring.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonControllerIntegrationTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private PersonRepository personRepository;
    
    @BeforeEach
    void setUp() {
        personRepository.deleteAll();
    }
    
    @Test
    @Order(1)
    @DisplayName("Should create person with valid data")
    void shouldCreatePerson() throws Exception {
        String requestJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john@example.com"
            }
            """;
        
        mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.firstName").value("John"))
            .andExpect(jsonPath("$.lastName").value("Doe"))
            .andExpect(jsonPath("$.email").value("john@example.com"));
    }
    
    @Test
    @Order(2)
    @DisplayName("Should reject invalid email")
    void shouldRejectInvalidEmail() throws Exception {
        String requestJson = """
            {
                "firstName": "Jane",
                "lastName": "Doe",
                "email": "not-an-email"
            }
            """;
        
        mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors.email").exists());
    }
    
    @Test
    @Order(3)
    @DisplayName("Should reject empty firstName")
    void shouldRejectEmptyFirstName() throws Exception {
        String requestJson = """
            {
                "firstName": "",
                "lastName": "Doe",
                "email": "test@example.com"
            }
            """;
        
        mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.errors.firstName").exists());
    }
    
    @Test
    @Order(4)
    @DisplayName("Should get all persons")
    void shouldGetAllPersons() throws Exception {
        // Create a person first
        String requestJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john@example.com"
            }
            """;
        
        mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson));
        
        // Get all persons
        mockMvc.perform(get("/api/persons"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].firstName").value("John"));
    }
    
    @Test
    @Order(5)
    @DisplayName("Should update person by id")
    void shouldUpdatePersonById() throws Exception {
        // Create a person first
        String createJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john@example.com"
            }
            """;
        
        String result = mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createJson))
            .andReturn().getResponse().getContentAsString();
        
        Long id = objectMapper.readTree(result).get("id").asLong();
        
        // Update the person
        String updateJson = """
            {
                "firstName": "Jane",
                "lastName": "Doe",
                "email": "jane@example.com"
            }
            """;
        
        mockMvc.perform(put("/api/persons/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value("Jane"))
            .andExpect(jsonPath("$.email").value("jane@example.com"));
    }
    
    @Test
    @Order(6)
    @DisplayName("Should delete person by id")
    void shouldDeletePersonById() throws Exception {
        // Create a person first
        String createJson = """
            {
                "firstName": "John",
                "lastName": "Doe",
                "email": "john@example.com"
            }
            """;
        
        String result = mockMvc.perform(post("/api/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createJson))
            .andReturn().getResponse().getContentAsString();
        
        Long id = objectMapper.readTree(result).get("id").asLong();
        
        // Delete the person
        mockMvc.perform(delete("/api/persons/" + id))
            .andExpect(status().isNoContent());
        
        // Verify it's deleted
        mockMvc.perform(get("/api/persons/" + id))
            .andExpect(status().isNotFound());
    }
}

