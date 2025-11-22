# Session 5: Building AI-Powered Java Apps with Spring AI - Lab Exercises

**Duration:** 3 hours  
**Audience:** ~100 experienced developers  
**Prerequisites:** Java 21, Spring Boot 3.5, OpenAI/Anthropic API Key

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Spring AI Setup](#lab-0-spring-ai-setup)
2. [Lab 1: Chat Client & Templating](#lab-1-chat-client)
3. [Lab 2: Implementing RAG](#lab-2-rag)
4. [Lab 3: Tools & Function Calling](#lab-3-tools)
5. [Lab 4: MCP Exploration](#lab-4-mcp)

### Part B: Exploration Exercises (Homework)
6. [Lab 5: Legacy Modernization with Agents](#lab-5-legacy-modernization)

---

## Part A: Code-Along Exercises (In-Class)

## Lab 0: Spring AI Setup

**Goal:** Scaffold a Spring AI project using Cursor  
**Time:** 15 minutes

1. **Create Project**
   **Composer Mode:**
   Type:
   ```
      Create a new Spring Boot 3.5 project named 'spring-ai-demo'.
      Add dependencies: Spring Web, Spring AI OpenAI, Spring AI PDF Document Reader, 
      Spring AI Simple Vector Store.
      Use Java 21.
   ```

2. **Configure API Keys**
   - Open `application.properties` (or `.yml`).
   - Add `spring.ai.openai.api-key=${OPENAI_API_KEY}`.
   - Ensure the environment variable is set in your terminal.

3. **Verify Setup**
   - Run the application. Ensure it starts without errors.

---

## Lab 1: Chat Client & Templating

**Goal:** Interact with the LLM using the fluent ChatClient API  
**Time:** 20 minutes

1. **Create Chat Controller**
   **Agent Mode:**
   Type:
   ```
      Create a ChatController with a GET endpoint /chat.
      Inject ChatClient.Builder.
      Use the ChatClient to send the user's message to the LLM and return the response.
   ```

2. **Use Prompt Templates**
   **Agent Mode:**
   Type:
   ```
      Refactor the controller to use a PromptTemplate.
      Load the template from 'classpath:/prompts/joke.st'.
      The template should accept a 'topic' variable.
   ```

3. **Test It**
   - `curl localhost:8080/chat?message=Java`

---

## Lab 2: Implementing RAG

**Goal:** Build a Retrieval Augmented Generation pipeline  
**Time:** 40 minutes

1. **Ingest Documents**
   **Extended Thinking:**
   Type:
   ```
      Create a CommandLineRunner that reads 'policy.txt' from the classpath.
      Use TokenTextSplitter to split it into chunks.
      Load the chunks into the SimpleVectorStore.
      Log when ingestion is complete.
   ```

2. **Query with RAG**
   **Agent Mode:**
   Type:
   ```
      Create a RagController.
      When a query comes in:
      1. Search the VectorStore for similar documents.
      2. Inject the documents into the system prompt.
      3. Ask the LLM to answer based ONLY on the provided context.
      Use the QuestionAnswerAdvisor if available.
   ```

3. **Test RAG**
   - Ask a question that is answered in `policy.txt` but not generally known.

---

## Lab 3: Tools & Function Calling

**Goal:** Give the AI the ability to execute Java code  
**Time:** 40 minutes

1. **Define a Tool**
   **Agent Mode:**
   Type:
   ```
      Create a Java Record 'WeatherRequest(String location, String unit)'.
      Create a Java Record 'WeatherResponse(String temp, String desc)'.
      Create a Function<WeatherRequest, WeatherResponse> bean named 'weatherFunction'.
      Annotate it with @Description("Get weather for a location").
      Implement it to return mock data.
   ```

2. **Register Tool with ChatClient**
   **Agent Mode:**
   Type:
   ```
      Update the ChatController.
      Configure the ChatClient to use the 'weatherFunction'.
      Ask the AI: "What's the weather in Boston?"
      Verify that the AI calls your function and describes the result.
   ```

3. **Database Tool (Advanced)**
   **Extended Thinking:**
   Type:
   ```
      Create a tool that looks up a user by email in a UserRepository.
      Expose this tool to the AI.
      Ask: "Who is the user with email 'bob@example.com'?"
   ```

---

## Lab 4: MCP Exploration

**Goal:** Understand Model Context Protocol  
**Time:** 20 minutes

1. **Cursor MCP**
   - Go to Cursor Settings -> Features -> MCP.
   - Add a local MCP server (e.g., a simple SQLite MCP server if available, or just discuss the concept).
   - Observe how Cursor can now "see" external resources.

---

## Part B: Exploration Exercises (Homework)

### Lab 5: Legacy Modernization with Agents

**Goal:** Use your new Agent skills to help modernize the legacy app.

1. **Agentic Refactoring**
   **Extended Thinking:**
   Type:
   ```
      Analyze the legacy 'OrderService' (from Session 4).
      Create a plan to refactor it using Spring AI Agents to identify code smells.
   ```

### Next Steps
1. **Apply agent patterns to your current projects**
2. **Experiment with custom MCP integrations**
3. **Explore advanced agent collaboration patterns**
4. **Implement agent monitoring and management**
5. **Plan for future AI development evolution**

### Course Completion
**Congratulations!** You've completed the complete Cursor training series:
- **Session 1:** Chat, Agent, Composer modes
- **Session 2:** Mobile development with AI
- **Session 3:** Agentic coding principles
- **Session 4:** AI-assisted testing and quality
- **Session 5:** Advanced agents and MCP

You're now equipped with comprehensive AI-assisted development skills!

---

**Session 5 labs complete! Ready to build the future of AI development! 🚀**
