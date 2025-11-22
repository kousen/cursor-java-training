package com.example.user.service;

import com.example.common.exception.DuplicateResourceException;
import com.example.common.exception.NotFoundException;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "test@example.com", "password123");
        testUser.setId(1L);
        testUser.setFirstName("Test");
        testUser.setLastName("User");
    }

    @Test
    void createUser_Success() {
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User result = userService.createUser(testUser);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(userRepository).existsByUsername("testuser");
        verify(userRepository).existsByEmail("test@example.com");
        verify(userRepository).save(testUser);
    }

    @Test
    void createUser_DuplicateUsername() {
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        DuplicateResourceException exception = assertThrows(
            DuplicateResourceException.class,
            () -> userService.createUser(testUser)
        );

        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("username"));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void createUser_DuplicateEmail() {
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(true);

        DuplicateResourceException exception = assertThrows(
            DuplicateResourceException.class,
            () -> userService.createUser(testUser)
        );

        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("email"));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void getUserById_Found() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        Optional<User> result = userService.getUserById(1L);

        assertTrue(result.isPresent());
        assertEquals(testUser, result.get());
        verify(userRepository).findById(1L);
    }

    @Test
    void getUserById_NotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserById(999L);

        assertFalse(result.isPresent());
        verify(userRepository).findById(999L);
    }

    @Test
    void getUserByUsername_Found() {
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));

        Optional<User> result = userService.getUserByUsername("testuser");

        assertTrue(result.isPresent());
        assertEquals(testUser, result.get());
    }

    @Test
    void getUserByUsername_NotFound() {
        when(userRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserByUsername("nonexistent");

        assertFalse(result.isPresent());
    }

    @Test
    void getUserByEmail_Found() {
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        Optional<User> result = userService.getUserByEmail("test@example.com");

        assertTrue(result.isPresent());
        assertEquals(testUser, result.get());
    }

    @Test
    void getUserByEmail_NotFound() {
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        Optional<User> result = userService.getUserByEmail("nonexistent@example.com");

        assertFalse(result.isPresent());
    }

    @Test
    void getAllUsers() {
        List<User> users = Arrays.asList(testUser, new User("user2", "user2@example.com", "pass"));
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository).findAll();
    }

    @Test
    void updateUser_Success() {
        User updatedData = new User();
        updatedData.setFirstName("Updated");
        updatedData.setLastName("Name");
        updatedData.setPhone("123-456-7890");
        updatedData.setAddress("123 Main St");

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User result = userService.updateUser(1L, updatedData);

        assertEquals("Updated", result.getFirstName());
        assertEquals("Name", result.getLastName());
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    void updateUser_NotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
            NotFoundException.class,
            () -> userService.updateUser(999L, new User())
        );

        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("999"));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void deleteUser_Success() {
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);

        assertDoesNotThrow(() -> userService.deleteUser(1L));
        verify(userRepository).existsById(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    void deleteUser_NotFound() {
        when(userRepository.existsById(999L)).thenReturn(false);

        NotFoundException exception = assertThrows(
            NotFoundException.class,
            () -> userService.deleteUser(999L)
        );

        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("999"));
        verify(userRepository, never()).deleteById(anyLong());
    }

    @Test
    void deactivateUser_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        userService.deactivateUser(1L);

        assertFalse(testUser.getActive());
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    void deactivateUser_NotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
            NotFoundException.class,
            () -> userService.deactivateUser(999L)
        );

        assertTrue(exception.getMessage().contains("User") && exception.getMessage().contains("999"));
        verify(userRepository, never()).save(any(User.class));
    }
}

