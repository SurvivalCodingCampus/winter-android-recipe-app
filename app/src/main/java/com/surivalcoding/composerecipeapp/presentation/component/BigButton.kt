package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    var backgroundColor = remember { mutableStateOf(AppColors.primary) }
    var isPressed = false

    Box(
        modifier = modifier
            .width(315.dp)
            .height(60.dp)
            .background(
                color = if(isPressed) AppColors.gray else AppColors.primary,
                shape = RoundedCornerShape(10.dp),
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {

                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            }
            .clickable(
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .width(114.dp)
                    .height(24.dp),
                text = text,
                style = AppTextStyles.normalTextBold.copy(
                    color = Color.White,
                ),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.padding(11.dp))
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = null,
                tint = Color.White,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    BigButton(
        text = "Button"
    )
}