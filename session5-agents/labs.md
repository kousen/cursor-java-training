# Session 5: Building AI-Powered Java Apps with Spring AI - Lab Exercises

**Duration:** 3 hours
**Audience:** ~100 experienced developers
**Prerequisites:** Java 21, Spring Boot 3.5.7, OpenAI/Anthropic API Key

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Spring AI Setup](#lab-0-spring-ai-setup)
2. [Lab 1: Chat Client & Templating](#lab-1-chat-client--templating)
3. [Lab 2: Implementing RAG](#lab-2-implementing-rag)
4. [Lab 3: Tools & Function Calling](#lab-3-tools--function-calling)
5. [Lab 4: MCP Exploration](#lab-4-mcp-exploration)

### Part B: Exploration Exercises (Homework)
6. [Lab 5: Legacy Modernization with Agents](#lab-5-legacy-modernization-with-agents)

---

## Part A: Code-Along Exercises (In-Class)

## Lab 0: Spring AI Setup

**Goal:** Scaffold a Spring AI project using Cursor
**Time:** 15 minutes

### Step 1: Create Project

**Composer Mode:**
```
Create a new Spring Boot 3.5.7 project named 'spring-ai-demo'.
Add dependencies: Spring Web, Spring AI OpenAI, Spring AI PDF Document Reader,
Spring AI Simple Vector Store.
Use Java 21 and Spring AI version 1.1.0.
```

### Step 2: Verify Maven Dependencies

Your `pom.xml` should include:
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.5.7</version>
</parent>

<properties>
    <java.version>21</java.version>
    <spring-ai.version>1.1.0</spring-ai.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework.ai</groupId>
        <artifactId>spring-ai-starter-model-openai</artifactId>
    </dependency>
</dependencies>
```

### Step 3: Configure API Keys

Open `application.properties` and add:
```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4o
spring.ai.openai.chat.options.temperature=0.7
```

Ensure the environment variable is set:
```bash
export OPENAI_API_KEY=your-api-key-here
```

### Step 4: Verify Setup

Run the application and ensure it starts without errors:
```bash
./mvnw spring-boot:run
```

---

## Lab 1: Chat Client & Templating

**Goal:** Interact with the LLM using the fluent ChatClient API
**Time:** 20 minutes

### Step 1: Create Chat Controller (10 min)

**Agent Mode:**
```
Create a ChatController with a GET endpoint /api/chat.
Inject ChatClient.Builder.
Use the ChatClient to send the user's message to the LLM and return the response.
```

**Expected Result:**
```java
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
            .user(message)
            .call()
            .content();
    }
}
```

### Step 2: Add System Prompt

**Agent Mode:**
```
Add a /api/chat/expert endpoint that uses a system prompt
to make the AI act as a Spring Boot expert.
```

**Expected Result:**
```java
@GetMapping("/expert")
public String expertChat(@RequestParam String topic) {
    return chatClient.prompt()
        .system("""
            You are an expert software architect
            specializing in Spring Boot applications.
            Provide concise, practical advice.
            """)
        .user("How do I implement " + topic)
        .call()
        .content();
}
```

### Step 3: Use Prompt Templates (10 min)

Create template file `src/main/resources/prompts/joke.st`:
```text
Tell me a {style} joke about {topic}.
Make it appropriate for a professional audience.
```

**Agent Mode:**
```
Refactor the controller to use a PromptTemplate.
Load the template from 'classpath:/prompts/joke.st'.
The template should accept 'topic' and 'style' variables.
```

### Step 4: Test It

```bash
curl "localhost:8080/api/chat?message=What is Spring AI?"
curl "localhost:8080/api/chat/expert?topic=caching"
curl "localhost:8080/api/chat/joke?topic=Java&style=dad"
```

### Student Exercise: Structured Responses (10 min)

**Challenge:** Create an endpoint that returns a Java record instead of a String.

**Agent Mode:**
```
Create a BookReview record with title, rating, and summary fields.
Create a /api/chat/review endpoint that uses .entity(BookReview.class)
to return structured JSON.
```

---

## Lab 2: Implementing RAG

**Goal:** Build a Retrieval Augmented Generation pipeline
**Time:** 40 minutes

### Step 1: Configure Vector Store (5 min)

**Agent Mode:**
```
Create a VectorStoreConfig class that provides a SimpleVectorStore bean.
Inject the EmbeddingModel.
```

**Expected Result:**
```java
@Configuration
public class VectorStoreConfig {

    @Bean
    public VectorStore vectorStore(EmbeddingModel embeddingModel) {
        return new SimpleVectorStore(embeddingModel);
    }
}
```

### Step 2: Create Sample Document (5 min)

Create `src/main/resources/documents/policy.txt` with sample content:
```text
Company Vacation Policy

All full-time employees are entitled to 20 days of paid vacation per year.
Vacation days must be requested at least 2 weeks in advance.
Unused vacation days can be carried over to the next year, up to a maximum of 5 days.
Employees in their first year receive prorated vacation based on start date.
```

### Step 3: Ingest Documents (15 min)

**Extended Thinking:**
```
Create a DocumentLoader component that implements CommandLineRunner.
It should:
1. Read 'policy.txt' from classpath using ClassPathResource
2. Use TokenTextSplitter to split into chunks
3. Load the chunks into the VectorStore
4. Log when ingestion is complete
```

**Expected Result:**
```java
@Component
public class DocumentLoader implements CommandLineRunner {

    private final VectorStore vectorStore;

    public DocumentLoader(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(String... args) {
        Resource resource = new ClassPathResource("documents/policy.txt");
        TextSplitter splitter = new TokenTextSplitter();
        List<Document> documents = splitter.split(new TextReader(resource).get());

        vectorStore.add(documents);
        log.info("Loaded {} document chunks", documents.size());
    }
}
```

### Step 4: Create RAG Controller (15 min)

**Agent Mode:**
```
Create a RagController with a GET endpoint /api/rag/query.
When a query comes in:
1. Search the VectorStore for top 5 similar documents
2. Build context from the retrieved documents
3. Use a system prompt that tells the AI to answer ONLY from context
4. Return the AI's response
```

**Expected Result:**
```java
@RestController
@RequestMapping("/api/rag")
public class RagController {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;

    public RagController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder.build();
        this.vectorStore = vectorStore;
    }

    @GetMapping("/query")
    public String query(@RequestParam String question) {
        List<Document> similarDocs = vectorStore.similaritySearch(
            SearchRequest.query(question).withTopK(5)
        );

        String context = similarDocs.stream()
            .map(Document::getContent)
            .collect(Collectors.joining("\n\n"));

        return chatClient.prompt()
            .system("""
                Answer the question based ONLY on the provided context.
                If you cannot answer from the context, say so.

                Context: %s
                """.formatted(context))
            .user(question)
            .call()
            .content();
    }
}
```

### Step 5: Test RAG

```bash
curl "localhost:8080/api/rag/query?question=How many vacation days do employees get?"
curl "localhost:8080/api/rag/query?question=Can I carry over unused vacation?"
```

### Student Exercise: RAG with Metadata (20 min)

**Challenge:** Add metadata to documents and filter by metadata in search.

**Agent Mode:**
```
Modify the DocumentLoader to add metadata (source, date) to each document.
Update the RAG query to filter by metadata using withFilterExpression.
```

---

## Lab 3: Tools & Function Calling

**Goal:** Give the AI the ability to execute Java code
**Time:** 40 minutes

### Step 1: Define Request/Response Records (5 min)

**Agent Mode:**
```
Create a Java Record 'WeatherRequest' with location (required) and unit (optional) fields.
Create a Java Record 'WeatherResponse' with location, temperature, and description fields.
Use @JsonProperty annotations for the request.
```

**Expected Result:**
```java
record WeatherRequest(
    @JsonProperty(required = true, value = "location") String location,
    @JsonProperty(required = false, value = "unit") String unit
) {}

record WeatherResponse(
    String location,
    String temperature,
    String description
) {}
```

### Step 2: Create Function Bean (10 min)

**Agent Mode:**
```
Create a ToolConfig class with a Function<WeatherRequest, WeatherResponse> bean.
Name it 'weatherFunction'.
Annotate with @Description("Get current weather for a location").
Return mock weather data for now.
```

**Expected Result:**
```java
@Configuration
public class ToolConfig {

    @Bean
    @Description("Get current weather for a location")
    public Function<WeatherRequest, WeatherResponse> weatherFunction() {
        return request -> new WeatherResponse(
            request.location(),
            "72°F",
            "Sunny with light clouds"
        );
    }
}
```

### Step 3: Register Tool with ChatClient (10 min)

**Agent Mode:**
```
Create a ToolController with a GET endpoint /api/tools/chat.
Inject ChatClient.Builder and the weatherFunction.
Configure the ChatClient to use the weatherFunction as a default function.
```

**Expected Result:**
```java
@RestController
@RequestMapping("/api/tools")
public class ToolController {

    private final ChatClient chatClient;

    public ToolController(
        ChatClient.Builder builder,
        Function<WeatherRequest, WeatherResponse> weatherFunction) {

        this.chatClient = builder
            .defaultFunctions(weatherFunction)
            .build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return chatClient.prompt()
            .user(message)
            .call()
            .content();
    }
}
```

### Step 4: Test Function Calling

```bash
curl "localhost:8080/api/tools/chat?message=What's the weather in San Francisco?"
curl "localhost:8080/api/tools/chat?message=How about in London?"
```

The AI should call your `weatherFunction` and describe the results!

### Step 5: Database Tool (Advanced - 15 min)

**Extended Thinking:**
```
Create a User entity with id, email, firstName, lastName.
Create a UserRepository with findByEmail method.
Create a userLookupFunction that finds users by email.
Annotate with @Description("Find user by email address").
Register this function with the ChatClient.
```

**Expected Result:**
```java
@Bean
@Description("Find user by email address")
public Function<UserLookupRequest, UserLookupResponse>
    userLookupFunction(UserRepository repo) {

    return request -> repo.findByEmail(request.email())
        .map(u -> new UserLookupResponse(
            u.getFirstName() + " " + u.getLastName(),
            u.getEmail()
        ))
        .orElse(new UserLookupResponse("Unknown", request.email()));
}
```

### Student Exercise: Multiple Tools (20 min)

**Challenge:** Create a set of related tools that work together.

**Agent Mode:**
```
Create three related functions:
1. createOrder(productId, quantity) - creates an order
2. getOrderStatus(orderId) - checks order status
3. cancelOrder(orderId) - cancels an order

Register all three with the ChatClient.
Test by asking the AI to "Create an order for 2 widgets, then check its status."
```

---

## Lab 4: MCP Exploration

**Goal:** Understand Model Context Protocol
**Time:** 20 minutes

### Step 1: Understanding MCP (5 min)

**What is MCP?**
- Protocol for connecting AI to external data sources
- Provides real-time context to AI assistants
- Enables database schema awareness, file access, API integration

### Step 2: Configure MCP in Cursor (10 min)

1. **Open Cursor Settings**
   - Go to Cursor → Settings → Features → MCP

2. **Add an MCP Server**

   Example configuration for PostgreSQL:
   ```json
   {
     "mcpServers": {
       "database": {
         "command": "npx",
         "args": [
           "-y",
           "@modelcontextprotocol/server-postgres",
           "postgresql://localhost/mydb"
         ]
       }
     }
   }
   ```

   Example configuration for filesystem:
   ```json
   {
     "mcpServers": {
       "filesystem": {
         "command": "npx",
         "args": [
           "-y",
           "@modelcontextprotocol/server-filesystem",
           "/path/to/your/project"
         ]
       }
     }
   }
   ```

3. **Restart Cursor** to apply changes

### Step 3: Test MCP Integration (5 min)

With MCP configured, try these prompts in Cursor Chat:

```
"What tables are in my database?"
"Describe the schema of the users table"
"What are the main entities and their relationships?"
```

### Available MCP Servers

**Official:**
- `@modelcontextprotocol/server-postgres` - PostgreSQL
- `@modelcontextprotocol/server-filesystem` - File access
- `@modelcontextprotocol/server-github` - GitHub API

**Community:**
- Jira, Slack, Notion integrations
- Cloud providers (AWS, GCP, Azure)

### Student Exercise: MCP Exploration (10 min)

**Questions to explore:**
1. How does MCP affect Cursor's code suggestions?
2. What queries work better with MCP enabled?
3. Does Cursor understand your database structure better?
4. Can you generate JPA entities from the database schema?

---

## Part B: Exploration Exercises (Homework)

### Lab 5: Legacy Modernization with AI

**Goal:** Apply Spring AI patterns to modernize legacy code
**Time:** 30 minutes (homework)

### Step 1: Analyze Legacy Code

Review the legacy `OrderService` from Session 4's `legacy-app` folder:

```java
// Legacy OrderService (Spring Boot 2.7)
@Service
public class OrderService {
    @Autowired private OrderRepository orderRepo;
    @Autowired private UserRepository userRepo;

    public void processOrder(Long orderId) throws Exception {
        Order order = orderRepo.findById(orderId).orElseThrow();
        // Complex business logic, no error handling, hard to test
    }
}
```

### Step 2: AI-Assisted Analysis

**Extended Thinking:**
```
Analyze this legacy OrderService.
Create a plan to:
1. Migrate to Spring Boot 3.x patterns
2. Replace field injection with constructor injection
3. Add proper error handling
4. Improve testability
5. Identify opportunities to add Spring AI for order analysis
```

### Step 3: Incremental Refactoring

**Step 3a: Constructor Injection**
```java
public OrderService(OrderRepository orderRepo, UserRepository userRepo) {
    this.orderRepo = orderRepo;
    this.userRepo = userRepo;
}
```

**Step 3b: Proper Error Handling**
```java
public Order processOrder(Long orderId) {
    return orderRepo.findById(orderId)
        .map(this::validateAndProcess)
        .orElseThrow(() -> new OrderNotFoundException(orderId));
}
```

### Step 4: Add AI Capabilities

**Extended Thinking:**
```
Add a Spring AI ChatClient to the OrderService.
Create an analyzeOrder method that:
1. Gets the order details
2. Sends them to the AI for risk analysis
3. Returns an OrderAnalysisReport with risk score and recommendations
```

**Expected Result:**
```java
public OrderAnalysisReport analyzeOrder(Long orderId) {
    Order order = getOrder(orderId);

    return chatClient.prompt()
        .system("Analyze this order for risks and anomalies")
        .user(toJson(order))
        .call()
        .entity(OrderAnalysisReport.class);
}
```

---

## Final Reflection

After completing these labs, reflect on:

1. **Spring AI Patterns:**
   - When would you use ChatClient vs RAG vs Function Calling?
   - How do you decide what to expose as AI tools?
   - What security considerations are important?

2. **Integration Strategies:**
   - How would you add AI to existing Spring Boot applications?
   - What's the best way to test AI-powered features?
   - How do you handle AI response variability?

3. **Team Adoption:**
   - How would you introduce Spring AI to your team?
   - What training would be most valuable?
   - How do you measure success?

---

## Additional Resources

### Spring AI
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Spring AI GitHub](https://github.com/spring-projects/spring-ai)
- [Spring AI Examples](https://github.com/spring-projects/spring-ai-examples)

### MCP
- [MCP Specification](https://modelcontextprotocol.io/)
- [MCP Servers Repository](https://github.com/modelcontextprotocol/servers)

### Course Resources
- Session 4 `legacy-app/` for modernization exercises
- Session 5 `spring-ai-demo/` for reference implementation

---

## Course Completion

**Congratulations!** You've completed the Cursor for Java Developers training series:

- **Session 1:** Cursor fundamentals - Chat, Agent, Composer modes
- **Session 2:** Mobile development with AI - Kotlin, Jetpack Compose
- **Session 3:** Agentic coding patterns - Advanced AI-assisted development
- **Session 4:** AI-assisted testing - JUnit 5, Mockito, AssertJ, TestContainers
- **Session 5:** Building AI-powered Java apps - Spring AI, RAG, Function Calling, MCP

You're now equipped to build intelligent Java applications with Spring AI!

---

**Session 5 complete! Go build amazing AI-powered applications!**
