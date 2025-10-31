# Session 1: Spring Boot Development Solutions

This directory contains the solution implementation for Session 1 lab exercises.

## Project Structure

```
session1-spring-boot/
├── README.md              # This file
└── hello-spring/          # Complete solution project
    ├── src/
    ├── build.gradle
    └── ...
```

## Hello Spring Boot Project

This is a Spring Boot REST API application demonstrating:
- REST controllers with AI assistance
- Service layer with dependency injection
- JPA entities and repositories
- Bean validation and error handling
- DTOs using Java records
- Global exception handling
- Unit and integration tests

## How to Run

1. **Navigate to project:**
   ```bash
   cd hello-spring
   ```

2. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

3. **Test endpoints:**
   ```bash
   # Greeting endpoint
   curl http://localhost:8080/api/greetings?name=World
   
   # Create a person
   curl -X POST http://localhost:8080/api/persons \
     -H "Content-Type: application/json" \
     -d '{"firstName":"John","lastName":"Doe","email":"john@example.com"}'
   
   # Get all persons
   curl http://localhost:8080/api/persons
   ```

4. **Run tests:**
   ```bash
   ./gradlew test
   ```

## Technologies Used

- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- H2 Database (in-memory)
- JUnit 5
- AssertJ
- MockMvc (integration testing)

## Lab Exercises

This solution implements all exercises from [Lab Exercises (labs.md)](../labs.md):

- ✅ Lab 0: Setup Verification
- ✅ Lab 1: Creating Hello Spring Boot
- ✅ Lab 2: Adding Service Layer
- ✅ Lab 3: Adding Persistence
- ✅ Lab 4: Code Quality & Refactoring
- ✅ Lab 5: Test Generation

## Notes

- This is one possible solution generated following the lab instructions
- Prompts used are documented in the lab exercises
- Some code variations are acceptable as long as functionality matches

## Java Version Compatibility

**Important:** This project requires Java 21. If you're using Java 25 (as was the case during validation), you may encounter Gradle wrapper compatibility issues.

Update the Gradle wrapper to a version compatible with Java 25:
   ```bash
   ./gradlew wrapper --gradle-version=9.1.0
   ```

## Validation Results

All Session 1 labs have been validated:
- ✅ Lab 0: Setup Verification
- ✅ Lab 1: Creating Hello Spring Boot  
- ✅ Lab 2: Adding Service Layer
- ✅ Lab 3: Adding Persistence
- ✅ Lab 4: Code Quality & Refactoring
- ✅ Lab 5: Test Generation

All tests pass successfully!

## Next Steps

- Review the code structure
- Compare your implementation with this solution
- Explore Spring PetClinic (see main README for clone instructions)
- Complete homework exercises in labs.md (Part B)

