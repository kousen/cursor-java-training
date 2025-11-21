# Coding Standards

This document outlines the coding standards and best practices for this project.

## Core Principles

This project follows **Clean Architecture** principles:
- **Dependency Injection** - Use constructor injection (never field injection)
- **Proper Error Handling** - Use custom exceptions and global exception handlers
- **Comprehensive Tests** - Unit tests and integration tests for all code
- **REST API Best Practices** - Follow RESTful conventions and HTTP standards
- **Loose Coupling** - Modules should be loosely coupled and highly cohesive

---

## Language & Framework Standards

### Java Version
- **Use Java 21+ features** (project uses Java 21)
- Prefer modern Java features:
  - Records for DTOs
  - Pattern matching (when applicable)
  - Text blocks for multi-line strings
  - `var` for local variables when type is obvious

### Spring Boot Conventions
- Follow Spring Boot conventions and auto-configuration
- Use Spring Boot starter dependencies
- Leverage Spring Boot's opinionated defaults

---

## Code Structure

### Package Organization
```
com.example.ecommerce/
├── controller/     # REST API endpoints
├── service/        # Business logic layer
├── repository/     # Data access layer
└── entity/         # Domain models (JPA entities)
```

### Layered Architecture
- **Controllers**: Handle HTTP requests/responses, validation, no business logic
- **Services**: Contain business logic, transaction management
- **Repositories**: Data access only, no business logic
- **Entities**: Domain models, JPA entities

---

## Dependency Injection

### ✅ DO: Constructor Injection
```java
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

### ❌ DON'T: Field Injection
```java
@Service
public class UserService {
    @Autowired  // DON'T DO THIS
    private UserRepository userRepository;
}
```

**Why?** Constructor injection:
- Makes dependencies explicit
- Enables immutability (`final` fields)
- Easier to test (no reflection needed)
- Fail-fast if dependencies are missing

---

## Naming Conventions

### Classes
- **PascalCase**: `UserService`, `UserController`, `UserRepository`
- **Descriptive names**: `UserService` not `US` or `UserSvc`
- **Suffix conventions**:
  - Controllers: `*Controller`
  - Services: `*Service`
  - Repositories: `*Repository`
  - Entities: Domain names (e.g., `User`, `Product`, `Order`)
  - DTOs: `*DTO` or `*Request`/`*Response`

### Methods
- **camelCase**: `createUser()`, `getUserById()`, `updateUser()`
- **Verb-based**: `create`, `get`, `update`, `delete`, `find`, `save`
- **Boolean methods**: `isActive()`, `hasPermission()`, `exists()`

### Variables
- **camelCase**: `userService`, `userId`, `userName`
- **Meaningful names**: `user` not `u`, `userList` not `list`
- **Avoid abbreviations**: `userName` not `uname`, `address` not `addr`

### Constants
- **UPPER_SNAKE_CASE**: `MAX_RETRY_COUNT`, `DEFAULT_PAGE_SIZE`

---

## JavaDoc Documentation

### ✅ DO: Include Comprehensive JavaDoc
```java
/**
 * Service for managing user operations.
 * Handles user creation, retrieval, updates, and deletion.
 * 
 * @author Your Name
 * @since 1.0.0
 */
@Service
@Transactional
public class UserService {
    
    /**
     * Creates a new user after validating uniqueness of username and email.
     * 
     * @param user The user entity to create
     * @return The created user with generated ID
     * @throws IllegalArgumentException if username or email already exists
     */
    public User createUser(User user) {
        // implementation
    }
}
```

### JavaDoc Tags
- `@param` - Document all parameters
- `@return` - Document return values
- `@throws` - Document exceptions
- `@since` - Version when added
- `@author` - Author name (optional)

---

## Error Handling

### Custom Exceptions
Use domain-specific exceptions (when available in modular version):
```java
// Preferred (modular version)
throw new NotFoundException("User", userId);
throw new DuplicateResourceException("User", "username", username);

// Monolith version (use IllegalArgumentException)
throw new IllegalArgumentException("User not found");
throw new IllegalArgumentException("Username already exists");
```

### Exception Messages
- **Clear and descriptive**: "User with id 123 not found"
- **Include context**: Include relevant IDs, names, etc.
- **Avoid exposing internals**: Don't reveal database structure or internal implementation

### Global Exception Handling
- Use `@RestControllerAdvice` for REST APIs
- Return RFC 7807 ProblemDetails format (modular version)
- Map exceptions to appropriate HTTP status codes

---

## Data Transfer Objects (DTOs)

### ✅ DO: Use Java Records for DTOs
```java
/**
 * Data Transfer Object for user creation requests.
 * 
 * @param username Unique username
 * @param email Valid email address
 * @param password Password (will be hashed)
 */
public record UserCreateRequest(
    @NotBlank String username,
    @Email String email,
    @NotBlank @Size(min = 8) String password
) {}
```

**Why Records?**
- Immutable by default
- Less boilerplate
- Concise and readable
- Perfect for data transfer

### ❌ DON'T: Expose Entities Directly
```java
// DON'T return entities directly from controllers
@GetMapping("/{id}")
public User getUser(@PathVariable Long id) {  // BAD
    return userService.getUserById(id);
}

// DO use DTOs
@GetMapping("/{id}")
public UserDTO getUser(@PathVariable Long id) {  // GOOD
    return UserDTO.from(userService.getUserById(id));
}
```

---

## Validation

### Entity Validation
```java
@Entity
public class User {
    @NotBlank(message = "Username is required")
    @Column(unique = true, nullable = false)
    private String username;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(unique = true, nullable = false)
    private String email;
}
```

### Controller Validation
```java
@PostMapping
public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserCreateRequest request) {
    // @Valid triggers validation
}
```

### Service Layer Validation
- Validate business rules in service layer
- Check for duplicates, existence, etc.
- Throw appropriate exceptions

---

## Transaction Management

### ✅ DO: Use @Transactional on Services
```java
@Service
@Transactional  // Class-level: all public methods are transactional
public class UserService {
    // Methods are transactional by default
}
```

### Transaction Boundaries
- **Services**: Use `@Transactional` for business operations
- **Repositories**: Don't add `@Transactional` (handled by Spring Data JPA)
- **Controllers**: Never use `@Transactional`

---

## Logging

### ✅ DO: Implement Proper Logging
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    
    public User createUser(User user) {
        log.debug("Creating user with username: {}", user.getUsername());
        try {
            User created = userRepository.save(user);
            log.info("User created successfully with ID: {}", created.getId());
            return created;
        } catch (Exception e) {
            log.error("Failed to create user: {}", user.getUsername(), e);
            throw e;
        }
    }
}
```

### Logging Levels
- **ERROR**: Errors that require attention
- **WARN**: Warning conditions
- **INFO**: Informational messages (important business events)
- **DEBUG**: Detailed information for debugging
- **TRACE**: Very detailed information

### Logging Best Practices
- Use parameterized logging: `log.info("User {} created", userId)` not `log.info("User " + userId + " created")`
- Don't log sensitive data (passwords, tokens, etc.)
- Include context (user ID, request ID, etc.)

---

## Testing Standards

### Unit Tests
- Use `@ExtendWith(MockitoExtension.class)` for service unit tests
- Mock dependencies with `@Mock`
- Inject service with `@InjectMocks`
- Use AssertJ for assertions
- Cover success cases, error scenarios, and edge cases

### Integration Tests
- Use `@DataJpaTest` for repository tests
- Use `@WebMvcTest` for controller tests
- Use `@SpringBootTest` for full integration tests
- Use `@MockBean` when you need Spring context

### Test Naming
- Pattern: `methodName_scenario_expectedResult`
- Example: `createUser_duplicateUsername_throwsException()`
- Use `@DisplayName` for readable test descriptions

---

## REST API Conventions

### HTTP Methods
- **GET**: Retrieve resources (idempotent)
- **POST**: Create resources
- **PUT**: Update entire resource (idempotent)
- **PATCH**: Partial updates
- **DELETE**: Delete resources (idempotent)

### Status Codes
- **200 OK**: Successful GET, PUT, PATCH
- **201 Created**: Successful POST
- **204 No Content**: Successful DELETE
- **400 Bad Request**: Validation errors
- **404 Not Found**: Resource not found
- **409 Conflict**: Duplicate resource
- **500 Internal Server Error**: Server errors

### Endpoint Naming
- Use plural nouns: `/api/users`, `/api/products`
- Use path variables for IDs: `/api/users/{id}`
- Use query parameters for filtering: `/api/products?category=electronics`

---

## Code Quality

### ✅ DO
- Keep methods focused (Single Responsibility Principle)
- Extract complex logic into private methods
- Use meaningful variable names
- Write self-documenting code
- Keep classes small and focused
- Use constants for magic numbers/strings

### ❌ DON'T
- Use field injection (`@Autowired` on fields)
- Expose entities directly from controllers
- Use public fields (encapsulate with getters/setters)
- Use static utility classes (hard to test)
- Use magic numbers (use constants)
- Abbreviate variable names unnecessarily
- Write methods longer than ~50 lines

---

## Security Best Practices

### ✅ DO
- Never return passwords in API responses
- Use DTOs to exclude sensitive fields
- Hash passwords (BCrypt, Argon2)
- Validate all input
- Use parameterized queries (JPA handles this)
- Implement authentication/authorization

### ❌ DON'T
- Store passwords in plaintext
- Expose sensitive data in responses
- Trust user input without validation
- Use string concatenation for SQL queries
- Expose internal error details to clients

---

## Code Formatting

### Indentation
- Use 4 spaces (not tabs)
- Consistent indentation throughout

### Line Length
- Maximum 120 characters per line
- Break long lines appropriately

### Braces
- Always use braces, even for single-line if statements
- Opening brace on same line
- Closing brace on its own line

### Imports
- Organize imports (IDE usually handles this)
- Remove unused imports

---

## Summary Checklist

When writing code, ensure:
- [ ] Constructor injection (not field injection)
- [ ] Comprehensive JavaDoc
- [ ] Meaningful variable names
- [ ] Proper error handling
- [ ] DTOs instead of exposing entities
- [ ] `@Transactional` on services
- [ ] Proper logging
- [ ] Input validation
- [ ] Unit tests written
- [ ] No sensitive data in responses
- [ ] Follow REST API conventions

---

**Last Updated**: 2025-01-XX  
**Version**: 1.0.0

