package com.example.studentbuddy.data.models

data class ClassScheduleItem(
    val day: String,          // e.g., "Monday", "Tuesday"
    val courseName: String,   // e.g., "Introduction to Programming"
    val date: String,         // e.g., "2025-08-06" or a more user-friendly format
    val location: String      // e.g., "Room A101"
)
