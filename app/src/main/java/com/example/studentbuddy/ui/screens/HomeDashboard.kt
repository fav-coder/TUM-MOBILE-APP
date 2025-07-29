package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.studentbuddy.R

@Composable
fun HomeDashboard(innerPadding: PaddingValues = PaddingValues(), navController: NavHostController) {

Box(
    modifier = Modifier.background(color = Color.White)
) {

    Column (
        modifier = Modifier.verticalScroll(rememberScrollState())
    ){

        AsyncImage(
            model = R.drawable.tum_image,
            contentDescription = "background image",
            contentScale = ContentScale.Fit,
            alignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxSize()
        )

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.padding(12.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            Text(text = " Everything You Need",
                fontSize = 25.sp,
                fontWeight = Bold,


            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Gray
        )

        Column(){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate("Map") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Campus Map",
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
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Class Schedule And Reminders",
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
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
                        shadowElevation = 8.dp.toPx()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Lost And Found",
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
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
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
                    .clickable { navController.navigate("QuickHelp") }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
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
                                Color.Yellow.copy(alpha = 0.3f),
                                Color.Green.copy(alpha = 0.5f)
                            )
                        )
                    )
                    .graphicsLayer {
                        alpha = 0.85f
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



}



