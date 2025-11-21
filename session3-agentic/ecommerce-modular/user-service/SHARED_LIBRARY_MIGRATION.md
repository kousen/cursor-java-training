# User Module: Shared Library Migration

## Summary

The User module has been updated to use shared library components from the `common` module, replacing custom implementations with standardized, reusable components.

## Changes Made

### 1. Controller Updates - ApiResponse Wrapper

**Before:**
```java
@GetMapping
public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
}
```

**After:**
```java
@GetMapping
public ApiResponse<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ApiResponse.success(users);
}
```

**Benefits:**
- Consistent response format across all endpoints
- Automatic timestamp inclusion
- Optional message support
- Cleaner code (no ResponseEntity wrapping needed)

### 2. Pagination Support Added

**New Endpoint:**
```java
@GetMapping("/page")
public ApiResponse<PageResponse<User>> getAllUsersPaginated(
        @Valid PageRequest pageRequest) {
    // Uses PageRequest DTO from common module
    // Returns PageResponse wrapper
}
```

**Usage:**
```
GET /api/users/page?page=0&size=20&sortBy=createdAt&sortDirection=desc
```

**Benefits:**
- Standard pagination DTOs (PageRequest, PageResponse)
- Validation built-in (@Min, @Max annotations)
- Consistent pagination across modules

### 3. Response Format Changes

**Old Format:**
```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com"
}
```

**New Format (with ApiResponse wrapper):**
```json
{
  "data": {
    "id": 1,
    "username": "testuser",
    "email": "test@example.com"
  },
  "message": "User created successfully",
  "timestamp": "2025-11-21T13:00:00"
}
```

### 4. Updated Components

#### UserController
- ✅ All endpoints now return `ApiResponse<T>` instead of `ResponseEntity<T>`
- ✅ Added pagination endpoint using `PageRequest` and `PageResponse`
- ✅ Uses `@ResponseStatus` for HTTP status codes
- ✅ Exception handling via GlobalExceptionHandler (automatic)

#### UserService
- ✅ Already using custom exceptions (NotFoundException, DuplicateResourceException)
- ✅ Added `getAllUsersPaginated(Pageable)` method for pagination support

#### UserRepository
- ✅ Added `Page<User> findAll(Pageable pageable)` method for pagination

### 5. Shared Library Components Used

| Component | Usage | Location |
|-----------|-------|----------|
| `BaseEntity` | User extends BaseEntity | `com.example.common.entity` |
| `NotFoundException` | Service layer exceptions | `com.example.common.exception` |
| `DuplicateResourceException` | Service layer exceptions | `com.example.common.exception` |
| `GlobalExceptionHandler` | Automatic exception handling | `com.example.common.exception` |
| `ApiResponse<T>` | Response wrapper | `com.example.common.dto` |
| `PageRequest` | Pagination request | `com.example.common.dto` |
| `PageResponse<T>` | Paginated response | `com.example.common.dto` |

## API Changes

### Endpoints Updated

All existing endpoints now return `ApiResponse` wrapper:

- `POST /api/users` → Returns `ApiResponse<User>` with message
- `GET /api/users` → Returns `ApiResponse<List<User>>`
- `GET /api/users/{id}` → Returns `ApiResponse<User>`
- `GET /api/users/username/{username}` → Returns `ApiResponse<User>`
- `PUT /api/users/{id}` → Returns `ApiResponse<User>` with message
- `DELETE /api/users/{id}` → Returns `ApiResponse<Void>` with message
- `PATCH /api/users/{id}/deactivate` → Returns `ApiResponse<Void>` with message

### New Endpoint

- `GET /api/users/page` → Returns `ApiResponse<PageResponse<User>>`
  - Query parameters: `page`, `size`, `sortBy`, `sortDirection`

## Migration Notes

### Breaking Changes

**Response Format:** All responses now wrapped in `ApiResponse` object. Clients need to access `.data` property:

**Before:**
```javascript
const user = response; // Direct user object
```

**After:**
```javascript
const user = response.data; // User object inside ApiResponse
```

### Backward Compatibility

To maintain backward compatibility, you could:
1. Keep both endpoints (with and without wrapper)
2. Use API versioning (`/api/v1/users` vs `/api/v2/users`)
3. Document the change and update clients

## Testing Updates

Tests have been updated to expect `ApiResponse` wrapper:
- JSON path assertions updated: `$.id` → `$.data.id`
- Message assertions added: `$.message`
- Pagination tests added for new endpoint

## Benefits Achieved

1. **Consistency**: All modules will use the same response format
2. **Maintainability**: Changes to response format happen in one place
3. **Features**: Automatic timestamps, message support
4. **Standards**: Uses shared DTOs and utilities
5. **Pagination**: Standard pagination support ready for use

## Next Steps

When extracting other modules (Product, Order, Payment), they will:
- Use the same `ApiResponse` wrapper
- Use the same pagination DTOs
- Benefit from consistent response formats
- Share common utilities and configurations

