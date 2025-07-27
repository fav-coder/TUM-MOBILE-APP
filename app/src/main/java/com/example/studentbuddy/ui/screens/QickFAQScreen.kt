package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun QuickFAQScreen(navController: NavHostController) {
    val faqs = listOf(
        "How do I register for classes?" to "Log into the student portal and go to 'Course Registration'. Make sure to meet your academic advisor if needed.",
        "Where can I access campus Wi-Fi?" to "Wi-Fi is available in lecture halls, library, and hostels. Use your student credentials to connect.",
        "What do I do if I miss a class?" to "Reach out to your lecturer via email or check the class WhatsApp group for updates.",
        "How do I join a club?" to "Clubs usually recruit at the beginning of the semester. Look for posters or announcements, or ask at the Student Affairs office."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Quick FAQs",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        faqs.forEach { (question, answer) ->
            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { expanded = !expanded },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(question, style = MaterialTheme.typography.titleMedium)
                    if (expanded) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(answer, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
