# Cursor Quick Start for IntelliJ IDEA Users

> A practical guide for experienced IntelliJ IDEA users transitioning to Cursor for Java development with AI assistance.

## Table of Contents

1. [First Impressions: What to Expect](#first-impressions-what-to-expect)
2. [The Workspace Concept](#the-workspace-concept)
3. [Multi-Window Support](#multi-window-support)
4. [AI Assistance: Agent vs Chat Modes](#ai-assistance-agent-vs-chat-modes)
5. [Code Navigation for Java Developers](#code-navigation-for-java-developers)
6. [Terminal Integration](#terminal-integration)
7. [Key Differences & Gotchas](#key-differences--gotchas)
8. [Keyboard Shortcuts & Productivity](#keyboard-shortcuts--productivity)
9. [File System Access & Limitations](#file-system-access--limitations)
10. [Quick Reference](#quick-reference)

---

## First Impressions: What to Expect

### What Feels Familiar

If you're coming from IntelliJ IDEA, you'll immediately recognize:

- **VS Code-based interface** - Cursor is built on VS Code, so the basic UI patterns are different from IntelliJ but well-established
- **Command Palette** - Similar to IntelliJ's "Find Action" (`Cmd/Ctrl + Shift + A`), but in Cursor it's `Cmd/Ctrl + Shift + P`
- **Multi-window support** - Just like IntelliJ, you can open multiple project windows simultaneously
- **Integrated terminal** - Similar to IntelliJ's embedded terminal
- **Git integration** - Built-in version control like IntelliJ

### What's Different

- **AI-first design** - The AI is integrated throughout, not a separate plugin
- **Workspace-centric** - Projects are organized as "workspaces" rather than IntelliJ's module structure
- **File-based focus** - Less emphasis on project structure, more on files and folders
- **Extensions ecosystem** - VS Code extensions instead of IntelliJ plugins

### The Big Win for Java Developers

**AI-powered code understanding** that works across your entire codebase without the heavy indexing IntelliJ requires. Cursor's AI can understand Spring Boot patterns, Gradle configurations, and complex Java architectures instantly.

---

## The Workspace Concept

### IntelliJ Project vs Cursor Workspace

**IntelliJ Thinking:**
```
Project (root)
├── Module 1 (service-a)
├── Module 2 (service-b)
└── Module 3 (common-lib)
```

**Cursor Thinking:**
```
Workspace (root folder)
├── service-a/
├── service-b/
└── common-lib/
```

### Key Differences

| Concept | IntelliJ | Cursor |
|---------|----------|--------|
| **Project structure** | `.idea/` folder with modules | `.cursor/` folder (optional) |
| **Multi-module** | Explicit module definitions | Any nested folder structure |
| **Opening projects** | File → Open, select project | File → Open Folder, select root |
| **Build tools** | Detected automatically | Detected via `build.gradle`, `pom.xml`, etc. |

### Best Practice for Java Projects

**For a typical Spring Boot project:**

```
my-spring-project/           ← Open this as workspace
├── .cursor/                 ← Cursor-specific config (optional)
├── src/
├── build.gradle (or pom.xml)
├── gradlew
└── README.md
```

**For multi-module projects:**

```
parent-project/              ← Open this as workspace
├── module-a/
│   ├── src/
│   └── build.gradle
├── module-b/
│   ├── src/
│   └── build.gradle
├── settings.gradle          ← Cursor understands this
└── build.gradle
```

### Creating a New Workspace

1. **File → Open Folder** (or `Cmd/Ctrl + O`)
2. Navigate to your project root
3. Click **Open**
4. Cursor will detect Java/Gradle/Maven automatically

> **💡 Tip:** Unlike IntelliJ, you don't need to "import" a Gradle project. Just open the folder, and Cursor recognizes the build file.

---

## Multi-Window Support

### Good News: It Works Like IntelliJ!

One of Cursor's best features for IntelliJ users: **multiple independent project windows**, just like you're used to.

### Opening Multiple Projects

**Method 1: File Menu**
- File → New Window
- Then File → Open Folder in the new window

**Method 2: Command Palette**
- `Cmd/Ctrl + Shift + P`
- Type "New Window"
- Open different folder in new window

**Method 3: From Terminal** (like IntelliJ's `idea` command)
```bash
# Open multiple projects in separate windows
cursor /path/to/project-a
cursor /path/to/project-b
```

### Managing Multiple Windows

**Works just like IntelliJ:**
- Each window is completely independent
- Separate AI conversation context per window
- Switch between windows with `Cmd + `` (Mac) or `Alt + Tab` (Windows/Linux)
- Close a window without closing others

### Use Case: Microservices Development

Just like in IntelliJ, open each microservice in its own window:

```bash
cursor ~/projects/user-service &
cursor ~/projects/order-service &
cursor ~/projects/inventory-service &
```

Each has independent:
- AI context
- Terminal sessions
- Git state
- File watchers

---

## AI Assistance: Agent vs Chat Modes

This is the most important section - understanding when and how to use Cursor's AI features.

### Two Main AI Interaction Modes

#### 1. **Chat Mode** (Cmd/Ctrl + L)

**Like:** A conversation with a colleague who can see your code  
**Use for:** Questions, explanations, suggestions

**When to use Chat:**
- "Explain this Spring configuration"
- "How does this dependency injection work?"
- "What does this regex pattern match?"
- "Suggest improvements to this method"
- Understanding existing code
- Getting design advice

**Example conversation:**
```
You: Explain the @Transactional annotation in this service class
AI: [Provides detailed explanation of transaction boundaries, rollback behavior, etc.]
You: What happens if an exception is thrown?
AI: [Explains rollback behavior]
```

**Key characteristic:** Chat mode is **read-only by default** - it won't modify your code unless you explicitly ask it to generate something.

#### 2. **Agent Mode** (Cmd/Ctrl + I or Cmd/Ctrl + K)

**Like:** Pair programming where your partner can actually type  
**Use for:** Code generation, modifications, refactoring

**When to use Agent:**
- "Add a new REST endpoint for user management"
- "Refactor this method to use Java streams"
- "Add validation to these entity fields"
- "Create a test class for this service"
- "Convert this class to use constructor injection"

**Example workflow:**
```
You: [Select a controller class] Add a new endpoint for updating user profiles
AI: [Shows proposed changes as diff]
You: [Review, accept or reject]
```

**Key characteristic:** Agent mode **proposes concrete changes** that you can accept, reject, or modify.

### Chat vs Agent: Quick Decision Guide

| Scenario | Use | Why |
|----------|-----|-----|
| Understanding legacy code | **Chat** | Just need explanation |
| Implementing a new feature | **Agent** | Need code generation |
| Code review / getting feedback | **Chat** | Want suggestions, not changes |
| Refactoring | **Agent** | Need actual code modifications |
| Learning a new API | **Chat** | Need guidance and examples |
| Writing test cases | **Agent** | Need generated test code |

### Referencing Code in Your Prompts

Both modes support context awareness:

**Implicit context:**
- **Current file** - Always included
- **Selected code** - Automatically focused on

**Explicit references:**
```
@filename.java - Reference specific file
@src/main/java/com/example/UserController.java - Full path
@build.gradle - Reference build configuration
```

**Example:**
```
Chat: "How does @UserController.java integrate with @UserService.java?"
Agent: "Add error handling to the saveUser method in @UserController.java"
```

### Pro Tips from IntelliJ Users

1. **Use Chat first** - Understand before modifying
2. **Agent for repetitive tasks** - "Add getters/setters", "Generate builder pattern"
3. **Combine both** - Chat to design, Agent to implement
4. **Review Agent changes** - Just like reviewing a pull request

---

## Code Navigation for Java Developers

### What IntelliJ Users Expect vs What Cursor Provides

| Feature | IntelliJ Shortcut | Cursor Equivalent | Notes |
|---------|------------------|-------------------|-------|
| **Go to Class** | `Cmd/Ctrl + N` | `Cmd/Ctrl + P` then type class name | Works great with Java |
| **Go to File** | `Cmd/Ctrl + Shift + N` | `Cmd/Ctrl + P` | Same command, universal |
| **Go to Symbol** | `Cmd/Ctrl + Alt + Shift + N` | `Cmd/Ctrl + Shift + O` | Methods, fields, etc. |
| **Go to Declaration** | `Cmd/Ctrl + B` | `F12` or `Cmd + Click` | Jump to definition |
| **Go to Implementation** | `Cmd/Ctrl + Alt + B` | `Cmd/Ctrl + F12` | Show implementations |
| **Find Usages** | `Alt + F7` | `Shift + F12` | Where is this used? |
| **File Structure** | `Cmd/Ctrl + F12` | `Cmd/Ctrl + Shift + O` | Outline view |
| **Recent Files** | `Cmd/Ctrl + E` | `Cmd/Ctrl + P` then `@` | Quick switcher |
| **Go to Line** | `Cmd/Ctrl + G` | `Ctrl + G` | Jump to line number |

### AI-Powered Navigation (The Game Changer)

**Instead of memorizing shortcuts, just ask:**

```
Chat: "Where is the UserService interface implemented?"
Chat: "Show me all REST controllers in this project"
Chat: "Find where the @Transactional annotation is used"
Chat: "Which classes extend BaseEntity?"
```

**The AI can find patterns that traditional navigation can't:**
```
Chat: "Show me all methods that call the database directly without using a repository"
Chat: "Find all controllers that don't have proper error handling"
Chat: "Where are we creating ObjectMapper instances manually?"
```

### Quick File Finder (`Cmd/Ctrl + P`)

This is your new best friend - it replaces multiple IntelliJ shortcuts:

**Basic usage:**
```
Cmd/Ctrl + P
Type: UserCont
Result: UserController.java opens
```

**Advanced patterns:**
```
@symbol           → Search for methods/fields (like Cmd+Alt+Shift+N)
#text             → Search in current file
:45               → Go to line 45
UserService.java:30  → Open file at line 30
```

### Project-Wide Search

**IntelliJ:** `Cmd/Ctrl + Shift + F` (Find in Path)  
**Cursor:** `Cmd/Ctrl + Shift + F` (Same!)

The search interface is similar, with regex support and file filtering.

### Navigating Java Package Structure

Cursor's file explorer works well for Java packages:

```
src/main/java/com/example/
├── controller/
│   ├── UserController.java     ← Right-click → "Reveal in File Explorer"
│   └── OrderController.java
├── service/
│   ├── UserService.java
│   └── OrderService.java        ← Cmd+Click to open
└── repository/
    └── UserRepository.java
```

**Tips:**
- Collapse/expand folders just like IntelliJ's project view
- Use `Cmd/Ctrl + Shift + E` to reveal current file in explorer
- Breadcrumbs at top show full package path

---

## Terminal Integration

### Good News: Similar to IntelliJ

Cursor's integrated terminal works almost identically to IntelliJ's embedded terminal.

### Opening the Terminal

**IntelliJ:** `Alt/Option + F12`  
**Cursor:** ``Ctrl + ` `` (backtick) or View → Terminal

### Multiple Terminal Sessions

Just like IntelliJ, you can have multiple terminals:

1. Click the **+** icon in terminal panel
2. Or: `Cmd/Ctrl + Shift + `` (backtick)
3. Switch between terminals with dropdown

**Common setup for Spring Boot development:**
```
Terminal 1: ./gradlew bootRun              # Running app
Terminal 2: ./gradlew test --continuous    # Test watcher
Terminal 3: git status / git commands      # Version control
```

### Running Gradle/Maven Tasks

**Unlike IntelliJ, no built-in Gradle tool window**, but you have options:

#### Option 1: Command Line (Recommended for Cursor)
```bash
./gradlew build
./gradlew test
./gradlew bootRun
./gradlew clean build
```

#### Option 2: Install Gradle Extension
- Install "Gradle for Java" extension
- Get a Gradle task runner sidebar (similar to IntelliJ)

#### Option 3: Use AI to Run Tasks
```
Agent: "Run the Spring Boot application in the terminal"
Agent: "Execute the tests for UserService"
Agent: "Build the project and show any compilation errors"
```

### Running Tests

**IntelliJ users are used to:** Right-click → Run Test

**In Cursor:**

**Method 1: Extension (Testing view)**
1. Install "Test Runner for Java" extension
2. Get test explorer in sidebar
3. Click to run individual tests

**Method 2: Terminal**
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests UserServiceTest

# Run specific test method
./gradlew test --tests UserServiceTest.shouldCreateUser

# Run tests in continuous mode
./gradlew test --continuous
```

**Method 3: Ask AI**
```
Agent: "Run the tests for UserService and show me the results"
Agent: "Run all repository tests and tell me if anything failed"
```

### Terminal Tips for Java Developers

**Set up shell aliases for common tasks:**
```bash
# Add to ~/.zshrc or ~/.bashrc
alias gw='./gradlew'
alias gwb='./gradlew build'
alias gwt='./gradlew test'
alias gwr='./gradlew bootRun'
alias gwc='./gradlew clean'

# Then use:
gwb          # instead of ./gradlew build
gwt          # instead of ./gradlew test
```

**Use task history:**
- `Cmd/Ctrl + R` in terminal to search command history
- Up/Down arrows to cycle through previous commands

---

## Key Differences & Gotchas

Things that might trip up IntelliJ users:

### 1. No "Sync Gradle" Button

**IntelliJ:** Click refresh icon to sync Gradle changes  
**Cursor:** Changes are picked up automatically

**If you need to force reload:**
```bash
# In terminal
./gradlew clean build

# Or restart Java Language Server:
Cmd/Ctrl + Shift + P → "Java: Clean Java Language Server Workspace"
```

### 2. Import Optimization

**IntelliJ:** `Cmd/Ctrl + Alt/Option + O` to optimize imports  
**Cursor:** Automatic via "Organize Imports" command

**To manually trigger:**
- Right-click in file → "Organize Imports"
- Or: `Shift + Alt + O`
- Or: `Cmd/Ctrl + Shift + P` → "Organize Imports"

### 3. Code Formatting

**IntelliJ:** `Cmd/Ctrl + Alt/Option + L` (reformat code)  
**Cursor:** `Shift + Alt + F` (format document)

**To use Google Java Style or other formatters:**
1. Install "Language Support for Java" extension
2. Configure in settings: `.vscode/settings.json`
```json
{
  "java.format.settings.url": "https://raw.githubusercontent.com/google/styleguide/gh-pages/eclipse-java-google-style.xml"
}
```

### 4. Auto-Import

**IntelliJ:** Automatic import suggestions  
**Cursor:** Works similarly with Java extensions installed

**To enable:**
1. Install "Language Support for Java" extension
2. Settings → Java → "Autobuild: Enabled"
3. Settings → Editor: "Auto Import" (if available)

**Quick fix:** `Cmd + .` on unresolved class → Import class

### 5. No "Rebuild Project"

**IntelliJ:** Build → Rebuild Project  
**Cursor:** Use Gradle directly

```bash
./gradlew clean build
```

### 6. Running Applications

**IntelliJ:** Right-click class with `main` → Run  
**Cursor:** 

**Method 1: CodeLens (appears above `main` method)**
```java
public class Application {
    // "Run | Debug" appears here ↓
    public static void main(String[] args) {
        // ...
    }
}
```
Click "Run" or "Debug"

**Method 2: Terminal**
```bash
./gradlew bootRun
# or
java -jar build/libs/myapp.jar
```

**Method 3: AI**
```
Agent: "Run the Spring Boot application"
```

### 7. Debugger

**Good news:** The debugger works similarly to IntelliJ

- Click line number gutter to set breakpoints
- Press `F5` (or Run → Start Debugging)
- Step through with `F10` (step over), `F11` (step into)
- Variables panel shows current state
- Watch expressions available

**Gotcha:** May need to configure launch configuration for complex projects

`.vscode/launch.json`:
```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Debug (Attach)",
      "request": "attach",
      "hostName": "localhost",
      "port": 5005
    }
  ]
}
```

### 8. Maven/Gradle Tool Window

**IntelliJ:** Gradle/Maven tool window on right side  
**Cursor:** Install extensions for GUI:
- "Gradle for Java"
- "Maven for Java"

**Or:** Embrace the terminal approach (many developers prefer this)

### 9. "Mark Directory As" (Sources/Resources/Test)

**IntelliJ:** Right-click folder → Mark Directory As → Sources Root  
**Cursor:** Detected automatically from `build.gradle` or `pom.xml`

**If you need manual configuration:**
- Usually not needed for standard Maven/Gradle layouts
- For non-standard structures, configure in `settings.json`

### 10. Spring Boot Support

**IntelliJ Ultimate:** Rich Spring Boot support built-in  
**Cursor:** Install "Spring Boot Extension Pack"

**Features you'll get:**
- Spring Boot properties autocompletion
- Application.yml validation
- Bean navigation
- Request mapping navigation

### 11. File Watchers

**IntelliJ:** File Watchers for Sass, Less, etc.  
**Cursor:** Configure tasks in `.vscode/tasks.json`

**For most Java projects:** Not needed, Gradle handles everything

### 12. Live Templates

**IntelliJ:** `sout` + Tab → `System.out.println()`  
**Cursor:** User snippets

**To add Java snippets:**
1. `Cmd/Ctrl + Shift + P` → "Snippets: Configure User Snippets"
2. Select "java.json"
3. Add snippets:
```json
{
  "System.out.println": {
    "prefix": "sout",
    "body": "System.out.println($1);",
    "description": "Print to console"
  },
  "main method": {
    "prefix": "main",
    "body": [
      "public static void main(String[] args) {",
      "\t$0",
      "}"
    ]
  }
}
```

---

## Keyboard Shortcuts & Productivity

### Essential Shortcuts for IntelliJ Users

| Action | IntelliJ | Cursor | Notes |
|--------|----------|--------|-------|
| **Command Palette** | Cmd/Ctrl+Shift+A | Cmd/Ctrl+Shift+P | Your most important shortcut |
| **Quick Open File** | Cmd/Ctrl+Shift+N | Cmd/Ctrl+P | Universal file finder |
| **Go to Symbol** | Cmd/Ctrl+Alt+Shift+N | Cmd/Ctrl+Shift+O | Methods, fields, etc. |
| **Find in Files** | Cmd/Ctrl+Shift+F | Cmd/Ctrl+Shift+F | Same! |
| **Replace in Files** | Cmd/Ctrl+Shift+R | Cmd/Ctrl+Shift+H | Different |
| **Terminal** | Alt/Option+F12 | Ctrl+` | Backtick key |
| **Rename** | Shift+F6 | F2 | Refactor rename |
| **Format Code** | Cmd/Ctrl+Alt+L | Shift+Alt+F | Different |
| **Organize Imports** | Cmd/Ctrl+Alt+O | Shift+Alt+O | Similar |
| **Comment Line** | Cmd/Ctrl+/ | Cmd/Ctrl+/ | Same! |
| **Duplicate Line** | Cmd/Ctrl+D | Shift+Alt+Down | Different |
| **Delete Line** | Cmd/Ctrl+Y | Cmd/Ctrl+Shift+K | Different |
| **Move Line Up/Down** | Shift+Alt+Up/Down | Alt+Up/Down | Different |
| **Select Next Occurrence** | Alt+J | Cmd/Ctrl+D | Multi-cursor magic |

### AI-Specific Shortcuts (New!)

| Action | Shortcut | Description |
|--------|----------|-------------|
| **Open Chat** | Cmd/Ctrl+L | Ask questions, get explanations |
| **Open Agent** | Cmd/Ctrl+I or Cmd/Ctrl+K | Generate/modify code |
| **Accept AI Suggestion** | Tab | Accept inline suggestion |
| **Reject AI Suggestion** | Esc | Dismiss suggestion |

### Customizing Shortcuts

If you want IntelliJ-style shortcuts:

1. `Cmd/Ctrl + K`, then `Cmd/Ctrl + S` (Keyboard Shortcuts)
2. Or: File → Preferences → Keyboard Shortcuts
3. Search for command, click, press new shortcut

**Popular customizations from IntelliJ users:**
```
Format Document: Cmd+Alt+L (like IntelliJ)
Terminal: Alt+F12 (like IntelliJ)
Rename Symbol: Shift+F6 (like IntelliJ)
```

### Multi-Cursor Editing (Power Feature!)

This is where Cursor/VS Code shines vs IntelliJ:

**Select multiple occurrences:**
1. Place cursor on variable name
2. Press `Cmd/Ctrl+D` repeatedly
3. Each press selects next occurrence
4. Type to edit all simultaneously

**Example:**
```java
String userName = "John";
System.out.println(userName);
process(userName);
validate(userName);

// Place cursor on first "userName", press Cmd+D three times
// Now edit all four occurrences at once!
```

**Column selection:**
- `Alt+Shift+Drag` to select columns
- Great for editing multiple lines identically

---

## File System Access & Limitations

### Important: Cursor's Workspace Boundary

**IntelliJ:** Can access any file on your system  
**Cursor Agent:** Restricted to workspace folder (sandboxed for security)

### What This Means

**✅ Agent can access:**
```
/Users/you/projects/my-app/        ← Workspace root
├── src/                           ✅ Yes
├── build.gradle                   ✅ Yes
├── README.md                      ✅ Yes
└── .cursor/                       ✅ Yes
```

**❌ Agent CANNOT access:**
```
/Users/you/.gradle/                ❌ No (outside workspace)
/Users/you/.m2/                    ❌ No (outside workspace)
/Users/you/Documents/notes.txt     ❌ No (outside workspace)
/tmp/something.log                 ❌ No (outside workspace)
```

### Practical Implications

**Scenario 1: Multi-module project with shared config**

❌ **Won't work:**
```
/Users/you/projects/
├── shared-config/           ← Referenced from projects
├── service-a/              ← Workspace
└── service-b/              ← Different workspace
```

✅ **Better structure:**
```
/Users/you/projects/parent/  ← Open THIS as workspace
├── shared-config/
├── service-a/
└── service-b/
```

**Scenario 2: Referencing external JAR**

❌ Agent can't read: `/Users/you/Downloads/custom-lib.jar`  
✅ Copy to workspace: `lib/custom-lib.jar`

**Scenario 3: Accessing local Maven repo**

❌ Agent can't read: `~/.m2/repository/...`  
✅ Dependencies downloaded automatically via Gradle/Maven

### Workarounds

**If you need to reference external files:**

1. **Symlinks** (works in some cases)
```bash
ln -s /path/to/external/config config/external
```

2. **Copy to workspace** (safest)
```bash
cp /path/to/external/file ./resources/
```

3. **Use Chat mode** (not Agent)
   - Chat can sometimes provide information about external files
   - But better to keep everything in workspace

### Comparing to Claude Code

From your experience:

| Feature | Claude Code | Cursor Agent |
|---------|-------------|--------------|
| Filesystem access | Full (can access any path) | Workspace-bound only |
| Multiple workspaces | Share context | Independent contexts |
| External files | ✅ Can read/write | ❌ Cannot access |
| Security | Requires user trust | Sandboxed by design |

### Best Practice

**Design your workspace to be self-contained:**
```
my-project/
├── .cursor/
├── docs/              ← Documentation in workspace
├── config/            ← Config files in workspace
├── scripts/           ← Build scripts in workspace
├── src/
├── build.gradle
└── README.md
```

**Everything Agent needs should be inside the workspace folder.**

---

## Quick Reference

### First Day Checklist

**Getting Started:**
- [ ] Install Cursor from [cursor.sh](https://cursor.sh)
- [ ] Open your first Java project: File → Open Folder
- [ ] Install recommended extensions:
  - [ ] Language Support for Java (Red Hat)
  - [ ] Debugger for Java (Microsoft)
  - [ ] Gradle for Java (Microsoft)
  - [ ] Spring Boot Extension Pack

**Test Drive:**
- [ ] Open Chat (`Cmd/Ctrl+L`) and ask "Explain this controller"
- [ ] Open Agent (`Cmd/Ctrl+I`) and ask "Add a new method to this class"
- [ ] Open terminal (``Ctrl+` ``) and run `./gradlew build`
- [ ] Try multi-cursor: Select word, `Cmd/Ctrl+D` repeatedly
- [ ] Open second project window: File → New Window

### Daily Workflow

**Starting your day:**
```
1. Cursor opens to your workspace
2. Cmd/Ctrl+` to open terminal
3. git pull to get latest changes
4. ./gradlew bootRun to start app (or use AI: "Start the application")
5. Cmd/Ctrl+L to open Chat for questions
```

**Common tasks:**
```
Navigate:       Cmd/Ctrl+P (Quick Open)
Search:         Cmd/Ctrl+Shift+F (Find in Files)
Chat:           Cmd/Ctrl+L (Ask AI questions)
Agent:          Cmd/Ctrl+I (Generate code)
Terminal:       Ctrl+` (Open terminal)
Run:            Click "Run" CodeLens above main()
Debug:          F5 (Start debugging)
Format:         Shift+Alt+F
```

### When Things Go Wrong

**Java Language Server not working:**
```
Cmd/Ctrl+Shift+P → "Java: Clean Java Language Server Workspace"
```

**Gradle not recognized:**
```bash
./gradlew tasks --all    # Verify Gradle works
```

**AI seems confused:**
```
Start a new Chat (Cmd/Ctrl+L, then click "New Chat")
OR
Restart window: Cmd/Ctrl+Shift+P → "Developer: Reload Window"
```

**Imports not resolving:**
```
1. Make sure "Language Support for Java" extension is installed
2. Check build.gradle dependencies
3. Try: Cmd/Ctrl+Shift+P → "Java: Clean Java Language Server Workspace"
```

**Project structure not recognized:**
```
1. Ensure you opened the root folder (where build.gradle or pom.xml lives)
2. Close and reopen: File → Open Folder → Select root
```

### Getting Help

**In Cursor:**
- `Cmd/Ctrl+L` → Ask AI: "How do I [task] in Cursor?"
- Help → Documentation
- Help → Show All Commands (`Cmd/Ctrl+Shift+P`)

**Online Resources:**
- Cursor Documentation: [docs.cursor.com](https://docs.cursor.com)
- Cursor Forum: [forum.cursor.sh](https://forum.cursor.sh)
- VS Code Java Documentation: [code.visualstudio.com/docs/java](https://code.visualstudio.com/docs/java)

---

## Next Steps

**Once you're comfortable:**

1. **Explore the `.cursor/` folder** - Custom rules, commands, and workspace-specific AI context
2. **Set up keyboard shortcuts** - Customize to match your IntelliJ muscle memory
3. **Install useful extensions** - Explore the Extension marketplace
4. **Learn advanced AI features** - Context files, custom commands, MCP tools
5. **Try the Spring PetClinic project** - Great for practicing with a real codebase

**Remember:** The AI is your pair programmer. When in doubt, just ask! `Cmd/Ctrl+L` and type your question.

---

## Feedback & Improvements

This guide is a living document. As you discover tips, tricks, and gotchas specific to Java development in Cursor, please share them!

---

**Version:** 1.0  
**Last Updated:** 2025-01-11  
**Target Audience:** Experienced IntelliJ IDEA users learning Cursor

