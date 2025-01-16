package com.surivalcoding.composerecipeapp.task.day2

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.util.TaskSubmissionForm

@Composable
fun TaskSubmissionPressedButton() {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    TaskSubmissionForm(
        title = "연습문제2: InputField"
    ) {
        BigButton(
            text = "Button",
            onClick = {},
            isPressed = isPressed,
            interactionSource = interactionSource
        )
    }
}