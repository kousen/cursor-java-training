---
theme: seriph
class: text-center
highlighter: shiki
lineNumbers: true
info: |
  ## Agentic Coding with Cursor
  
  By Kenneth Kousen
  
  Session 3 of Cursor for Java Developers training series
drawings:
  persist: false
transition: slide-left
title: "Agentic Coding with Cursor"
mdc: true
---

# Agentic Coding with Cursor

<div class="pt-12">
  <span @click="$slidev.nav.next" class="px-2 py-1 rounded cursor-pointer" hover="bg-white bg-opacity-10">
    AI as Your Collaborative Partner <carbon:arrow-right class="inline"/>
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <button @click="$slidev.nav.openInEditor()" title="Open in Editor" class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <carbon:edit />
  </button>
</div>

---

# Contact Info

Ken Kousen<br>
Kousen IT, Inc.

- ken.kousen@kousenit.com
- http://www.kousenit.com
- http://kousenit.org (blog)
- Social Media:
  - [@kenkousen](https://twitter.com/kenkousen) (Twitter)
  - [@kousenit.com](https://bsky.app/profile/kousenit.com) (Bluesky)
  - [https://www.linkedin.com/in/kenkousen/](https://www.linkedin.com/in/kenkousen/) (LinkedIn)
- *Tales from the jar side* (free newsletter)
  - https://kenkousen.substack.com
  - https://youtube.com/@talesfromthejarside

---

# Course Overview: 5 Sessions

<v-clicks>

1. **Using Cursor for Java Development** (Session 1 - Complete)
   - Understanding code, navigation, generation, testing
2. **Using Cursor for Mobile Development** (Session 2 - Complete)
   - Android/Kotlin with AI assistance
3. **Agentic Coding with Cursor** (Today - 3 hours)
   - AI as collaborative partner for complex projects
4. **Reviewing and Testing Code** (3 hours)
   - Quality assurance with AI
5. **Exploring Agents and MCP** (3 hours)
   - Model Context Protocol and advanced features

</v-clicks>

---

# Today's Session: What We'll Cover

<v-clicks>

- **Agentic Coding Principles** - AI as collaborative partner, not just tool
- **Extended Thinking Mode** - Complex problem analysis and planning
- **Plan Mode** - Multi-phase project execution with AI
- **Custom Rules and Commands** - Team workflow automation
- **MCP Integration** - External tool connectivity
- **Legacy Code Review** - AI-assisted modernization analysis

</v-clicks>

---

# Two Projects Today

<v-clicks>

## Project 1: E-Commerce Modular Refactoring
Build together from scratch - refactor monolithic app into modular architecture:
- User Module (authentication, profiles)
- Product Module (catalog, inventory)
- Order Module (processing, history)
- Payment Module (transactions, refunds)
- Shared Library (common utilities)

## Project 2: Legacy Code Modernization
Apply agentic coding to real-world legacy systems

</v-clicks>

---
layout: two-cols
---

# Sessions 1-2 Recap

## What You Learned

<v-clicks>

- **Chat Mode** (Cmd/Ctrl+L)
  - Ask questions
  - Understand code
  - Learn APIs

- **Agent Mode** (Cmd/Ctrl+I)
  - Generate code
  - Refactor
  - Single-file edits

- **Composer Mode** (Cmd/Ctrl+Shift+I)
  - Multi-file generation
  - Full codebase context
  - Complex features

</v-clicks>

::right::

# Today: Agentic Coding

## The Next Level

<v-clicks>

- **Extended Thinking** - Deep analysis and planning
- **Plan Mode** - Multi-phase project execution
- **Custom Rules** - Team workflow automation with `.cursor/rules/`
- **MCP Integration** - External tool connectivity (natural language)
- **AI Collaboration** - Partner, not just assistant

**Key Shift:** From AI as tool to AI as collaborative partner

</v-clicks>

---

# Part 1: Agentic Coding Foundations

## The Paradigm Shift

---

# Traditional vs Agentic Development

<div class="grid grid-cols-2 gap-8">
<div>

## Traditional Development

<v-clicks>

- Developer writes code line by line
- AI assists with individual tasks
- Sequential, manual process
- AI as helpful tool
- Task-focused interaction

</v-clicks>

</div>
<div>

## Agentic Development

<v-clicks>

- Developer defines high-level goals
- AI collaborates on planning and execution
- Iterative, collaborative process
- AI as thinking partner
- Goal-oriented interaction

</v-clicks>

</div>
</div>

---

# Agentic Coding Principles

<v-clicks>

## 1. Goal-Oriented
Define **what** you want, not **how** to do it
- ❌ "Add a for loop here"
- ✅ "Process all orders and update their status"

## 2. Iterative
Plan → Execute → Review → Refine
- Continuous improvement cycle
- AI learns from feedback

</v-clicks>

---

# Agentic Coding Principles (Continued)

<v-clicks>

## 3. Collaborative
AI as thinking partner, not just code generator
- Architectural discussions
- Design pattern suggestions
- Problem-solving partnership

## 4. Context-Aware
AI understands entire system, not just files
- Cross-module dependencies
- System-wide impact analysis
- Holistic understanding

</v-clicks>

---

# Extended Thinking Mode

## When AI Takes Time to Think

<v-clicks>

**What is Extended Thinking?**
- AI takes time to reason through complex problems
- Multi-step analysis and planning
- Deeper understanding before code generation
- Like having a senior developer think through architecture

**When to Use:**
- Architectural decisions
- Complex refactoring projects
- Performance optimization strategies
- Security analysis
- Legacy code modernization

**Demo:**
```
Extended Thinking: "Design a modular architecture for an e-commerce 
system with user management, product catalog, order processing, and 
payment handling. Consider maintainability, testability, and team 
collaboration."
```

</v-clicks>

---

# Demo: Extended Thinking in Action

**Complex Problem:**
```
Extended Thinking: "Analyze this monolithic e-commerce application 
and design a modular architecture that supports team collaboration, 
independent deployment, and maintainable code."
```

<v-clicks>

**AI Response Process:**
1. **Analysis Phase** - Understanding current structure
2. **Design Phase** - Identifying module boundaries
3. **Planning Phase** - Migration strategy
4. **Implementation Phase** - Step-by-step approach

**Key Insight:** AI considers factors you might miss:
- Team size and expertise
- Deployment constraints
- Testing strategies
- Future scalability

</v-clicks>

---

# Part 2: Plan Mode for Complex Changes

## Multi-Phase Project Execution

---

# What is Plan Mode?

<v-clicks>

## Core Concept
AI creates step-by-step implementation plans for complex changes
- Multi-file, multi-phase modifications
- Reviewable and modifiable plans
- Executable in phases
- Human oversight at each step

## When to Use Plan Mode
- Large refactoring projects
- Architecture migrations
- Feature additions across multiple modules
- Breaking changes that affect multiple components
- Team coordination on complex tasks

## Key Benefits
- **Visibility** - See the full scope before starting
- **Control** - Modify plans before execution
- **Safety** - Execute in phases with validation
- **Collaboration** - Share plans with team

</v-clicks>

---

# Demo: Planning Modular Refactoring

**Starting Point:** Monolithic e-commerce Spring Boot application

**Goal:** Refactor into modular architecture with clear boundaries

<v-clicks>

**Step 1: Analysis Phase**
```
Plan Mode: "Analyze this monolithic e-commerce application and create a 
plan to refactor it into modular architecture. Identify module boundaries, 
shared dependencies, and refactoring phases."
```

**Generated Plan Overview:**
- **Module Identification:** User, Product, Order, Payment, Common
- **Shared Library Extraction:** DTOs, utilities, configurations
- **Database Schema Separation:** Module-specific tables
- **API Contract Definitions:** Inter-module communication
- **Migration Phases:** 4 phases with dependencies

</v-clicks>

---

# Plan Review and Refinement

<v-clicks>

**Step 2: Plan Refinement**
```
Plan Mode: "Modify the plan to prioritize User module first and add
comprehensive testing strategy for each module."
```

**Refined Plan Features:**
- **Phase 1:** User module extraction
- **Phase 2:** Shared library creation
- **Phase 3:** Product module extraction
- **Phase 4:** Order and Payment modules
- **Phase 5:** Integration and testing
- **Phase 6:** Documentation and deployment

**Key Insight:** Plans are living documents that evolve with requirements

</v-clicks>

---

# Plan Execution: Phase 1

**Execute Plan Phase 1:**
```
Plan Mode: "Execute Phase 1: Extract User module from the monolith.
Create separate User module with its own package structure, 
entities, and API endpoints."
```

<v-clicks>

**Generated Changes:**
- New User module structure
- User entity and repository
- User API endpoints
- Module dependencies
- Shared library setup

**Review Process:**
- Examine generated code
- Test API endpoints
- Validate module boundaries
- Prepare for Phase 2

</v-clicks>

---

# Student Exercise: Plan Review

**Your Turn:**

<v-clicks>

1. **Review the generated plan** for modular refactoring
2. **Use Chat mode** to ask questions about specific phases
3. **Suggest modifications** to the plan
4. **Understand the planning process**

**Questions to Explore:**
- "What are the risks in Phase 2?"
- "How will modules communicate?"
- "What testing strategy is recommended?"
- "How do we handle shared database connections?"

**Goal:** Understand how AI plans complex projects

</v-clicks>

---

# Part 3: Advanced AI Collaboration Patterns

## Custom Commands and Iterative Refinement

---

# Custom Rules and Commands

## Team Workflow Automation

<v-clicks>

**What are Cursor Rules?**
- Project rules stored in `.cursor/rules/*.mdc` files
- Team-standardized AI behavior
- Version-controlled and shared via git
- Consistent code generation across team

**Benefits:**
- **Consistency** - Same AI behavior across team
- **Efficiency** - Rules apply automatically when relevant
- **Quality** - Proven patterns and best practices
- **Onboarding** - New team members get rules automatically

</v-clicks>

---

# Creating Team Rules

**Example Rules in `.cursor/rules/`:**

<v-clicks>

**File: `security-review.mdc`**
```markdown
When asked to review security:
Review this code for security vulnerabilities including SQL injection,
XSS, authentication bypass, and data exposure risks. Provide specific
recommendations with examples.
```

**File: `test-generation.mdc`**
```markdown
When asked to generate tests:
Generate comprehensive unit and integration tests for this class using
JUnit 5, Mockito, and TestContainers. Include edge cases and error scenarios.
```

</v-clicks>

---

# Creating Team Rules (Continued)

**More Example Rules:**

<v-clicks>

**File: `module-creation.mdc`**
```markdown
When asked to create a module:
Create a new Spring Boot module following our architecture patterns:
entity, repository, service, controller, and tests. Use shared library
components where appropriate.
```

**File: `coding-standards.mdc`**
```markdown
This project follows Clean Architecture principles.
Use Java 17+ features, Spring Boot conventions, comprehensive JavaDoc,
meaningful variable names, and proper logging.
```

</v-clicks>

---

# Demo: Using Team Rules

<v-clicks>

**Security Review:**
```
"Please review this controller for security vulnerabilities."
```
→ AI applies security-review.mdc rule automatically

**Test Generation:**
```
"Generate tests for this service."
```
→ AI uses test-generation.mdc patterns

**Coding Standards:**
```
"Create a new service class for order processing."
```
→ AI follows coding-standards.mdc automatically

**Key Insight:** Rules apply intelligently - no need to remember slash commands!

</v-clicks>

---

# Iterative Refinement Workflows

## The Refinement Cycle

<v-clicks>

**1. Generate:** Initial AI output
**2. Review:** Human evaluation
**3. Refine:** Specific improvement requests
**4. Iterate:** Repeat until satisfied

**Example: API Design Refinement**

**Initial Request:**
```
"Create REST API for product management"
```

**Review:** "The API needs pagination, filtering, and proper error responses"

**Refinement:**
```
"Add pagination with page/size parameters, filtering by category/price, 
and structured error responses with proper HTTP status codes"
```

**Iteration:**
```
"Include OpenAPI documentation and validation examples"
```

</v-clicks>

---

# Student Exercise: Refinement Practice

**Your Turn:**

<v-clicks>

1. **Generate initial code** for Product module
2. **Review and identify improvements**
3. **Use refinement prompts** to enhance
4. **Iterate until satisfied**

</v-clicks>

---

# Student Exercise: Refinement Practice (Continued)

<v-clicks>

**Refinement Examples:**
- "Add input validation to all endpoints"
- "Include proper error handling and logging"
- "Add comprehensive JavaDoc documentation"
- "Implement caching for frequently accessed data"

**Goal:** Master the iterative refinement process

</v-clicks>

---

# Part 4: Model Context Protocol (MCP)

## External Tool Integration

---

# Understanding MCP

<v-clicks>

**What is MCP?**
- Protocol for AI to interact with external tools
- Extends AI capabilities beyond code
- Enables tool integration and automation
- Custom context providers

**MCP Servers We'll Use:**
- **Context7** - Up-to-date library documentation
- **Playwright** - Browser automation for testing

**What MCP Enables:**
- Real-time access to current documentation
- Automated browser testing from Cursor
- Integration with external tools and services
- Extended AI capabilities beyond code generation

**Key Benefit:** AI becomes aware of your entire development ecosystem

</v-clicks>

---

# Demo: Context7 for Documentation

**Look up Spring Boot best practices:**
```
What are the current best practices for input validation in Spring Boot 3.x?
Show me examples using Jakarta validation annotations.
```
*(Cursor's Composer will suggest using Context7 for up-to-date docs)*

<v-clicks>

**Context7 Response:**
- Current Spring Boot 3.x patterns (not outdated info)
- Jakarta validation examples: `@Valid`, `@NotNull`, `@Email`
- Code snippets you can use immediately
- Library-specific best practices

**Key Insight:** No special syntax needed - just ask naturally!

</v-clicks>

---

# Demo: Playwright for Testing

**Test the running application:**
```
Navigate to http://localhost:8080/api/users and capture what you see.
Then take a screenshot of the H2 console.
```
*(Cursor will suggest using Playwright for browser automation)*

<v-clicks>

**Playwright Actions:**
- Opens browser automatically
- Navigates to endpoints
- Captures screenshots
- Reports what it found
- Verifies HTTP status codes

**Key Insight:** Natural language requests - Cursor handles the tool selection!

</v-clicks>

---

# Part 5: Legacy Code Review

## AI-Assisted Modernization Analysis

---

# Legacy Code Review

**AI as Modernization Partner:**
```
Conduct a comprehensive code review of the legacy-app Customer module.
This is legacy code that needs modernization. Analyze:
- Code quality and outdated patterns
- Security vulnerabilities
- Performance issues
- Deprecated APIs or libraries
- Missing error handling and testing gaps

Provide specific recommendations with examples of modern alternatives.
```

<v-clicks>

**Expected Issues Found:**
- **Outdated patterns:** Old Java patterns, pre-Java 8 code
- **Naming issues:** Inconsistent conventions (e.g., "Repo" vs "Repository")
- **Security vulnerabilities:** SQL injection, missing validation
- **Performance problems:** N+1 queries, missing caching
- **Missing features:** No logging, error handling, tests

**Key Insight:** AI identifies modernization opportunities systematically

</v-clicks>

---

# Prioritizing Modernization

**Create Action Plan:**
```
Based on the code review, create a prioritized modernization plan
for the legacy-app. Group improvements into:
1. Critical (security, data integrity)
2. High Priority (performance, major bugs)
3. Medium Priority (code quality, maintainability)
4. Low Priority (nice-to-have improvements)
```

<v-clicks>

**Expected Prioritization:**
- **Critical:** SQL injection fixes, authentication issues
- **High:** Exception handling, input validation, logging
- **Medium:** Naming consistency, code organization, documentation
- **Low:** Code style, minor refactoring, optional features

**Key Insight:** AI helps systematically plan legacy modernization

</v-clicks>

---

# Part 6: Team Collaboration with Rules

## Shared AI Context via Version Control

---

# Team Context Management

<v-clicks>

**Shared AI Context:**
- Version-controlled `.cursor/rules/` directory
- Team coding standards as `.mdc` files
- Architecture guidelines
- Common patterns and anti-patterns

**Example `.cursor/rules/coding-standards.mdc`:**
```markdown
This project follows Clean Architecture principles.
Use dependency injection, implement proper error handling, include
comprehensive tests, and follow REST API best practices.
Modules should be loosely coupled and highly cohesive.

Coding Standards:
- Use Java 17+ features
- Follow Spring Boot conventions
- Include comprehensive JavaDoc
```

**Benefits:**
- Consistent AI behavior across team (rules stored in git)
- Automatic application when relevant
- New team members get rules when they clone
- Under 500 lines per rule for maintainability

</v-clicks>

---

# Collaborative Development Patterns

<v-clicks>

**Feature Branch Workflow:**
1. **Planning:** Use Plan Mode for feature design
2. **Development:** Iterative AI collaboration
3. **Review:** AI-assisted code review
4. **Integration:** Automated testing and deployment

</v-clicks>

---

# Collaborative Development Patterns (Continued)

<v-clicks>

**Demo: Team Feature Development**
```
Plan Mode: "Design and implement an Order module that integrates
with User and Product modules. Include order processing, inventory
management, and email notifications."
```

**Review Process:**
- AI-generated test cases
- Automated security scanning
- Performance analysis
- Documentation generation

</v-clicks>

---

# Break Time! ☕

**10 Minutes**

We're halfway through - stretch, grab coffee, be back on time!

---

# Part 7: Legacy Code Modernization

## Applying Agentic Coding to Real-World Problems

---

# Legacy Code Analysis

**Extended Thinking Analysis:**
```
Extended Thinking: "Analyze this legacy Java application and create a 
modernization strategy. Identify technical debt, security issues, 
performance bottlenecks, and migration opportunities."
```

<v-clicks>

**Analysis Categories:**
- Technical debt identification
- Security vulnerability assessment
- Performance bottleneck analysis
- Modernization roadmap
- Risk assessment

**Key Insight:** AI provides systematic analysis of complex legacy systems

</v-clicks>

---

# Student Exploration Exercise

**Use Extended Thinking to explore:**

<v-clicks>

1. **"What are the main architectural issues in this codebase?"**
2. **"How would you prioritize modernization efforts?"**
3. **"What risks should be considered during migration?"**

**Share findings:** What did you discover?

**Key Learning:** Extended Thinking for complex problem analysis

</v-clicks>

---

# Part 8: Project Architecture Overview

## E-Commerce Modular Structure

---

# Modular Architecture Design

```
ecommerce-app/
├── ecommerce-monolith/          # Starting point (H2 database)
├── ecommerce-modular/           # Refactored version
│   ├── user-module/
│   │   ├── UserController
│   │   ├── UserService
│   │   ├── UserRepository
│   │   └── User entity
│   ├── product-module/
│   │   ├── ProductController
│   │   ├── ProductService
│   │   ├── ProductRepository
│   │   └── Product entity
│   ├── order-module/
│   ├── payment-module/
│   └── shared-lib/              # Common utilities
└── README.md
```

<v-clicks>

**Key Benefits:**
- Clear module boundaries
- Independent development
- Shared common utilities
- H2 in-memory database (no external dependencies)
- Simple local development setup

</v-clicks>

---

# Refactoring Phases

<v-clicks>

**Phase 1:** Extract User module
**Phase 2:** Create shared library
**Phase 3:** Extract Product module

</v-clicks>

---

# Refactoring Phases (Continued)

<v-clicks>

**Phase 4:** Extract Order module
**Phase 5:** Extract Payment module
**Phase 6:** Integration and testing

**Key Learning:** Systematic approach to complex refactoring

</v-clicks>

---

# Wrap-Up: Key Takeaways

---

# Agentic Coding Decision Tree

```
Complex architectural decision? → Use Extended Thinking
Multi-phase project? → Use Plan Mode
Repetitive tasks? → Create Slash Commands
External tool integration? → Use MCP
Team collaboration? → Establish shared context
Code quality? → AI-assisted review
```

---

# What We Accomplished Today

<v-clicks>

✅ **Modular Architecture Refactoring** using Plan Mode
✅ **Custom Rules and Commands** with `.cursor/rules/`
✅ **MCP Integration** with natural language (Context7, Playwright)
✅ **Legacy Code Review** and modernization analysis
✅ **Team Collaboration** with version-controlled rules

**All with local development tools!**

</v-clicks>

---

# Best Practices We Learned

<v-clicks>

1. **Start with Extended Thinking** for complex problems
2. **Use Plan Mode** for multi-phase projects
3. **Create custom rules** in `.cursor/rules/` for team consistency
4. **Use natural language** for MCP tools - no special syntax needed
5. **Iterate and refine** - first output is rarely perfect
6. **Version control rules** - commit `.cursor/rules/` to git
7. **Review AI output** - AI assists, humans decide
8. **Apply to legacy code** - AI excels at modernization analysis

</v-clicks>

---

# Comparing Sessions 1-3

| Session 1-2 (Individual AI) | Session 3 (Agentic AI) |
|------------------------------|-------------------------|
| Chat for understanding | Extended Thinking for complex analysis |
| Agent for code generation | Plan Mode for multi-phase projects |
| Composer for multi-file changes | Custom rules for team workflows |
| Manual AI interaction | Rules apply automatically |
| Single-developer focus | Version-controlled team collaboration |
| Code generation | Architecture, planning, and modernization |

<v-clicks>

**Same principles, advanced application:**
- Natural language as interface
- Iterative refinement
- Context awareness
- Human-AI collaboration

</v-clicks>

---

# Preview: Session 4

## Reviewing and Testing Code with AI

<v-clicks>

**Coming up:**
- Automated test generation strategies
- AI-powered debugging and troubleshooting
- Performance analysis and optimization
- Security vulnerability assessment
- Code coverage and quality metrics
- Continuous integration with AI

**Get ready to level up your testing game!**

</v-clicks>

---

# Homework / Lab Exercises

<v-clicks>

**Part A: Reinforce Today's Learning**
- Complete modular refactoring (if not done)
- Create custom rules in `.cursor/rules/` for your team
- Apply Extended Thinking to architectural decisions
- Practice MCP integration with Context7 and Playwright

**Part B: Legacy Code Challenges**
- Deep analysis of provided legacy codebase
- Create modernization strategy with priorities
- Apply agentic coding principles
- Document findings and recommendations

**See `labs.md` for details**

</v-clicks>

---

# Resources

**Agentic Coding Resources:**
- [Cursor Documentation - Advanced Features](https://docs.cursor.com)
- [Model Context Protocol Specification](https://modelcontextprotocol.io)
- [AI-Assisted Development Best Practices](https://cursor.com/blog)

**Architecture Patterns:**
- [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
- [Modular Monolith](https://www.kamilgrzybek.com/design/modular-monolith-primer/)
- [Spring Boot Best Practices](https://spring.io/guides)

---

# Questions?

<div class="text-center mt-10">
  <h2>Open Q&A</h2>
  <p class="text-xl mt-4">
    Ask about anything we covered today:
  </p>
  <ul class="text-left mx-auto max-w-2xl mt-6">
    <li>Agentic coding principles</li>
    <li>Extended Thinking mode</li>
    <li>Plan Mode execution</li>
    <li>Custom rules in `.cursor/rules/`</li>
    <li>MCP integration (natural language)</li>
    <li>Legacy code modernization</li>
    <li>Your own projects</li>
  </ul>
</div>

---

# Thank You!

<div class="text-left">

**Contact:**
- ken.kousen@kousenit.com
- http://kousenit.com
- [@kenkousen](https://twitter.com/kenkousen)

**Continue Learning:**
- Complete homework labs
- Apply agentic coding to your projects
- Experiment with Extended Thinking
- Join us for Session 4!

</div>

<div class="text-center mt-8">
  <p class="text-2xl">Happy Agentic Coding! 🤖🤝👨‍💻</p>
</div>

