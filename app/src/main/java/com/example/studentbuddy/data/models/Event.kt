package com.example.studentbuddy.data.models

import android.accessibilityservice.GestureDescription
import android.icu.text.CaseMap
import java.sql.Date

data class Event(
    val title: String,
    val date: String,
    val description: String,
    val venue: String
)
