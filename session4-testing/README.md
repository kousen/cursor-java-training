# Session 4: Testing Solutions

This directory contains the lab exercises for Session 4: Reviewing and Testing Code Using Cursor and Claude.

## Project Structure

```
session4-testing/
├── README.md              # This file
├── labs.md                # Lab exercise instructions
├── slides.md              # Session slides (Slidev format)
├── ecommerce-modular/     # Main testing project
└── legacy-app/            # Legacy code for Lab 5
```

## What This Session Covers

- AI-assisted test generation
- Unit testing with JUnit 5, Mockito, and AssertJ
- Integration testing with TestContainers
- End-to-end API testing with MockMvc
- External service mocking with WireMock
- AI-powered debugging
- Legacy code testing strategies

## Prerequisites

- Java 17 or 21
- Spring Boot 3.2+
- Docker (for TestContainers)
- Cursor IDE with Claude

## How to Run

1. **Navigate to project:**
   ```bash
   cd ecommerce-modular
   ```

2. **Run all tests:**
   ```bash
   ./gradlew test
   ```

3. **Run integration tests:**
   ```bash
   ./gradlew integrationTest
   ```

4. **Generate test coverage:**
   ```bash
   ./gradlew jacocoTestReport
   open build/reports/jacoco/test/html/index.html
   ```

## Technologies Used

- JUnit 5
- AssertJ
- Mockito
- TestContainers (PostgreSQL)
- MockMvc
- WireMock (external service mocking)

## Lab Exercises

See [Lab Exercises](labs.md) for detailed instructions:

- **Lab 0:** AI Testing Setup
- **Lab 1:** Unit Test Generation with Mockito & AssertJ
- **Lab 1B:** AI-Powered Test Quality
- **Lab 2:** Integration Testing with TestContainers
- **Lab 3:** End-to-End Testing
- **Lab 4:** AI Debugging
- **Lab 5:** Legacy Code Testing

## Testing Strategy

1. **Unit Tests:** Fast, isolated tests for services using mocks
2. **Integration Tests:** Database testing with TestContainers
3. **E2E Tests:** Full API workflow testing with MockMvc

## AI Testing Features

This session emphasizes:
- AI test generation with comprehensive coverage
- AI-assisted debugging of failing tests
- AI code review for test quality
- Test data generation

## Notes

- **TestContainers:** Requires Docker to be running
- **Spring Boot 3.4+:** Uses `@MockitoBean` instead of deprecated `@MockBean`
- **Legacy App:** Used only for Lab 5 exploration

---

*Open `session4-testing` in Cursor to begin the labs. This gives you access to labs.md, ecommerce-modular, and legacy-app.*
