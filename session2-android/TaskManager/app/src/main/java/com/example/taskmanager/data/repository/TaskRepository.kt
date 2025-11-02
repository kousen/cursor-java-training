package com.example.taskmanager.data.repository

import com.example.taskmanager.data.local.TaskDao
import com.example.taskmanager.model.Task
import kotlinx.coroutines.flow.Flow

/**
 * Repository for managing task data operations.
 *
 * Acts as a single source of truth for task data, abstracting the data source
 * (currently Room database) from the rest of the application.
 *
 * @property taskDao Data Access Object for task database operations
 */
class TaskRepository(
    private val taskDao: TaskDao
) {
    /**
     * Gets all tasks as a reactive Flow.
     *
     * The Flow will automatically emit updated lists whenever the database changes.
     *
     * @return Flow of all tasks, ordered by creation date (newest first)
     */
    fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks()

    /**
     * Gets a task by its unique identifier.
     *
     * @param taskId The unique identifier of the task to retrieve
     * @return The task if found, null otherwise
     */
    suspend fun getTaskById(taskId: String): Task? = taskDao.getTaskById(taskId)

    /**
     * Inserts a new task into the database.
     *
     * If a task with the same ID already exists, it will be replaced.
     *
     * @param task The task to insert
     */
    suspend fun insertTask(task: Task) {
        taskDao.insert(task)
    }

    /**
     * Updates an existing task in the database.
     *
     * @param task The task to update with modified data
     */
    suspend fun updateTask(task: Task) {
        taskDao.update(task)
    }

    /**
     * Deletes a task from the database.
     *
     * @param task The task to delete
     */
    suspend fun deleteTask(task: Task) {
        taskDao.delete(task)
    }
}

