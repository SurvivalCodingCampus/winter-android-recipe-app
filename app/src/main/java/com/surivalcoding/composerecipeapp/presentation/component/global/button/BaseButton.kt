package com.surivalcoding.composerecipeapp.presentation.component.global.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    width: Dp,
    height: Dp,
    text: String,
    color: Color = AppColors.Primary100,
    fontStyle: TextStyle,
    iconSize: Dp,
    enabled: Boolean = false,
    onClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor by remember {
        derivedStateOf {
            when {
                !enabled -> AppColors.Gray1
                isPressed -> AppColors.Gray4
                else -> color
            }
        }
    }

    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = enabled,
            ) {
                onClick()
            }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp),
            ),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.width(114.dp),
                text = text,
                style = fontStyle.copy(
                    color = AppColors.White,
                    textAlign = TextAlign.Center
                )
            )
            if (iconSize != 0.dp) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.AutoMirrored.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.White,

                    )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ButtonsPreview() {
    BigButton(
        text = "Big Button", onClick = { println("hello world")},
        isDisable = true
    )
}