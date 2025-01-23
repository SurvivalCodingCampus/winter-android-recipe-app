package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.Primary100

@Composable
fun MediumButton(
    modifier: Modifier = Modifier,
    text: String,
    iconSizePercent: Float = 1.0f,
    onClick: () -> Unit = {},
) {
    val configuration = LocalConfiguration.current
    val fontScale = configuration.fontScale
    val baseIconSize = 20.dp
    val calculateIconSize = baseIconSize * iconSizePercent * fontScale

    Box(
        modifier = modifier
            .background(
                color = Primary100,
                shape = RoundedCornerShape(10.dp),
            )
            .clickable {
                onClick()
            }
            .wrapContentHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 50.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = text,
                    style = PoppinsBoldTypography.bodyLarge.copy(
                        color = Color.White,
                    ),
                )
            }
            Spacer(modifier = Modifier.width(11.dp))
            Icon(
                modifier = Modifier
                    .size(calculateIconSize)
                    .align(Alignment.Bottom),
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
        text = "Button"
    )
}