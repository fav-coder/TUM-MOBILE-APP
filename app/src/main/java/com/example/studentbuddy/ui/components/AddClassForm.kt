package com.example.studentbuddy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.studentbuddy.data.models.ClassScheduleItem

@Composable
fun AddClassForm(onAdd: (ClassScheduleItem) -> Unit) {
    var day by remember { mutableStateOf("") }
    var courseName by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
        OutlinedTextField(day, { day = it }, label = { Text("Day") }, modifier = Modifier.fillMaxWidth(),colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ))
        OutlinedTextField(courseName, { courseName = it }, label = { Text("Course Name") }, modifier = Modifier.fillMaxWidth(),colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ))
        OutlinedTextField(time, { time = it }, label = { Text("Time") }, modifier = Modifier.fillMaxWidth(),colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ))
        OutlinedTextField(location, { location = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth(),colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ))

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onAdd(ClassScheduleItem(day, courseName, time, location))
                day = ""; courseName = ""; time = ""; location = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFEC9808),       // Background color
                contentColor = Color.White // Text/Icon color
            ),
            enabled = listOf(day, courseName, time, location).all { it.isNotBlank() }
        ) {
            Text("Add Class")
        }
    }
}
