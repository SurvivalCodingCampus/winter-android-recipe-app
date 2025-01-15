package com.surivalcoding.composerecipeapp.presentation.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
    Box(
        modifier = modifier
            .width(315.dp)
            .height(60.dp)
            .background(
                color = AppColors.primary_100,
                shape = RoundedCornerShape(10.dp),
            )
            .clickable { onClick() },
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
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BigButton(text = text)
        Spacer(modifier = Modifier.height(30.dp))
        MediumButton(text = text)
        Spacer(modifier = Modifier.height(30.dp))
        SmallButton(text = text)
    }
}

@Preview(showBackground = true)
@Composable
private fun BigButtonPreview() {
    BigButton(
        text = "Button"
    )
}

@Preview(showBackground = true)
@Composable
private fun AllButtonPreview() {
    AllButton(text = "Button")
}