# Session 2: Android Development Solutions

This directory contains the solution implementation for Session 2 lab exercises.

## Project Structure

```
session2-android/
├── README.md              # This file
└── TaskManagerApp/        # Complete solution project
    ├── app/
    ├── build.gradle
    └── ...
```

## Task Manager App

This is an Android application demonstrating:
- Jetpack Compose UI with Material 3
- ViewModels with StateFlow for state management
- Compose Navigation for multi-screen apps
- Room Database for local persistence
- Hilt for dependency injection
- Unit tests for ViewModels
- Compose UI tests

## Setup Instructions

### Prerequisites
- Android Studio (latest stable version)
- Android SDK (API level 24+)
- Kotlin support
- Physical device or emulator

### Running the Project

1. **Open in Android Studio:**
   ```bash
   # In Android Studio:
   File → Open → Select TaskManagerApp folder
   ```

2. **Sync Gradle:**
   - Android Studio should automatically sync
   - Or: Build → Sync Project with Gradle Files

3. **Open in Cursor (for AI assistance):**
   ```bash
   # In Cursor:
   File → Open Folder → Select TaskManagerApp folder
   ```

4. **Run on device/emulator:**
   - Click Run button in Android Studio (Shift+F10)
   - Select device/emulator
   - App should install and launch

### Testing the App

1. **Run unit tests:**
   ```bash
   ./gradlew test
   ```

2. **Run UI tests:**
   ```bash
   ./gradlew connectedAndroidTest
   ```

## Technologies Used

- Kotlin
- Jetpack Compose
- Material Design 3
- ViewModels + StateFlow
- Compose Navigation
- Room Database
- Hilt (Dependency Injection)
- JUnit 5
- MockK
- Compose Testing

## Hybrid Workflow: Cursor + Android Studio

This project uses a hybrid workflow:
- **Cursor:** For AI-assisted code generation using Composer mode
- **Android Studio:** For building, running, testing, and debugging

**Recommended workflow:**
1. Generate code in Cursor using Composer (`Cmd/Ctrl+Shift+I`)
2. Switch to Android Studio to run and test
3. Return to Cursor for next iteration
4. Repeat!

## Lab Exercises

This solution implements all exercises from [Android Lab Exercises (android_labs.md)](../android_labs.md):

- ✅ Lab 0: Android Setup Verification
- ✅ Lab 1: Building Task UI
- ✅ Lab 2: State Management
- ✅ Lab 3: Navigation
- ✅ Lab 4: Room Database
- ✅ Lab 5: Testing
- ✅ Lab 6: Hilt & Polish

## Now in Android Reference

Session 2 also explores Google's "Now in Android" sample application for reference.

**To clone Now in Android:**
```bash
git clone https://github.com/android/nowinandroid
cd nowinandroid
```

**Open in both tools:**
- Android Studio: File → Open → Select nowinandroid folder
- Cursor: File → Open Folder → Select nowinandroid folder

**Use Cursor Chat mode to explore:**
- Architecture patterns
- Module structure
- Compose patterns
- Testing strategies

See [android_labs.md](../android_labs.md) for exploration exercises.

## Notes

- This is one possible solution generated following the lab instructions
- Prompts used are documented in the lab exercises
- Some code variations are acceptable as long as functionality matches
- The app demonstrates a complete Task Manager with CRUD operations

## Troubleshooting

### Gradle Sync Issues
- Open project in Android Studio first to sync Gradle
- Then open in Cursor

### Emulator Not Starting
- Use Android Studio's AVD Manager to create/start emulator
- Or use a physical device connected via USB

### Compose Preview Issues
- Use Android Studio's preview pane (not Cursor)
- Build project first if preview doesn't show

## Next Steps

- Review the code structure
- Compare your implementation with this solution
- Explore Now in Android (see clone instructions above)
- Complete homework exercises in android_labs.md (Part B)

