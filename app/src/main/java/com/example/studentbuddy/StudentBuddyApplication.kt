package com.example.studentbuddy

import android.app.Application
import com.google.firebase.FirebaseApp

class StudentBuddyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
