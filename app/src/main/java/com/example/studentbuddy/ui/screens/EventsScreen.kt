package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentbuddy.data.models.Event


@Composable
fun EventsScreen(navController: NavController, innerPadding: PaddingValues) {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var venue by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var events by remember { mutableStateOf(listOf<Event>()) }
    var editingIndex by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
    ) {
        Text("Add Event", style = MaterialTheme.typography.titleLarge, fontSize = 20.sp, fontWeight = Bold)

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Event Title") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Event Date") },
            placeholder = { Text("e.g. 30 July 2025") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = venue,
            onValueChange = { venue = it },
            label = { Text("Venue") },
            placeholder = { Text("Event Venue") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Event Description") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (title.isNotBlank() && date.isNotBlank()) {
                    if (editingIndex != null) {
                        events = events.toMutableList().also {
                            it[editingIndex!!] = Event(title.trim(), date.trim(), venue.trim(), description.trim())
                        }
                        editingIndex = null
                    } else {
                        events = events + Event(title.trim(), date.trim(), venue.trim(), description.trim())
                    }

                    title = ""
                    date = ""
                    venue = ""
                    description = ""
                }
            },
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEC9808),       // Background color
                contentColor = Color.White
            )
        ) {
            Text(if (editingIndex == null) "Add" else "Update")
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

        Spacer(modifier = Modifier.height(8.dp))
        Text("Upcoming Events", style = MaterialTheme.typography.titleMedium, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(8.dp))

        if (events.isEmpty()) {
            Text("No events added yet.",  color = Color(0xFFEC9808))
        } else {
            LazyColumn {
                items(events.indices.toList()) { index ->
                    val event = events[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(event.title, style = MaterialTheme.typography.titleMedium)
                            Text(event.date, style = MaterialTheme.typography.labelSmall)
                            Text(event.venue, style = MaterialTheme.typography.labelSmall)
                            if (event.description.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(event.description, style = MaterialTheme.typography.bodySmall)
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                                TextButton(onClick = {
                                    title = event.title
                                    date = event.date
                                    venue = event.venue
                                    description = event.description
                                    editingIndex = index
                                }) {
                                    Text("Edit")
                                }

                                TextButton(onClick = {
                                    events = events.toMutableList().also {
                                        it.removeAt(index)
                                    }
                                    if (editingIndex == index) {
                                        editingIndex = null
                                        title = ""
                                        date = ""
                                        venue = ""
                                        description = ""
                                    }
                                }) {
                                    Text("Delete", color = Color.Red)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
