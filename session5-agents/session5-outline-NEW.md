# Session 5: Building AI-Powered Java Apps with Spring AI

**Duration:** 3 hours
**Audience:** ~100 experienced developers (Java/Android background from Sessions 1-4)
**Format:** Instructor-led with hands-on exercises
**Prerequisite:** Completion of Sessions 1-4 or equivalent Cursor experience

## Session Objectives

By the end of this session, participants will be able to:
- Build Java applications with Spring AI framework
- Implement chat interfaces using ChatClient API
- Create Retrieval Augmented Generation (RAG) pipelines
- Implement function calling with Spring AI tools
- Understand Model Context Protocol (MCP) for enhanced AI capabilities
- Apply AI patterns to modernize legacy Java applications

## Project Approach

### Project: Spring AI Demo Application (Code-Along)
**Purpose:** Build a complete Spring AI application with chat, RAG, and function calling
**Duration:** ~150 minutes (Parts 1-5)
**Approach:** Instructor-led, students follow along
**Deliverable:** Working Spring AI application with multiple AI capabilities

**Key Technologies:**
- Spring Boot 3.5
- Spring AI 1.1.0
- Java 21
- OpenAI/Anthropic API integration
- Vector stores for RAG
- Function calling with Spring AI tools

---

## Detailed Timeline

### Part 1: Introduction to Spring AI (20 minutes)

#### Welcome & Session 5 Overview (5 min)
- Recap Sessions 1-4: Development AI tools → Testing AI → Building AI Apps
- Session 5 focus: **Creating AI-powered Java applications**
- The Spring AI framework: Bringing AI capabilities to Spring Boot
- Today's deliverables: Complete Spring AI application

#### What is Spring AI? (15 min)
- **Spring AI Overview:**
  - Official Spring project for AI integration
  - Portable abstraction over AI providers (OpenAI, Anthropic, etc.)
  - Spring Boot auto-configuration
  - Familiar Spring programming model

- **Core Components:**
  - **ChatClient:** Fluent API for LLM interactions
  - **Embeddings:** Vector representations of text
  - **Vector Stores:** Storage for document embeddings
  - **Function Calling:** Tools that AI can invoke
  - **Document Readers:** PDF, Word, text file processing

**Checkpoint:** Understanding of Spring AI ecosystem

---

### Part 2: Chat Client & Templating (30 minutes)

#### ChatClient API (15 min)

**Demo: Basic Chat Interaction**
```
Agent Mode: "Create a ChatController with a GET endpoint /chat.
Inject ChatClient.Builder. Use the ChatClient to send the user's
message to the LLM and return the response."
```

**Review ChatClient Features:**
- Fluent API for building requests
- System and user message configuration
- Response parsing and handling
- Error management
- Streaming responses (optional)

#### Prompt Templates (15 min)

**Demo: Template-Based Prompts**
```
Agent Mode: "Refactor the controller to use a PromptTemplate.
Load the template from 'classpath:/prompts/joke.st'.
The template should accept a 'topic' variable."
```

**Review Template Patterns:**
- StringTemplate format (.st files)
- Variable substitution
- Template organization
- Reusable prompt patterns

**Checkpoint:** Working chat interface with templates

---

### Part 3: Retrieval Augmented Generation (RAG) (45 minutes)

#### Understanding RAG (10 min)

**RAG Concepts:**
- Why RAG? - Grounding AI in your data
- Document chunking and embeddings
- Vector similarity search
- Context injection into prompts
- Preventing hallucinations

#### Document Ingestion (20 min)

**Demo: Loading Documents**
```
Extended Thinking: "Create a CommandLineRunner that reads 'policy.txt'
from the classpath. Use TokenTextSplitter to split it into chunks.
Load the chunks into the SimpleVectorStore. Log when ingestion is complete."
```

**Review Ingestion Pipeline:**
- Document loaders (PDF, text, etc.)
- Text splitting strategies
- Embedding generation
- Vector store population
- Production considerations

#### RAG Query Implementation (15 min)

**Demo: RAG Controller**
```
Agent Mode: "Create a RagController. When a query comes in:
1. Search the VectorStore for similar documents.
2. Inject the documents into the system prompt.
3. Ask the LLM to answer based ONLY on the provided context."
```

**Review RAG Implementation:**
- Similarity search configuration
- Context window management
- Prompt engineering for RAG
- Answer verification
- Source citation

**Checkpoint:** Working RAG system

---

### BREAK (10 minutes)

---

### Part 4: Tools & Function Calling (45 minutes)

#### Function Calling Concepts (10 min)

**What is Function Calling?**
- Giving AI the ability to execute code
- Structured output from LLM
- Tool registration and discovery
- Parameter extraction and validation
- Response formatting

#### Simple Tool Implementation (20 min)

**Demo: Weather Tool**
```
Agent Mode: "Create a Java Record 'WeatherRequest(String location, String unit)'.
Create a Java Record 'WeatherResponse(String temp, String desc)'.
Create a Function<WeatherRequest, WeatherResponse> bean named 'weatherFunction'.
Annotate it with @Description('Get weather for a location').
Implement it to return mock data."
```

**Review Tool Implementation:**
- Function bean registration
- Description annotations
- Parameter schemas
- Return value handling
- Error management

#### Advanced Tool: Database Access (15 min)

**Demo: Database Tool**
```
Extended Thinking: "Create a tool that looks up a user by email in a
UserRepository. Expose this tool to the AI. Test by asking:
'Who is the user with email bob@example.com?'"
```

**Review Database Integration:**
- Repository integration
- Transaction management
- Security considerations
- Error handling
- Result formatting

**Checkpoint:** Working function calling system

---

### Part 5: Model Context Protocol (MCP) Exploration (20 minutes)

#### What is MCP? (10 min)

**MCP Overview:**
- Protocol for connecting AI to external data sources
- Cursor's MCP support
- Standard interface for tool integration
- Context providers and resources
- Real-time data access

#### Cursor MCP Configuration (10 min)

**Demo: MCP Setup**
- Cursor Settings → Features → MCP
- Adding MCP servers
- Testing MCP connections
- Observing enhanced context

**MCP Use Cases:**
- Database schema awareness
- API documentation access
- Codebase navigation
- Real-time data queries
- Custom domain integrations

**Checkpoint:** Understanding of MCP capabilities

---

### Part 6: Legacy Modernization with AI (15 minutes)

#### AI-Assisted Refactoring (15 min)

**Demo: Legacy Analysis**
```
Extended Thinking: "Analyze the legacy 'OrderService' (from Session 4).
Create a plan to refactor it using Spring AI Agents to identify code smells."
```

**Review Modernization Strategies:**
- AI-powered code analysis
- Pattern detection
- Refactoring recommendations
- Testing strategy
- Incremental modernization

**Checkpoint:** Legacy modernization understanding

---

### Wrap-Up & Course Completion (15 minutes)

#### Key Takeaways (7 min)

**Spring AI Decision Tree:**
```
Need chat interface? → Use ChatClient with templates
Need to chat with your data? → Implement RAG
Need AI to execute code? → Use function calling
Need enhanced context? → Configure MCP
Need to modernize legacy code? → Apply AI analysis
```

**What We Accomplished:**
- ✅ Spring AI application setup
- ✅ ChatClient with prompt templates
- ✅ RAG pipeline for document Q&A
- ✅ Function calling with Spring AI tools
- ✅ MCP exploration for enhanced context
- ✅ Legacy code modernization strategies

#### Complete Training Journey (5 min)

**The Five-Session Arc:**
- **Session 1:** Cursor fundamentals (Chat, Agent, Composer)
- **Session 2:** Mobile development with AI
- **Session 3:** Agentic coding patterns
- **Session 4:** AI-assisted testing
- **Session 5:** Building AI-powered Java apps

**Next Steps:**
- Apply Spring AI to your projects
- Experiment with different AI providers
- Explore advanced RAG patterns
- Build custom tools for your domain
- Share knowledge with your team

#### Q&A (3 min)
- Spring AI questions
- RAG implementation challenges
- MCP integration topics
- Future AI development

---

## Materials Provided

### Pre-Session
- Session 1-4 recap document
- Spring AI introduction guide
- API key setup instructions

### During Session
- This session outline
- Slidev presentation
- spring-ai-demo project
- Sample documents for RAG
- Prompt template examples

### Post-Session
- Complete labs.md with all exercises
- Spring AI reference guide
- RAG implementation patterns
- Function calling examples
- MCP configuration guides

---

## Success Metrics

Students should leave able to:
- [ ] Create Spring Boot applications with Spring AI
- [ ] Build chat interfaces using ChatClient API
- [ ] Implement RAG pipelines for document Q&A
- [ ] Create and register custom functions for AI
- [ ] Configure MCP for enhanced context
- [ ] Apply AI patterns to legacy code modernization

---

## Instructor Notes

### Timing Buffers
- Break provides 10 min catch-up time
- Can compress MCP section if needed
- Core Spring AI concepts must be completed
- Legacy modernization can be homework if short on time

### Common Issues & Solutions
- **API key problems:** Have backup keys ready, test before session
- **RAG complexity:** Start simple, emphasize concepts over implementation
- **Function calling confusion:** Use simple examples first (weather, calculator)
- **MCP availability:** MCP is optional, focus on concepts if unavailable

### Adaptation Points
- If ahead: Add more advanced RAG patterns, explore streaming responses
- If behind: Simplify examples, focus on ChatClient and basic RAG
- If questions: Use Chat mode to explore answers together
- If students struggle: More demos, less exercises

### Demo Tips
- **Always test with API keys** before the session
- **Show real responses** from the LLM, not mock data
- **Explain the flow** - user → Spring AI → LLM → response
- **Highlight Spring patterns** - familiar dependency injection, auto-config
- **Use realistic examples** - avoid toy problems
- **Show errors and recovery** - API failures happen
- **Emphasize production readiness** - error handling, timeouts, rate limits

---

## Project: Spring AI Demo Application

### Application Structure
```
spring-ai-demo/
├── src/main/java/com/example/ai/
│   ├── SpringAiDemoApplication.java
│   ├── ChatController.java          # Basic chat with templates
│   ├── RagController.java           # RAG implementation
│   ├── WeatherFunction.java         # Function calling example
│   └── config/
│       └── VectorStoreConfig.java   # Vector store setup
├── src/main/resources/
│   ├── application.properties       # API keys, config
│   ├── prompts/
│   │   └── joke.st                  # Prompt templates
│   └── documents/
│       └── policy.txt               # Sample document for RAG
└── pom.xml
```

### Dependencies
- Spring Boot 3.5
- Spring AI 1.1.0 (OpenAI starter)
- Spring AI PDF Document Reader
- Spring AI Simple Vector Store

---

## Lab Preview (labs.md)

### Part A: Code-Along (In-Class)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 0 | Spring AI Setup | 15 min | Project setup, API configuration |
| 1 | Chat Client & Templating | 20 min | ChatClient, prompt templates |
| 2 | Implementing RAG | 40 min | Document ingestion, vector search |
| 3 | Tools & Function Calling | 40 min | Function registration, tool execution |
| 4 | MCP Exploration | 20 min | MCP configuration, enhanced context |

**Total In-Class Time:** ~135 minutes (2h 15m) + breaks

### Part B: Exploration (Homework)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 5 | Legacy Modernization with Agents | 45 min | AI-assisted refactoring, code analysis |

**Total Homework Time:** ~45 minutes

---

## Resources and Links

### Spring AI Resources
- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Spring AI GitHub](https://github.com/spring-projects/spring-ai)
- [Spring AI Examples](https://github.com/spring-projects/spring-ai-examples)

### RAG Resources
- [RAG Best Practices](https://www.anthropic.com/research/rag)
- [Vector Database Comparison](https://www.pinecone.io/learn/vector-database/)
- [Chunking Strategies](https://www.llamaindex.ai/blog/chunking)

### MCP Resources
- [Model Context Protocol Specification](https://modelcontextprotocol.io/)
- [Cursor MCP Documentation](https://docs.cursor.com/mcp)
- [MCP Examples](https://github.com/modelcontextprotocol/examples)

---

**Session 5 outline complete and aligned with Spring AI focus! 🚀**
