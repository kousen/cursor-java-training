# General Setup Instructions

This document provides general setup instructions for the Cursor Training course.

## Prerequisites

### For All Sessions
- **Cursor IDE** installed from [cursor.sh](https://cursor.sh)
- **Git** for version control
- Basic command-line familiarity

### Session 1: Spring Boot Development
- **Java 17 or 21** (JDK)
- **Gradle** or **Maven** (wrappers included in projects)
- Internet connection for Spring Initializr

### Session 2: Android Development
- **Android Studio** (latest stable version)
- **Android SDK** (API level 24+)
- **Emulator** or **Physical Android Device**
- **Kotlin** support (included with Android Studio)
- Internet connection for Gradle dependencies

### Sessions 3-5: Advanced Topics
- Same as Session 1 (Java/Spring Boot focus)
- Internet connection for AI model access

## Basic Setup Steps

1. **Clone this repository:**
   ```bash
   git clone <repository-url>
   cd cursor-java-training
   ```

2. **Navigate to specific session:**
   ```bash
   cd session1-spring-boot  # or session2-android, etc.
   ```

3. **Follow session-specific README:**
   - Each session has its own `README.md` with detailed setup
   - See main `README.md` for course navigation

## Troubleshooting

### Cursor Issues
- **Extensions not loading:** Restart Cursor window (Cmd/Ctrl+Shift+P → "Developer: Reload Window")
- **AI not responding:** Check internet connection, verify API key settings

### Java Issues
- **Wrong Java version:** Verify with `java -version`, set JAVA_HOME if needed
- **Build tool not found:** Use project wrappers (`./gradlew` or `./mvnw`)

### Android Issues
- **SDK not found:** Open project in Android Studio first to sync Gradle
- **Emulator not starting:** Check AVD configuration in Android Studio

## Getting Help

- Check session-specific README files
- Review lab exercise documentation
- Use Cursor Chat mode for troubleshooting
- Consult official documentation links in each session README

