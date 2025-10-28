# Cursor Training for Java Developers

**A comprehensive 5-session training program for experienced Java developers transitioning to AI-assisted development with Cursor**

---

## 📚 Overview

This training program is designed for approximately 100 experienced Java developers who are:
- Primarily IntelliJ IDEA users (transitioning to Cursor)
- Familiar with AI concepts but new to AI-enabled IDEs
- Working with Spring Boot, Gradle/Maven, and modern Java (17+)
- Looking to boost productivity with AI-assisted development

**Instructor:** Ken Kousen  
**Format:** 5 sessions × 3 hours each  
**Materials:** Slidev presentations + Markdown labs + Code projects

---

## 🎯 Session Structure

### Session 1: Using Cursor for Java Development ✅
**Duration:** 3 hours  
**Focus:** Cursor fundamentals, Spring Boot development, AI modes

**Materials:**
- 📄 [Session 1 Outline](session1-outline.md)
- 📄 [Cursor Quick Start for IntelliJ Users](cursor-quickstart-for-intellij-users.md)
- 📊 [Session 1 Slides](slides.md)
- 🧪 [Lab Exercises](labs.md)
- 🛠️ [Hello Spring Boot Setup](hello-spring-setup.md)
- 📖 [PetClinic Exploration Guide](petclinic-guide.md)

**Projects:**
- **Hello Spring Boot** - Code-along project (built from scratch)
- **Spring PetClinic** - Exploration project (clone from GitHub)

**Key Topics:**
- Transitioning from IntelliJ to Cursor
- Chat Mode vs Agent Mode
- AI-assisted code generation
- Refactoring with AI
- Test generation
- Code analysis and understanding

---

### Session 2: Mobile Development with Cursor (Android/Kotlin) ✅
**Duration:** 3 hours  
**Focus:** Android development with Cursor Composer, Jetpack Compose, ViewModels, Room

**Materials:**
- 📄 [Session 2 Outline](session2-outline.md)
- 📊 [Session 2 Slides](android_slides.md)
- 🧪 [Lab Exercises](android_labs.md)
- 📖 [Session 2 README](session2-android/README.md)

**Projects:**
- **Task Manager App** - Complete solution in `session2-android/TaskManagerApp/`
- **Now in Android** - Exploration project (clone from GitHub)

**Key Topics:**
- Hybrid workflow: Cursor + Android Studio
- Cursor Composer for multi-file code generation
- Jetpack Compose UI with Material 3
- State management with ViewModels and StateFlow
- Navigation with Compose Navigation
- Room database for persistence
- Hilt dependency injection
- Testing Android apps with AI assistance

---

### Session 3: Agentic Coding with Cursor ✅
**Duration:** 3 hours  
**Focus:** Extended Thinking, Plan Mode, modular architecture refactoring

**Materials:**
- 📄 [Session 3 Outline](session3-outline.md)
- 📊 [Session 3 Slides](agentic_slides.md)
- 🧪 [Lab Exercises](agentic_labs.md)

**Key Topics:**
- Agentic coding principles
- Extended Thinking mode for complex problems
- Plan Mode for multi-phase refactoring
- Modular architecture extraction
- Custom slash commands
- Model Context Protocol (MCP) basics

**Note:** Requires Plan Mode features in Cursor. Instructions validated, full implementation pending.

---

### Session 4: Reviewing and Testing Code with AI ✅
**Duration:** 3 hours  
**Focus:** AI-assisted testing, code review, quality assurance

**Materials:**
- 📄 [Session 4 Outline](session4-outline.md)
- 📊 [Session 4 Slides](testing_slides.md)
- 🧪 [Lab Exercises](testing_labs.md)

**Key Topics:**
- AI test generation strategies
- Unit, integration, and E2E testing
- Code review with AI assistance
- Performance and security testing
- CI/CD integration with quality gates

**Note:** Extends Session 3 project. Instructions validated, full implementation pending.

---

### Session 5: Exploring Agents and MCP ✅
**Duration:** 3 hours  
**Focus:** Advanced AI agents, Model Context Protocol, multi-agent systems

**Materials:**
- 📄 [Session 5 Outline](session5-outline.md)
- 📊 [Session 5 Slides](agents_slides.md)
- 🧪 [Lab Exercises](agents_labs.md)

**Key Topics:**
- Custom AI agent development
- Model Context Protocol (MCP) integration
- Multi-agent collaboration patterns
- Enterprise tool integration
- Production agent deployment

**Note:** Requires MCP setup. Instructions validated, full implementation pending.

---

## 📁 Project Structure

```
cursor-java-training/
├── README.md                                    # This file
├── .cursor/
│   └── CURSOR_TRAINING_CONTEXT.md              # AI context document
│
├── session1-spring-boot/                       # Session 1 solutions
│   ├── README.md                               # Session 1 guide
│   └── hello-spring/                           # Complete solution project
│
├── session2-android/                           # Session 2 solutions
│   ├── README.md                               # Session 2 guide
│   └── TaskManagerApp/                         # Complete solution project
│
├── session3-agentic/                           # Session 3 (coming soon)
├── session4-testing/                           # Session 4 (coming soon)
├── session5-agents/                            # Session 5 (coming soon)
│
├── docs/
│   └── SETUP.md                                # General setup instructions
│
└── [Course Materials - root level]
    ├── cursor-quickstart-for-intellij-users.md
    ├── session1-outline.md                     # Session outline
    ├── slides.md                               # Slidev presentation
    ├── labs.md                                 # Session 1 lab exercises
    ├── android_labs.md                         # Session 2 lab exercises
    ├── hello-spring-setup.md
    └── petclinic-guide.md

Note: examples-*/ folders are for reference only (not part of course materials)
```

---

## 🚀 Getting Started

### For Instructors

1. **Review Materials:**
   ```bash
   # Clone or navigate to this repository
   cd cursor-java-training
   
   # Read the context document
   cat .cursor/CURSOR_TRAINING_CONTEXT.md
   
   # Review Session 1 materials
   cat cursor-quickstart-for-intellij-users.md
   cat session1-outline.md
   ```

2. **Prepare Slidev Presentation:**
   ```bash
   # Install dependencies (if not already installed)
   npm install -g @slidev/cli
   
   # Run slides in dev mode
   slidev slides.md
   
   # Export to PDF (optional)
   slidev export slides.md
   ```

3. **Set Up Projects:**
   ```bash
   # Hello Spring Boot - students will create from Spring Initializr
   # See: hello-spring-setup.md for instructions
   
   # Spring PetClinic - clone for exploration
   git clone https://github.com/spring-projects/spring-petclinic
   ```

4. **Test Everything:**
   - Run through all labs yourself
   - Verify all Cursor prompts work as expected
   - Test both code-along and exploration exercises

### For Students

#### Before Session 1

1. **Install Cursor:**
   - Download from [cursor.sh](https://cursor.sh)
   - Install for your platform (macOS/Windows/Linux)
   - Sign up for an account

2. **Install Java:**
   ```bash
   # Verify Java installation
   java -version  # Should show Java 17 or 21
   ```

3. **Install Build Tools:**
   ```bash
   # Gradle (optional, wrapper included in projects)
   brew install gradle  # macOS
   
   # Or Maven
   brew install maven   # macOS
   ```

4. **Install Cursor Extensions:**
   - Language Support for Java (Red Hat)
   - Debugger for Java (Microsoft)
   - Spring Boot Extension Pack (VMware)
   - Gradle for Java (Microsoft)

5. **Review Prerequisites:**
   - Read: [Cursor Quick Start for IntelliJ Users](cursor-quickstart-for-intellij-users.md)
   - Familiarize yourself with Cursor basics

#### During Session 1

1. **Follow along with instructor** for code-along exercises
2. **Use labs.md** as reference during class
3. **Ask questions** in Chat mode to understand concepts
4. **Save your work** for future reference

#### After Session 1

1. **Complete homework exercises** in labs.md (Part B)
2. **Explore Spring PetClinic** using the exploration guide
3. **Practice AI modes** (Chat and Agent) with your own projects
4. **Document learnings** for Session 2

---

## 🛠️ Technology Stack

### Core Technologies
- **Java:** 17 or 21
- **Spring Boot:** 3.2+
- **Build Tools:** Gradle (Groovy), Maven
- **Database:** H2 (in-memory), MySQL, PostgreSQL
- **Testing:** JUnit 5, AssertJ, MockMvc

### Frameworks & Libraries
- **Spring Data JPA** - Data access
- **Spring Web** - REST APIs
- **Thymeleaf** - Server-side templates (PetClinic)
- **Bean Validation** - Data validation
- **Spring Boot DevTools** - Development productivity

### Development Tools
- **Cursor IDE** - AI-assisted development
- **Slidev** - Presentation framework
- **Git** - Version control

---

## 📖 Key Learning Resources

### Session 1 Materials

1. **[Cursor Quick Start for IntelliJ Users](cursor-quickstart-for-intellij-users.md)**
   - IntelliJ to Cursor transition guide
   - Key differences and similarities
   - Workspace concept and multi-window support
   - Chat vs Agent modes
   - Keyboard shortcuts

2. **[Session 1 Slides](slides.md)**
   - Slidev presentation
   - Core concepts and demos
   - Live coding examples

3. **[Lab Exercises](labs.md)**
   - Part A: Code-along (in-class)
   - Part B: Exploration (homework)
   - Progressive difficulty
   - Comprehensive examples

4. **[Hello Spring Boot Setup](hello-spring-setup.md)**
   - Project setup instructions
   - Spring Initializr configuration
   - Pre-built starter (backup)
   - Troubleshooting guide

5. **[PetClinic Exploration Guide](petclinic-guide.md)**
   - Architecture overview
   - Entity relationships
   - Repository patterns
   - Controller patterns
   - Template integration
   - Testing strategies

### External Resources

- [Cursor Documentation](https://docs.cursor.com)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/)
- [Spring PetClinic](https://github.com/spring-projects/spring-petclinic)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

---

## 🎓 Teaching Philosophy

### AI-First Approach

This course emphasizes:
- **Learning by doing** with AI assistance
- **Understanding AI capabilities** and limitations
- **Asking the right questions** to AI
- **Verifying AI suggestions** with human judgment
- **Progressive complexity** from simple to advanced

### Practical Focus

- **Real projects:** Hello Spring Boot + Spring PetClinic
- **Hands-on exercises:** Code-along and exploration
- **Modern practices:** Java 17+, records, Spring Boot 3+
- **Production patterns:** Layered architecture, testing, validation

### Key Principles

1. **AI as a Pair Programmer:** Not a replacement, but a powerful assistant
2. **Critical Thinking:** Always verify AI-generated code
3. **Context Matters:** Proper prompts lead to better results
4. **Iterative Learning:** Start simple, build complexity gradually
5. **Tool Selection:** Know when to use Chat vs Agent mode

---

## 📝 Session 1 Learning Outcomes

By the end of Session 1, students will be able to:

### Cursor Fundamentals
- ✅ Navigate Cursor IDE confidently (coming from IntelliJ)
- ✅ Use Chat Mode for learning and understanding
- ✅ Use Agent Mode for code generation and refactoring
- ✅ Manage multiple windows and workspaces
- ✅ Leverage terminal integration

### Java Development with AI
- ✅ Create Spring Boot projects with AI assistance
- ✅ Generate REST controllers and services
- ✅ Implement JPA entities and repositories
- ✅ Add validation and error handling
- ✅ Use modern Java features (records, etc.)

### Code Quality
- ✅ Refactor code with AI suggestions
- ✅ Generate comprehensive tests (unit + integration)
- ✅ Apply best practices and design patterns
- ✅ Analyze existing codebases effectively

### Complex Project Analysis
- ✅ Understand Spring PetClinic architecture
- ✅ Trace request flows through layers
- ✅ Analyze entity relationships
- ✅ Identify performance considerations
- ✅ Compare architectural approaches

---

## 🎯 Success Criteria

### For Students

**After Session 1, you should be comfortable:**
- Creating Spring Boot projects from scratch with Cursor
- Using Chat mode to understand concepts
- Using Agent mode to generate and modify code
- Reading and analyzing complex Java codebases
- Writing tests with AI assistance
- Refactoring code effectively

**You should have completed:**
- All code-along exercises (Labs 1-5)
- Setup verification (Lab 0)
- At least the initial PetClinic exploration (Lab 6)

**Optional achievements:**
- Complete PetClinic deep dive (Lab 7)
- Attempt advanced challenges (Lab 8)
- Apply learnings to personal projects

### For Instructors

**Successful session indicators:**
- All students have working Hello Spring Boot project
- Most students complete code-along exercises
- Students understand Chat vs Agent decision-making
- Questions demonstrate engagement with AI concepts
- Students can independently use Cursor for basic tasks

**Common challenges to address:**
- IntelliJ muscle memory → Cursor keyboard shortcuts
- Over-reliance on AI without verification
- Prompt engineering (asking right questions)
- Context window management
- Choosing appropriate AI mode

---

## 🔧 Troubleshooting

### Common Issues

#### Cursor Installation
- **Problem:** Cursor won't start
- **Solution:** Check system requirements, reinstall if needed

#### Java Setup
- **Problem:** Wrong Java version
- **Solution:** Use SDKMAN or update JAVA_HOME

#### Project Setup
- **Problem:** Spring Initializr fails
- **Solution:** Use pre-built starter from `hello-spring-setup.md`

#### Extensions
- **Problem:** Java support not working
- **Solution:** Reinstall Java extensions, restart Cursor

#### AI Modes
- **Problem:** AI responses seem wrong
- **Solution:** Improve prompts, add context, verify with documentation

### Getting Help

1. **During Class:**
   - Ask instructor
   - Use Chat mode to understand errors
   - Check troubleshooting sections in guides

2. **After Class:**
   - Review lab documentation
   - Check Cursor documentation
   - Experiment with different prompts
   - Apply to personal projects

---

## 📅 Training Schedule Template

### Session 1 - Sample Agenda (3 hours)

**Part 1: Setup & Foundations (60 min)**
- 00:00 - 00:15: Welcome & Overview
- 00:15 - 00:30: Cursor Quick Start (from IntelliJ)
- 00:30 - 00:45: Setup Verification (Lab 0)
- 00:45 - 01:00: Creating Hello Spring Boot (Lab 1)

**Break (10 min)**

**Part 2: Building with AI (70 min)**
- 01:10 - 01:25: Adding Service Layer (Lab 2)
- 01:25 - 01:55: Adding Persistence (Lab 3)
- 01:55 - 02:20: Code Quality & Refactoring (Lab 4)

**Break (10 min)**

**Part 3: Testing & Exploration (60 min)**
- 02:30 - 02:50: Test Generation (Lab 5)
- 02:50 - 03:05: Introduction to PetClinic (Lab 6)
- 03:05 - 03:20: PetClinic Guided Exploration
- 03:20 - 03:30: Wrap-up & Homework Assignment

---

## 🚀 Next Steps

### Immediate (After Session 1)
1. Complete all homework exercises
2. Explore Spring PetClinic in depth
3. Practice with personal projects
4. Document learnings and questions

### Short-term (Before Session 2)
1. Review Session 1 materials
2. Experiment with advanced Cursor features
3. Read ahead for Session 2 topics
4. Prepare questions for next session

### Long-term (Course Goal)
1. Master AI-assisted development workflow
2. Apply learnings to production projects
3. Share knowledge with team
4. Contribute to best practices

---

## 📬 Feedback & Contributions

### For Students
- Share your experiences using Cursor
- Report any issues with course materials
- Suggest improvements or additional topics

### For Instructors
- Adapt materials to your teaching style
- Share successful exercises or examples
- Contribute improvements to materials

---

## 📄 License & Usage

These materials are provided for educational purposes.

**You may:**
- Use these materials for teaching
- Adapt them to your needs
- Share with students and colleagues

**Please:**
- Give credit when sharing
- Report issues or improvements
- Respect intellectual property

---

## 👨‍💻 About the Instructor

**Ken Kousen**
- 30+ years Java experience
- 15+ years IntelliJ user
- Author of multiple technical books
- Speaker at conferences worldwide
- Passionate about developer productivity

---

## 🎉 Acknowledgments

- **Spring Team** - For Spring Boot and PetClinic
- **Cursor Team** - For the amazing AI-powered IDE
- **Java Community** - For continuous innovation
- **Students** - For feedback and engagement

---

**Ready to boost your Java development with AI?**  
**Let's get started! 🚀**

