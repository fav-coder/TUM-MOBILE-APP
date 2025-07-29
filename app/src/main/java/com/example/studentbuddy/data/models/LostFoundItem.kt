package com.example.studentbuddy.data.models

data class LostFoundItem(
    val id: String,
    val title: String,
    val description:String,
    val location: String,
    val date: String,
    val type: String,
    val imageUri: String? = null

)
