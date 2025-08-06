package com.example.studentbuddy.ui.screens

import EventDao
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentbuddy.data.models.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EventViewModel(private val eventDao: EventDao) : ViewModel() {
    val events: Flow<List<Event>> = eventDao.getAllEvents()

    // Editing state
    var editingIndex: Int? by mutableStateOf(null)

    // In your ViewModel:
    fun addOrUpdateEvent(event: Event) {
        viewModelScope.launch {
            if (editingIndex != null) {
                eventDao.update(event)  // Make sure you have this DAO function
            } else {
                eventDao.insert(event)
            }
            editingIndex = null  // Reset editing state
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            eventDao.delete(event)
            // Clear editing if deleting the current item
            if (events.first().indexOf(event) == editingIndex) {
                editingIndex = null
            }
        }
    }

    fun startEditing(index: Int) {
        editingIndex = index
    }
    fun clearEditingState() {
        editingIndex = null
    }

    suspend fun getEvent(index: Int): Event? {
        return events.first().getOrNull(index)
    }
}