package com.example.taskmanager.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanager.model.Task
import com.example.taskmanager.ui.theme.TaskManagerTheme

@Composable
fun TaskCard(
    task: Task,
    onToggleComplete: (String) -> Unit,
    onTaskClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
                    .clickable(onClick = onTaskClick)
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Checkbox(
                checked = task.completed,
                onCheckedChange = { onToggleComplete(task.id) },
                modifier = Modifier.testTag("task_checkbox_${task.id}")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardUncompletedShortPreview() {
    TaskManagerTheme {
        TaskCard(
            task = Task(
                id = "1",
                title = "Buy milk",
                description = "From the store",
                completed = false
            ),
            onToggleComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardCompletedPreview() {
    TaskManagerTheme {
        TaskCard(
            task = Task(
                id = "2",
                title = "Finish report",
                description = "Submit to manager",
                completed = true
            ),
            onToggleComplete = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardLongTextPreview() {
    TaskManagerTheme {
        TaskCard(
            task = Task(
                id = "3",
                title = "This is a very long task title that might overflow and cause layout issues if not handled properly",
                description = "This is an extremely long description that contains a lot of detailed information about the task. It describes everything that needs to be done, including all the steps, requirements, deadlines, and important notes. The text might wrap to multiple lines and should be handled gracefully by the layout system without breaking the UI.",
                completed = false
            ),
            onToggleComplete = {}
        )
    }
}

