package com.example.studentbuddy.ui.screens

import CampusMapScreen
import EventViewModel
import EventsScreen
import QuickHelpScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CampusBuddyNavGraph(
    innerPadding: PaddingValues,
    navController: NavHostController,
    viewModel: EventViewModel = viewModel(), // ← Inject ViewModel here


) {
    // 🔁 Shared state: Class schedule is remembered across navigation

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeDashboard(innerPadding = innerPadding, navController = navController)
        }

        composable("ClassScheduleAndReminders") {
            TimetableScreen(innerPadding = innerPadding, viewModel = viewModel())
        }

        composable("map") {
            CampusMapScreen(innerPadding = innerPadding, navController = navController)
        }

        composable("QuickHelp") {
            QuickHelpScreen(navController = navController)
        }

        composable("QuickFAQ") {
            QuickFAQScreen(navController = navController)
        }

        composable("Events") {
            EventsScreen(navController = navController, innerPadding = innerPadding,viewModel = viewModel)
        }
    }
}
