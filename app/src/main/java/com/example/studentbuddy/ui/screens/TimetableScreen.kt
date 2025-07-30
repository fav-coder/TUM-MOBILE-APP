package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentbuddy.data.models.ClassScheduleItem
import com.example.studentbuddy.ui.components.ClassCard

@Composable
fun TimetableScreen(schedule: SnapshotStateList<ClassScheduleItem>) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Your Timetable", style = MaterialTheme.typography.headlineSmall, fontSize = 20.sp, fontWeight = Bold)
        Text("Total classes: ${schedule.size}", style = MaterialTheme.typography.labelSmall)

        Spacer(Modifier.height(12.dp))

        if (schedule.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No classes yet.",
                    color = Color(0xFFEC9808),

                )
            }
        } else {
            LazyColumn {
                val grouped = schedule.groupBy { it.day }
                grouped.forEach { (day, classList) -> // ✅ renamed 'items' to 'classList'
                    item {
                        Text(day, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                    }
                    items(classList) { classItem ->
                        ClassCard(classItem)
                    }
                }
            }
        }
    }
}
