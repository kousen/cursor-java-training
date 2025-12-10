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

**Goal:** Scaffold a Spring AI project using the Spring Initializr in Cursor
**Time:** 15 minutes

### Step 1: Create Project with Spring Initializr

1. **Open Command Palette** in Cursor (`Cmd+Shift+P` on Mac, `Ctrl+Shift+P` on Windows/Linux)

2. **Run:** `Spring Initializr: Create a Gradle Project`

3. **Select the following options:**
   - **Spring Boot version:** 3.5.7
   - **Language:** Java
   - **Group Id:** `com.example`
   - **Artifact Id:** `spring-ai-demo`
   - **Packaging:** Jar
   - **Java version:** 21
   - **Dependencies:**
     - Spring Web
     - OpenAI (under the AI section)

4. **Choose a location** to save the project and open it in Cursor

### Step 2: Verify Gradle Version

Ensure you're using Gradle 9.2.0 or later. Check `gradle/wrapper/gradle-wrapper.properties`:

```properties
distributionUrl=https\://services.gradle.org/distributions/gradle-9.2.0-bin.zip
```

If the version is older, update it to 9.2.0.

### Step 3: Verify Gradle Dependencies

Your `build.gradle` should include:

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.5.7'
    id 'io.spring.dependency-management' version '1.1.7'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

ext {
    set('springAiVersion', "1.1.0")
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.ai:spring-ai-starter-model-openai'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}

dependencyManagement {
    imports {
        mavenBom "org.springframework.ai:spring-ai-bom:${springAiVersion}"
    }
}
```

### Step 4: Configure API Keys

Open `src/main/resources/application.properties` and add:

```properties
spring.ai.openai.api-key=${OPENAI_API_KEY}
spring.ai.openai.chat.options.model=gpt-4o
spring.ai.openai.chat.options.temperature=0.7
```

Ensure the environment variable is set in your terminal:

```bash
export OPENAI_API_KEY=your-api-key-here
```

### Step 5: Verify Setup

Run the application and ensure it starts without errors:

```bash
./gradlew bootRun
```

You should see Spring Boot start up on port 8080 with no errors.

> **Note:** We'll add the vector store and RAG dependencies in Lab 2 when we need them.

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

**Goal:** Build a Retrieval Augmented Generation pipeline using the Advisor pattern
**Time:** 40 minutes

### Step 1: Add RAG Dependencies (5 min)

Add the vector store and RAG advisor dependencies to your `build.gradle`:

```groovy
dependencies {
    // Existing dependencies...
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.ai:spring-ai-starter-model-openai'

    // Add these for RAG support
    implementation 'org.springframework.ai:spring-ai-advisors-vector-store'
    implementation 'org.springframework.ai:spring-ai-starter-vector-store-simple'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

Run `./gradlew build` to download the new dependencies.

### Step 2: Configure Vector Store (5 min)

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
        return SimpleVectorStore.builder(embeddingModel).build();
    }
}
```

### Step 3: Create Sample Document (5 min)

Create `src/main/resources/documents/policy.txt` with sample content:
```text
Company Vacation Policy

All full-time employees are entitled to 20 days of paid vacation per year.
Vacation days must be requested at least 2 weeks in advance.
Unused vacation days can be carried over to the next year, up to a maximum of 5 days.
Employees in their first year receive prorated vacation based on start date.
```

### Step 4: Ingest Documents (10 min)

**Agent Mode:**
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
@Slf4j
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
        log.info("Loaded {} document chunks into vector store", documents.size());
    }
}
```

### Step 5: Create RAG Controller with QuestionAnswerAdvisor (15 min)

Spring AI provides the `QuestionAnswerAdvisor` which handles the entire RAG flow automatically:
- Searches the vector store for relevant documents
- Injects the retrieved context into the prompt
- Sends the augmented prompt to the LLM

**Agent Mode:**
```
Create a RagController with a GET endpoint /api/rag/query.
Use QuestionAnswerAdvisor to handle RAG automatically.
Configure it to retrieve the top 5 most similar documents.
```

**Expected Result:**
```java
@RestController
@RequestMapping("/api/rag")
public class RagController {

    private final ChatClient chatClient;

    public RagController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder
            .defaultAdvisors(
                QuestionAnswerAdvisor.builder(vectorStore)
                    .searchRequest(SearchRequest.builder()
                        .topK(5)
                        .build())
                    .build())
            .build();
    }

    @GetMapping("/query")
    public String query(@RequestParam String question) {
        return chatClient.prompt()
            .user(question)
            .call()
            .content();
    }
}
```

Notice how much simpler this is compared to manual RAG implementation! The `QuestionAnswerAdvisor` handles:
- Similarity search against the vector store
- Building the context from retrieved documents
- Augmenting the prompt with instructions to answer from context

### Step 6: Test RAG

```bash
curl "localhost:8080/api/rag/query?question=How many vacation days do employees get?"
curl "localhost:8080/api/rag/query?question=Can I carry over unused vacation?"
```

### Student Exercise: Custom Search Configuration (15 min)

**Challenge:** Add an endpoint that allows dynamic filtering by metadata.

**Agent Mode:**
```
1. Modify DocumentLoader to add metadata (source: "hr-policy", year: "2024") to documents
2. Create a new endpoint /api/rag/query/filtered that accepts a 'source' parameter
3. Use the advisors() method with FILTER_EXPRESSION to filter at query time
```

**Expected Result:**
```java
@GetMapping("/query/filtered")
public String queryFiltered(
        @RequestParam String question,
        @RequestParam(required = false) String source) {

    var prompt = chatClient.prompt().user(question);

    if (source != null) {
        prompt = prompt.advisors(a -> a.param(
            QuestionAnswerAdvisor.FILTER_EXPRESSION,
            "source == '" + source + "'"));
    }

    return prompt.call().content();
}
```

### Advanced Exercise: RetrievalAugmentationAdvisor (Optional)

For more control over the RAG pipeline, use `RetrievalAugmentationAdvisor`:

```java
// Add to build.gradle: implementation 'org.springframework.ai:spring-ai-rag'

Advisor ragAdvisor = RetrievalAugmentationAdvisor.builder()
    .documentRetriever(VectorStoreDocumentRetriever.builder()
        .vectorStore(vectorStore)
        .similarityThreshold(0.5)
        .topK(5)
        .build())
    .build();

ChatClient chatClient = builder
    .defaultAdvisors(ragAdvisor)
    .build();
```

This approach allows adding query transformers (rewriting, translation) and custom query augmenters.

---

## Lab 3: Tools & Function Calling

**Goal:** Give the AI the ability to execute Java code using the @Tool annotation
**Time:** 40 minutes

### Step 1: Create a Weather Tools Class (10 min)

Spring AI uses the `@Tool` annotation to define methods that the AI can call. This is much simpler than the older `Function<Input, Output>` approach.

**Agent Mode:**
```
Create a WeatherTools class with a method annotated with @Tool.
The method should be named 'getCurrentWeather' and take a location parameter.
Use @ToolParam to describe the parameter.
Return a record with location, temperature, and description.
```

**Expected Result:**
```java
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTools {

    public record WeatherResponse(String location, String temperature, String description) {}

    @Tool(description = "Get the current weather for a specified location. "
        + "Use this when the user asks about weather conditions.")
    public WeatherResponse getCurrentWeather(
            @ToolParam(description = "The city and state, e.g., 'San Francisco, CA'") String location,
            @ToolParam(description = "Temperature unit: 'celsius' or 'fahrenheit'", required = false) String unit) {

        // Mock implementation - in production, call a real weather API
        String temp = "celsius".equalsIgnoreCase(unit) ? "22°C" : "72°F";
        return new WeatherResponse(location, temp, "Sunny with light clouds");
    }
}
```

**Key Points:**
- `@Tool` marks the method as callable by the AI
- `description` is critical - it tells the AI *when* to use this tool
- `@ToolParam` describes each parameter for the AI
- `required = false` marks optional parameters
- Return types are automatically serialized to JSON

### Step 2: Register Tools with ChatClient (10 min)

**Agent Mode:**
```
Create a ToolController with a GET endpoint /api/tools/chat.
Inject ChatClient.Builder and WeatherTools.
Use the .defaultTools() method to register the tools.
```

**Expected Result:**
```java
@RestController
@RequestMapping("/api/tools")
public class ToolController {

    private final ChatClient chatClient;

    public ToolController(ChatClient.Builder builder, WeatherTools weatherTools) {
        this.chatClient = builder
            .defaultTools(weatherTools)
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

Notice how simple this is:
- Inject the tools class (it's a Spring `@Component`)
- Pass it to `.defaultTools()` - Spring AI discovers all `@Tool` methods automatically

### Step 3: Test Function Calling

```bash
curl "localhost:8080/api/tools/chat?message=What's the weather in San Francisco?"
curl "localhost:8080/api/tools/chat?message=How about in London in celsius?"
```

The AI will:
1. Recognize it needs weather information
2. Call your `getCurrentWeather` method
3. Use the response to formulate its answer

### Step 4: Add Tools Per-Request (5 min)

You can also add tools to individual requests instead of as defaults:

```java
@GetMapping("/chat/weather")
public String chatWithWeather(@RequestParam String message) {
    return chatClient.prompt()
        .user(message)
        .tools(weatherTools)  // Add tools for this request only
        .call()
        .content();
}
```

### Step 5: Database Tool (Advanced - 15 min)

**Agent Mode:**
```
Create a CustomerTools class with methods to look up customers.
Add a @Tool method 'findCustomerByEmail' that searches for customers.
Use a simple in-memory map for now (or connect to a real repository).
```

**Expected Result:**
```java
@Component
public class CustomerTools {

    public record Customer(Long id, String name, String email, String tier) {}

    // Simulated database
    private final Map<String, Customer> customers = Map.of(
        "alice@example.com", new Customer(1L, "Alice Smith", "alice@example.com", "Gold"),
        "bob@example.com", new Customer(2L, "Bob Jones", "bob@example.com", "Silver")
    );

    @Tool(description = "Find a customer by their email address. "
        + "Use this when the user asks about a specific customer.")
    public Customer findCustomerByEmail(
            @ToolParam(description = "The customer's email address") String email) {

        return customers.getOrDefault(email,
            new Customer(null, "Unknown", email, "Not Found"));
    }

    @Tool(description = "List all customers in a specific membership tier. "
        + "Valid tiers are: Gold, Silver, Bronze.")
    public List<Customer> getCustomersByTier(
            @ToolParam(description = "Membership tier: Gold, Silver, or Bronze") String tier) {

        return customers.values().stream()
            .filter(c -> c.tier().equalsIgnoreCase(tier))
            .toList();
    }
}
```

Register both tool classes:

```java
public ToolController(ChatClient.Builder builder,
                      WeatherTools weatherTools,
                      CustomerTools customerTools) {
    this.chatClient = builder
        .defaultTools(weatherTools, customerTools)
        .build();
}
```

### Student Exercise: Order Management Tools (20 min)

**Challenge:** Create a set of related tools that work together for order management.

**Agent Mode:**
```
Create an OrderTools class with three @Tool methods:
1. createOrder(productId, quantity) - creates an order and returns the order ID
2. getOrderStatus(orderId) - returns the current status of an order
3. cancelOrder(orderId) - cancels an order and returns success/failure

Use an in-memory map to track orders.
Test by asking the AI to "Create an order for 2 widgets, then check its status."
```

**Hints:**
- Use a `ConcurrentHashMap` to store orders
- Generate order IDs with `UUID.randomUUID().toString().substring(0, 8)`
- Track order status as an enum: PENDING, CONFIRMED, SHIPPED, CANCELLED

### Tool Best Practices

1. **Write clear descriptions** - The AI uses these to decide when to call your tool
2. **Document parameters** - Include format examples in `@ToolParam` descriptions
3. **Handle errors gracefully** - Return error information rather than throwing exceptions
4. **Keep tools focused** - One tool should do one thing well
5. **Consider side effects** - Document if a tool modifies data

---

## Lab 4: MCP Exploration

**Goal:** Understand Model Context Protocol and configure MCP servers in Cursor
**Time:** 20 minutes

### Step 1: Understanding MCP (5 min)

**What is MCP?**
- Model Context Protocol - a standard for connecting AI to external data sources
- Provides real-time context to AI assistants beyond their training data
- Enables access to live documentation, web content, APIs, and more
- Open protocol supported by Cursor, Claude Desktop, and other AI tools

**Why does this matter?**
- AI models have a knowledge cutoff date
- MCP lets them access current information dynamically
- Tools can be added without changing the AI itself

### Step 2: Configure Context7 MCP Server (10 min)

Context7 provides up-to-date documentation for libraries and frameworks - perfect for looking up Spring AI docs while you're building!

1. **Open Cursor Settings**
   - Go to Cursor → Settings → Features → MCP
   - Or press `Cmd+Shift+J` (Mac) / `Ctrl+Shift+J` (Windows)

2. **Add the Context7 MCP Server**

   Click "Add MCP Server" and configure:
   ```json
   {
     "mcpServers": {
       "context7": {
         "command": "npx",
         "args": [
           "-y",
           "@upstash/context7-mcp"
         ]
       }
     }
   }
   ```

3. **Restart Cursor** to apply changes

4. **Verify the server is running**
   - Go back to Settings → MCP
   - You should see "context7" listed with a green status

### Step 3: Test Context7 Integration (5 min)

With Context7 configured, try these prompts in Cursor Chat:

```
"Using context7, look up the current Spring AI documentation for ChatClient"
"What's the latest API for configuring RAG advisors in Spring AI?"
"Show me examples of @Tool annotation usage from the Spring AI docs"
```

Context7 will fetch live documentation, so you'll get the most current API information!

### Optional: Add Playwright MCP Server

For browser automation and web interaction, add the Playwright MCP server:

```json
{
  "mcpServers": {
    "context7": {
      "command": "npx",
      "args": ["-y", "@upstash/context7-mcp"]
    },
    "playwright": {
      "command": "npx",
      "args": ["-y", "@anthropic/mcp-server-playwright"]
    }
  }
}
```

**Note:** First run may require: `npx playwright install chromium`

With Playwright, you can ask Cursor to:
- Navigate to websites and take screenshots
- Interact with web applications
- Test your running Spring AI app in the browser

### Available MCP Servers

**Documentation & Knowledge:**
- `@upstash/context7-mcp` - Live library documentation
- `@anthropic/mcp-server-fetch` - Fetch and read web pages

**Browser & Web:**
- `@anthropic/mcp-server-playwright` - Browser automation
- `@anthropic/mcp-server-puppeteer` - Alternative browser control

**Development Tools:**
- `@anthropic/mcp-server-github` - GitHub API integration
- `@anthropic/mcp-server-filesystem` - Local file access

**Explore more:** [MCP Servers Repository](https://github.com/modelcontextprotocol/servers)

### Student Exercise: MCP Exploration (10 min)

**Try these experiments:**

1. **Documentation lookup:** Ask Cursor to explain a Spring AI feature using Context7. Compare the answer with and without the MCP server enabled.

2. **Code generation:** Ask Cursor to generate code based on the latest Spring AI patterns. Does it use the current API?

3. **Cross-reference:** Ask about a feature in multiple libraries (e.g., "How does Spring AI's tool calling compare to LangChain's?")

**Discussion questions:**
- How does MCP change your workflow when learning new libraries?
- What other MCP servers would be useful for your projects?
- How might you build your own MCP server for internal documentation?

---

## Part B: Exploration Exercises (Homework)

### Lab 5: Legacy Modernization with Spring AI

**Goal:** Modernize a legacy Spring Boot 2.7 application and add AI-powered capabilities
**Time:** 45 minutes (homework)

### Overview

In this lab, you'll take a legacy `OrderService` from the Session 4 materials and:
1. Copy it into your Spring AI project
2. Modernize the code patterns
3. Add AI-powered order analysis

### Step 1: Copy Legacy Code (5 min)

Copy the legacy service from `session4-testing/legacy-app/` into your `spring-ai-demo` project:

```bash
# From the session5-agents directory
cp -r ../session4-testing/legacy-app/src/main/java/com/example/legacy \
      spring-ai-demo/src/main/java/com/example/
```

Review what you're working with - the `OrderService.java` has several issues:

```java
@Service
public class OrderService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EmailService emailService;

    public void processOrder(String orderId, String userId, List<String> productIds) {
        // Legacy date handling
        Date now = new Date();
        System.out.println("Processing order " + orderId + " at " + now);

        // ... business logic with hardcoded discount rules ...

        if (total > 1000) {
            System.out.println("Applying discount for big order");
            total = total * 0.9;
        }

        // ... more processing ...
    }
}
```

**Issues to fix:**
- Field injection (`@Autowired` on fields)
- `java.util.Date` instead of `java.time` API
- `System.out.println` instead of proper logging
- `RuntimeException` instead of custom exceptions
- Hardcoded business rules
- No return value (void method)

### Step 2: Modernize with Constructor Injection (10 min)

**Agent Mode:**
```
Refactor OrderService to use constructor injection instead of field injection.
Remove all @Autowired annotations from fields.
Add a constructor that takes all dependencies.
```

**Expected Result:**
```java
@Service
public class OrderService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final EmailService emailService;

    public OrderService(InventoryService inventoryService,
                        PaymentService paymentService,
                        EmailService emailService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.emailService = emailService;
    }

    // ... rest of class
}
```

### Step 3: Modernize Date Handling and Logging (10 min)

**Agent Mode:**
```
Update OrderService to:
1. Replace java.util.Date with java.time.Instant or LocalDateTime
2. Replace System.out.println with SLF4J logging using @Slf4j
3. Add appropriate log levels (info for normal flow, warn for discounts, error for failures)
```

**Expected Result:**
```java
@Service
@Slf4j
public class OrderService {
    // ...

    public void processOrder(String orderId, String userId, List<String> productIds) {
        Instant now = Instant.now();
        log.info("Processing order {} at {}", orderId, now);

        // ... business logic ...

        if (total > 1000) {
            log.info("Applying 10% discount for order {} (total: {})", orderId, total);
            total = total * 0.9;
        }

        // ...
    }
}
```

### Step 4: Add Custom Exceptions (5 min)

**Agent Mode:**
```
Create custom exceptions for the order processing:
1. OutOfStockException - when a product is unavailable
2. PaymentFailedException - when payment processing fails
Replace RuntimeException throws with these custom exceptions.
```

**Expected Result:**
```java
public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String productId) {
        super("Product out of stock: " + productId);
    }
}

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String userId, double amount) {
        super("Payment failed for user " + userId + ", amount: " + amount);
    }
}
```

### Step 5: Add AI-Powered Order Analysis (15 min)

Now add Spring AI to provide intelligent order analysis. This is where it gets interesting!

**Agent Mode:**
```
Add a ChatClient to OrderService.
Create an OrderAnalysisReport record with fields: riskLevel (String),
riskScore (int 1-10), recommendations (List<String>), summary (String).
Create an analyzeOrder method that:
1. Takes the order details (orderId, userId, productIds, total)
2. Sends them to the AI for risk and fraud analysis
3. Returns a structured OrderAnalysisReport
```

**Expected Result:**
```java
public record OrderAnalysisReport(
    String riskLevel,
    int riskScore,
    List<String> recommendations,
    String summary
) {}

@Service
@Slf4j
public class OrderService {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final EmailService emailService;
    private final ChatClient chatClient;

    public OrderService(InventoryService inventoryService,
                        PaymentService paymentService,
                        EmailService emailService,
                        ChatClient.Builder chatClientBuilder) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.emailService = emailService;
        this.chatClient = chatClientBuilder.build();
    }

    public OrderAnalysisReport analyzeOrder(String orderId, String userId,
                                            List<String> productIds, double total) {
        String orderDetails = """
            Order ID: %s
            User ID: %s
            Products: %s
            Total: $%.2f
            """.formatted(orderId, userId, productIds, total);

        return chatClient.prompt()
            .system("""
                You are a fraud detection system. Analyze the order for potential risks.
                Consider: unusual quantities, high-value orders, product combinations.
                Provide a risk assessment with actionable recommendations.
                """)
            .user(orderDetails)
            .call()
            .entity(OrderAnalysisReport.class);
    }

    // ... existing processOrder method ...
}
```

### Step 6: Create Order Analysis Endpoint (Optional)

**Agent Mode:**
```
Create an OrderController with:
1. POST /api/orders/process - processes an order
2. POST /api/orders/analyze - analyzes an order for risks without processing
Return the OrderAnalysisReport as JSON.
```

### Step 7: Test Your AI-Powered Service

```bash
# Analyze an order for risks
curl -X POST "localhost:8080/api/orders/analyze" \
  -H "Content-Type: application/json" \
  -d '{
    "orderId": "ORD-123",
    "userId": "user-456",
    "productIds": ["PROD-1", "PROD-2", "PROD-3"],
    "total": 2500.00
  }'
```

### Bonus Challenge: Order Tools for AI

Convert the order operations into AI-callable tools:

**Agent Mode:**
```
Create an OrderTools class with @Tool annotated methods:
1. analyzeOrderRisk - analyzes an order for fraud
2. getOrderHistory - retrieves past orders for a user
3. checkInventoryLevels - checks stock for products

Register these tools with a ChatClient so the AI can autonomously
decide when to check inventory or analyze risk during a conversation.
```

This allows natural interactions like:
```
"I want to place an order for 50 laptops. Is that suspicious?"
"Check if we have enough stock for order ORD-789"
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
