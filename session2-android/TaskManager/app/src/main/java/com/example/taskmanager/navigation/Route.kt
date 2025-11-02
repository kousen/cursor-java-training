package com.example.taskmanager.navigation

/**
 * Sealed class representing all possible navigation routes in the app.
 *
 * Each route defines a destination screen with its required parameters.
 * Route patterns are defined in companion objects for use with Navigation Compose.
 */
sealed class Route(val route: String) {
    /**
     * Route to the home screen (task list).
     *
     * No arguments required.
     */
    object HomeRoute : Route(route = "home") {
        const val routePattern = "home"
    }

    /**
     * Route to the task detail screen.
     *
     * @property taskId The unique identifier of the task to display
     */
    data class TaskDetailRoute(val taskId: String) : Route(route = "task_detail/$taskId") {
        companion object {
            const val routePattern = "task_detail/{taskId}"
            
            /**
             * Creates a TaskDetailRoute with the given task ID.
             */
            fun createRoute(taskId: String) = "task_detail/$taskId"
        }
    }
}

