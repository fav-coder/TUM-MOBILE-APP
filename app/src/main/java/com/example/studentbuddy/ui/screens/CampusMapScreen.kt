package com.example.studentbuddy.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studentbuddy.R


data class Marker(val position: Offset, val title: String, val description: String)

@Composable
fun CampusMapScreen(innerPadding: PaddingValues, navController: NavController) {
    var scale by remember { mutableStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    var selectedMarker by remember { mutableStateOf<Marker?>(null) }

    val markers = listOf(
        Marker(Offset(600f, 500f), "Cafeteria", "Open from 8am to 8pm"),
        Marker(Offset(400f, 700f), "Admin Building", "Admissions and records")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale = (scale * zoom).coerceIn(1f, 5f)
                    offset += pan
                }
            }
            .padding(innerPadding)
    ) {
        // Title bar
        Text(
            "Campus Map",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 16.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Map image
        Image(
            painter = painterResource(id = R.drawable.my_map),
            contentDescription = "Campus Map",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    translationX = offset.x,
                    translationY = offset.y
                )
        )

        // Markers with custom styling
        markers.forEach { marker ->
            Box(
                modifier = Modifier
                    .offset {
                        val x = ((marker.position.x * scale) + offset.x).toInt()
                        val y = ((marker.position.y * scale) + offset.y).toInt()
                        androidx.compose.ui.unit.IntOffset(x, y)
                    }
                    .size(28.dp)
                    .background(Color.Red, shape = CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .shadow(6.dp, CircleShape)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            selectedMarker = marker
                        }
                    }
            )
        }

        // Info popup with fade animation
        AnimatedVisibility(
            visible = selectedMarker != null,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            selectedMarker?.let { marker ->
                Card(
                    modifier = Modifier
                        .offset {
                            val x = ((marker.position.x * scale) + offset.x).toInt()
                            val y = ((marker.position.y * scale) + offset.y).toInt() - 110
                            androidx.compose.ui.unit.IntOffset(x, y)
                        }
                        .width(220.dp)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f)),
                    elevation = CardDefaults.cardElevation(12.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = marker.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = marker.description, fontSize = 14.sp)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { selectedMarker = null },
                            modifier = Modifier.align(Alignment.End),
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                        ) {
                            Text("Close", color = Color.White)
                        }
                    }
                }
            }
        }

        // Reset Zoom/Pan Button
        FloatingActionButton(
            onClick = {
                scale = 1f
                offset = Offset.Zero
                selectedMarker = null
            },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        ) {
            Icon(Icons.Filled.Refresh, contentDescription = "Reset Map View")
        }

        // Zoom In Button
        FloatingActionButton(
            onClick = {
                scale = (scale * 1.2f).coerceAtMost(5f)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 96.dp),
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Zoom In")
        }

        // Zoom Out Button
        FloatingActionButton(
            onClick = {
                scale = (scale / 1.2f).coerceAtLeast(1f)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 24.dp),
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White,
            shape = CircleShape,
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        ) {
            Icon(imageVector = Icons.Filled.Remove, contentDescription = "Zoom Out")
        }

        // Legend box
        Card(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f)),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(18.dp)
                        .background(Color.Red, shape = CircleShape)
                        .border(1.dp, Color.White, CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Campus Marker", fontSize = 14.sp)
            }
        }
    }
}
