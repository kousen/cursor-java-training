package com.example.taskmanager.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.state.TaskListUiState
import com.example.taskmanager.ui.theme.TaskManagerTheme
import com.example.taskmanager.ui.viewmodel.TaskViewModel

@Composable
fun TaskList(
    viewModel: TaskViewModel,
    onTaskClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is TaskListUiState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is TaskListUiState.Success -> {
            if (state.tasks.isEmpty()) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No tasks yet",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                LazyColumn(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 8.dp)
                ) {
                    items(
                        items = state.tasks,
                        key = { task -> task.id }
                    ) { task ->
                        TaskCard(
                            task = task,
                            onToggleComplete = viewModel::toggleTaskCompletion,
                            onTaskClick = { onTaskClick(task.id) },
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }

        is TaskListUiState.Error -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error: ${state.message}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

// Internal composable for displaying task list items (used by previews)
@Composable
private fun TaskListItems(
    tasks: List<Task>,
    onToggleComplete: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (tasks.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No tasks yet",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(vertical = 8.dp)
        ) {
            items(
                items = tasks,
                key = { task -> task.id }
            ) { task ->
                TaskCard(
                    task = task,
                    onToggleComplete = onToggleComplete,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListLoadingPreview() {
    TaskManagerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListEmptyPreview() {
    TaskManagerTheme {
        TaskListItems(
            tasks = emptyList(),
            onToggleComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListWithItemsPreview() {
    TaskManagerTheme {
        TaskListItems(
            tasks = listOf(
                Task(
                    id = "1",
                    title = "Buy groceries",
                    description = "Milk, eggs, bread",
                    completed = false
                ),
                Task(
                    id = "2",
                    title = "Finish project",
                    description = "Complete the task manager app",
                    completed = true
                ),
                Task(
                    id = "3",
                    title = "Call dentist",
                    description = "Schedule appointment",
                    completed = false
                )
            ),
            onToggleComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListErrorPreview() {
    TaskManagerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Error: Failed to load tasks",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

