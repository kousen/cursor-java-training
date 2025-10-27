# Session 4: Lab Exercises

**Reviewing and Testing Code Using Cursor and Claude**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: AI Testing Setup](#lab-0-ai-testing-setup)
2. [Lab 1: Unit Test Generation](#lab-1-unit-test-generation)
3. [Lab 2: Integration Testing](#lab-2-integration-testing)
4. [Lab 3: End-to-End Testing](#lab-3-end-to-end-testing)
5. [Lab 4: Performance Testing](#lab-4-performance-testing)
6. [Lab 5: Security Testing](#lab-5-security-testing)
7. [Lab 6: CI/CD Integration](#lab-6-cicd-integration)
8. [Lab 7: AI Debugging](#lab-7-ai-debugging)

### Part B: Exploration Exercises (Homework/Practice)
9. [Lab 8: Legacy Code Testing](#lab-8-legacy-code-testing)
10. [Lab 9: Advanced Performance Testing](#lab-9-advanced-performance-testing)
11. [Lab 10: Security Testing Deep Dive](#lab-10-security-testing-deep-dive)

---

## Part A: Code-Along Exercises (In-Class)

These exercises are designed to be completed during the session with instructor guidance. They can be repeated independently for practice.

---

## Lab 0: AI Testing Setup

**Goal:** Understand AI testing philosophy and test generation strategies  
**Time:** 10 minutes

### Prerequisites

- Cursor installed and configured
- Understanding of Sessions 1-3 concepts
- E-commerce application (from Session 3)

### **Steps**

1. **Open the E-commerce Application**

   Navigate to the modular e-commerce application:
   ```
   ecommerce-modular/
   ├── user-module/
   ├── product-module/
   ├── order-module/
   ├── payment-module/
   └── shared-lib/
   ```

2. **Test AI Testing Philosophy**

   **Extended Thinking Analysis:**
   ```
   Extended Thinking: "Analyze this e-commerce application and create a 
   comprehensive testing strategy. Identify what types of tests are needed 
   and prioritize them based on risk and business value."
   ```

   **Expected Response:**
   - Testing strategy overview
   - Test type prioritization
   - Risk assessment
   - Coverage recommendations

3. **Compare Testing Approaches**

   **Traditional Approach:**
   ```
   Chat Mode: "What unit tests should I write for UserService?"
   ```

   **AI-Assisted Approach:**
   ```
   Extended Thinking: "Generate comprehensive unit tests for UserService 
   including edge cases, error conditions, and boundary value testing."
   ```

   **Notice the difference:**
   - Traditional: Specific, limited scope
   - AI-Assisted: Comprehensive, strategic approach

### Success Criteria

- ✅ Extended Thinking provides comprehensive testing strategy
- ✅ Understanding of AI testing philosophy
- ✅ Recognition of when to use different AI modes for testing

---

## Lab 1: Unit Test Generation

**Goal:** Generate comprehensive unit tests using AI assistance  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: Service Layer Testing (15 min)

1. **Generate Service Tests**

   **Agent Mode:**
   ```
   Generate comprehensive unit tests for UserService using JUnit 5, Mockito, 
   and AssertJ. Test all public methods with comprehensive scenarios including 
   happy path, edge cases, and error conditions.
   ```

2. **Review Generated Tests**

   **Expected Test Structure:**
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
       
       @Test
       @DisplayName("Should throw exception when email already exists")
       void shouldThrowExceptionWhenEmailExists() {
           // Test implementation
       }
   }
   ```

3. **Examine Test Features**

   **Key Elements to Review:**
   - Test structure and organization
   - Mocking strategies
   - Assertion patterns
   - Edge case coverage
   - Error scenario testing

### Step 2: Repository Testing (10 min)

1. **Generate Repository Tests**

   **Plan Mode:**
   ```
   Create unit tests for UserRepository using @DataJpaTest. Test all CRUD 
   operations, custom query methods, and error conditions.
   ```

2. **Review Generated Tests**

   **Expected Test Structure:**
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

3. **Run Tests**

   **Execute Tests:**
   ```bash
   ./mvnw test
   ```

   **Verify Results:**
   - All tests pass
   - Coverage report generated
   - Test execution time reasonable

### Success Criteria

- ✅ Service layer tests generated successfully
- ✅ Repository tests generated successfully
- ✅ Tests use modern JUnit 5 patterns
- ✅ Comprehensive test coverage achieved

---

## Lab 2: Integration Testing

**Goal:** Set up integration testing with TestContainers and service mocking  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: TestContainers Setup (15 min)

1. **Generate Integration Tests**

   **Extended Thinking:**
   ```
   Set up TestContainers for integration testing with PostgreSQL. Create tests 
   that verify database operations, transactions, and data consistency for 
   the User module.
   ```

2. **Review Generated Setup**

   **Expected Test Structure:**
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
       
       @Autowired
       private UserService userService;
       
       @Test
       @DisplayName("Should create and retrieve user from database")
       void shouldCreateAndRetrieveUser() {
           // Given
           UserRequest request = new UserRequest("John", "Doe", "john@example.com");
           
           // When
           User created = userService.createUser(request);
           User retrieved = userService.findById(created.getId());
           
           // Then
           assertThat(retrieved).isNotNull();
           assertThat(retrieved.getEmail()).isEqualTo("john@example.com");
       }
   }
   ```

3. **Test Integration**

   **Run Integration Tests:**
   ```bash
   ./mvnw verify
   ```

   **Verify Results:**
   - TestContainers starts PostgreSQL
   - Tests execute against real database
   - Transaction handling works correctly

### Step 2: External Service Mocking (10 min)

1. **Setup WireMock**

   **Agent Mode:**
   ```
   Set up WireMock for mocking external services. Create integration tests 
   for payment processing and email notifications in the Order module.
   ```

2. **Review Generated Tests**

   **Expected Test Structure:**
   ```java
   @SpringBootTest
   @AutoConfigureWireMock(port = 8089)
   class OrderIntegrationTest {
       
       @Autowired
       private OrderService orderService;
       
       @Test
       @DisplayName("Should process order with payment and email")
       void shouldProcessOrderWithPaymentAndEmail() {
           // Given
           stubFor(post(urlEqualTo("/api/payments"))
                   .willReturn(aResponse()
                           .withStatus(200)
                           .withHeader("Content-Type", "application/json")
                           .withBody("{\"status\":\"success\",\"transactionId\":\"12345\"}")));
           
           stubFor(post(urlEqualTo("/api/emails"))
                   .willReturn(aResponse()
                           .withStatus(200)
                           .withHeader("Content-Type", "application/json")
                           .withBody("{\"status\":\"sent\"}")));
           
           // When
           Order order = orderService.processOrder(orderRequest);
           
           // Then
           assertThat(order.getStatus()).isEqualTo(OrderStatus.CONFIRMED);
           verify(postRequestedFor(urlEqualTo("/api/payments")));
           verify(postRequestedFor(urlEqualTo("/api/emails")));
       }
   }
   ```

3. **Test Service Mocking**

   **Run Tests:**
   ```bash
   ./mvnw test -Dtest=OrderIntegrationTest
   ```

   **Verify Results:**
   - WireMock starts successfully
   - External service calls are mocked
   - Tests execute without external dependencies

### Success Criteria

- ✅ TestContainers integration working
- ✅ Database integration tests passing
- ✅ WireMock setup successful
- ✅ External service mocking working

---

## Lab 3: End-to-End Testing

**Goal:** Create comprehensive end-to-end tests for complete workflows  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: API Testing (10 min)

1. **Generate API Tests**

   **Extended Thinking:**
   ```
   Create comprehensive API tests for the e-commerce application. Include 
   authentication, authorization, data validation, and error handling scenarios.
   ```

2. **Review Generated Tests**

   **Expected Test Structure:**
   ```java
   @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
   @TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
   class EcommerceApiIntegrationTest {
       
       @Autowired
       private TestRestTemplate restTemplate;
       
       @Test
       @DisplayName("Should complete full order workflow")
       void shouldCompleteFullOrderWorkflow() {
           // Given
           UserRequest userRequest = new UserRequest("John", "Doe", "john@example.com");
           
           // When - Register user
           ResponseEntity<UserResponse> userResponse = restTemplate.postForEntity(
               "/api/users", userRequest, UserResponse.class);
           
           // When - Browse products
           ResponseEntity<ProductResponse[]> productsResponse = restTemplate.getForEntity(
               "/api/products", ProductResponse[].class);
           
           // When - Create order
           OrderRequest orderRequest = new OrderRequest(
               userResponse.getBody().getId(),
               Arrays.asList(productsResponse.getBody()[0].getId())
           );
           
           ResponseEntity<OrderResponse> orderResponse = restTemplate.postForEntity(
               "/api/orders", orderRequest, OrderResponse.class);
           
           // Then
           assertThat(userResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
           assertThat(productsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
           assertThat(orderResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
           assertThat(orderResponse.getBody().getStatus()).isEqualTo(OrderStatus.CONFIRMED);
       }
   }
   ```

3. **Test API Workflow**

   **Run Tests:**
   ```bash
   ./mvnw test -Dtest=EcommerceApiIntegrationTest
   ```

### Step 2: Workflow Testing (10 min)

1. **Create Workflow Tests**

   **Plan Mode:**
   ```
   Create end-to-end tests for the complete order processing workflow from 
   user login to order completion.
   ```

2. **Review Generated Tests**

   **Expected Test Scenarios:**
   - User registration and authentication
   - Product browsing and selection
   - Cart management
   - Checkout process
   - Order confirmation
   - Email notifications

3. **Test Complete Workflow**

   **Run Tests:**
   ```bash
   ./mvnw test -Dtest=OrderWorkflowTest
   ```

   **Verify Results:**
   - Complete workflow executes successfully
   - All integration points work correctly
   - Error handling scenarios covered

### Success Criteria

- ✅ API tests generated successfully
- ✅ Workflow tests created
- ✅ End-to-end tests passing
- ✅ Complete user journey validated

---

## Lab 4: Performance Testing

**Goal:** Set up performance testing with JMeter and AI analysis  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Performance Analysis (10 min)

1. **AI Performance Analysis**

   **Extended Thinking:**
   ```
   Analyze the e-commerce application for performance bottlenecks. Create 
   performance tests using JMeter and identify optimization opportunities.
   ```

2. **Review Performance Analysis**

   **Expected Analysis:**
   - Bottleneck identification
   - Resource utilization analysis
   - Database query optimization
   - Caching opportunities
   - Memory usage patterns

3. **Performance Test Generation**

   **Plan Mode:**
   ```
   Generate JMeter test plans for critical user journeys including user 
   registration, product browsing, and order processing.
   ```

### Step 2: JMeter Test Implementation (10 min)

1. **Review Generated JMeter Tests**

   **Expected Test Plan Structure:**
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <jmeterTestPlan version="1.2">
     <hashTree>
       <TestPlan testname="E-commerce Performance Test">
         <elementProp name="TestPlan.arguments" elementType="Arguments" guiclass="ArgumentsPanel">
           <collectionProp name="Arguments.arguments"/>
         </elementProp>
         <stringProp name="TestPlan.user_define_classpath"></stringProp>
         <boolProp name="TestPlan.functional_mode">false</boolProp>
         <boolProp name="TestPlan.tearDown_on_shutdown">true</boolProp>
         <boolProp name="TestPlan.serialize_threadgroups">false</boolProp>
       </TestPlan>
       <hashTree>
         <ThreadGroup testname="User Registration Load Test">
           <stringProp name="ThreadGroup.num_threads">50</stringProp>
           <stringProp name="ThreadGroup.ramp_time">60</stringProp>
           <stringProp name="ThreadGroup.duration">300</stringProp>
         </ThreadGroup>
       </hashTree>
     </hashTree>
   </jmeterTestPlan>
   ```

2. **Run Performance Tests**

   **Execute JMeter Tests:**
   ```bash
   jmeter -n -t ecommerce-performance.jmx -l results.jtl
   ```

3. **Analyze Results**

   **Review Performance Metrics:**
   - Response times
   - Throughput
   - Error rates
   - Resource utilization

### Success Criteria

- ✅ Performance analysis completed
- ✅ JMeter tests generated
- ✅ Performance tests executed
- ✅ Optimization opportunities identified

---

## Lab 5: Security Testing

**Goal:** Conduct security testing with OWASP ZAP and AI assessment  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Security Assessment (10 min)

1. **AI Security Analysis**

   **Extended Thinking:**
   ```
   Conduct a comprehensive security assessment of the e-commerce application. 
   Identify vulnerabilities and create security tests using OWASP ZAP.
   ```

2. **Review Security Analysis**

   **Expected Assessment:**
   - Vulnerability identification
   - Authentication testing
   - Authorization testing
   - Input validation testing
   - SQL injection testing
   - XSS vulnerability testing

3. **Security Test Generation**

   **Agent Mode:**
   ```
   Generate security tests for the e-commerce application including 
   authentication bypass, SQL injection, and XSS vulnerability testing.
   ```

### Step 2: OWASP ZAP Integration (5 min)

1. **Review Generated Security Tests**

   **Expected Test Structure:**
   ```java
   @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
   class SecurityTest {
       
       @Autowired
       private TestRestTemplate restTemplate;
       
       @Test
       @DisplayName("Should prevent SQL injection in user search")
       void shouldPreventSqlInjection() {
           // Given
           String maliciousInput = "'; DROP TABLE users; --";
           
           // When
           ResponseEntity<String> response = restTemplate.getForEntity(
               "/api/users/search?query=" + maliciousInput, String.class);
           
           // Then
           assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
           // Verify database is not compromised
       }
       
       @Test
       @DisplayName("Should prevent XSS in user input")
       void shouldPreventXss() {
           // Test implementation
       }
   }
   ```

2. **Run Security Tests**

   **Execute Security Tests:**
   ```bash
   ./mvnw test -Dtest=SecurityTest
   ```

3. **Analyze Security Results**

   **Review Security Metrics:**
   - Vulnerability count
   - Risk levels
   - Remediation recommendations

### Success Criteria

- ✅ Security assessment completed
- ✅ Security tests generated
- ✅ OWASP ZAP integration working
- ✅ Vulnerabilities identified and tested

---

## Lab 6: CI/CD Integration

**Goal:** Integrate testing into CI/CD pipeline with quality gates  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: GitHub Actions Setup (10 min)

1. **Generate CI/CD Pipeline**

   **Extended Thinking:**
   ```
   Design a comprehensive CI/CD pipeline using GitHub Actions that includes 
   unit tests, integration tests, performance tests, and security scans.
   ```

2. **Review Generated Pipeline**

   **Expected Pipeline Structure:**
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
       
       - name: Run unit tests
         run: ./mvnw test
         
       - name: Run integration tests
         run: ./mvnw verify
         
       - name: Generate coverage report
         run: ./mvnw jacoco:report
         
       - name: Upload coverage to Codecov
         uses: codecov/codecov-action@v3
   ```

3. **Test Pipeline**

   **Commit and Push:**
   ```bash
   git add .github/workflows/ci.yml
   git commit -m "Add CI/CD pipeline"
   git push origin main
   ```

### Step 2: Quality Gates (5 min)

1. **Create Quality Gates**

   **Agent Mode:**
   ```
   Create quality gates that prevent deployment if tests fail, coverage 
   drops below threshold, or security vulnerabilities are detected.
   ```

2. **Review Quality Gate Configuration**

   **Expected Quality Gates:**
   - Test coverage minimum (80%)
   - Performance benchmarks
   - Security vulnerability limits
   - Code quality metrics

3. **Test Quality Gates**

   **Trigger Pipeline with Issues:**
   - Introduce failing test
   - Verify deployment prevention
   - Test notification system

### Success Criteria

- ✅ CI/CD pipeline created
- ✅ Quality gates configured
- ✅ Pipeline executes successfully
- ✅ Quality gates prevent bad deployments

---

## Lab 7: AI Debugging

**Goal:** Use AI for intelligent debugging and troubleshooting  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Test Failure Analysis (10 min)

1. **Introduce Test Failure**

   **Create Failing Test:**
   ```java
   @Test
   @DisplayName("Should handle null user gracefully")
   void shouldHandleNullUser() {
       // Given
       UserRequest request = null;
       
       // When
       User result = userService.createUser(request);
       
       // Then
       assertThat(result).isNotNull();
   }
   ```

2. **AI Debugging Analysis**

   **Extended Thinking:**
   ```
   Analyze this failing test and provide debugging guidance. Identify the 
   root cause and suggest fixes.
   ```

3. **Review Debugging Process**

   **Expected Analysis:**
   - Error analysis and interpretation
   - Root cause identification
   - Fix recommendation
   - Prevention strategies

### Step 2: Debugging Implementation (5 min)

1. **Apply AI Recommendations**

   **Fix the Test:**
   ```java
   @Test
   @DisplayName("Should throw exception for null user request")
   void shouldThrowExceptionForNullUserRequest() {
       // Given
       UserRequest request = null;
       
       // When & Then
       assertThatThrownBy(() -> userService.createUser(request))
           .isInstanceOf(IllegalArgumentException.class)
           .hasMessage("User request cannot be null");
   }
   ```

2. **Validate Fix**

   **Run Tests:**
   ```bash
   ./mvnw test
   ```

3. **Learn from Debugging**

   **Document Lessons:**
   - Error patterns
   - Debugging strategies
   - Prevention measures

### Success Criteria

- ✅ AI debugging analysis completed
- ✅ Root cause identified
- ✅ Fix implemented successfully
- ✅ Debugging strategies learned

---

## 🎉 Checkpoint: AI Testing Complete!

**Congratulations!** You now have:

- ✅ Comprehensive test suite generation with AI
- ✅ Integration testing with TestContainers
- ✅ End-to-end testing strategies
- ✅ Performance testing with JMeter
- ✅ Security testing with OWASP ZAP
- ✅ CI/CD integration with quality gates
- ✅ AI-powered debugging skills

**Time for a break, then we'll explore legacy code testing!**

---

## Part B: Exploration Exercises (Homework/Practice)

These exercises help you practice applying AI testing strategies to real-world scenarios. Complete them at your own pace.

---

## Lab 8: Legacy Code Testing

**Goal:** Apply AI testing strategies to legacy code modernization  
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
   └── pom.xml
   ```

2. **Initial Assessment**

   **Extended Thinking Analysis:**
   ```
   Extended Thinking: "Analyze this legacy Java application and create a 
   testing strategy. Identify testing challenges and recommend approaches 
   for improving test coverage."
   ```

### Exercise 1: Testing Challenge Analysis (15 min)

**Use Extended Thinking to explore:**

1. **Current Test Coverage:**
   ```
   Extended Thinking: "Analyze the current test coverage in this legacy 
   application. What areas are tested and what gaps exist?"
   ```

2. **Testing Challenges:**
   ```
   Extended Thinking: "Identify the main testing challenges in this 
   legacy codebase. What makes it difficult to test?"
   ```

3. **Risk Assessment:**
   ```
   Extended Thinking: "Assess the risks of adding tests to this legacy 
   code. What could go wrong and how can we mitigate those risks?"
   ```

**Document your findings** in `legacy-testing-analysis.md`

### Exercise 2: Incremental Testing Strategy (15 min)

**Create Testing Strategy:**

1. **Characterization Testing:**
   ```
   Extended Thinking: "Design a characterization testing approach for 
   this legacy application. How can we understand current behavior before 
   adding comprehensive tests?"
   ```

2. **Incremental Test Addition:**
   ```
   Extended Thinking: "Create a plan for incrementally adding tests to 
   this legacy codebase. What should be tested first and why?"
   ```

3. **Refactoring for Testability:**
   ```
   Extended Thinking: "Identify refactoring opportunities that would 
   make this legacy code more testable. What changes would have the 
   biggest impact?"
   ```

### Exercise 3: Legacy Test Implementation (15 min)

**Implement Testing Strategy:**

1. **Characterization Tests:**
   ```
   Agent Mode: "Create characterization tests for the UserService class 
   in this legacy application. Focus on understanding current behavior."
   ```

2. **Incremental Tests:**
   ```
   Plan Mode: "Add unit tests to the OrderService class following the 
   incremental testing strategy."
   ```

3. **Refactoring Tests:**
   ```
   Extended Thinking: "Refactor the PaymentService class to improve 
   testability and add comprehensive tests."
   ```

### Exercise 4: Legacy Testing Validation (15 min)

**Validate Testing Approach:**

1. **Test Coverage Analysis:**
   ```
   Extended Thinking: "Analyze the test coverage improvement after 
   implementing the legacy testing strategy. What progress was made?"
   ```

2. **Risk Mitigation:**
   ```
   Extended Thinking: "Evaluate the risk mitigation strategies used 
   in the legacy testing approach. Were the risks successfully managed?"
   ```

3. **Lessons Learned:**
   ```
   Extended Thinking: "Document lessons learned from applying AI testing 
   strategies to legacy code. What worked well and what could be improved?"
   ```

### Success Criteria

- ✅ Legacy code testing challenges identified
- ✅ Incremental testing strategy created
- ✅ Characterization tests implemented
- ✅ Test coverage improved
- ✅ Risk mitigation strategies applied
- ✅ Lessons learned documented

---

## Lab 9: Advanced Performance Testing

**Goal:** Explore advanced performance testing scenarios and optimization  
**Time:** 30-45 minutes  
**Mode:** Self-paced exploration

### Exercise 1: Stress Testing (15 min)

**Advanced Stress Testing:**

1. **Stress Test Design:**
   ```
   Extended Thinking: "Design comprehensive stress tests for the 
   e-commerce application. Include scenarios that push the system 
   beyond normal capacity."
   ```

2. **Breaking Point Analysis:**
   ```
   Extended Thinking: "Create tests to identify the breaking point 
   of the e-commerce application. What happens when load exceeds capacity?"
   ```

3. **Recovery Testing:**
   ```
   Extended Thinking: "Design recovery tests to verify system behavior 
   after stress conditions. How does the system recover from overload?"
   ```

### Exercise 2: Performance Optimization (15 min)

**AI-Guided Optimization:**

1. **Bottleneck Identification:**
   ```
   Extended Thinking: "Analyze performance test results to identify 
   specific bottlenecks in the e-commerce application."
   ```

2. **Optimization Recommendations:**
   ```
   Extended Thinking: "Provide specific optimization recommendations 
   for the identified performance bottlenecks."
   ```

3. **Optimization Implementation:**
   ```
   Plan Mode: "Implement the recommended performance optimizations 
   and create tests to verify improvements."
   ```

### Exercise 3: Performance Monitoring (15 min)

**Continuous Performance Monitoring:**

1. **Monitoring Strategy:**
   ```
   Extended Thinking: "Design a comprehensive performance monitoring 
   strategy for the e-commerce application."
   ```

2. **Alert Configuration:**
   ```
   Extended Thinking: "Create performance alert configurations for 
   proactive monitoring and issue detection."
   ```

3. **Performance Regression Testing:**
   ```
   Extended Thinking: "Design performance regression tests to prevent 
   performance degradation over time."
   ```

### Success Criteria

- ✅ Advanced stress testing implemented
- ✅ Performance bottlenecks identified
- ✅ Optimization recommendations applied
- ✅ Performance monitoring strategy created
- ✅ Regression testing implemented

---

## Lab 10: Security Testing Deep Dive

**Goal:** Explore advanced security testing and vulnerability assessment  
**Time:** 30-45 minutes  
**Mode:** Self-paced exploration

### Exercise 1: Penetration Testing (15 min)

**Advanced Penetration Testing:**

1. **Penetration Test Design:**
   ```
   Extended Thinking: "Design comprehensive penetration tests for the 
   e-commerce application. Include various attack vectors and scenarios."
   ```

2. **Attack Vector Analysis:**
   ```
   Extended Thinking: "Analyze potential attack vectors for the 
   e-commerce application. What are the most likely security threats?"
   ```

3. **Vulnerability Exploitation:**
   ```
   Extended Thinking: "Create tests that attempt to exploit identified 
   vulnerabilities in the e-commerce application."
   ```

### Exercise 2: Security Compliance (15 min)

**Compliance Testing:**

1. **Compliance Requirements:**
   ```
   Extended Thinking: "Identify security compliance requirements for 
   the e-commerce application. What standards should be followed?"
   ```

2. **Compliance Testing:**
   ```
   Extended Thinking: "Create tests to verify compliance with security 
   standards and regulations."
   ```

3. **Compliance Reporting:**
   ```
   Extended Thinking: "Design compliance reporting mechanisms for 
   security testing results."
   ```

### Exercise 3: Security Monitoring (15 min)

**Continuous Security Monitoring:**

1. **Security Monitoring Strategy:**
   ```
   Extended Thinking: "Design a comprehensive security monitoring 
   strategy for the e-commerce application."
   ```

2. **Threat Detection:**
   ```
   Extended Thinking: "Create threat detection mechanisms and alert 
   configurations for security monitoring."
   ```

3. **Incident Response:**
   ```
   Extended Thinking: "Design incident response procedures for security 
   issues detected through monitoring."
   ```

### Success Criteria

- ✅ Advanced penetration testing implemented
- ✅ Security compliance testing created
- ✅ Security monitoring strategy designed
- ✅ Threat detection mechanisms implemented
- ✅ Incident response procedures documented

---

## Bonus Challenges

### Challenge: Multi-Environment Testing

**Advanced: Test across multiple environments**

1. **Environment Strategy:**
   ```
   Extended Thinking: "Design a testing strategy that works across 
   development, staging, and production environments."
   ```

2. **Environment-Specific Tests:**
   ```
   Extended Thinking: "Create environment-specific tests that adapt 
   to different deployment configurations."
   ```

### Challenge: AI Test Maintenance

**Advanced: Automated test maintenance**

1. **Test Maintenance Strategy:**
   ```
   Extended Thinking: "Design an AI-powered test maintenance strategy 
   that keeps tests up-to-date with code changes."
   ```

2. **Automated Test Refactoring:**
   ```
   Extended Thinking: "Create automated test refactoring mechanisms 
   that improve test quality over time."
   ```

### Challenge: Testing Metrics and Analytics

**Advanced: Testing analytics and insights**

1. **Testing Metrics:**
   ```
   Extended Thinking: "Design comprehensive testing metrics and 
   analytics for the e-commerce application."
   ```

2. **Testing Insights:**
   ```
   Extended Thinking: "Create AI-powered testing insights that provide 
   actionable recommendations for test improvement."
   ```

---

## Final Reflection

After completing these labs, reflect on:

1. **AI Testing Adoption:**
   - How has your approach to testing changed?
   - What AI testing strategies do you find most valuable?
   - How do you decide when to use different AI modes for testing?

2. **Testing Quality:**
   - How do you ensure AI-generated tests are high quality?
   - What strategies help you get better test coverage?
   - How do you handle AI-generated test failures?

3. **Team Integration:**
   - How would you introduce AI testing to your team?
   - What challenges do you anticipate in team adoption?
   - How would you measure success of AI testing adoption?

4. **Future Applications:**
   - What other areas could benefit from AI testing?
   - How might AI testing evolve in the future?
   - What skills will be most important for testers?

**Document in:** `ai-testing-reflection.md`

---

## Additional Resources

### Testing Resources
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [TestContainers Documentation](https://www.testcontainers.org/)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [JMeter User Manual](https://jmeter.apache.org/usermanual/)

### AI Testing
- [Cursor Documentation - Testing](https://docs.cursor.com)
- [AI-Assisted Testing Best Practices](https://cursor.com/blog/ai-testing)
- [Quality Assurance with AI](https://cursor.com/blog/quality-assurance)

### Security Testing
- [OWASP ZAP Documentation](https://www.zaproxy.org/docs/)
- [OWASP Testing Guide](https://owasp.org/www-project-web-security-testing-guide/)
- [Security Testing Best Practices](https://owasp.org/www-project-top-ten/)

### Next Steps
- Session 5: Exploring Agents and MCP
- Apply AI testing to your own projects
- Experiment with advanced testing scenarios
- Explore testing tool integrations

---

**Happy AI Testing! 🧪🤖✅**
