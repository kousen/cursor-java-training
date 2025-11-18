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
- **Code Review and Quality Analysis** - AI-powered quality assessment
- **Integration Testing Strategies** - TestContainers and service mocking
- **End-to-End Testing** - Complete workflow validation
- **Performance and Security Testing** - JMeter and OWASP ZAP integration
- **CI/CD Integration** - Automated testing pipelines
- **AI-Powered Debugging** - Intelligent troubleshooting

</v-clicks>

---

# Two Projects Today

<v-clicks>

## Project 1: E-Commerce Testing Suite
Build comprehensive testing strategy with AI assistance:
- Unit Tests (JUnit 5, Mockito, AssertJ)
- Integration Tests (TestContainers, @DataJpaTest)
- End-to-End Tests (API testing, workflow validation)
- Performance Tests (JMeter, load testing)
- Security Tests (OWASP ZAP, vulnerability assessment)
- CI/CD Integration (GitHub Actions, quality gates)

## Project 2: Legacy Code Testing
Apply AI testing strategies to real-world legacy systems

</v-clicks>

---

layout: two-cols
---

# Sessions 1-3 Recap

## What You Learned

<v-clicks>

- **Chat Mode** (Cmd/Ctrl+L)
  - Ask questions, understand code
  
- **Agent Mode** (Cmd/Ctrl+I)
  - Generate code, refactor
  
- **Composer Mode** (Cmd/Ctrl+Shift+I)
  - Multi-file generation
  
- **Extended Thinking**
  - Complex analysis and planning
  
- **Plan Mode**
  - Multi-phase project execution

</v-clicks>

::right::

# Today: AI Testing

## The Quality Focus

<v-clicks>

- **Test Generation** - AI creates comprehensive test suites
- **Quality Analysis** - AI reviews code for issues
- **Debugging Assistance** - AI helps troubleshoot failures
- **Performance Testing** - AI identifies bottlenecks
- **Security Assessment** - AI finds vulnerabilities
- **CI/CD Integration** - AI automates quality gates

**Key Shift:** From AI as development tool to AI as quality partner

</v-clicks>

---

# Part 1: AI-Assisted Test Generation

## The Testing Paradigm Shift

---

# Traditional vs AI-Assisted Testing

<div class="grid grid-cols-2 gap-8">
<div>

## Traditional Testing

<v-clicks>

- Manual test writing
- Limited test coverage
- Reactive quality assurance
- Time-consuming maintenance
- Human bias in test design

</v-clicks>

</div>
<div>

## AI-Assisted Testing

<v-clicks>

- Automated test generation
- Comprehensive coverage analysis
- Proactive quality assurance
- Intelligent test maintenance
- Objective test scenario design

</v-clicks>

</div>
</div>

---

# AI Testing Philosophy

<v-clicks>

## 1. Coverage-Driven
AI identifies gaps in test coverage
- Missing edge cases
- Untested code paths
- Boundary value testing
- Error condition coverage

## 2. Scenario-Based
AI generates realistic test scenarios
- User journey testing
- Business logic validation
- Integration point testing
- Performance scenario testing

---

# AI Testing Philosophy (Continued)

## 3. Maintenance-Aware
AI helps keep tests up-to-date
- Test refactoring
- Deprecated API updates
- Configuration changes
- Dependency updates

## 4. Quality-Focused
AI ensures tests actually test something
- Meaningful assertions
- Proper test data
- Realistic scenarios
- Actionable failures

</v-clicks>

---

# Test Generation Strategies

<v-clicks>

## Unit Test Generation
- Method-level testing with edge cases
- Mocking strategies
- Assertion patterns
- Error condition testing

## Integration Test Generation
- Component interaction testing
- Database integration
- External service mocking
- Transaction testing

## End-to-End Test Generation
- Full workflow testing
- User journey validation
- API contract testing
- Cross-system integration

---

# Test Generation Strategies (Continued)

## Performance Test Generation
- Load testing scenarios
- Stress testing patterns
- Performance metrics
- Bottleneck identification

## Security Test Generation
- Vulnerability testing
- Penetration testing
- Security scanning
- Compliance validation

</v-clicks>

---

# Demo: AI Test Generation

**Service Layer Testing:**
```
Extended Thinking: "Generate comprehensive unit tests for the UserService 
class. Include happy path scenarios, edge cases, error conditions, and 
boundary value testing. Use JUnit 5, Mockito, and AssertJ."
```

<v-clicks>

**AI Response Process:**
1. **Analysis Phase** - Understanding the service class
2. **Strategy Phase** - Identifying test scenarios
3. **Generation Phase** - Creating comprehensive tests
4. **Validation Phase** - Ensuring test quality

**Generated Test Features:**
- Happy path scenarios
- Edge case testing
- Error condition handling
- Boundary value testing
- Mocking strategies
- Assertion patterns

</v-clicks>

---

# Part 2: Comprehensive Unit Testing

## JUnit 5, Mockito, and AssertJ

---

# Unit Testing Strategies

<v-clicks>

## Service Layer Testing
- Mock dependencies
- Test business logic
- Verify error handling
- Validate edge cases

## Repository Testing
- Use @DataJpaTest
- Test CRUD operations
- Verify custom queries
- Test transaction handling

---

# Unit Testing Strategies (Continued)

## Controller Testing
- Use @WebMvcTest
- Test endpoint mapping
- Verify request validation
- Test response formats

## Utility Testing
- Test static methods
- Verify edge cases
- Test error conditions
- Validate performance

</v-clicks>

---

# Demo: Service Layer Testing

**UserService Test Generation:**
```
Agent Mode: "Generate unit tests for UserService using JUnit 5, Mockito, 
and AssertJ. Test all public methods with comprehensive scenarios."
```

<v-clicks>

**Generated Test Structure:**
```java
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    @Test
    @DisplayName("Should create user with valid data")
    void shouldCreateUserWithValidData() {
        // Given
        UserRequest request = new UserRequest("John", "Doe", "john@example.com");
        User savedUser = new User(1L, "John", "Doe", "john@example.com");
        
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        
        // When
        User result = userService.createUser(request);
        
        // Then
        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("John");
        verify(userRepository).save(any(User.class));
    }
}
```

---

# Demo: Service Layer Testing (Continued)

**Test Structure Benefits:**
- Comprehensive mocking strategy
- Clear test organization
- Proper assertion patterns
- Verification of interactions

</v-clicks>

---

# Demo: Repository Testing

**UserRepository Test Generation:**
```
Plan Mode: "Create unit tests for UserRepository using @DataJpaTest. 
Test all CRUD operations, custom query methods, and error conditions."
```

<v-clicks>

**Generated Test Structure:**
```java
@DataJpaTest
class UserRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    @DisplayName("Should find user by email")
    void shouldFindUserByEmail() {
        // Given
        User user = new User("John", "Doe", "john@example.com");
        entityManager.persistAndFlush(user);
        
        // When
        Optional<User> result = userRepository.findByEmail("john@example.com");
        
        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("john@example.com");
    }
}
```

</v-clicks>

---

# Student Exercise: Controller Testing

**Your Turn:**

<v-clicks>

1. **Generate Controller Tests:**
   ```
   Agent Mode: "Generate unit tests for UserController using @WebMvcTest. 
   Test all endpoints, request validation, error handling, and response formats."
   ```

2. **Review Generated Tests:**
   - Test endpoint coverage
   - Request/response validation
   - Error handling scenarios
   - Security testing
   - Performance considerations

3. **Refine and Improve:**
   - Add missing test scenarios
   - Improve test data
   - Enhance assertions
   - Add edge cases

**Goal:** Master AI-assisted unit test generation

</v-clicks>

---

# Part 3: Integration Testing Strategies

## TestContainers and Service Mocking

---

# Integration Testing Approaches

<v-clicks>

## Database Integration Testing
- Use TestContainers for real databases
- Test actual SQL queries
- Verify transaction handling
- Test data consistency

## Service Integration Testing
- Test component interactions
- Verify data flow
- Test error propagation
- Validate business logic

---

# Integration Testing Approaches (Continued)

## External Service Mocking
- Use WireMock for HTTP services
- Mock payment gateways
- Mock email services
- Mock third-party APIs

## Message Queue Testing
- Test asynchronous processing
- Verify message handling
- Test error scenarios
- Validate retry logic

</v-clicks>

---

# Demo: TestContainers Integration

**Database Integration Testing:**
```
Extended Thinking: "Set up TestContainers for integration testing 
with PostgreSQL. Create tests that verify database operations, 
transactions, and data consistency."
```

<v-clicks>

**Generated Test Setup:**
```java
@SpringBootTest
@Testcontainers
class UserIntegrationTest {
    
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");
    
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
```

---

# Demo: TestContainers Integration (Continued)

```java
@Test
@DisplayName("Should create and retrieve user from database")
void shouldCreateAndRetrieveUser() {
    // Test implementation
}
```

</v-clicks>

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
- Performance testing
- Data consistency validation

**Key Benefits:**
- Real database testing
- Actual component interaction
- Transaction boundary testing
- Performance validation
- Error scenario testing

</v-clicks>

---

# Student Exercise: External Service Mocking

**Your Turn:**

<v-clicks>

1. **Setup WireMock:**
   ```
   Agent Mode: "Set up WireMock for mocking external services. 
   Create integration tests for payment processing and email notifications."
   ```

2. **Configure Service Mocking:**
   - Payment gateway mocking
   - Email service mocking
   - Error scenario testing
   - Response validation

3. **Test Integration:**
   - Verify service calls
   - Test error handling
   - Validate response processing
   - Check retry logic

**Goal:** Master external service mocking with AI assistance

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

## API Testing
- Complete API workflow testing
- Authentication and authorization
- Data validation and processing
- Error handling and responses

## Workflow Testing
- User journey validation
- Business process testing
- State management testing
- Integration point verification

---

# End-to-End Testing Strategies (Continued)

## Cross-System Testing
- Multi-service integration
- Data consistency validation
- Performance under load
- Error propagation testing

## User Experience Testing
- UI workflow testing
- User interaction validation
- Performance from user perspective
- Accessibility testing

</v-clicks>

---

# Demo: Complete API Testing

**Comprehensive API Testing:**
```
Extended Thinking: "Create comprehensive API tests for the e-commerce 
application. Include authentication, authorization, data validation, 
and error handling scenarios."
```

<v-clicks>

**Generated API Tests:**
- Authentication flow testing
- Authorization scenario testing
- CRUD operation validation
- Data validation testing
- Error response verification
- Performance testing
- Security testing

**Test Structure:**
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
class EcommerceApiIntegrationTest {
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    @DisplayName("Should complete full order workflow")
    void shouldCompleteFullOrderWorkflow() {
        // Test implementation
    }
}
```

---

# Demo: Complete API Testing (Continued)

**Test Features:**
- Random port configuration
- In-memory database setup
- REST template integration
- Comprehensive workflow testing

</v-clicks>

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
   - Email notifications

---

# Student Exercise: Workflow Testing (Continued)

3. **Implement and Validate:**
   - Test data setup
   - Workflow execution
   - State validation
   - Error handling
   - Performance verification

**Goal:** Master end-to-end testing with AI assistance

</v-clicks>

---

# Part 5: Performance and Security Testing

## JMeter and OWASP ZAP Integration

---

# Performance Testing Strategies

<v-clicks>

## Load Testing
- Normal load scenarios
- Peak load testing
- Gradual load increase
- Sustained load testing

## Stress Testing
- Beyond normal capacity
- Breaking point identification
- Recovery testing
- Resource exhaustion testing

---

# Performance Testing Strategies (Continued)

## Volume Testing
- Large data set testing
- Database size testing
- File upload testing
- Memory usage testing

## Spike Testing
- Sudden load increases
- Traffic spike handling
- System recovery
- Performance degradation

</v-clicks>

---

# Demo: Performance Analysis

**AI-Guided Performance Testing:**
```
Extended Thinking: "Analyze the e-commerce application for performance 
bottlenecks. Create performance tests using JMeter and identify 
optimization opportunities."
```

<v-clicks>

**Performance Analysis:**
- Bottleneck identification
- Resource utilization analysis
- Database query optimization
- Caching opportunities
- Memory usage patterns
- CPU utilization analysis

**Generated JMeter Tests:**
- Load testing scenarios
- Stress testing patterns
- Performance metrics
- Threshold definitions
- Reporting configuration

</v-clicks>

---

# Demo: Security Testing

**AI-Assisted Security Assessment:**
```
Extended Thinking: "Conduct a comprehensive security assessment of 
the e-commerce application. Identify vulnerabilities and create 
security tests using OWASP ZAP."
```

<v-clicks>

**Security Assessment:**
- Vulnerability identification
- Authentication testing
- Authorization testing
- Input validation testing
- SQL injection testing
- XSS vulnerability testing

**Generated Security Tests:**
- Penetration testing scenarios
- Vulnerability scanning
- Security monitoring
- Compliance validation
- Remediation recommendations

</v-clicks>

---

# Part 6: CI/CD Integration and Automation

## GitHub Actions and Quality Gates

---

# CI/CD Testing Pipeline

<v-clicks>

## Automated Test Execution
- Unit test execution
- Integration test execution
- End-to-end test execution
- Performance test execution
- Security test execution

## Quality Gates
- Test coverage thresholds
- Performance benchmarks
- Security vulnerability limits
- Code quality metrics
- Documentation requirements

---

# CI/CD Testing Pipeline (Continued)

## Reporting and Notifications
- Test result reporting
- Coverage reporting
- Performance reporting
- Security reporting
- Failure notifications

## Deployment Automation
- Automated deployment
- Rollback procedures
- Environment promotion
- Configuration management
- Monitoring integration

</v-clicks>

---

# Demo: GitHub Actions Pipeline

**Automated Testing Pipeline:**
```
Extended Thinking: "Design a comprehensive CI/CD pipeline using 
GitHub Actions that includes unit tests, integration tests, 
performance tests, and security scans."
```

<v-clicks>

**Generated Pipeline:**
```yaml
name: CI/CD Pipeline

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
```

---

# Demo: GitHub Actions Pipeline (Continued)

```yaml
    - name: Run unit tests
      run: ./mvnw test
      
    - name: Run integration tests
      run: ./mvnw verify
      
    - name: Generate coverage report
      run: ./mvnw jacoco:report
      
    - name: Upload coverage to Codecov
      uses: codecov/codecov-action@v3
```

</v-clicks>

---

# Student Exercise: Quality Gates

**Your Turn:**

<v-clicks>

1. **Create Quality Gates:**
   ```
   Agent Mode: "Create quality gates that prevent deployment if tests 
   fail, coverage drops below threshold, or security vulnerabilities 
   are detected."
   ```

2. **Configure Thresholds:**
   - Test coverage minimum (80%)
   - Performance benchmarks
   - Security vulnerability limits
   - Code quality metrics

---

# Student Exercise: Quality Gates (Continued)

3. **Test Quality Gates:**
   - Trigger pipeline with failing tests
   - Verify deployment prevention
   - Test notification system
   - Validate rollback procedures

**Goal:** Master CI/CD quality assurance with AI

</v-clicks>

---

# Part 7: AI-Powered Debugging

## Intelligent Troubleshooting

---

# AI Debugging Strategies

<v-clicks>

## Error Analysis
- Stack trace interpretation
- Root cause identification
- Error pattern recognition
- Historical error analysis

## Test Failure Debugging
- Test failure analysis
- Environment issue identification
- Data problem detection
- Configuration error finding

---

# AI Debugging Strategies (Continued)

## Performance Debugging
- Bottleneck identification
- Resource usage analysis
- Performance regression detection
- Optimization opportunity finding

## Security Debugging
- Vulnerability analysis
- Security issue identification
- Attack vector analysis
- Remediation guidance

</v-clicks>

---

# Demo: AI-Guided Debugging

**Test Failure Analysis:**
```
Extended Thinking: "Analyze this failing test and provide debugging 
guidance. Identify the root cause and suggest fixes."
```

<v-clicks>

**Debugging Process:**
1. **Error Analysis** - Understanding the failure
2. **Root Cause Identification** - Finding the source
3. **Fix Recommendation** - Suggesting solutions
4. **Prevention Strategy** - Avoiding future issues

**AI Debugging Features:**
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

---

# Student Exercise: Test Failure Analysis (Continued)

3. **Learn from Failure:**
   - Understand error patterns
   - Improve test design
   - Enhance error handling
   - Document lessons learned

**Goal:** Master AI-assisted debugging techniques

</v-clicks>

---

# Part 8: Legacy Code Testing

## Testing Strategies for Legacy Systems

---

# Legacy Code Testing Challenges

<v-clicks>

## Testing Challenges
- Limited test coverage
- Tightly coupled code
- Missing documentation
- Outdated dependencies
- Complex business logic

## Testing Strategies
- Incremental test addition
- Characterization testing
- Refactoring for testability
- Legacy code modernization
- Risk-based testing

---

# Legacy Code Testing Challenges (Continued)

## Risk Assessment
- Business impact analysis
- Technical debt evaluation
- Testing priority ranking
- Resource allocation
- Timeline planning

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
Need performance tests? → Use Extended Thinking for analysis
Need security tests? → Use AI vulnerability assessment
Need debugging help? → Use Chat Mode for analysis
Need CI/CD integration? → Use Plan Mode for pipeline design
```

---

# What We Accomplished Today

<v-clicks>

✅ **Comprehensive Test Suite Generation** using AI assistance
✅ **AI-Assisted Code Review** and quality analysis
✅ **Integration Testing Strategies** with TestContainers
✅ **End-to-End Testing** for complete workflows
✅ **Performance and Security Testing** with specialized tools
✅ **CI/CD Integration** with quality gates
✅ **AI-Powered Debugging** and troubleshooting
✅ **Legacy Code Testing** strategies

**All with AI as your quality partner!**

</v-clicks>

---

# Best Practices We Learned

<v-clicks>

1. **Start with AI test generation** - Comprehensive coverage from the beginning
2. **Use appropriate testing strategies** - Unit, integration, e2e, performance, security
3. **Integrate testing into CI/CD** - Automated quality gates
4. **Leverage AI for debugging** - Intelligent troubleshooting
5. **Apply testing to legacy code** - Incremental improvement strategies
6. **Monitor and measure** - Quality metrics and reporting
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
- [JMeter User Manual](https://jmeter.apache.org/usermanual/)

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
    <li>Integration testing</li>
    <li>Performance testing</li>
    <li>Security testing</li>
    <li>CI/CD integration</li>
    <li>AI debugging</li>
    <li>Legacy code testing</li>
  </ul>
</div>

---

layout: end
---

# Thank You!

**Contact:**
- ken.kousen@kousenit.com
- http://kousenit.com
- [@kenkousen](https://twitter.com/kenkousen)

**Continue Learning:**
- Complete homework labs
- Apply AI testing to your projects
- Experiment with quality assurance
- Join us for Session 5!

<div class="text-center mt-8">
  <p class="text-2xl">Happy AI Testing! 🧪🤖✅</p>
</div>

