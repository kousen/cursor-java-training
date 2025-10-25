# Custom Live Course Proposal 

**Title:** Using Cursor for Mobile Development  
**Subtitle:** AI-Assisted Android Development with Kotlin and Jetpack Compose

## Contacts

**Instructor Name:** Ken Kousen  
**Email:** ken.kousen@kousenit.com  
**Timezone:** ET  
**Mailing Address:** 11 Emily Road, Marlborough, CT 06447, USA

**Entity**  
*If we offer you an agreement, and you would prefer that an LLC or other entity be a party to the contract, please include the following information about the entity.*  
**Name:** Kousen IT Inc.  
**Email:** ken.kousen@kousenit.com  
**Mailing Address:** 11 Emily Road, Marlborough, CT 06447, USA

## Timing

**Total Duration:** 3 hours

## Course Information

### Course Registration Page Information

**Course Description**

In this hands-on, 3-hour course, you'll learn how to supercharge your Android development by combining Cursor's AI capabilities with Android Studio. Building on the fundamentals from Session 1, we'll explore a powerful hybrid workflow where you use Cursor Composer for AI-powered code generation and Android Studio for running and testing. Through guided exercises building a complete Android app with Kotlin and Jetpack Compose, you'll discover how AI assistance accelerates UI development—from generating entire composables and ViewModels to implementing navigation and state management. You'll gain practical experience using natural language prompts to build complex features in minutes and learn the optimal workflow for integrating Cursor's AI into your existing Android Studio development process.

**Course Objectives**

* Master a hybrid workflow using Cursor Composer for AI-powered code generation and Android Studio for running and testing mobile applications
* Use natural language prompts to generate complete Android features including Composables, ViewModels, navigation, and data persistence layers
* Build production-quality Android apps following modern architecture patterns (MVVM, unidirectional data flow) by leveraging AI to write Kotlin code faster while maintaining best practices

**Prerequisites**

* Experience with Android development fundamentals (Activities, Views, Gradle)
* Working knowledge of Kotlin syntax and idioms (classes, lambdas, coroutines)
* Familiarity with Jetpack Compose basics (Composables, state, modifiers) is helpful but not required
* Completion of Session 1 (Using Cursor for Java Development) or equivalent experience with Cursor basics

**Course Preparation**

**Required Setup (Before Class):**
* Complete Session 1 or verify you can use Cursor's Composer mode (Cmd/Ctrl+Shift+I)
* **Android Studio installed** - You will need this! Download from [developer.android.com](https://developer.android.com/studio)
  * Complete Android Studio setup wizard
  * Install Android SDK (API 34 or higher recommended)
  * Set up at least one Android emulator (AVD) OR have a physical device for testing
* **Cursor IDE installed** - for AI-powered code generation
* Install Kotlin language support in Cursor:
  * Kotlin (mathiasfrohlich.Kotlin or fwcd.kotlin) - for Kotlin syntax highlighting
  * Language Support for Java (Red Hat) - for Gradle projects
  * Gradle for Java (Microsoft) - for build integration
* Clone starter repository: [GitHub link will be provided]

**Recommended Pre-Reading:**
* [Cursor Quick Start for Android Studio Users](link-to-guide) - especially if coming from Android Studio
* Review Jetpack Compose mental model: thinking in composition, not view hierarchy
* Skim [Modern Android Architecture Guide](https://developer.android.com/topic/architecture)

**Course Follow-Up**

**Read:**
* [Chapter 3. Code Generation with Context](https://learning.oreilly.com/library/view/generative-ai-for/9781098162269/ch03.html) from *Generative AI for Software Development* by Sergio Pereira
* [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose) - Advanced topics in state management and performance
* [Kotlin Coroutines Guide](https://kotlinlang.org/docs/coroutines-guide.html)

**Watch:**
* [Modern Android Development with AI Assistance](https://learning.oreilly.com/) – Relevant Android talks (links TBD)
* [Thinking in Compose](https://www.youtube.com/watch?v=SMOhl9RK0BA) – Leland Richardson (Google I/O)

**Practice Projects:**
* Complete the Now in Android exploration exercises using Cursor to understand Google's recommended architecture
* Apply Cursor to your own Android projects: try building new screens with Compose, refactoring ViewModels, or implementing new features with AI assistance
* Experiment with generating test data, preview parameters, and UI tests

---

**Course Schedule**

### Section 1: Cursor for Android Development (25 minutes)

**Presentation:** Using Cursor with Android Studio (Hybrid Workflow)
* Session 2 objectives and what we'll build today
* The hybrid workflow: Why you need BOTH tools
  * Android Studio: project setup, running, debugging, device management
  * Cursor: AI-powered code generation via Composer mode
  * Switching between tools: the efficient workflow
* Cursor Composer (Cmd/Ctrl+Shift+I): Multi-file code generation
  * Tagging @codebase for full context
  * Natural language instructions
  * Iterative development with AI
* Mobile-specific AI workflows: UI generation, architecture implementation, API integration

**Discussion:** What aspects of Android development take the most time in your current workflow? Where do you get stuck with Compose APIs or state management?

**Exercise:** Hybrid workflow setup
* Create a new Android project in Android Studio (or open provided starter)
* Open the same project folder in Cursor (File → Open Folder)
* In Cursor, open Composer mode (Cmd/Ctrl+Shift+I)
* Tag @codebase and prompt: "Explain the architecture of this Android app"
* Use Composer: "@codebase Create a simple Greeting composable with a Text and Button"
* Switch to Android Studio → Run app on emulator/device
* Verify the AI-generated composable works
* Practice: Cursor for code → Android Studio for testing

**Q&A**

---

### Section 2: Kotlin and Composables with AI Assistance (30 minutes)

**Presentation:** Accelerating Compose development with AI
* Generating Composables: stateless vs stateful components
* Material Design 3 integration: theming, colors, typography
* Using AI to explore Compose APIs and modifiers
* Preview functions and design iteration with AI
* Kotlin-specific patterns: data classes, sealed classes, extension functions
* State management fundamentals: remember, mutableStateOf, derivedStateOf

**Discussion:** How do you currently learn new Compose APIs? How could AI help you discover modifiers and components? When would you trust AI-generated UI code?

**Exercise:** Building UI components with AI
* Generate a TaskCard composable displaying task information
  * Use Material 3 Card, Text, and Icon components
  * Implement proper spacing and typography
  * Add modifiers for styling and layout
* Create multiple preview functions for different states (empty, loading, error)
  * Prompt: "Add preview functions showing TaskCard in different states"
* Generate a TaskList composable using LazyColumn
  * Implement proper item keys and content types
* Use Chat to understand: "Explain the difference between remember and rememberSaveable"
* Run and test: verify previews render correctly

**Q&A**

---

**5-Minute Break**

---

### Section 3: State Management and ViewModels (30 minutes)

**Presentation:** Modern Android architecture with AI
* MVVM pattern in Compose: ViewModel, UI State, Events
* Unidirectional data flow: state down, events up
* State hoisting: where to manage state in the composition tree
* Using AI to generate ViewModels with proper lifecycle handling
* Kotlin coroutines and Flow for async operations
* Repository pattern for data access

**Discussion:** How do you currently structure your ViewModels? What patterns help you manage complex UI state? How can AI assist with architecture decisions?

**Exercise:** Implementing state management
* Generate a TaskViewModel with UI state management
  * Prompt: "Create a TaskViewModel with StateFlow for a list of tasks, including loading and error states"
  * Implement add, update, delete operations
  * Use proper coroutine scopes (viewModelScope)
* Create a TaskUiState sealed interface/class for state representation
  * Prompt: "Generate a sealed interface for task list UI states: Loading, Success, Error"
* Connect ViewModel to Composable using collectAsStateWithLifecycle
* Generate a repository layer with mock data
  * Prompt: "Create a TaskRepository interface and fake implementation with delay to simulate network"
* Implement state hoisting for the TaskCard
* Test: add tasks, observe state updates, verify error handling

**Q&A**

---

### Section 4: Navigation and Multi-Screen Apps (25 minutes)

**Presentation:** Building complete apps with Compose Navigation
* Jetpack Navigation for Compose: NavController, NavHost, destinations
* Type-safe navigation with arguments
* Bottom navigation and navigation drawer patterns
* Using AI to generate navigation graphs and routes
* Deep linking and back stack management
* Passing data between screens

**Discussion:** How do you currently handle navigation in your apps? What challenges do you face with argument passing or complex navigation flows?

**Exercise:** Implementing app navigation
* Set up Navigation Compose with AI assistance
  * Prompt: "Add Jetpack Compose Navigation dependencies and create a navigation graph with home and detail screens"
* Create a sealed class for navigation routes
  * Prompt: "Generate a sealed class for navigation routes with type-safe arguments"
* Implement navigation from task list to task detail screen
  * Pass task ID as argument
  * Handle back navigation
* Add bottom navigation bar with multiple tabs
  * Prompt: "Create a bottom navigation bar with Home, Tasks, and Settings destinations"
* Generate a detail screen with edit functionality
  * Form inputs with state management
  * Save and cancel actions
* Test: navigate between screens, verify data persistence, test back stack

**Q&A**

---

### Section 5: Data Persistence and API Integration (25 minutes)

**Presentation:** Working with data in Android
* Room database integration with Jetpack Compose
* Using AI to generate Entity, DAO, and Database classes
* Retrofit for API calls: service interfaces and data models
* JSON parsing with kotlinx.serialization or Moshi
* Combining local and remote data sources
* Error handling and loading states in data layer

**Discussion:** How do you currently handle data persistence? What patterns work well for combining local and remote data? How can AI help with boilerplate data layer code?

**Exercise:** Implementing data persistence
* Use Agent to generate Room database setup
  * Prompt: "Create a Room database for Task entity with id, title, description, completed, and createdAt fields"
  * Generate TaskDao with CRUD operations and Flow queries
  * Create Database class with proper configuration
* Generate repository implementation using Room
  * Prompt: "Update TaskRepository to use TaskDao and return Flow for reactive updates"
* Add data serialization for API models
  * Prompt: "Create data transfer objects (DTOs) for Task API with kotlinx.serialization"
* Connect UI to Room database
  * Update ViewModel to use real repository
  * Observe Flow from Room in Composables
* Test: add tasks, verify persistence across app restarts

**Q&A**

---

### Section 6: Testing Android UIs with AI (20 minutes)

**Presentation:** AI-assisted testing for Compose
* Compose testing fundamentals: ComposeTestRule, semantics tree
* Unit testing ViewModels and state management
* UI testing with semantic properties and assertions
* Generating test data and preview parameters
* Screenshot testing considerations
* Testing navigation flows

**Discussion:** How much time do you spend writing UI tests? What makes Compose testing different from View-based testing? How can AI help generate comprehensive test coverage?

**Exercise:** Generating tests for Android components
* Use Agent to generate ViewModel tests
  * Prompt: "Generate unit tests for TaskViewModel using JUnit 5, Turbine for Flow testing, and MockK"
  * Test state transitions, loading states, error handling
  * Verify coroutine behavior
* Generate Compose UI tests
  * Prompt: "Create Compose UI tests for TaskCard using ComposeTestRule, verify text content and button clicks"
  * Test user interactions (click, swipe, input)
  * Verify state changes are reflected in UI
* Generate test data factories
  * Prompt: "Create a test factory for generating Task test data with various states"
* Run tests: `./gradlew test` and `./gradlew connectedAndroidTest`
* Review generated tests, discuss what to keep vs. modify

**Q&A**

---

### Section 7: Real-World Android Development Scenarios (25 minutes)

**Presentation:** Advanced patterns and production considerations
* Dependency injection with Hilt: generating modules and providing dependencies
* Using AI for performance optimization: recomposition, remember, derivedStateOf
* Accessibility with Compose: semantic properties and testing
* Handling configuration changes and process death
* Material Design 3 theming: dynamic colors, dark theme
* Code organization: multi-module projects

**Discussion:** What production concerns do you face that AI could help with? How do you ensure your Compose UIs are performant and accessible?

**Exercise:** Real-world enhancements
* Add Hilt dependency injection
  * Prompt: "Set up Hilt in this Android project and inject TaskRepository into TaskViewModel"
  * Generate Application class, modules, and ViewModelFactory
* Implement Material 3 theming
  * Prompt: "Create a Material 3 theme with custom color scheme and typography"
  * Add dark theme support
  * Apply theme throughout app
* Add accessibility improvements
  * Prompt: "Review TaskCard for accessibility and add semantic properties for screen readers"
  * Test with TalkBack or accessibility scanner
* Performance optimization with AI
  * Chat: "Review this Composable for unnecessary recompositions"
  * Apply suggested improvements (remember, derivedStateOf, keys)
* Generate documentation
  * Prompt: "Generate KDoc comments for TaskViewModel and all public functions"

**Q&A**

---

### Section 8: Exploring Now in Android (Optional/Homework)

**Presentation:** Learning from Google's sample app
* Now in Android overview: architecture, modularization, conventions
* Using Cursor to understand complex Compose applications
* Analyzing production patterns and best practices
* Code navigation strategies for large codebases
* Comparing your implementation to Google's recommendations

**Discussion:** What can we learn from analyzing production-quality sample apps?

**Exercise:** Now in Android exploration (homework)
* Clone Now in Android: `git clone https://github.com/android/nowinandroid`
* Use Chat mode to understand the architecture:
  * "Explain the module structure of this app"
  * "How is dependency injection implemented?"
  * "What testing strategies are used?"
* Compare patterns with your task app
* Extract learnings to apply to your projects

---

### Final Wrap-Up (10 minutes)

**Presentation:** Key takeaways and next steps
* Recap: From simple composables to complete Android app with persistence and navigation
* Decision framework: When to use AI assistance in mobile development
* Cursor vs Android Studio: hybrid workflow strategies
* Common pitfalls and how to avoid them
* Preview of Session 3: Advanced AI features

**Discussion:** What aspect of mobile development with AI surprised you most? Where will you apply these skills first?

**Final Q&A:** Open questions, debugging common issues, and recommendations for continued learning

---

### Instructor Information

Ken Kousen is the author of the Kotlin Cookbook (O'Reilly), Modern Java Recipes (O'Reilly), Gradle Recipes for Android (O'Reilly), and Making Java Groovy (Manning), as well as O'Reilly video courses in Android, Groovy, Gradle, advanced Java, and Spring. A JavaOne Rock Star, he's a regular speaker on the No Fluff Just Stuff conference tour and has spoken at conferences all over the world. Through his company, Kousen I.T., Inc., he's taught software development training courses to thousands of students.

**Instructor photo**

* In [Headshot Inbox](https://drive.google.com/drive/folders/1yA5MF0XrfJMm-8VSxPPL7DPor66f_BuJ?usp=sharing).

