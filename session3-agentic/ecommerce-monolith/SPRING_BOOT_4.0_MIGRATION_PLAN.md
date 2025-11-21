# Spring Boot 4.0 Migration Plan

This document details the step-by-step execution plan for upgrading the ecommerce-monolith from Spring Boot 3.5.7 to 4.0.0.

## Phase 1: Preparation

### 1.1 Verify Environment
- [ ] Ensure JDK 25 is installed and configured in your IDE.
- [ ] Verify `JAVA_HOME` points to JDK 25.

### 1.2 Baseline Verification
- [ ] Run current tests to ensure clean state:
  ```bash
  ./gradlew test
  ```
- [ ] Verify application starts successfully:
  ```bash
  ./gradlew bootRun
  ```

## Phase 2: Upgrade Execution

### 2.1 Update Build Configuration
Modify `build.gradle`:

```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.0.0' // Update version
    id 'io.spring.dependency-management' version '1.1.4'
}

java {
    sourceCompatibility = '25' // Update to Java 25
}
```

### 2.2 Add Migration Tooling
Temporarily add the properties migrator to `build.gradle` dependencies:

```gradle
dependencies {
    // ... other dependencies
    runtimeOnly 'org.springframework.boot:spring-boot-properties-migrator'
}
```

### 2.3 Refresh Dependencies
Force refresh dependencies to pull new versions:

```bash
./gradlew --refresh-dependencies build
```

## Phase 3: Runtime Verification & Fixes

### 3.1 Startup Analysis
1. Start the application:
   ```bash
   ./gradlew bootRun
   ```
2. Monitor console output for "Properties Migrator" logs.
3. Fix any reported deprecated properties in `src/main/resources/application.properties`.

### 3.2 Fix Compilation Errors
(Expected to be minimal/zero due to standard Jakarta usage)
- [ ] Check for any compilation errors related to Spring Framework 7.0 changes.
- [ ] Verify `GlobalExceptionHandler` compatibility.

### 3.3 Test Execution
Run the full test suite:

```bash
./gradlew test
```

**Focus Areas:**
- `UserServiceTest.java` (Business logic)
- Controller integration tests (if any)
- H2 database compatibility

## Phase 4: Cleanup

### 4.1 Remove Migrator
Remove the temporary dependency from `build.gradle`:

```gradle
// Remove this line
// runtimeOnly 'org.springframework.boot:spring-boot-properties-migrator'
```

### 4.2 Final Verification
Run a final clean build and test:

```bash
./gradlew clean build
```

## Rollback Plan

If critical issues are encountered:
1. Revert `build.gradle` changes.
2. `git checkout .` to discard local changes.
3. `./gradlew clean build` to restore 3.5.7 state.

