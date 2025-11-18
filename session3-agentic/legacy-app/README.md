# Legacy Application

This is a legacy Java application with intentional technical debt, used for Lab 8: Legacy Code Analysis.

## Overview

This application demonstrates common issues found in legacy codebases:

- Outdated coding practices
- Security vulnerabilities
- Performance issues
- Poor architecture
- Lack of documentation
- Missing tests
- Deprecated APIs

## Intentional Issues

### Architecture Issues
- No clear separation of concerns
- Business logic in controllers
- No DTOs (exposing entities directly)
- No layered architecture boundaries
- Static utility classes (hard to test)

### Security Issues
- **CRITICAL**: Plain text password storage
- **CRITICAL**: SQL injection vulnerabilities
- No input validation
- No authentication/authorization framework
- Exposing sensitive data in API responses
- Using GET requests for state changes

### Code Quality Issues
- Field injection instead of constructor injection
- Public fields (no encapsulation)
- No validation annotations
- Poor naming conventions (abbreviated names)
- Magic numbers throughout code
- No logging
- No error handling
- No proper exception handling

### Performance Issues
- No pagination on list endpoints
- Inefficient queries (loading all records)
- No caching strategy
- Using `double` for currency (precision issues)
- Inefficient string concatenation
- No database indexes
- N+1 query problems

### API Design Issues
- Using GET for state-changing operations
- No proper HTTP status codes
- No API versioning
- Inconsistent endpoint naming
- No proper REST conventions
- Returning strings instead of proper JSON

### Data Model Issues
- Using `Date` instead of `LocalDateTime` (deprecated)
- Using `double` for money (precision loss)
- Using `int` for status (should be enum)
- Public fields instead of proper encapsulation
- No validation constraints
- Poor field naming

### Testing Issues
- No unit tests
- No integration tests
- No test coverage
- Hard to test due to static methods

## Technologies

- Java 17
- Spring Boot 3.5.7
- H2 Database (in-memory)
- Gradle 9.2.0

## Running the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:9090`

## API Endpoints

### Customers
- `POST /customers` - Create customer
- `GET /customers` - Get all customers (no pagination)
- `GET /customers/{id}` - Get customer by ID
- `PUT /customers` - Update customer
- `DELETE /customers/{id}` - Delete customer
- `POST /customers/login` - Login (insecure)
- `GET /customers/search?name={name}` - Search customers

### Items
- `POST /items` - Add item
- `GET /items` - Get all items (no pagination)
- `GET /items/{id}` - Get item by ID
- `PUT /items` - Update item
- `GET /items/{id}/stock/add?qty={qty}` - Add stock (wrong HTTP method)
- `GET /items/{id}/stock/remove?qty={qty}` - Remove stock (wrong HTTP method)
- `POST /items/{id}/price?price={price}` - Update price
- `GET /items/inventory/value` - Get total inventory value
- `GET /items/stock/check?sku={sku}&qty={qty}` - Check stock
- `GET /items/{id}/deactivate` - Deactivate item (wrong HTTP method)

## Lab 8 Exercises

Use this codebase to practice:

1. **Technical Debt Analysis** - Identify architectural issues
2. **Security Assessment** - Find security vulnerabilities
3. **Performance Analysis** - Identify performance bottlenecks
4. **Modernization Strategy** - Create a modernization plan

## Key Learning Points

This legacy application demonstrates:

- Why modern best practices matter
- Security implications of poor coding
- Performance impact of inefficient design
- Importance of proper architecture
- Value of validation and error handling
- Benefits of using proper data types
- Importance of testing and documentation

## Modernization Opportunities

Students should identify opportunities for:

- Migrating to `LocalDateTime` from `Date`
- Using `BigDecimal` for currency instead of `double`
- Implementing proper security (password hashing, authentication)
- Adding input validation
- Implementing pagination
- Using DTOs instead of exposing entities
- Proper error handling and logging
- Adding comprehensive tests
- Using constructor injection
- Implementing proper REST conventions
- Adding proper HTTP status codes
- Using enums instead of magic numbers
