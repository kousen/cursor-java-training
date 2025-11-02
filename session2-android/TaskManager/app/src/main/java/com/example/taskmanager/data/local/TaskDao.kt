package com.example.taskmanager.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.taskmanager.model.Task
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for Task entity operations.
 *
 * Provides methods to interact with the tasks table in the Room database.
 */
@Dao
interface TaskDao {
    /**
     * Retrieves all tasks ordered by creation date (newest first).
     *
     * @return Flow of list of tasks, automatically emits updated data when database changes
     */
    @Query("SELECT * FROM tasks ORDER BY created_at DESC")
    fun getAllTasks(): Flow<List<Task>>

    /**
     * Retrieves a single task by its ID.
     *
     * @param taskId The unique identifier of the task
     * @return The task if found, null otherwise
     */
    @Query("SELECT * FROM tasks WHERE id = :taskId")
    suspend fun getTaskById(taskId: String): Task?

    /**
     * Retrieves tasks filtered by completion status, ordered by creation date (newest first).
     *
     * @param completed True to get completed tasks, false for incomplete tasks
     * @return Flow of list of tasks matching the completion status
     */
    @Query("SELECT * FROM tasks WHERE completed = :completed ORDER BY created_at DESC")
    fun getTasksByCompletion(completed: Boolean): Flow<List<Task>>

    /**
     * Inserts a task into the database.
     * If a task with the same ID already exists, it will be replaced.
     *
     * @param task The task to insert or replace
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    /**
     * Updates an existing task in the database.
     *
     * @param task The task to update
     */
    @Update
    suspend fun update(task: Task)

    /**
     * Deletes a task from the database.
     *
     * @param task The task to delete
     */
    @Delete
    suspend fun delete(task: Task)
}

