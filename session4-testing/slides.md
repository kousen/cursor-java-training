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
- **Legacy Code Testing** - Applying AI to existing codebases

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

# Sessions 1-3 Recap

<v-clicks>

- **Chat Mode** (Cmd/Ctrl+L) - Ask questions, understand code
- **Agent Mode** (Cmd/Ctrl+I) - Generate code, refactor
- **Composer Mode** (Cmd/Ctrl+Shift+I) - Multi-file generation
- **Extended Thinking** - Complex analysis and planning
- **Plan Mode** - Multi-phase project execution

</v-clicks>

---

# Today: AI Testing

<v-clicks>

- **Test Generation** - AI creates comprehensive test suites
- **Quality Analysis** - AI reviews code for issues
- **Integration Testing** - TestContainers and mocking
- **End-to-End Testing** - Validate complete workflows
- **Debugging Assistance** - AI troubleshoots failures
- **Legacy Code Testing** - Modernize and test old code

</v-clicks>

---

# Part 1: AI-Assisted Test Generation

## The Testing Paradigm Shift

---

# Traditional Testing

<v-clicks>

- Manual test writing
- Limited test coverage
- Reactive quality assurance
- Time-consuming maintenance
- Human bias in test design

</v-clicks>

---

# AI-Assisted Testing

<v-clicks>

- Automated test generation
- Comprehensive coverage analysis
- Proactive quality assurance
- Intelligent test maintenance
- Objective test scenario design

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

# AI Testing Philosophy (2)

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

<v-clicks>

**AI Response Process:**
1. **Analysis** - Understanding the service
2. **Strategy** - Identifying test scenarios
3. **Generation** - Creating tests
4. **Validation** - Ensuring quality

**Generated Features:** Happy path, edge cases, error handling, mocking, assertions

</v-clicks>

---

# Part 2: Comprehensive Unit Testing

## JUnit 5, Mockito, and AssertJ

---

# Spring Boot 3.4+ Testing Changes

<v-clicks>

**Important Update:**

`@MockBean` and `@SpyBean` are deprecated as of Spring Boot 3.4

**New annotations:**
- `@MockitoBean` - replaces `@MockBean`
- `@MockitoSpyBean` - replaces `@SpyBean`

**New package:**
```
org.springframework.test.context.bean.override.mockito
```

**Migration:** AI can help update your tests automatically!

</v-clicks>

---

# Unit Testing Strategies

<v-clicks>

## Service Layer
Mock dependencies, test business logic, verify error handling

## Repository Layer
@DataJpaTest for CRUD operations and custom queries

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

**Benefits:** Mocking, organization, assertions, verifications

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

<v-clicks>

1. **Generate Tests:**
   ```
   "Generate unit tests for UserController using @WebMvcTest.
   Use @MockitoBean for service mocking (Spring Boot 3.4+).
   Test endpoints, validation, and error handling."
   ```

2. **Review:** Endpoint coverage, MockMvc usage, JSON assertions

3. **Refine:** Add edge cases and improve test data

**Goal:** Master AI-assisted test generation

**Note:** Spring Boot 3.4+ uses `@MockitoBean` from `org.springframework.test.context.bean.override.mockito`

</v-clicks>

---

# Part 2B: AI-Powered Test Quality

## Review and Improvement

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
- **Test smells** - Unclear names, too much setup, brittle tests
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

# AI-Generated Test Data

```java
// Valid users
User normalUser = new User("John", "Doe", "john@example.com");
User longNameUser = new User("Christopher", "Bartholomew",
    "christopher.bartholomew@example.com");

// Edge cases
User shortNameUser = new User("A", "B", "a@b.co");
User unicodeUser = new User("José", "García", "jose@example.es");

// Invalid data for validation testing
User nullEmailUser = new User("John", "Doe", null);
User invalidEmailUser = new User("John", "Doe", "not-an-email");
```

---

# Student Exercise: Improve Your Tests

**Your Turn:**

<v-clicks>

1. **Review Generated Tests:**
   ```
   "Review my UserService tests. What's missing?
   What could be improved?"
   ```

2. **Generate Test Data:**
   ```
   "Generate test data for various Order scenarios:
   new orders, completed orders, cancelled orders."
   ```

3. **Apply Improvements:** Implement AI suggestions

**Goal:** Write higher quality tests with AI assistance

</v-clicks>

---

# Part 3: Integration Testing Strategies

## TestContainers and Service Mocking

---

# Database Integration Testing

<v-clicks>

TestContainers for real databases, SQL queries, transactions

</v-clicks>

---

# Service Integration Testing

<v-clicks>

Test component interactions, data flow, error propagation

</v-clicks>

---

# External Service Testing

<v-clicks>

WireMock for HTTP services, payment gateways, third-party APIs

</v-clicks>

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

<v-clicks>

**Generated Integration Tests:**
- Service layer integration
- Repository integration
- Database transaction testing
- Error handling verification
- Data consistency validation

**Key Benefits:**
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

# Configure Service Mocking

<v-clicks>

- Payment gateway mocking
- Email service mocking
- Error scenario testing
- Response validation

</v-clicks>

---

# Test Integration Scenarios

<v-clicks>

- Verify service calls
- Test error handling
- Validate response processing
- Check retry logic

</v-clicks>

---

# Break Time! ☕

**10 Minutes**

We're halfway through - stretch, grab coffee, be back on time!

---

# Part 4: End-to-End Testing

## Complete Workflow Validation

---

# End-to-End Testing Strategies

<v-clicks>

- **API Testing:** Complete workflows, authentication, validation
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
- Data validation testing
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

**Your Turn:**

<v-clicks>

1. **Create Workflow Tests:**
   ```
   Plan Mode: "Create end-to-end tests for the complete order processing
   workflow from user login to order completion."
   ```

2. **Design Test Scenarios:**
   - User registration and login
   - Product browsing and selection
   - Cart management
   - Checkout process
   - Order confirmation

3. **Implement and Validate:**
   - Test data setup
   - Workflow execution
   - State validation
   - Error handling
   - Response verification

**Goal:** Master end-to-end testing with AI assistance

</v-clicks>

---

# Part 5: AI-Powered Debugging

## Intelligent Troubleshooting

---

# Error Analysis with AI

<v-clicks>

Stack traces, root causes, error patterns

</v-clicks>

---

# Test Failure Debugging

<v-clicks>

Failures, environment issues, data problems, configuration

</v-clicks>

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

# AI Debugging Features

<v-clicks>

- Stack trace interpretation
- Error pattern recognition
- Historical context analysis
- Fix recommendation
- Prevention strategies

</v-clicks>

---

# Student Exercise: Test Failure Analysis

**Your Turn:**

<v-clicks>

1. **Analyze Test Failure:**
   ```
   Chat Mode: "This test is failing with a NullPointerException.
   Help me debug the issue and fix the test."
   ```

2. **Debug Process:**
   - Analyze error message
   - Identify root cause
   - Implement fix
   - Validate solution
   - Prevent future issues

3. **Learn from Failure:**
   - Understand error patterns
   - Improve test design
   - Enhance error handling
   - Document lessons learned

**Goal:** Master AI-assisted debugging techniques

</v-clicks>

---

# Part 6: Legacy Code Testing

## Testing Strategies for Legacy Systems

---

# Legacy Code Testing Challenges

<v-clicks>

- Limited test coverage
- Tightly coupled code
- Missing documentation
- Outdated dependencies
- Complex business logic

</v-clicks>

---

# Legacy Code Testing Strategies

<v-clicks>

- Incremental test addition
- Characterization testing
- Refactoring for testability
- Legacy code modernization
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

<v-clicks>

**Analysis Results:**
- Current test coverage assessment
- Testing challenge identification
- Risk-based testing approach
- Incremental improvement strategy
- Modernization recommendations

**Recommended Approach:**
1. **Characterization Testing** - Understand current behavior
2. **Incremental Testing** - Add tests gradually
3. **Refactoring for Testability** - Improve code structure
4. **Modernization** - Update dependencies and patterns
5. **Comprehensive Testing** - Full test coverage

</v-clicks>

---

# Student Exploration Exercise

**Use Extended Thinking to explore:**

<v-clicks>

1. **"What are the main testing challenges in this legacy codebase?"**
2. **"How would you prioritize testing improvements?"**
3. **"What risks should be considered when adding tests to legacy code?"**

**Share findings:** What did you discover?

**Key Learning:** AI-assisted legacy code testing strategies

</v-clicks>

---

# Wrap-Up: Key Takeaways

---

# AI Testing Decision Tree

```
Need unit tests? → Use Agent Mode with JUnit 5
Need integration tests? → Use TestContainers with Plan Mode
Need end-to-end tests? → Use Extended Thinking for workflow design
Need debugging help? → Use Chat Mode for analysis
Testing legacy code? → Use Extended Thinking for strategy
Need mocking? → Use Agent Mode with Mockito/WireMock
```

---

# What We Accomplished Today

<v-clicks>

✅ **Comprehensive Test Suite Generation** using AI

✅ **Unit Testing Mastery** with JUnit 5, Mockito, AssertJ

✅ **Integration Testing** with TestContainers and WireMock

</v-clicks>

---

# What We Accomplished Today (cont'd)

<v-clicks>

✅ **End-to-End Testing** for complete workflows

✅ **AI-Powered Debugging** and troubleshooting

✅ **Legacy Code Testing** strategies

**All with AI as your quality partner!**

</v-clicks>

---

# Best Practices We Learned

<v-clicks>

1. **Start with AI test generation** - Comprehensive coverage from the beginning
2. **Use appropriate testing strategies** - Unit, integration, and end-to-end
3. **Master the testing stack** - JUnit 5, Mockito, AssertJ, TestContainers
4. **Leverage AI for debugging** - Intelligent troubleshooting
5. **Apply testing to legacy code** - Incremental improvement strategies
6. **Use realistic test data** - AI helps generate meaningful scenarios
7. **Iterate and improve** - Continuous testing enhancement

</v-clicks>

---

# Comparing Sessions 1-4

| Session 1-3 (Development) | Session 4 (Testing) |
|---------------------------|---------------------|
| Code generation | Test generation |
| Architecture planning | Testing strategy planning |
| AI collaboration | AI quality partnership |
| Manual development | Automated testing |
| Individual focus | Team quality assurance |
| Code creation | Code validation |

<v-clicks>

**Same principles, quality focus:**
- Natural language as interface
- Iterative refinement
- Context awareness
- Human-AI collaboration
- Quality verification

</v-clicks>

---

# Preview: Session 5

## Exploring Agents and MCP

<v-clicks>

**Coming up:**
- Advanced Model Context Protocol integrations
- Custom AI agents for specific domains
- Multi-agent collaboration patterns
- Enterprise AI tool integration
- Future of AI-assisted development

**Get ready to explore the cutting edge!**

</v-clicks>

---

# Homework / Lab Exercises

<v-clicks>

**Part A: Reinforce Today's Learning**
- Complete testing suite generation (if not done)
- Apply AI debugging to test failures
- Create custom testing workflows
- Integrate testing into CI/CD pipeline

**Part B: Legacy Code Testing Challenges**
- Analyze provided legacy codebase
- Create testing strategy
- Apply incremental testing approach
- Document testing improvements

**See `testing_labs.md` for details**

</v-clicks>

---

# Resources

**Testing Resources:**
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [TestContainers Documentation](https://www.testcontainers.org/)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [AssertJ Documentation](https://assertj.github.io/doc/)

**AI Testing:**
- [Cursor Documentation - Testing](https://docs.cursor.com)
- [AI-Assisted Testing Best Practices](https://cursor.com/blog/ai-testing)
- [Quality Assurance with AI](https://cursor.com/blog/quality-assurance)

---

# Questions?

<div class="text-center mt-10">
  <h2>Open Q&A</h2>
  <p class="text-xl mt-4">
    Ask about anything we covered today:
  </p>
  <ul class="text-left mx-auto max-w-2xl mt-6">
    <li>AI test generation</li>
    <li>Unit testing with Mockito & AssertJ</li>
    <li>Integration testing with TestContainers</li>
    <li>End-to-end testing</li>
    <li>AI debugging</li>
    <li>Legacy code testing</li>
  </ul>
</div>

---

# Thank You!

**Contact:**
- ken.kousen@kousenit.com
- http://kousenit.com
- [@kenkousen](https://twitter.com/kenkousen)

**Continue Learning:**
- Apply AI testing to your projects
- Explore the testing tools and frameworks
- Join us for Session 5!

<div class="text-center mt-8">
  <p class="text-2xl">Happy AI Testing! 🧪🤖✅</p>
</div>

