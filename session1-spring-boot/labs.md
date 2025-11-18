# Session 1: Lab Exercises

**Using Cursor for Java Development**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Setup Verification](#lab-0-setup-verification)
2. [Lab 1: Creating Hello Spring Boot](#lab-1-creating-hello-spring-boot)
3. [Lab 2: Adding Service Layer](#lab-2-adding-service-layer)
4. [Lab 3: Adding Persistence](#lab-3-adding-persistence)
5. [Lab 4: Code Quality & Refactoring](#lab-4-code-quality--refactoring)
6. [Lab 5: Test Generation](#lab-5-test-generation)

### Part B: Exploration Exercises (Homework/Practice)
7. [Lab 6: Analyzing Spring PetClinic](#lab-6-analyzing-spring-petclinic)
8. [Lab 7: PetClinic Deep Dive](#lab-7-petclinic-deep-dive)
9. [Lab 8: Advanced Challenges](#lab-8-advanced-challenges)

---

## Part A: Code-Along Exercises (In-Class)

These exercises are designed to be completed during the session with instructor guidance. They can be repeated independently for practice.

---

## Lab 0: Setup Verification

**Goal:** Ensure Cursor is properly configured for Java development  
**Time:** 5 minutes

### Prerequisites

- Cursor installed from [cursor.sh](https://cursor.sh)
- Java 17 or 21 installed (`java -version`)
- Gradle or Maven available

### **Steps**

1. **Open Cursor**

2. **Verify Extensions** (Cmd/Ctrl+Shift+X)
   
   Install these if missing:
   - [ ] Language Support for Java (Red Hat)
   - [ ] Debugger for Java (Microsoft)
   - [ ] Spring Boot Extension Pack (VMware)
   - [ ] Gradle for Java (Microsoft)
   - [ ] REST Client (Huachao Mao)

3. **Test AI Modes**

   **Chat Mode (Cmd/Ctrl+L):**
   ```
   Type: "What is Spring Boot?"
   Expected: Detailed explanation
   ```

   **Agent Mode (Cmd/Ctrl+I):**
   ```
   Type: "Create a simple Java hello world class"
   Expected: Code generation offer
   ```

4. **Test Terminal** (``Ctrl+` ``)
   ```bash
   java -version
   gradle -version  # or: mvn -version
   ```

### Troubleshooting

**If you have Java 25 or newer:**
- The Gradle wrapper in projects may not support Java 25+
- **Solution 1:** Use Java 21 (recommended):
  ```bash
  export JAVA_HOME=$(/usr/libexec/java_home -v 21)  # macOS
  # or set JAVA_HOME to your Java 21 installation
  ```
- **Solution 2:** Update Gradle wrapper to 9.1.0+ (if using Java 25+)

### Success Criteria

- ✅ All extensions installed
- ✅ Chat mode responds to questions
- ✅ Agent mode offers to generate code
- ✅ Terminal works and shows Java version

---

## Lab 1: Creating Hello Spring Boot

**Goal:** Create a Spring Boot REST API from scratch with AI assistance  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Generate Project (5 min)

1. **Use Spring Initializr in Cursor (Command Palette):**
   - `Cmd/Ctrl+Shift+P` → type: `Spring Initializr`
   - Select: **Generate a Gradle Project**
   - Language: **Java**
   - Spring Boot: **3.5.6**
   - Group: `com.example`
   - Artifact: `hello-spring`
   - Java: **21**
   - Choose folder and open the new project window

2. **Add Dependencies:** (when prompted)
   - Spring Web
   - Spring Data JPA
   - H2 Database
   - Validation
   - Spring Boot DevTools

3. **Alternative (optional):** Use `start.spring.io` and then open the folder in Cursor

### Step 2: Create First REST Controller (10 min)

1. **Open Agent Mode** (Cmd/Ctrl+I)

2. **Use this prompt:**
   Type:
   ```
      Create a REST controller for a Greeting resource with:
      - Package: com.example.hellospring.controller
      - Class name: GreetingController
      - A GET endpoint at /api/greetings
      - Accept a 'name' query parameter (default: "World")
      - Return a JSON response with a message field
      - Use a Java record for the response
   ```

3. **Review Generated Code**

   Expected structure:
   ```java
   @RestController
   @RequestMapping("/api/greetings")
   public class GreetingController {
       
       @GetMapping
       public GreetingResponse greet(
               @RequestParam(defaultValue = "World") String name) {
           String message = "Hello, " + name + "!";
           return new GreetingResponse(message);
       }
       
       public record GreetingResponse(String message) {}
   }
   ```

4. **Run the Application**

   Open Terminal (``Ctrl+` ``):
   ```bash
   ./gradlew bootRun
   ```
   
   **Note:** If you encounter Gradle compatibility issues with Java 25+, set JAVA_HOME to Java 21:
   ```bash
   export JAVA_HOME=$(/usr/libexec/java_home -v 21)
   ./gradlew bootRun
   ```

5. **Test the Endpoint**
   
   Open browser, use REST Client, or curl:
   ```bash
   # Browser:
   http://localhost:8080/api/greetings?name=Cursor

   # REST Client (.http file):
   ### file: requests.http
   GET http://localhost:8080/api/greetings?name=Cursor

   # curl:
   curl http://localhost:8080/api/greetings?name=Cursor

   # Expected response:
   {"message":"Hello, Cursor!"}
   ```

### Success Criteria

- ✅ Spring Boot application starts without errors
- ✅ GET request returns JSON response
- ✅ Query parameter works (try different names)
- ✅ Record class used for response

### Understanding Check (Chat Mode)

Ask Chat (Cmd/Ctrl+L):
Type:
```
   Explain how Spring Boot automatically configures this REST controller
```

Expected learning:
- `@RestController` combines `@Controller` + `@ResponseBody`
- `@RequestMapping` maps HTTP requests to handler methods
- Spring Boot auto-configures JSON serialization (Jackson)
- Embedded Tomcat server starts automatically

---

## Lab 2: Adding Service Layer

**Goal:** Extract business logic into a service with dependency injection  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Create Service (10 min)

1. **Use Agent Mode** (Cmd/Ctrl+I)

2. **Prompt:**
   Type:
   ```
      Create a GreetingService in package com.example.hellospring.service with:
      - @Service annotation
      - Method createGreeting(String name) - returns formatted greeting
      - Method createFormalGreeting(String name) - returns formal greeting
      - Use String.format() for message formatting
   ```

3. **Review Generated Service**

   Expected:
   ```java
   @Service
   public class GreetingService {
       
       public String createGreeting(String name) {
           return String.format("Hello, %s! Welcome to Spring Boot with Cursor.", name);
       }
       
       public String createFormalGreeting(String name) {
           return String.format("Good day, %s. It's a pleasure to meet you.", name);
       }
   }
   ```

### Step 2: Refactor Controller (5 min)

1. **Select GreetingController class**

2. **Use Agent Mode:**
   Type:
   ```
      Refactor this controller to use GreetingService with constructor injection.
      Use the createGreeting method from the service.
   ```

3. **Review Refactored Controller**

   Expected:
   ```java
   @RestController
   @RequestMapping("/api/greetings")
   public class GreetingController {
       
       private final GreetingService greetingService;
       
       public GreetingController(GreetingService greetingService) {
           this.greetingService = greetingService;
       }
       
       @GetMapping
       public GreetingResponse greet(
               @RequestParam(defaultValue = "World") String name) {
           String message = greetingService.createGreeting(name);
           return new GreetingResponse(message);
       }
       
       public record GreetingResponse(String message) {}
   }
   ```

### Step 3: Add Formal Endpoint

**Student Exercise (5 min):**

Use Agent to:
Type:
```
   Add a new GET endpoint at /api/greetings/formal that uses 
   the createFormalGreeting method from the service
```

Test:
```bash
curl http://localhost:8080/api/greetings/formal?name=Java
```

### Success Criteria

- ✅ Service created with `@Service` annotation
- ✅ Controller uses constructor injection
- ✅ Both endpoints work correctly
- ✅ Business logic separated from controller

### Understanding Check (Chat Mode)

Ask Chat:
Type:
```
   Explain Spring's dependency injection and why constructor injection is preferred
```

---

## Lab 3: Adding Persistence

**Goal:** Create JPA entity, repository, and CRUD operations  
**Time:** 30 minutes  
**Mode:** Code-along with instructor

### Step 1: Create Person Entity (10 min)

1. **Use Agent Mode:**
   Type:
   ```
      Create a Person entity in package com.example.hellospring.entity with:
      - JPA annotations (@Entity, @Table, @Id, @GeneratedValue)
      - Fields: id (Long), firstName, lastName, email
      - Validation: firstName and lastName @NotBlank, email @Email and @NotBlank
      - Standard getters, setters, constructors
      - equals, hashCode, toString methods
   ```

2. **Review Generated Entity**

   Key elements to verify:
   - `@Entity` and `@Table(name = "persons")`
   - `@Id` with `@GeneratedValue(strategy = GenerationType.IDENTITY)`
   - Validation annotations from `jakarta.validation.constraints`
   - Proper constructors (no-arg and all-args)

3. **Ask Chat (optional):**
   ```
   Should I use a Java record for this entity? Why or why not?
   ```

### Step 2: Create Repository (5 min)

1. **Use Agent Mode:**
   Type:
   ```
      Create a PersonRepository interface in package com.example.hellospring.repository:
      - Extend JpaRepository<Person, Long>
      - Add derived query methods:
      - findByLastName(String lastName)
      - findByEmail(String email)
      - findByFirstNameContainingIgnoreCase(String firstName)
   ```

2. **Review Generated Repository**

   Expected:
   ```java
   @Repository
   public interface PersonRepository extends JpaRepository<Person, Long> {
       List<Person> findByLastName(String lastName);
       Optional<Person> findByEmail(String email);
       List<Person> findByFirstNameContainingIgnoreCase(String firstName);
   }
   ```

3. **Ask Chat:**
   Type:
   ```
      How does Spring Data JPA generate implementations for these methods?
   ```

### Step 3: Create CRUD Controller (15 min)

1. **Use Agent Mode:**
   Type:
   ```
      Create a PersonController in package com.example.hellospring.controller:
      - @RestController with @RequestMapping("/api/persons")
      - Inject PersonRepository
      - Implement all CRUD endpoints:
      - GET / - find all persons
      - GET /{id} - find person by id
      - POST / - create person (with @Valid)
      - PUT /{id} - update person
      - DELETE /{id} - delete person
      - Use appropriate HTTP status codes
      - Return ResponseEntity for proper responses
   ```

2. **Review Generated Controller**

   Verify these endpoints exist:
   - `@GetMapping` - returns `List<Person>`
   - `@GetMapping("/{id}")` - returns `ResponseEntity<Person>`
   - `@PostMapping` - accepts `@Valid @RequestBody Person`
   - `@PutMapping("/{id}")` - updates existing person
   - `@DeleteMapping("/{id}")` - returns `ResponseEntity<Void>`

3. **Test the API**

   **Create a person:**
   ```bash
   curl -X POST http://localhost:8080/api/persons \
     -H "Content-Type: application/json" \
     -d '{
       "firstName": "John",
       "lastName": "Doe",
       "email": "john@example.com"
     }'
   ```

   **Get all persons:**
   ```bash
   curl http://localhost:8080/api/persons
   ```

   **Get one person:**
   ```bash
   curl http://localhost:8080/api/persons/1
   ```

   **Update person:**
   ```bash
   curl -X PUT http://localhost:8080/api/persons/1 \
     -H "Content-Type: application/json" \
     -d '{
       "firstName": "Jane",
       "lastName": "Doe",
       "email": "jane@example.com"
     }'
   ```

   **Delete person:**
   ```bash
   curl -X DELETE http://localhost:8080/api/persons/1
   ```

### Success Criteria

- ✅ Entity created with proper JPA annotations
- ✅ Repository interface with derived queries
- ✅ Controller with all CRUD operations
- ✅ Validation works (try invalid email)
- ✅ All HTTP status codes correct (200, 201, 404, etc.)

### Understanding Check (Chat Mode)

Ask Chat:
Type:
```
   Explain the full request flow from HTTP request to database for POST /api/persons
```

---

## Lab 4: Code Quality & Refactoring

**Goal:** Improve code with DTOs, error handling, and modern patterns  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: Create DTOs with Records (10 min)

1. **Ask Chat first:**
   Type:
   ```
      Why should I use DTOs instead of exposing JPA entities directly in REST APIs?
   ```

2. **Use Agent Mode:**
   Type:
   ```
      Create PersonRequest and PersonResponse DTOs using Java records in package 
      com.example.hellospring.dto:

      PersonRequest (for POST/PUT):
      - Fields: firstName, lastName, email
      - Include validation annotations

      PersonResponse (for GET responses):
      - Fields: id, firstName, lastName, email
      - Add static factory method from(Person person)
   ```

3. **Review Generated DTOs**

   PersonRequest:
   ```java
   public record PersonRequest(
       @NotBlank(message = "First name is required")
       String firstName,
       
       @NotBlank(message = "Last name is required")
       String lastName,
       
       @Email(message = "Email must be valid")
       @NotBlank(message = "Email is required")
       String email
   ) {}
   ```

   PersonResponse:
   ```java
   public record PersonResponse(
       Long id,
       String firstName,
       String lastName,
       String email
   ) {
       public static PersonResponse from(Person person) {
           return new PersonResponse(
               person.getId(),
               person.getFirstName(),
               person.getLastName(),
               person.getEmail()
           );
       }
   }
   ```

4. **Refactor Controller to Use DTOs**

   Use Agent:
   Type:
   ```
      Refactor PersonController to use PersonRequest for input and 
      PersonResponse for output instead of Person entity
   ```

### Step 2: Add Global Exception Handler (10 min)

1. **Use Agent Mode:**
   Type:
   ```
      Create a GlobalExceptionHandler in package com.example.hellospring.exception:
      - Use @RestControllerAdvice
      - Handle MethodArgumentNotValidException (validation errors)
      - Handle generic exceptions
      - Return structured error responses with timestamp, status, message, and errors
      - Use a record for ErrorResponse
   ```

2. **Review Generated Handler**

   Expected structure:
   ```java
   @RestControllerAdvice
   public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
       
       @Override
       protected ResponseEntity<Object> handleMethodArgumentNotValid(
               MethodArgumentNotValidException ex,
               HttpHeaders headers,
               HttpStatusCode status,
               WebRequest request) {
           
           Map<String, String> errors = new HashMap<>();
           ex.getBindingResult().getFieldErrors().forEach(error -> 
               errors.put(error.getField(), error.getDefaultMessage())
           );
           
           ErrorResponse errorResponse = new ErrorResponse(
               LocalDateTime.now(),
               HttpStatus.BAD_REQUEST.value(),
               "Validation Failed",
               errors
           );
           
           return ResponseEntity.badRequest().body(errorResponse);
       }
       
       record ErrorResponse(
           LocalDateTime timestamp,
           int status,
           String message,
           Object errors
       ) {}
   }
   ```

3. **Test Validation**

   Send invalid request:
   ```bash
   curl -X POST http://localhost:8080/api/persons \
     -H "Content-Type: application/json" \
     -d '{
       "firstName": "",
       "lastName": "Doe",
       "email": "not-an-email"
     }'
   ```

   Expected response:
   ```json
   {
     "timestamp": "2024-01-15T10:30:00",
     "status": 400,
     "message": "Validation Failed",
     "errors": {
       "firstName": "First name is required",
       "email": "Email must be valid"
     }
   }
   ```

### Step 3: Code Review with Chat (5 min)

**Student Exercise:**

1. **Select PersonController class**

2. **Ask Chat:**
   Type:
   ```
      Review this controller and suggest improvements for:
      - Code organization
      - Best practices
      - Error handling
      - Performance
   ```

3. **Apply ONE suggested improvement with Agent**

### Success Criteria

- ✅ DTOs created using Java records
- ✅ Controller uses request/response DTOs
- ✅ Global exception handler catches validation errors
- ✅ Error responses are structured and informative
- ✅ Code improvements applied

---

## Lab 5: Test Generation

**Goal:** Generate unit and integration tests with AI  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Unit Tests for Service (10 min)

1. **Select GreetingService class**

2. **Use Agent Mode:**
   Type:
   ```
      Generate comprehensive unit tests for this service using:
      - JUnit 5
      - AssertJ assertions
      - @DisplayName annotations for readable test names
      - Test all public methods
      - Include edge cases (null, empty string, special characters)
   ```

3. **Review Generated Tests**

   Expected structure:
   ```java
   @DisplayName("GreetingService Tests")
   class GreetingServiceTest {
       
       private GreetingService greetingService;
       
       @BeforeEach
       void setUp() {
           greetingService = new GreetingService();
       }
       
       @Test
       @DisplayName("Should create greeting with provided name")
       void shouldCreateGreetingWithName() {
           String result = greetingService.createGreeting("Alice");
           
           assertThat(result)
               .isNotNull()
               .contains("Alice")
               .startsWith("Hello");
       }
       
       @Test
       @DisplayName("Should handle empty name")
       void shouldHandleEmptyName() {
           String result = greetingService.createGreeting("");
           assertThat(result).isNotNull();
       }
       
       // More tests...
   }
   ```

4. **Run Tests**

   Terminal:
   ```bash
   ./gradlew test --tests GreetingServiceTest
   ```

### Step 2: Integration Tests for Controller (10 min)

1. **Select PersonController class**

2. **Use Agent Mode:**
   Type:
   ```
      Generate integration tests for this controller using:
      - @SpringBootTest and @AutoConfigureMockMvc
      - MockMvc for HTTP requests
      - ObjectMapper for JSON serialization
      - Test all CRUD endpoints
      - Include valid and invalid data scenarios
      - Use @BeforeEach to clear database
   ```

3. **Review Generated Tests**

   Key test example:
   ```java
   @SpringBootTest
   @AutoConfigureMockMvc
   @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
   class PersonControllerIntegrationTest {
       
       @Autowired
       private MockMvc mockMvc;
       
       @Autowired
       private ObjectMapper objectMapper;
       
       @Autowired
       private PersonRepository personRepository;
       
       @BeforeEach
       void setUp() {
           personRepository.deleteAll();
       }
       
       @Test
       @Order(1)
       @DisplayName("Should create person with valid data")
       void shouldCreatePerson() throws Exception {
           PersonRequest request = new PersonRequest(
               "John", "Doe", "john@example.com"
           );
           
           mockMvc.perform(post("/api/persons")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(objectMapper.writeValueAsString(request)))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.id").exists())
               .andExpect(jsonPath("$.firstName").value("John"))
               .andExpect(jsonPath("$.lastName").value("Doe"))
               .andExpect(jsonPath("$.email").value("john@example.com"));
       }
       
       @Test
       @Order(2)
       @DisplayName("Should reject invalid email")
       void shouldRejectInvalidEmail() throws Exception {
           PersonRequest request = new PersonRequest(
               "Jane", "Doe", "not-an-email"
           );
           
           mockMvc.perform(post("/api/persons")
                   .contentType(MediaType.APPLICATION_JSON)
                   .content(objectMapper.writeValueAsString(request)))
               .andExpect(status().isBadRequest())
               .andExpect(jsonPath("$.errors.email").exists());
       }
   }
   ```

4. **Run All Tests**

   ```bash
   ./gradlew test
   ```

   View results:
   ```bash
   open build/reports/tests/test/index.html
   ```

### Student Exercise (Optional)

**Generate your own test:**

1. Select any service method
2. Use Agent to generate tests
3. Run and verify they pass

### Success Criteria

- ✅ Unit tests generated for service
- ✅ Integration tests for controller
- ✅ Tests use modern JUnit 5 features
- ✅ All tests pass
- ✅ Edge cases covered

### Understanding Check (Chat Mode)

Ask Chat:
Type:
```
   Explain the difference between @SpringBootTest and @WebMvcTest. 
   When should I use each?
```

---

## 🎉 Checkpoint: Hello Spring Boot Complete!

**Congratulations!** You now have:

- ✅ Complete REST API with CRUD operations
- ✅ Service layer with dependency injection
- ✅ JPA persistence with H2 database
- ✅ Bean validation with custom error handling
- ✅ DTOs using modern Java records
- ✅ Global exception handling
- ✅ Comprehensive test suite

**Time for a break, then we'll explore Spring PetClinic!**

---

## Part B: Exploration Exercises (Homework/Practice)

These exercises help you practice analyzing and understanding complex existing codebases. Complete them at your own pace.

---

## Lab 6: Analyzing Spring PetClinic

**Goal:** Use Cursor's AI to understand a complex Spring Boot application  
**Time:** 30-45 minutes  
**Mode:** Self-paced with guided questions

### Setup

1. **Clone PetClinic (Command Palette - Recommended):**
   - `Cmd/Ctrl+Shift+P` → `Git: Clone`
   - Paste: `https://github.com/spring-projects/spring-petclinic`
   - Choose folder → Open in New Window

   **Alternative (terminal):**
   ```bash
   cd ~/projects  # or your preferred location
   git clone https://github.com/spring-projects/spring-petclinic
   cd spring-petclinic
   cursor .
   ```
   Or: File → New Window → File → Open Folder → Select `spring-petclinic`

3. **Explore Project Structure:**
   - Take 5 minutes to browse the file tree
   - Notice the package organization
   - Identify familiar patterns from Hello Spring Boot

### Exercise 1: Architecture Overview (10 min)

**Use Chat Mode for these questions:**

1. **Overall Architecture:**
   Type:
   ```
      Explain the overall architecture of this Spring PetClinic application. 
      What layers does it have?
   ```

2. **Design Patterns:**
   Type:
   ```
      What design patterns are used in this application? 
      Give specific examples with file names.
   ```

3. **Technology Stack:**
   Type:
   ```
      List all the major technologies and frameworks used in this project. 
      Include Spring Boot version, database, template engine, etc.
   ```

**Document your findings:**
- Create a file `petclinic-notes.md` in the project
- Save AI responses for reference

### Exercise 2: Entity Relationships (15 min)

**Understanding the Domain Model:**

1. **Identify Entities:**
   Type:
   ```
      Chat: List all JPA entity classes in this application with their purpose
   ```

2. **Relationship Analysis:**
   Type:
   ```
      Chat: Explain the relationship between Owner, Pet, and Visit entities. 
      Show me the JPA annotations used.
   ```

3. **Inheritance Hierarchy:**
   Type:
   ```
      Chat: Explain the class hierarchy starting from BaseEntity. 
      Which entities extend which classes?
   ```

4. **Draw the Diagram:**

   Ask Chat:
   Type:
   ```
      Create a mermaid diagram showing all entity relationships in this application
   ```

   Copy the diagram to your notes

### Exercise 3: Request Flow Tracing (10 min)

**Follow a Complete Request:**

1. **Trace Owner Retrieval:**
   Type:
   ```
      Chat: Walk me through the complete flow when a user requests GET /owners/1
      Include: controller → service → repository → database → response
   ```

2. **Find the Code:**

   Use Quick Open (Cmd/Ctrl+P) to navigate:
   - `Owner` → Open Owner.java
   - `OwnerController` → Open OwnerController.java
   - `OwnerRepository` → Open OwnerRepository.java

3. **Understand Each Layer:**

   For each file, ask Chat:
   Type:
   ```
      Explain what this [Controller/Repository/Entity] does and its key methods
   ```

### Exercise 4: Feature Discovery (10 min)

**Find Specific Features:**

1. **REST Endpoints:**
   Type:
   ```
      Chat: Show me all REST endpoints in this application. 
      Group them by resource (owners, pets, vets, visits).
   ```

2. **Validation Rules:**
   Type:
   ```
      Chat: What validation is applied to the Owner entity? 
      List all validation annotations and their purposes.
   ```

3. **Query Methods:**
   Type:
   ```
      Chat: Find all custom query methods in the repositories. 
      Explain how Spring Data JPA generates implementations.
   ```

4. **Template Views:**
   Type:
   ```
      Chat: List all Thymeleaf templates in this application. 
      What is each template used for?
   ```

### Exercise 5: Running PetClinic (5 min)

1. **Build and Run:**
   ```bash
   ./mvnw spring-boot:run
   # or with Gradle:
   ./gradlew bootRun
   ```

2. **Explore the UI:**
   - Open: http://localhost:8080
   - Find owners
   - View owner details
   - Add a new pet
   - Register a visit
   - View veterinarians

3. **Connect UI to Code:**

   While using the UI, ask Chat:
   Type:
   ```
      How does the "Add Owner" form submission work? 
      Show me the controller method and template.
   ```

### Success Criteria

- ✅ Understanding of overall architecture
- ✅ Entity relationships mapped
- ✅ Request flow traced
- ✅ All endpoints identified
- ✅ Application runs successfully
- ✅ Notes documented for reference

### Reflection Questions

Use Chat to explore:
1. "What Spring Boot features does PetClinic use that Hello Spring Boot didn't?"
2. "Compare PetClinic's architecture to Hello Spring Boot. What are the key differences?"
3. "What would you improve in this codebase? Any code smells?"

---

## Lab 7: PetClinic Deep Dive

**Goal:** Advanced code understanding and pattern recognition  
**Time:** 45-60 minutes  
**Mode:** Self-paced challenges

### Challenge 1: Database Configuration (15 min)

**Understand Multi-Database Support:**

1. **Ask Chat:**
   Type:
   ```
      How does PetClinic support multiple databases (H2, MySQL, PostgreSQL)?
      Show me the configuration files.
   ```

2. **Explore Profiles:**
   Type:
   ```
      Chat: Explain the Spring profiles used in this application. 
      What changes between profiles?
   ```

3. **Switch Database:**

   Try running with different profiles:
   ```bash
   # H2 (default)
   ./mvnw spring-boot:run

   # MySQL profile
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
   ```

   Ask Chat:
   Type:
   ```
      What configuration changes when I activate the 'mysql' profile?
   ```

### Challenge 2: Template Integration (15 min)

**Thymeleaf Templates:**

1. **Find Owner Template:**
   
   Navigate to: `src/main/resources/templates/owners/ownerDetails.html`

2. **Ask Chat:**
   Type:
   ```
      Explain how this Thymeleaf template works:
      [paste the template content]
   
      Focus on:
      - How data is passed from controller
      - Thymeleaf expressions used
      - How it handles the pets collection
   ```

3. **Trace Data Flow:**
   Type:
   ```
      Chat: Show me the complete flow from OwnerController to this template.
      How does the Owner object with its pets get to the view?
   ```

4. **Form Handling:**
   Type:
   ```
      Chat: How does the "Add Pet" form work? 
      Show me the template, controller method, and validation.
   ```

### Challenge 3: Repository Patterns (15 min)

**Spring Data JPA Queries:**

1. **Custom Queries:**

   Find `OwnerRepository.java` and ask Chat:
   Type:
   ```
      Explain this custom query method:
      [paste the @Query annotation and method]
   
      Why use @Query instead of derived query methods?
   ```

2. **Eager vs Lazy Loading:**
   Type:
   ```
      Chat: Find all @OneToMany and @ManyToOne relationships. 
      Which use EAGER loading and which use LAZY? Why?
   ```

3. **Compare to Hello Spring Boot:**
   Type:
   ```
      Chat: How do PetClinic's repository patterns differ from 
      the simple PersonRepository we created in Hello Spring Boot?
   ```

### Challenge 4: Testing Strategies (15 min)

**Explore Test Patterns:**

1. **Repository Tests:**

   Find: `src/test/java/.../OwnerRepositoryTests.java`

   Ask Chat:
   Type:
   ```
      Explain the testing strategy used for this repository.
      What annotations are used and why?
   ```

2. **Controller Tests:**

   Find: `src/test/java/.../OwnerControllerTests.java`

   Ask Chat:
   Type:
   ```
      How are these controller tests different from our 
      PersonController integration tests in Hello Spring Boot?
   ```

3. **Test Coverage:**
   Type:
   ```
      Chat: What testing patterns and frameworks does PetClinic use? 
      List examples of unit tests, integration tests, and any other test types.
   ```

### Success Criteria

- ✅ Multi-database configuration understood
- ✅ Thymeleaf template integration clear
- ✅ Repository patterns analyzed
- ✅ Testing strategies identified
- ✅ Comparisons to Hello Spring Boot made

---

## Lab 8: Advanced Challenges

**Goal:** Practice advanced AI-assisted development  
**Time:** 60+ minutes  
**Mode:** Independent work

### Challenge 1: Add New Feature (45 min)

**Task: Add "Pet Insurance" Feature**

1. **Design with Chat:**
   Type:
   ```
      Chat: I want to add a Pet Insurance feature to PetClinic where:
      - Each pet can have one insurance policy
      - Insurance has: provider, policyNumber, expiryDate, coverageAmount
      - Owners should see insurance details on pet page
   
      Suggest the implementation approach including:
      - New entity structure
      - Repository methods needed
      - Controller endpoints
      - Template modifications
   ```

2. **Implement with Agent:**

   a. Create `PetInsurance` entity:
   Type:
   ```
      Agent: Create a PetInsurance entity in the model package with:
      - Fields: id, provider, policyNumber, expiryDate, coverageAmount
      - OneToOne relationship with Pet
      - JPA annotations
      - Validation
   ```

   b. Add repository:
   Type:
   ```
      Agent: Create PetInsuranceRepository extending JpaRepository
      with methods to find insurance by pet
   ```

   c. Update controller:
   Type:
   ```
      Agent: Add insurance management endpoints to PetController
   ```

   d. Update templates:
   Type:
   ```
      Agent: Modify petDetails.html to display insurance information
   ```

3. **Test Your Feature:**
   - Generate tests for new entity
   - Test endpoints with curl
   - Verify in UI

### Challenge 2: Refactoring Exercise (30 min)

**Task: Modernize Code**

1. **Find Improvement Opportunities:**
   Type:
   ```
      Chat: Review the Visit entity and controller. 
      Suggest modern Java improvements (records, streams, optional, etc.)
   ```

2. **Apply Refactoring:**

   Use Agent to:
   - Convert POJOs to records where appropriate
   - Use Optional instead of null checks
   - Apply stream operations
   - Add defensive copying where needed

3. **Verify with Tests:**
   - Ensure existing tests still pass
   - Generate new tests if needed

### Challenge 3: Performance Analysis (20 min)

**Task: Identify Performance Issues**

1. **N+1 Query Problem:**
   Type:
   ```
      Chat: Analyze the code for potential N+1 query problems. 
      Show me specific examples where lazy loading might cause performance issues.
   ```

2. **Find Solutions:**
   Type:
   ```
      Chat: How can I fix the N+1 query problem in [specific location]? 
      Show me the code changes needed.
   ```

3. **Implement Fix:**

   Use Agent to apply the suggested improvements

### Challenge 4: Security Review (15 min)

**Task: Security Analysis**

1. **Ask Chat:**
   Type:
   ```
      Review this application for common security vulnerabilities:
      - SQL injection risks
      - XSS vulnerabilities
      - Missing authentication/authorization
      - Insecure data handling
   
      Provide specific file locations and recommendations.
   ```

2. **Understand Findings:**

   For each issue found, ask:
   Type:
   ```
      Chat: Explain this security issue in detail and show me how to fix it
   ```

### Challenge 5: API Documentation (20 min)

**Task: Generate OpenAPI/Swagger Docs**

1. **Research with Chat:**
   Type:
   ```
      How can I add OpenAPI/Swagger documentation to this Spring Boot application?
      Show me the dependencies and configuration needed.
   ```

2. **Implement:**

   Use Agent to:
   - Add Swagger dependencies to pom.xml
   - Configure Swagger
   - Add API documentation annotations to controllers

3. **Verify:**
   - Run application
   - Access: http://localhost:8080/swagger-ui.html
   - Explore generated API docs

### Success Criteria

- ✅ New feature implemented and working
- ✅ Code refactored with modern Java patterns
- ✅ Performance issues identified and fixed
- ✅ Security review completed
- ✅ API documentation added

---

## Bonus Challenges

### Challenge: Convert to Kotlin

**Advanced: Port part of PetClinic to Kotlin**

1. Ask Chat:
   Type:
   ```
      How would I convert the Owner entity from Java to Kotlin?
      Show me the equivalent Kotlin code.
   ```

2. Create a parallel Kotlin version of one entity

3. Compare with Chat:
   Type:
   ```
      Compare the Java and Kotlin versions. What are the benefits of each?
   ```

### Challenge: Add GraphQL API

**Advanced: Add GraphQL alongside REST**

1. Research:
   Type:
   ```
      Chat: How can I add GraphQL to this Spring Boot application 
      alongside the existing REST API?
   ```

2. Implement a GraphQL endpoint for one resource

3. Test with GraphQL Playground

### Challenge: Containerization

**DevOps: Docker Setup**

1. Ask Chat:
   Type:
   ```
      Generate a Dockerfile and docker-compose.yml for this application
      Include MySQL database setup
   ```

2. Build and run:
   ```bash
   docker-compose up
   ```

3. Verify application works in container

---

## Final Reflection

After completing these labs, reflect on:

1. **Chat vs Agent Decision Making:**
   - When did you choose Chat over Agent?
   - Were there times you chose wrong? What happened?

2. **AI Accuracy:**
   - Did AI ever suggest incorrect solutions?
   - How did you identify and fix AI mistakes?

3. **Productivity Gains:**
   - What tasks were dramatically faster with AI?
   - What still required human insight?

4. **Learning:**
   - What did you learn from AI explanations?
   - Where did you need to verify with documentation?

**Document in:** `learning-reflection.md`

---

## Additional Resources

### Spring Boot References
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring PetClinic](https://github.com/spring-projects/spring-petclinic)

### Cursor Resources
- [Cursor Documentation](https://docs.cursor.com)
- [Cursor Forum](https://forum.cursor.sh)
- Quick Start Guide: `cursor-quickstart-for-intellij-users.md`

### Java & Testing
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ Documentation](https://assertj.github.io/doc/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)

### Next Steps
- Session 2: Mobile Development with Cursor (Android/Kotlin)
- Practice these exercises with your own projects
- Explore advanced Cursor features (MCP, custom commands)

---

**Happy Coding with Cursor!** 🚀

