# Session 4: Lab Exercises

**Reviewing and Testing Code Using Cursor and Claude**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: AI Testing Setup](#lab-0-ai-testing-setup)
2. [Lab 1: Unit Test Generation with Mockito & AssertJ](#lab-1-unit-test-generation-with-mockito--assertj)
3. [Lab 1B: AI-Powered Test Quality](#lab-1b-ai-powered-test-quality)
4. [Lab 2: Integration Testing with TestContainers](#lab-2-integration-testing-with-testcontainers)
5. [Lab 3: End-to-End Testing](#lab-3-end-to-end-testing)
6. [Lab 4: AI Debugging](#lab-4-ai-debugging)

### Part B: Legacy Code Testing (In-Class Exploration)
7. [Lab 5: Legacy Code Testing](#lab-5-legacy-code-testing)

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

1. **Open the Session 4 Folder in Cursor**
   Open `session4-testing` as your Cursor workspace. The e-commerce application is in the `ecommerce-modular` subfolder.

2. **Test AI Testing Philosophy**
   **Extended Thinking Analysis:**
   Type:
   ```
      Extended Thinking: "Analyze the @ecommerce-modular application and create a
      comprehensive testing strategy. Identify what types of tests are needed
      and prioritize them based on risk and business value."
   ```

3. **Compare Prompting Approaches**

   Notice how prompt specificity affects results:

   | Prompt Style | Example | Result |
   |--------------|---------|--------|
   | Basic | "What unit tests should I write?" | Generic advice, you do the work |
   | Comprehensive | Specifies edge cases, technologies, patterns | AI generates actual tests |

   **Key Insight:** Specific prompts with technology choices (JUnit 5, Mockito, AssertJ) yield better results. We'll apply this in Lab 1.

---

## Lab 1: Unit Test Generation with Mockito & AssertJ

**Goal:** Generate comprehensive unit tests using AI assistance
**Time:** 35 minutes
**Mode:** Code-along with instructor

**Note:** These are *pure unit tests* - no Spring context. We use `@ExtendWith(MockitoExtension.class)` with `@Mock` and `@InjectMocks` for fast, isolated testing.

### Step 1: Service Layer Testing (20 min)

1. **Generate Service Tests**
   **Agent Mode:**
   Type:
   ```
      Generate comprehensive unit tests for @ecommerce-modular/user-service UserService
      using JUnit 5, Mockito, and AssertJ. Test all public methods.
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
      Create unit tests for @ecommerce-modular/user-service UserRepository using @DataJpaTest.
      Test all CRUD operations and custom query methods.
      Use AssertJ for assertions.
   ```

2. **Run Tests**
   ```bash
   cd ecommerce-modular && ./gradlew test
   ```

---

## Lab 1B: AI-Powered Test Quality

**Goal:** Improve test quality with AI review and generate realistic test data  
**Time:** 15 minutes  
**Mode:** Code-along with instructor  

### Step 1: AI Test Quality Review (8 min)

1. **Review Generated Tests**
   **Chat Mode:**
   Type:
   ```
      Review these UserService unit tests and suggest improvements.
      Focus on test coverage, assertion quality, and maintainability.
   ```

2. **Analyze AI Feedback**
   - Missing test cases
   - Weak or generic assertions
   - Test smells (unclear names, brittle tests)
   - Improvement suggestions

3. **Apply Improvements**
   Implement 1-2 key suggestions from AI

### Step 2: Test Data Generation (7 min)

1. **Generate Test Data**
   **Extended Thinking:**
   Type:
   ```
      Generate realistic test data for the User entity.
      Include various scenarios: valid data, edge cases, invalid data.
   ```

2. **Review Generated Data**
   - Normal/happy path data
   - Edge cases (boundaries, special characters)
   - Invalid data for validation testing

3. **Apply to Tests**
   Use generated test data in your existing tests

---

## Lab 2: Integration Testing with TestContainers

**Goal:** Set up integration testing with TestContainers
**Time:** 20 minutes
**Mode:** Code-along with instructor

**Note:** Integration tests load the Spring context. When mocking beans, Spring Boot 3.4+ uses `@MockitoBean` instead of deprecated `@MockBean`. The new annotation is in package `org.springframework.test.context.bean.override.mockito`.

### Steps

1. **Generate Integration Tests**
   **Extended Thinking:**
   Type:
   ```
      Set up TestContainers for integration testing with PostgreSQL in @ecommerce-modular/user-service.
      Create tests that verify database operations, transactions, and data consistency.
      Ensure @ServiceConnection is used if available.
   ```

2. **Review Generated Setup**
   - Verify `PostgreSQLContainer` usage.
   - Check for `@Testcontainers` annotation.

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
      Create comprehensive API tests for @ecommerce-modular using MockMvc.
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
      Create end-to-end tests for the complete user management workflow in
      @ecommerce-modular/user-service: registration, retrieval, update, and deletion.
   ```

---

## Lab 4: AI Debugging

**Goal:** Use AI for intelligent debugging and troubleshooting  
**Time:** 20 minutes  
**Mode:** Code-along with instructor  

### Step 1: Test Failure Analysis

1. **Introduce Test Failure**
   Modify `@ecommerce-modular/user-service/.../UserService.java` to throw a `NullPointerException` when creating a user.

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

## Part B: Legacy Code Testing (In-Class Exploration)

## Lab 5: Legacy Code Testing

**Goal:** Apply AI testing strategies to legacy code modernization  
**Time:** 20 minutes (in-class) + optional practice  
**Mode:** Guided exploration with instructor  

### Step 1: Legacy Code Analysis (10 min)

**Instructor Demo:**

1. **Analyze Legacy Codebase**
   **Extended Thinking:**
   Type:
   ```
      Extended Thinking: "Analyze the @legacy-app Spring Boot 2.7 application.
      It uses field injection and older JUnit 4. Create a plan to migrate
      tests to JUnit 5 and add coverage for the OrderService."
   ```

2. **Review Analysis Together:**
   - Legacy code patterns (field injection, JUnit 4)
   - Migration strategies (JUnit 4 -> JUnit 5)
   - Refactoring for testability
   - Testing challenges and priorities

### Step 2: Student Exploration (10 min)

**Your Turn:**

Use Extended Thinking to explore the legacy codebase:

1. **Testing Challenges:**
   Type:
   ```
      Extended Thinking: "What are the main testing challenges in
      @legacy-app?"
   ```

2. **Prioritization:**
   Type:
   ```
      Extended Thinking: "How would you prioritize testing improvements
      for @legacy-app?"
   ```

3. **Risk Assessment:**
   Type:
   ```
      Extended Thinking: "What risks should be considered when adding
      tests to @legacy-app?"
   ```

**Share Findings:** Discuss what you discovered with the group

### Optional Extended Practice

For those interested in deeper practice, the full Lab 5 exercises are available in the labs folder:
- Characterization testing
- Incremental test addition
- Refactoring for testability
- Test coverage analysis

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

---

## Additional Resources

### Testing Resources
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [AssertJ Documentation](https://assertj.github.io/doc/)
- [TestContainers Documentation](https://www.testcontainers.org/)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [WireMock Documentation](https://wiremock.org/docs/)

### AI Testing
- [Cursor Documentation - Testing](https://docs.cursor.com)
- [AI-Assisted Testing Best Practices](https://cursor.com/blog/ai-testing)
- [Quality Assurance with AI](https://cursor.com/blog/quality-assurance)

### Next Steps
- Session 5: Exploring Agents and MCP
- Apply AI testing to your own projects
- Explore testing tool integrations

---

**Happy AI Testing! 🧪🤖✅**
