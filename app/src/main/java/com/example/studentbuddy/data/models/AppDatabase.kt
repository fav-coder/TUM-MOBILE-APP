// app/src/main/java/com/example/studentbuddy/data/models/AppDatabase.kt
package com.example.studentbuddy.data.models

import EventDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Event::class], // Kotlin array syntax
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "studentbuddy.db"
                )
                    .fallbackToDestructiveMigration(false) // For development only
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}