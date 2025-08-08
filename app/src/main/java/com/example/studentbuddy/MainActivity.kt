package com.example.studentbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBack
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.studentbuddy.ui.screens.CampusBuddyNavGraph
import com.example.studentbuddy.ui.theme.StudentBuddyTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudentBuddyTheme {
                val navController = rememberNavController()
                val scale = remember { Animatable(0f) }

                // State to toggle splash screen visibility

                LaunchedEffect(Unit) {
                    delay(3000) // Show splash for 5 seconds

                    scale.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 1500, easing = EaseOutBack)
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {

                        Scaffold(
                            modifier = Modifier.fillMaxSize(),
                            containerColor = Color.White
                        ) { innerPadding ->
                            CampusBuddyNavGraph(
                                navController = navController,
                                innerPadding = innerPadding
                            )
                        }
                    }
                }
            }
        }
    }


