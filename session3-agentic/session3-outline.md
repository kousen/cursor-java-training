# Session 3: Agentic Coding with Cursor

**Duration:** 3 hours  
**Audience:** ~100 experienced developers (Java/Android background from Sessions 1-2)  
**Format:** Instructor-led with hands-on exercises  
**Prerequisite:** Completion of Sessions 1-2 or equivalent Cursor experience

## Session Objectives

By the end of this session, participants will be able to:
- Apply agentic coding principles using Cursor's advanced AI capabilities
- Use Extended Thinking mode for complex problem-solving
- Implement Plan Mode for multi-step architectural changes
- Create custom slash commands for team workflows
- Leverage Model Context Protocol (MCP) for external tool integration
- Conduct AI-assisted code reviews and refactoring sessions
- Design collaborative AI workflows for team development

## Two-Project Approach

### Project 1: E-Commerce Application Refactoring (Code-Along)
**Purpose:** Demonstrate agentic coding principles with local tools  
**Duration:** ~140 minutes (Parts 1-6)  
**Approach:** Instructor-led, students follow along  
**Deliverable:** Monolithic Spring Boot app refactored into modular architecture

**Key Technologies (All Local):**
- Spring Boot with modular structure
- Docker Compose for local services (PostgreSQL, Redis, Mock services)
- H2 Database for development
- Spring Cloud Gateway (embedded)
- Mock external services (payment, email)
- Shared libraries and common utilities

### Project 2: Legacy Code Modernization (Exploration)
**Purpose:** Apply agentic coding to real-world scenarios  
**Duration:** ~30 minutes intro + homework  
**Approach:** Guided exploration, deeper practice in labs  
**Repository:** Custom legacy Java application (provided)

---

## Detailed Timeline

### Part 1: Agentic Coding Foundations (30 minutes)

#### Welcome & Session 3 Overview (5 min)
- Recap Sessions 1-2: Chat, Agent, Composer modes
- Session 3 focus: **Agentic Coding** - AI as a collaborative partner
- The paradigm shift: from tool to co-agent
- Two-project approach explanation
- Today's deliverables: modular e-commerce architecture

#### Understanding Agentic Coding (15 min)
- **Traditional Development:**
  - Developer writes code line by line
  - AI assists with individual tasks
  - Sequential, manual process
  - AI as helpful tool
  - Task-focused interaction
  
- **Agentic Development:**
  - Developer defines high-level goals
  - AI collaborates on planning and execution
  - Iterative, collaborative process
  - AI as thinking partner
  - Goal-oriented interaction

- **Key Principles:**
  - **Goal-Oriented:** Define **what** you want, not **how** to do it
  - **Iterative:** Plan → Execute → Review → Refine
  - **Collaborative:** AI as thinking partner, not just code generator
  - **Context-Aware:** AI understands entire system, not just files

#### Extended Thinking Mode (10 min)
- **What is Extended Thinking?**
  - AI takes time to reason through complex problems
  - Multi-step analysis and planning
  - Deeper understanding before code generation
  - Like having a senior developer think through architecture
  
- **When to Use:**
  - Architectural decisions
  - Complex refactoring projects
  - Performance optimization strategies
  - Security analysis
  - Legacy code modernization

**Checkpoint:** Understanding of agentic coding principles

---

### Part 2: Plan Mode for Complex Changes (35 minutes)

#### Introduction to Plan Mode (10 min)
- **What is Plan Mode?**
  - AI creates step-by-step implementation plans
  - Multi-file, multi-phase changes
  - Reviewable and modifiable plans
  - Executable in phases
  
- **When to Use Plan Mode:**
  - Large refactoring projects
  - Architecture migrations
  - Feature additions across multiple modules
  - Breaking changes that affect multiple components
  - Team coordination on complex tasks

#### Demo: Planning Modular Refactoring (15 min)
- **Starting Point:** Monolithic e-commerce Spring Boot application
- **Goal:** Refactor into modular architecture with clear boundaries

- **Step 1: Analysis Phase**
  ```
  Plan Mode: "Analyze this monolithic e-commerce application and create a 
  plan to refactor it into modular architecture. Identify module boundaries, 
  shared dependencies, and refactoring phases."
  ```
  
- **Review Generated Plan:**
  - **Module Identification:** User, Product, Order, Payment, Common
  - **Shared Dependencies:** Database, utilities, configurations
  - **Refactoring Phases:** 4-6 phases with dependencies
  - **Risk Assessment:** Potential issues and mitigation strategies

- **Step 2: Refinement**
  ```
  Plan Mode: "Modify the plan to prioritize User module first, 
  include local Docker services, and add comprehensive testing strategy."
  ```

#### Student Exercise: Plan Review (10 min)
- Students review the generated plan
- Use Chat mode to ask questions about specific phases
- Suggest modifications to the plan
- Understand the planning process

**Checkpoint:** Understanding of Plan Mode capabilities

---

### Part 3: Executing Complex Plans (40 minutes)

#### Phase 1: Module Extraction (20 min)

- **Execute Plan Phase 1:**
  ```
  Plan Mode: "Execute Phase 1: Extract User module from the monolith.
  Create separate User module with its own package structure, 
  entities, and API endpoints."
  ```
  
- **Review Changes:**
  - New User module structure
  - User entity and repository
  - User API endpoints
  - Module dependencies
  - Shared library setup

- **Student Exercise:**
  - Review generated User module
  - Test API endpoints
  - Understand module boundaries

#### Phase 2: Shared Library Creation (20 min)

- **Execute Plan Phase 2:**
  ```
  Plan Mode: "Execute Phase 2: Create shared library for common 
  utilities, DTOs, and configurations used across modules."
  ```
  
- **Review Changes:**
  - Common DTOs and utilities
  - Shared configuration classes
  - Database connection management
  - Error handling utilities

- **Integration Testing:**
  - Test module communication
  - Verify shared library usage
  - Check dependency management

**Checkpoint:** Working modular architecture foundation

---

### BREAK (10 minutes)

---

### Part 4: Advanced AI Collaboration Patterns (35 minutes)

#### Custom Slash Commands (15 min)

- **What are Slash Commands?**
  - Reusable prompt templates
  - Team-standardized AI interactions
  - Context-aware shortcuts
  - Consistent code generation

- **Creating Team Commands:**
  ```
  /review-security: "Review this code for security vulnerabilities including 
  SQL injection, XSS, authentication bypass, and data exposure risks."
  
  /generate-tests: "Generate comprehensive unit and integration tests for 
  this class using JUnit 5, Mockito, and TestContainers."
  
  /refactor-legacy: "Modernize this legacy code using current best practices: 
  replace deprecated APIs, improve error handling, add proper logging."
  
  /create-module: "Create a new Spring Boot module following our architecture 
  patterns: entity, repository, service, controller, and tests."
  ```

- **Demo: Using Custom Commands**
  - Apply `/review-security` to User module
  - Use `/generate-tests` for API endpoints
  - Apply `/refactor-legacy` to old utility classes
  - Use `/create-module` for Product module

#### Iterative Refinement Workflows (20 min)

- **The Refinement Cycle:**
  1. **Generate:** Initial AI output
  2. **Review:** Human evaluation
  3. **Refine:** Specific improvement requests
  4. **Iterate:** Repeat until satisfied

- **Demo: API Design Refinement**
  ```
  Initial: "Create REST API for product management"
  
  Review: "The API needs pagination, filtering, and proper error responses"
  
  Refinement: "Add pagination with page/size parameters, filtering by category/price, 
  and structured error responses with proper HTTP status codes"
  
  Iteration: "Include OpenAPI documentation and validation examples"
  ```

- **Student Exercise:**
  - Generate initial code for Product module
  - Review and identify improvements
  - Use refinement prompts to enhance
  - Iterate until satisfied

**Checkpoint:** Advanced AI collaboration patterns

---

### Part 5: Model Context Protocol (MCP) Integration (30 minutes)

#### Understanding MCP (10 min)

- **What is MCP?**
  - Protocol for AI to interact with external tools
  - Extends AI capabilities beyond code
  - Enables tool integration and automation
  - Custom context providers

- **Common MCP Integrations:**
  - Database schema analysis
  - API documentation generation
  - Performance monitoring
  - Security scanning
  - Documentation generation

#### Demo: Database Schema Integration (10 min)

- **Setup MCP Database Provider:**
  ```
  MCP: "Connect to the e-commerce database and analyze the schema.
  Generate entity classes and repository interfaces based on actual tables.
  Include proper JPA annotations and relationships."
  ```

- **Review Generated Code:**
  - Entity classes match actual database schema
  - Repository methods based on table relationships
  - Proper JPA annotations and constraints
  - Relationship mappings

#### Demo: API Documentation Generation (10 min)

- **Generate OpenAPI Documentation:**
  ```
  MCP: "Analyze all REST endpoints in the e-commerce application and generate 
  comprehensive OpenAPI 3.0 documentation with examples and schemas."
  ```

- **Review Generated Documentation:**
  - Complete API specification
  - Request/response examples
  - Schema definitions
  - Interactive documentation
  - Validation rules

**Checkpoint:** MCP integration capabilities

---

### Part 6: AI-Assisted Code Review and Quality (25 minutes)

#### Collaborative Code Review (15 min)

- **AI as Review Partner:**
  ```
  Extended Thinking: "Conduct a comprehensive code review of the User module.
  Analyze code quality, architecture, security, performance, and maintainability.
  Provide specific recommendations with examples."
  ```

- **Review Categories:**
  - **Architecture:** Module boundaries, dependencies
  - **Security:** Authentication, authorization, data protection
  - **Performance:** Database queries, caching, scalability
  - **Maintainability:** Code organization, documentation, testing
  - **Best Practices:** Spring Boot conventions, error handling

#### Automated Quality Improvements (10 min)

- **Batch Refactoring:**
  ```
  Plan Mode: "Apply all recommended improvements from the code review.
  Focus on security enhancements, performance optimizations, and 
  code organization improvements."
  ```

- **Review Applied Changes:**
  - Security improvements (input validation, SQL injection prevention)
  - Performance optimizations (caching, query optimization)
  - Code organization (package structure, naming conventions)
  - Error handling enhancements
  - Documentation improvements

**Checkpoint:** AI-assisted quality improvement

---

### BREAK (10 minutes)

---

### Part 7: Team Collaboration Workflows (25 minutes)

#### Shared AI Context (10 min)

- **Team Context Management:**
  - Shared `.cursorrules` files
  - Team coding standards
  - Architecture documentation
  - Common patterns and anti-patterns

- **Demo: Team Standards**
  ```
  .cursorrules: "This project follows Clean Architecture principles.
  Use dependency injection, implement proper error handling, include 
  comprehensive tests, and follow REST API best practices.
  Modules should be loosely coupled and highly cohesive."
  ```

#### Collaborative Development Patterns (15 min)

- **Feature Branch Workflow:**
  1. **Planning:** Use Plan Mode for feature design
  2. **Development:** Iterative AI collaboration
  3. **Review:** AI-assisted code review
  4. **Integration:** Automated testing and deployment

- **Demo: Team Feature Development**
  ```
  Plan Mode: "Design and implement an Order module that integrates 
  with User and Product modules. Include order processing, inventory 
  management, and email notifications."
  ```

- **Review Process:**
  - AI-generated test cases
  - Automated security scanning
  - Performance analysis
  - Documentation generation

**Checkpoint:** Team collaboration patterns

---

### Part 8: Legacy Code Modernization Introduction (15 minutes)

#### Exploring Legacy Codebase (15 min)

**Demo: Legacy Analysis**
- Open provided legacy Java application
- **Extended Thinking Analysis:**
  ```
  Extended Thinking: "Analyze this legacy Java application and create a 
  modernization strategy. Identify technical debt, security issues, 
  performance bottlenecks, and migration opportunities."
  ```

- **Review Analysis:**
  - Technical debt identification
  - Security vulnerability assessment
  - Performance bottleneck analysis
  - Modernization roadmap

**Student Guided Exploration (5 min):**
Students use Extended Thinking to explore:
1. "What are the main architectural issues in this codebase?"
2. "How would you prioritize modernization efforts?"
3. "What risks should be considered during migration?"

---

### Wrap-Up & Next Steps (10 minutes)

#### Key Takeaways (5 min)

**Agentic Coding Decision Tree:**
```
Complex architectural decision? → Use Extended Thinking
Multi-phase project? → Use Plan Mode
Repetitive tasks? → Create Slash Commands
External tool integration? → Use MCP
Team collaboration? → Establish shared context
Code quality? → AI-assisted review
```

**What We Accomplished:**
- ✅ Modular architecture refactoring using Plan Mode
- ✅ Advanced AI collaboration patterns
- ✅ Custom slash commands for team workflows
- ✅ MCP integration for external tools
- ✅ AI-assisted code review and quality improvement
- ✅ Team collaboration workflows

#### Preview Session 4 (3 min)

**Reviewing and Testing Code with AI**
- Automated test generation strategies
- AI-powered debugging and troubleshooting
- Performance analysis and optimization
- Security vulnerability assessment
- Code coverage and quality metrics

#### Q&A (2 min)
- Advanced AI workflow questions
- Team adoption strategies
- Custom tool integration

---

## Materials Provided

### Pre-Session
- Session 1-2 recap document
- Agentic Coding principles guide
- Legacy codebase for exploration
- MCP setup instructions
- Team collaboration checklist

### During Session
- This session outline
- Slidev presentation
- E-commerce starter project (monolithic)
- Legacy codebase for analysis
- Custom slash command templates

### Post-Session
- Complete labs.md with all exercises
- Legacy modernization challenges
- Team workflow templates
- MCP integration guides
- Session 4 preview materials

---

## Success Metrics

Students should leave able to:
- [ ] Apply agentic coding principles to complex problems
- [ ] Use Extended Thinking mode for architectural decisions
- [ ] Create and execute multi-phase plans with Plan Mode
- [ ] Develop custom slash commands for team workflows
- [ ] Integrate MCP for external tool connectivity
- [ ] Conduct AI-assisted code reviews and quality improvements
- [ ] Design collaborative AI workflows for team development
- [ ] Apply agentic coding to legacy code modernization

---

## Instructor Notes

### Timing Buffers
- Breaks provide 20 min catch-up time
- Can compress MCP section if needed
- Modular refactoring must be completed
- Legacy analysis can be shortened if running behind

### Common Issues & Solutions
- **Extended Thinking taking too long:** Set expectations, use for complex problems only
- **Plan Mode overwhelming:** Start with simple plans, build complexity gradually
- **MCP setup issues:** Have backup demos ready, focus on concepts over implementation
- **Students confused about when to use each mode:** Reinforce decision tree throughout
- **Team workflow adoption:** Emphasize gradual adoption, start with individual use

### Adaptation Points
- If ahead: Add more modules, explore advanced MCP integrations
- If behind: Focus on core agentic principles, simplify modular example
- If questions: Use Extended Thinking to explore answers together
- If students struggle with concepts: More Chat mode explanations, simpler examples

### Demo Tips
- **Always explain the thinking process** before using Extended Thinking
- **Show plan modification** - plans are living documents
- **Demonstrate iteration** - first output is rarely perfect
- **Highlight collaboration** - AI as partner, not replacement
- **Use real examples** - avoid toy problems
- **Show mistakes and recovery** - AI makes errors too
- **Emphasize human oversight** - AI assists, humans decide

---

## Project: E-Commerce Modular Architecture

### Architecture Overview
1. **User Module**
   - User management and authentication
   - Profile management
   - Role-based access control

2. **Product Module**
   - Product catalog management
   - Category management
   - Inventory tracking

3. **Order Module**
   - Order processing
   - Order history
   - Status management

4. **Payment Module**
   - Payment processing (mock)
   - Transaction history
   - Refund handling

5. **Common Library**
   - Shared DTOs and utilities
   - Database configurations
   - Error handling
   - Validation

### Local Services (Docker Compose)
```yaml
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: ecommerce
      POSTGRES_USER: ecommerce
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
  
  redis:
    image: redis:7
    ports:
      - "6379:6379"
  
  mock-payment-service:
    image: mockserver/mockserver
    ports:
      - "1080:1080"
    environment:
      MOCKSERVER_INITIALIZATION_JSON_PATH: /config/mock-payment.json

volumes:
  postgres_data:
```

### Refactoring Phases
1. **Phase 1:** Extract User module
2. **Phase 2:** Create shared library
3. **Phase 3:** Extract Product module
4. **Phase 4:** Extract Order module
5. **Phase 5:** Extract Payment module
6. **Phase 6:** Integration and testing

---

## Progression from Sessions 1-2

### Building on Previous Sessions

| Session 1-2 (Individual AI) | Session 3 (Agentic AI) |
|------------------------------|-------------------------|
| Chat for understanding | Extended Thinking for complex analysis |
| Agent for code generation | Plan Mode for multi-phase projects |
| Composer for multi-file changes | Custom commands for team workflows |
| Manual AI interaction | Automated AI collaboration |
| Single-developer focus | Team collaboration patterns |
| Code generation | Architecture and planning |

### Same AI Principles, Advanced Application
- Natural language as interface
- Iterative refinement
- Context awareness
- Human-AI collaboration
- Quality verification

### New Agentic-Specific Skills
- High-level goal definition
- Multi-step planning and execution
- Team workflow design
- External tool integration
- Automated quality processes
- Legacy modernization strategies

---

## Lab Preview (labs-session3.md)

### Part A: Code-Along (In-Class)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 0 | Agentic Coding Setup | 10 min | Extended Thinking, Plan Mode |
| 1 | Modular Architecture Planning | 20 min | Plan Mode, architecture analysis |
| 2 | Service Extraction | 25 min | Plan execution, service boundaries |
| 3 | Shared Library Creation | 20 min | Common utilities, module integration |
| 4 | Custom Slash Commands | 15 min | Team workflows, reusable prompts |
| 5 | MCP Integration | 20 min | External tools, database analysis |
| 6 | AI Code Review | 15 min | Quality analysis, automated improvements |
| 7 | Team Collaboration | 15 min | Shared context, collaborative patterns |

**Total In-Class Time:** ~140 minutes (2h 20m)

### Part B: Exploration (Homework)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 8 | Legacy Code Analysis | 45-60 min | Extended Thinking, modernization |
| 9 | Advanced MCP Integration | 30-45 min | Custom tools, automation |
| 10 | Team Workflow Design | 30-45 min | Collaboration patterns, standards |

**Total Homework Time:** ~2-3 hours

---

## Resources and Links

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

**Session 3 outline complete and ready for material development! 🚀**
