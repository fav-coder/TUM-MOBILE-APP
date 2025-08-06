// app/src/main/java/com/example/studentbuddy/data/models/Event.kt
package com.example.studentbuddy.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Event(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val date: String,
    val venue: String,
    val description: String
)