---
theme: seriph
class: text-center
highlighter: shiki
lineNumbers: true
info: |
  ## Reviewing and Testing Code Using Cursor and Claude

  By Kenneth Kousen

  Session 4 of Cursor for Java Developers training series
drawings:
  persist: false
transition: slide-left
title: "Reviewing and Testing Code Using Cursor and Claude"
mdc: true
---

# Reviewing and Testing Code Using Cursor and Claude

<div class="pt-12">
  <span @click="$slidev.nav.next" class="px-2 py-1 rounded cursor-pointer" hover="bg-white bg-opacity-10">
    AI as Your Quality Partner <carbon:arrow-right class="inline"/>
  </span>
</div>

<div class="abs-br m-6 flex gap-2">
  <button @click="$slidev.nav.openInEditor()" title="Open in Editor" class="text-xl slidev-icon-btn opacity-50 !border-none !hover:text-white">
    <carbon:edit />
  </button>
</div>

---

# Contact Info

Ken Kousen • Kousen IT, Inc.

- ken.kousen@kousenit.com
- http://www.kousenit.com
- http://kousenit.org (blog)

---

# Connect with Me

- **Twitter:** [@kenkousen](https://twitter.com/kenkousen)
- **Bluesky:** [@kousenit.com](https://bsky.app/profile/kousenit.com)
- **LinkedIn:** [linkedin.com/in/kenkousen](https://www.linkedin.com/in/kenkousen/)
- **Newsletter:** [kenkousen.substack.com](https://kenkousen.substack.com)
- **YouTube:** [@talesfromthejarside](https://youtube.com/@talesfromthejarside)

---

# Course Overview: 5 Sessions

<v-clicks>

1. **Using Cursor for Java Development** (Session 1 - Complete)
   - Understanding code, navigation, generation, testing
2. **Using Cursor for Mobile Development** (Session 2 - Complete)
   - Android/Kotlin with AI assistance
3. **Agentic Coding with Cursor** (Session 3 - Complete)
   - AI as collaborative partner for complex projects
4. **Reviewing and Testing Code** (Today - 3 hours)
   - AI as quality assurance partner
5. **Exploring Agents and MCP** (3 hours)
   - Model Context Protocol and advanced features

</v-clicks>

---

# Today's Session: What We'll Cover

<v-clicks>

- **AI-Assisted Test Generation** - Comprehensive test suites with AI
- **Comprehensive Unit Testing** - JUnit 5, Mockito, and AssertJ
- **Integration Testing Strategies** - TestContainers and service mocking
- **End-to-End Testing** - Complete workflow validation
- **AI-Powered Debugging** - Intelligent troubleshooting

</v-clicks>

---

# Project 1: E-Commerce Testing Suite

Build comprehensive testing strategy with AI assistance:

<v-clicks>

- Unit Tests (JUnit 5, Mockito, AssertJ)
- Integration Tests (TestContainers, @DataJpaTest)
- End-to-End Tests (API testing, workflow validation)

</v-clicks>

---

# Project 2: Legacy Code Testing

Apply AI testing strategies to real-world legacy systems

<v-clicks>

- Analyze existing code without tests
- Create testing strategies incrementally
- Refactor for testability

</v-clicks>

---

# Sessions 1-3 Recap

<v-clicks>

- **Chat Mode** (Cmd/Ctrl+L) - Ask questions, understand code
- **Agent Mode** (Cmd/Ctrl+I) - Generate code, refactor
- **Composer Mode** (Cmd/Ctrl+Shift+I) - Multi-file generation
- **Extended Thinking** - Complex analysis and planning

</v-clicks>

---

# Today: AI Testing

<v-clicks>

- **Test Generation** - AI creates comprehensive test suites
- **Quality Analysis** - AI reviews code for issues
- **Integration Testing** - TestContainers and mocking
- **Debugging Assistance** - AI troubleshoots failures

</v-clicks>

---
layout: image-right
image: https://images.unsplash.com/photo-1516116216624-53e697fedbea?w=800
---

# Part 1: AI-Assisted Test Generation

The Testing Paradigm Shift

<v-clicks>

- From manual to AI-assisted
- From reactive to proactive
- From limited to comprehensive

</v-clicks>

---

# Traditional Testing

<v-clicks>

- Manual test writing
- Limited test coverage
- Reactive quality assurance
- Time-consuming maintenance

</v-clicks>

---

# AI-Assisted Testing

<v-clicks>

- Automated test generation
- Comprehensive coverage analysis
- Proactive quality assurance
- Intelligent test maintenance

</v-clicks>

---

# AI Testing Philosophy

<v-clicks>

## 1. Coverage-Driven
AI identifies gaps: edge cases, untested paths, boundary values

## 2. Scenario-Based
AI generates realistic test scenarios and user journeys

</v-clicks>

---

# AI Testing Philosophy (continued)

<v-clicks>

## 3. Maintenance-Aware
AI helps keep tests up-to-date with code changes

## 4. Quality-Focused
AI ensures meaningful assertions and realistic test data

</v-clicks>

---

# Unit Test Generation

<v-clicks>

- Method-level testing with edge cases
- Mocking strategies
- Assertion patterns
- Error condition testing

</v-clicks>

---

# Integration Test Generation

<v-clicks>

- Component interaction testing
- Database integration
- External service mocking
- Transaction testing

</v-clicks>

---

# End-to-End Test Generation

<v-clicks>

- Full workflow testing
- User journey validation
- API contract testing
- Cross-system integration

</v-clicks>

---

# Demo: AI Test Generation

**Service Layer Testing:**
```
Extended Thinking: "Generate comprehensive unit tests for UserService.
Include happy path, edge cases, and error conditions.
Use JUnit 5, Mockito, and AssertJ."
```

---

# AI Response Process

<v-clicks>

1. **Analysis** - Understanding the service
2. **Strategy** - Identifying test scenarios
3. **Generation** - Creating tests
4. **Validation** - Ensuring quality

</v-clicks>

---
layout: image-left
image: https://images.unsplash.com/photo-1555066931-4365d14bab8c?w=800
---

# Part 2: Comprehensive Unit Testing

JUnit 5, Mockito, and AssertJ

<v-clicks>

- Modern testing stack
- AI-assisted generation
- Quality-focused approach

</v-clicks>

---

# Spring Boot 3.4+ Testing Changes

**Important Update:**

`@MockBean` and `@SpyBean` are deprecated as of Spring Boot 3.4

<v-clicks>

**New annotations:**
- `@MockitoBean` - replaces `@MockBean`
- `@MockitoSpyBean` - replaces `@SpyBean`

</v-clicks>

---

# New Package Location

```java
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
```

**Migration:** AI can help update your tests automatically!

---

# Unit Testing Strategies

<v-clicks>

## Service Layer
Mock dependencies, test business logic, verify error handling

## Repository Layer
@DataJpaTest for CRUD operations and custom queries

</v-clicks>

---

# Unit Testing Strategies (continued)

<v-clicks>

## Controller Layer
@WebMvcTest for endpoints, validation, and responses

## Utilities
Test static methods, edge cases, and error conditions

</v-clicks>

---

# Demo: Service Layer Testing

**Prompt:**
```
"Generate unit tests for UserService using JUnit 5,
Mockito, and AssertJ."
```

---

# Generated Test Structure

```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock private UserRepository repo;
    @InjectMocks private UserService service;

    @Test
    void shouldCreateUserWithValidData() {
        when(repo.save(any())).thenReturn(savedUser);
        User result = service.createUser(request);
        assertThat(result).isNotNull();
        verify(repo).save(any());
    }
}
```

---

# Demo: Repository Testing

**Prompt:**
```
"Create unit tests for UserRepository using @DataJpaTest.
Test all CRUD operations and custom query methods."
```

---

# Generated Repository Test

```java
@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserByEmail() {
        User user = new User("John", "Doe", "john@example.com");
        entityManager.persistAndFlush(user);

        Optional<User> result =
            userRepository.findByEmail("john@example.com");

        assertThat(result).isPresent();
    }
}
```

---

# Student Exercise: Controller Testing

**Your Turn:**

Generate tests using this prompt:

```
"Generate unit tests for UserController using @WebMvcTest.
Use @MockitoBean for service mocking (Spring Boot 3.4+).
Test endpoints, validation, and error handling."
```

---

# Controller Testing Goals

<v-clicks>

- **Review:** Endpoint coverage, MockMvc usage, JSON assertions
- **Refine:** Add edge cases and improve test data
- **Note:** Spring Boot 3.4+ uses `@MockitoBean`

</v-clicks>

---

# Part 2B: AI-Powered Test Quality

Review and Improvement

---

# Demo: AI Test Quality Review

**Prompt:**
```
"Review these unit tests and suggest improvements.
Focus on test coverage, assertion quality, and maintainability."
```

---

# AI Test Review Insights

<v-clicks>

- **Missing test cases** - Edge cases, error conditions
- **Weak assertions** - Too generic, not specific enough
- **Test smells** - Unclear names, too much setup
- **Improvement suggestions** - Better structure, clearer intent

</v-clicks>

---

# Demo: Test Data Generation

**Prompt:**
```
"Generate realistic test data for User and Order entities.
Include various scenarios: valid data, edge cases, invalid data."
```

---

# AI-Generated Test Data: Valid Users

```java
// Valid users
User normalUser = new User("John", "Doe", "john@example.com");
User longNameUser = new User("Christopher", "Bartholomew",
    "christopher.bartholomew@example.com");
```

---

# AI-Generated Test Data: Edge Cases

```java
// Edge cases
User shortNameUser = new User("A", "B", "a@b.co");
User unicodeUser = new User("José", "García", "jose@example.es");

// Invalid data for validation testing
User nullEmailUser = new User("John", "Doe", null);
User invalidEmailUser = new User("John", "Doe", "not-an-email");
```

---

# Student Exercise: Improve Your Tests

**Review Generated Tests:**
```
"Review my UserService tests. What's missing?
What could be improved?"
```

---

# Student Exercise: Generate Test Data

**Generate Test Data:**
```
"Generate test data for various Order scenarios:
new orders, completed orders, cancelled orders."
```

**Goal:** Write higher quality tests with AI assistance

---
layout: image-right
image: https://images.unsplash.com/photo-1558494949-ef010cbdcc31?w=800
---

# Part 3: Integration Testing

TestContainers and Service Mocking

<v-clicks>

- Real database testing
- Component interaction
- External service mocking

</v-clicks>

---

# Database Integration Testing

TestContainers for real databases, SQL queries, transactions

---

# Service Integration Testing

Test component interactions, data flow, error propagation

---

# External Service Testing

WireMock for HTTP services, payment gateways, third-party APIs

---

# Demo: TestContainers Integration

**Prompt:**
```
"Set up TestContainers with PostgreSQL for integration testing"
```

---

# Generated TestContainers Setup

```java
@SpringBootTest
@Testcontainers
class UserIntegrationTest {
    @Container
    static PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:15");

    @DynamicPropertySource
    static void props(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", postgres::getJdbcUrl);
    }

    @Test
    void shouldCreateAndRetrieveUser() { /* ... */ }
}
```

---

# Demo: Service Integration Testing

**Complete Module Testing:**
```
Plan Mode: "Create integration tests for the complete User module
including service, repository, and database layers."
```

---

# Generated Integration Tests

<v-clicks>

- Service layer integration
- Repository integration
- Database transaction testing
- Error handling verification

</v-clicks>

---

# Integration Test Benefits

<v-clicks>

- Real database testing
- Actual component interaction
- Transaction boundary testing
- Error scenario testing

</v-clicks>

---

# Student Exercise: External Service Mocking

**Prompt:**
```
"Set up WireMock for mocking external services.
Create integration tests for payment processing."
```

---

# WireMock Configuration Goals

<v-clicks>

- Payment gateway mocking
- Email service mocking
- Error scenario testing
- Response validation

</v-clicks>

---

# Break Time!

**10 Minutes**

Stretch, grab coffee, be back on time!

---
layout: image-left
image: https://images.unsplash.com/photo-1454165804606-c3d57bc86b40?w=800
---

# Part 4: End-to-End Testing

Complete Workflow Validation

<v-clicks>

- Full user journeys
- API contracts
- Cross-system integration

</v-clicks>

---

# End-to-End Testing Strategies

<v-clicks>

- **API Testing:** Complete workflows, authentication
- **Workflow Testing:** User journeys, business processes
- **Cross-System Testing:** Multi-service integration

</v-clicks>

---

# Demo: Complete API Testing

**Prompt:**
```
"Create comprehensive API tests for the e-commerce application.
Include authentication, authorization, and error handling."
```

---

# Generated API Test Coverage

<v-clicks>

- Authentication flow testing
- Authorization scenario testing
- CRUD operation validation
- Error response verification

</v-clicks>

---

# API Test Structure

```java
@SpringBootTest(webEnvironment = RANDOM_PORT)
class EcommerceApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shouldCompleteFullOrderWorkflow() {
        // Test implementation
    }
}
```

---

# Student Exercise: Workflow Testing

**Create Workflow Tests:**
```
Plan Mode: "Create end-to-end tests for the complete order processing
workflow from user login to order completion."
```

---

# Workflow Test Scenarios

<v-clicks>

- User registration and login
- Product browsing and selection
- Cart management
- Checkout process

</v-clicks>

---

# Workflow Test Implementation

<v-clicks>

- Test data setup
- Workflow execution
- State validation
- Response verification

</v-clicks>

---
layout: image-right
image: https://images.unsplash.com/photo-1504639725590-34d0984388bd?w=800
---

# Part 5: AI-Powered Debugging

Intelligent Troubleshooting

<v-clicks>

- Error analysis
- Root cause identification
- Fix recommendations

</v-clicks>

---

# Error Analysis with AI

Stack traces, root causes, error patterns

---

# Test Failure Debugging

Failures, environment issues, data problems, configuration

---

# Demo: AI-Guided Debugging

**Prompt:**
```
"Analyze this failing test and provide debugging guidance.
Identify the root cause and suggest fixes."
```

---

# AI Debugging Process

<v-clicks>

1. **Error Analysis** - Understanding the failure
2. **Root Cause Identification** - Finding the source
3. **Fix Recommendation** - Suggesting solutions
4. **Prevention Strategy** - Avoiding future issues

</v-clicks>

---

# Student Exercise: Test Failure Analysis

**Analyze Test Failure:**
```
Chat Mode: "This test is failing with a NullPointerException.
Help me debug the issue and fix the test."
```

---

# Debug Process Steps

<v-clicks>

- Analyze error message
- Identify root cause
- Implement fix
- Validate solution

</v-clicks>

---
layout: image-left
image: https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=800
---

# Part 6: Legacy Code Testing

Testing Strategies for Legacy Systems

<v-clicks>

- Incremental approach
- Risk-based testing
- Modernization path

</v-clicks>

---

# Legacy Code Testing Challenges

<v-clicks>

- Limited test coverage
- Tightly coupled code
- Missing documentation
- Complex business logic

</v-clicks>

---

# Legacy Code Testing Strategies

<v-clicks>

- Incremental test addition
- Characterization testing
- Refactoring for testability
- Risk-based testing

</v-clicks>

---

# Demo: Legacy Code Analysis

**Legacy Testing Strategy:**
```
Extended Thinking: "Analyze this legacy Java application and create
a testing strategy. Identify testing challenges and recommend
approaches for improving test coverage."
```

---

# Analysis Results

<v-clicks>

- Current test coverage assessment
- Testing challenge identification
- Risk-based testing approach
- Modernization recommendations

</v-clicks>

---

# Recommended Approach

<v-clicks>

1. **Characterization Testing** - Understand current behavior
2. **Incremental Testing** - Add tests gradually
3. **Refactoring** - Improve code structure
4. **Comprehensive Testing** - Full coverage

</v-clicks>

---

# Student Exploration Exercise

**Use Extended Thinking to explore:**

<v-clicks>

- "What are the main testing challenges in this legacy codebase?"
- "How would you prioritize testing improvements?"
- "What risks should be considered?"

</v-clicks>

---
layout: section
---

# Wrap-Up

Key Takeaways

---

# AI Testing Decision Tree

```
Need unit tests? → Use Agent Mode with JUnit 5
Need integration tests? → Use TestContainers with Plan Mode
Need end-to-end tests? → Use Extended Thinking for workflow design
Need debugging help? → Use Chat Mode for analysis
```

---

# What We Accomplished Today

<v-clicks>

- ✅ **Test Suite Generation** using AI
- ✅ **Unit Testing** with JUnit 5, Mockito, AssertJ
- ✅ **Integration Testing** with TestContainers

</v-clicks>

---

# What We Accomplished Today (continued)

<v-clicks>

- ✅ **End-to-End Testing** for workflows
- ✅ **AI-Powered Debugging**
- ✅ **Legacy Code Testing** strategies

</v-clicks>

---

# Best Practices: Generation

<v-clicks>

- Start with AI test generation for comprehensive coverage
- Use appropriate testing strategies (unit, integration, E2E)
- Master the stack: JUnit 5, Mockito, AssertJ, TestContainers

</v-clicks>

---

# Best Practices: Quality

<v-clicks>

- Leverage AI for debugging and troubleshooting
- Apply testing to legacy code incrementally
- Use realistic test data from AI generation

</v-clicks>

---

# Comparing Sessions 1-4

| Sessions 1-3 | Session 4 |
|--------------|-----------|
| Code generation | Test generation |
| Architecture planning | Testing strategy |
| AI collaboration | AI quality partnership |

---

# Same Core Principles

<v-clicks>

- Natural language as interface
- Iterative refinement
- Context awareness
- Human-AI collaboration

</v-clicks>

---

# Preview: Session 5

## Building AI-Powered Java Apps with Spring AI

<v-clicks>

- ChatClient and prompt templates
- RAG (Retrieval Augmented Generation)
- Function calling and tools
- Model Context Protocol (MCP)

</v-clicks>

---

# Lab Exercises

**Part A: Reinforce Today's Learning**

<v-clicks>

- Complete testing suite generation
- Apply AI debugging to test failures
- Create custom testing workflows

</v-clicks>

---

# Lab Exercises (continued)

**Part B: Legacy Code Testing**

<v-clicks>

- Analyze provided legacy codebase
- Create testing strategy
- Apply incremental testing approach

</v-clicks>

**See `labs.md` for details**

---

# Resources: Testing

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [TestContainers Documentation](https://www.testcontainers.org/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [AssertJ Documentation](https://assertj.github.io/doc/)

---

# Resources: Spring

- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [Cursor Documentation](https://docs.cursor.com)

---
layout: center
class: text-center
---

# Questions?

<div class="pt-8">

AI test generation • Unit testing • Integration testing

End-to-end testing • AI debugging • Legacy code

</div>

---
layout: center
class: text-center
---

# Thank You!

**ken.kousen@kousenit.com** • **kousenit.com** • **@kenkousen**

<div class="pt-8">

Apply AI testing to your projects

Join us for Session 5!

</div>
