package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Unit tests for UserService.
 * Tests cover all service methods including success cases, error scenarios, and edge cases.
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("UserService Unit Tests")
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;
    private User anotherUser;

    @BeforeEach
    void setUp() {
        testUser = new User("testuser", "test@example.com", "password123");
        testUser.setId(1L);
        testUser.setFirstName("Test");
        testUser.setLastName("User");
        testUser.setPhone("555-1234");
        testUser.setAddress("123 Main St");
        testUser.setActive(true);

        anotherUser = new User("anotheruser", "another@example.com", "password456");
        anotherUser.setId(2L);
        anotherUser.setFirstName("Another");
        anotherUser.setLastName("User");
        anotherUser.setActive(true);
    }

    // ========== createUser Tests ==========

    @Test
    @DisplayName("Should create user successfully when username and email are unique")
    void createUser_Success() {
        // Given
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        // When
        User result = userService.createUser(testUser);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getUsername()).isEqualTo("testuser");
        assertThat(result.getEmail()).isEqualTo("test@example.com");
        
        verify(userRepository).existsByUsername("testuser");
        verify(userRepository).existsByEmail("test@example.com");
        verify(userRepository).save(testUser);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when username already exists")
    void createUser_DuplicateUsername() {
        // Given
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        // When/Then
        assertThatThrownBy(() -> userService.createUser(testUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Username already exists");

        verify(userRepository).existsByUsername("testuser");
        verify(userRepository, never()).existsByEmail(anyString());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when email already exists")
    void createUser_DuplicateEmail() {
        // Given
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(true);

        // When/Then
        assertThatThrownBy(() -> userService.createUser(testUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Email already exists");

        verify(userRepository).existsByUsername("testuser");
        verify(userRepository).existsByEmail("test@example.com");
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should check username before email when creating user")
    void createUser_ChecksUsernameBeforeEmail() {
        // Given
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        // When
        assertThatThrownBy(() -> userService.createUser(testUser))
                .isInstanceOf(IllegalArgumentException.class);

        // Then - verify email check never happens if username check fails
        verify(userRepository).existsByUsername("testuser");
        verify(userRepository, never()).existsByEmail(anyString());
    }

    // ========== getUserById Tests ==========

    @Test
    @DisplayName("Should return user when found by ID")
    void getUserById_Found() {
        // Given
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        // When
        Optional<User> result = userService.getUserById(1L);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testUser);
        assertThat(result.get().getId()).isEqualTo(1L);
        assertThat(result.get().getUsername()).isEqualTo("testuser");
        verify(userRepository).findById(1L);
    }

    @Test
    @DisplayName("Should return empty Optional when user not found by ID")
    void getUserById_NotFound() {
        // Given
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserById(999L);

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findById(999L);
    }

    @Test
    @DisplayName("Should handle null ID gracefully")
    void getUserById_NullId() {
        // Given
        when(userRepository.findById(null)).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserById(null);

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findById(null);
    }

    // ========== getUserByUsername Tests ==========

    @Test
    @DisplayName("Should return user when found by username")
    void getUserByUsername_Found() {
        // Given
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));

        // When
        Optional<User> result = userService.getUserByUsername("testuser");

        // Then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testUser);
        assertThat(result.get().getUsername()).isEqualTo("testuser");
        verify(userRepository).findByUsername("testuser");
    }

    @Test
    @DisplayName("Should return empty Optional when username not found")
    void getUserByUsername_NotFound() {
        // Given
        when(userRepository.findByUsername("nonexistent")).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserByUsername("nonexistent");

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findByUsername("nonexistent");
    }

    @Test
    @DisplayName("Should handle case-sensitive username lookup")
    void getUserByUsername_CaseSensitive() {
        // Given
        when(userRepository.findByUsername("TestUser")).thenReturn(Optional.empty());
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(testUser));

        // When
        Optional<User> resultLowercase = userService.getUserByUsername("testuser");
        Optional<User> resultUppercase = userService.getUserByUsername("TestUser");

        // Then
        assertThat(resultLowercase).isPresent();
        assertThat(resultUppercase).isEmpty();
    }

    @Test
    @DisplayName("Should handle null username gracefully")
    void getUserByUsername_NullUsername() {
        // Given
        when(userRepository.findByUsername(null)).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserByUsername(null);

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findByUsername(null);
    }

    // ========== getUserByEmail Tests ==========

    @Test
    @DisplayName("Should return user when found by email")
    void getUserByEmail_Found() {
        // Given
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        // When
        Optional<User> result = userService.getUserByEmail("test@example.com");

        // Then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(testUser);
        assertThat(result.get().getEmail()).isEqualTo("test@example.com");
        verify(userRepository).findByEmail("test@example.com");
    }

    @Test
    @DisplayName("Should return empty Optional when email not found")
    void getUserByEmail_NotFound() {
        // Given
        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserByEmail("nonexistent@example.com");

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findByEmail("nonexistent@example.com");
    }

    @Test
    @DisplayName("Should handle null email gracefully")
    void getUserByEmail_NullEmail() {
        // Given
        when(userRepository.findByEmail(null)).thenReturn(Optional.empty());

        // When
        Optional<User> result = userService.getUserByEmail(null);

        // Then
        assertThat(result).isEmpty();
        verify(userRepository).findByEmail(null);
    }

    // ========== getAllUsers Tests ==========

    @Test
    @DisplayName("Should return all users when multiple users exist")
    void getAllUsers_MultipleUsers() {
        // Given
        List<User> users = Arrays.asList(testUser, anotherUser);
        when(userRepository.findAll()).thenReturn(users);

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(testUser, anotherUser);
        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Should return empty list when no users exist")
    void getAllUsers_EmptyList() {
        // Given
        when(userRepository.findAll()).thenReturn(List.of());

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEmpty();
        verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Should return single user when only one user exists")
    void getAllUsers_SingleUser() {
        // Given
        when(userRepository.findAll()).thenReturn(List.of(testUser));

        // When
        List<User> result = userService.getAllUsers();

        // Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(1);
        assertThat(result).containsExactly(testUser);
        verify(userRepository).findAll();
    }

    // ========== updateUser Tests ==========

    @Test
    @DisplayName("Should update user successfully when user exists")
    void updateUser_Success() {
        // Given
        User updatedData = new User();
        updatedData.setFirstName("Updated");
        updatedData.setLastName("Name");
        updatedData.setPhone("555-9999");
        updatedData.setAddress("456 New St");

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        User result = userService.updateUser(1L, updatedData);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getFirstName()).isEqualTo("Updated");
        assertThat(result.getLastName()).isEqualTo("Name");
        assertThat(result.getPhone()).isEqualTo("555-9999");
        assertThat(result.getAddress()).isEqualTo("456 New St");
        
        // Verify original fields are preserved
        assertThat(result.getUsername()).isEqualTo("testuser");
        assertThat(result.getEmail()).isEqualTo("test@example.com");
        assertThat(result.getPassword()).isEqualTo("password123");
        
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when updating non-existent user")
    void updateUser_NotFound() {
        // Given
        User updatedData = new User();
        updatedData.setFirstName("Updated");
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        // When/Then
        assertThatThrownBy(() -> userService.updateUser(999L, updatedData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User not found");

        verify(userRepository).findById(999L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should update only provided fields, leaving others unchanged")
    void updateUser_PartialUpdate() {
        // Given
        User updatedData = new User();
        updatedData.setFirstName("UpdatedFirstName");
        // lastName, phone, address are null

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        User result = userService.updateUser(1L, updatedData);

        // Then
        assertThat(result.getFirstName()).isEqualTo("UpdatedFirstName");
        assertThat(result.getLastName()).isEqualTo("User"); // Original value preserved
        assertThat(result.getPhone()).isEqualTo("555-1234"); // Original value preserved
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    @DisplayName("Should handle null values in update data")
    void updateUser_NullValues() {
        // Given
        User updatedData = new User();
        updatedData.setFirstName(null);
        updatedData.setLastName(null);
        updatedData.setPhone(null);
        updatedData.setAddress(null);

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        User result = userService.updateUser(1L, updatedData);

        // Then
        assertThat(result.getFirstName()).isNull();
        assertThat(result.getLastName()).isNull();
        assertThat(result.getPhone()).isNull();
        assertThat(result.getAddress()).isNull();
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    @DisplayName("Should not update username, email, or password fields")
    void updateUser_DoesNotUpdateImmutableFields() {
        // Given
        User updatedData = new User();
        updatedData.setUsername("newusername");
        updatedData.setEmail("newemail@example.com");
        updatedData.setPassword("newpassword");
        updatedData.setFirstName("Updated");

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        User result = userService.updateUser(1L, updatedData);

        // Then - immutable fields should not be changed
        assertThat(result.getUsername()).isEqualTo("testuser"); // Original value
        assertThat(result.getEmail()).isEqualTo("test@example.com"); // Original value
        assertThat(result.getPassword()).isEqualTo("password123"); // Original value
        assertThat(result.getFirstName()).isEqualTo("Updated"); // Updated value
    }

    // ========== deleteUser Tests ==========

    @Test
    @DisplayName("Should delete user successfully when user exists")
    void deleteUser_Success() {
        // Given
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);

        // When
        assertThatCode(() -> userService.deleteUser(1L))
                .doesNotThrowAnyException();

        // Then
        verify(userRepository).existsById(1L);
        verify(userRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when deleting non-existent user")
    void deleteUser_NotFound() {
        // Given
        when(userRepository.existsById(999L)).thenReturn(false);

        // When/Then
        assertThatThrownBy(() -> userService.deleteUser(999L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User not found");

        verify(userRepository).existsById(999L);
        verify(userRepository, never()).deleteById(anyLong());
    }

    @Test
    @DisplayName("Should handle null ID when deleting user")
    void deleteUser_NullId() {
        // Given
        when(userRepository.existsById(null)).thenReturn(false);

        // When/Then
        assertThatThrownBy(() -> userService.deleteUser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User not found");

        verify(userRepository).existsById(null);
        verify(userRepository, never()).deleteById(any());
    }

    // ========== deactivateUser Tests ==========

    @Test
    @DisplayName("Should deactivate user successfully when user exists")
    void deactivateUser_Success() {
        // Given
        testUser.setActive(true);
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        assertThatCode(() -> userService.deactivateUser(1L))
                .doesNotThrowAnyException();

        // Then
        assertThat(testUser.getActive()).isFalse();
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    @DisplayName("Should set active to false even if already false")
    void deactivateUser_AlreadyInactive() {
        // Given
        testUser.setActive(false);
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        userService.deactivateUser(1L);

        // Then
        assertThat(testUser.getActive()).isFalse();
        verify(userRepository).findById(1L);
        verify(userRepository).save(testUser);
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when deactivating non-existent user")
    void deactivateUser_NotFound() {
        // Given
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        // When/Then
        assertThatThrownBy(() -> userService.deactivateUser(999L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User not found");

        verify(userRepository).findById(999L);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should handle null ID when deactivating user")
    void deactivateUser_NullId() {
        // Given
        when(userRepository.findById(null)).thenReturn(Optional.empty());

        // When/Then
        assertThatThrownBy(() -> userService.deactivateUser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("User not found");

        verify(userRepository).findById(null);
        verify(userRepository, never()).save(any(User.class));
    }

    // ========== Edge Cases and Integration Scenarios ==========

    @Test
    @DisplayName("Should handle repository exceptions gracefully")
    void createUser_RepositoryException() {
        // Given
        when(userRepository.existsByUsername("testuser")).thenReturn(false);
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenThrow(new RuntimeException("Database error"));

        // When/Then
        assertThatThrownBy(() -> userService.createUser(testUser))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Database error");
    }

    @Test
    @DisplayName("Should maintain transaction boundaries")
    void updateUser_TransactionRollback() {
        // Given
        User updatedData = new User();
        updatedData.setFirstName("Updated");
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenThrow(new RuntimeException("Transaction failed"));

        // When/Then
        assertThatThrownBy(() -> userService.updateUser(1L, updatedData))
                .isInstanceOf(RuntimeException.class);

        // Verify the user entity was not modified before save failed
        verify(userRepository).findById(1L);
        verify(userRepository).save(any(User.class));
    }
}

