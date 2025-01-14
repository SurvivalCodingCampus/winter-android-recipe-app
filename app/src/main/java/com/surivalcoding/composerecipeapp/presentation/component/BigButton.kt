package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    iconSizePercent: Float = 1.0f,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale
    val baseIconSize = 20.dp
    val calculatedIconSize = baseIconSize * iconSizePercent * fontScale

    Row(
        modifier = modifier
            .width(315.dp)
            .height(60.dp)
            .background(
                color = if (enabled) AppColors.primary100 else AppColors.gray4,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(enabled = enabled) {
                onClick()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .width(114.dp),
            text = buttonText,
            style = AppTextStyles.normalTextBold.copy(
                color = Color.White,
                textAlign = TextAlign.Center
            )
        )
        Icon(
            modifier = Modifier.size(calculatedIconSize),
            imageVector = Icons.AutoMirrored.Default.ArrowForward,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    BigButton(
        buttonText = "Button"
    )
}

@Preview(showBackground = true)
@Composable
private fun DisabledBigButtonPreview() {
    BigButton(
        buttonText = "Button",
        enabled = false
    )
}