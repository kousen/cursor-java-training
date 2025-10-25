# Custom Live Course Proposal 

**Title:** Using Cursor for Java Development  
**Subtitle:** AI-Assisted Development for Modern Java Applications

## Contacts

**Instructor Name:** Ken Kousen  
**Email:** ken.kousen@kousenit.com  
**Timezone:** ET  
**Mailing Address:** 11 Emily Road, Marlborough, CT 06447, USA

**Entity**  
*If we offer you an agreement, and you would prefer that an LLC or other entity be a party to the contract, please include the following information about the entity.*  
**Name:** Kousen IT Inc.  
**Email:** ken.kousen@kousenit.com  
**Mailing Address:** 11 Emily Road, Marlborough, CT 06447, USA

## Timing

**Total Duration:** 3 hours

## Course Information

### Course Registration Page Information

**Course Description**

In this hands-on, 3-hour course, you'll learn how to use Cursor effectively in real Java development scenarios, from generating boilerplate code and writing tests to navigating large codebases. We'll explore how to communicate with the AI using effective prompts and how Cursor understands context across files. With guided exercises building a complete Spring Boot application, you'll gain firsthand experience using Cursor as a collaborative coding assistant—and develop the skills needed to integrate AI coding tools into your everyday development process.

**Course Objectives**

* Use Cursor to generate, navigate, and refactor Java code efficiently through prompt-based interactions in both Chat and Agent modes
* Understand how Cursor interprets code context and leverage that awareness to debug and enhance multi-file Spring Boot projects
* Apply best practices for AI-assisted development including effective prompting, code verification, and iterative refinement

**Prerequisites**

* Basic experience with Java, including writing classes, methods, and working with IDEs like IntelliJ or VS Code
* Familiarity with Spring Boot fundamentals (REST controllers, services, JPA) is helpful but not required
* General awareness of AI-assisted tools or GitHub Copilot-style code suggestions (helpful but not required)

**Course Preparation**

Is there any setup learners should do before the class starts? This could include things like having an IDE ready with certain libraries installed, or a dataset to use in an exercise.

**Required Setup (Before Class):**
* Install Cursor IDE from [cursor.sh](https://cursor.sh) and create an account
* Install Java 17 or 21 (verify with `java -version`)
* Install Gradle or Maven (wrappers will be provided in projects)
* Install the following Cursor extensions:
  * Language Support for Java (Red Hat)
  * Debugger for Java (Microsoft)
  * Spring Boot Extension Pack (VMware)
  * Gradle for Java (Microsoft)

**Recommended Pre-Reading:**
* [Cursor Quick Start for IntelliJ Users](https://docs.cursor.com) - especially if coming from IntelliJ IDEA
* Review basic Spring Boot concepts: controllers, services, repositories

**Course Follow-Up**

**Read:**
* [Chapter 1. Code Generation and Autocompletion](https://learning.oreilly.com/library/view/generative-ai-for/9781098162269/ch01.html) from *Generative AI for Software Development* by Sergio Pereira
* [Chapter 5. Understanding Generated Code: Review, Refine, Own](https://learning.oreilly.com/library/view/beyond-vibe-coding/9798341634749/ch05.html#ch05_from_intent_to_implementation_understanding_the_a_1749486800491236) from *Beyond Vibe Coding* by Addy Osmani
* [Cursor Documentation](https://docs.cursor.com) - Explore advanced features like MCP and Extended Thinking

**Watch:**
* [Vibe Coding: More Experiments, More Care](https://learning.oreilly.com/videos/coding-with-ai/0642572017171/0642572017171-video386896/) – Kent Beck (15 mins)
* [Bridging the AI Learning Gap: Teaching Developers to Think with AI](https://learning.oreilly.com/videos/coding-with-ai/0642572017171/0642572017171-video386923/) – Andrew Stellman (15 mins)

**Practice Projects:**
* Complete the Spring PetClinic exploration exercises using Cursor to analyze the architecture, understand entity relationships, and trace request flows
* Apply Cursor to your own Java projects: try refactoring legacy code, generating tests for existing services, or building new features with AI assistance

---

**Course Schedule**

### Section 1: Getting Started with Cursor (20 minutes)

**Presentation:** Introduction to Cursor IDE for Java developers
* Course objectives and what we'll build today
* Cursor environment overview: editor, side panels, Chat vs Agent modes
* Key differences from IntelliJ/VS Code: workspace concept, multi-window support
* AI modes explained: when to use Chat (learning/understanding) vs Agent (code generation/modification)

**Discussion:** What do you currently use for code assistance or automation in your Java workflow? What takes the most time in your daily development?

**Exercise:** First steps with Cursor
* Open Cursor and explore the UI (Cmd/Ctrl+L for Chat, Cmd/Ctrl+I for Agent)
* Navigate to a provided Spring Boot starter project
* Use Chat mode: "Explain the structure of this Spring Boot application"
* Use Agent mode: "Create a simple Greeting controller with a GET endpoint"
* Run the application and test the generated endpoint

**Q&A**

---

### Section 2: Prompting Techniques & Context Awareness (30 minutes)

**Presentation:** Mastering AI communication for Java development
* Writing effective prompts: be specific, provide context, iterate
* How Cursor understands code context across files and packages
* Context windows and @ mentions: referencing specific files, symbols, or documentation
* Best practices: progressive refinement, verification, and human oversight
* Common pitfalls: vague prompts, missing context, blindly accepting AI output

**Discussion:** How do you currently name or describe coding tasks when working in a team? Could this guide how you prompt an AI tool? When would you trust AI suggestions vs. verify them manually?

**Exercise:** Prompt engineering practice
* Given a User entity, craft prompts to:
  1. Generate a UserService with specific business logic (compare different prompt styles)
  2. Add input validation with custom error messages
  3. Refactor to use constructor injection and modern Java patterns
* Observe how prompt clarity and context (@mentions) impact results
* Compare Chat mode explanations with Agent mode implementations

**Q&A**

---

**5-Minute Break**

---

### Section 3: Generating Java Code with Cursor (25 minutes)

**Presentation:** Accelerating development with AI-generated code
* Using Cursor to generate boilerplate: entities, DTOs, repositories, controllers
* Modern Java patterns: records for DTOs, sealed interfaces, pattern matching
* Spring Boot code generation: REST APIs, service layers, dependency injection
* Validation and error handling: Bean Validation, global exception handlers
* Code review: verifying AI-generated code for correctness and best practices

**Discussion:** When generating code, how do you balance speed vs. control of what is produced? What standards or patterns should AI-generated code follow in your organization?

**Exercise:** Build a complete feature with AI assistance
* Generate a Task entity with JPA annotations (id, title, description, status, createdAt)
* Create TaskRequest and TaskResponse DTOs using Java records
* Generate TaskRepository extending JpaRepository with custom queries
* Build TaskController with full CRUD operations
* Add Bean Validation and a global exception handler
* Test the API with curl or in browser

**Q&A**

---

### Section 4: Writing Tests with Cursor (25 minutes)

**Presentation:** AI-assisted test generation and improvement
* Using Cursor to generate JUnit 5 tests with modern assertions (AssertJ)
* Test types: unit tests (services), integration tests (controllers with MockMvc), repository tests (@DataJpaTest)
* Generating edge cases and boundary conditions with AI
* Test-driven development with Cursor: write tests first, implement with AI
* Code coverage analysis and gap identification

**Discussion:** How much time do you currently spend writing and debugging tests? What makes writing tests tedious? How can AI help while maintaining test quality?

**Exercise:** Generate comprehensive test suite
* Use Agent mode to generate unit tests for TaskService
  * Prompt: "Generate JUnit 5 tests with AssertJ, test all public methods, include edge cases"
* Generate integration tests for TaskController using MockMvc
  * Test successful CRUD operations
  * Test validation failures (invalid input)
  * Test error responses (404, 400 status codes)
* Run tests and verify coverage: `./gradlew test`
* Review generated tests, discuss what to keep vs. modify

**Q&A**

---

### Section 5: Navigating & Refactoring Large Codebases (25 minutes)

**Presentation:** Understanding and improving existing code with AI
* Using Cursor to explore unfamiliar codebases: architecture analysis, dependency graphs
* Semantic code search: finding functionality by intent, not just keywords
* Safe refactoring strategies: rename methods/classes across files, extract services, modernize patterns
* Analyzing the Spring PetClinic application: entities, relationships, request flow
* Cross-file changes: tracking impacts, maintaining consistency

**Discussion:** What are your biggest blockers when working in large codebases or legacy systems? How do you currently understand code you didn't write?

**Exercise:** Analyze and refactor Spring PetClinic
* Clone Spring PetClinic: `git clone https://github.com/spring-projects/spring-petclinic`
* Open in new Cursor window
* Use Chat mode to understand the architecture:
  * "Explain the entity relationships in this application"
  * "How does the Owner-Pet-Visit relationship work?"
  * "Trace the request flow for GET /owners/1"
* Use Agent mode for refactoring:
  * Find a method to rename and update all references
  * Identify opportunities to use modern Java features (records, streams)
  * Generate documentation for a complex service class

**Q&A**

---

### Section 6: Collaborative Coding & Workflow Integration (25 minutes)

**Presentation:** AI in team development and production workflows
* AI pair programming principles: driver (you) and navigator (AI)
* Code review with Cursor: analyzing PRs, suggesting improvements, finding bugs
* Git integration: generating commit messages, understanding diffs, resolving conflicts
* Documentation generation: JavaDoc, README files, API documentation
* Team best practices: consistency, code standards, when to use AI vs. human expertise
* Managing costs and context: token usage, model selection, conversation management

**Discussion:** When would you trust Cursor's output in a pull request? When would you override it or prompt again? How should teams establish AI usage guidelines?

**Exercise:** Real-world workflow scenarios
* Select a feature you've built today (Task API)
* Use Cursor to:
  1. Generate comprehensive JavaDoc comments for all classes
  2. Create meaningful Git commit messages for your changes
  3. Generate a README.md section documenting the Task API
  4. Perform a code review: "Review this controller for best practices, security issues, and performance"
* Apply one suggested improvement from the code review
* Draft a team guideline: "When should we use AI assistance in our project?"

**Q&A**

---

### Section 7: Final Project and Wrap-Up (30 minutes)

**Presentation:** Bringing it all together - Building a complete feature
* Guided walkthrough: Planning a feature with AI assistance
* End-to-end development: entity → repository → service → controller → tests
* Iterative refinement: starting simple, adding complexity
* Quality checklist: validation, error handling, tests, documentation
* Next steps: advanced Cursor features (MCP, Extended Thinking, custom commands)

**Discussion:** Reflect on today's exercises - Where can Cursor save you the most time going forward? What surprised you about AI-assisted development?

**Exercise:** Build a Comment feature for Tasks
* Use Cursor to guide you through creating:
  1. Comment entity with relationship to Task (one-to-many)
  2. CommentRepository with custom query methods
  3. CommentService with business logic
  4. REST endpoints in TaskController or new CommentController
  5. Request/Response DTOs using records
  6. Full test suite (unit + integration)
* Challenge: Let AI drive most of the implementation while you verify and refine
* Run the complete application with all features working

**Q&A:** Final open Q&A, top tips recap, and next steps for continuing your AI-assisted development journey

---

### Instructor Information

Ken Kousen is the author of the Kotlin Cookbook (O'Reilly), Modern Java Recipes (O'Reilly), Gradle Recipes for Android (O'Reilly), and Making Java Groovy (Manning), as well as O'Reilly video courses in Android, Groovy, Gradle, advanced Java, and Spring. A JavaOne Rock Star, he's a regular speaker on the No Fluff Just Stuff conference tour and has spoken at conferences all over the world. Through his company, Kousen I.T., Inc., he's taught software development training courses to thousands of students.

**Instructor photo**

* In [Headshot Inbox](https://drive.google.com/drive/folders/1yA5MF0XrfJMm-8VSxPPL7DPor66f_BuJ?usp=sharing).

