# Hello Spring Boot - Setup Guide

This document explains how to set up the Hello Spring Boot project for Session 1.

## Option 1: Students Generate from Spring Initializr (Recommended)

This is the recommended approach as it gives students practice with project setup.

### Spring Initializr Configuration

**URL:** [https://start.spring.io](https://start.spring.io)

**Project Settings:**
- **Project:** Gradle - Groovy
- **Language:** Java
- **Spring Boot:** 3.2.x (latest stable)
- **Group:** `com.example`
- **Artifact:** `hello-spring`
- **Name:** hello-spring
- **Description:** Demo project for Cursor training
- **Package name:** com.example.hellospring
- **Packaging:** Jar
- **Java:** 17 or 21

**Dependencies:**
- Spring Web
- Spring Data JPA
- H2 Database
- Validation
- Spring Boot DevTools

### Setup Instructions for Students

1. **Generate Project:**
   - Go to [start.spring.io](https://start.spring.io)
   - Configure as above
   - Click "Generate"
   - Download `hello-spring.zip`

2. **Extract and Open:**
   ```bash
   # Extract the ZIP file
   unzip hello-spring.zip
   cd hello-spring
   
   # Open in Cursor
   cursor .
   ```

3. **Verify Setup:**
   ```bash
   # Run the application
   ./gradlew bootRun
   
   # Expected: Application starts on port 8080
   # Press Ctrl+C to stop
   ```

4. **Verify in Cursor:**
   - Check Extensions are installed (see Lab 0)
   - Verify Java version matches project
   - Test Agent mode with simple prompt

---

## Option 2: Pre-built Starter (For Backup)

If students have issues with Spring Initializr, provide a pre-built starter.

### Folder Structure

```
hello-spring/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── hellospring/
│   │   │               └── HelloSpringApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── hellospring/
│                       └── HelloSpringApplicationTests.java
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

### Core Files

#### `build.gradle`

```groovy
plugins {
	id 'java'
	id 'org.springframework.boot' version '3.2.0'
	id 'io.spring.dependency-management' version '1.1.4'
}

group = 'com.example'
version = '0.0.1-SNAPSHOT'

java {
	sourceCompatibility = '17'
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

tasks.named('test') {
	useJUnitPlatform()
}
```

#### `settings.gradle`

```groovy
rootProject.name = 'hello-spring'
```

#### `src/main/resources/application.properties`

```properties
# Application name
spring.application.name=hello-spring

# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console (for development)
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080

# Logging
logging.level.com.example.hellospring=DEBUG
```

#### `src/main/java/com/example/hellospring/HelloSpringApplication.java`

```java
package com.example.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
```

#### `src/test/java/com/example/hellospring/HelloSpringApplicationTests.java`

```java
package com.example.hellospring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringApplicationTests {

	@Test
	void contextLoads() {
	}

}
```

#### `.gitignore`

```
HELP.md
.gradle
build/
!gradle/wrapper/gradle-wrapper.jar
!**/src/main/**/build/
!**/src/test/**/build/

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache
bin/
!**/src/main/**/bin/
!**/src/test/**/bin/

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr
out/
!**/src/main/**/out/
!**/src/test/**/out/

### NetBeans ###
/nbproject/private/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/

### VS Code ###
.vscode/

### Mac ###
.DS_Store
```

#### `README.md`

```markdown
# Hello Spring Boot

Demo project for Cursor training - Session 1

## Requirements

- Java 17 or 21
- Gradle 8.x (wrapper included)

## Running the Application

```bash
./gradlew bootRun
```

The application will start on http://localhost:8080

## H2 Console

Access the H2 database console at: http://localhost:8080/h2-console

Connection details:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## Building

```bash
./gradlew build
```

## Running Tests

```bash
./gradlew test
```
```

---

## Instructor Notes

### Before Class

1. **Test both approaches:**
   - Try generating from Spring Initializr yourself
   - Have backup starter ready in case of issues

2. **Network considerations:**
   - Spring Initializr requires internet
   - Have offline backup if network is unreliable
   - Pre-download Gradle wrapper if needed

3. **Common issues:**
   - Java version mismatch → verify with `java -version`
   - Gradle not found → use `./gradlew` (wrapper)
   - Port 8080 in use → change in `application.properties`

### During Class

**Recommended Flow:**

1. **Start with Spring Initializr (5 min):**
   - Show on projector
   - Walk through configuration
   - Students generate and download
   - Most will succeed

2. **Fallback plan:**
   - Have pre-built starter in shared folder
   - Students can copy if Initializr fails
   - Don't spend more than 5 minutes on setup issues

3. **Verification:**
   - Everyone runs `./gradlew bootRun`
   - See Spring Boot banner
   - Visit http://localhost:8080
   - Should see Whitelabel Error Page (no controllers yet)

4. **Then proceed to Lab 1** (creating first controller)

### Time Management

- **Ideal:** 5 minutes setup → start coding
- **With issues:** 10 minutes max → move on with backup
- **Don't:** Spend 20 minutes debugging one student's Java installation

### Multi-Window Support

Remind students they can:
- Open multiple Cursor windows (one per project)
- Keep Hello Spring Boot in one window
- Open PetClinic in another window later
- Reference examples while working

---

## Troubleshooting Guide

### Issue: "JAVA_HOME not set"

**Solution:**
```bash
# macOS/Linux
export JAVA_HOME=$(/usr/libexec/java_home -v 17)

# Windows
set JAVA_HOME=C:\Program Files\Java\jdk-17
```

### Issue: "Gradle wrapper not found"

**Solution:**
```bash
# The wrapper should be included, but if missing:
gradle wrapper --gradle-version 8.5
```

### Issue: "Port 8080 already in use"

**Solution:**

Option 1 - Change port in `application.properties`:
```properties
server.port=8081
```

Option 2 - Find and kill process:
```bash
# macOS/Linux
lsof -ti:8080 | xargs kill -9

# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F
```

### Issue: "Cannot download dependencies"

**Solution:**

1. **Check internet connection**
2. **Try manual download:**
   ```bash
   ./gradlew build --refresh-dependencies
   ```
3. **Use pre-built starter** (offline backup)

### Issue: "Tests failing after changes"

**Solution:**
```bash
# Clean and rebuild
./gradlew clean build

# Run tests with more info
./gradlew test --info
```

---

## Distribution Options

### Option A: Git Repository

**Before class:**
```bash
# Create repo for students
git init
git add .
git commit -m "Initial commit"
git remote add origin <repo-url>
git push -u origin main
```

**Students clone:**
```bash
git clone <repo-url>
cd hello-spring
./gradlew bootRun
```

### Option B: ZIP Distribution

**Create ZIP:**
```bash
# Exclude build artifacts
zip -r hello-spring-starter.zip hello-spring -x "*.gradle" -x "build/*"
```

**Students extract:**
```bash
unzip hello-spring-starter.zip
cd hello-spring
./gradlew bootRun
```

### Option C: Cloud IDE (Fallback)

For students with setup issues:
- GitHub Codespaces
- GitPod
- Replit

Pre-configure with:
- Correct Java version
- Project template
- Extensions installed

---

## Post-Session

### Student Homework

1. **Complete all labs** in `labs.md`
2. **Experiment with Agent** mode
3. **Try Chat** mode for learning
4. **Document learnings** for Session 2

### Instructor Follow-up

1. **Collect feedback:**
   - Which setup approach worked best?
   - Were there common issues?
   - Adjust for next session

2. **Update materials:**
   - Fix any errors found
   - Add common troubleshooting
   - Improve clarity where needed

3. **Prepare for Session 2:**
   - Review Session 1 code
   - Identify areas for deeper coverage
   - Plan mobile dev environment setup

---

## Quick Reference Commands

```bash
# Generate from Spring Initializr
curl https://start.spring.io/starter.zip \
  -d dependencies=web,data-jpa,h2,validation,devtools \
  -d javaVersion=17 \
  -d type=gradle-project \
  -d groupId=com.example \
  -d artifactId=hello-spring \
  -o hello-spring.zip

# Run application
./gradlew bootRun

# Run tests
./gradlew test

# Clean build
./gradlew clean build

# Generate wrapper
gradle wrapper

# Check Java version
java -version

# Check Gradle version
./gradlew --version
```

---

**Remember:** The goal is to get everyone coding quickly, not perfect environment setup!

