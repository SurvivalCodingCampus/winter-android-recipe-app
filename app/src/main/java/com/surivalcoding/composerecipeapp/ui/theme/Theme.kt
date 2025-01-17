package com.surivalcoding.composerecipeapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.surivalcoding.composerecipeapp.ui.AppColors


private val LightColorScheme = lightColorScheme(
    primary = AppColors.Primary80,
    onPrimary = AppColors.White,
    primaryContainer = AppColors.Primary100,
    onPrimaryContainer = AppColors.White,
    secondary = AppColors.Secondary80,
    onSecondary = AppColors.White,
    secondaryContainer = AppColors.Secondary100,
    onSecondaryContainer = AppColors.White,
    tertiary = AppColors.Secondary60,
    onTertiary = AppColors.Black,
    error = AppColors.Warning,
    onError = AppColors.White,
    errorContainer = AppColors.WarningLight,
    onErrorContainer = AppColors.Warning,
    background = AppColors.White,
    onBackground = AppColors.Black,
    surface = AppColors.White,
    onSurface = AppColors.Black,
    surfaceVariant = AppColors.Gray4,
    onSurfaceVariant = AppColors.Gray1
)

private val DarkColorScheme = darkColorScheme(
    primary = AppColors.Primary100,
    onPrimary = AppColors.White,
    primaryContainer = AppColors.Primary80,
    onPrimaryContainer = AppColors.White,
    secondary = AppColors.Secondary100,
    onSecondary = AppColors.White,
    secondaryContainer = AppColors.Secondary80,
    onSecondaryContainer = AppColors.White,
    tertiary = AppColors.Secondary80,
    onTertiary = AppColors.White,
    error = AppColors.Warning,
    onError = AppColors.White,
    errorContainer = AppColors.Warning,
    onErrorContainer = AppColors.White,
    background = AppColors.Black,
    onBackground = AppColors.White,
    surface = AppColors.Gray1,
    onSurface = AppColors.White,
    surfaceVariant = AppColors.Gray2,
    onSurfaceVariant = AppColors.White
)


object DesignTokens {
    // Layout
    object Layout {
        // Figma screen size
        const val FIGMA_SCREEN_WIDTH = 375f
        const val FIGMA_SCREEN_HEIGHT = 823f
    }

    // Spacing (Figma px values)
    object Spacing {
        val small = 8
        val medium = 16
        val large = 24
        val xlarge = 32
    }

    // Component sizes (Figma px values)
    object Components {
        val buttonWidth = 315
        val buttonHeight = 60
        val iconSize = 24
        val inputHeight = 48
    }
}


@Composable
fun ComposeRecipeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}