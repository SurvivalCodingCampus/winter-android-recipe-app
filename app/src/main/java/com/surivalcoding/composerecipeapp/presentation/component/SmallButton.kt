package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    buttonText: String,
) {
    var isPressed by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .width(174.dp)
            .height(37.dp)
            .background(
                color = if (isPressed) AppColors.gray4 else AppColors.primary100,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        isPressed = true
                        tryAwaitRelease()
                        isPressed = false
                    }
                )
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .width(114.dp),
            text = buttonText,
            style = AppTextStyles.smallerTextBold.copy(
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SmallButtonPreview() {
    SmallButton(
        buttonText = "Button"
    )
}
