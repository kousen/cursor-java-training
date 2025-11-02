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

/**
 * Hilt module for providing database-related dependencies.
 *
 * This module is installed in the SingletonComponent, meaning all provided
 * dependencies will be scoped to the application lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Provides the singleton AppDatabase instance.
     *
     * Creates the Room database with the application context and configures
     * it to fall back to destructive migration (recreates database on version mismatch).
     *
     * @param context Application context provided by Hilt
     * @return AppDatabase singleton instance
     */
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "task_database"
        )
            .fallbackToDestructiveMigration(dropAllTables = true)
            .build()
    }

    /**
     * Provides the TaskDao from the database.
     *
     * @param database AppDatabase instance provided by Hilt
     * @return TaskDao for performing task-related database operations
     */
    @Provides
    @Singleton
    fun provideTaskDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    /**
     * Provides the TaskRepository with its dependencies.
     *
     * @param taskDao TaskDao instance provided by Hilt
     * @return TaskRepository for managing task data operations
     */
    @Provides
    @Singleton
    fun provideTaskRepository(taskDao: TaskDao): TaskRepository {
        return TaskRepository(taskDao)
    }
}

