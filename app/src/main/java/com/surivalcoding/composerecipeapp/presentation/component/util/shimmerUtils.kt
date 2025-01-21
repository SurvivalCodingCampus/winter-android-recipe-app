package com.surivalcoding.composerecipeapp.presentation.component.util

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.shimmerEffect(): Modifier = composed {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Shimmer"
    )

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.2f)
    )

    drawBehind {
        val brush = Brush.linearGradient(
            colors = shimmerColors,
            start = Offset(translateAnim, translateAnim),
            end = Offset(translateAnim + size.width, translateAnim + size.height)
        )
        drawRect(brush = brush)
    }
}
