# Session 3: Lab Exercises

**Agentic Coding with Cursor**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Agentic Coding Setup](#lab-0-agentic-coding-setup)
2. [Lab 1: Modular Architecture Planning](#lab-1-modular-architecture-planning)
3. [Lab 2: Service Extraction](#lab-2-service-extraction)
4. [Lab 3: Shared Library Creation](#lab-3-shared-library-creation)
5. [Lab 4: Custom Rules and Commands](#lab-4-custom-rules-and-commands)
6. [Lab 5: MCP Integration](#lab-5-mcp-integration)
7. [Lab 6: Legacy Code Review](#lab-6-legacy-code-review)

### Part B: Exploration Exercises (Homework/Practice)
8. [Lab 7: Deep Legacy Code Analysis](#lab-7-deep-legacy-code-analysis)
9. [Lab 8: Advanced MCP Usage](#lab-8-advanced-mcp-usage)
10. [Lab 9: Team Workflow Design](#lab-9-team-workflow-design)

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

### Important: Workspace Setup

**Before starting the labs, open Cursor in the correct workspace:**

1. **Open Cursor**
2. **File → Open Folder** (or Cmd/Ctrl+O)
3. **Navigate to and open:** `session3-agentic/`
4. **Verify:** Your Cursor workspace root should be `session3-agentic/` (not `cursor-java-training/` or `ecommerce-monolith/`)

This is important because:
- The `.cursorrules` file you'll create in Lab 4 needs to be in the workspace root
- Cursor's AI features apply to the entire open workspace
- All labs assume this workspace structure

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

## Lab 4: Custom Rules and Commands

**Goal:** Create and use custom rules for team workflows
**Time:** 15 minutes
**Mode:** Code-along with instructor

### About Custom Rules in Cursor

Cursor supports custom rules to maintain consistency across your team. Rules can be created in several ways:

- **`.cursor/rules/*.mdc`** - Project rules (recommended, official format)
- **`AGENTS.md`** - Simpler markdown format (alternative)
- **`.cursorrules`** - Legacy format (being deprecated)

In this lab, we'll use the **Settings UI** which creates `.mdc` files in `.cursor/rules/`. These files can be version-controlled and shared with your team.

**Important:** Rules should be under 500 lines. Split larger instructions into multiple composable rules.

**Reference:** [Cursor Rules Documentation](https://cursor.com/docs/context/rules)

### Step 1: Create Team Coding Standards (5 min)

1. **Verify Workspace Location**

   **Important:** Ensure Cursor is opened in `session3-agentic/` as your workspace root.
   - Look at the bottom-left of Cursor - it should show `session3-agentic` as the workspace
   - If not, go back to Lab 0 and follow the "Workspace Setup" instructions

2. **Open Cursor Settings**

   **Option A - Settings Panel:**
   - Press **Cmd/Ctrl+,** (or File → Preferences → Settings)
   - Navigate to: **"Rules, Memories, Commands"**
   - You'll see sections for User Rules, Project Rules, and User Commands

   **Option B - Command Palette (Alternative):**
   - Press **Cmd/Ctrl+Shift+P**
   - Type: `New Cursor Rule`
   - Select the command to create a new rule

3. **Add Project Coding Standards**

   In the **Project Rules** section:
   - Click **"+ Add Rule"** (or use the `New Cursor Rule` command)
   - Set **"Apply Intelligently"** (let Cursor decide when to apply)
   - In the description field: "Team coding standards"
   - Add the following content:

   ```markdown
   # Team Coding Standards

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

   - The file will be saved as `.cursor/rules/[name].mdc`

### Step 2: Create Custom Command Rules (5 min)

Create three more rules for common tasks:

1. **Security Review Rule**

   - Click **"+ Add Rule"** in Project Rules
   - Set **"Apply Intelligently"**
   - Description: "Security review guidelines"
   - Content:
   ```markdown
   When asked to review security:
   Review this code for security vulnerabilities including SQL injection,
   XSS, authentication bypass, and data exposure risks. Provide specific
   recommendations with examples.
   ```

2. **Test Generation Rule**

   - Click **"+ Add Rule"**
   - Set **"Apply Intelligently"**
   - Description: "Test generation standards"
   - Content:
   ```markdown
   When asked to generate tests:
   Generate comprehensive unit and integration tests for this class using
   JUnit 5, Mockito, and TestContainers. Include edge cases and error scenarios.
   ```

3. **Module Creation Rule**

   - Click **"+ Add Rule"**
   - Set **"Apply Intelligently"**
   - Description: "Module creation pattern"
   - Content:
   ```markdown
   When asked to create a module:
   Create a new Spring Boot module following our architecture patterns:
   entity, repository, service, controller, and tests. Use shared library
   components where appropriate.
   ```

4. **Verify Rules are Saved**

   Check your file system - you should see:
   ```
   session3-agentic/
   ├── .cursor/
   │   └── rules/
   │       ├── [coding-standards].mdc
   │       ├── [security-review].mdc
   │       ├── [test-generation].mdc
   │       └── [module-creation].mdc
   ├── ecommerce-monolith/
   └── labs.md
   ```

### Step 3: Test Your Rules (5 min)

**Note:** The rules you created will be intelligently applied by Cursor when relevant, or you can explicitly reference them in your prompts.

1. **Test Security Review Rule**

   **Open the file:**
   `ecommerce-monolith/src/main/java/com/example/ecommerce/controller/UserController.java`

   **Chat Mode (Cmd/Ctrl+L):** Type:
   ```
   Please review this controller for security vulnerabilities.
   ```
   **Expected:** Cursor should apply your security review rule and provide detailed analysis

2. **Test Test Generation Rule**

   **Open the file:**
   `ecommerce-monolith/src/main/java/com/example/ecommerce/service/UserService.java`

   **Chat Mode (Cmd/Ctrl+L):** Type:
   ```
   Generate tests for this service.
   ```
   **Expected:** Tests using JUnit 5, Mockito, and TestContainers (as specified in your rule)

3. **Test Coding Standards Rule**

   **Chat Mode (Cmd/Ctrl+L):** Type:
   ```
   What coding standards should I follow in this project?
   ```
   **Expected:** Cursor should reference your team coding standards rule

### Understanding How Rules Work

**Rule Files Structure:**
- Rules are stored as `.mdc` files in `.cursor/rules/`
- MDC format supports metadata and content
- Each file has YAML frontmatter: `alwaysApply: false` (or `true`)
- **"Apply Intelligently"** = `alwaysApply: false` (Cursor decides when to use)
- **"Always Apply"** = `alwaysApply: true` (included in every chat)
- Keep rules **under 500 lines** - split larger rules into multiple files

**Rule Application Modes:**
- **Always Apply** - Applies to every chat session
- **Apply Intelligently** - Activated when Cursor deems it relevant (recommended)
- **Apply to Specific Files** - Triggered by glob pattern matching
- **Apply Manually** - Activated via @-mentions in chat

**Version Control:**
- Commit `.cursor/rules/` directory to git
- Team members get the same rules when they clone the repo
- Everyone maintains consistency
- Team/Enterprise plans can enforce rules across the organization

**Alternative Format:**
- You can also create an `AGENTS.md` file in your project root
- Simpler markdown format without metadata overhead
- Good for straightforward instructions

### Success Criteria

- ✅ Project rules created via Settings UI
- ✅ Rules visible in Settings → Rules, Memories, Commands
- ✅ `.cursor/rules/*.mdc` files exist in file system
- ✅ AI applies rules intelligently in chat
- ✅ Understanding of team workflow automation

### Key Insights

- Settings UI creates `.cursor/rules/*.mdc` files automatically
- Rules can be committed to version control for team sharing
- "Apply Intelligently" mode lets Cursor decide when rules are relevant
- Multiple team members can add their own rules
- Great for ensuring consistency in generated code across the team

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

### How MCP Servers Work in Cursor

**Important:** You don't need special syntax to use MCP servers. Just chat naturally!

- **Natural conversation:** Ask questions normally, and Cursor's Composer Agent automatically decides when to use MCP tools
- **Or mention by name:** "Use Context7 to look up..." or "Use Playwright to test..."
- **Available Tools:** You'll see a list of available MCP tools in the chat interface
- **Approval required:** By default, Cursor asks for approval before using MCP tools
- **Toggle tools:** Click tool names to enable/disable them for a chat session

**Reference:** [Cursor MCP Documentation](https://cursor.com/docs/context/mcp)

### Step 1: Context7 for Documentation (10 min)

**Use Case:** Look up Spring Boot best practices while refactoring

1. **Query Spring Boot Validation**

   **Composer Chat (Cmd/Ctrl+I or Cmd/Ctrl+Shift+L):**
   Type:
   ```
   What are the current best practices for input validation in Spring Boot 3.x?
   Show me examples using Jakarta validation annotations.
   ```

   **What Happens:**
   - Cursor's Composer Agent sees "Spring Boot 3.x" and may suggest using Context7
   - You'll see Context7 appear in the "Available Tools" list
   - Click to approve Context7 usage
   - Context7 fetches up-to-date Spring Boot 3.x documentation

   **Expected Response:**
   - Current Spring Boot 3.x validation patterns
   - `@Valid`, `@NotNull`, `@Email` examples
   - Code snippets you can use immediately

2. **Research REST API Best Practices**

   **Composer Chat:**
   Type:
   ```
   Use Context7 to find REST API best practices for Spring Boot controllers.
   Include error handling, status codes, and response formatting.
   ```

   **Note:** By explicitly mentioning "Use Context7", you guide the Agent to use that tool.

   **Expected Response:**
   - Current REST conventions
   - `ResponseEntity` usage patterns
   - Exception handling strategies
   - HTTP status code guidelines

3. **Look Up JPA Relationships**

   **Composer Chat:**
   Type:
   ```
   Show me best practices for JPA entity relationships in Spring Boot,
   including @OneToMany, @ManyToOne, and cascade operations.
   ```

   **Note:** You can ask naturally without mentioning Context7—the Agent decides if it's helpful.

   **Why This Matters:**
   - Get up-to-date documentation without leaving Cursor
   - Find current best practices (not outdated Stack Overflow posts)
   - See actual code examples you can adapt
   - No need to remember special syntax

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

   **Composer Chat:**
   Type:
   ```
   Use Playwright to navigate to http://localhost:8080/api/users and capture
   what you see. Then navigate to http://localhost:8080/h2-console and
   take a screenshot.
   ```

   **What Happens:**
   - Cursor asks for approval to use Playwright
   - Playwright tool appears in "Available Tools"
   - After approval, Playwright opens browser
   - Navigates to endpoints
   - Captures responses/screenshots
   - Reports what it found

3. **Verify Application is Working**

   **Composer Chat:**
   Type:
   ```
   Navigate to http://localhost:8080/api/products and verify the endpoint
   returns a 200 status code. Show me the response structure.
   ```

   **Note:** You can ask naturally—Cursor will suggest Playwright if appropriate.

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
   How do I add CORS configuration to Spring Boot?
   ```

   (Cursor may use Context7 automatically, or you can say "Use Context7 to look up...")

2. **Implement the CORS configuration** in your code

3. **Test with Playwright:**
   ```
   Test that CORS headers are present in the response from
   http://localhost:8080/api/users
   ```

   (Cursor will suggest using Playwright for browser-based testing)

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
- No special syntax required—just natural conversation
- Cursor's Composer Agent intelligently decides when to use tools
- You maintain control with approval prompts (by default)

---

## Lab 6: Legacy Code Review

**Goal:** Conduct AI-assisted code review of legacy code and identify modernization opportunities
**Time:** 20-25 minutes
**Mode:** Code-along with instructor

### About This Lab

This lab introduces the **legacy-app** - an older Java application with typical legacy code issues. You'll use AI to identify problems and suggest improvements.

### Step 1: Explore the Legacy Codebase (5 min)

1. **Review the Legacy Application Structure**

   **Browse the legacy-app directory:**
   ```
   legacy-app/
   ├── src/main/java/com/legacy/
   │   ├── controllers/
   │   │   ├── CustomerController.java
   │   │   └── ItemController.java
   │   ├── services/
   │   │   ├── CustomerService.java
   │   │   └── ItemService.java
   │   ├── repositories/
   │   │   ├── CustomerRepo.java
   │   │   └── ItemRepo.java
   │   ├── models/
   │   │   ├── Customer.java
   │   │   └── Item.java
   │   └── utils/
   │       ├── NumberUtil.java
   │       └── StringHelper.java
   ├── src/main/resources/
   └── build.gradle
   ```

2. **Open Key Files for Review**

   **Open these files in your editor:**
   - `legacy-app/src/main/java/com/legacy/controllers/CustomerController.java`
   - `legacy-app/src/main/java/com/legacy/services/CustomerService.java`
   - `legacy-app/src/main/java/com/legacy/repositories/CustomerRepo.java`
   - `legacy-app/src/main/java/com/legacy/models/Customer.java`

   **Why:** Having files open helps Cursor understand the full context of what to review.

### Step 2: Comprehensive Legacy Code Review (10 min)

1. **AI-Assisted Review**

   **Composer Chat (Cmd/Ctrl+I):**
   Type:
   ```
   Conduct a comprehensive code review of the legacy-app Customer module.
   This is legacy code that needs modernization. Analyze:
   - Code quality and outdated patterns
   - Security vulnerabilities
   - Performance issues
   - Deprecated APIs or libraries
   - Naming conventions and organization
   - Missing error handling
   - Testing gaps

   Provide specific recommendations with examples of modern alternatives.
   ```

2. **Review AI Analysis**

   **Expected Issues Found:**
   - **Outdated patterns:** Old Java patterns, pre-Java 8 code
   - **Naming issues:** Inconsistent names (e.g., "Repo" vs "Repository")
   - **Security vulnerabilities:** SQL injection, missing validation
   - **Performance problems:** N+1 queries, missing caching
   - **Missing features:** No logging, error handling, tests
   - **Deprecated APIs:** Old Spring or Java APIs
   - **Code organization:** Poor separation of concerns

3. **Examine Specific Recommendations**

   **Ask follow-up questions:**
   ```
   What are the top 3 most critical issues in this code that should
   be addressed first?
   ```

   ```
   Show me examples of how to modernize the CustomerService to use
   Java 17+ features and Spring Boot best practices.
   ```

### Step 3: Prioritize Improvements (5 min)

1. **Create Modernization Plan**

   **Composer Chat:**
   Type:
   ```
   Based on the code review, create a prioritized modernization plan
   for the legacy-app. Group improvements into:
   1. Critical (security, data integrity)
   2. High Priority (performance, major bugs)
   3. Medium Priority (code quality, maintainability)
   4. Low Priority (nice-to-have improvements)
   ```

2. **Review the Plan**

   **Expected Prioritization:**
   - **Critical:** SQL injection fixes, authentication issues
   - **High:** Exception handling, input validation, logging
   - **Medium:** Naming consistency, code organization, documentation
   - **Low:** Code style, minor refactoring, optional features

### Success Criteria

- ✅ Legacy code review completed
- ✅ Multiple types of issues identified (security, performance, quality)
- ✅ Understanding of difference between modern and legacy code
- ✅ Prioritized modernization plan created
- ✅ Recognition of AI's value in legacy code analysis

---

## 🎉 Checkpoint: Agentic Coding Complete!

**Congratulations!** You now have:

- ✅ Understanding of agentic coding principles
- ✅ Experience with Extended Thinking mode
- ✅ Plan Mode for complex projects
- ✅ Custom rules for team workflows
- ✅ MCP integration capabilities
- ✅ AI-assisted code review skills for legacy code

**Now explore the additional exercises at your own pace!**

---

## Part B: Exploration Exercises (Homework/Practice)

These exercises help you practice applying agentic coding principles to real-world scenarios. Complete them at your own pace.

---

## Lab 7: Deep Legacy Code Analysis

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

## Lab 8: Advanced MCP Usage

**Goal:** Master advanced Context7 and Playwright workflows
**Time:** 30-45 minutes
**Mode:** Self-paced exploration

### Exercise 1: Advanced Context7 Usage (20 min)

**Multi-Library Research:**

1. **Compare Libraries:**
   **Composer Chat:**
   ```
   Use Context7 to compare Hibernate vs Spring Data JPA for entity management.
   What are the trade-offs and when would you use each?
   ```

2. **Version-Specific Features:**
   **Composer Chat:**
   ```
   Use Context7 to find what's new in Spring Boot 3.5 compared to 3.2.
   Show me migration steps and new features I should use.
   ```

3. **Security Best Practices:**
   **Composer Chat:**
   ```
   What are the current Spring Security best practices for REST APIs?
   Include JWT, OAuth2, and CORS configuration examples.
   ```
   (Cursor may suggest Context7 automatically for up-to-date docs)

4. **Performance Optimization:**
   **Composer Chat:**
   ```
   How do I optimize Spring Boot application startup time?
   Show me lazy initialization, conditional beans, and other techniques.
   ```

**Why This Matters:**
- Research multiple related topics quickly
- Get version-specific information
- Find current best practices without outdated blogs

### Exercise 2: Advanced Playwright Workflows (15 min)

**Comprehensive Application Testing:**

1. **End-to-End User Flow:**
   **Composer Chat:**
   ```
   Test this user workflow on http://localhost:8080:
   1. Navigate to /api/users
   2. Check that the response is valid JSON
   3. Navigate to /api/products
   4. Verify products are returned
   5. Take screenshots at each step
   ```
   (Cursor will suggest using Playwright for browser-based testing)

2. **Performance Testing:**
   **Composer Chat:**
   ```
   Measure page load times for the following endpoints:
   - /api/users
   - /api/products
   - /api/orders
   Report any endpoints slower than 500ms
   ```

3. **Visual Regression:**
   **Composer Chat:**
   ```
   Take screenshots of the H2 console at http://localhost:8080/h2-console
   and save them with timestamps so I can compare across sessions.
   ```

**Why This Matters:**
- Automated acceptance testing
- Performance monitoring
- Visual change detection

### Exercise 3: Combined Workflows (10 min)

**Research → Implement → Test Cycle:**

1. **Research with Context7:**
   **Composer Chat:**
   ```
   How do I add pagination to Spring Data JPA repositories?
   Show me examples with PageRequest and Pageable.
   ```
   (Mention Context7 or let Cursor suggest it)

2. **Implement the pagination** in your ProductService

3. **Test with Playwright:**
   **Composer Chat:**
   ```
   Test the paginated product endpoint at
   http://localhost:8080/api/products?page=0&size=10
   Verify pagination metadata is present in the response.
   ```

4. **Verify Documentation:**
   **Composer Chat:**
   ```
   Generate OpenAPI documentation example for a paginated endpoint
   with page, size, and sort parameters.
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

## Lab 9: Team Workflow Design

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
