# Session 2: Lab Exercises

**Using Cursor for Mobile Development (Android/Kotlin)**

## Table of Contents

### Part A: Code-Along Exercises (In-Class)
1. [Lab 0: Setup Verification](#lab-0-setup-verification)
2. [Lab 1: Creating Task Manager Project](#lab-1-creating-task-manager-project)
3. [Lab 2: Building Task UI Components](#lab-2-building-task-ui-components)
4. [Lab 3: State Management with ViewModels](#lab-3-state-management-with-viewmodels)
5. [Lab 4: Multi-Screen Navigation](#lab-4-multi-screen-navigation)
6. [Lab 5: Room Database Persistence](#lab-5-room-database-persistence)
7. [Lab 6: Testing ViewModels and UIs](#lab-6-testing-viewmodels-and-uis)
8. [Lab 7: Hilt DI and Polish](#lab-7-hilt-di-and-polish)

### Part B: Exploration Exercises (Homework/Practice)
9. [Lab 8: Now in Android Analysis](#lab-8-now-in-android-analysis)
10. [Lab 9: Advanced Features](#lab-9-advanced-features)
11. [Lab 10: Production Polish](#lab-10-production-polish)

---

## Part A: Code-Along Exercises (In-Class)

These exercises are designed to be completed during the session with instructor guidance. They demonstrate the hybrid workflow of using Cursor for code generation and Android Studio for running and testing.

---

## Lab 0: Setup Verification

**Goal:** Ensure both Android Studio and Cursor are properly configured  
**Time:** 5 minutes

### Prerequisites

- Cursor installed from [cursor.sh](https://cursor.sh)
- Android Studio installed from [developer.android.com/studio](https://developer.android.com/studio)
- Android SDK configured (API 34+)
- At least one Android emulator configured OR physical device available

### Steps

#### 1. Verify Android Studio

1. **Open Android Studio**

2. **Check SDK Installation:**
   - Tools → SDK Manager
   - Verify Android SDK is installed
   - Confirm at least one API level 34+ installed

3. **Check Emulator:**
   - Tools → Device Manager
   - Verify at least one AVD (Android Virtual Device) exists
   - Alternative: Connect physical device via USB

4. **Test Emulator/Device:**
   - Launch emulator or connect device
   - Verify it shows in device dropdown

#### 2. Verify Cursor

1. **Open Cursor**

2. **Verify Extensions** (Cmd/Ctrl+Shift+X)
   
   Install these if missing:
   - [ ] Kotlin (mathiasfrohlich.Kotlin or fwcd.kotlin)
   - [ ] Language Support for Java (Red Hat)
   - [ ] Gradle for Java (Microsoft)

3. **Test AI Modes**

   **Chat Mode (Cmd/Ctrl+L):**
   
   Type: 
   ```
   What is Jetpack Compose?
   ```
   
   Expected: Detailed explanation about declarative UI

   **Composer Mode (Cmd/Ctrl+Shift+I):**
   
   Type:
   ```
   Create a simple Kotlin data class for a User
   ```
   
   Expected: Multi-line editor with code generation offer

4. **Test Terminal** (``Ctrl+` ``)
   ```bash
   java -version
   ./gradlew -version  # (in an Android project)
   adb devices         # Should show connected devices
   ```

### Success Criteria

- ✅ Android Studio runs and shows SDK
- ✅ At least one emulator/device available
- ✅ Cursor opens and all extensions installed
- ✅ Chat mode responds to questions
- ✅ Composer mode opens and automatically checks codebase
- ✅ Terminal works and shows adb devices

---

## Lab 1: Creating Task Manager Project

**Goal:** Set up a new Android project and configure the hybrid workflow  
**Time:** 10 minutes  
**Mode:** Code-along with instructor

### Step 1: Create Project in Android Studio (5 min)

1. **Open Android Studio**

2. **Create New Project:**
   - Click "New Project"
   - Select **Empty Activity**
   - Click Next

3. **Configure Project:**
   - **Name:** Task Manager
   - **Package name:** com.example.taskmanager
   - **Save location:** Choose your preferred location
   - **Language:** Kotlin
   - **Minimum SDK:** API 24 (Android 7.0)
   - **Target SDK:** API 36 (Android 15+)
   - **Compile SDK:** API 36
   - **Build configuration language:** Kotlin DSL (build.gradle.kts)
   - **Java version:** Java 21 (will be configured in build.gradle.kts)
   - Click Finish

4. **After Project Creation, Update `app/build.gradle.kts`:**
   
   Add these configurations at the top level:
   
   ```kotlin
   // Configure Java Toolchain to use Java 21
   kotlin {
       jvmToolchain(21)
   }
   ```
   
   Then in the `android` block:
   
   ```kotlin
   android {
       compileSdk = 36
       
       defaultConfig {
           targetSdk = 36
           // ... other config
       }
       
       compileOptions {
           sourceCompatibility = JavaVersion.VERSION_21
           targetCompatibility = JavaVersion.VERSION_21
       }
       
       kotlinOptions {
           jvmTarget = "21"
       }
       
       testOptions {
           unitTests {
               all {
                   it.useJUnitPlatform()
               }
           }
       }
   }
   ```
   
   This ensures compatibility with the latest Android Gradle Plugin and Kotlin versions.

5. **Wait for Gradle Sync**
   - This may take 2-5 minutes
   - Watch for "Gradle build finished" message

6. **Run the Default App:**
   - Select your emulator/device from dropdown
   - Click Run button (green triangle) or press Shift+F10
   - Verify "Hello Android!" appears on screen

### Step 2: Open Project in Cursor (5 min)

1. **Open Cursor**

2. **Open the Project Folder:**
   - File → Open Folder (or Cmd/Ctrl+O)
   - Navigate to your Task Manager project folder
   - Click Open

3. **Verify Project Structure:**
   - See `app/` folder
   - See `build.gradle.kts` files
   - See `MainActivity.kt` in `app/src/main/java/com/example/taskmanager/`

4. **Test Composer Mode:**
   
   Open Composer (Cmd/Ctrl+Shift+I) and type:
   ```
   Explain the structure of this Android project
   ```
   
   Expected: AI describes MainActivity, Gradle files, manifest, etc.

5. **Test Simple Generation:**
   
   In Composer, type:
   ```
   Create a simple data class Task with properties:
   id (String), title (String), description (String), 
   completed (Boolean). Add default values.
   ```
   
   - Review the generated code
   - Accept the changes
   - Verify new file created

### Success Criteria

- ✅ Android project created and runs in Android Studio
- ✅ Same project opens successfully in Cursor
- ✅ Composer mode generates code using codebase context
- ✅ Can switch between Android Studio and Cursor
- ✅ Changes in Cursor appear in Android Studio (and vice versa)

### Troubleshooting

**Gradle Sync Fails:**
- Check internet connection
- File → Invalidate Caches / Restart
- Verify Java 21 is installed (required for latest Android Gradle Plugin)

**Emulator Won't Start:**
- Use physical device instead
- Tools → Device Manager → Cold Boot Now

**Cursor Can't Find Project:**
- Make sure you opened the root folder (contains `build.gradle.kts`)
- Restart Cursor

---

## Lab 2: Building Task UI Components

**Goal:** Create Jetpack Compose UI components with AI assistance  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Generate TaskCard Composable (10 min)

1. **In Cursor, open Composer** (Cmd/Ctrl+Shift+I)

2. **Prompt for TaskCard:**
   
   In Composer, type:
   ```
   Create a TaskCard composable in a new file ui/TaskCard.kt
   
   Requirements:
   - Display a task with title, description, and completion checkbox
   - Use Material 3 Card component
   - Include proper spacing and padding (16dp)
   - Use Material 3 typography (headlineSmall for title, bodyMedium for description)
   - Checkbox should be on the right side
   - Take Task data class and onToggleComplete callback as parameters
   - Add appropriate modifiers for layout
   ```

3. **Review Generated Code:**
   
   Expected structure:
   ```kotlin
   @Composable
   fun TaskCard(
       task: Task,
       onToggleComplete: (String) -> Unit,
       modifier: Modifier = Modifier
   ) {
       Card(
           modifier = modifier.fillMaxWidth(),
           elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
       ) {
           Row(
               modifier = Modifier
                   .padding(16.dp)
                   .fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.CenterVertically
           ) {
               Column(modifier = Modifier.weight(1f)) {
                   Text(
                       text = task.title,
                       style = MaterialTheme.typography.headlineSmall
                   )
                   if (task.description.isNotEmpty()) {
                       Text(
                           text = task.description,
                           style = MaterialTheme.typography.bodyMedium,
                           color = MaterialTheme.colorScheme.onSurfaceVariant
                       )
                   }
               }
               Checkbox(
                   checked = task.completed,
                   onCheckedChange = { onToggleComplete(task.id) }
               )
           }
       }
   }
   ```

4. **Accept the Changes**

### Step 2: Generate Preview Functions (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Add preview functions to TaskCard.kt showing:
   1. An uncompleted task with short text
   2. A completed task
   3. A task with long text that might overflow
   
   Use @Preview annotation and provide sample Task data
   ```

2. **Expected Preview Code:**
   ```kotlin
   @Preview(showBackground = true)
   @Composable
   fun TaskCardPreview() {
       TaskManagerTheme {
           TaskCard(
               task = Task(
                   id = "1",
                   title = "Complete Lab 2",
                   description = "Build UI components with Compose",
                   completed = false
               ),
               onToggleComplete = {}
           )
       }
   }
   
   @Preview(showBackground = true)
   @Composable
   fun TaskCardCompletedPreview() {
       TaskManagerTheme {
           TaskCard(
               task = Task(
                   id = "2",
                   title = "Setup Environment",
                   description = "Install Android Studio and Cursor",
                   completed = true
               ),
               onToggleComplete = {}
           )
       }
   }
   ```

3. **View Previews in Android Studio:**
   - Open `TaskCard.kt` in Android Studio
   - Look for preview pane on the right
   - Click "Split" or "Design" view
   - See your composable rendered

### Step 3: Generate TaskList with LazyColumn (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create a TaskList composable in ui/TaskList.kt
   
   Requirements:
   - Use LazyColumn to display a list of tasks
   - Each item should be a TaskCard
   - Include proper item keys for performance
   - Handle empty state with a message "No tasks yet"
   - Take tasks list and onToggleComplete callback
   - Add 8dp spacing between items
   ```

2. **Expected Code:**
   ```kotlin
   @Composable
   fun TaskList(
       tasks: List<Task>,
       onToggleComplete: (String) -> Unit,
       modifier: Modifier = Modifier
   ) {
       if (tasks.isEmpty()) {
           Box(
               modifier = modifier.fillMaxSize(),
               contentAlignment = Alignment.Center
           ) {
               Text(
                   text = "No tasks yet",
                   style = MaterialTheme.typography.bodyLarge,
                   color = MaterialTheme.colorScheme.onSurfaceVariant
               )
           }
       } else {
           LazyColumn(
               modifier = modifier,
               contentPadding = PaddingValues(16.dp),
               verticalArrangement = Arrangement.spacedBy(8.dp)
           ) {
               items(
                   items = tasks,
                   key = { task -> task.id }
               ) { task ->
                   TaskCard(
                       task = task,
                       onToggleComplete = onToggleComplete
                   )
               }
           }
       }
   }
   ```

3. **Add Preview with Sample Data:**
   
   In Composer, type:
   ```
   Add a preview for TaskList with 3-5 sample tasks
   ```

### Step 4: Test in Android Studio (2 min)

1. **Switch to Android Studio**

2. **Update MainActivity.kt to show TaskList:**
   
   You can do this manually or use Cursor Composer to type:
   ```
   Update MainActivity to display TaskList in the content
   area with sample tasks
   ```

3. **Run the app** (Shift+F10)

4. **Verify:**
   - See list of tasks
   - Tasks display properly
   - Checkboxes appear
   - Scroll works smoothly

### Success Criteria

- ✅ TaskCard composable created with Material 3 components
- ✅ Preview functions render correctly
- ✅ TaskList with LazyColumn works
- ✅ Empty state displays when no tasks
- ✅ App runs and shows task list in Android Studio

### Troubleshooting

**Preview not showing in Android Studio:**
- Make sure preview pane is visible (View → Tool Windows → Preview)
- Rebuild project (Build → Rebuild Project)
- Check that `@Preview` annotation is imported

**Compose not found:**
- Verify Compose dependencies in `build.gradle.kts`
- Sync Gradle files

---

## Lab 3: State Management with ViewModels

**Goal:** Implement MVVM architecture with StateFlow  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: Understand MVVM (5 min)

1. **In Cursor, use Chat Mode** (Cmd/Ctrl+L):
   
   Type:
   ```
   Explain the MVVM pattern for Android and how it applies 
   to Jetpack Compose. Include details about StateFlow and 
   unidirectional data flow.
   ```

2. **Read the explanation and discuss with instructor**

3. **Key Concepts:**
   - Model: Data and business logic
   - View: UI (Composables)
   - ViewModel: State holder and event handler
   - State flows down, events flow up

### Step 2: Generate UI State Classes (5 min)

1. **In Cursor Composer** (Cmd/Ctrl+Shift+I):
   
   Type:
   ```
   Create a TaskListUiState.kt file in the ui/state package
   
   Requirements:
   - Create a sealed interface TaskListUiState
   - Include three states: Loading, Success (with tasks list), Error (with message)
   - Use data objects and data classes appropriately
   - Add KDoc comments explaining each state
   ```

2. **Expected Code:**
   ```kotlin
   package com.example.taskmanager.ui.state
   
   import com.example.taskmanager.Task
   
   /**
    * Represents the UI state for the task list screen.
    */
   sealed interface TaskListUiState {
       /**
        * Loading state while tasks are being fetched.
        */
       data object Loading : TaskListUiState
       
       /**
        * Success state with the list of tasks.
        */
       data class Success(val tasks: List<Task>) : TaskListUiState
       
       /**
        * Error state with an error message.
        */
       data class Error(val message: String) : TaskListUiState
   }
   ```

3. **Accept the changes**

### Step 3: Generate TaskViewModel (10 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskViewModel.kt in the ui/viewmodel package
   
   Requirements:
   - Extend ViewModel from androidx.lifecycle
   - Use StateFlow<TaskListUiState> for UI state
   - Private MutableStateFlow, public StateFlow pattern
   - Include functions: addTask, deleteTask, toggleTaskCompletion, updateTask
   - Initialize with Loading state, then switch to Success with sample data
   - Use viewModelScope for coroutines
   - Add proper immutable state updates
   - Include KDoc comments
   ```

2. **Expected Code:**
   ```kotlin
   package com.example.taskmanager.ui.viewmodel
   
   import androidx.lifecycle.ViewModel
   import androidx.lifecycle.viewModelScope
   import com.example.taskmanager.Task
   import com.example.taskmanager.ui.state.TaskListUiState
   import kotlinx.coroutines.flow.MutableStateFlow
   import kotlinx.coroutines.flow.StateFlow
   import kotlinx.coroutines.flow.asStateFlow
   import kotlinx.coroutines.launch
   import java.util.UUID
   
   /**
    * ViewModel for managing task list state and operations.
    */
   class TaskViewModel : ViewModel() {
       
       private val _uiState = MutableStateFlow<TaskListUiState>(TaskListUiState.Loading)
       val uiState: StateFlow<TaskListUiState> = _uiState.asStateFlow()
       
       private val _tasks = mutableListOf<Task>()
       
       init {
           loadSampleTasks()
       }
       
       private fun loadSampleTasks() {
           viewModelScope.launch {
               _tasks.addAll(
                   listOf(
                       Task(
                           id = UUID.randomUUID().toString(),
                           title = "Complete Lab 3",
                           description = "Implement ViewModels and State Management",
                           completed = false
                       ),
                       Task(
                           id = UUID.randomUUID().toString(),
                           title = "Learn Jetpack Compose",
                           description = "Build modern UIs with declarative approach",
                           completed = true
                       )
                   )
               )
               _uiState.value = TaskListUiState.Success(_tasks.toList())
           }
       }
       
       /**
        * Adds a new task to the list.
        */
       fun addTask(title: String, description: String) {
           viewModelScope.launch {
               val newTask = Task(
                   id = UUID.randomUUID().toString(),
                   title = title,
                   description = description,
                   completed = false
               )
               _tasks.add(newTask)
               _uiState.value = TaskListUiState.Success(_tasks.toList())
           }
       }
       
       /**
        * Toggles the completion status of a task.
        */
       fun toggleTaskCompletion(taskId: String) {
           viewModelScope.launch {
               val index = _tasks.indexOfFirst { it.id == taskId }
               if (index != -1) {
                   _tasks[index] = _tasks[index].copy(completed = !_tasks[index].completed)
                   _uiState.value = TaskListUiState.Success(_tasks.toList())
               }
           }
       }
       
       /**
        * Deletes a task from the list.
        */
       fun deleteTask(taskId: String) {
           viewModelScope.launch {
               _tasks.removeIf { it.id == taskId }
               _uiState.value = TaskListUiState.Success(_tasks.toList())
           }
       }
       
    /**
     * Updates an existing task's properties.
     */
    fun updateTask(
        taskId: String,
        title: String? = null,
        description: String? = null,
        completed: Boolean? = null
    ) {
        viewModelScope.launch {
            val task = repository.getTaskById(taskId)
            if (task != null) {
                val updatedTask = task.copy(
                    title = title ?: task.title,
                    description = description ?: task.description,
                    completed = completed ?: task.completed
                )
                repository.updateTask(updatedTask)
            }
        }
    }
   }
   ```

3. **Add ViewModel dependencies to `build.gradle.kts`:**
   
   In Cursor Composer, type:
   ```
   Add the required ViewModel and lifecycle dependencies
   to app/build.gradle.kts if they're not already present
   ```

### Step 4: Connect ViewModel to UI (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update TaskList composable to accept a TaskViewModel
   and observe its uiState using collectAsStateWithLifecycle.
   Handle all three states: Loading (show CircularProgressIndicator),
   Success (show task list), Error (show error message).
   ```

2. **Expected Updated TaskList:**
   ```kotlin
   @Composable
   fun TaskList(
       viewModel: TaskViewModel = viewModel(),
       modifier: Modifier = Modifier
   ) {
       val uiState by viewModel.uiState.collectAsStateWithLifecycle()
       
       Box(modifier = modifier.fillMaxSize()) {
           when (val state = uiState) {
               is TaskListUiState.Loading -> {
                   CircularProgressIndicator(
                       modifier = Modifier.align(Alignment.Center)
                   )
               }
               is TaskListUiState.Success -> {
                   if (state.tasks.isEmpty()) {
                       Text(
                           text = "No tasks yet",
                           modifier = Modifier.align(Alignment.Center),
                           style = MaterialTheme.typography.bodyLarge
                       )
                   } else {
                       LazyColumn(
                           contentPadding = PaddingValues(16.dp),
                           verticalArrangement = Arrangement.spacedBy(8.dp)
                       ) {
                           items(
                               items = state.tasks,
                               key = { task -> task.id }
                           ) { task ->
                               TaskCard(
                                   task = task,
                                   onToggleComplete = { taskId ->
                                       viewModel.toggleTaskCompletion(taskId)
                                   }
                               )
                           }
                       }
                   }
               }
               is TaskListUiState.Error -> {
                   Column(
                       modifier = Modifier.align(Alignment.Center),
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Text(
                           text = "Error",
                           style = MaterialTheme.typography.headlineSmall,
                           color = MaterialTheme.colorScheme.error
                       )
                       Spacer(modifier = Modifier.height(8.dp))
                       Text(
                           text = state.message,
                           style = MaterialTheme.typography.bodyMedium
                       )
                   }
               }
           }
       }
   }
   ```

3. **Update MainActivity:**
   
   Type:
   ```
   Update MainActivity to use TaskList with ViewModel
   ```

### Step 5: Test State Management (2 min)

1. **Switch to Android Studio**

2. **Run the app** (Shift+F10)

3. **Test:**
   - See loading indicator briefly
   - See sample tasks appear
   - Click checkboxes to toggle completion
   - Verify UI updates immediately

4. **Verify state persistence:**
   - Toggle a few tasks
   - Rotate device/emulator (Ctrl+F11 / Ctrl+F12)
   - Tasks should maintain state (though won't persist across app restarts yet)

### Success Criteria

- ✅ Sealed interface for UI states created
- ✅ TaskViewModel manages state with StateFlow
- ✅ UI observes ViewModel state
- ✅ All three states (Loading, Success, Error) handled
- ✅ Toggling tasks updates UI immediately
- ✅ Immutable state updates working

### Troubleshooting

**StateFlow not found:**
- Add kotlinx-coroutines dependencies to gradle
- Sync project

**collectAsStateWithLifecycle not found:**
- Add lifecycle-runtime-compose dependency
- Import: `import androidx.lifecycle.compose.collectAsStateWithLifecycle`

**ViewModel crashes:**
- Check viewModelScope is used correctly
- Verify all state updates happen in viewModelScope.launch

---

## Lab 4: Multi-Screen Navigation

**Goal:** Implement navigation between Home and Detail screens  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Set Up Navigation (10 min)

1. **In Cursor Composer** (Cmd/Ctrl+Shift+I):
   
   Type:
   ```
   Set up Jetpack Compose Navigation:
   
   1. Add navigation-compose dependency to build.gradle.kts if not present
   2. Create a sealed class Route in navigation/Route.kt with:
      - HomeRoute object (no arguments)
      - TaskDetailRoute data class (takes taskId: String as argument)
   3. Include companion objects for route patterns
   ```

2. **Expected Route Code:**
   ```kotlin
   package com.example.taskmanager.navigation
   
   sealed class Route(val route: String) {
       object HomeRoute : Route(route = "home") {
           const val routePattern = "home"
       }
       
       data class TaskDetailRoute(val taskId: String) : Route(route = "task_detail/$taskId") {
           companion object {
               const val routePattern = "task_detail/{taskId}"
               
               fun createRoute(taskId: String) = "task_detail/$taskId"
           }
       }
   }
   ```

3. **Create NavHost:**
   
   Type:
   ```
   Create TaskNavHost.kt in navigation package:
   
   Requirements:
   - Create TaskNavHost composable taking NavHostController
   - Set Home as start destination
   - Define composable for Home route showing TaskListScreen
   - Define composable for TaskDetail route showing TaskDetailScreen
   - Pass navController to screens for navigation
   - Handle taskId argument from back stack entry
   ```

4. **Expected NavHost Code:**
   ```kotlin
   @Composable
   fun TaskNavHost(
       navController: NavHostController,
       modifier: Modifier = Modifier
   ) {
       NavHost(
           navController = navController,
           startDestination = Route.HomeRoute.route,
           modifier = modifier
       ) {
           composable(Route.HomeRoute.routePattern) {
               TaskListScreen(
                   navController = navController,
                   onTaskClick = { taskId ->
                       navController.navigate(Route.TaskDetailRoute.createRoute(taskId))
                   }
               )
           }
           
           composable(
               route = Route.TaskDetailRoute.routePattern,
               arguments = listOf(
                   navArgument("taskId") {
                       type = NavType.StringType
                   }
               )
           ) { backStackEntry ->
               val taskId = backStackEntry.arguments?.getString("taskId")
               TaskDetailScreen(
                   taskId = taskId,
                   onNavigateBack = {
                       navController.popBackStack()
                   }
               )
           }
       }
   }
   ```

### Step 2: Create TaskListScreen (3 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskListScreen.kt in ui/screen package:
   
   Requirements:
   - Scaffold with TopAppBar showing "Task Manager"
   - FloatingActionButton with "Add" icon (bottom-right)
   - TaskList in content area
   - Take NavController and onTaskClick callback for navigation
   - Show AlertDialog for adding new tasks (with title and description fields)
   - Wire up ViewModel using hiltViewModel()
   ```

2. **Expected Code:**
   ```kotlin
   @OptIn(ExperimentalMaterial3Api::class)
   @Composable
   fun TaskListScreen(
       navController: NavController,
       viewModel: TaskViewModel = hiltViewModel(),
       modifier: Modifier = Modifier
   ) {
       var showAddTaskDialog by remember { mutableStateOf(false) }
       var taskTitle by remember { mutableStateOf("") }
       var taskDescription by remember { mutableStateOf("") }

       Scaffold(
           topBar = {
               TopAppBar(
                   title = { Text("Task Manager") }
               )
           },
           floatingActionButton = {
               FloatingActionButton(
                   onClick = { showAddTaskDialog = true }
               ) {
                   Icon(Icons.Default.Add, contentDescription = "Add task")
               }
           },
           modifier = modifier
       ) { paddingValues ->
           TaskList(
               viewModel = viewModel,
               onTaskClick = { taskId ->
                   navController.navigate(Route.TaskDetailRoute.createRoute(taskId))
               },
               modifier = Modifier.padding(paddingValues)
           )
       }
       
       if (showAddTaskDialog) {
           AlertDialog(
               onDismissRequest = {
                   showAddTaskDialog = false
                   taskTitle = ""
                   taskDescription = ""
               },
               title = { Text("Add New Task") },
               text = {
                   Column(
                       modifier = Modifier.fillMaxWidth(),
                       verticalArrangement = Arrangement.spacedBy(16.dp)
                   ) {
                       OutlinedTextField(
                           value = taskTitle,
                           onValueChange = { taskTitle = it },
                           label = { Text("Title") },
                           modifier = Modifier.fillMaxWidth(),
                           singleLine = true
                       )
                       OutlinedTextField(
                           value = taskDescription,
                           onValueChange = { taskDescription = it },
                           label = { Text("Description") },
                           modifier = Modifier.fillMaxWidth().height(120.dp),
                           maxLines = 4
                       )
                   }
               },
               confirmButton = {
                   Button(
                       onClick = {
                           if (taskTitle.isNotBlank()) {
                               viewModel.addTask(taskTitle, taskDescription)
                               showAddTaskDialog = false
                               taskTitle = ""
                               taskDescription = ""
                           }
                       }
                   ) {
                       Text("Add")
                   }
               },
               dismissButton = {
                   TextButton(
                       onClick = {
                           showAddTaskDialog = false
                           taskTitle = ""
                           taskDescription = ""
                       }
                   ) {
                       Text("Cancel")
                   }
               }
           )
       }
   }
   ```

3. **Update TaskList to support onTaskClick:**
   
   Type:
   ```
   Update TaskList composable to take an onTaskClick callback
   and call it when a TaskCard is clicked
   ```

### Step 3: Create TaskDetailScreen (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskDetailScreen.kt in ui/screen package:
   
   Requirements:
   - Accept taskId and onNavigateBack callback
   - Use ViewModel to load task by ID
   - Show Scaffold with TopAppBar (back button and title)
   - Form with TextField for title and description
   - Checkbox for completion status
   - Save and Cancel buttons
   - Save updates task in ViewModel and navigates back
   - Cancel just navigates back
   ```

2. **Expected Code:**
   ```kotlin
   @OptIn(ExperimentalMaterial3Api::class)
   @Composable
   fun TaskDetailScreen(
       taskId: String?,
       onNavigateBack: () -> Unit,
       viewModel: TaskViewModel = viewModel(),
       modifier: Modifier = Modifier
   ) {
       val uiState by viewModel.uiState.collectAsStateWithLifecycle()
       
       val task = when (val state = uiState) {
           is TaskListUiState.Success -> {
               state.tasks.find { it.id == taskId }
           }
           else -> null
       }
       
       var title by remember(task) { mutableStateOf(task?.title ?: "") }
       var description by remember(task) { mutableStateOf(task?.description ?: "") }
       var completed by remember(task) { mutableStateOf(task?.completed ?: false) }
       
       Scaffold(
           topBar = {
               TopAppBar(
                   title = { Text("Task Details") },
                   navigationIcon = {
                       IconButton(onClick = onNavigateBack) {
                           Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
                       }
                   }
               )
           },
           modifier = modifier
       ) { paddingValues ->
           Column(
               modifier = Modifier
                   .padding(paddingValues)
                   .padding(16.dp)
                   .fillMaxSize(),
               verticalArrangement = Arrangement.spacedBy(16.dp)
           ) {
               OutlinedTextField(
                   value = title,
                   onValueChange = { title = it },
                   label = { Text("Title") },
                   modifier = Modifier.fillMaxWidth()
               )
               
               OutlinedTextField(
                   value = description,
                   onValueChange = { description = it },
                   label = { Text("Description") },
                   modifier = Modifier.fillMaxWidth(),
                   minLines = 3
               )
               
               Row(
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Checkbox(
                       checked = completed,
                       onCheckedChange = { completed = it }
                   )
                   Spacer(modifier = Modifier.width(8.dp))
                   Text("Completed")
               }
               
               Spacer(modifier = Modifier.weight(1f))
               
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                   OutlinedButton(
                       onClick = onNavigateBack,
                       modifier = Modifier.weight(1f)
                   ) {
                       Text("Cancel")
                   }
                   
                   Button(
                       onClick = {
                           taskId?.let { id ->
                               viewModel.updateTask(
                                   taskId = id,
                                   title = title,
                                   description = description,
                                   completed = completed
                               )
                           }
                           onNavigateBack()
                       },
                       modifier = Modifier.weight(1f)
                   ) {
                       Text("Save")
                   }
               }
           }
       }
   }
   ```

### Step 4: Update MainActivity (2 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update MainActivity to use rememberNavController
   and display TaskNavHost instead of TaskList directly
   ```

2. **Expected MainActivity:**
   ```kotlin
   @AndroidEntryPoint
   class MainActivity : ComponentActivity() {
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           enableEdgeToEdge()
           setContent {
               TaskManagerTheme {
                   MainContent()
               }
           }
       }
   }
   
   @Composable
   fun MainContent() {
       val navController = rememberNavController()
       TaskNavHost(navController = navController)
   }
   ```
   
   **Note:** The `@AndroidEntryPoint` annotation is required for Hilt (added in Lab 7). If you're building incrementally, you may add it later.

### Step 5: Test Navigation (1 min)

1. **Switch to Android Studio**

2. **Run the app** (Shift+F10)

3. **Test navigation flow:**
   - See task list
   - Click a task
   - Navigate to detail screen
   - See back arrow in toolbar
   - Edit task title/description
   - Toggle completion
   - Click Save
   - Return to list
   - Verify changes appear

4. **Test back navigation:**
   - Click a task
   - Click Cancel or back arrow
   - Verify no changes saved

### Success Criteria

- ✅ Navigation routes defined with sealed class
- ✅ NavHost configured with both routes
- ✅ TaskListScreen displays with FAB and TopAppBar
- ✅ Clicking task navigates to detail screen
- ✅ TaskDetailScreen shows task data
- ✅ Form allows editing task
- ✅ Save persists changes and navigates back
- ✅ Cancel navigates back without saving
- ✅ Back arrow works correctly

### Troubleshooting

**Navigation not found:**
- Add navigation-compose dependency
- Sync gradle

**Back arrow icon not found:**
- Import: `androidx.compose.material.icons.automirrored.filled.ArrowBack`
- Or use regular ArrowBack

**Task not loading in detail:**
- Check taskId is being passed correctly
- Verify ViewModel.updateTask() is implemented

---

## Lab 5: Room Database Persistence

**Goal:** Implement data persistence with Room database  
**Time:** 25 minutes  
**Mode:** Code-along with instructor

### Step 1: Add Room Dependencies (3 min)

1. **In Cursor Composer** (Cmd/Ctrl+Shift+I):
   
   Type:
   ```
   Add Room database dependencies using version catalog:
   
   Add to gradle/libs.versions.toml:
   - room version 2.8.3
   - Room runtime, ktx, and compiler libraries
   
   Then add to app/build.gradle.kts dependencies section:
   - implementation for room-runtime and room-ktx
   - ksp for room-compiler (KSP plugin should already be present)
   ```

2. **Expected additions to `gradle/libs.versions.toml`:**
   ```toml
   [versions]
   room = "2.8.3"
   
   [libraries]
   androidx-room-runtime = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
   androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }
   androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
   ```
   
   Then in `app/build.gradle.kts`:
   ```kotlin
   dependencies {
       // ... existing dependencies
       
       // Room
       implementation(libs.androidx.room.runtime)
       implementation(libs.androidx.room.ktx)
       ksp(libs.androidx.room.compiler)  // KSP instead of kapt
   }
   ```

3. **Sync Gradle in Android Studio**

### Step 2: Update Task as Entity (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update the existing Task data class to be a Room entity:
   
   Requirements:
   - Add @Entity annotation with tableName = "tasks"
   - Make id the primary key with @PrimaryKey
   - Add @ColumnInfo annotations with proper column names
   - Keep all existing properties
   - Add default value for id using UUID
   - Add timestamp for createdAt (Long, default to current time)
   ```

2. **Expected Updated Task:**
   ```kotlin
   package com.example.taskmanager.model
   
   import androidx.room.ColumnInfo
   import androidx.room.Entity
   import androidx.room.PrimaryKey
   import java.util.UUID
   
   @Entity(tableName = "tasks")
   data class Task(
       @PrimaryKey
       @ColumnInfo(name = "id")
       val id: String = UUID.randomUUID().toString(),
       
       @ColumnInfo(name = "title")
       val title: String = "",
       
       @ColumnInfo(name = "description")
       val description: String = "",
       
       @ColumnInfo(name = "completed")
       val completed: Boolean = false,
       
       @ColumnInfo(name = "created_at")
       val createdAt: Long = System.currentTimeMillis()
   )
   ```
   
   **Note:** Task is in the `model` package for better organization.

### Step 3: Create TaskDao (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskDao.kt interface in data/local package:
   
   Requirements:
   - Interface annotated with @Dao
   - getAllTasks(): Flow<List<Task>> - ordered by created_at DESC
   - getTaskById(taskId: String): Task? - suspend function
   - getTasksByCompletion(completed: Boolean): Flow<List<Task>>
   - insert(task: Task) - suspend function with REPLACE conflict strategy
   - update(task: Task) - suspend function
   - delete(task: Task) - suspend function
   - Use appropriate @Query, @Insert, @Update, @Delete annotations
   ```

2. **Expected TaskDao:**
   ```kotlin
   package com.example.taskmanager.data.local
   
   import androidx.room.Dao
   import androidx.room.Delete
   import androidx.room.Insert
   import androidx.room.OnConflictStrategy
   import androidx.room.Query
   import androidx.room.Update
   import com.example.taskmanager.Task
   import kotlinx.coroutines.flow.Flow
   
   @Dao
   interface TaskDao {
       
       @Query("SELECT * FROM tasks ORDER BY created_at DESC")
       fun getAllTasks(): Flow<List<Task>>
       
       @Query("SELECT * FROM tasks WHERE id = :taskId")
       suspend fun getTaskById(taskId: String): Task?
       
       @Query("SELECT * FROM tasks WHERE completed = :completed ORDER BY created_at DESC")
       fun getTasksByCompletion(completed: Boolean): Flow<List<Task>>
       
       @Insert(onConflict = OnConflictStrategy.REPLACE)
       suspend fun insert(task: Task)
       
       @Update
       suspend fun update(task: Task)
       
       @Delete
       suspend fun delete(task: Task)
   }
   ```

### Step 4: Create AppDatabase (3 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create AppDatabase.kt in data/local package:
   
   Requirements:
   - Abstract class extending RoomDatabase
   - @Database annotation with Task entity, version 1
   - exportSchema = false for demo
   - Abstract function to get TaskDao
   - Singleton pattern with companion object
   - getInstance(context) returning database instance
   - Use fallbackToDestructiveMigration(dropAllTables = true) for demo purposes
   ```

2. **Expected AppDatabase:**
   ```kotlin
   package com.example.taskmanager.data.local
   
   import android.content.Context
   import androidx.room.Database
   import androidx.room.Room
   import androidx.room.RoomDatabase
   import com.example.taskmanager.Task
   
   @Database(
       entities = [Task::class],
       version = 1,
       exportSchema = false
   )
   abstract class AppDatabase : RoomDatabase() {
       
       abstract fun taskDao(): TaskDao
       
       companion object {
           @Volatile
           private var INSTANCE: AppDatabase? = null
           
           fun getInstance(context: Context): AppDatabase {
               return INSTANCE ?: synchronized(this) {
                   val instance = Room.databaseBuilder(
                       context.applicationContext,
                       AppDatabase::class.java,
                       "task_database"
                   )
                   .fallbackToDestructiveMigration(dropAllTables = true)
                   .build()
                   INSTANCE = instance
                   instance
               }
           }
       }
   }
   ```

### Step 5: Create Repository (4 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskRepository.kt in data/repository package:
   
   Requirements:
   - Class taking TaskDao as constructor parameter
   - Expose Flow<List<Task>> for all tasks
   - Suspend functions for: insertTask, updateTask, deleteTask, getTaskById
   - Simply delegate to DAO methods
   - Add KDoc comments
   ```

2. **Expected TaskRepository:**
   ```kotlin
   package com.example.taskmanager.data.repository
   
   import com.example.taskmanager.Task
   import com.example.taskmanager.data.local.TaskDao
   import kotlinx.coroutines.flow.Flow
   
   /**
    * Repository for managing task data operations.
    * Provides a clean API for data access.
    */
   class TaskRepository(private val taskDao: TaskDao) {
       
       /**
        * Flow of all tasks, ordered by creation date (newest first).
        */
       val allTasks: Flow<List<Task>> = taskDao.getAllTasks()
       
       /**
        * Gets a specific task by ID.
        */
       suspend fun getTaskById(taskId: String): Task? {
           return taskDao.getTaskById(taskId)
       }
       
       /**
        * Gets tasks filtered by completion status.
        */
       fun getTasksByCompletion(completed: Boolean): Flow<List<Task>> {
           return taskDao.getTasksByCompletion(completed)
       }
       
       /**
        * Inserts a new task or replaces if exists.
        */
       suspend fun insertTask(task: Task) {
           taskDao.insert(task)
       }
       
       /**
        * Updates an existing task.
        */
       suspend fun updateTask(task: Task) {
           taskDao.update(task)
       }
       
       /**
        * Deletes a task.
        */
       suspend fun deleteTask(task: Task) {
           taskDao.delete(task)
       }
   }
   ```

### Step 6: Update ViewModel to Use Repository (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update TaskViewModel to use TaskRepository:
   
   Requirements:
   - Accept TaskRepository in constructor (will need context temporarily)
   - Remove sample data initialization
   - Collect repository.allTasks Flow and map to UI state
   - Update all methods to call repository instead of local list
   - Use viewModelScope for coroutine launches
   - Handle exceptions with try-catch and Error state
   ```

2. **Expected Updated ViewModel:**
   ```kotlin
   class TaskViewModel(
       private val repository: TaskRepository
   ) : ViewModel() {
       
       private val _uiState = MutableStateFlow<TaskListUiState>(TaskListUiState.Loading)
       val uiState: StateFlow<TaskListUiState> = _uiState.asStateFlow()
       
       init {
           loadTasks()
       }
       
       private fun loadTasks() {
           viewModelScope.launch {
               repository.allTasks
                   .onStart {
                       _uiState.value = TaskListUiState.Loading
                   }
                   .catch { exception ->
                       _uiState.value = TaskListUiState.Error(
                           message = exception.message ?: "Failed to load tasks"
                       )
                   }
                   .collect { tasks ->
                       _uiState.value = TaskListUiState.Success(tasks = tasks)
                   }
           }
       }
       
       fun addTask(title: String, description: String) {
           viewModelScope.launch {
               try {
                   val task = Task(
                       title = title,
                       description = description
                   )
                   repository.insertTask(task)
               } catch (e: Exception) {
                   _uiState.value = TaskListUiState.Error(
                       "Failed to add task: ${e.message}"
                   )
               }
           }
       }
       
       fun toggleTaskCompletion(taskId: String) {
           viewModelScope.launch {
               try {
                   val task = repository.getTaskById(taskId)
                   task?.let {
                       repository.updateTask(it.copy(completed = !it.completed))
                   }
               } catch (e: Exception) {
                   _uiState.value = TaskListUiState.Error(
                       "Failed to update task: ${e.message}"
                   )
               }
           }
       }
       
       fun updateTask(
           taskId: String,
           title: String? = null,
           description: String? = null,
           completed: Boolean? = null
       ) {
           viewModelScope.launch {
               try {
                   val task = repository.getTaskById(taskId)
                   if (task != null) {
                       val updatedTask = task.copy(
                           title = title ?: task.title,
                           description = description ?: task.description,
                           completed = completed ?: task.completed
                       )
                       repository.updateTask(updatedTask)
                   }
               } catch (e: Exception) {
                   _uiState.value = TaskListUiState.Error(
                       "Failed to update task: ${e.message}"
                   )
               }
           }
       }
       
       fun deleteTask(taskId: String) {
           viewModelScope.launch {
               try {
                   val task = repository.getTaskById(taskId)
                   task?.let { repository.deleteTask(it) }
               } catch (e: Exception) {
                   _uiState.value = TaskListUiState.Error(
                       "Failed to delete task: ${e.message}"
                   )
               }
           }
       }
   }
   ```

3. **Note:** In Lab 7, we'll use Hilt for dependency injection, which eliminates the need for ViewModelFactory. For now, you can create a simple factory, or wait until Lab 7.

### Step 7: Wire Up in UI (2 min)

1. **Update composables to use factory:**
   
   In Cursor Composer, type:
   ```
   Update TaskListScreen and TaskDetailScreen to use
   TaskViewModelFactory to create ViewModel with repository
   ```

2. **In Android Studio, build the project:**
   - Build → Rebuild Project
   - Fix any import errors

### Step 8: Test Persistence (2 min)

1. **Run the app in Android Studio** (Shift+F10)

2. **Test persistence:**
   - Add several new tasks
   - Toggle some as completed
   - Edit a task's details
   - **Force stop the app** (not just background it)
   - Reopen the app
   - **Verify all tasks are still there** ✅

3. **Test data integrity:**
   - Tasks appear in correct order (newest first)
   - Completed status persists
   - Edited content persists
   - No duplicate tasks

### Success Criteria

- ✅ Room dependencies added
- ✅ Task entity with proper annotations
- ✅ TaskDao with all CRUD operations
- ✅ AppDatabase created with singleton pattern
- ✅ TaskRepository wraps DAO
- ✅ TaskViewModel uses repository
- ✅ Data persists across app restarts
- ✅ All CRUD operations work correctly

### Troubleshooting

**KSP not found:**
- Make sure `ksp` plugin is added (not kapt)
- Verify KSP plugin in project-level `build.gradle.kts`
- Sync gradle

**Database not created:**
- Check Room dependencies version
- Verify @Entity, @Dao, @Database annotations
- Check database name doesn't have typos

**Tasks not persisting:**
- Verify you're force-stopping the app (not just backgrounding)
- Check repository methods are called correctly
- Look for exceptions in Logcat

**ViewModel needs context:**
- For now, use factory pattern
- In Lab 7, we'll switch to Hilt DI

---

## Lab 6: Testing ViewModels and UIs

**Goal:** Generate and run tests for Android components  
**Time:** 20 minutes  
**Mode:** Code-along with instructor

### Step 1: Add Test Dependencies (3 min)

1. **In Cursor Composer** (Cmd/Ctrl+Shift+I):
   
   Type:
   ```
   Add testing dependencies using version catalog:
   
   Add to gradle/libs.versions.toml:
   - JUnit Jupiter 6.0.1
   - MockK 1.14.6
   - Turbine 1.2.1
   - Coroutines test 1.10.2
   - Compose UI test 1.9.4
   - Espresso 3.7.0
   
   Then add to app/build.gradle.kts dependencies section
   ```

2. **Expected additions to `gradle/libs.versions.toml`:**
   ```toml
   [versions]
   junitJupiter = "6.0.1"
   mockk = "1.14.6"
   turbine = "1.2.1"
   coroutinesTest = "1.10.2"
   composeUiTest = "1.9.4"
   espressoCore = "3.7.0"
   junitVersion = "1.3.0"
   
   [libraries]
   junit-jupiter-api = { group = "org.junit.jupiter", name = "junit-jupiter-api", version.ref = "junitJupiter" }
   junit-jupiter-engine = { group = "org.junit.jupiter", name = "junit-jupiter-engine", version.ref = "junitJupiter" }
   mockk = { group = "io.mockk", name = "mockk", version.ref = "mockk" }
   turbine = { group = "app.cash.turbine", name = "turbine", version.ref = "turbine" }
   kotlinx-coroutines-test = { group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-test", version.ref = "coroutinesTest" }
   androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
   androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
   androidx-compose-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4", version.ref = "composeUiTest" }
   androidx-compose-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest", version.ref = "composeUiTest" }
   ```
   
   Then in `app/build.gradle.kts`:
   ```kotlin
   dependencies {
       // Unit testing
       testImplementation(libs.junit.jupiter.api)
       testRuntimeOnly(libs.junit.jupiter.engine)
       testImplementation(libs.mockk)
       testImplementation(libs.turbine)
       testImplementation(libs.kotlinx.coroutines.test)
       
       // Instrumented testing
       androidTestImplementation(libs.androidx.junit)
       androidTestImplementation(libs.androidx.espresso.core)
       androidTestImplementation(platform(libs.androidx.compose.bom))
       androidTestImplementation(libs.androidx.compose.ui.test.junit4)
       androidTestImplementation(libs.androidx.compose.ui.test)
       debugImplementation(libs.androidx.compose.ui.test.manifest)
   }
   
   testOptions {
       unitTests {
           all {
               it.useJUnitPlatform()
           }
       }
   }
   ```

3. **Sync Gradle in Android Studio**

### Step 2: Generate ViewModel Tests (10 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskViewModelTest.kt in test directory
   (src/test/java/com/example/taskmanager/):
   
   Requirements:
   - Test class for TaskViewModel
   - Use JUnit 5 (@Test, @BeforeEach)
   - Mock TaskRepository with MockK
   - Use TestDispatcher for coroutines
   - Use Turbine for Flow testing
   - Test cases:
     1. Initial state is Loading then Success with empty list
     2. addTask updates state with new task
     3. toggleTaskCompletion updates task completion status
     4. updateTask updates task in repository
     5. deleteTask removes task from list
   - Include setup and teardown
   ```

2. **Expected Test Code:**
   ```kotlin
   package com.example.taskmanager
   
   import app.cash.turbine.test
   import com.example.taskmanager.data.repository.TaskRepository
   import com.example.taskmanager.ui.state.TaskListUiState
   import com.example.taskmanager.ui.viewmodel.TaskViewModel
   import io.mockk.*
   import kotlinx.coroutines.Dispatchers
   import kotlinx.coroutines.ExperimentalCoroutinesApi
   import kotlinx.coroutines.flow.flowOf
   import kotlinx.coroutines.test.*
   import org.junit.jupiter.api.AfterEach
   import org.junit.jupiter.api.BeforeEach
   import org.junit.jupiter.api.Test
   import kotlin.test.assertEquals
   import kotlin.test.assertTrue
   
   @OptIn(ExperimentalCoroutinesApi::class)
   class TaskViewModelTest {
       
       @MockK
       private lateinit var repository: TaskRepository
       
       private lateinit var testDispatcher: TestDispatcher
       private lateinit var viewModel: TaskViewModel
       
       @BeforeEach
       fun setup() {
           MockKAnnotations.init(this)
           testDispatcher = UnconfinedTestDispatcher()
           Dispatchers.setMain(testDispatcher)
           
           // Default: repository returns empty list flow
           val tasksFlow = MutableStateFlow<List<Task>>(emptyList())
           every { repository.getAllTasks() } returns tasksFlow
       }
       
       @AfterEach
       fun tearDown() {
           Dispatchers.resetMain()
           unmockkAll()
       }
       
       @Test
       fun `initial state is Loading then Success with empty list`() = runTest(testDispatcher) {
           // When
           viewModel = TaskViewModel(repository)
           advanceUntilIdle()
           
           // Then
           viewModel.uiState.test {
               // First state might be Loading or Success depending on timing
               val firstState = awaitItem()
               if (firstState is TaskListUiState.Loading) {
                   val successState = awaitItem()
                   assertInstanceOf(TaskListUiState.Success::class.java, successState)
                   val success = successState as TaskListUiState.Success
                   assertTrue(success.tasks.isEmpty())
               } else {
                   assertInstanceOf(TaskListUiState.Success::class.java, firstState)
                   val success = firstState as TaskListUiState.Success
                   assertTrue(success.tasks.isEmpty())
               }
               cancel()
           }
       }
       
       @Test
       fun `addTask inserts task into repository`() = runTest(testDispatcher) {
           // Given
           val tasksFlow = MutableStateFlow<List<Task>>(emptyList())
           every { repository.getAllTasks() } returns tasksFlow
           coEvery { repository.insertTask(any()) } coAnswers {
               val task = firstArg<Task>()
               tasksFlow.value = tasksFlow.value + task
           }
           
           viewModel = TaskViewModel(repository)
           advanceUntilIdle()
           
           // When
           val newTaskTitle = "New Task"
           val newTaskDescription = "Task description"
           viewModel.addTask(newTaskTitle, newTaskDescription)
           advanceUntilIdle()
           
           // Then
           coVerify { repository.insertTask(any()) }
           viewModel.uiState.test {
               val successState = awaitItem()
               assertInstanceOf(TaskListUiState.Success::class.java, successState)
               val success = successState as TaskListUiState.Success
               assertEquals(1, success.tasks.size)
               assertEquals(newTaskTitle, success.tasks[0].title)
               assertEquals(newTaskDescription, success.tasks[0].description)
               cancel()
           }
       }
       
       @Test
       fun `toggleTaskCompletion updates task in repository`() = runTest {
           // Given
           val task = Task(id = "1", title = "Task", completed = false)
           coEvery { repository.getTaskById("1") } returns task
           coEvery { repository.updateTask(any()) } just Runs
           
           // When
           viewModel.toggleTaskCompletion("1")
           advanceUntilIdle()
           
           // Then
           coVerify { 
               repository.updateTask(match { it.id == "1" && it.completed == true })
           }
       }
       
       @Test
       fun `updateTask calls repository with updated task`() = runTest {
           // Given
           val task = Task(id = "1", title = "Updated Title")
           coEvery { repository.updateTask(any()) } just Runs
           
           // When
           viewModel.updateTask(task)
           advanceUntilIdle()
           
           // Then
           coVerify { repository.updateTask(task) }
       }
       
       @Test
       fun `deleteTask removes task from repository`() = runTest {
           // Given
           val task = Task(id = "1", title = "Task to delete")
           coEvery { repository.getTaskById("1") } returns task
           coEvery { repository.deleteTask(any()) } just Runs
           
           // When
           viewModel.deleteTask("1")
           advanceUntilIdle()
           
           // Then
           coVerify { repository.deleteTask(task) }
       }
   }
   ```

### Step 3: Run Unit Tests (2 min)

1. **In Android Studio:**
   - Right-click on `TaskViewModelTest`
   - Select "Run 'TaskViewModelTest'"

2. **Or use terminal:**
   ```bash
   ./gradlew test
   ```

3. **Verify all tests pass** ✅

4. **If tests fail:**
   - Use Chat mode in Cursor: "Why is my test failing?" (paste error)
   - Fix issues and rerun

### Step 4: Generate Compose UI Tests (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskCardTest.kt in androidTest directory
   (src/androidTest/java/com/example/taskmanager/):
   
   Requirements:
   - Test class for TaskCard composable
   - Use @get:Rule with createComposeRule()
   - Test cases:
     1. TaskCard displays task title and description
     2. Checkbox reflects completed state (checked/unchecked)
     3. Clicking checkbox triggers onToggleComplete callback
   - Use appropriate semantic properties and test tags
   - Use setContent { } to render composable
   - Use onNodeWithText, onNodeWithContentDescription, etc.
   ```

2. **Expected Test Code:**
   ```kotlin
   package com.example.taskmanager
   
   import androidx.compose.ui.test.*
   import androidx.compose.ui.test.junit4.createComposeRule
   import com.example.taskmanager.ui.TaskCard
   import com.example.taskmanager.ui.theme.TaskManagerTheme
   import org.junit.Rule
   import org.junit.Test
   
   class TaskCardTest {
       
       @get:Rule
       val composeTestRule = createComposeRule()
       
       @Test
       fun taskCard_displaysTaskInformation() {
           // Given
           val task = Task(
               id = "1",
               title = "Test Task",
               description = "Test Description",
               completed = false
           )
           
           // When
           composeTestRule.setContent {
               TaskManagerTheme {
                   TaskCard(
                       task = task,
                       onToggleComplete = {}
                   )
               }
           }
           
           // Then
           composeTestRule.onNodeWithText("Test Task").assertIsDisplayed()
           composeTestRule.onNodeWithText("Test Description").assertIsDisplayed()
       }
       
       @Test
       fun taskCard_checkboxReflectsCompletedState_unchecked() {
           // Given
           val task = Task(title = "Task", completed = false)
           
           // When
           composeTestRule.setContent {
               TaskManagerTheme {
                   TaskCard(task = task, onToggleComplete = {})
               }
           }
           
           // Then
           composeTestRule.onNode(
               hasContentDescription("Task completion")
           ).assertIsOff()
       }
       
       @Test
       fun taskCard_checkboxReflectsCompletedState_checked() {
           // Given
           val task = Task(title = "Task", completed = true)
           
           // When
           composeTestRule.setContent {
               TaskManagerTheme {
                   TaskCard(task = task, onToggleComplete = {})
               }
           }
           
           // Then
           composeTestRule.onNode(
               hasContentDescription("Task completion")
           ).assertIsOn()
       }
       
       @Test
       fun taskCard_clickingCheckbox_triggersCallback() {
           // Given
           val task = Task(id = "1", title = "Task", completed = false)
           var callbackTriggered = false
           var callbackTaskId = ""
           
           // When
           composeTestRule.setContent {
               TaskManagerTheme {
                   TaskCard(
                       task = task,
                       onToggleComplete = { id ->
                           callbackTriggered = true
                           callbackTaskId = id
                       }
                   )
               }
           }
           
           composeTestRule.onNode(
               hasContentDescription("Task completion")
           ).performClick()
           
           // Then
           assert(callbackTriggered)
           assert(callbackTaskId == "1")
       }
   }
   ```

3. **Update TaskCard to add contentDescription:**
   
   In Cursor Composer, type:
   ```
   Add semantics to TaskCard Checkbox:
   set contentDescription = "Task completion" for accessibility
   ```

### Step 5: Run UI Tests (2 min)

1. **Make sure emulator/device is running**

2. **In Android Studio:**
   - Right-click on `TaskCardTest`
   - Select "Run 'TaskCardTest'"

3. **Or use terminal:**
   ```bash
   ./gradlew connectedAndroidTest
   ```

4. **Watch tests run on device:**
   - See composable appear briefly
   - Tests execute automatically
   - Verify all pass ✅

### Success Criteria

- ✅ Test dependencies added
- ✅ ViewModel unit tests created
- ✅ All unit tests pass (`./gradlew test`)
- ✅ Compose UI tests created
- ✅ UI tests pass on device (`./gradlew connectedAndroidTest`)
- ✅ Tests cover main functionality

### Troubleshooting

**JUnit 5 not working:**
- Make sure you have both jupiter-api and jupiter-engine
- May need to add: `tasks.withType<Test> { useJUnitPlatform() }`

**MockK errors:**
- Verify version compatibility
- Use `relaxed = true` for simple mocks

**Compose test not finding nodes:**
- Check semantic properties are set
- Use `printToLog("TAG")` to see semantic tree
- Verify text/contentDescription matches exactly

**UI tests won't run:**
- Ensure device is connected and unlocked
- Check `debugImplementation("androidx.compose.ui:ui-test-manifest")` is added
- Clean and rebuild project

---

## Lab 7: Hilt DI and Polish

**Goal:** Add dependency injection and polish the app  
**Time:** 15 minutes  
**Mode:** Code-along with instructor

### Step 1: Add Hilt Dependencies (3 min)

1. **In Cursor Composer** (Cmd/Ctrl+Shift+I):
   
   Type:
   ```
   Add Hilt dependency injection using version catalog:
   
   Add to gradle/libs.versions.toml:
   - Hilt version 2.57.2
   - Hilt navigation compose 1.3.0
   - Hilt plugin and libraries
   
   Add Hilt plugin to project and app build.gradle.kts
   Add Hilt dependencies to app/build.gradle.kts
   ```

2. **Expected additions to `gradle/libs.versions.toml`:**
   ```toml
   [versions]
   hilt = "2.57.2"
   hiltNavigationCompose = "1.3.0"
   
   [libraries]
   hilt-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
   hilt-compiler = { group = "com.google.dagger", name = "hilt-compiler", version.ref = "hilt" }
   hilt-navigation-compose = { group = "androidx.hilt", name = "hilt-navigation-compose", version.ref = "hiltNavigationCompose" }
   
   [plugins]
   hilt-android = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
   ```
   
   **Project-level `build.gradle.kts`:**
   ```kotlin
   plugins {
       alias(libs.plugins.hilt.android) apply false
   }
   ```
   
   **App-level `build.gradle.kts`:**
   ```kotlin
   plugins {
       // ... existing plugins
       alias(libs.plugins.hilt.android)
       alias(libs.plugins.ksp)  // KSP for Hilt compiler (should already be present)
   }
   
   dependencies {
       // Hilt
       implementation(libs.hilt.android)
       ksp(libs.hilt.compiler)  // KSP instead of kapt
       implementation(libs.hilt.navigation.compose)
   }
   ```

3. **Sync Gradle in Android Studio**

### Step 2: Create Application Class (2 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create TaskApplication.kt in the root package:
   
   Requirements:
   - Extend Application class
   - Annotate with @HiltAndroidApp
   - No other code needed
   ```

2. **Expected Code:**
   ```kotlin
   package com.example.taskmanager
   
   import android.app.Application
   import dagger.hilt.android.HiltAndroidApp
   
   @HiltAndroidApp
   class TaskApplication : Application()
   ```

3. **Update AndroidManifest.xml:**
   
   Type:
   ```
   Add android:name=".TaskApplication" to the
   <application> tag in AndroidManifest.xml
   ```

### Step 3: Create Hilt Modules (5 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Create DatabaseModule.kt in di package:
   
   Requirements:
   - @Module and @InstallIn(SingletonComponent::class)
   - Provide AppDatabase singleton taking @ApplicationContext
   - Provide TaskDao from database
   - Provide TaskRepository taking TaskDao
   - All providers should be @Singleton where appropriate
   ```

2. **Expected Module:**
   ```kotlin
   package com.example.taskmanager.di
   
   import android.content.Context
   import androidx.room.Room
   import com.example.taskmanager.data.local.AppDatabase
   import com.example.taskmanager.data.local.TaskDao
   import com.example.taskmanager.data.repository.TaskRepository
   import dagger.Module
   import dagger.Provides
   import dagger.hilt.InstallIn
   import dagger.hilt.android.qualifiers.ApplicationContext
   import dagger.hilt.components.SingletonComponent
   import javax.inject.Singleton
   
   @Module
   @InstallIn(SingletonComponent::class)
   object DatabaseModule {
       
       @Provides
       @Singleton
       fun provideDatabase(
           @ApplicationContext context: Context
       ): AppDatabase {
           return Room.databaseBuilder(
               context,
               AppDatabase::class.java,
               "task_database"
           )
           .fallbackToDestructiveMigration(dropAllTables = true)
           .build()
       }
       
       @Provides
       fun provideTaskDao(database: AppDatabase): TaskDao {
           return database.taskDao()
       }
       
       @Provides
       @Singleton
       fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
           return TaskRepository(taskDao)
       }
   }
   ```

### Step 4: Update ViewModel for Hilt (2 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update TaskViewModel to use Hilt:
   
   Requirements:
   - Add @HiltViewModel annotation
   - Add @Inject constructor annotation
   - Keep TaskRepository parameter
   - Remove ViewModelFactory (no longer needed)
   ```

2. **Expected Updated ViewModel:**
   ```kotlin
   @HiltViewModel
   class TaskViewModel @Inject constructor(
       private val repository: TaskRepository
   ) : ViewModel() {
       // ... rest of code stays the same
   }
   ```

3. **Update MainActivity:**
   
   Type:
   ```
   Add @AndroidEntryPoint annotation to MainActivity
   ```

### Step 5: Update Composables (1 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update all screens to use hiltViewModel() instead
   of viewModel() or custom factory:
   
   - TaskListScreen
   - TaskDetailScreen
   - Any other screens using ViewModel
   
   Import: androidx.hilt.navigation.compose.hiltViewModel
   ```

2. **Example:**
   ```kotlin
   @Composable
   fun TaskListScreen(
       viewModel: TaskViewModel = hiltViewModel(), // Changed from viewModel()
       // ...
   ) {
       // ...
   }
   ```

### Step 6: Material 3 Theming (2 min)

1. **In Cursor Composer:**
   
   Type:
   ```
   Update the theme in ui/theme/Theme.kt:
   
   Requirements:
   - Update color scheme to use purple as primary color
   - Support both light and dark themes
   - Use dynamic colors on Android 12+ if available
   - Fallback to custom colors on older versions
   ```

2. **Test dark theme:**
   - Run app in Android Studio
   - Open device settings → Display → Dark theme
   - Toggle and see app update
   - Or use quick settings to toggle

### Step 7: Test Everything (2 min)

1. **Clean and rebuild in Android Studio:**
   
   Type:
   ```
   Build → Clean Project
   Build → Rebuild Project
   ```

2. **Run the app** (Shift+F10)

3. **Verify:**
   - App launches successfully
   - Tasks load from database
   - Add, edit, delete tasks works
   - Navigation works
   - Dark theme works
   - No crashes

4. **Test DI is working:**
   - Add a task
   - Force stop app
   - Reopen
   - Task persists (confirms Room injection works)

### Success Criteria

- ✅ Hilt dependencies added
- ✅ Application class with @HiltAndroidApp
- ✅ Hilt modules provide dependencies
- ✅ ViewModel uses @HiltViewModel with @Inject
- ✅ MainActivity has @AndroidEntryPoint
- ✅ Composables use hiltViewModel()
- ✅ App builds and runs without errors
- ✅ All features still work
- ✅ Material 3 theme with dark mode support

### Troubleshooting

**Hilt annotation processor errors:**
- Make sure KSP plugin is applied (not kapt)
- Verify `ksp(libs.hilt.compiler)` is added
- Clean and rebuild project
- Check that KSP version matches Kotlin version

**@AndroidEntryPoint missing:**
- Must be on Activity classes
- Import from dagger.hilt.android

**ViewModel not injected:**
- Check @HiltViewModel is on ViewModel
- Verify @Inject is on constructor
- Make sure hiltViewModel() is used, not viewModel()

**App crashes on startup:**
- Check Application class is registered in manifest
- Verify all Hilt modules are correct
- Look at Logcat for specific error

---

## Part B: Exploration Exercises (Homework/Practice)

These exercises are designed for independent exploration after the session. They build on what was learned in class and provide additional practice with more complex scenarios.

---

## Lab 8: Now in Android Analysis

**Goal:** Analyze Google's production sample app architecture  
**Time:** 30-45 minutes  
**Mode:** Independent exploration

### Prerequisites

- Completed all Part A labs
- Understanding of MVVM, Room, Hilt, Navigation
- Now in Android repository cloned

### Setup

1. **Clone Repository:**
   ```bash
   git clone https://github.com/android/nowinandroid
   cd nowinandroid
   ```

2. **Open in Android Studio:**
   - Open the project
   - Wait for Gradle sync (may take 5-10 minutes first time)
   - Let Android Studio index files

3. **Open in Cursor:**
   - File → Open Folder
   - Select the nowinandroid directory

4. **Build and run in Android Studio:**
   - Select device/emulator
   - Click Run (Shift+F10)
   - Explore the running app

### Part 1: Architecture Overview (15 min)

**Use Cursor Chat Mode (Cmd/Ctrl+L) to explore:**

1. **Overall Architecture:**
   ```
   Chat: "Explain the overall architecture of the Now in Android app.
   What architectural patterns are used?"
   ```
   
   **Document your findings:**
   - What is the layered architecture?
   - How many modules are there?
   - What is the purpose of each layer?

2. **Module Structure:**
   ```
   Chat: "Explain the module structure. What is the purpose of
   feature modules vs core modules?"
   ```
   
   **Questions to answer:**
   - How many feature modules exist?
   - What goes in `core` modules?
   - Why use multi-module architecture?
   - Benefits and trade-offs?

3. **Data Layer:**
   ```
   Chat: "Explain how the data layer is structured. How does
   it handle local vs remote data?"
   ```
   
   **Explore:**
   - Look at `:core:data` module
   - Find Repository implementations
   - How is data synchronized?
   - What is the "offline-first" strategy?

### Part 2: Dependency Injection (10 min)

1. **Hilt Setup:**
   ```
   Chat: "How is Hilt dependency injection set up in this project?
   Show me the main modules."
   ```
   
   **Find and examine:**
   - Application class
   - Hilt modules in `core:data`
   - Hilt modules in `core:database`
   - How are repositories provided?

2. **Scoping:**
   ```
   Chat: "Explain the Hilt scoping strategy used. What is
   @Singleton vs @ActivityScoped?"
   ```

3. **Compare with your Task Manager:**
   - What's similar?
   - What's more complex in NiA?
   - What could you apply to your app?

### Part 3: UI and Compose Patterns (10 min)

1. **Design System:**
   ```
   Chat: "What design system components are used? Where is
   the theming defined?"
   ```
   
   **Explore:**
   - Find `:core:designsystem` module
   - Look at reusable components
   - Check theme implementation
   - Material 3 usage

2. **Compose Patterns:**
   ```
   Chat: "Show me examples of advanced Compose patterns used
   in this app. How is state hoisting implemented?"
   ```
   
   **Find examples of:**
   - State hoisting
   - Side effects (LaunchedEffect, etc.)
   - Performance optimizations
   - Reusable composables

3. **Navigation:**
   ```
   Chat: "How is navigation implemented across feature modules?"
   ```

### Part 4: Testing Strategies (10 min)

1. **Test Structure:**
   ```
   Chat: "What testing strategies are used? Show me examples
   of unit tests, UI tests, and integration tests."
   ```
   
   **Find:**
   - ViewModel tests
   - Repository tests
   - Composable tests
   - Test doubles/fakes

2. **Test Data:**
   ```
   Chat: "How is test data managed? Are there test fixtures
   or factories?"
   ```

### Part 5: Build Configuration (5 min)

1. **Build Logic:**
   ```
   Chat: "Explain the build-logic module. What is convention
   plugins and why are they used?"
   ```
   
   **Explore:**
   - `build-logic/convention` directory
   - How are common configurations shared?
   - Benefits of this approach?

2. **Gradle Version Catalogs:**
   ```
   Chat: "How are dependencies managed with version catalogs?"
   ```
   
   **Find:**
   - `gradle/libs.versions.toml`
   - How to add new dependency?
   - Benefits vs traditional approach?

### Comparison Checklist

Create a comparison document between Now in Android and your Task Manager app:

| Feature | Your Task Manager | Now in Android | Notes |
|---------|------------------|----------------|-------|
| **Architecture** | | | |
| Module count | Single module | 20+ modules | |
| MVVM | ✅ | ✅ | |
| Repository pattern | ✅ | ✅ | |
| **DI** | | | |
| Hilt | ✅ | ✅ | |
| Scoping | Basic | Advanced | |
| **Data** | | | |
| Room | ✅ | ✅ | |
| Remote API | ❌ | ✅ | |
| Offline-first | ❌ | ✅ | |
| **UI** | | | |
| Compose | ✅ | ✅ | |
| Navigation | Basic | Advanced | |
| Design system | Basic | Complete | |
| **Testing** | | | |
| Unit tests | Basic | Comprehensive | |
| UI tests | Basic | Comprehensive | |
| Test doubles | ❌ | ✅ | |
| **Build** | | | |
| Version catalog | ❌ | ✅ | |
| Convention plugins | ❌ | ✅ | |

### Reflection Questions

Answer these questions in your notes:

1. **What surprised you most about Now in Android's architecture?**

2. **What patterns would you like to adopt in your own projects?**

3. **What seems overly complex for a smaller app?**

4. **How does multi-module architecture help with:**
   - Build times?
   - Team collaboration?
   - Code organization?
   - Testing?

5. **What did you learn about production-quality Android apps?**

### Success Criteria

- ✅ Now in Android builds and runs
- ✅ Explored architecture with AI assistance
- ✅ Understood module structure
- ✅ Analyzed DI setup
- ✅ Examined UI patterns
- ✅ Reviewed testing approach
- ✅ Created comparison with your app
- ✅ Documented learnings

### Next Steps

- Try implementing one pattern from NiA in your Task Manager
- Explore specific feature modules in detail
- Read the architectural decision records (ADRs)
- Study the GitHub issues and PRs to see development process

---

## Lab 9: Advanced Features

**Goal:** Extend Task Manager with advanced features  
**Time:** 45-60 minutes  
**Mode:** Independent practice

### Feature 1: Task Categories (20 min)

**Objective:** Add categories/tags to tasks

1. **Use Cursor Composer to:**
   
   Type:
   ```
   Add categories feature:
   
   1. Create Category entity with id, name, color
   2. Add many-to-many relationship between Task and Category
   3. Update TaskDao with category queries
   4. Update UI to show category chips on TaskCard
   5. Add category selection in TaskDetailScreen
   6. Create CategoryRepository
   ```

2. **Requirements:**
   - Categories: Personal, Work, Shopping, Health, etc.
   - Multiple categories per task
   - Color-coded chips
   - Filter tasks by category

3. **Test:**
   - Add categories to tasks
   - Filter by category
   - Verify persistence

### Feature 2: Due Dates (15 min)

**Objective:** Add due dates and reminders

1. **Use Cursor Composer:**
   
   Type:
   ```
   Add due date feature:
   
   1. Add dueDate: Long? field to Task entity
   2. Update TaskCard to show due date with icon
   3. Add DatePicker in TaskDetailScreen
   4. Sort tasks by due date
   5. Highlight overdue tasks in red
   ```

2. **Requirements:**
   - Optional due date
   - Date picker dialog
   - Visual indication of overdue
   - Sort: overdue → today → tomorrow → future

3. **Test:**
   - Add tasks with various due dates
   - Verify sorting
   - Check overdue highlighting

### Feature 3: Search and Filter (10 min)

**Objective:** Search tasks by title/description

1. **Use Cursor Composer:**
   
   Type:
   ```
   Add search feature:
   
   1. Add SearchBar to TaskListScreen TopAppBar
   2. Add search query to TaskDao
   3. Filter tasks in ViewModel based on search text
   4. Show search results or empty state
   5. Add chip filters: All, Active, Completed
   ```

2. **Requirements:**
   - Real-time search as you type
   - Search in title and description
   - Filter buttons for completion status
   - Clear search button

3. **Test:**
   - Search for task names
   - Test with no results
   - Toggle filters

### Feature 4: Task Priority (5 min)

**Objective:** Add priority levels

1. **Use Cursor Composer:**
   
   Type:
   ```
   Add priority feature:
   
   1. Create Priority enum: LOW, MEDIUM, HIGH
   2. Add priority field to Task
   3. Show priority with colored indicator (dot or bar)
   4. Add priority selector in TaskDetailScreen
   5. Sort by priority
   ```

2. **Requirements:**
   - Three priority levels
   - Color-coded (green, yellow, red)
   - Default: MEDIUM
   - Sort: HIGH → MEDIUM → LOW

### Feature 5: Swipe to Delete (5 min)

**Objective:** Swipe gesture to delete tasks

1. **Use Cursor Composer:**
   
   Type:
   ```
   Add swipe to delete:
   
   1. Wrap TaskCard in SwipeToDismiss
   2. Show delete icon in background
   3. Call viewModel.deleteTask on dismiss
   4. Optional: Add undo snackbar
   ```

2. **Test:**
   - Swipe task left/right
   - Task disappears
   - Verify deletion persists

### Success Criteria

- ✅ At least 3 of 5 features implemented
- ✅ All features work without crashes
- ✅ Data persists across app restarts
- ✅ UI looks polished
- ✅ Tests still pass (if you wrote tests for new features)

### Troubleshooting

**Room schema changes:**
- Increment database version
- Provide migration or use fallbackToDestructiveMigration

**UI feels cluttered:**
- Use Cursor Chat: "How can I improve the layout of TaskCard with categories and due dates?"
- Consider collapsible sections

**Performance issues:**
- Check for unnecessary recompositions
- Use `remember` and `derivedStateOf`
- Add LazyColumn keys

---

## Lab 10: Production Polish

**Goal:** Add production-ready features and polish  
**Time:** 30-45 minutes  
**Mode:** Independent practice

### Part 1: Accessibility (10 min)

1. **Review with AI:**
   ```
   Chat: "Review all my composables for accessibility issues.
   What improvements are needed for screen readers?"
   ```

2. **Apply improvements using Composer:**
   
   Type:
   ```
   Add accessibility improvements:
   
   1. Add contentDescription to all icons
   2. Add semantic properties to interactive elements
   3. Ensure minimum touch targets (48dp)
   4. Add semantic headings
   5. Test with TalkBack
   ```

3. **Test with TalkBack:**
   - Enable TalkBack in device settings
   - Navigate through app
   - Verify all elements are announced
   - Fix any issues found

### Part 2: Error Handling (10 min)

1. **Add comprehensive error handling:**
   ```
   Improve error handling:
   
   1. Add try-catch in all ViewModel functions
   2. Show meaningful error messages to users
   3. Add Snackbar for temporary errors
   4. Add error state screen for fatal errors
   5. Handle network errors (if applicable)
   6. Log errors for debugging
   ```

2. **Test error scenarios:**
   - Simulate database errors
   - Test with poor network (if applicable)
   - Verify user-friendly messages

### Part 3: Loading States (5 min)

1. **Improve loading UX:**
   
   Type:
   ```
   Add loading indicators:
   
   1. Show progress when adding task
   2. Show shimmer effect while loading tasks
   3. Add pull-to-refresh
   4. Disable buttons during operations
   ```

2. **Test:**
   - Observe loading states
   - Ensure no double-clicks cause issues

### Part 4: Performance Optimization (10 min)

1. **Analyze performance:**
   ```
   Chat: "Review my composables for performance issues.
   Are there unnecessary recompositions?"
   ```

2. **Apply optimizations:**
   ```
   Optimize performance:
   
   1. Add @Stable annotations where appropriate
   2. Use remember for expensive calculations
   3. Use derivedStateOf for derived state
   4. Ensure proper LazyColumn keys
   5. Use immutable data classes
   ```

3. **Profile in Android Studio:**
   - Run with profiler
   - Check for memory leaks
   - Verify smooth scrolling

### Part 5: Visual Polish (10 min)

1. **Enhance UI:**
   ```
   Polish the UI:
   
   1. Add animations (AnimatedVisibility, transitions)
   2. Improve spacing and padding consistency
   3. Add empty state illustrations
   4. Improve color contrast for accessibility
   5. Add splash screen
   6. Polish icons and typography
   ```

2. **Verify:**
   - App looks professional
   - Animations are smooth
   - Dark mode looks good
   - All states have proper UI

### Part 6: App Icon and Metadata (5 min)

1. **Create app icon:**
   - Use Android Studio's Image Asset Studio
   - Or use AI to generate icon design
   - Create adaptive icon (foreground + background)

2. **Update metadata:**
   - App name in `strings.xml`
   - Update package name if needed
   - Add app description

### Final Checklist

Production-ready criteria:

- ✅ All features work correctly
- ✅ No crashes or freezes
- ✅ Data persists reliably
- ✅ Accessible to screen reader users
- ✅ Error messages are user-friendly
- ✅ Loading states are clear
- ✅ Performance is smooth
- ✅ UI is polished and consistent
- ✅ Dark mode works perfectly
- ✅ App icon looks professional
- ✅ Tests cover main functionality
- ✅ Code is documented

### Success Criteria

- ✅ App is accessible (TalkBack tested)
- ✅ Comprehensive error handling
- ✅ All loading states implemented
- ✅ Performance optimized
- ✅ UI is polished
- ✅ App icon created
- ✅ Ready for production use

### Optional: Build APK

1. **Build release APK:**
   ```bash
   ./gradlew assembleRelease
   ```

2. **Find APK:**
   - `app/build/outputs/apk/release/app-release-unsigned.apk`

3. **Install on device:**
   ```bash
   adb install app/build/outputs/apk/release/app-release-unsigned.apk
   ```

4. **Share with friends!**

---

## Summary and Next Steps

### What You've Accomplished

After completing these labs, you've built a complete, production-quality Android app:

✅ **Complete Task Manager App:**
- Jetpack Compose UI with Material 3
- MVVM architecture with ViewModels
- StateFlow for reactive state management
- Multi-screen navigation
- Room database for persistence
- Hilt dependency injection
- Comprehensive testing
- Accessibility support
- Advanced features (categories, due dates, search)
- Production polish

✅ **Skills Acquired:**
- Hybrid workflow (Cursor + Android Studio)
- Cursor Composer mode (automatically uses codebase context)
- AI-assisted Android development
- Modern Android architecture
- Jetpack Compose proficiency
- Testing in Android

### Continue Learning

1. **Practice:**
   - Build your own app ideas
   - Apply patterns from Now in Android
   - Experiment with more Compose APIs

2. **Explore:**
   - Advanced Compose topics (Canvas, Gestures)
   - Jetpack libraries (WorkManager, Paging)
   - Kotlin coroutines and Flow
   - Material Design 3 guidelines

3. **Share:**
   - Publish your app to Google Play
   - Share code on GitHub
   - Write about your experience
   - Help others learn

### Session 3 Preview

In the next session, you'll learn:
- Extended Thinking mode for complex problems
- Plan Mode for large refactorings
- Custom slash commands
- Team collaboration with AI
- Code review workflows

### Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Now in Android](https://github.com/android/nowinandroid)
- [Android Architecture Guide](https://developer.android.com/topic/architecture)
- [Material Design 3](https://m3.material.io/)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

---

**Congratulations on completing Session 2! 🎉**

You've successfully learned how to use AI assistance for Android development while maintaining best practices and building production-quality apps. Keep experimenting and building!

