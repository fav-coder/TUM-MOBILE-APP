package com.example.studentbuddy.ui.screens

import CampusMapScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CampusBuddyNavGraph(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("Home") { HomeDashboard(innerPadding = PaddingValues(), navController) } // call your actual home screen here
        composable("ClassScheduleAndReminders") { TimetableScreen(navController) }
        composable("map") { CampusMapScreen(innerPadding = PaddingValues(),navController) }
        composable("LostAndFound") { LostAndFoundScreen(navController) }
        composable("QuickHelp") { QuickHelpScreen(navController) }
        composable("QuickFAQ") { QuickFAQScreen(navController) }
        composable("Events") { EventsScreen(navController,innerPadding = PaddingValues()) }


    }
}
