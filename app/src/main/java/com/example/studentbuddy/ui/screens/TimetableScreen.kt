package com.example.studentbuddy.ui.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.studentbuddy.data.models.ClassScheduleItem
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimetableScreen(viewModel: TimetableViewModel) {
    val timetable = viewModel.timetableItems
    var showDialog by remember { mutableStateOf(false) }
    var editingItem by remember { mutableStateOf<ClassScheduleItem?>(null) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background, // or surface, your choice
        floatingActionButton = {
            FloatingActionButton(onClick = {
                editingItem = null
                showDialog = true },
                containerColor = MaterialTheme.colorScheme.primary // example light orange background


            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Class",
                    tint = Color.Black
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(padding) // Use the padding provided by Scaffold
        ) {
            if (timetable.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No classes found")
                }
            } else {
                LazyColumn {
                    items(timetable) { item ->
                        ClassCard(
                            item = item,
                            onEdit = {
                                editingItem = item
                                showDialog = true
                            },
                            onDelete = { viewModel.deleteClass(item.id) }
                        )
                    }
                }
            }
        }

        if (showDialog) {
            AddEditClassDialog(
                item = editingItem,
                onDismiss = { showDialog = false },
                onSave = { newItem ->
                    if (editingItem == null) {
                        viewModel.addClass(newItem.copy(id = UUID.randomUUID().toString()))
                    } else {
                        viewModel.updateClass(newItem)
                    }
                    showDialog = false
                }
            )
        }
    } // end of Scaffold content lambda
} // end of TimetableScreen function



@Composable
fun ClassCard(item: ClassScheduleItem, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(item.courseName, fontWeight = FontWeight.Bold)
            Text("Date: ${item.date}")
            Text("Location: ${item.location}")
            Row(Modifier.padding(top = 8.dp)) {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}

@Composable
fun AddEditClassDialog(
    item: ClassScheduleItem?,
    onDismiss: () -> Unit,
    onSave: (ClassScheduleItem) -> Unit
) {
    var courseName by remember { mutableStateOf(item?.courseName ?: "") }
    var date by remember { mutableStateOf(item?.date ?: "") }
    var location by remember { mutableStateOf(item?.location ?: "") }

    val context = LocalContext.current
    // initialize calendar from existing date if present
    val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val calendar = remember {
        Calendar.getInstance().apply {
            if (date.isNotBlank()) {
                try {
                    time = dateFormatter.parse(date) ?: Date()
                } catch (_: Exception) { /* ignore */ }
            }
        }
    }

    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            date = dateFormatter.format(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (item == null) "Add Class" else "Edit Class") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = courseName,
                    onValueChange = { courseName = it },
                    label = { Text("Course Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = date,
                    onValueChange = {},
                    label = { Text("Date") },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { datePickerDialog.show() }) {
                            Icon(Icons.Default.DateRange, contentDescription = "Pick date")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = location,
                    onValueChange = { location = it },
                    label = { Text("Location") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(
                    ClassScheduleItem(
                        id = item?.id ?: "",
                        courseName = courseName,
                        location = location,
                        date = date
                    )
                )
            }) {
                Text("Save")
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
