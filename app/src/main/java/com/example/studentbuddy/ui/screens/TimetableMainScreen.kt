package com.example.studentbuddy.ui.screens

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studentbuddy.data.models.ClassScheduleItem
import com.example.studentbuddy.ui.components.AddClassForm

@Composable
fun TimetableMainScreen(schedule: SnapshotStateList<ClassScheduleItem>, innerPadding: PaddingValues) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(36.dp)


    ) {
        Text(text = "Plan your Day!",
            fontWeight = Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,


            )
        Spacer(modifier=Modifier.height(5.dp))
        AddClassForm(onAdd = { newClass ->
            schedule.add(newClass)  // ✅ This modifies the actual list
        })

        TimetableScreen(schedule = schedule)
    }
}
