package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun QuickFAQScreen(navController: NavController) {
    val faqs = listOf(
        "How do I register for classes?" to "Go to the student portal or registrar’s office to register for your units.",
        "Where can I find the library?" to "The library is located next to the admin block. Open from 8AM to 9PM.",
        "How do I reset my portal password?" to "Click 'Forgot Password' on the portal or visit ICT support."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "FAQ Icon",
                tint = Color(0xFFFFA500) // TUM accent orange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Frequently Asked Questions",
                style = MaterialTheme.typography.headlineSmall
            )
        }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(faqs) { (question, answer) ->
                var expanded by remember { mutableStateOf(false) }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(2.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF3E0) // soft orange background
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = question,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { expanded = !expanded }
                        )

                        if (expanded) {
                            Text(
                                text = answer,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
