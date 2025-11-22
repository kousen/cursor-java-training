# Session 4: Reviewing and Testing Code Using Cursor and Claude

**Duration:** 3 hours  
**Audience:** ~100 experienced developers (Java/Android background from Sessions 1-3)  
**Format:** Instructor-led with hands-on exercises  
**Prerequisite:** Completion of Sessions 1-3 or equivalent Cursor experience

## Session Objectives

By the end of this session, participants will be able to:
- Generate comprehensive test suites using AI assistance
- Master Spring Boot testing patterns (Slice testing, MockMvc, DataJpaTest)
- Write fluent assertions using AssertJ and AI
- Implement effective mocking strategies with Mockito
- Conduct AI-powered code reviews and quality analysis
- Debug complex issues with AI-guided troubleshooting
- Apply testing strategies to legacy codebases

## Two-Project Approach

### Project 1: E-Commerce Testing Suite (Code-Along)
**Purpose:** Build comprehensive testing strategy with AI assistance  
**Duration:** ~140 minutes (Parts 1-6)  
**Approach:** Instructor-led, students follow along  
**Deliverable:** Complete testing suite with unit, integration, and end-to-end tests

**Key Technologies:**
- Java 21, Spring Boot 3.5.*
- JUnit 5 (Jupiter)
- AssertJ for fluent assertions
- Mockito for mocking
- TestContainers for integration testing
- MockMvc for web layer testing
- WireMock for external service mocking

### Project 2: Legacy Code Testing (Exploration)
**Purpose:** Apply AI testing strategies to real-world legacy systems  
**Duration:** ~30 minutes intro + homework  
**Approach:** Guided exploration, deeper practice in labs  
**Repository:** Legacy Spring Boot 2.7 Application (provided)

---

## Detailed Timeline

### Part 1: AI-Assisted Test Generation (30 minutes)

#### Welcome & Session 4 Overview (5 min)
- Recap Sessions 1-3: Chat, Agent, Composer
- Session 4 focus: **Testing and Quality Assurance** with AI
- The testing paradigm: AI as quality partner
- Stack: Java 21, Spring Boot 3.5.*

#### Understanding AI Testing Philosophy (15 min)
- **Traditional vs AI-Assisted Testing**
- **Key Principles:**
  - **Coverage-Driven:** AI identifies gaps
  - **Scenario-Based:** AI generates realistic scenarios
  - **Maintenance-Aware:** AI helps keep tests up-to-date

#### Test Generation Strategies (10 min)
- **Unit Test Generation:** Method-level testing with edge cases
- **Integration Test Generation:** Component interaction testing
- **Slice Testing:** @WebMvcTest, @DataJpaTest
- **Prompting for Tests:** "Generate JUnit 5 tests with AssertJ assertions..."

**Checkpoint:** Understanding of AI testing philosophy

---

### Part 2: Comprehensive Unit Testing with Mockito & AssertJ (45 minutes)

#### AI-Generated Unit Tests (25 min)

**Demo: Service Layer Testing with Mockito**
```
Extended Thinking: "Generate unit tests for UserService. Use @ExtendWith(MockitoExtension.class). 
Mock the UserRepository. Use AssertJ for all assertions. 
Include scenarios for success, user not found, and validation errors."
```

**Review Generated Tests:**
- Mockito annotations (@Mock, @InjectMocks)
- `when(...).thenReturn(...)` vs `given(...).willReturn(...)`
- AssertJ fluency: `assertThat(result).isNotNull().satisfies(...)`

**Demo: Repository Testing**
```
Plan Mode: "Create unit tests for UserRepository using @DataJpaTest. 
Use AssertJ to verify the returned entities."
```

#### Student Exercise: Controller Testing (20 min)

**Your Turn:**
```
Agent Mode: "Generate unit tests for UserController using @WebMvcTest. 
Use MockMvc to perform requests and AssertJ to verify the response body."
```

**Review and Refine:**
- MockMvc usage
- JSON path verification
- Exception handling

**Checkpoint:** Comprehensive unit test suite with modern tools

---

### Part 3: Integration Testing Strategies (40 minutes)

#### TestContainers Integration (20 min)

**Demo: Database Integration Testing**
```
Extended Thinking: "Set up TestContainers for integration testing with PostgreSQL. 
Ensure the context loads correctly and transactions are rolled back."
```

**Review Setup:**
- @ServiceConnection (Spring Boot 3.1+)
- DynamicPropertySource (if needed)
- Real database verification

#### Student Exercise: External Service Mocking (20 min)

**Your Turn:**
```
Agent Mode: "Set up WireMock for mocking the PaymentService. 
Create an integration test that verifies the order processing flow when payment succeeds."
```

**Review and Test:**
- WireMock stubs
- Integration test patterns

**Checkpoint:** Integration testing framework

---

### BREAK (10 minutes)

---

### Part 4: AI-Powered Debugging and Troubleshooting (25 minutes)

#### Intelligent Debugging (15 min)

**Demo: AI-Guided Debugging**
```
Extended Thinking: "Analyze this failing test (NullPointerException). 
Explain the root cause and provide a fix using Optional."
```

**Review Debugging Process:**
- Error analysis
- Root cause identification
- Fix recommendation

#### Student Exercise: Test Failure Analysis (10 min)

**Your Turn:**
```
Chat Mode: "This test is failing with an assertion error. 
Show me how to fix the production code to make it pass."
```

**Checkpoint:** AI-assisted debugging skills

---

### Part 5: Legacy Code Testing (30 minutes)

#### Exploring Legacy Testing Challenges (15 min)

**Demo: Legacy Code Analysis**
```
Extended Thinking: "Analyze this legacy Spring Boot 2.7 application. 
It uses field injection and older JUnit 4. 
Create a plan to migrate tests to JUnit 5 and add coverage for the OrderService."
```

**Review Analysis:**
- Legacy code patterns
- Migration strategies (JUnit 4 -> 5)
- Refactoring for testability

**Student Guided Exploration (15 min):**
Students use Extended Thinking to generate tests for a legacy component without changing the production code initially.

---

### Wrap-Up & Next Steps (10 minutes)

#### Key Takeaways (5 min)
- ✅ JUnit 5 + AssertJ + Mockito is the gold standard
- ✅ AI generates boilerplate and complex scenarios
- ✅ TestContainers makes integration testing reliable
- ✅ AI helps decipher and test legacy code

#### Preview Session 5 (3 min)
- **Building AI Apps with Spring AI**
- RAG (Retrieval Augmented Generation)
- AI Agents and Tools
- MCP in Java

#### Q&A (2 min)

---

## Materials Provided

### Pre-Session
- Session 1-3 recap
- Testing strategy guide
- Legacy codebase (Spring Boot 2.7)

### During Session
- E-commerce testing project (Spring Boot 3.5)
- Legacy codebase
- Slidev presentation

### Post-Session
- Complete labs.md
- Reference guide for AssertJ/Mockito

---

## Success Metrics

Students should leave able to:
- [ ] Generate comprehensive test suites using AI
- [ ] Use AssertJ for readable assertions
- [ ] Mock dependencies effectively with Mockito
- [ ] Implement TestContainers for integration tests
- [ ] Debug issues using AI
- [ ] Apply testing strategies to legacy code

