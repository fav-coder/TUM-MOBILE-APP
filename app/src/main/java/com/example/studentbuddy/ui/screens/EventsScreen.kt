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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.studentbuddy.ui.screens.EventViewModel

@Composable
fun EventsScreen(
    navController: NavController,
    innerPadding: PaddingValues,
    viewModel: EventViewModel = viewModel()
) {
    val currentEvent = viewModel.currentEvent.value
    val eventList = viewModel.eventList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text("Add Event", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = currentEvent.title,
            onValueChange = viewModel::updateTitle,
            label = { Text("Event Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentEvent.description,
            onValueChange = viewModel::updateDescription,
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentEvent.date,
            onValueChange = viewModel::updateDate,
            label = { Text("Date (e.g. 2025-08-10)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentEvent.time,
            onValueChange = viewModel::updateTime,
            label = { Text("Time (e.g. 10:00 AM)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = currentEvent.location,
            onValueChange = viewModel::updateLocation,
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (currentEvent.id.isBlank()) {
                    viewModel.addEvent()
                } else {
                    viewModel.updateEvent()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(if (currentEvent.id.isBlank()) "Add Event" else "Update Event")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Upcoming Events", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(eventList) { event ->
                EventCard(
                    event = event,
                    onEdit = { viewModel.startEditing(event) },
                    onDelete = { viewModel.deleteEvent(event) }
                )
            }
        }
    }
}


@Composable
fun EventCard(
    event: EventItem,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors= CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0), contentColor = Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "📅 ${event.date} at ${event.time}")
            Text(text = "📍 ${event.location}")
            if (event.description.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = event.description, style = MaterialTheme.typography.bodySmall)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onEdit) {
                    Text("Edit")
                }
                TextButton(onClick = onDelete) {
                    Text("Delete")
                }
            }
        }
    }
}
