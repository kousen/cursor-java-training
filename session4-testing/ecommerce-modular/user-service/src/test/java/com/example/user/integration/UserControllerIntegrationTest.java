package com.example.user.integration;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "spring.datasource.url=jdbc:h2:mem:testdb"
})
@Transactional
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void createUser_WithValidData_ReturnsCreated() throws Exception {
        User newUser = new User("newuser", "newuser@example.com", "password123");
        newUser.setFirstName("New");
        newUser.setLastName("User");

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.username").value("newuser"))
                .andExpect(jsonPath("$.data.email").value("newuser@example.com"))
                .andExpect(jsonPath("$.data.active").value(true))
                .andExpect(jsonPath("$.message").value("User created successfully"));
    }

    @Test
    void createUser_WithInvalidData_ReturnsBadRequest() throws Exception {
        User invalidUser = new User(); // Missing required fields

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidUser)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getUserById_ExistingUser_ReturnsUser() throws Exception {
        User savedUser = userRepository.save(createTestUser());

        mockMvc.perform(get("/api/users/{id}", savedUser.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(savedUser.getId()))
                .andExpect(jsonPath("$.data.username").value("testuser"));
    }

    @Test
    void getUserById_NonExistentUser_ReturnsNotFound() throws Exception {
        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateUser_ExistingUser_ReturnsUpdatedUser() throws Exception {
        User savedUser = userRepository.save(createTestUser());
        
        User updateData = new User();
        updateData.setFirstName("Updated");
        updateData.setLastName("Name");

        mockMvc.perform(put("/api/users/{id}", savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateData)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.firstName").value("Updated"))
                .andExpect(jsonPath("$.data.lastName").value("Name"))
                .andExpect(jsonPath("$.message").value("User updated successfully"));
    }

    @Test
    void deleteUser_ExistingUser_ReturnsNoContent() throws Exception {
        User savedUser = userRepository.save(createTestUser());

        mockMvc.perform(delete("/api/users/{id}", savedUser.getId()))
                .andExpect(status().isNoContent());

        // Verify user is deleted
        assertFalse(userRepository.existsById(savedUser.getId()));
    }

    @Test
    void deactivateUser_ExistingUser_ReturnsNoContent() throws Exception {
        User savedUser = userRepository.save(createTestUser());

        mockMvc.perform(patch("/api/users/{id}/deactivate", savedUser.getId()))
                .andExpect(status().isNoContent());

        // Verify user is deactivated
        User updatedUser = userRepository.findById(savedUser.getId()).orElseThrow();
        assertFalse(updatedUser.getActive());
    }

    private User createTestUser() {
        User user = new User("testuser", "test@example.com", "password123");
        user.setFirstName("Test");
        user.setLastName("User");
        return user;
    }
}

