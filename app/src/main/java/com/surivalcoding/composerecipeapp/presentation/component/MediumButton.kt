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
fun MediumButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    iconSizePercent: Float = 1.0f,
    onClick: () -> Unit = {},
) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale
    val baseIconSize = 20.dp
    val calculatedIconSize = baseIconSize * iconSizePercent * fontScale

    Box(
        modifier = modifier
            .width(243.dp)
            .height(54.dp)
            .background(
                color = AppColors.primary100,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(9.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .width(114.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = buttonText,
                    style = AppTextStyles.normalTextBold.copy(
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Icon(
                modifier = Modifier.size(calculatedIconSize),
                imageVector = Icons.AutoMirrored.Default.ArrowForward,
                contentDescription = null,
                tint = Color.White,
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun MediumButtonPreview() {
    MediumButton(
        buttonText = "Button"
    )
}