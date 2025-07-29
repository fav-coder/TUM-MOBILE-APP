package com.example.studentbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.studentbuddy.ui.screens.CampusBuddyNavGraph
import com.example.studentbuddy.ui.theme.StudentBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            StudentBuddyTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Ensures white background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = Color.White // Optional: for extra white background
                    ) { innerPadding ->
                        CampusBuddyNavGraph(
                            navController = navController,
                            innerPadding = innerPadding // Pass actual padding
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudentBuddyTheme {
        Greeting("Android")
    }
}
