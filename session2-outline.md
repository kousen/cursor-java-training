# Session 2: Using Cursor for Mobile Development

**Duration:** 3 hours  
**Audience:** ~100 experienced Android developers (primarily Android Studio users)  
**Format:** Instructor-led with code-along exercises  
**Prerequisite:** Completion of Session 1 or equivalent Cursor experience

## Session Objectives

By the end of this session, participants will be able to:
- Navigate Cursor effectively for Android/Kotlin development
- Generate and refactor Jetpack Compose UIs with AI assistance
- Implement modern Android architecture (MVVM, Repository pattern)
- Build complete multi-screen apps with navigation and persistence
- Test Android applications using Compose testing APIs
- Understand when to use AI assistance vs manual coding in mobile development

## Two-Project Approach

### Project 1: Task Manager App (Code-Along)
**Purpose:** Build from scratch together  
**Duration:** ~130 minutes (Parts 1-6)  
**Approach:** Instructor-led, students follow along  
**Deliverable:** Working Android app with Compose UI, ViewModels, Navigation, Room database, and tests

**Key Technologies:**
- Kotlin
- Jetpack Compose + Material 3
- ViewModels + StateFlow
- Compose Navigation
- Room Database
- Hilt (Dependency Injection)
- JUnit 5 + Compose Testing

### Project 2: Now in Android (Exploration)
**Purpose:** Analyze Google's production sample app  
**Duration:** ~30 minutes intro + homework  
**Approach:** Guided exploration, deeper practice in labs  
**Repository:** https://github.com/android/nowinandroid

---

## Detailed Timeline

### Part 1: Setup & Android Development in Cursor (30 minutes)

#### Welcome & Session 2 Overview (5 min)
- Recap Session 1: Cursor basics, Chat vs Agent modes
- Session 2 focus: **Cursor Composer** - the multi-file AI code generator
- The hybrid workflow: Cursor + Android Studio together
- Two-project approach explanation
- Today's deliverables: complete Task Manager app

#### The Hybrid Workflow (10 min)
- **Why you need BOTH tools:**
  - Android Studio: Project creation, running, debugging, device management, building APKs
  - Cursor: AI-powered code generation via Composer mode
  - They complement each other perfectly
  
- **Cursor Composer Mode (Cmd/Ctrl+Shift+I):**
  - Multi-file code generation with full codebase context
  - Tag @codebase to give AI awareness of entire project
  - Natural language instructions
  - Accepts/rejects changes before applying
  - Iterative refinement: describe → generate → test → refine
  
- **The efficient workflow:**
  1. Create/open project in Android Studio
  2. Open same folder in Cursor
  3. Use Composer in Cursor to generate code
  4. Switch to Android Studio to run/test
  5. Back to Cursor for next iteration
  6. Repeat!
  
- **Terminal commands you may still need:**
  - `./gradlew assembleDebug`
  - `adb devices`
  - `./gradlew installDebug`

#### Environment Verification (15 min)
**Live Demo:**
- **Step 1:** Create new project in Android Studio (or open starter)
  - File → New → New Project → Empty Activity
  - Set up project name, package, save location
  - Wait for Gradle sync
  - Run app to verify emulator works
  
- **Step 2:** Open same project in Cursor
  - Cursor → File → Open Folder
  - Select the Android project folder
  - Verify Kotlin syntax highlighting works
  
- **Step 3:** Test Composer mode in Cursor
  - Press Cmd/Ctrl+Shift+I to open Composer
  - Type: `@codebase Explain the structure of this Android app`
  - Then: `@codebase Create a simple Greeting composable with a Text and Button`
  - Accept the changes
  
- **Step 4:** Back to Android Studio → Run app
  - Click Run button or Shift+F10
  - Verify the AI-generated composable appears on screen

**Student Exercise (5 min):**
- Verify both Android Studio and Cursor are installed
- Open the same project in both tools
- Test Composer mode with simple prompt
- Run on emulator/device from Android Studio

**Checkpoint:** Everyone has the hybrid workflow working

---

### Part 2: Building UIs with Jetpack Compose (35 minutes)

#### Composables and Material Design (20 min)

**Demo: Creating Basic Composables (10 min)**
- **Open Cursor Composer (Cmd/Ctrl+Shift+I):**
  ```
  @codebase Create a TaskCard composable that displays a task with title, 
  description, and completed checkbox using Material 3 components.
  Use proper spacing and modern Compose patterns.
  ```
- Review generated code in Composer:
  - `@Composable` annotation
  - Material 3 Card, Text, Checkbox
  - Modifier usage (padding, fillMaxWidth, etc.)
  - Remember and state handling
- Accept the changes

- **Add Preview Functions in Composer:**
  ```
  @codebase Add preview functions showing TaskCard with different states: 
  uncompleted task, completed task, and long text overflow
  ```
- Switch to Android Studio → view Compose preview pane
- Back to Cursor Composer to iterate:
  ```
  @codebase Update TaskCard to use better spacing and add an icon for task status
  ```
- Switch to Android Studio → run app to see results

**Demo: Building Lists (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Create a TaskList composable using LazyColumn to display 
  a list of tasks. Include proper keys and content types. Handle empty state.
  Add sample data for preview.
  ```
- Review generated code:
  - LazyColumn basics
  - Item keys for performance
  - Content types
  - Handling empty state
- Switch to Android Studio → Run app

**Student Exercise (15 min):**
- In Cursor Composer, generate your own TaskCard with customizations
- Use Composer to create preview functions for different states
- Build a TaskList and test with sample data
- Use Chat mode to ask: "How do I make the checkbox larger?"
- Back to Composer to apply changes
- Test in Android Studio

---

### Part 3: State Management and Architecture (35 minutes)

#### ViewModels and UI State (35 min)

**Demo: Creating ViewModels (15 min)**
- **Understanding MVVM (use Chat mode):**
  ```
  Cmd/Ctrl+L: "Explain the MVVM pattern for Android and how it applies to Compose"
  ```

- **In Cursor Composer:**
  ```
  @codebase Create a TaskViewModel that manages a list of tasks using StateFlow. 
  Include functions to add, update, delete, and toggle task completion. 
  Use proper coroutine scopes and follow Android best practices.
  ```
- Review generated code:
  - StateFlow and MutableStateFlow
  - viewModelScope for coroutines
  - Immutable state updates
  - Event handling

**Demo: UI State Pattern (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Create a sealed interface TaskListUiState with states for 
  Loading, Success with task list, and Error with message
  ```
- Review pattern:
  - Sealed interfaces/classes
  - Exhaustive when expressions
  - Type-safe state representation

- **Connect to UI in Composer:**
  ```
  @codebase Update TaskList composable to observe TaskViewModel's StateFlow 
  using collectAsStateWithLifecycle and handle all UI states (Loading, Success, Error)
  ```
- Switch to Android Studio → Run and test

**Student Exercise (10 min):**
- Use Composer to generate a ViewModel for your tasks
- Use Composer to create UI state sealed interface
- Connect ViewModel to your composables
- Run in Android Studio: add a task and observe UI update
- Test loading and error states

**Checkpoint:** Working UI with state management through ViewModel

---

### BREAK (10 minutes)

---

### Part 4: Navigation (25 minutes)

#### Multi-Screen Navigation (25 min)

**Demo: Setting Up Navigation (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Add Jetpack Compose Navigation to this project. Create a 
  sealed class for routes: HomeRoute and TaskDetailRoute with task ID parameter.
  Add the required dependencies to build.gradle if needed.
  ```
- Review generated code:
  - Navigation dependencies
  - Route definitions
  - Type-safe navigation

- **Create NavHost in Composer:**
  ```
  @codebase Create a NavHost with home screen showing task list and 
  detail screen for editing a task. Set up the navigation structure in MainActivity.
  ```
- Switch to Android Studio → Build and run

**Demo: Passing Data Between Screens (10 min)**
- **Detail Screen in Composer:**
  ```
  @codebase Create TaskDetailScreen composable that takes a task ID, 
  loads task from ViewModel, and provides form inputs to edit title 
  and description with Save and Cancel buttons. Wire up navigation.
  ```
- Review in Composer preview:
  - Navigation with arguments
  - Back stack handling
  - Form state management
- Run in Android Studio → Test navigation flow

**Student Exercise (5 min):**
- Test navigation: click a task to navigate to detail
- Edit task details in the form
- Save and navigate back
- Verify changes persist in the list
- Use Composer to fix any issues

---

### Part 5: Data Persistence with Room (30 minutes)

#### Room Database Integration (30 min)

**Demo: Creating Room Database (15 min)**
- **In Cursor Composer:**
  ```
  @codebase Create a Task entity for Room database with fields: id (auto-generated), 
  title (not null), description (nullable), completed (boolean), 
  createdAt (timestamp). Add Room dependencies to build.gradle if needed.
  ```
- Review Room annotations:
  - `@Entity`, `@PrimaryKey`, `@ColumnInfo`
  - Type converters for Date/Timestamp

- **Continue in Composer:**
  ```
  @codebase Create TaskDao with functions to: insert, update, delete task, 
  get all tasks as Flow, get task by ID, and get completed/incomplete tasks. 
  Use proper suspend functions and Flow.
  ```
- Review DAO patterns:
  - Suspend functions for one-shot operations
  - Flow for observable queries
  - Query annotations

- **Complete Database Setup in Composer:**
  ```
  @codebase Create AppDatabase extending RoomDatabase with TaskDao. 
  Include version, entities, and proper database configuration.
  ```

**Demo: Repository Pattern (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Create TaskRepository that uses TaskDao and exposes Flow 
  for task list and suspend functions for CRUD operations. Update TaskViewModel 
  to use this real repository instead of fake data.
  ```
- Switch to Android Studio → Build and run
- Test: add task, close app, reopen → verify persistence

**Student Exercise (5 min):**
- Run the app with Room integration in Android Studio
- Add multiple tasks
- Force close and reopen app
- Verify tasks persist
- Toggle task completion and verify save works

**Checkpoint:** Complete app with data persistence

---

### BREAK (10 minutes)

---

### Part 6: Testing Android Components (25 minutes)

#### Testing ViewModels and Compose UIs (25 min)

**Demo: ViewModel Testing (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Generate unit tests for TaskViewModel using JUnit 5 and MockK. 
  Test adding a task, deleting a task, and toggling completion. 
  Use Turbine for testing Flow emissions. Add test dependencies to build.gradle if needed.
  ```
- Review testing patterns in Composer:
  - Mocking repository with MockK
  - Testing coroutines with runTest
  - Testing Flow with Turbine
  - Verifying state updates
- Run tests from Android Studio or terminal

**Demo: Compose UI Testing (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Generate Compose UI tests for TaskCard using ComposeTestRule. 
  Test that title and description are displayed, checkbox reflects 
  completed state, and clicking checkbox triggers callback.
  ```
- Review Compose testing:
  - ComposeTestRule setup
  - Finding nodes by semantic properties
  - Assertions (assertIsDisplayed, assertTextEquals)
  - User actions (performClick, performTextInput)

- **Integration Tests in Composer:**
  ```
  @codebase Create an integration test for TaskList that verifies tasks 
  are displayed, clicking a task navigates to detail, and empty state 
  is shown when list is empty
  ```
- Run from Android Studio

**Student Exercise (5 min):**
- Run generated tests in Android Studio or terminal: `./gradlew test`
- Review test results
- Use Composer to add one custom test
- Use Chat mode if tests fail: "Why is my UI test failing?"

---

### Part 7: Advanced Topics and Production Patterns (20 minutes)

#### Dependency Injection and Polish (20 min)

**Demo: Adding Hilt (10 min)**
- **In Cursor Composer:**
  ```
  @codebase Add Hilt dependency injection to this project. Create Application 
  class annotated with @HiltAndroidApp, create a module to provide 
  TaskRepository and Room database, and set up ViewModel injection.
  Add all necessary dependencies to build.gradle.
  ```
- Review Hilt concepts in generated code:
  - Application class
  - Modules and providers
  - ViewModel injection
  - Singleton scoping
- Build and run in Android Studio

**Demo: Material 3 Theming (5 min)**
- **In Cursor Composer:**
  ```
  @codebase Create a Material 3 theme with custom color scheme (purple primary) 
  and add dark theme support using dynamic colors. Apply this theme to the app.
  ```
- Switch to Android Studio → Run and test
- Toggle dark mode on device/emulator

**Demo: Accessibility and Performance (5 min)**
- **Use Chat mode for review:**
  ```
  Chat: "Review TaskCard for accessibility. What improvements would help 
  screen reader users?"
  ```
- **Apply suggestions in Composer:**
  ```
  @codebase Add semantic properties to TaskCard for better accessibility
  ```

- **Performance Review in Chat:**
  ```
  Chat: "Review TaskList for potential recomposition issues and suggest 
  optimizations"
  ```
- Apply in Composer if needed

**Student Exercise (5 min):**
- Use Composer to add Hilt to your project (if not done)
- Apply Material 3 theme via Composer
- Test with dark mode in Android Studio
- Use Chat to ask AI to review your code for improvements

---

### Part 8: Now in Android Introduction (15 minutes)

#### Exploring Google's Sample App (15 min)

**Demo: Navigation and Analysis (10 min)**
- Clone Now in Android:
  ```bash
  git clone https://github.com/android/nowinandroid
  cd nowinandroid
  ```
- Open in both Android Studio (to run it) and Cursor (to analyze it)

- **In Cursor Chat Mode (Cmd/Ctrl+L):**
  ```
  Chat: "Explain the overall architecture of Now in Android app"
  Chat: "What is the purpose of the :core:data module?"
  Chat: "How is the navigation implemented?"
  Chat: "What testing strategies are used?"
  ```

- Quick tour of:
  - Multi-module structure
  - Build conventions (Gradle version catalogs)
  - UI patterns (Compose, Material 3)
  - Testing approach
- Run in Android Studio to see the production app

**Student Guided Exploration (5 min):**
Students use Chat mode in Cursor to explore:
1. "How many feature modules are there?"
2. "Explain the DI setup in this app"
3. "What design system components are used?"
4. "How is offline support implemented?"
5. Compare with your Task Manager app architecture

---

### Wrap-Up & Next Steps (10 minutes)

#### Key Takeaways (5 min)

**Decision Tree:**
```
Need to understand code/APIs? → Use Chat mode (Cmd/Ctrl+L)
Need to generate/modify code? → Use Composer (Cmd/Ctrl+Shift+I) with @codebase
Need to run/test app? → Switch to Android Studio
Need to debug layout? → Use Chat to explain, then Composer to fix
Need to add feature? → Use Composer with detailed instructions + @codebase
Need multi-file changes? → Always use Composer, never manual editing
```

**What We Built:**
- ✅ Complete Android app with Jetpack Compose
- ✅ Material Design 3 UI components
- ✅ State management with ViewModels and StateFlow
- ✅ Multi-screen navigation with type-safe routes
- ✅ Data persistence with Room database
- ✅ Dependency injection with Hilt
- ✅ Comprehensive test suite (unit + UI tests)

#### Preview Session 3 (3 min)

**Advanced AI Features & Custom Workflows**
- Extended Thinking mode for complex problems
- Plan Mode for multi-step changes
- Model Context Protocol (MCP) for external tools
- Custom slash commands
- Team collaboration and code review

#### Q&A (2 min)
- Quick questions
- Troubleshooting
- Homework assignment

---

## Materials Provided

### Pre-Session
- Session 1 recap document
- Hybrid Workflow guide: Using Cursor with Android Studio
- Starter project repository (can be opened in both tools)
- Extension installation checklist (Kotlin, Java, Gradle support for Cursor)
- **Android Studio installation required** - not optional!

### During Session
- This session outline
- Slidev presentation
- GitHub repository with starter code
- Quick reference for Compose with AI

### Post-Session
- Complete labs.md with all exercises
- Now in Android exploration guide
- Solution code for reference
- Additional resources and links
- Session 3 preview materials

---

## Success Metrics

Students should leave able to:
- [ ] Set up and use the hybrid workflow (Cursor + Android Studio)
- [ ] Use Composer mode with @codebase for multi-file code generation
- [ ] Generate complete Composables with Material 3 components
- [ ] Implement ViewModels with proper state management via AI
- [ ] Build multi-screen apps with navigation using Composer
- [ ] Integrate Room database for persistence with AI assistance
- [ ] Write tests for ViewModels and Compose UIs via Composer
- [ ] Switch efficiently between Cursor (coding) and Android Studio (testing)
- [ ] Understand Now in Android architecture basics using Chat mode
- [ ] Apply the hybrid workflow to their own Android projects

---

## Instructor Notes

### Timing Buffers
- Breaks provide 20 min catch-up time
- Can compress Now in Android section if needed
- Task Manager app core features must be completed
- Testing and Hilt sections can be shortened if running behind

### Common Issues & Solutions
- **Gradle sync issues:** Sync in Android Studio first, then open in Cursor
- **Emulator not starting:** Use physical device as backup, manage AVDs in Android Studio
- **Compose preview not working in Cursor:** Use Android Studio's preview pane instead
- **AI generates View code instead of Compose:** Be explicit in Composer prompts: "using Jetpack Compose"
- **Room migrations:** Keep it simple, use fallbackToDestructiveMigration for demo
- **Students confused about which tool:** Reinforce: Cursor for code, Android Studio for running
- **Code not updating:** Make sure to save/accept changes in Composer, then rebuild in Android Studio

### Adaptation Points
- If ahead: Add more features (categories, due dates, reminders)
- If behind: Skip Hilt, use manual DI; simplify theming
- If questions: Use Chat mode to explore together
- If students struggle with Compose: More Chat mode explanations, slower demo

### Demo Tips
- **Always show both tools side-by-side** (or switch between them clearly)
- **Be explicit:** "Now I'm in Cursor Composer..." vs "Now switching to Android Studio..."
- Start every Composer prompt with @codebase to show best practice
- Run on device frequently in Android Studio to show real app
- Demonstrate incremental development (Cursor → generate, Android Studio → test, iterate)
- Show mistakes and how AI can help debug (Chat for understanding, Composer for fixes)
- Highlight when AI misunderstands mobile context
- Use Chat mode to explain complex Compose concepts before generating code
- Keep both tools visible if possible (two monitors ideal)

### Mobile-Specific Considerations
- Device/emulator availability varies by student
- Build times can be slow - use this for discussions
- Screen sizes differ - emphasize responsive design
- Some students may have iOS background - acknowledge differences
- Compose is newer - some may be familiar with Views, others pure Compose

---

## Project: Task Manager App

### Features to Build
1. **Home Screen**
   - LazyColumn of tasks
   - Add task button (FAB)
   - Filter: All, Active, Completed
   - Empty state

2. **Task Detail/Edit Screen**
   - Text inputs for title and description
   - Checkbox for completion
   - Created date display
   - Save and Cancel buttons
   - Navigation back

3. **Data Layer**
   - Task entity with Room
   - TaskDao with CRUD + queries
   - Repository abstraction
   - Hilt for DI

4. **Architecture**
   - MVVM pattern
   - Unidirectional data flow
   - StateFlow for state
   - Proper coroutine usage

5. **Testing**
   - ViewModel unit tests
   - Composable UI tests
   - Repository tests
   - Integration tests

6. **Polish**
   - Material 3 theming
   - Dark mode support
   - Accessibility
   - Error handling

---

## Progression from Session 1

### Building on Session 1 Concepts

| Session 1 (Java/Spring Boot) | Session 2 (Android/Compose) |
|------------------------------|----------------------------|
| REST Controllers | Composable functions |
| Service Layer | ViewModels |
| JPA Repositories | Room DAOs |
| Spring DI | Hilt DI |
| Spring Boot Tests | Compose Tests |
| Multi-file backend | Multi-screen mobile app |
| HTTP requests | Screen navigation |
| JSON serialization | State serialization |

### Same AI Principles, Different Domain
- Chat for understanding APIs and architecture
- Agent for generating code
- Iterative refinement
- Context awareness (@file mentions)
- Verification of AI output
- Testing generated code

### New Mobile-Specific Skills
- Visual UI development (Compose previews)
- State management in declarative UI
- Navigation patterns for mobile
- Lifecycle awareness
- Platform-specific constraints (device, screen size)
- UI testing with semantic tree

---

## Lab Preview (labs-session2.md)

### Part A: Code-Along (In-Class)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 0 | Android Setup Verification | 5 min | Environment, emulator, extensions |
| 1 | Creating Task Manager Project | 10 min | Project setup, first composable |
| 2 | Building Task UI | 20 min | Compose, Material 3, previews |
| 3 | State Management | 25 min | ViewModels, StateFlow, MVVM |
| 4 | Navigation | 20 min | Compose Navigation, routes |
| 5 | Room Database | 25 min | Entity, DAO, Database, Repository |
| 6 | Testing | 20 min | Unit tests, UI tests |
| 7 | Hilt and Polish | 15 min | DI, theming, accessibility |

**Total In-Class Time:** ~140 minutes (2h 20m)

### Part B: Exploration (Homework)

| Lab | Title | Time | Key Concepts |
|-----|-------|------|--------------|
| 8 | Now in Android Analysis | 30-45 min | Architecture, modules, patterns |
| 9 | Advanced Features | 45-60 min | Add categories, due dates, search |
| 10 | Production Polish | 30-45 min | Performance, accessibility, error handling |

**Total Homework Time:** ~2-3 hours

---

## Resources and Links

### Official Documentation
- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose)
- [Kotlin Language Docs](https://kotlinlang.org/docs/home.html)
- [Android Architecture Guide](https://developer.android.com/topic/architecture)
- [Room Database](https://developer.android.com/training/data-storage/room)
- [Hilt Dependency Injection](https://developer.android.com/training/dependency-injection/hilt-android)

### Sample Projects
- [Now in Android](https://github.com/android/nowinandroid)
- [Compose Samples](https://github.com/android/compose-samples)
- [Architecture Samples](https://github.com/android/architecture-samples)

### Learning Resources
- [Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)
- [Testing in Jetpack Compose](https://developer.android.com/jetpack/compose/testing)

---

**Session 2 outline complete and ready for material development! 🚀**

