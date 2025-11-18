# Session 4: Reviewing and Testing Code Using Cursor and Claude

**Duration:** 3 hours  
**Audience:** ~100 experienced developers (Java/Android background from Sessions 1-3)  
**Format:** Instructor-led with hands-on exercises  
**Prerequisite:** Completion of Sessions 1-3 or equivalent Cursor experience

## Session Objectives

By the end of this session, participants will be able to:
- Generate comprehensive test suites using AI assistance
- Conduct AI-powered code reviews and quality analysis
- Debug complex issues with AI-guided troubleshooting
- Implement automated testing strategies and CI/CD integration
- Use AI for performance analysis and optimization
- Apply AI-assisted security vulnerability assessment
- Design testing workflows for team collaboration

## Two-Project Approach

### Project 1: E-Commerce Testing Suite (Code-Along)
**Purpose:** Build comprehensive testing strategy with AI assistance  
**Duration:** ~140 minutes (Parts 1-6)  
**Approach:** Instructor-led, students follow along  
**Deliverable:** Complete testing suite with unit, integration, and end-to-end tests

**Key Technologies:**
- JUnit 5 with modern testing patterns
- TestContainers for integration testing
- MockMvc for web layer testing
- WireMock for external service mocking
- Performance testing with JMeter
- Security testing with OWASP ZAP
- CI/CD integration with GitHub Actions

### Project 2: Legacy Code Testing (Exploration)
**Purpose:** Apply AI testing strategies to real-world legacy systems  
**Duration:** ~30 minutes intro + homework  
**Approach:** Guided exploration, deeper practice in labs  
**Repository:** Custom legacy Java application (provided)

---

## Detailed Timeline

### Part 1: AI-Assisted Test Generation (30 minutes)

#### Welcome & Session 4 Overview (5 min)
- Recap Sessions 1-3: Chat, Agent, Composer, Agentic Coding
- Session 4 focus: **Testing and Quality Assurance** with AI
- The testing paradigm: AI as quality partner
- Two-project approach explanation
- Today's deliverables: comprehensive testing strategy

#### Understanding AI Testing Philosophy (15 min)
- **Traditional Testing:**
  - Manual test writing
  - Limited test coverage
  - Reactive quality assurance
  - Time-consuming test maintenance
  
- **AI-Assisted Testing:**
  - Automated test generation
  - Comprehensive coverage analysis
  - Proactive quality assurance
  - Intelligent test maintenance

- **Key Principles:**
  - **Coverage-Driven:** AI identifies gaps in test coverage
  - **Scenario-Based:** AI generates realistic test scenarios
  - **Maintenance-Aware:** AI helps keep tests up-to-date
  - **Quality-Focused:** AI ensures tests actually test something

#### Test Generation Strategies (10 min)
- **Unit Test Generation:** Method-level testing with edge cases
- **Integration Test Generation:** Component interaction testing
- **End-to-End Test Generation:** Full workflow testing
- **Performance Test Generation:** Load and stress testing
- **Security Test Generation:** Vulnerability and penetration testing

**Checkpoint:** Understanding of AI testing philosophy

---

### Part 2: Comprehensive Unit Testing (35 minutes)

#### AI-Generated Unit Tests (20 min)

**Demo: Service Layer Testing**
```
Extended Thinking: "Generate comprehensive unit tests for the UserService 
class. Include happy path scenarios, edge cases, error conditions, and 
boundary value testing. Use JUnit 5, Mockito, and AssertJ."
```

**Review Generated Tests:**
- Test structure and organization
- Mocking strategies
- Assertion patterns
- Edge case coverage
- Error scenario testing

**Demo: Repository Testing**
```
Plan Mode: "Create unit tests for UserRepository using @DataJpaTest. 
Test all CRUD operations, custom query methods, and error conditions."
```

**Review Generated Tests:**
- @DataJpaTest configuration
- Test data setup
- Query method testing
- Transaction handling
- Error condition testing

#### Student Exercise: Controller Testing (15 min)

**Your Turn:**
```
Agent Mode: "Generate unit tests for UserController using @WebMvcTest. 
Test all endpoints, request validation, error handling, and response formats."
```

**Review and Refine:**
- Test endpoint coverage
- Request/response validation
- Error handling scenarios
- Security testing
- Performance considerations

**Checkpoint:** Comprehensive unit test suite

---

### Part 3: Integration Testing Strategies (35 minutes)

#### TestContainers Integration (20 min)

**Demo: Database Integration Testing**
```
Extended Thinking: "Set up TestContainers for integration testing 
with PostgreSQL. Create tests that verify database operations, 
transactions, and data consistency."
```

**Review Setup:**
- TestContainers configuration
- Database initialization
- Test data management
- Transaction testing
- Performance considerations

**Demo: Service Integration Testing**
```
Plan Mode: "Create integration tests for the complete User module 
including service, repository, and database layers."
```

**Review Generated Tests:**
- Integration test structure
- Test data setup
- Service layer testing
- Database interaction testing
- Error handling verification

#### Student Exercise: External Service Mocking (15 min)

**Your Turn:**
```
Agent Mode: "Set up WireMock for mocking external services. 
Create integration tests for payment processing and email notifications."
```

**Review and Test:**
- WireMock configuration
- Service mocking strategies
- Integration test patterns
- Error scenario testing
- Performance testing

**Checkpoint:** Integration testing framework

---

### BREAK (10 minutes)

---

### Part 4: End-to-End Testing (30 minutes)

#### API Testing with AI (15 min)

**Demo: Complete API Testing**
```
Extended Thinking: "Create comprehensive API tests for the e-commerce 
application. Include authentication, authorization, data validation, 
and error handling scenarios."
```

**Review Generated Tests:**
- API test structure
- Authentication testing
- Authorization scenarios
- Data validation testing
- Error response verification

#### Student Exercise: Workflow Testing (15 min)

**Your Turn:**
```
Plan Mode: "Create end-to-end tests for the complete order processing 
workflow from user login to order completion."
```

**Review and Refine:**
- Workflow test design
- State management testing
- Integration point verification
- Error handling scenarios
- Performance considerations

**Checkpoint:** End-to-end testing suite

---

### Part 5: Performance and Security Testing (35 minutes)

#### AI-Guided Performance Testing (20 min)

**Demo: Performance Analysis**
```
Extended Thinking: "Analyze the e-commerce application for performance 
bottlenecks. Create performance tests using JMeter and identify 
optimization opportunities."
```

**Review Analysis:**
- Performance bottleneck identification
- Load testing scenarios
- Stress testing patterns
- Optimization recommendations
- Monitoring strategies

**Demo: Performance Test Generation**
```
Plan Mode: "Generate JMeter test plans for critical user journeys 
including user registration, product browsing, and order processing."
```

**Review Generated Tests:**
- JMeter test plan structure
- Load testing scenarios
- Performance metrics
- Threshold definitions
- Reporting configuration

#### AI-Assisted Security Testing (15 min)

**Demo: Security Vulnerability Assessment**
```
Extended Thinking: "Conduct a comprehensive security assessment of 
the e-commerce application. Identify vulnerabilities and create 
security tests using OWASP ZAP."
```

**Review Assessment:**
- Vulnerability identification
- Security test scenarios
- Penetration testing patterns
- Remediation recommendations
- Security monitoring

**Checkpoint:** Performance and security testing

---

### Part 6: CI/CD Integration and Automation (25 minutes)

#### GitHub Actions Integration (15 min)

**Demo: Automated Testing Pipeline**
```
Extended Thinking: "Design a comprehensive CI/CD pipeline using 
GitHub Actions that includes unit tests, integration tests, 
performance tests, and security scans."
```

**Review Pipeline:**
- GitHub Actions workflow
- Test execution strategies
- Quality gates
- Reporting and notifications
- Deployment automation

#### Student Exercise: Quality Gates (10 min)

**Your Turn:**
```
Agent Mode: "Create quality gates that prevent deployment if tests 
fail, coverage drops below threshold, or security vulnerabilities 
are detected."
```

**Review and Test:**
- Quality gate configuration
- Threshold definitions
- Failure handling
- Notification strategies
- Rollback procedures

**Checkpoint:** Automated testing pipeline

---

### BREAK (10 minutes)

---

### Part 7: AI-Powered Debugging and Troubleshooting (25 minutes)

#### Intelligent Debugging (15 min)

**Demo: AI-Guided Debugging**
```
Extended Thinking: "Analyze this failing test and provide debugging 
guidance. Identify the root cause and suggest fixes."
```

**Review Debugging Process:**
- Error analysis and interpretation
- Root cause identification
- Fix recommendation
- Prevention strategies
- Learning from failures

#### Student Exercise: Test Failure Analysis (10 min)

**Your Turn:**
```
Chat Mode: "This test is failing with a NullPointerException. 
Help me debug the issue and fix the test."
```

**Review and Fix:**
- Error analysis
- Debugging strategies
- Fix implementation
- Test validation
- Prevention measures

**Checkpoint:** AI-assisted debugging skills

---

### Part 8: Legacy Code Testing Introduction (15 minutes)

#### Exploring Legacy Testing Challenges (15 min)

**Demo: Legacy Code Analysis**
```
Extended Thinking: "Analyze this legacy Java application and create a 
testing strategy. Identify testing challenges and recommend 
approaches for improving test coverage."
```

**Review Analysis:**
- Legacy code testing challenges
- Test coverage analysis
- Testing strategy recommendations
- Risk assessment
- Implementation approach

**Student Guided Exploration (5 min):**
Students use Extended Thinking to explore:
1. "What are the main testing challenges in this legacy codebase?"
2. "How would you prioritize testing improvements?"
3. "What risks should be considered when adding tests to legacy code?"

---

### Wrap-Up & Next Steps (10 minutes)

#### Key Takeaways (5 min)

**AI Testing Decision Tree:**
```
Need unit tests? → Use Agent Mode with JUnit 5
Need integration tests? → Use TestContainers with Plan Mode
Need performance tests? → Use Extended Thinking for analysis
Need security tests? → Use AI vulnerability assessment
Need debugging help? → Use Chat Mode for analysis
Need CI/CD integration? → Use Plan Mode for pipeline design
```

**What We Accomplished:**
- ✅ Comprehensive test suite generation
- ✅ AI-assisted code review and quality analysis
- ✅ Performance and security testing strategies
- ✅ CI/CD integration with quality gates
- ✅ AI-powered debugging and troubleshooting
- ✅ Legacy code testing approaches

#### Preview Session 5 (3 min)

**Exploring Agents and MCP**
- Advanced Model Context Protocol integrations
- Custom AI agents for specific domains
- Multi-agent collaboration patterns
- Enterprise AI tool integration
- Future of AI-assisted development

#### Q&A (2 min)
- Testing strategy questions
- AI debugging techniques
- CI/CD integration challenges

---

## Materials Provided

### Pre-Session
- Session 1-3 recap document
- Testing strategy guide
- Legacy codebase for exploration
- CI/CD setup instructions
- Performance testing tools guide

### During Session
- This session outline
- Slidev presentation
- E-commerce testing project
- Legacy codebase for analysis
- Testing tool configurations

### Post-Session
- Complete labs.md with all exercises
- Legacy testing challenges
- CI/CD pipeline templates
- Testing strategy guides
- Session 5 preview materials

---

## Success Metrics

Students should leave able to:
- [ ] Generate comprehensive test suites using AI assistance
- [ ] Conduct AI-powered code reviews and quality analysis
- [ ] Debug complex issues with AI-guided troubleshooting
- [ ] Implement automated testing strategies and CI/CD integration
- [ ] Use AI for performance analysis and optimization
- [ ] Apply AI-assisted security vulnerability assessment
- [ ] Design testing workflows for team collaboration
- [ ] Apply testing strategies to legacy codebases

---

## Instructor Notes

### Timing Buffers
- Breaks provide 20 min catch-up time
- Can compress performance testing if needed
- Core testing concepts must be completed
- CI/CD section can be shortened if running behind

### Common Issues & Solutions
- **TestContainers setup issues:** Have backup demos ready, focus on concepts
- **Performance testing complexity:** Simplify JMeter examples, focus on principles
- **Security testing concerns:** Emphasize educational use, provide safe examples
- **CI/CD platform differences:** Focus on GitHub Actions, mention alternatives
- **Students overwhelmed by testing:** Start with simple examples, build complexity

### Adaptation Points
- If ahead: Add more advanced testing scenarios, explore additional tools
- If behind: Focus on core testing concepts, simplify tool integration
- If questions: Use Chat mode to explore answers together
- If students struggle with concepts: More Chat mode explanations, simpler examples

### Demo Tips
- **Always explain the testing strategy** before generating tests
- **Show test execution** - tests should actually run and pass/fail
- **Demonstrate debugging** - show how AI helps with test failures
- **Highlight quality metrics** - coverage, performance, security
- **Use real examples** - avoid toy problems
- **Show mistakes and recovery** - AI makes errors too
- **Emphasize human oversight** - AI assists, humans decide

---

## Project: E-Commerce Testing Suite

### Testing Strategy Overview
1. **Unit Tests**
   - Service layer testing with mocks
   - Repository testing with @DataJpaTest
   - Controller testing with @WebMvcTest

2. **Integration Tests**
   - Database integration with TestContainers
   - Service integration testing
   - External service mocking with WireMock

3. **End-to-End Tests**
   - Complete API testing
   - Workflow testing
   - User journey validation

4. **Performance Tests**
   - Load testing with JMeter
   - Stress testing scenarios
   - Performance monitoring

5. **Security Tests**
   - Vulnerability assessment
   - Penetration testing
   - Security scanning

6. **CI/CD Integration**
   - Automated test execution
   - Quality gates
   - Deployment automation

### Testing Tools and Technologies
- **JUnit 5** - Modern testing framework
- **TestContainers** - Integration testing
- **MockMvc** - Web layer testing
- **WireMock** - External service mocking
- **JMeter** - Performance testing
- **OWASP ZAP** - Security testing
- **GitHub Actions** - CI/CD automation

---

## Progression from Sessions 1-3

### Building on Previous Sessions

| Session 1-3 (Development) | Session 4 (Testing) |
|---------------------------|---------------------|
| Code generation | Test generation |
| Architecture planning | Testing strategy planning |
| AI collaboration | AI quality partnership |
| Manual development | Automated testing |
| Individual focus | Team quality assurance |
| Code creation | Code validation |

### Same AI Principles, Quality Focus
- Natural language as interface
- Iterative refinement
- Context awareness
- Human-AI collaboration
- Quality verification

### New Testing-Specific Skills
- Test strategy design
- Quality metric analysis
- Performance optimization
- Security vulnerability assessment
- CI/CD pipeline integration
- Legacy code testing approaches

---

## Lab Preview (labs-session4.md)

### Part A: Code-Along (In-Class)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 0 | AI Testing Setup | 10 min | Testing philosophy, AI strategies |
| 1 | Unit Test Generation | 25 min | JUnit 5, Mockito, AssertJ |
| 2 | Integration Testing | 25 min | TestContainers, @DataJpaTest |
| 3 | End-to-End Testing | 20 min | API testing, workflow testing |
| 4 | Performance Testing | 20 min | JMeter, load testing |
| 5 | Security Testing | 15 min | OWASP ZAP, vulnerability assessment |
| 6 | CI/CD Integration | 15 min | GitHub Actions, quality gates |
| 7 | AI Debugging | 15 min | Test failure analysis, troubleshooting |

**Total In-Class Time:** ~145 minutes (2h 25m)

### Part B: Exploration (Homework)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 8 | Legacy Code Testing | 45-60 min | Testing strategy, coverage analysis |
| 9 | Advanced Performance Testing | 30-45 min | Stress testing, optimization |
| 10 | Security Testing Deep Dive | 30-45 min | Penetration testing, remediation |

**Total Homework Time:** ~2-3 hours

---

## Resources and Links

### Testing Resources
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [TestContainers Documentation](https://www.testcontainers.org/)
- [MockMvc Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#spring-mvc-test-framework)
- [WireMock Documentation](https://wiremock.org/docs/)

### Performance and Security
- [JMeter User Manual](https://jmeter.apache.org/usermanual/)
- [OWASP ZAP Documentation](https://www.zaproxy.org/docs/)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)

### CI/CD and Automation
- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Testing Best Practices](https://martinfowler.com/articles/practical-test-pyramid.html)
- [Quality Assurance with AI](https://cursor.com/blog/ai-testing)

---

**Session 4 outline complete and ready for material development! 🚀**
