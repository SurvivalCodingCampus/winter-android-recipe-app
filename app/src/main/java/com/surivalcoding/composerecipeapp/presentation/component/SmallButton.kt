package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .width(174.dp)
            .height(37.dp)
            .background(
                color = AppColors.primary,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick()
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
                    style = AppTextStyles.smallerTextBold.copy(
                        color = Color.White,
                    ),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SmallButtonPreview() {
    SmallButton(
        text = "Button"
    )
}

@Preview(showBackground = true)
@Composable
private fun MediumButtonPreview() {
    MediumButton(
        text = "Button"
    )
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    BigButton(
        text = "Button"
    )
}