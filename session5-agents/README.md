# Session 5: Building AI-Powered Java Apps with Spring AI

This directory contains materials and project code for Session 5 lab exercises.

## Project Structure

```
session5-agents/
├── README.md                    # This file
├── session5-outline.md          # Session timeline and structure
├── slides.md                    # Slidev presentation source
├── slides.pdf                   # Exported presentation
├── labs.md                      # Lab exercises
└── spring-ai-demo/              # Demo Spring AI application
```

## Spring AI Demo Application

This project demonstrates building intelligent Java applications using Spring AI:

- **ChatClient API** - Fluent interface for LLM interactions
- **Prompt Templates** - Reusable, parameterized prompts
- **RAG (Retrieval Augmented Generation)** - Chat with your documents
- **Function Calling** - Give AI tools to execute Java code
- **Vector Stores** - Document embedding and similarity search
- **Model Context Protocol (MCP)** - Enhanced context in Cursor

## Prerequisites

- **Java 21** or higher
- **Gradle 9.2+** (project uses Gradle wrapper)
- **Spring Boot 3.5.7**
- **OpenAI API Key** (or Anthropic API Key)
- **Cursor** with Claude support

## How to Run

### 1. Set Up API Keys

Set your OpenAI API key as an environment variable:

```bash
export OPENAI_API_KEY="your-api-key-here"
```

Or add it to `spring-ai-demo/src/main/resources/application.properties`:

```properties
spring.ai.openai.api-key=your-api-key-here
```

### 2. Navigate to Project

```bash
cd spring-ai-demo
```

### 3. Build and Run

```bash
./gradlew bootRun
```

### 4. Test the Endpoints

**Basic Chat:**
```bash
curl "http://localhost:8080/chat?message=Tell me a joke about Java"
```

**RAG Query (after completing Lab 2):**
```bash
curl "http://localhost:8080/api/rag/query?question=What is the company policy?"
```

**Function Calling (after completing Lab 3):**
```bash
curl "http://localhost:8080/api/tools/chat?message=What's the weather in San Francisco?"
```

## Technologies Used

- **Spring Boot 3.5.7** - Application framework
- **Spring AI 1.1.0** - AI integration for Spring
- **Java 21** - Programming language with records, pattern matching
- **OpenAI/Anthropic APIs** - Large Language Model providers
- **Simple Vector Store** - In-memory vector storage for development
- **Gradle 9.2+** - Build and dependency management

## Lab Exercises

This project is built through hands-on labs from [labs.md](./labs.md):

### Part A: Code-Along (In-Class)

- ✅ **Lab 0:** Spring AI Setup (15 min)
- ✅ **Lab 1:** Chat Client & Templating (20 min)
- ⏳ **Lab 2:** Implementing RAG (40 min)
- ⏳ **Lab 3:** Tools & Function Calling (40 min)
- ⏳ **Lab 4:** MCP Exploration (20 min)

### Part B: Exploration (Homework)

- ⏳ **Lab 5:** Legacy Modernization with Agents (45 min)

## Project Features

### ChatClient (Lab 1)

**Basic chat interface using Spring AI's fluent API:**

```java
@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
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

### RAG Pipeline (Lab 2)

**Chat with your documents using the QuestionAnswerAdvisor:**

```java
public RagController(ChatClient.Builder builder, VectorStore vectorStore) {
    this.chatClient = builder
        .defaultAdvisors(
            QuestionAnswerAdvisor.builder(vectorStore)
                .searchRequest(SearchRequest.builder().topK(5).build())
                .build())
        .build();
}
```

The advisor handles similarity search, context injection, and prompt augmentation automatically!

### Function Calling (Lab 3)

**Give AI the ability to execute Java code using @Tool:**

```java
@Component
public class WeatherTools {

    @Tool(description = "Get current weather for a location")
    public WeatherResponse getCurrentWeather(
            @ToolParam(description = "City and state") String location) {
        return new WeatherResponse(location, "72°F", "Sunny");
    }
}
```

AI automatically calls this method when users ask about weather!

### Model Context Protocol (Lab 4)

**Enhanced context in Cursor with Context7:**

- Configure MCP servers in Cursor settings
- Access live library documentation while coding
- Get current Spring AI API details
- Verify code matches latest patterns

## Resources

### Spring AI Documentation

- [Spring AI Reference](https://docs.spring.io/spring-ai/reference/)
- [Spring AI GitHub](https://github.com/spring-projects/spring-ai)
- [Spring AI Examples](https://github.com/spring-projects/spring-ai-examples)

### RAG & Vector Stores

- [RAG Best Practices](https://www.anthropic.com/research/rag)
- [Vector Database Comparison](https://www.pinecone.io/learn/vector-database/)
- [Chunking Strategies](https://www.llamaindex.ai/blog/chunking)

### MCP Resources

- [Model Context Protocol Spec](https://modelcontextprotocol.io/)
- [Cursor MCP Documentation](https://docs.cursor.com/mcp)
- [MCP Examples](https://github.com/modelcontextprotocol/examples)

## Common Issues & Solutions

### API Key Issues

**Problem:** `401 Unauthorized` when calling chat endpoint

**Solution:**
- Verify `OPENAI_API_KEY` environment variable is set
- Check API key has sufficient credits
- Ensure no extra spaces in the key

### Port Already in Use

**Problem:** Port 8080 already in use

**Solution:**
```bash
# Kill process on port 8080
lsof -ti:8080 | xargs kill -9

# Or change port in application.properties
server.port=8081
```

### Vector Store Not Populated

**Problem:** RAG queries return "I don't know"

**Solution:**
- Ensure `CommandLineRunner` executed on startup (check logs)
- Verify documents exist in `src/main/resources/documents/`
- Check document loading logs for errors

## Next Steps

After completing Session 5:

1. **Apply Spring AI to your projects** - Add AI capabilities to existing apps
2. **Experiment with different providers** - Try Anthropic, Ollama, Azure OpenAI
3. **Explore advanced RAG** - Metadata filtering, hybrid search, re-ranking
4. **Build custom tools** - Domain-specific functions for your business
5. **Deploy to production** - Use real vector stores (Chroma, PgVector, Pinecone)
6. **Share knowledge** - Teach your team about Spring AI patterns

## Verification Status

✅ **Project Structure:** Complete and validated
✅ **Dependencies:** Spring Boot 3.5.7 + Spring AI 1.1.0 configured
✅ **ChatController:** Basic implementation present
⏳ **RagController:** Placeholder - to be implemented in Lab 2
⏳ **Function Calling:** To be implemented in Lab 3
⏳ **MCP Configuration:** Optional exploration in Lab 4

---

**Session 5 Status:** Ready for instruction! Spring AI demo app prepared for labs 🚀
