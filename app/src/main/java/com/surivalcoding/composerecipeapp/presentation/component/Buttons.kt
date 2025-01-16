package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun StateButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    size: ButtonSize = ButtonSize.BIG,
    enabled: Boolean = true
) {
    val buttonColors = if (enabled) {
        AppColors.primary100
    } else {
        Color.Gray // Disable state color
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(getButtonHeight(size))
            .background(
                color = buttonColors,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(
                onClick = onClick,
//                indication = rememberRipple(),
                enabled = enabled
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = { /* Handle press state here if needed */ },
                    onTap = { onClick() }
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .width(114.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = text,
                    style = AppTextStyles.normalTextBold.copy(
                        color = Color.White,
                    ),
                )
            }
            Spacer(modifier = Modifier.width(11.dp))
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}

@Composable
fun getButtonHeight(size: ButtonSize): Dp {
    return when (size) {
        ButtonSize.BIG -> 60.dp
        ButtonSize.MEDIUM -> 54.dp
        ButtonSize.SMALL -> 37.dp
    }
}

enum class ButtonSize {
    BIG, MEDIUM, SMALL
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    StateButton(
        text = "Button",
        size = ButtonSize.BIG
    )
}

@Preview(showBackground = true)
@Composable
private fun MediumButtonPreview() {
    StateButton(
        text = "Button",
        size = ButtonSize.MEDIUM
    )
}

@Preview(showBackground = true)
@Composable
private fun SmallButtonPreview() {
    StateButton(
        text = "Button",
        size = ButtonSize.SMALL
    )
}
