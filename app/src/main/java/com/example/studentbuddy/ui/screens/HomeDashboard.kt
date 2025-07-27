package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.studentbuddy.R
import java.nio.file.WatchEvent

@Composable
fun HomeDashboard(innerPadding: PaddingValues = PaddingValues(), navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()

    ) {


        AsyncImage(
            model = R.drawable.kenya_map,
            contentDescription = "background image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .alpha(0.5f)
                .fillMaxSize()
        )

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,

                )

            {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),


                    )


                {
                    Image(
                        painter = painterResource(id = R.drawable.mobasa_tum),
                        contentDescription = "Campus Logo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape)
                    )
                }


            }
            Spacer(modifier = Modifier.height(90.dp))


            Text(
                text = "Welcome to TUM Mombasa!",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.LightGray,
                modifier = Modifier.padding(19.dp),

                )
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("map") }  // <-- This line
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Campus Navigation",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("ClassScheduleAndReminders") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Class Schedule and Reminders",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }



            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("Events") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Events",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("LostAndFound") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Lost and Found",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("QuickHelp") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Quick Help",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("QuickFAQ") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White.copy(alpha = 0.2f),
                                Color.White.copy(alpha = 0.05f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f // Slightly more visible
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Quick FAQ",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
        }
    }


}
