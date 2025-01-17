package com.surivalcoding.composerecipeapp.presentation.component.global.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun BigButton(
    modifier: Modifier = Modifier,
    text: String,
    isDisable: Boolean,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        width = 315.dp,
        height = 60.dp,
        text = text,
        fontStyle = AppTextStyles.regularNormal.copy(
            fontSize = 16.sp
        ),
        iconSize = 20.dp,
        enabled = isDisable,
        onClick = onClick
    )
}
