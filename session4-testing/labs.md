# Session 4: Lab Exercises

**Reviewing and Testing Code Using Cursor and Claude**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: AI Testing Setup](#lab-0-ai-testing-setup)
2. [Lab 1: Unit Test Generation with Mockito & AssertJ](#lab-1-unit-test-generation-with-mockito--assertj)
3. [Lab 2: Integration Testing with TestContainers](#lab-2-integration-testing-with-testcontainers)
4. [Lab 3: End-to-End Testing](#lab-3-end-to-end-testing)
5. [Lab 4: AI Debugging](#lab-4-ai-debugging)

### Part B: Exploration Exercises (Homework/Practice)
6. [Lab 5: Legacy Code Testing](#lab-5-legacy-code-testing)
7. [Lab 6: Advanced Mocking Scenarios](#lab-6-advanced-mocking-scenarios)

---

## Part A: Code-Along Exercises (In-Class)

These exercises are designed to be completed during the session with instructor guidance.

---

## Lab 0: AI Testing Setup

**Goal:** Understand AI testing philosophy and test generation strategies  
**Time:** 10 minutes

### Prerequisites
- Cursor installed and configured
- E-commerce application (Session 4 version)

### **Steps**

1. **Open the E-commerce Application**
   Navigate to `session4-testing/ecommerce-modular`.

2. **Test AI Testing Philosophy**
   **Extended Thinking Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze this e-commerce application and create a 
      comprehensive testing strategy. Identify what types of tests are needed 
      and prioritize them based on risk and business value."
   ```

3. **Compare Testing Approaches**
   **Traditional Approach:**
   Type:
   ```
      Chat Mode: "What unit tests should I write for UserService?"
   ```

   **AI-Assisted Approach:**
   Type:
   ```
      Extended Thinking: "Generate comprehensive unit tests for UserService 
      including edge cases, error conditions, and boundary value testing.
      Use JUnit 5, Mockito, and AssertJ."
   ```

---

## Lab 1: Unit Test Generation with Mockito & AssertJ

**Goal:** Generate comprehensive unit tests using AI assistance  
**Time:** 35 minutes  
**Mode:** Code-along with instructor

### Step 1: Service Layer Testing (20 min)

1. **Generate Service Tests**
   **Agent Mode:**
   Type:
   ```
      Generate comprehensive unit tests for UserService using JUnit 5, Mockito, 
      and AssertJ. Test all public methods.
      Use @ExtendWith(MockitoExtension.class).
      Use fluent assertions with AssertJ (e.g., assertThat(...).isNotNull()...).
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
           assertThat(result).isNotNull()
               .satisfies(u -> {
                   assertThat(u.getFirstName()).isEqualTo("John");
                   assertThat(u.getEmail()).isEqualTo("john@example.com");
               });
           
           verify(userRepository).save(any(User.class));
       }
   }
   ```

### Step 2: Repository Testing (15 min)

1. **Generate Repository Tests**
   **Plan Mode:**
   Type:
   ```
      Create unit tests for UserRepository using @DataJpaTest. 
      Test all CRUD operations and custom query methods.
      Use AssertJ for assertions.
   ```

2. **Run Tests**
   ```bash
   ./mvnw test
   ```

---

## Lab 2: Integration Testing with TestContainers

**Goal:** Set up integration testing with TestContainers and service mocking  
**Time:** 35 minutes  
**Mode:** Code-along with instructor

### Step 1: TestContainers Setup (20 min)

1. **Generate Integration Tests**
   **Extended Thinking:**
   Type:
   ```
      Set up TestContainers for integration testing with PostgreSQL. 
      Create tests that verify database operations, transactions, and data consistency 
      for the User module. Ensure @ServiceConnection is used if available.
   ```

2. **Review Generated Setup**
   - Verify `PostgreSQLContainer` usage.
   - Check for `@Testcontainers` annotation.

### Step 2: External Service Mocking (15 min)

1. **Setup WireMock**
   **Agent Mode:**
   Type:
   ```
      Set up WireMock for mocking external services. Create integration tests 
      for payment processing in the Order module.
   ```

2. **Review Generated Tests**
   - Verify `WireMock` stubs.
   - Ensure tests run without external network calls.

---

## Lab 3: End-to-End Testing

**Goal:** Create comprehensive end-to-end tests for complete workflows  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: API Testing (15 min)

1. **Generate API Tests**
   **Extended Thinking:**
   Type:
   ```
      Create comprehensive API tests for the e-commerce application using MockMvc. 
      Include authentication, authorization, data validation, and error handling scenarios.
      Use AssertJ to verify the JSON responses.
   ```

2. **Review Generated Tests**
   - Check `mockMvc.perform(...)` calls.
   - Verify `jsonPath` or AssertJ JSON assertions.

### Step 2: Workflow Testing (10 min)

1. **Create Workflow Tests**
   **Plan Mode:**
   Type:
   ```
      Create end-to-end tests for the complete order processing workflow from 
      user login to order completion.
   ```

---

## Lab 4: AI Debugging

**Goal:** Use AI for intelligent debugging and troubleshooting  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Test Failure Analysis

1. **Introduce Test Failure**
   Modify `UserService.java` to throw a `NullPointerException` when creating a user.

2. **AI Debugging Analysis**
   **Extended Thinking:**
   Type:
   ```
      Analyze this failing test and provide debugging guidance. Identify the 
      root cause and suggest fixes.
   ```

3. **Review Debugging Process**
   - Error analysis
   - Root cause identification
   - Fix recommendation

---

## Part B: Exploration Exercises (Homework)

### Lab 5: Legacy Code Testing

**Goal:** Apply agent patterns to real-world legacy system modernization

1. **Analyze Legacy System**
   **Extended Thinking:**
   Type:
   ```
      Analyze this legacy Spring Boot 2.7 application. 
      Identify technical debt and missing test coverage.
   ```

2. **Generate Tests for Legacy Code**
   **Agent Mode:**
   Type:
   ```
      Generate JUnit 5 tests for the legacy OrderService. 
      You may need to refactor the code slightly to make it testable (e.g., add constructor injection).
   ```

### Lab 6: Advanced Mocking Scenarios

**Goal:** Handle complex mocking scenarios with Mockito

1. **Mock Static Methods**
   **Agent Mode:**
   Type:
   ```
      Show me how to mock a static utility method using Mockito-inline.
      Create a test case that demonstrates this.
   ```

2. **Mock Final Classes**
   **Agent Mode:**
   Type:
   ```
      Show me how to mock a final class using Mockito.
   ```

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
   Type:
   ```
      Extended Thinking: "Analyze this legacy Java application and create a 
      testing strategy. Identify testing challenges and recommend approaches 
      for improving test coverage."
   ```

### Exercise 1: Testing Challenge Analysis (15 min)

**Use Extended Thinking to explore:**

1. **Current Test Coverage:**
   Type:
   ```
      Extended Thinking: "Analyze the current test coverage in this legacy 
      application. What areas are tested and what gaps exist?"
   ```

2. **Testing Challenges:**
   Type:
   ```
      Extended Thinking: "Identify the main testing challenges in this 
      legacy codebase. What makes it difficult to test?"
   ```

3. **Risk Assessment:**
   Type:
   ```
      Extended Thinking: "Assess the risks of adding tests to this legacy 
      code. What could go wrong and how can we mitigate those risks?"
   ```

**Document your findings** in `legacy-testing-analysis.md`

### Exercise 2: Incremental Testing Strategy (15 min)

**Create Testing Strategy:**

1. **Characterization Testing:**
   Type:
   ```
      Extended Thinking: "Design a characterization testing approach for 
      this legacy application. How can we understand current behavior before 
      adding comprehensive tests?"
   ```

2. **Incremental Test Addition:**
   Type:
   ```
      Extended Thinking: "Create a plan for incrementally adding tests to 
      this legacy codebase. What should be tested first and why?"
   ```

3. **Refactoring for Testability:**
   Type:
   ```
      Extended Thinking: "Identify refactoring opportunities that would 
      make this legacy code more testable. What changes would have the 
      biggest impact?"
   ```

### Exercise 3: Legacy Test Implementation (15 min)

**Implement Testing Strategy:**

1. **Characterization Tests:**
   Type:
   ```
      Agent Mode: "Create characterization tests for the UserService class 
      in this legacy application. Focus on understanding current behavior."
   ```

2. **Incremental Tests:**
   Type:
   ```
      Plan Mode: "Add unit tests to the OrderService class following the 
      incremental testing strategy."
   ```

3. **Refactoring Tests:**
   Type:
   ```
      Extended Thinking: "Refactor the PaymentService class to improve 
      testability and add comprehensive tests."
   ```

### Exercise 4: Legacy Testing Validation (15 min)

**Validate Testing Approach:**

1. **Test Coverage Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze the test coverage improvement after 
      implementing the legacy testing strategy. What progress was made?"
   ```

2. **Risk Mitigation:**
   Type:
   ```
      Extended Thinking: "Evaluate the risk mitigation strategies used 
      in the legacy testing approach. Were the risks successfully managed?"
   ```

3. **Lessons Learned:**
   Type:
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
   Type:
   ```
      Extended Thinking: "Design comprehensive stress tests for the 
      e-commerce application. Include scenarios that push the system 
      beyond normal capacity."
   ```

2. **Breaking Point Analysis:**
   Type:
   ```
      Extended Thinking: "Create tests to identify the breaking point 
      of the e-commerce application. What happens when load exceeds capacity?"
   ```

3. **Recovery Testing:**
   Type:
   ```
      Extended Thinking: "Design recovery tests to verify system behavior 
      after stress conditions. How does the system recover from overload?"
   ```

### Exercise 2: Performance Optimization (15 min)

**AI-Guided Optimization:**

1. **Bottleneck Identification:**
   Type:
   ```
      Extended Thinking: "Analyze performance test results to identify 
      specific bottlenecks in the e-commerce application."
   ```

2. **Optimization Recommendations:**
   Type:
   ```
      Extended Thinking: "Provide specific optimization recommendations 
      for the identified performance bottlenecks."
   ```

3. **Optimization Implementation:**
   Type:
   ```
      Plan Mode: "Implement the recommended performance optimizations 
      and create tests to verify improvements."
   ```

### Exercise 3: Performance Monitoring (15 min)

**Continuous Performance Monitoring:**

1. **Monitoring Strategy:**
   Type:
   ```
      Extended Thinking: "Design a comprehensive performance monitoring 
      strategy for the e-commerce application."
   ```

2. **Alert Configuration:**
   Type:
   ```
      Extended Thinking: "Create performance alert configurations for 
      proactive monitoring and issue detection."
   ```

3. **Performance Regression Testing:**
   Type:
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
   Type:
   ```
      Extended Thinking: "Design comprehensive penetration tests for the 
      e-commerce application. Include various attack vectors and scenarios."
   ```

2. **Attack Vector Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze potential attack vectors for the 
      e-commerce application. What are the most likely security threats?"
   ```

3. **Vulnerability Exploitation:**
   Type:
   ```
      Extended Thinking: "Create tests that attempt to exploit identified 
      vulnerabilities in the e-commerce application."
   ```

### Exercise 2: Security Compliance (15 min)

**Compliance Testing:**

1. **Compliance Requirements:**
   Type:
   ```
      Extended Thinking: "Identify security compliance requirements for 
      the e-commerce application. What standards should be followed?"
   ```

2. **Compliance Testing:**
   Type:
   ```
      Extended Thinking: "Create tests to verify compliance with security 
      standards and regulations."
   ```

3. **Compliance Reporting:**
   Type:
   ```
      Extended Thinking: "Design compliance reporting mechanisms for 
      security testing results."
   ```

### Exercise 3: Security Monitoring (15 min)

**Continuous Security Monitoring:**

1. **Security Monitoring Strategy:**
   Type:
   ```
      Extended Thinking: "Design a comprehensive security monitoring 
      strategy for the e-commerce application."
   ```

2. **Threat Detection:**
   Type:
   ```
      Extended Thinking: "Create threat detection mechanisms and alert 
      configurations for security monitoring."
   ```

3. **Incident Response:**
   Type:
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
   Type:
   ```
      Extended Thinking: "Design a testing strategy that works across 
      development, staging, and production environments."
   ```

2. **Environment-Specific Tests:**
   Type:
   ```
      Extended Thinking: "Create environment-specific tests that adapt 
      to different deployment configurations."
   ```

### Challenge: AI Test Maintenance

**Advanced: Automated test maintenance**

1. **Test Maintenance Strategy:**
   Type:
   ```
      Extended Thinking: "Design an AI-powered test maintenance strategy 
      that keeps tests up-to-date with code changes."
   ```

2. **Automated Test Refactoring:**
   Type:
   ```
      Extended Thinking: "Create automated test refactoring mechanisms 
      that improve test quality over time."
   ```

### Challenge: Testing Metrics and Analytics

**Advanced: Testing analytics and insights**

1. **Testing Metrics:**
   Type:
   ```
      Extended Thinking: "Design comprehensive testing metrics and 
      analytics for the e-commerce application."
   ```

2. **Testing Insights:**
   Type:
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
