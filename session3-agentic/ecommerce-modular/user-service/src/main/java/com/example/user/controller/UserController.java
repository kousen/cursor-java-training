package com.example.user.controller;

import com.example.common.dto.ApiResponse;
import com.example.common.dto.PageRequest;
import com.example.common.dto.PageResponse;
import com.example.common.exception.NotFoundException;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ApiResponse.success(createdUser, "User created successfully");
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.success(users);
    }

    @GetMapping("/page")
    public ApiResponse<PageResponse<User>> getAllUsersPaginated(
            @Valid PageRequest pageRequest) {
        // Convert PageRequest to Spring Pageable
        Sort sort = pageRequest.sortBy() != null
                ? Sort.by(pageRequest.isAscending() ? Sort.Direction.ASC : Sort.Direction.DESC, pageRequest.sortBy())
                : Sort.unsorted();
        
        Pageable pageable = org.springframework.data.domain.PageRequest.of(
                pageRequest.page(),
                pageRequest.size(),
                sort
        );
        
        Page<User> page = userService.getAllUsersPaginated(pageable);
        PageResponse<User> pageResponse = PageResponse.of(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements()
        );
        
        return ApiResponse.success(pageResponse);
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new NotFoundException("User", id));
        return ApiResponse.success(user);
    }

    @GetMapping("/username/{username}")
    public ApiResponse<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found with username: " + username));
        return ApiResponse.success(user);
    }

    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return ApiResponse.success(updatedUser, "User updated successfully");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.message("User deleted successfully");
    }

    @PatchMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return ApiResponse.message("User deactivated successfully");
    }
}

