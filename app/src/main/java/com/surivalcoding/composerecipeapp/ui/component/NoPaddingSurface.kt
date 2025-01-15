package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalUseFallbackRippleImplementation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

@Composable
@NonRestartableComposable
fun NoPaddingSurface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
    ) {
        Box(
            modifier =
            modifier
                .then(if (border != null) Modifier.border(border, shape) else Modifier)
                .background(color = color, shape = shape)
                .clip(shape)
                .clickable(
                    interactionSource = interactionSource,
                    indication = rippleOrFallbackImplementation(),
                    enabled = enabled,
                    onClick = onClick
                ),
            propagateMinConstraints = false
        ) {
            content()
        }
    }
}


@Suppress("DEPRECATION_ERROR")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun rippleOrFallbackImplementation(
    bounded: Boolean = true,
    radius: Dp = Dp.Unspecified,
    color: Color = Color.Unspecified
): Indication {
    return if (LocalUseFallbackRippleImplementation.current) {
        rememberRipple(bounded, radius, color)
    } else {
        ripple(bounded, radius, color)
    }
}