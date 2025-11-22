package com.example.user.controller;

import com.example.common.dto.ApiResponse;
import com.example.common.exception.GlobalExceptionHandler;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
@Import(GlobalExceptionHandler.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "test@example.com", "password123");
        testUser.setId(1L);
        testUser.setFirstName("Test");
        testUser.setLastName("User");
    }

    @Test
    void createUser_Success() throws Exception {
        when(userService.createUser(any(User.class))).thenReturn(testUser);

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.username").value("testuser"))
                .andExpect(jsonPath("$.data.email").value("test@example.com"))
                .andExpect(jsonPath("$.message").value("User created successfully"));

        verify(userService).createUser(any(User.class));
    }

    @Test
    void createUser_ValidationError() throws Exception {
        User invalidUser = new User(); // Missing required fields

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidUser)))
                .andExpect(status().isBadRequest());

        verify(userService, never()).createUser(any(User.class));
    }

    @Test
    void getAllUsers_Success() throws Exception {
        List<User> users = Arrays.asList(testUser);
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].id").value(1L));

        verify(userService).getAllUsers();
    }

    @Test
    void getUserById_Found() throws Exception {
        when(userService.getUserById(1L)).thenReturn(Optional.of(testUser));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(1L))
                .andExpect(jsonPath("$.data.username").value("testuser"));

        verify(userService).getUserById(1L);
    }

    @Test
    void getUserById_NotFound() throws Exception {
        when(userService.getUserById(999L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/999"))
                .andExpect(status().isNotFound());

        verify(userService).getUserById(999L);
    }

    @Test
    void getUserByUsername_Found() throws Exception {
        when(userService.getUserByUsername("testuser")).thenReturn(Optional.of(testUser));

        mockMvc.perform(get("/api/users/username/testuser"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.username").value("testuser"));

        verify(userService).getUserByUsername("testuser");
    }

    @Test
    void getUserByUsername_NotFound() throws Exception {
        when(userService.getUserByUsername("nonexistent")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/username/nonexistent"))
                .andExpect(status().isNotFound());

        verify(userService).getUserByUsername("nonexistent");
    }

    @Test
    void updateUser_Success() throws Exception {
        User updatedUser = new User();
        updatedUser.setFirstName("Updated");
        updatedUser.setLastName("Name");

        when(userService.updateUser(eq(1L), any(User.class))).thenReturn(testUser);

        mockMvc.perform(put("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("User updated successfully"));

        verify(userService).updateUser(eq(1L), any(User.class));
    }

    @Test
    void updateUser_NotFound() throws Exception {
        when(userService.updateUser(eq(999L), any(User.class)))
                .thenThrow(new com.example.common.exception.NotFoundException("User", 999L));

        mockMvc.perform(put("/api/users/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new User())))
                .andExpect(status().isNotFound());

        verify(userService).updateUser(eq(999L), any(User.class));
    }

    @Test
    void deleteUser_Success() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.message").value("User deleted successfully"));

        verify(userService).deleteUser(1L);
    }

    @Test
    void deleteUser_NotFound() throws Exception {
        doThrow(new com.example.common.exception.NotFoundException("User", 999L))
                .when(userService).deleteUser(999L);

        mockMvc.perform(delete("/api/users/999"))
                .andExpect(status().isNotFound());

        verify(userService).deleteUser(999L);
    }

    @Test
    void deactivateUser_Success() throws Exception {
        doNothing().when(userService).deactivateUser(1L);

        mockMvc.perform(patch("/api/users/1/deactivate"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$.message").value("User deactivated successfully"));

        verify(userService).deactivateUser(1L);
    }

    @Test
    void deactivateUser_NotFound() throws Exception {
        doThrow(new com.example.common.exception.NotFoundException("User", 999L))
                .when(userService).deactivateUser(999L);

        mockMvc.perform(patch("/api/users/999/deactivate"))
                .andExpect(status().isNotFound());

        verify(userService).deactivateUser(999L);
    }
}

