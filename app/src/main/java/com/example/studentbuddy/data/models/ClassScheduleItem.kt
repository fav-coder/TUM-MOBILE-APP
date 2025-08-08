package com.example.studentbuddy.data.models

data class ClassScheduleItem(
    var id: String = "",
    val courseName: String = "",
    val date: String = "", // Format: yyyy-MM-dd
    val location: String = ""
)
