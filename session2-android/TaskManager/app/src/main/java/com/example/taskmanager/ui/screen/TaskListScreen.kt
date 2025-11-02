package com.example.taskmanager.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.taskmanager.navigation.Route
import com.example.taskmanager.ui.TaskList
import com.example.taskmanager.ui.theme.TaskManagerTheme
import com.example.taskmanager.ui.viewmodel.TaskViewModel

/**
 * Screen displaying the list of tasks with app bar and floating action button.
 *
 * @param navController Navigation controller for navigating to other screens
 * @param viewModel ViewModel instance for managing task list state
 * @param modifier Modifier for layout adjustments
 */
@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: TaskViewModel = hiltViewModel(),
) {
    var showAddTaskDialog by remember { mutableStateOf(false) }
    var taskTitle by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { androidx.compose.material3.Text("Task Manager") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showAddTaskDialog = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Task"
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        TaskList(
            viewModel = viewModel,
            onTaskClick = { taskId ->
                navController.navigate(Route.TaskDetailRoute.createRoute(taskId))
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    }

    if (showAddTaskDialog) {
        AlertDialog(
            onDismissRequest = {
                showAddTaskDialog = false
                taskTitle = ""
                taskDescription = ""
            },
            title = { Text("Add New Task") },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = taskTitle,
                        onValueChange = { taskTitle = it },
                        label = { Text("Title") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    OutlinedTextField(
                        value = taskDescription,
                        onValueChange = { taskDescription = it },
                        label = { Text("Description") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        maxLines = 4
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (taskTitle.isNotBlank()) {
                            viewModel.addTask(taskTitle, taskDescription)
                            showAddTaskDialog = false
                            taskTitle = ""
                            taskDescription = ""
                        }
                    }
                ) {
                    Text("Add")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showAddTaskDialog = false
                        taskTitle = ""
                        taskDescription = ""
                    }
                ) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskListScreenPreview() {
    TaskManagerTheme {
        // Preview without NavController - would need mock for full preview
        androidx.compose.material3.Text("Task List Screen Preview")
    }
}

