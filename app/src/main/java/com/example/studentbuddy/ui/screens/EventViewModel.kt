import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.ListenerRegistration
import java.util.UUID

class EventViewModel : ViewModel() {

    var currentEvent = mutableStateOf(EventItem())
        private set

    val eventList = mutableStateListOf<EventItem>()
    private val firestore = FirebaseFirestore.getInstance()
    private var listenerRegistration: ListenerRegistration? = null

    private var eventListener: ListenerRegistration? = null




    init {
        observeEvents() // Real-time updates
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder()
            .setPersistenceEnabled(true)
            .build()

        observeEvents()

    }

    // --- Update Form Fields ---
    fun updateTitle(newTitle: String) {
        currentEvent.value = currentEvent.value.copy(title = newTitle)
    }

    fun updateDescription(newDesc: String) {
        currentEvent.value = currentEvent.value.copy(description = newDesc)
    }

    fun updateDate(newDate: String) {
        currentEvent.value = currentEvent.value.copy(date = newDate)
    }

    fun updateTime(newTime: String) {
        currentEvent.value = currentEvent.value.copy(time = newTime)
    }

    fun updateLocation(newLocation: String) {
        currentEvent.value = currentEvent.value.copy(location = newLocation)
    }

    fun startEditing(event: EventItem) {
        currentEvent.value = event
    }

    // --- Firestore Real-time Sync ---
    private fun observeEvents() {
        listenerRegistration = firestore.collection("events")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.e("EventViewModel", "Listen failed.", error)
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    eventList.clear()
                    for (doc in snapshot.documents) {
                        val event = doc.toObject(EventItem::class.java)
                        if (event != null) {
                            eventList.add(event)
                        }
                    }
                }
            }
    }

    // --- Add Event ---
    fun addEvent() {
        val event = currentEvent.value
        if (event.title.isBlank()) return

        val id = UUID.randomUUID().toString()
        val newEvent = event.copy(id = id)



        firestore.collection("events")
            .document(id)
            .set(newEvent)
            .addOnSuccessListener {
                // ✅ Success listener, but no need to add manually to eventList
                println("Event added successfully")
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }

        // ✅ Immediately reset the form regardless of success
        currentEvent.value = EventItem()
    }

    // --- Update Existing Event ---
    fun updateEvent() {
        val event = currentEvent.value
        if (event.id.isBlank()) return

        firestore.collection("events")
            .document(event.id)
            .set(event)
            .addOnSuccessListener {
                Log.d("EventViewModel", "Event updated: $event")
                currentEvent.value = EventItem()
            }
            .addOnFailureListener {
                Log.e("EventViewModel", "Failed to update event", it)
            }

        currentEvent.value = EventItem()

    }

    // --- Delete Event ---
    fun deleteEvent(event: EventItem) {
        firestore.collection("events")
            .document(event.id)
            .delete()
            .addOnSuccessListener {
                Log.d("EventViewModel", "Event deleted: ${event.id}")
            }
            .addOnFailureListener {
                Log.e("EventViewModel", "Failed to delete event", it)
            }
    }



    // --- Cleanup Listener on ViewModel Destroy ---
    override fun onCleared() {
        super.onCleared()
        listenerRegistration?.remove()
    }
}
