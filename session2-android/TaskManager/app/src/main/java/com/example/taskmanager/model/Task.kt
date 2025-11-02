package com.example.taskmanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

/**
 * Room entity representing a task in the database.
 *
 * @property id Unique identifier for the task (primary key)
 * @property title Title of the task
 * @property description Description/details of the task
 * @property completed Whether the task is completed
 * @property createdAt Timestamp when the task was created (in milliseconds since epoch)
 */
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

