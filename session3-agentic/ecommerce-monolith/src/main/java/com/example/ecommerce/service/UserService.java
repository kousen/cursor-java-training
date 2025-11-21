package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service for managing user operations.
 * Handles user creation, retrieval, updates, deletion, and deactivation.
 * All operations are transactional.
 * 
 * @author E-Commerce Team
 * @since 1.0.0
 */
@Service
@Transactional
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    
    private final UserRepository userRepository;

    /**
     * Constructs a new UserService with the given repository.
     * 
     * @param userRepository The user repository for data access
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user after validating uniqueness of username and email.
     * 
     * @param user The user entity to create
     * @return The created user with generated ID
     * @throws IllegalArgumentException if username or email already exists
     */
    public User createUser(User user) {
        log.debug("Creating user with username: {}", user.getUsername());
        
        if (userRepository.existsByUsername(user.getUsername())) {
            log.warn("Attempted to create user with duplicate username: {}", user.getUsername());
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            log.warn("Attempted to create user with duplicate email: {}", user.getEmail());
            throw new IllegalArgumentException("Email already exists");
        }
        
        User createdUser = userRepository.save(user);
        log.info("User created successfully with ID: {} and username: {}", createdUser.getId(), createdUser.getUsername());
        return createdUser;
    }

    /**
     * Retrieves a user by their unique ID.
     * 
     * @param id The user ID
     * @return Optional containing the user if found, empty otherwise
     */
    public Optional<User> getUserById(Long id) {
        log.debug("Retrieving user by ID: {}", id);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            log.debug("User found with ID: {}", id);
        } else {
            log.debug("User not found with ID: {}", id);
        }
        return user;
    }

    /**
     * Retrieves a user by their unique username.
     * 
     * @param username The username
     * @return Optional containing the user if found, empty otherwise
     */
    public Optional<User> getUserByUsername(String username) {
        log.debug("Retrieving user by username: {}", username);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            log.debug("User found with username: {}", username);
        } else {
            log.debug("User not found with username: {}", username);
        }
        return user;
    }

    /**
     * Retrieves a user by their unique email address.
     * 
     * @param email The email address
     * @return Optional containing the user if found, empty otherwise
     */
    public Optional<User> getUserByEmail(String email) {
        log.debug("Retrieving user by email: {}", email);
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            log.debug("User found with email: {}", email);
        } else {
            log.debug("User not found with email: {}", email);
        }
        return user;
    }

    /**
     * Retrieves all users in the system.
     * 
     * @return List of all users
     */
    public List<User> getAllUsers() {
        log.debug("Retrieving all users");
        List<User> users = userRepository.findAll();
        log.info("Retrieved {} users", users.size());
        return users;
    }

    /**
     * Updates an existing user's profile information.
     * Only updates firstName, lastName, phone, and address fields.
     * Username, email, and password are not updated by this method.
     * 
     * @param id The ID of the user to update
     * @param updatedUser User object containing updated fields
     * @return The updated user entity
     * @throws IllegalArgumentException if user with given ID is not found
     */
    public User updateUser(Long id, User updatedUser) {
        log.debug("Updating user with ID: {}", id);
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Attempted to update non-existent user with ID: {}", id);
                    return new IllegalArgumentException("User not found");
                });

        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPhone(updatedUser.getPhone());
        user.setAddress(updatedUser.getAddress());

        User savedUser = userRepository.save(user);
        log.info("User updated successfully with ID: {}", id);
        return savedUser;
    }

    /**
     * Deletes a user by their ID.
     * 
     * @param id The ID of the user to delete
     * @throws IllegalArgumentException if user with given ID is not found
     */
    public void deleteUser(Long id) {
        log.debug("Deleting user with ID: {}", id);
        
        if (!userRepository.existsById(id)) {
            log.warn("Attempted to delete non-existent user with ID: {}", id);
            throw new IllegalArgumentException("User not found");
        }
        
        userRepository.deleteById(id);
        log.info("User deleted successfully with ID: {}", id);
    }

    /**
     * Deactivates a user account by setting the active flag to false.
     * The user record remains in the database but is marked as inactive.
     * 
     * @param id The ID of the user to deactivate
     * @throws IllegalArgumentException if user with given ID is not found
     */
    public void deactivateUser(Long id) {
        log.debug("Deactivating user with ID: {}", id);
        
        User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Attempted to deactivate non-existent user with ID: {}", id);
                    return new IllegalArgumentException("User not found");
                });
        
        user.setActive(false);
        userRepository.save(user);
        log.info("User deactivated successfully with ID: {}", id);
    }
}
