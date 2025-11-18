# Session 3: Lab Exercises

**Agentic Coding with Cursor**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Agentic Coding Setup](#lab-0-agentic-coding-setup)
2. [Lab 1: Modular Architecture Planning](#lab-1-modular-architecture-planning)
3. [Lab 2: Service Extraction](#lab-2-service-extraction)
4. [Lab 3: Shared Library Creation](#lab-3-shared-library-creation)
5. [Lab 4: Custom Slash Commands](#lab-4-custom-slash-commands)
6. [Lab 5: MCP Integration](#lab-5-mcp-integration)
7. [Lab 6: AI Code Review](#lab-6-ai-code-review)
8. [Lab 7: Team Collaboration](#lab-7-team-collaboration)

### Part B: Exploration Exercises (Homework/Practice)
9. [Lab 8: Legacy Code Analysis](#lab-8-legacy-code-analysis)
10. [Lab 9: Advanced MCP Integration](#lab-9-advanced-mcp-integration)
11. [Lab 10: Team Workflow Design](#lab-10-team-workflow-design)

---

## Part A: Code-Along Exercises (In-Class)

These exercises are designed to be completed during the session with instructor guidance. They can be repeated independently for practice.

---

## Lab 0: Agentic Coding Setup

**Goal:** Understand agentic coding principles and Extended Thinking mode
**Time:** 10 minutes

### Prerequisites

- Cursor installed and configured
- Basic understanding of Sessions 1-2 concepts
- E-commerce monolithic application (provided)

### What is Extended Thinking?

**Extended Thinking** is a Cursor feature where the AI takes additional time to reason through complex problems before responding. Think of it as asking the AI to "think deeply" about a problem rather than giving an immediate answer.

**How to use it:**
- In Chat Mode (Cmd/Ctrl+L), prefix your prompt with "Extended Thinking:"
- The AI will spend more time analyzing the problem from multiple angles
- Use it for architectural decisions, complex refactoring, and strategic planning

**When to use Extended Thinking:**
- ✅ Architectural design decisions
- ✅ Complex refactoring strategies
- ✅ Security analysis
- ✅ Performance optimization planning
- ❌ Simple questions like "What does this function do?"
- ❌ Quick syntax lookups

### **Steps**

1. **Open the E-commerce Monolith**

   Navigate to the provided monolithic e-commerce application:
   ```
   ecommerce-monolith/
   ├── src/main/java/com/example/ecommerce/
   │   ├── controller/
   │   │   ├── UserController.java
   │   │   ├── ProductController.java
   │   │   ├── OrderController.java
   │   │   └── PaymentController.java
   │   ├── service/
   │   ├── repository/
   │   ├── entity/
   │   └── EcommerceApplication.java
   ├── src/main/resources/
   │   └── application.properties
   └── build.gradle
   ```

2. **Test Extended Thinking Mode**

   **Open Chat Mode (Cmd/Ctrl+L):**
   Type:
   ```
      Extended Thinking: "Analyze this monolithic e-commerce application. 
      What are the main components and how do they interact? Identify 
      potential areas for modularization."
   ```

   **Expected Response:**
   - Detailed analysis of current architecture
   - Component interaction mapping
   - Modularization opportunities
   - Potential challenges and risks

3. **Compare with Regular Chat**

   **Regular Chat Mode:**
   Type:
   ```
      "What controllers are in this application?"
   ```

   **Notice the difference:**
   - Extended Thinking: Deep analysis, multiple perspectives
   - Regular Chat: Direct, specific answers

### Success Criteria

- ✅ Extended Thinking mode responds with comprehensive analysis
- ✅ Understanding of agentic coding principles
- ✅ Recognition of when to use Extended Thinking vs regular Chat

---

## Lab 1: Modular Architecture Planning

**Goal:** Use Plan Mode to create a comprehensive refactoring plan  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Initial Plan Generation (10 min)

1. **Open Plan Mode**

   **Command Palette (Cmd/Ctrl+Shift+P):**
   Type: `Cursor: Open Plan Mode`

2. **Generate Initial Plan**

   **Plan Mode Prompt:**
   Type:
   ```
      Analyze this monolithic e-commerce application and create a plan to 
      refactor it into modular architecture. Identify module boundaries, 
      shared dependencies, and refactoring phases.
   ```

3. **Review Generated Plan**

   **Expected Plan Structure:**
   - **Module Identification:** User, Product, Order, Payment, Common
   - **Shared Dependencies:** Database, utilities, configurations
   - **Refactoring Phases:** 4-6 phases with dependencies
   - **Risk Assessment:** Potential issues and mitigation strategies

4. **Understand Plan Components**

   **Key Elements to Review:**
   - Module boundaries and responsibilities
   - Shared library requirements
   - Database schema considerations
   - API contract definitions
   - Testing strategy

### Step 2: Plan Refinement (10 min)

1. **Modify the Plan**

   **Plan Mode Refinement:**
   Type:
   ```
      Modify the plan to prioritize User module first and add
      comprehensive testing strategy for each module.
   ```

2. **Review Refined Plan**

   **Updated Plan Features:**
   - **Phase 1:** User module extraction
   - **Phase 2:** Shared library creation
   - **Phase 3:** Product module extraction
   - **Phase 4:** Order and Payment modules
   - **Phase 5:** Integration and testing
   - **Phase 6:** Documentation and deployment

3. **Student Exercise**

   **Your Turn:**
   - Review the refined plan
   - Use Chat mode to ask questions about specific phases
   - Suggest one modification to the plan
   - Understand the planning process

### Success Criteria

- ✅ Plan Mode generates comprehensive refactoring plan
- ✅ Plan includes clear phases and dependencies
- ✅ Plan can be modified and refined
- ✅ Understanding of when to use Plan Mode

---

## Lab 2: Service Extraction

**Goal:** Execute Phase 1 of the plan - extract User module
**Time:** 25 minutes (may require additional time for iteration)
**Mode:** Code-along with instructor

### Important Notes

Creating a fully independent module is **complex** and may require multiple iterations. This lab focuses on understanding the **process** rather than achieving perfection. Be prepared to:
- Iterate on the AI's suggestions
- Handle dependency issues
- Adjust configurations
- Use Chat mode to troubleshoot

If time is limited, focus on understanding the **refactoring strategy** rather than completing all implementation details.

### Step 1: Execute Plan Phase 1 (15 min)

1. **Execute Phase 1**

   **Plan Mode Execution:**
   ```
   Execute Phase 1: Extract User module from the monolith.
   Create separate User module with its own package structure,
   entities, and API endpoints.
   ```

   **Note:** AI may create the module structure in different ways:
   - As a separate directory with its own build.gradle
   - As a sub-package within the monolith
   - As a multi-module Gradle project

   All approaches are valid learning opportunities.

2. **Review Generated Changes**

   **Expected Changes:**
   - New User module structure
   - User entity and repository
   - User API endpoints
   - Module dependencies
   - Shared library setup

3. **Examine Generated Code**

   **Key Files Created:**
   ```
   user-module/
   ├── src/main/java/com/example/user/
   │   ├── controller/UserController.java
   │   ├── service/UserService.java
   │   ├── repository/UserRepository.java
   │   ├── entity/User.java
   │   └── UserModuleApplication.java
   ├── src/main/resources/
   │   └── application.yml
   └── build.gradle
   ```

4. **Test the Module**

   **Run the Application:**
   ```bash
   cd user-module
   ./gradlew bootRun
   ```

   **Test API Endpoints:**
   ```bash
   curl http://localhost:8080/api/users
   curl http://localhost:8080/api/users/1
   ```

### Step 2: Validation and Review (10 min)

1. **Validate Module Boundaries**

   **Chat Mode Review:**
   Type:
   ```
      Review the extracted User module. Does it have clear boundaries? 
      Are there any dependencies that should be moved to shared library?
   ```

2. **Check for Issues**

   **Common Issues to Look For:**
   - Missing dependencies
   - Incorrect package structure
   - Database connection issues
   - Missing configuration

3. **Student Exercise**

   **Your Turn:**
   - Review the generated User module
   - Test API endpoints
   - Identify any issues or improvements
   - Understand module boundaries

### Success Criteria

- ✅ User module extracted successfully
- ✅ Module has clear boundaries
- ✅ API endpoints work correctly
- ✅ Understanding of module extraction process

---

## Lab 3: Shared Library Creation

**Goal:** Execute Phase 2 - create shared library for common utilities  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Create Shared Library (15 min)

1. **Execute Phase 2**

   **Plan Mode Execution:**
   ```
   Execute Phase 2: Create shared library for common utilities, 
   DTOs, and configurations used across modules.
   ```

2. **Review Generated Library**

   **Expected Structure:**
   ```
   shared-lib/
   ├── src/main/java/com/example/shared/
   │   ├── dto/
   │   │   ├── ApiResponse.java
   │   │   ├── ErrorResponse.java
   │   │   └── PaginationRequest.java
   │   ├── util/
   │   │   ├── ValidationUtils.java
   │   │   ├── DateUtils.java
   │   │   └── StringUtils.java
   │   ├── config/
   │   │   ├── DatabaseConfig.java
   │   │   └── SecurityConfig.java
   │   └── exception/
   │       ├── BusinessException.java
   │       └── GlobalExceptionHandler.java
   ├── src/main/resources/
   └── build.gradle
   ```

3. **Examine Generated Code**

   **Key Components:**
   - Common DTOs for API responses
   - Utility classes for validation
   - Shared configuration classes
   - Exception handling utilities

### Step 2: Integration Testing (5 min)

1. **Update User Module**

   **Plan Mode:**
   Type:
   ```
      Update User module to use shared library components.
      Replace custom DTOs and utilities with shared library versions.
   ```

2. **Test Integration**

   **Verify Changes:**
   - User module compiles with shared library
   - API responses use shared DTOs
   - Error handling uses shared utilities

### Success Criteria

- ✅ Shared library created with common utilities
- ✅ User module updated to use shared library
- ✅ Integration works correctly
- ✅ Understanding of shared library benefits

---

## Lab 4: Custom Slash Commands

**Goal:** Create and use custom slash commands for team workflows  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Create Custom Commands (10 min)

1. **Open Command Settings**

   **Command Palette (Cmd/Ctrl+Shift+P):**
   Type: `Cursor: Open Commands`

2. **Create Security Review Command**

   **Command Configuration:**
   ```
   Name: review-security
   Description: Review code for security vulnerabilities
   Prompt: "Review this code for security vulnerabilities including 
   SQL injection, XSS, authentication bypass, and data exposure risks. 
   Provide specific recommendations with examples."
   ```

3. **Create Test Generation Command**

   **Command Configuration:**
   ```
   Name: generate-tests
   Description: Generate comprehensive tests
   Prompt: "Generate comprehensive unit and integration tests for 
   this class using JUnit 5, Mockito, and TestContainers. Include 
   edge cases and error scenarios."
   ```

4. **Create Module Creation Command**

   **Command Configuration:**
   ```
   Name: create-module
   Description: Create new Spring Boot module
   Prompt: "Create a new Spring Boot module following our architecture 
   patterns: entity, repository, service, controller, and tests. 
   Use shared library components where appropriate."
   ```

### Step 2: Test Custom Commands (5 min)

1. **Test Security Review**

   **Select UserController.java**
   **Use Command:** `/review-security`
   **Review AI Response:** Security analysis and recommendations

2. **Test Test Generation**

   **Select UserService.java**
   **Use Command:** `/generate-tests`
   **Review AI Response:** Generated test suite

3. **Test Module Creation**

   **Use Command:** `/create-module`
   **Prompt:** "Create Product module"
   **Review AI Response:** Generated module structure

### Success Criteria

- ✅ Custom slash commands created successfully
- ✅ Commands work as expected
- ✅ Understanding of team workflow automation
- ✅ Recognition of when to use custom commands

---

## Lab 5: MCP Integration

**Goal:** Use MCP servers (Context7 and Playwright) to enhance development workflow
**Time:** 20 minutes
**Mode:** Code-along with instructor

### About This Lab

This lab demonstrates practical MCP (Model Context Protocol) integration using two real MCP servers:
- **Context7** - Up-to-date library documentation and best practices
- **Playwright** - Browser automation for testing web applications

**Prerequisites:** Context7 and Playwright MCP servers should be configured in Cursor.

### Step 1: Context7 for Documentation (10 min)

**Use Case:** Look up Spring Boot best practices while refactoring

1. **Query Spring Boot Validation**

   **Chat Mode with Context7:**
   Type:
   ```
   @context7 What are the current best practices for input validation
   in Spring Boot 3.x? Show me examples using Jakarta validation annotations.
   ```

   **Expected Response:**
   - Current Spring Boot 3.x validation patterns
   - `@Valid`, `@NotNull`, `@Email` examples
   - Code snippets you can use immediately

2. **Research REST API Best Practices**

   **Chat Mode with Context7:**
   Type:
   ```
   @context7 What are REST API best practices for Spring Boot controllers?
   Include error handling, status codes, and response formatting.
   ```

   **Expected Response:**
   - Current REST conventions
   - `ResponseEntity` usage patterns
   - Exception handling strategies
   - HTTP status code guidelines

3. **Look Up JPA Relationships**

   **Chat Mode with Context7:**
   Type:
   ```
   @context7 Show me best practices for JPA entity relationships in Spring Boot.
   Include @OneToMany, @ManyToOne, and cascade operations.
   ```

   **Why This Matters:**
   - Get up-to-date documentation without leaving Cursor
   - Find current best practices (not outdated Stack Overflow posts)
   - See actual code examples you can adapt

### Step 2: Playwright for Application Testing (10 min)

**Use Case:** Test the running e-commerce application

1. **Start the Application**

   **Terminal:**
   ```bash
   cd ecommerce-monolith
   ./gradlew bootRun
   ```

   Wait for application to start on `http://localhost:8080`

2. **Test API Endpoints with Playwright**

   **Chat Mode with Playwright:**
   Type:
   ```
   @playwright Navigate to http://localhost:8080/api/users and capture
   what you see. Then navigate to http://localhost:8080/h2-console and
   take a screenshot.
   ```

   **Expected Actions:**
   - Playwright opens browser
   - Navigates to endpoints
   - Captures responses/screenshots
   - Reports what it found

3. **Verify Application is Working**

   **Chat Mode with Playwright:**
   Type:
   ```
   @playwright Go to http://localhost:8080/api/products and verify
   the endpoint returns a 200 status code. Show me the response structure.
   ```

   **Expected Output:**
   - HTTP status verification
   - Response body structure
   - Confirmation endpoints are accessible

   **Why This Matters:**
   - Automated verification of running application
   - Visual confirmation through screenshots
   - Quick smoke testing without manual browser work

### Step 3: Combining Both (Optional)

**Advanced Use Case:** Use Context7 to research, then Playwright to test

1. **Research and Implement:**
   ```
   @context7 How do I add CORS configuration to Spring Boot?
   ```

2. **Implement the CORS configuration** in your code

3. **Test with Playwright:**
   ```
   @playwright Test that CORS headers are present in the response
   from http://localhost:8080/api/users
   ```

### Success Criteria

- ✅ Context7 provides up-to-date Spring Boot documentation
- ✅ Context7 examples are directly applicable to your code
- ✅ Playwright successfully navigates to application endpoints
- ✅ Playwright captures screenshots and verifies responses
- ✅ Understanding of how MCP extends Cursor's capabilities

### Key Insights

**Context7 Benefits:**
- Always up-to-date (unlike static AI training data)
- Library-specific best practices
- Real code examples you can copy

**Playwright Benefits:**
- Automated browser testing from within Cursor
- Visual verification of UI/endpoints
- No need to manually open browser for smoke tests

**MCP in General:**
- Extends AI capabilities with external tools
- Brings specialized knowledge into your workflow
- Automates repetitive development tasks

---

## Lab 6: AI Code Review

**Goal:** Conduct AI-assisted code review and quality improvement
**Time:** 15-20 minutes
**Mode:** Code-along with instructor

### Step 1: Comprehensive Code Review (10 min)

1. **AI-Assisted Review**

   **Extended Thinking Prompt:**
   Type:
   ```
      Extended Thinking: "Conduct a comprehensive code review of the User module.
      Analyze code quality, architecture, security, performance, and maintainability.
      Provide specific recommendations with examples."
   ```

2. **Review AI Analysis**

   **Expected Analysis Categories:**
   - **Architecture:** Module boundaries, dependencies
   - **Security:** Authentication, authorization, data protection
   - **Performance:** Database queries, caching, scalability
   - **Maintainability:** Code organization, documentation, testing
   - **Best Practices:** Spring Boot conventions, error handling

3. **Examine Recommendations**

   **Key Areas to Review:**
   - Security vulnerabilities
   - Performance bottlenecks
   - Code organization issues
   - Missing documentation
   - Testing gaps

### Step 2: Automated Quality Improvements (5 min)

1. **Apply Improvements**

   **Plan Mode:**
   ```
   Apply all recommended improvements from the code review.
   Focus on security enhancements, performance optimizations, and 
   code organization improvements.
   ```

2. **Review Applied Changes**

   **Expected Improvements:**
   - Security enhancements (input validation, SQL injection prevention)
   - Performance optimizations (caching, query optimization)
   - Code organization (package structure, naming conventions)
   - Error handling enhancements
   - Documentation improvements

### Success Criteria

- ✅ AI-assisted code review completed
- ✅ Comprehensive analysis provided
- ✅ Quality improvements applied
- ✅ Understanding of AI review process

---

## Lab 7: Team Collaboration

**Goal:** Establish team collaboration workflows with shared AI context  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Shared AI Context (10 min)

1. **Create Team .cursorrules File**

   **File: `.cursorrules`**
   ```
   This project follows Clean Architecture principles.
   Use dependency injection, implement proper error handling, include 
   comprehensive tests, and follow REST API best practices.
   Modules should be loosely coupled and highly cohesive.
   
   Coding Standards:
   - Use Java 17+ features
   - Follow Spring Boot conventions
   - Include comprehensive JavaDoc
   - Use meaningful variable names
   - Implement proper logging
   ```

2. **Test Shared Context**

   **Chat Mode Test:**
   Type:
   ```
      "What coding standards should I follow for this project?"
   ```

   **Expected Response:** AI references the .cursorrules file

3. **Verify Consistency**

   **Generate Code Test:**
   Type:
   ```
      "Create a new service class for order processing"
   ```

   **Expected Output:** Code follows team standards

### Step 2: Collaborative Development Patterns (5 min)

1. **Feature Branch Workflow**

   **Plan Mode Demo:**
   Type:
   ```
      Plan Mode: "Design and implement an Order module that integrates 
      with User and Product modules. Include order processing, inventory 
      management, and email notifications."
   ```

2. **Review Process**

   **AI-Generated Components:**
   - Test cases
   - Security scanning
   - Performance analysis
   - Documentation generation

### Success Criteria

- ✅ Shared .cursorrules file created
- ✅ AI follows team standards consistently
- ✅ Collaborative development patterns established
- ✅ Understanding of team workflow benefits

---

## 🎉 Checkpoint: Agentic Coding Complete!

**Congratulations!** You now have:

- ✅ Understanding of agentic coding principles
- ✅ Experience with Extended Thinking mode
- ✅ Plan Mode for complex projects
- ✅ Custom slash commands for team workflows
- ✅ MCP integration capabilities
- ✅ AI-assisted code review skills
- ✅ Team collaboration workflows

**Time for a break, then we'll explore legacy code modernization!**

---

## Part B: Exploration Exercises (Homework/Practice)

These exercises help you practice applying agentic coding principles to real-world scenarios. Complete them at your own pace.

---

## Lab 8: Legacy Code Analysis

**Goal:** Apply agentic coding principles to legacy code modernization  
**Time:** 45-60 minutes  
**Mode:** Self-paced with guided questions

### Setup

1. **Open Legacy Codebase**

   Navigate to the provided legacy Java application:
   ```
   legacy-app/
   ├── src/main/java/com/legacy/
   │   ├── controllers/
   │   ├── services/
   │   ├── repositories/
   │   ├── models/
   │   └── utils/
   ├── src/main/resources/
   └── build.gradle
   ```

2. **Initial Assessment**

   **Extended Thinking Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze this legacy Java application and create a 
      modernization strategy. Identify technical debt, security issues, 
      performance bottlenecks, and migration opportunities."
   ```

### Exercise 1: Technical Debt Analysis (15 min)

**Use Extended Thinking to explore:**

1. **Architecture Issues:**
   Type:
   ```
      Extended Thinking: "What are the main architectural issues in this 
      codebase? How does the current structure impact maintainability?"
   ```

2. **Code Quality Issues:**
   Type:
   ```
      Extended Thinking: "Identify code quality issues including deprecated 
      APIs, poor error handling, and missing documentation."
   ```

3. **Dependency Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze the dependency structure. Are there 
      circular dependencies or outdated libraries?"
   ```

**Document your findings** in `legacy-analysis.md`

### Exercise 2: Security Assessment (15 min)

**Security Analysis:**

1. **Vulnerability Assessment:**
   Type:
   ```
      Extended Thinking: "Conduct a security assessment of this legacy 
      application. Identify potential vulnerabilities including SQL injection, 
      XSS, authentication bypass, and data exposure risks."
   ```

2. **Authentication and Authorization:**
   Type:
   ```
      Extended Thinking: "Review the authentication and authorization 
      mechanisms. Are they secure and following current best practices?"
   ```

3. **Data Protection:**
   Type:
   ```
      Extended Thinking: "Analyze how sensitive data is handled. Are there 
      proper encryption and access controls?"
   ```

### Exercise 3: Performance Analysis (15 min)

**Performance Assessment:**

1. **Bottleneck Identification:**
   Type:
   ```
      Extended Thinking: "Identify performance bottlenecks in this 
      application. Focus on database queries, memory usage, and I/O operations."
   ```

2. **Scalability Issues:**
   Type:
   ```
      Extended Thinking: "Analyze the application's scalability. What 
      limitations exist and how could they be addressed?"
   ```

3. **Optimization Opportunities:**
   Type:
   ```
      Extended Thinking: "Identify specific optimization opportunities 
      including caching, query optimization, and resource management."
   ```

### Exercise 4: Modernization Strategy (15 min)

**Create Modernization Plan:**

1. **Migration Strategy:**
   Type:
   ```
      Extended Thinking: "Create a comprehensive modernization strategy 
      for this legacy application. Include phased approach, risk assessment, 
      and success criteria."
   ```

2. **Technology Stack Update:**
   Type:
   ```
      Extended Thinking: "Recommend technology stack updates including 
      framework versions, libraries, and tools."
   ```

3. **Implementation Plan:**
   Type:
   ```
      Extended Thinking: "Create a detailed implementation plan with 
      timelines, resources, and milestones."
   ```

### Success Criteria

- ✅ Comprehensive legacy code analysis completed
- ✅ Technical debt identified and documented
- ✅ Security vulnerabilities assessed
- ✅ Performance bottlenecks identified
- ✅ Modernization strategy created
- ✅ Understanding of agentic coding for legacy systems

---

## Lab 9: Advanced MCP Usage

**Goal:** Master advanced Context7 and Playwright workflows
**Time:** 30-45 minutes
**Mode:** Self-paced exploration

### Exercise 1: Advanced Context7 Usage (20 min)

**Multi-Library Research:**

1. **Compare Libraries:**
   Type:
   ```
   @context7 Compare Hibernate vs Spring Data JPA for entity management.
   What are the trade-offs and when would you use each?
   ```

2. **Version-Specific Features:**
   Type:
   ```
   @context7 What's new in Spring Boot 3.5 compared to 3.2?
   Show me migration steps and new features I should use.
   ```

3. **Security Best Practices:**
   Type:
   ```
   @context7 What are the current Spring Security best practices for
   REST APIs? Include JWT, OAuth2, and CORS configuration examples.
   ```

4. **Performance Optimization:**
   Type:
   ```
   @context7 How do I optimize Spring Boot application startup time?
   Show me lazy initialization, conditional beans, and other techniques.
   ```

**Why This Matters:**
- Research multiple related topics quickly
- Get version-specific information
- Find current best practices without outdated blogs

### Exercise 2: Advanced Playwright Workflows (15 min)

**Comprehensive Application Testing:**

1. **End-to-End User Flow:**
   Type:
   ```
   @playwright Test this user workflow on http://localhost:8080:
   1. Navigate to /api/users
   2. Check that the response is valid JSON
   3. Navigate to /api/products
   4. Verify products are returned
   5. Take screenshots at each step
   ```

2. **Performance Testing:**
   Type:
   ```
   @playwright Measure page load times for the following endpoints:
   - /api/users
   - /api/products
   - /api/orders
   Report any endpoints slower than 500ms
   ```

3. **Visual Regression:**
   Type:
   ```
   @playwright Take screenshots of the H2 console at:
   http://localhost:8080/h2-console
   Save them with timestamp so I can compare across sessions.
   ```

**Why This Matters:**
- Automated acceptance testing
- Performance monitoring
- Visual change detection

### Exercise 3: Combined Workflows (10 min)

**Research → Implement → Test Cycle:**

1. **Research with Context7:**
   ```
   @context7 How do I add pagination to Spring Data JPA repositories?
   Show me examples with PageRequest and Pageable.
   ```

2. **Implement the pagination** in your ProductService

3. **Test with Playwright:**
   ```
   @playwright Test the paginated product endpoint:
   http://localhost:8080/api/products?page=0&size=10
   Verify pagination metadata is present in the response.
   ```

4. **Verify Documentation:**
   ```
   @context7 Generate OpenAPI documentation example for a paginated
   endpoint with page, size, and sort parameters.
   ```

### Success Criteria

- ✅ Use Context7 for multi-library research
- ✅ Get version-specific Spring Boot information
- ✅ Automate complex test workflows with Playwright
- ✅ Combine research, implementation, and testing in one workflow
- ✅ Understanding of MCP in real development scenarios

### Key Insights

**Advanced Context7 Patterns:**
- Compare multiple libraries/approaches
- Get migration guides between versions
- Research complex topics (security, performance)
- Generate documentation snippets

**Advanced Playwright Patterns:**
- End-to-end user flow testing
- Performance measurement
- Visual regression testing
- Automated smoke tests

**Integration Benefits:**
- Research → Code → Test workflow stays in Cursor
- No context switching between tools
- Immediate verification of implementations

---

## Lab 10: Team Workflow Design

**Goal:** Design comprehensive team workflows using agentic coding principles  
**Time:** 30-45 minutes  
**Mode:** Self-paced design exercise

### Exercise 1: Team Standards Definition (15 min)

**Define Team Standards:**

1. **Coding Standards:**
   Type:
   ```
      Extended Thinking: "Design comprehensive coding standards for a 
      development team using Spring Boot and modern Java practices."
   ```

2. **Architecture Guidelines:**
   Type:
   ```
      Extended Thinking: "Create architecture guidelines for modular 
      application development including module boundaries and communication patterns."
   ```

3. **Review Process:**
   Type:
   ```
      Extended Thinking: "Design a code review process that incorporates 
      AI assistance while maintaining human oversight."
   ```

### Exercise 2: Workflow Automation (15 min)

**Automate Workflows:**

1. **Feature Development Workflow:**
   Type:
   ```
      Plan Mode: "Design an automated workflow for feature development 
      including planning, implementation, testing, and deployment."
   ```

2. **Bug Fix Workflow:**
   Type:
   ```
      Plan Mode: "Create an automated workflow for bug fixes including 
      triage, analysis, implementation, and verification."
   ```

3. **Release Process:**
   Type:
   ```
      Plan Mode: "Design an automated release process including versioning, 
      testing, documentation, and deployment."
   ```

### Exercise 3: Team Onboarding (15 min)

**Onboarding Process:**

1. **New Developer Setup:**
   Type:
   ```
      Extended Thinking: "Design an onboarding process for new developers 
      that leverages AI assistance for faster productivity."
   ```

2. **Knowledge Transfer:**
   Type:
   ```
      Extended Thinking: "Create a knowledge transfer process that uses 
      AI to help new team members understand existing codebases."
   ```

3. **Mentorship Program:**
   Type:
   ```
      Extended Thinking: "Design a mentorship program that incorporates 
      AI tools for learning and development."
   ```

### Success Criteria

- ✅ Team standards defined and documented
- ✅ Workflow automation designed
- ✅ Onboarding process created
- ✅ Understanding of team collaboration with AI

---

## Bonus Challenges

### Challenge: Multi-Language Support

**Advanced: Add support for multiple programming languages**

1. **Language Analysis:**
   Type:
   ```
      Extended Thinking: "Design an MCP provider that can analyze and 
      generate code in multiple programming languages (Java, Kotlin, Python, JavaScript)."
   ```

2. **Cross-Language Integration:**
   Type:
   ```
      Extended Thinking: "Create a workflow for integrating microservices 
      written in different programming languages."
   ```

### Challenge: AI Model Fine-Tuning

**Advanced: Customize AI behavior for your team**

1. **Team-Specific Training:**
   Type:
   ```
      Extended Thinking: "Design a process for fine-tuning AI models 
      based on your team's coding patterns and preferences."
   ```

2. **Domain-Specific Knowledge:**
   Type:
   ```
      Extended Thinking: "Create a knowledge base that helps AI understand 
      your specific domain and business requirements."
   ```

### Challenge: Continuous Learning

**Advanced: Implement continuous learning workflows**

1. **Feedback Loop:**
   Type:
   ```
      Extended Thinking: "Design a feedback loop that allows AI to learn 
      from code review comments and improve over time."
   ```

2. **Pattern Recognition:**
   Type:
   ```
      Extended Thinking: "Create a system that recognizes successful 
      patterns and suggests them for similar problems."
   ```

---

## Final Reflection

After completing these labs, reflect on:

1. **Agentic Coding Adoption:**
   - How has your approach to development changed?
   - What agentic coding principles do you find most valuable?
   - How do you decide when to use Extended Thinking vs regular Chat?

2. **AI Collaboration:**
   - How do you maintain control while collaborating with AI?
   - What strategies help you get better results from AI?
   - How do you handle AI mistakes or misunderstandings?

3. **Team Integration:**
   - How would you introduce agentic coding to your team?
   - What challenges do you anticipate in team adoption?
   - How would you measure success of agentic coding adoption?

4. **Future Applications:**
   - What other areas could benefit from agentic coding?
   - How might agentic coding evolve in the future?
   - What skills will be most important for developers?

**Document in:** `agentic-coding-reflection.md`

---

## Additional Resources

### Agentic Coding Resources
- [Cursor Documentation - Advanced Features](https://docs.cursor.com)
- [Model Context Protocol Specification](https://modelcontextprotocol.io)
- [AI-Assisted Development Best Practices](https://cursor.com/blog)

### Architecture Patterns
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Modular Monolith](https://www.kamilgrzybek.com/design/modular-monolith-primer/)
- [Spring Boot Best Practices](https://spring.io/guides)

### Team Collaboration
- [Git Workflow Strategies](https://www.atlassian.com/git/tutorials/comparing-workflows)
- [Code Review Best Practices](https://google.github.io/eng-practices/review/)
- [Agile Development with AI](https://cursor.com/blog/agile-ai-development)

### Next Steps
- Session 4: Reviewing and Testing Code with AI
- Apply agentic coding principles to your own projects
- Experiment with Extended Thinking for complex problems
- Explore advanced MCP integrations

---

**Happy Agentic Coding! 🤖🤝👨‍💻**
