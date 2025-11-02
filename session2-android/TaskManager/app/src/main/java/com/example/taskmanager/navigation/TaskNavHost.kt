package com.example.taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.taskmanager.ui.screen.TaskDetailScreen
import com.example.taskmanager.ui.screen.TaskListScreen

/**
 * Navigation host for the Task Manager app.
 *
 * Defines all navigation routes and their associated composable screens.
 *
 * @param navController The NavHostController managing navigation state
 */
@Composable
fun TaskNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.HomeRoute.routePattern
    ) {
        composable(route = Route.HomeRoute.routePattern) {
            TaskListScreen(navController = navController)
        }

        composable(
            route = Route.TaskDetailRoute.routePattern,
            arguments = listOf(
                navArgument("taskId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId") ?: ""
            TaskDetailScreen(
                taskId = taskId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

