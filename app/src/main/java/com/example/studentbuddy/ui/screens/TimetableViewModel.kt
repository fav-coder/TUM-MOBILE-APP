package com.example.studentbuddy.ui.screens

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.studentbuddy.data.models.ClassScheduleItem
import com.google.firebase.firestore.FirebaseFirestore
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.*

class TimetableViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    private val collection = firestore.collection("timetable")

    var timetableItems = mutableStateListOf<ClassScheduleItem>()
        private set

    var selectedDate by mutableStateOf<LocalDate?>(null)

    init {
        fetchTimetable()
    }

    fun fetchTimetable() {
        collection.addSnapshotListener { snapshot, error ->
            if (error != null || snapshot == null) return@addSnapshotListener
            val items = snapshot.documents.mapNotNull { doc ->
                try {
                    doc.toObject(ClassScheduleItem::class.java)
                } catch (e: Exception) {
                    null // skip bad document
                }
            }
            timetableItems.clear()
            timetableItems.addAll(items.sortedBy { it.date })
        }
    }

    fun addClass(item: ClassScheduleItem) {
        val newItem = item.copy(id = UUID.randomUUID().toString())
        collection.document(newItem.id).set(newItem)
    }

    fun getFilteredByDate(): List<ClassScheduleItem> {
        return selectedDate?.let { date ->
            timetableItems.filter {
                LocalDate.parse(it.date) == date
            }
        } ?: timetableItems
    }

    fun getFilteredByWeek(): List<ClassScheduleItem> {
        val today = LocalDate.now()
        val start = today.with(DayOfWeek.MONDAY)
        val end = today.with(DayOfWeek.SUNDAY)
        return timetableItems.filter {
            val classDate = try {
                LocalDate.parse(it.date)
            } catch (e: Exception) {
                null
            }
            classDate != null && classDate in start..end
        }
    }
}
