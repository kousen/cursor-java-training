# Task Manager - Android App

A modern Android task management application demonstrating best practices in Android development.

## Features

- ✅ Create, read, update, and delete tasks
- 🎨 Material 3 design with purple theme
- 🌓 Light and dark mode support
- 💾 Local persistence with Room database
- 🏗️ Clean architecture with MVVM pattern
- 💉 Dependency injection with Hilt

## Tech Stack

### Architecture & Design
- **MVVM** (Model-View-ViewModel)
- **Repository Pattern**
- **Dependency Injection** with Hilt
- **Unidirectional Data Flow** with StateFlow

### Android Jetpack
- **Jetpack Compose** - Modern declarative UI
- **Room** - Local database
- **Navigation Compose** - Type-safe navigation
- **ViewModel** - Lifecycle-aware state management
- **Hilt** - Dependency injection

### Libraries & Tools
- **Kotlin 2.0.21**
- **Compose BOM 2025.10.01**
- **Material 3** - Latest Material Design
- **Coroutines & Flow** - Asynchronous programming
- **KSP** - Kotlin Symbol Processing

## Requirements

- Android Studio Ladybug or newer
- JDK 21 (recommended: use SDKMAN)
- Android SDK 36
- Minimum SDK 24 (Android 7.0)

## Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd TaskManager
   ```

2. **Set Java 21** (if using SDKMAN)
   ```bash
   sdk use java 21.0.5-tem
   ```

3. **Open in Android Studio**
   - File → Open → Select the project folder
   - Wait for Gradle sync to complete

4. **Run the app**
   - Click the Run button or press Shift+F10
   - Select an emulator or connected device

## Project Structure

```
app/src/main/java/com/example/taskmanager/
├── data/
│   ├── local/
│   │   ├── AppDatabase.kt      # Room database
│   │   └── TaskDao.kt          # Data access object
│   └── repository/
│       └── TaskRepository.kt   # Data layer abstraction
├── di/
│   └── DatabaseModule.kt       # Hilt dependency injection
├── model/
│   └── Task.kt                 # Task entity
├── navigation/
│   ├── Route.kt                # Navigation routes
│   └── TaskNavHost.kt          # Navigation graph
├── ui/
│   ├── screen/
│   │   ├── TaskListScreen.kt   # Main task list
│   │   └── TaskDetailScreen.kt # Task editing
│   ├── state/
│   │   └── TaskListUiState.kt  # UI state sealed class
│   ├── theme/
│   │   ├── Color.kt            # Color definitions
│   │   ├── Theme.kt            # Material 3 theme
│   │   └── Type.kt             # Typography
│   └── viewmodel/
│       └── TaskViewModel.kt    # Business logic & state
├── MainActivity.kt             # Entry point
└── TaskApplication.kt          # Application class
```

## Key Concepts Demonstrated

### Dependency Injection with Hilt
- `@HiltAndroidApp` on Application
- `@AndroidEntryPoint` on Activity
- `@HiltViewModel` on ViewModel
- `@Module` and `@InstallIn` for providing dependencies
- `hiltViewModel()` for ViewModel injection in Compose

### Room Database
- Entity definition with `@Entity`
- DAO with `@Dao` and `@Query`
- Flow-based reactive queries
- Database singleton with Hilt

### Modern UI with Compose
- Declarative UI with `@Composable`
- State management with `remember` and `StateFlow`
- Material 3 components
- Edge-to-edge display
- Light/Dark theme support

### MVVM Architecture
- ViewModel handles business logic
- Repository abstracts data sources
- UI observes StateFlow for updates
- Unidirectional data flow

## Building for Production

```bash
# Debug build
./gradlew assembleDebug

# Release build (configure signing first)
./gradlew assembleRelease

# Run tests
./gradlew test
./gradlew connectedAndroidTest
```

## Testing

- Unit tests use JUnit 5 (Jupiter)
- Mocking with MockK
- Flow testing with Turbine
- Instrumented tests with Compose Testing

## License

This project is provided as-is for educational purposes.

## Author

Kenneth Kousen

