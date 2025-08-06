import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentbuddy.data.models.Event
import com.example.studentbuddy.ui.screens.EventViewModel

@Composable
fun EventsScreen(
    navController: NavController,
    innerPadding: PaddingValues,
    viewModel: EventViewModel = viewModel()
) {
    // Form state
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var venue by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    // Collect events from Room database
    // Collect events as State
    val events by viewModel.events.collectAsState(initial = emptyList())

// Handle editing state
    LaunchedEffect(viewModel.editingIndex) {
        val currentIndex = viewModel.editingIndex
        if (currentIndex != null) {
            // Get from the current list
            events.getOrNull(currentIndex)?.let { event ->
                title = event.title
                date = event.date
                venue = event.venue
                description = event.description
            } ?: run {
                // Request ViewModel to clear invalid state
                viewModel.clearEditingState()
            }
        } else {
            // Clear form when not editing
            title = ""
            date = ""
            venue = ""
            description = ""
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
    ) {
        // Header
        Text("Add Event", style = MaterialTheme.typography.titleLarge.copy(fontSize = 20.sp, fontWeight = Bold))

        Spacer(modifier = Modifier.height(8.dp))

        // Form fields
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Event Title") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Event Date") },
            placeholder = { Text("e.g. 30 July 2025") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = venue,
            onValueChange = { venue = it },
            label = { Text("Venue") },
            placeholder = { Text("Event Venue") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Event Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Submit button
        Button(
            onClick = {
                if (title.isNotBlank() && date.isNotBlank()) {
                    val event = Event(
                        title = title.trim(),
                        date = date.trim(),
                        venue = venue.trim(),
                        description = description.trim()
                    )
                    viewModel.addOrUpdateEvent(event)

                    // Immediate local state reset (better UX)
                    if (viewModel.editingIndex == null) {
                        title = ""
                        date = ""
                        venue = ""
                        description = ""
                    }
                }
            },
            modifier = Modifier.align(Alignment.End),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEC9808),
                contentColor = Color.White
            )
        ) {
            Text(if (viewModel.editingIndex == null) "Add" else "Update")
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()

        // Events list
        Spacer(modifier = Modifier.height(8.dp))
        Text("Upcoming Events", style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp))

        Spacer(modifier = Modifier.height(8.dp))

        when {
            events.isEmpty() -> {
                Text("No events added yet.", color = Color(0xFFEC9808))
            }
            else -> {
                LazyColumn {
                    items(events) { event ->
                        EventItem(
                            event = event,
                            onEdit = {
                                viewModel.startEditing(events.indexOf(event))
                            },
                            onDelete = {
                                viewModel.deleteEvent(event)
                                // Clear form if deleting the currently edited event
                                if (viewModel.editingIndex == events.indexOf(event)) {
                                    viewModel.editingIndex = null
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EventItem(
    event: Event,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onEdit) {
                    Text("Edit")
                }
                TextButton(onClick = onDelete) {
                    Text("Delete", color = Color.Red)
                }
            }
        }
    }
}