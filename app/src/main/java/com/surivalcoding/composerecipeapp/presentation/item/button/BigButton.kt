package com.surivalcoding.composerecipeapp.presentation.item.button

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.GestureCancellationException
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
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
fun BigButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonState: ButtonState,
    onClick: (ButtonState) -> Unit = {},
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
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
fun AllButton(text: String) {
    var bigButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    var mediumButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    var smallButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BigButton(text = text, buttonState = bigButtonState) { newState ->
            bigButtonState = newState
        }
        Spacer(modifier = Modifier.height(30.dp))
        MediumButton(text = text, buttonState = mediumButtonState) { newState ->
            mediumButtonState = newState
        }
        Spacer(modifier = Modifier.height(30.dp))
        SmallButton(text = text, buttonState = smallButtonState) { newState ->
            smallButtonState = newState
        }
    }
}

@Composable
fun AllButtonPressed(text: String) {
    var bigButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    var mediumButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    var smallButtonState by remember { mutableStateOf(ButtonState.NORMAL) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BigButton(text = text, buttonState = ButtonState.PRESSED) { newState ->
            bigButtonState = newState
        }
        Spacer(modifier = Modifier.height(30.dp))
        MediumButton(text = text, buttonState = ButtonState.PRESSED) { newState ->
            mediumButtonState = newState
        }
        Spacer(modifier = Modifier.height(30.dp))
        SmallButton(text = text, buttonState = ButtonState.PRESSED) { newState ->
            smallButtonState = newState
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    var buttonState by remember { mutableStateOf(ButtonState.NORMAL) }

    BigButton(
        text = "Button",
        buttonState = buttonState
    ) { newState ->
        buttonState = newState
    }
}

@Preview(showBackground = true)
@Composable
private fun AllButtonPreview() {
    AllButton(text = "Button")
}


@Preview(showBackground = true)
@Composable
private fun AllButtonPressedPreview() {
    AllButtonPressed(text = "Button")
}

