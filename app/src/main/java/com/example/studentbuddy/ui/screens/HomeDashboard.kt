package com.example.studentbuddy.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.studentbuddy.R
import java.nio.file.WatchEvent

@Composable
fun HomeDashboard(innerPadding: PaddingValues = PaddingValues()) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {


        AsyncImage(
            model = R.drawable.kenya_map,
            contentDescription = "background image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.alpha(0.5f).fillMaxSize()
        )
        Column {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,

                )
            {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth()

                ) {

                    Icon(Icons.Default.Menu, contentDescription = "menu")

                    Icon(
                        Icons.Default.Person, contentDescription = "person"
                    )


                }


            }
            Spacer(modifier = Modifier.height(130.dp))


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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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
                    .clip(RoundedCornerShape(16.dp)) // Clip FIRST to make background + blur align
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


