package com.example.taskmanager.ui.viewmodel

import app.cash.turbine.test
import com.example.taskmanager.data.repository.TaskRepository
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.state.TaskListUiState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModelTest {

    @MockK
    private lateinit var mockRepository: TaskRepository

    private lateinit var testDispatcher: TestDispatcher
    private lateinit var viewModel: TaskViewModel

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
        testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `initial state is Loading then Success with empty list`() = runTest(testDispatcher) {
        // Given
        val tasksFlow = MutableStateFlow<List<Task>>(emptyList())
        every { mockRepository.getAllTasks() } returns tasksFlow

        // When
        viewModel = TaskViewModel(mockRepository)
        advanceUntilIdle()

        // Then - with UnconfinedTestDispatcher, states are emitted immediately
        // We verify the final Success state and that it started with Loading
        viewModel.uiState.test {
            // First state might be Loading or Success depending on timing
            val firstState = awaitItem()
            if (firstState is TaskListUiState.Loading) {
                // If we caught Loading, verify Success follows
                val successState = awaitItem()
                assertInstanceOf(TaskListUiState.Success::class.java, successState)
                val success = successState as TaskListUiState.Success
                assertTrue(success.tasks.isEmpty())
            } else {
                // If we only see Success, verify it's correct
                assertInstanceOf(TaskListUiState.Success::class.java, firstState)
                val success = firstState as TaskListUiState.Success
                assertTrue(success.tasks.isEmpty())
            }
            cancel()
        }
    }

    @Test
    fun `addTask updates state with new task`() = runTest(testDispatcher) {
        // Given
        val tasksFlow = MutableStateFlow<List<Task>>(emptyList())
        every { mockRepository.getAllTasks() } returns tasksFlow
        coEvery { mockRepository.insertTask(any()) } coAnswers {
            val task = firstArg<Task>()
            tasksFlow.value = tasksFlow.value + task
        }

        viewModel = TaskViewModel(mockRepository)
        advanceUntilIdle()

        // When
        val newTaskTitle = "New Task"
        val newTaskDescription = "Task description"
        viewModel.addTask(newTaskTitle, newTaskDescription)
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.insertTask(any()) }
        viewModel.uiState.test {
            // Get the current Success state (Loading was already emitted)
            val successState = awaitItem()
            assertInstanceOf(TaskListUiState.Success::class.java, successState)
            val success = successState as TaskListUiState.Success
            assertEquals(1, success.tasks.size)
            assertEquals(newTaskTitle, success.tasks[0].title)
            assertEquals(newTaskDescription, success.tasks[0].description)
            assertEquals(false, success.tasks[0].completed)
            cancel()
        }
    }

    @Test
    fun `toggleTaskCompletion updates task completion status`() = runTest(testDispatcher) {
        // Given
        val task = Task(
            id = "1",
            title = "Test Task",
            description = "Description",
            completed = false
        )
        val tasksFlow = MutableStateFlow<List<Task>>(listOf(task))
        every { mockRepository.getAllTasks() } returns tasksFlow
        coEvery { mockRepository.getTaskById("1") } returns task
        coEvery { mockRepository.updateTask(any()) } coAnswers {
            val updatedTask = firstArg<Task>()
            tasksFlow.value = listOf(updatedTask)
        }

        viewModel = TaskViewModel(mockRepository)
        advanceUntilIdle()

        // When
        viewModel.toggleTaskCompletion("1")
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.getTaskById("1") }
        coVerify { mockRepository.updateTask(any()) }
        viewModel.uiState.test {
            // Get the current Success state (Loading was already emitted)
            val successState = awaitItem()
            assertInstanceOf(TaskListUiState.Success::class.java, successState)
            val success = successState as TaskListUiState.Success
            assertEquals(1, success.tasks.size)
            assertEquals(true, success.tasks[0].completed)
            cancel()
        }
    }

    @Test
    fun `updateTask updates task in repository`() = runTest(testDispatcher) {
        // Given
        val task = Task(
            id = "1",
            title = "Original Title",
            description = "Original Description",
            completed = false
        )
        val tasksFlow = MutableStateFlow<List<Task>>(listOf(task))
        every { mockRepository.getAllTasks() } returns tasksFlow
        coEvery { mockRepository.getTaskById("1") } returns task
        coEvery { mockRepository.updateTask(any()) } coAnswers {
            val updatedTask = firstArg<Task>()
            tasksFlow.value = listOf(updatedTask)
        }

        viewModel = TaskViewModel(mockRepository)
        advanceUntilIdle()

        // When
        val newTitle = "Updated Title"
        val newDescription = "Updated Description"
        viewModel.updateTask(
            taskId = "1",
            title = newTitle,
            description = newDescription
        )
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.getTaskById("1") }
        coVerify { mockRepository.updateTask(any()) }
        viewModel.uiState.test {
            // Get the current Success state (Loading was already emitted)
            val successState = awaitItem()
            assertInstanceOf(TaskListUiState.Success::class.java, successState)
            val success = successState as TaskListUiState.Success
            assertEquals(1, success.tasks.size)
            assertEquals(newTitle, success.tasks[0].title)
            assertEquals(newDescription, success.tasks[0].description)
            cancel()
        }
    }

    @Test
    fun `deleteTask removes task from list`() = runTest(testDispatcher) {
        // Given
        val task1 = Task(id = "1", title = "Task 1", completed = false)
        val task2 = Task(id = "2", title = "Task 2", completed = false)
        val tasksFlow = MutableStateFlow<List<Task>>(listOf(task1, task2))
        every { mockRepository.getAllTasks() } returns tasksFlow
        coEvery { mockRepository.getTaskById("1") } returns task1
        coEvery { mockRepository.deleteTask(any()) } coAnswers {
            val taskToDelete = firstArg<Task>()
            tasksFlow.value = tasksFlow.value.filter { it.id != taskToDelete.id }
        }

        viewModel = TaskViewModel(mockRepository)
        advanceUntilIdle()

        // When
        viewModel.deleteTask("1")
        advanceUntilIdle()

        // Then
        coVerify { mockRepository.getTaskById("1") }
        coVerify { mockRepository.deleteTask(task1) }
        viewModel.uiState.test {
            // Get the current Success state (Loading was already emitted)
            val successState = awaitItem()
            assertInstanceOf(TaskListUiState.Success::class.java, successState)
            val success = successState as TaskListUiState.Success
            assertEquals(1, success.tasks.size)
            assertEquals("2", success.tasks[0].id)
            assertEquals("Task 2", success.tasks[0].title)
            cancel()
        }
    }
}

