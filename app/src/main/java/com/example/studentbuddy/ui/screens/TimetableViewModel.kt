package com.example.studentbuddy.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.studentbuddy.data.models.ClassScheduleItem
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class TimetableViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    private val collection = firestore.collection("timetable")

    var timetableItems = mutableStateListOf<ClassScheduleItem>()
        private set

    init {
        getClasses()
    }

    // Load all classes from Firestore
    private fun getClasses() {
        collection.addSnapshotListener { snapshot, e ->
            if (e != null) return@addSnapshotListener

            timetableItems.clear()
            snapshot?.forEach { doc ->
                val item = doc.toObject<ClassScheduleItem>()
                item.id = doc.id // ✅ Store Firestore doc ID
                timetableItems.add(item)
            }
        }
    }

    // Add new class
    fun addClass(item: ClassScheduleItem) {
        val docRef = collection.document() // Create a doc with random ID
        val newItem = item.copy(id = docRef.id)
        docRef.set(newItem)
    }

    // Update existing class
    fun updateClass(item: ClassScheduleItem) {
        item.id.let { id ->
            collection.document(id).set(item)
        }
    }

    // Delete class
    fun deleteClass(id: String?) {
        if (!id.isNullOrEmpty()) {
            collection.document(id).delete()
        }
    }
}
