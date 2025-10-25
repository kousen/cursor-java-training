# Session 1: Using Cursor for Java Development

**Duration:** 3 hours  
**Audience:** ~100 experienced Java developers (primarily IntelliJ IDEA users)  
**Format:** Instructor-led with code-along exercises

## Session Objectives

By the end of this session, participants will be able to:
- Navigate Cursor effectively for Java development
- Use AI modes (Chat vs Agent) appropriately for different tasks
- Generate, modify, and refactor Java/Spring Boot code with AI assistance
- Understand and analyze existing codebases using Cursor
- Debug and test Java applications in Cursor

## Two-Project Approach

### Project 1: Hello Spring Boot (Code-Along)
**Purpose:** Build from scratch together  
**Duration:** ~90 minutes (Parts 1-4)  
**Approach:** Instructor-led, students follow along  
**Deliverable:** Working Spring Boot REST API with CRUD operations

### Project 2: Spring PetClinic (Exploration)
**Purpose:** Analyze complex existing code  
**Duration:** ~60 minutes (Parts 5-6) + homework  
**Approach:** Guided exploration, deeper practice in labs  
**Repository:** https://github.com/spring-projects/spring-petclinic

---

## Detailed Timeline

### Part 1: Setup & Foundations (30 minutes)

#### Welcome & Objectives (5 min)
- Course overview (5 sessions)
- Session 1 goals: Understanding, Navigation, Generation, Testing
- Two-project approach explanation
- Today's deliverables

#### Cursor Quick Setup Review (10 min)
- Quick verification: Is Cursor installed?
- Opening your first workspace
- Essential extensions check:
  - Language Support for Java (Red Hat)
  - Debugger for Java
  - Spring Boot Extension Pack
  - Gradle for Java
- IntelliJ → Cursor key concepts
  - Workspace vs Project
  - Multi-window support
  - Command Palette (Cmd/Ctrl+Shift+P)

#### Understanding AI Modes (15 min)
- **Chat Mode (Cmd/Ctrl+L)**: Questions, explanations, understanding
  - "How does this work?"
  - "Explain this Spring configuration"
  - "What's the difference between X and Y?"
  
- **Agent Mode (Cmd/Ctrl+I)**: Code generation, modifications
  - "Add a new REST endpoint"
  - "Refactor this method"
  - "Generate tests for this class"

- **Live Demo:** Same task in both modes
  - Chat: "Explain how to add validation"
  - Agent: "Add validation to this class"

---

### Part 2: Project Creation (30 minutes)

#### Creating Hello Spring Boot (30 min)
**Goal:** Build a simple Spring Boot REST API from scratch

**Step 1: Project Setup (5 min)**
- Use Spring Initializr (start.spring.io)
- Dependencies: Web, JPA, H2, Validation, DevTools
- Group: `com.example`, Artifact: `hello-spring`
- Generate and open in Cursor

**Step 2: First REST Controller (10 min)**
- **AI-Assisted Creation:**
  ```
  Agent: "Create a REST controller for a Greeting resource with a GET endpoint 
  that returns a greeting message with a name parameter"
  ```
- Review generated code
- Run application (`./gradlew bootRun`)
- Test endpoint: http://localhost:8080/greet?name=World

**Step 3: Add Service Layer (15 min)**
- **AI-Assisted:**
  ```
  Agent: "Add a service layer between the controller and add business logic 
  to format the greeting message"
  ```
- Review dependency injection
- Understand Spring Boot's component scanning
- **Quick Exercise:** Students add their own greeting format

**Checkpoint:** Everyone has a working "Hello, World" REST API

---

### Part 3: Adding Persistence (30 minutes)

#### Entity & Repository (30 min)

**Step 1: Create Person Entity (10 min)**
- **AI-Assisted:**
  ```
  Agent: "Create a Person entity with id, firstName, lastName, and email. 
  Use JPA annotations and include validation"
  ```
- Review generated code:
  - `@Entity`, `@Id`, `@GeneratedValue`
  - Validation annotations
  - Modern Java features (records? getters/setters?)

**Step 2: Add Repository (10 min)**
- **AI-Assisted:**
  ```
  Agent: "Create a Spring Data JPA repository for Person with 
  custom query methods to find by lastName and email"
  ```
- Understand derived queries
- Review Spring Data JPA magic

**Step 3: CRUD Controller (10 min)**
- **AI-Assisted:**
  ```
  Agent: "Create a REST controller for Person with all CRUD operations 
  (GET, POST, PUT, DELETE)"
  ```
- Review HTTP methods
- Test with curl or browser

**Deliverable:** Working CRUD API for Person resource

---

### BREAK (10 minutes)

---

### Part 4: Code Quality & Testing (30 minutes)

#### Refactoring & Improvement (15 min)

**Demo: Modernizing Code**
- **Chat for review:**
  ```
  Chat: "Review this controller and suggest improvements"
  ```
- Apply suggested improvements with Agent
- Convert POJOs to records (if applicable)
- Add proper error handling
- Improve validation messages

**Student Exercise (5 min):**
- Ask Chat to review their Person entity
- Apply one suggested improvement with Agent

#### Test Generation (15 min)

**Demo: Unit Tests**
- **AI-Assisted:**
  ```
  Agent: "Generate unit tests for PersonService using JUnit 5 and Mockito"
  ```
- Review test structure
- Mocking dependencies
- Test data creation

**Demo: Integration Tests**
- **AI-Assisted:**
  ```
  Agent: "Create integration tests for PersonController using MockMvc"
  ```
- Review `@SpringBootTest` vs `@WebMvcTest`
- Testing REST endpoints

**Student Exercise (5 min):**
- Generate tests for one method
- Run tests: `./gradlew test`

**Checkpoint:** Complete Spring Boot application with tests

---

### BREAK (10 minutes)

---

### Part 5: Understanding Complex Code (35 minutes)

#### Exploring Spring PetClinic (35 min)

**Setup (5 min)**
- **Clone repository:**
  ```bash
  git clone https://github.com/spring-projects/spring-petclinic
  cd spring-petclinic
  cursor .
  ```
- Open in new Cursor window (multi-window demo)
- First impressions: project structure

#### AI-Powered Code Understanding (15 min)

**Demo: Architecture Overview**
- **Chat:** "Explain the overall architecture of this application"
- **Chat:** "What design patterns are used here?"
- **Chat:** "How is the database configured?"

**Demo: Navigation Techniques**
- Find all REST endpoints
  ```
  Chat: "Show me all REST endpoints in this application"
  ```
- Understand entity relationships
  ```
  Chat: "Explain the relationship between Owner, Pet, and Visit entities"
  ```
- Trace request flow
  ```
  Chat: "Walk me through what happens when I GET /owners/{id}"
  ```

**Demo: Quick Navigation**
- `Cmd/Ctrl+P`: Quick file open
- `Cmd/Ctrl+Shift+O`: Find symbols (methods, classes)
- `Cmd+Click`: Go to definition
- `Shift+F12`: Find usages

#### Student Exploration (15 min)

**Guided Exercise:**
Students use Chat to answer:
1. "How many entity classes are there? List them"
2. "Which controller handles vet operations?"
3. "Explain how pet types are stored and retrieved"
4. "What validation is applied to the Owner entity?"
5. "How are visits associated with pets?"

**Share findings:** Quick discussion of what students discovered

---

### Part 6: Terminal, Debugging & Workflow (25 minutes)

#### Terminal Integration (10 min)

**Demo: Gradle Tasks**
- Opening terminal (``Ctrl+` ``)
- Multiple terminal sessions
- Common tasks:
  ```bash
  ./gradlew build
  ./gradlew test
  ./gradlew bootRun
  ```
- AI assistance:
  ```
  Agent: "Run the Spring Boot application in the terminal"
  ```

**Demo: Running PetClinic**
- Start application: `./gradlew bootRun`
- Open: http://localhost:8080
- Explore running application
- View logs in terminal

#### Debugging Basics (10 min)

**Demo: Debug Workflow**
- Set breakpoint in a controller method
- Start debugging (F5 or Debug CodeLens)
- Step through code (F10, F11)
- Inspect variables
- Evaluate expressions

**AI-Assisted Debugging:**
- **Chat:** "Why is this test failing?" (paste test output)
- **Chat:** "Explain this NullPointerException" (paste stack trace)

#### Workflow Tips (5 min)

**Multi-Window Setup:**
- Window 1: Hello Spring Boot (your code)
- Window 2: Spring PetClinic (reference)
- Each window: independent AI context

**Productivity Shortcuts Review:**
- `Cmd/Ctrl+P`: Quick Open
- `Cmd/Ctrl+Shift+F`: Find in Files
- `Cmd/Ctrl+L`: Open Chat
- `Cmd/Ctrl+I`: Open Agent
- ``Ctrl+` ``: Toggle Terminal

---

### Wrap-Up & Next Steps (10 minutes)

#### Key Takeaways (5 min)

**Decision Tree:**
```
Need to understand code? → Use Chat (Cmd/Ctrl+L)
Need to write/modify code? → Use Agent (Cmd/Ctrl+I)
Need to find something? → Use Quick Open (Cmd/Ctrl+P)
Need to run/test? → Use Terminal (Ctrl+`)
```

**What We Built:**
- ✅ Complete Spring Boot REST API (Hello Spring Boot)
- ✅ CRUD operations with JPA
- ✅ Validation and error handling
- ✅ Unit and integration tests
- ✅ Code understanding skills (PetClinic)

**What's in labs.md:**
- Detailed steps for Hello Spring Boot (redo on your own)
- Advanced PetClinic exploration exercises
- Challenge problems for more practice

#### Preview Session 2 (3 min)

**Mobile Development with Cursor**
- Android/Kotlin basics
- Building UI with Jetpack Compose
- AI-assisted mobile development
- Same AI techniques, different platform

#### Q&A (2 min)
- Quick questions
- Troubleshooting common issues
- Where to get help

---

## Materials Provided

### Pre-Session
- Setup instructions document
- Cursor installation guide
- Extension recommendations
- System requirements check

### During Session
- These slides (slides.md)
- Live coding demonstrations
- GitHub repository links
- Quick reference cards

### Post-Session
- Complete labs.md with all exercises
- Starter code for Hello Spring Boot
- Solution code for reference
- PetClinic exploration challenges
- Additional resources and links

---

## Success Metrics

Students should leave able to:
- [ ] Create a Spring Boot project with AI assistance
- [ ] Navigate effectively using Cursor's tools
- [ ] Choose appropriate AI mode (Chat vs Agent) for tasks
- [ ] Generate REST endpoints, services, and repositories
- [ ] Write and run tests
- [ ] Understand unfamiliar code using AI analysis
- [ ] Use terminal for build/run tasks
- [ ] Debug Java applications in Cursor

---

## Instructor Notes

### Timing Buffers
- Breaks provide 20 min catch-up time
- Can compress PetClinic section if needed
- Hello Spring Boot must be completed

### Common Issues & Solutions
- **Java Language Server not loading:** Restart window
- **Gradle not recognized:** Verify gradlew exists
- **AI seems slow:** Check internet connection
- **Extensions missing:** Install from Extensions panel

### Adaptation Points
- If ahead: More PetClinic challenges
- If behind: Simplify Hello Spring Boot, skip advanced features
- If questions: Use Chat to explore answers together

### Demo Tips
- Always show keyboard shortcuts
- Explain AI prompts before sending
- Review AI responses before accepting
- Highlight when AI makes mistakes (learning opportunity)
- Keep terminal visible when running apps

