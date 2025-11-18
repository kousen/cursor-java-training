# E-Commerce Monolith Application

This is a monolithic Spring Boot e-commerce application used as starter code for Session 3: Agentic Coding labs.

## Overview

This application demonstrates a typical monolithic architecture with all functionality in a single codebase:

- **User Management** - User registration, authentication, profile management
- **Product Catalog** - Product management, inventory, search
- **Order Processing** - Shopping cart, order placement, order tracking
- **Payment Processing** - Payment gateway integration, transaction management

## Architecture

The application follows a typical layered architecture:

```
com.example.ecommerce/
├── controller/     # REST API endpoints
├── service/        # Business logic
├── repository/     # Data access layer
└── entity/         # Domain models
```

## Technologies

- **Java 17+**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Gradle 9.2.0**

## Getting Started

### Prerequisites

- Java 17 or higher
- Gradle 9.2.0 or higher (wrapper included)

### Running the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### H2 Console

Access the H2 database console at: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:ecommerce`
- Username: `sa`
- Password: (leave blank)

## API Endpoints

### Users
- `POST /api/users` - Create user
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Products
- `POST /api/products` - Create product
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/category/{category}` - Get products by category
- `GET /api/products/search?query={term}` - Search products
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Orders
- `POST /api/orders?userId={id}` - Create order
- `GET /api/orders` - Get all orders
- `GET /api/orders/{id}` - Get order by ID
- `GET /api/orders/user/{userId}` - Get orders by user
- `PATCH /api/orders/{id}/status?status={status}` - Update order status
- `DELETE /api/orders/{id}` - Cancel order

### Payments
- `POST /api/payments?orderId={id}&paymentMethod={method}` - Create payment
- `GET /api/payments/{id}` - Get payment by ID
- `GET /api/payments/order/{orderId}` - Get payment by order
- `POST /api/payments/{id}/process` - Process payment
- `POST /api/payments/{id}/refund` - Refund payment

## Lab Exercises

This monolith will be refactored during the lab exercises:

1. **Lab 0** - Initial analysis with Extended Thinking
2. **Lab 1** - Planning modular architecture with Plan Mode
3. **Lab 2** - Extracting User module
4. **Lab 3** - Creating shared library
5. **Labs 4-7** - Advanced agentic coding techniques

## Characteristics (For Analysis)

This monolith exhibits typical characteristics that make it a candidate for refactoring:

- All functionality in a single codebase
- Tight coupling between components
- Shared database schema
- No clear module boundaries
- Simple error handling
- Basic service layer patterns
- Straightforward but not scalable architecture

These characteristics make it an ideal candidate for demonstrating agentic coding principles and refactoring techniques.
