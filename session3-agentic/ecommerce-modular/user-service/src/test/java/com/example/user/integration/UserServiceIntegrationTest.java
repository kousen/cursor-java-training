package com.example.user.integration;

import com.example.common.exception.DuplicateResourceException;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(UserService.class)
@TestPropertySource(properties = {
    "spring.jpa.hibernate.ddl-auto=create-drop",
    "spring.datasource.url=jdbc:h2:mem:testdb"
})
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        testUser = new User("testuser", "test@example.com", "password123");
        testUser.setFirstName("Test");
        testUser.setLastName("User");
    }

    @Test
    void createUser_WithValidData_SavesToDatabase() {
        User savedUser = userService.createUser(testUser);

        assertNotNull(savedUser.getId());
        assertEquals("testuser", savedUser.getUsername());
        assertEquals("test@example.com", savedUser.getEmail());
        
        Optional<User> found = userRepository.findById(savedUser.getId());
        assertTrue(found.isPresent());
    }

    @Test
    void createUser_DuplicateUsername_ThrowsException() {
        userService.createUser(testUser);

        User duplicateUser = new User("testuser", "different@example.com", "password");
        
        DuplicateResourceException exception = assertThrows(
            DuplicateResourceException.class,
            () -> userService.createUser(duplicateUser)
        );
        
        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("username"));
    }

    @Test
    void createUser_DuplicateEmail_ThrowsException() {
        userService.createUser(testUser);

        User duplicateUser = new User("differentuser", "test@example.com", "password");
        
        DuplicateResourceException exception = assertThrows(
            DuplicateResourceException.class,
            () -> userService.createUser(duplicateUser)
        );
        
        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("email"));
    }

    @Test
    void updateUser_UpdatesFields() {
        User savedUser = userService.createUser(testUser);
        
        User updateData = new User();
        updateData.setFirstName("Updated");
        updateData.setLastName("Name");
        updateData.setPhone("123-456-7890");
        updateData.setAddress("123 Main St");

        User updatedUser = userService.updateUser(savedUser.getId(), updateData);

        assertEquals("Updated", updatedUser.getFirstName());
        assertEquals("Name", updatedUser.getLastName());
        assertEquals("123-456-7890", updatedUser.getPhone());
        assertEquals("123 Main St", updatedUser.getAddress());
        
        // Verify username and email are not changed
        assertEquals("testuser", updatedUser.getUsername());
        assertEquals("test@example.com", updatedUser.getEmail());
    }

    @Test
    void deactivateUser_SetsActiveToFalse() {
        User savedUser = userService.createUser(testUser);
        assertTrue(savedUser.getActive());

        userService.deactivateUser(savedUser.getId());

        Optional<User> found = userRepository.findById(savedUser.getId());
        assertTrue(found.isPresent());
        assertFalse(found.get().getActive());
    }

    @Test
    void deleteUser_RemovesFromDatabase() {
        User savedUser = userService.createUser(testUser);
        Long userId = savedUser.getId();

        userService.deleteUser(userId);

        Optional<User> found = userRepository.findById(userId);
        assertFalse(found.isPresent());
    }

    @Test
    void getUserByUsername_FindsCorrectUser() {
        userService.createUser(testUser);

        Optional<User> found = userService.getUserByUsername("testuser");

        assertTrue(found.isPresent());
        assertEquals("testuser", found.get().getUsername());
    }

    @Test
    void getUserByEmail_FindsCorrectUser() {
        userService.createUser(testUser);

        Optional<User> found = userService.getUserByEmail("test@example.com");

        assertTrue(found.isPresent());
        assertEquals("test@example.com", found.get().getEmail());
    }
}

