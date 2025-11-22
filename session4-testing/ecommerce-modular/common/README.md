# Common Module

Shared utilities and base classes for all service modules.

## Components

### BaseEntity
Base class for all JPA entities providing:
- `id` (Long) - Primary key with auto-generation
- `createdAt` (LocalDateTime) - Timestamp set on creation
- `updatedAt` (LocalDateTime) - Timestamp updated automatically on modification

**Usage:**
```java
@Entity
public class MyEntity extends BaseEntity {
    // Your fields here
    // id, createdAt, updatedAt are inherited
}
```

### Exceptions

#### NotFoundException
Thrown when a requested resource is not found.
```java
throw new NotFoundException("User", userId);
// Message: "User with id 123 not found"
```

#### DuplicateResourceException
Thrown when attempting to create a resource that already exists.
```java
throw new DuplicateResourceException("User", "username", "johndoe");
// Message: "User with username 'johndoe' already exists"
```

### GlobalExceptionHandler

Global exception handler using:
- **@RestControllerAdvice** (not @ControllerAdvice) - Automatically serializes responses to JSON
- **RFC 7807 ProblemDetails** (not custom DTOs) - Standard format for HTTP API errors

**Why @RestControllerAdvice?**
- Includes `@ResponseBody` by default
- More appropriate for REST APIs
- Cleaner code (no need to wrap in ResponseEntity)

**Why ProblemDetails (RFC 7807)?**
- Industry standard format
- Built-in Spring Boot support (Spring Boot 3.1+)
- Better tooling and client support
- Consistent structure: `type`, `title`, `status`, `detail`, `instance`

**Example ProblemDetails Response:**
```json
{
  "type": "about:blank",
  "title": "Resource Not Found",
  "status": 404,
  "detail": "User with id 123 not found",
  "instance": "/api/users/123",
  "resource": "User",
  "id": 123
}
```

## DTOs (Data Transfer Objects)

**Preference: Use Java Records instead of POJOs for DTOs**

Records are preferred for DTOs because they:
- Are immutable by default (better for data transfer)
- Reduce boilerplate (automatic getters, equals, hashCode, toString)
- More concise and readable
- Perfect for data-carrying objects

### Available DTOs

#### ApiResponse<T>
Standard wrapper for successful API responses:
```java
ApiResponse<User> response = ApiResponse.success(user);
ApiResponse<User> response = ApiResponse.success(user, "User created successfully");
ApiResponse<Void> response = ApiResponse.message("Operation completed");
```

#### PageRequest
Pagination request DTO:
```java
PageRequest pageRequest = PageRequest.of(0, 20);
PageRequest pageRequest = PageRequest.of(0, 20, "createdAt", "desc");
PageRequest pageRequest = PageRequest.defaults(); // page=0, size=20
```

#### PageResponse<T>
Paginated response wrapper:
```java
PageResponse<User> pageResponse = PageResponse.of(users, 0, 20, totalCount);
```

**Note:** Exceptions (NotFoundException, DuplicateResourceException) remain as classes since they must extend RuntimeException and cannot be records.

## Utilities

### ValidationUtils
Helper methods for Jakarta Validation:
```java
Set<String> violations = ValidationUtils.getViolationMessages(validator, user);
boolean isValid = ValidationUtils.isValid(validator, user);
ValidationUtils.validateOrThrow(validator, user); // throws IllegalArgumentException if invalid
```

### DateUtils
Helper methods for date/time operations:
```java
String iso = DateUtils.formatIso(localDateTime);
String display = DateUtils.formatDisplay(localDateTime);
long seconds = DateUtils.secondsBetween(start, end);
boolean isPast = DateUtils.isPast(localDateTime);
```

## Configurations

### JacksonConfig
Configures JSON serialization:
- Java 8 Time module support (LocalDateTime, etc.)
- ISO date/time formatting
- Consistent serialization across modules

### ValidationConfig
Provides Validator bean for programmatic validation:
```java
@Autowired
private Validator validator;

ValidationUtils.validateOrThrow(validator, user);
```

### WebConfig
Web-related configuration:
- CORS configuration for `/api/**` endpoints
- Allows all origins, methods, and headers (can be customized per module)

## Dependencies

- Jakarta Persistence API (for BaseEntity)
- Jakarta Validation API (for validation support)
- Spring Web & WebMVC (for GlobalExceptionHandler and configurations)
- Jackson (for JSON serialization)

## Module Structure

```
common/
├── entity/
│   └── BaseEntity.java          # Base class for all JPA entities
├── exception/
│   ├── NotFoundException.java    # Resource not found exception
│   ├── DuplicateResourceException.java  # Duplicate resource exception
│   └── GlobalExceptionHandler.java      # Global exception handler
├── dto/
│   ├── ApiResponse.java          # Standard API response wrapper
│   ├── PageRequest.java          # Pagination request DTO
│   └── PageResponse.java         # Paginated response DTO
├── util/
│   ├── ValidationUtils.java     # Validation helper methods
│   └── DateUtils.java            # Date/time utility methods
└── config/
    ├── JacksonConfig.java        # JSON serialization configuration
    ├── ValidationConfig.java     # Validation configuration
    └── WebConfig.java            # Web configuration (CORS, etc.)
```

## Usage in Service Modules

All service modules automatically inherit these components via the `common` module dependency. The GlobalExceptionHandler and configurations are automatically discovered via component scanning when you include the common package in your `@SpringBootApplication`:

```java
@SpringBootApplication(scanBasePackages = {"com.example.yourservice", "com.example.common"})
public class YourServiceApplication {
    // ...
}
```

### Example: Using Common Components

**Extend BaseEntity:**
```java
@Entity
public class Product extends BaseEntity {
    private String name;
    // id, createdAt, updatedAt inherited from BaseEntity
}
```

**Use Custom Exceptions:**
```java
throw new NotFoundException("Product", productId);
throw new DuplicateResourceException("Product", "sku", sku);
```

**Use DTOs:**
```java
@GetMapping
public ApiResponse<List<Product>> getAllProducts() {
    return ApiResponse.success(productService.getAllProducts());
}

@GetMapping("/page")
public PageResponse<Product> getProducts(PageRequest pageRequest) {
    // Use pageRequest for pagination
    return PageResponse.of(products, pageRequest.page(), pageRequest.size(), total);
}
```

**Use Utilities:**
```java
@Autowired
private Validator validator;

ValidationUtils.validateOrThrow(validator, product);
String formatted = DateUtils.formatIso(LocalDateTime.now());
```

