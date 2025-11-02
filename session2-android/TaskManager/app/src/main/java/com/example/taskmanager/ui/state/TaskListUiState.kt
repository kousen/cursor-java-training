package com.example.taskmanager.ui.state

import com.example.taskmanager.model.Task

/**
 * Sealed interface representing the UI state for the task list screen.
 *
 * This provides type-safe state representation for different scenarios:
 * - [Loading] - When tasks are being fetched
 * - [Success] - When tasks have been successfully loaded
 * - [Error] - When an error occurs while loading tasks
 */
sealed interface TaskListUiState {
    /**
     * Represents the loading state when tasks are being fetched.
     *
     * The UI should display a loading indicator while in this state.
     */
    data object Loading : TaskListUiState

    /**
     * Represents the success state with a list of tasks.
     *
     * @property tasks The list of tasks to display in the UI
     */
    data class Success(
        val tasks: List<Task>
    ) : TaskListUiState

    /**
     * Represents an error state that occurred while loading tasks.
     *
     * @property message The error message to display to the user
     */
    data class Error(
        val message: String
    ) : TaskListUiState
}

