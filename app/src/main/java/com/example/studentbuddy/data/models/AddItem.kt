package com.example.studentbuddy.data.models

data class AddItem(
    val itemName: String,
    val description: String,
    val date: String,
    val location: String,
    val type: String, // "Lost" or "Found"
    val status: String,
    val imageUri: String? = null // stored as a string URI
)
