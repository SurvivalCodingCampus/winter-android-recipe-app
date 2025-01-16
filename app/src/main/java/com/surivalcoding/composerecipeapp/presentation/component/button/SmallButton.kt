package com.surivalcoding.composerecipeapp.presentation.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.GestureCancellationException
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonState: ButtonState,
    onClick: (ButtonState) -> Unit = {}
) {
    Box(
        modifier = modifier
            .width(174.dp)
            .height(37.dp)
            .background(
                color = when (buttonState) {
                    ButtonState.NORMAL -> AppColors.primary_100
                    ButtonState.PRESSED -> AppColors.gray_4
                },
                shape = RoundedCornerShape(10.dp),
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        onClick(ButtonState.PRESSED)
                        try {
                            // 손을 뗄때 까지 대기하다가 떼면 상태 변경
                            awaitRelease()
                            onClick(ButtonState.NORMAL)
                        } catch (e: GestureCancellationException) {
                            onClick(ButtonState.NORMAL)
                        }
                    }
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
                    style = AppTextStyles.smallTextBold.copy(
                        color = Color.White,
                    ),
                )
            }
        }
    }
}


@Preview
@Composable
private fun SmallButtonPreview() {
    var buttonState by remember { mutableStateOf(ButtonState.NORMAL) }

    SmallButton(text = "Button", buttonState = buttonState) { newState ->
        buttonState = newState
    }
}