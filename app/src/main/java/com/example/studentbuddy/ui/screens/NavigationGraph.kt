package com.example.studentbuddy.ui.screens

import CampusMapScreen
import EventsScreen
import QuickHelpScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun CampusBuddyNavGraph(innerPadding: PaddingValues, navController: NavHostController) {
    // 🔁 Persisted across navigation

    NavHost(navController = navController, startDestination = "home") {
        composable("Home") {
            HomeDashboard(innerPadding = PaddingValues(), navController)
        }

        composable("ClassScheduleAndReminders") {
            val timetableViewModel: TimetableViewModel = viewModel()
            TimetableScreen(viewModel = timetableViewModel)
        }

        composable("map") {
            CampusMapScreen(innerPadding = PaddingValues(), navController)
        }

        composable("QuickHelp") {
            QuickHelpScreen(navController, innerPadding =PaddingValues())
        }

        composable("QuickFAQ") {
            QuickFAQScreen(navController, innerPadding = PaddingValues())
        }

        composable("Events") {
            EventsScreen(navController, innerPadding = PaddingValues())
        }
    }
}
