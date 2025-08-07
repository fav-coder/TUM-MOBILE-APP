package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.studentbuddy.data.models.ClassScheduleItem
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun TimetableScreen(viewModel: TimetableViewModel = viewModel()) {
    var showDialog by remember { mutableStateOf(false) }
    val timetable = viewModel.getFilteredByWeek()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Class Timetable", style = MaterialTheme.typography.headlineMedium)
            Button(onClick = { showDialog = true }) {
                Text("Add Class")
            }
        }

        Spacer(Modifier.height(16.dp))

        if (timetable.isEmpty()) {
            Text("No classes scheduled this week.", style = MaterialTheme.typography.bodyLarge)
        } else {
            LazyColumn {
                val grouped = timetable.groupBy { it.date }

                grouped.forEach { (date, items) ->
                    item {
                        val formatted = try {
                            LocalDate.parse(date).format(DateTimeFormatter.ofPattern("EEE, MMM dd"))
                        } catch (e: Exception) {
                            "Invalid date"
                        }

                        Text(formatted, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }

                    items(items) { classItem ->
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)) {
                            Column(Modifier.padding(12.dp)) {
                                Text("Course: ${classItem.courseName}")
                                Text("Location: ${classItem.location}")
                                Text("Date: ${classItem.date}")
                            }
                        }
                    }
                }
            }
        }
    }

    if (showDialog) {
        AddClassDialog(
            onDismiss = { showDialog = false },
            onAdd = { item ->
                viewModel.addClass(item)
                showDialog = false
            }
        )
    }
}



@Composable
fun AddClassDialog(
    onDismiss: () -> Unit,
    onAdd: (ClassScheduleItem) -> Unit
) {
    var courseName by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf(LocalDate.now()) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                val formattedDate = date.format(DateTimeFormatter.ISO_DATE)
                onAdd(ClassScheduleItem(
                    courseName = courseName,
                    date = formattedDate,
                    location = location
                ))
            }) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        },
        title = { Text("Add Class") },
        text = {
            Column {
                OutlinedTextField(
                    value = courseName,
                    onValueChange = { courseName = it },
                    label = { Text("Course Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = location,
                    onValueChange = { location = it },
                    label = { Text("Location") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = date.toString(),
                    onValueChange = {
                        date = try {
                            LocalDate.parse(it)
                        } catch (_: Exception) {
                            LocalDate.now()
                        }
                    },
                    label = { Text("Date (yyyy-MM-dd)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    )
}

