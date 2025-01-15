package com.surivalcoding.composerecipeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Green100,
    onPrimary = Color.White,
    primaryContainer = Green80,
    secondary = Yellow100,
    surface = Gray2,
    surfaceVariant = Gray4,
)

private val LightColorScheme = lightColorScheme(
    primary = Green100,
    onPrimary = Color.White,
    primaryContainer = Green80,
    secondary = Yellow100,
    surface = Gray2,
    surfaceVariant = Gray4,
)

@Composable
fun ComposeRecipeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}