package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for user management operations.
 * Provides endpoints for creating, retrieving, updating, and deleting users.
 * 
 * @author E-Commerce Team
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    
    private final UserService userService;

    /**
     * Constructs a new UserController with the given service.
     * 
     * @param userService The user service for business logic
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     * 
     * @param user The user entity to create (validated)
     * @return ResponseEntity with created user and HTTP 201 status
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        log.debug("POST /api/users - Creating new user with username: {}", user.getUsername());
        User createdUser = userService.createUser(user);
        log.info("User created successfully via API with ID: {}", createdUser.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Retrieves all users.
     * 
     * @return ResponseEntity with list of all users and HTTP 200 status
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        log.debug("GET /api/users - Retrieving all users");
        List<User> users = userService.getAllUsers();
        log.debug("Retrieved {} users via API", users.size());
        return ResponseEntity.ok(users);
    }

    /**
     * Retrieves a user by their unique ID.
     * 
     * @param id The user ID
     * @return ResponseEntity with user if found (HTTP 200), or HTTP 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable @Positive(message = "User ID must be positive") Long id) {
        log.debug("GET /api/users/{} - Retrieving user by ID", id);
        return userService.getUserById(id)
                .map(user -> {
                    log.debug("User found via API with ID: {}", id);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> {
                    log.debug("User not found via API with ID: {}", id);
                    return ResponseEntity.notFound().build();
                });
    }

    /**
     * Retrieves a user by their username.
     * 
     * @param username The username
     * @return ResponseEntity with user if found (HTTP 200), or HTTP 404 if not found
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable @NotBlank(message = "Username cannot be blank") String username) {
        log.debug("GET /api/users/username/{} - Retrieving user by username", username);
        return userService.getUserByUsername(username)
                .map(user -> {
                    log.debug("User found via API with username: {}", username);
                    return ResponseEntity.ok(user);
                })
                .orElseGet(() -> {
                    log.debug("User not found via API with username: {}", username);
                    return ResponseEntity.notFound().build();
                });
    }

    /**
     * Updates an existing user's profile information.
     * 
     * @param id The ID of the user to update
     * @param user User object containing updated fields (validated)
     * @return ResponseEntity with updated user (HTTP 200), or HTTP 404 if user not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable @Positive(message = "User ID must be positive") Long id, @Valid @RequestBody User user) {
        log.debug("PUT /api/users/{} - Updating user", id);
        try {
            User updatedUser = userService.updateUser(id, user);
            log.info("User updated successfully via API with ID: {}", id);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            log.warn("User update failed via API - user not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a user by their ID.
     * 
     * @param id The ID of the user to delete
     * @return ResponseEntity with HTTP 204 (No Content) if successful, or HTTP 404 if user not found
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @Positive(message = "User ID must be positive") Long id) {
        log.debug("DELETE /api/users/{} - Deleting user", id);
        try {
            userService.deleteUser(id);
            log.info("User deleted successfully via API with ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.warn("User deletion failed via API - user not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deactivates a user account.
     * 
     * @param id The ID of the user to deactivate
     * @return ResponseEntity with HTTP 204 (No Content) if successful, or HTTP 404 if user not found
     */
    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateUser(@PathVariable @Positive(message = "User ID must be positive") Long id) {
        log.debug("PATCH /api/users/{}/deactivate - Deactivating user", id);
        try {
            userService.deactivateUser(id);
            log.info("User deactivated successfully via API with ID: {}", id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            log.warn("User deactivation failed via API - user not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
