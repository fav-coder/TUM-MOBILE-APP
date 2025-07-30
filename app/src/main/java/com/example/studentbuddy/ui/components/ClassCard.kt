package com.example.studentbuddy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.studentbuddy.data.models.ClassScheduleItem

@Composable
fun ClassCard(item: ClassScheduleItem) {
    Card(
        onClick = { /* TODO: Handle tap */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(item.courseName, style = MaterialTheme.typography.titleSmall)
            Text("📅 ${item.day}  |  🕒 ${item.day}", style = MaterialTheme.typography.labelSmall)
            Divider(modifier = Modifier.padding(vertical = 4.dp))
            Text("📍 Location: ${item.location}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
