package com.example.taskmanager.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskmanager.data.repository.TaskRepository
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.state.TaskListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for managing task list UI state and business logic.
 *
 * Follows the MVVM pattern with unidirectional data flow:
 * - UI events flow up to ViewModel functions
 * - State flows down from StateFlow to UI
 *
 * Uses [StateFlow] for reactive state management that survives configuration changes.
 * Integrates with [TaskRepository] to persist and retrieve tasks from the database.
 *
 * @property repository Repository for task data operations injected by Hilt
 */
@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<TaskListUiState>(TaskListUiState.Loading)
    
    /**
     * Public read-only StateFlow for observing UI state.
     *
     * The UI should collect this StateFlow and react to state changes.
     */
    val uiState: StateFlow<TaskListUiState> = _uiState.asStateFlow()

    init {
        // Collect tasks from repository and map to UI state
        loadTasks()
    }

    /**
     * Loads tasks from the repository and observes changes.
     *
     * Collects the Flow from repository and maps it to UI state.
     * Handles loading, success, and error states.
     */
    private fun loadTasks() {
        viewModelScope.launch {
            repository.getAllTasks()
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

    /**
     * Adds a new task to the database.
     *
     * @param title The title of the task
     * @param description The description of the task
     */
    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            try {
                val newTask = Task(
                    title = title,
                    description = description,
                    completed = false
                )
                repository.insertTask(newTask)
                // State will update automatically via Flow collection
            } catch (exception: Exception) {
                _uiState.value = TaskListUiState.Error(
                    message = exception.message ?: "Failed to add task"
                )
            }
        }
    }

    /**
     * Deletes a task from the database.
     *
     * @param taskId The unique identifier of the task to delete
     */
    fun deleteTask(taskId: String) {
        viewModelScope.launch {
            try {
                val task = repository.getTaskById(taskId)
                if (task != null) {
                    repository.deleteTask(task)
                    // State will update automatically via Flow collection
                }
            } catch (exception: Exception) {
                _uiState.value = TaskListUiState.Error(
                    message = exception.message ?: "Failed to delete task"
                )
            }
        }
    }

    /**
     * Toggles the completion status of a task.
     *
     * @param taskId The unique identifier of the task to toggle
     */
    fun toggleTaskCompletion(taskId: String) {
        viewModelScope.launch {
            try {
                val task = repository.getTaskById(taskId)
                if (task != null) {
                    val updatedTask = task.copy(completed = !task.completed)
                    repository.updateTask(updatedTask)
                    // State will update automatically via Flow collection
                }
            } catch (exception: Exception) {
                _uiState.value = TaskListUiState.Error(
                    message = exception.message ?: "Failed to toggle task completion"
                )
            }
        }
    }

    /**
     * Gets a task by its ID.
     *
     * @param taskId The unique identifier of the task to retrieve
     * @return The task if found, null otherwise
     */
    suspend fun getTaskById(taskId: String): Task? {
        return try {
            repository.getTaskById(taskId)
        } catch (exception: Exception) {
            _uiState.value = TaskListUiState.Error(
                message = exception.message ?: "Failed to get task"
            )
            null
        }
    }

    /**
     * Updates an existing task's properties.
     *
     * @param taskId The unique identifier of the task to update
     * @param title The new title (null to keep existing)
     * @param description The new description (null to keep existing)
     * @param completed The new completion status (null to keep existing)
     */
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
                    // State will update automatically via Flow collection
                }
            } catch (exception: Exception) {
                _uiState.value = TaskListUiState.Error(
                    message = exception.message ?: "Failed to update task"
                )
            }
        }
    }
}

