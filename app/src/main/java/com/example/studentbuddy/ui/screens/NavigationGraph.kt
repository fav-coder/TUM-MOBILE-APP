package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentbuddy.data.models.ClassScheduleItem


@Composable
fun CampusBuddyNavGraph(innerPadding: PaddingValues, navController: NavHostController) {
    // 🔁 Persisted across navigation
    val schedule = remember { mutableStateListOf<ClassScheduleItem>() }

    NavHost(navController = navController, startDestination = "home") {
        composable("Home") {
            HomeDashboard(innerPadding = PaddingValues(), navController)
        }

        composable("ClassScheduleAndReminders") {
            TimetableMainScreen(schedule, innerPadding)
        }

        composable("map") {
            CampusMapScreen(innerPadding = PaddingValues(), navController)
        }

        composable("QuickHelp") {
            QuickHelpScreen(navController)
        }

        composable("QuickFAQ") {
            QuickFAQScreen(navController)
        }

        composable("Events") {
            EventsScreen(navController, innerPadding = PaddingValues())
        }
    }
}
