package com.example.studentbuddy.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = TumYellowOrange,
    onPrimary = White,

    secondary = TumGreen,
    onSecondary = White,

    tertiary = LightOrange,
    onTertiary = Black,

    background = White, // Always white
    onBackground = Black,

    surface = White, // Always white
    onSurface = Black


)

@Composable
fun StudentBuddyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
