import androidx.room.*
import com.example.studentbuddy.data.models.Event
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {
    @Insert
    suspend fun insert(event: Event)

    @Delete
    suspend fun delete(event: Event)
    @Update
    suspend fun update(event: Event)

    // ... other functions ...
    @Query("SELECT * FROM events")
    fun getAllEvents(): Flow<List<Event>>
}

