# Cursor Training Project - Current Context

**Last Updated:** After completing Session 2 materials

## 🎯 Project Overview

Creating 5 training sessions (3 hours each) for **~100 experienced Java developers** learning AI-assisted development with Cursor. Client has experience with Android, Kotlin, and Jetpack Compose.

**Instructor:** Ken Kousen  
**Format:** Instructor-led with hands-on exercises  
**Platform:** Cursor IDE with AI assistance

---

## ✅ Completed Sessions

### Session 1: Using Cursor for Java Development
**Status:** ✅ Complete  
**Materials:**
- `COURSE_PROPOSAL.md` - O'Reilly formal proposal
- `session1-outline.md` - Instructor guide
- `slides.md` - Slidev presentation (~80 slides)
- `labs.md` - Lab exercises (9 labs)
- `cursor-quickstart-for-intellij-users.md` - Transition guide
- `hello-spring-setup.md` - Project setup guide
- `petclinic-guide.md` - Exploration guide

**Projects Built:**
- Hello Spring Boot (code-along)
- Spring PetClinic analysis (homework)

**Key Topics:** Chat vs Agent modes, Spring Boot, REST APIs, JPA, testing

---

### Session 2: Using Cursor for Mobile Development (Android/Kotlin)
**Status:** ✅ Complete  
**Materials:**
- `COURSE_PROPOSAL_SESSION2.md` - O'Reilly formal proposal
- `session2-outline.md` - Instructor guide
- `android_slides.md` - Slidev presentation (~85 slides)
- `android_labs.md` - Lab exercises (11 labs: 8 in-class + 3 homework)
- Prefixed with "android_" to avoid conflicts with Session 1

**Projects Built:**
- Task Manager App (code-along) - Complete Android app with:
  - Jetpack Compose UI + Material 3
  - ViewModels + StateFlow (MVVM)
  - Multi-screen navigation
  - Room database persistence
  - Hilt dependency injection
  - Comprehensive testing

**Key Innovation: HYBRID WORKFLOW**
- **Cursor Composer** (Cmd/Ctrl+Shift+I) for code generation with `@codebase` tag
- **Android Studio** for running, testing, debugging
- Not Cursor-only development (realistic approach)

**Key Topics:** Composer mode, Jetpack Compose, MVVM, Navigation, Room, Hilt, testing

---

## 📋 Key Decisions & Conventions

### 1. Slidev Presentation Limits
**Problem:** Code blocks and content extending below viewport  
**Solution:** Strict limits in `.cursorrules`:

- **Code blocks:** Maximum **12 lines** (strict)
- **Bullet points:** Maximum **5 items** (ideally 4)
- **v-clicks with bullets:** Maximum **4 items** (expand vertically)
- **Combined content:** Title + 3-4 bullets + 8-10 line code block MAX

**Strategies when code exceeds limits:**
1. Abbreviate with `// ...` to show key parts
2. Split into 2 slides (setup + usage)
3. Use `layout: two-cols` for side-by-side
4. Focus on concepts over complete implementation

### 2. File Naming Conventions
- **Slides:** `[topic]_slides.md` (e.g., `android_slides.md`)
- **Labs:** `[topic]_labs.md` (e.g., `android_labs.md`)
- **Outlines:** `session[N]-outline.md`
- **Proposals:** `COURSE_PROPOSAL_SESSION[N].md`

### 3. Cursor Rules File
- **Location:** `.cursorrules` in project root (NOT in `.cursor/rules/`)
- **Purpose:** Project-specific guidelines for AI
- **Contents:** Slidev limits, lab structure, Android hybrid workflow, code generation patterns

### 4. Session 2 Android Approach
**Critical: Hybrid Workflow, NOT Cursor-only**
- Android Studio is **required** (not optional)
- Students need both tools installed
- Every lab shows: Cursor Composer → Android Studio → Test
- Realistic about limitations (no native Android tooling in Cursor)

### 5. Cursor Composer Mode
**Primary mode for Session 2:**
- `Cmd/Ctrl+Shift+I` to open
- **Always** start prompts with `@codebase` tag
- Multi-file code generation
- Better than Chat/Agent for complex Android features
- Accepts/rejects changes before applying

---

## 📁 Project Structure

```
cursor-java-training/
├── .cursorrules                              # Project rules (root)
├── PROJECT_CONTEXT.md                        # This file
│
├── Session 1 Materials (Java/Spring Boot)
│   ├── COURSE_PROPOSAL.md
│   ├── session1-outline.md
│   ├── slides.md
│   ├── labs.md
│   ├── cursor-quickstart-for-intellij-users.md
│   ├── hello-spring-setup.md
│   ├── petclinic-guide.md
│   └── SESSION1_SUMMARY.md
│
├── Session 2 Materials (Android/Kotlin)
│   ├── COURSE_PROPOSAL_SESSION2.md
│   ├── session2-outline.md
│   ├── android_slides.md                    # Note: "android_" prefix
│   ├── android_labs.md                      # Note: "android_" prefix
│   ├── SESSION2_SUMMARY.md
│   └── SESSION2_MATERIALS_COMPLETE.md
│
├── Sessions 3-5 (TODO)
│   └── (Not yet created)
│
└── Reference
    ├── examples-*/ (ignored by git)
    └── README.md (project overview)
```

---

## 🔧 Technical Stack

### Session 1 (Java/Spring Boot)
- Java 17/21
- Spring Boot 3.2+
- Gradle
- JPA/Hibernate
- H2 Database
- JUnit 5 + AssertJ

### Session 2 (Android/Kotlin)
- Kotlin
- Android SDK (API 34+)
- Jetpack Compose + Material 3
- ViewModels + StateFlow
- Compose Navigation
- Room Database
- Hilt DI
- JUnit 5 + MockK + Compose Test
- **Both Cursor AND Android Studio**

---

## 🎓 Teaching Philosophy

### AI-First Approach
- Learning by doing with AI assistance
- Understanding AI capabilities AND limitations
- Asking the right questions to AI
- **Always verify AI-generated code**
- Progressive complexity: simple → advanced

### Key Principles
1. **AI as Pair Programmer** - Assistant, not replacement
2. **Critical Thinking** - Verify all AI output
3. **Context Matters** - Proper prompts = better results
4. **Iterative Learning** - Start simple, build complexity
5. **Tool Selection** - Know when to use which AI mode

### For Session 2 Specifically
- **Hybrid Workflow** - Use each tool for its strengths
- **Realistic Expectations** - Don't oversell AI capabilities
- **Tool Switching** - Explicit about when to use which tool
- **Troubleshooting** - Include common issues and solutions

---

## 📝 Lab Exercise Structure

### Standard Format
Each lab includes:
1. **Goal** - Clear objective
2. **Time estimate** - Realistic duration
3. **Step-by-step instructions** - Numbered, detailed
4. **Expected code output** - For verification
5. **Success criteria** - Checklist
6. **Troubleshooting** - Common issues

### Cursor Composer Prompts
Always formatted as:
```
@codebase [Clear instruction with specifics]

Requirements:
- Specific requirement 1
- Specific requirement 2
- Architecture patterns to follow
```

---

## 🚀 Running Materials

### Slidev Presentations
```bash
# Install Slidev globally (one time)
npm install -g @slidev/cli

# Run Session 1 slides
slidev slides.md

# Run Session 2 slides
slidev android_slides.md

# Export to PDF (optional)
slidev export slides.md
```

### Testing Labs
1. Work through all labs yourself before teaching
2. Verify all Cursor Composer prompts work
3. Test on actual devices/emulators
4. Note any timing adjustments needed

---

## 🔍 Resources & References

### Cursor-Specific
- **cursor.directory** - Community `.cursorrules` examples
- Cursor browser agent via MCP (built-in)
- Documentation: https://cursor.com/docs

### MCP Servers Configured
1. **CursorBrowser** - Built-in browser automation
2. **Context7** - Library documentation lookup
3. **SonarQube** - Code quality analysis

### External Resources
- **Slidev Docs:** https://sli.dev
- **Spring Boot:** https://spring.io/projects/spring-boot
- **Android Developers:** https://developer.android.com
- **Jetpack Compose:** https://developer.android.com/jetpack/compose
- **Now in Android:** https://github.com/android/nowinandroid

---

## ⚠️ Important Notes

### Session 2 Critical Points
1. **Students MUST have Android Studio installed** - Not optional!
2. Emphasize hybrid workflow from the start
3. Always show `@codebase` tag in Composer prompts
4. Switch between tools explicitly ("Now in Cursor..." vs "In Android Studio...")
5. Set realistic expectations (AI isn't perfect)

### Common Pitfalls to Avoid
- ❌ Suggesting Cursor can replace Android Studio entirely
- ❌ Forgetting `@codebase` tag in prompts
- ❌ Code blocks > 12 lines in slides
- ❌ More than 5 bullets in a slide
- ❌ Overselling AI capabilities
- ❌ Not including troubleshooting sections

### Slidev Issues
- Watch for content extending below viewport
- Test slides in presentation mode
- Code blocks are the main culprit
- Split or abbreviate when needed

---

## 📊 Session Comparison

| Aspect | Session 1 (Java) | Session 2 (Android) |
|--------|------------------|---------------------|
| **Environment** | Cursor only | Cursor + Android Studio |
| **Primary Mode** | Chat + Agent | Composer + @codebase |
| **Project Type** | Backend API | Mobile app |
| **Architecture** | Layered (MVC) | MVVM |
| **Persistence** | JPA/Hibernate | Room |
| **DI** | Spring DI | Hilt |
| **Testing** | JUnit + MockMvc | JUnit + Compose Test |
| **Key Challenge** | Understanding Spring | Tool switching workflow |

---

## 🎯 What's Next

### Session 3: Advanced AI Features (TODO)
**Planned Topics:**
- Extended Thinking mode
- Plan Mode for complex refactoring
- Model Context Protocol (MCP) deep dive
- Custom slash commands
- Team collaboration workflows

### Session 4: Code Review & Testing (TODO)
**Planned Topics:**
- AI-assisted code reviews
- Test generation strategies
- Quality assurance with AI
- Documentation generation

### Session 5: Agents and MCP (TODO)
**Planned Topics:**
- Building custom MCP servers
- Agent workflows
- Integration patterns
- Production considerations

---

## 💡 Quick Reference

### Opening a New Chat Session
When starting a new chat, reference:
- `@PROJECT_CONTEXT.md` (this file) - Overall project status
- `@.cursorrules` - Project guidelines
- Session-specific files as needed

### Key Commands to Remember
- **Slidev:** `slidev [filename].md`
- **Composer:** `Cmd/Ctrl+Shift+I`
- **Chat:** `Cmd/Ctrl+L`
- **Agent:** `Cmd/Ctrl+I`

### Always Include in Android Labs
- Hybrid workflow steps
- `@codebase` in all Composer prompts
- "In Cursor Composer:" and "In Android Studio:" labels
- Success criteria checklist
- Troubleshooting section

---

## 📞 Contact & Metadata

**Instructor:** Ken Kousen  
**Email:** ken.kousen@kousenit.com  
**Company:** Kousen IT, Inc.

**Course Series:** Cursor for Java Developers (5 sessions × 3 hours)  
**Target Audience:** ~100 experienced Java developers  
**Experience Level:** Familiar with IntelliJ, Java 17+, Spring Boot, Android/Kotlin

**Repository Type:** Training materials (slides, labs, guides)  
**Not a code repository:** Minimal example code, mostly documentation

---

**This file should be referenced at the start of each new chat session to maintain context about the project's current state, decisions made, and conventions established.**

**Last significant update:** Completed all Session 2 materials with hybrid workflow approach

