package com.example.taskmanager.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskmanager.model.Task

/**
 * Room database for the Task Manager app.
 *
 * This is the main database access point for the application.
 * Uses singleton pattern to ensure only one database instance exists.
 *
 * @property taskDao Provides access to Task entity operations
 */
@Database(
    entities = [Task::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Provides access to the Task Data Access Object.
     *
     * @return TaskDao instance for performing task-related database operations
     */
    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Gets the singleton database instance.
         *
         * Creates the database instance if it doesn't exist.
         * Uses fallbackToDestructiveMigration for demo purposes (will recreate database on version mismatch).
         *
         * @param context Application context
         * @return The AppDatabase instance
         */
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

