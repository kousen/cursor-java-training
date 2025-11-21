# User Service Module

This is the extracted User Service module from the monolithic e-commerce application.

## Overview

The User Service module handles user management functionality including:
- User registration and authentication
- User profile management
- User activation/deactivation

## Module Structure

```
user-service/
├── src/main/java/com/example/user/
│   ├── entity/
│   │   └── User.java
│   ├── repository/
│   │   └── UserRepository.java
│   ├── service/
│   │   └── UserService.java
│   ├── controller/
│   │   └── UserController.java
│   └── UserServiceApplication.java
└── src/test/java/com/example/user/
    ├── service/
    │   └── UserServiceTest.java
    ├── controller/
    │   └── UserControllerTest.java
    └── integration/
        ├── UserServiceIntegrationTest.java
        └── UserControllerIntegrationTest.java
```

## API Endpoints

- `POST /api/users` - Create a new user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `GET /api/users/username/{username}` - Get user by username
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user
- `PATCH /api/users/{id}/deactivate` - Deactivate user

## Running the Service

```bash
cd user-service
../gradlew bootRun
```

The service will start on port 8081 (configured in `application.properties`).

## Testing

Run all tests:
```bash
../gradlew test
```

Run specific test suites:
```bash
# Unit tests only
../gradlew test --tests "*Test"

# Integration tests only
../gradlew test --tests "*IntegrationTest"
```

## Dependencies

- `common` module - Shared utilities and base classes
- Spring Boot 3.5.7
- Spring Data JPA
- H2 Database (in-memory)

## Port Configuration

The service runs on port **8081** to avoid conflicts with other services.

