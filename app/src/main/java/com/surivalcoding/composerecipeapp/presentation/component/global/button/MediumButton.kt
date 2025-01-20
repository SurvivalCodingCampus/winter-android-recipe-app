package com.surivalcoding.composerecipeapp.presentation.component.global.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MediumButton(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseButton(
        modifier = modifier,
        width = 243.dp,
        height = 54.dp,
        text = text,
        iconSize = 16.dp,
        fontStyle = AppTextStyles.regularNormal.copy(
            fontSize = 16.sp
        ),
        onClick = {}
    )
}
