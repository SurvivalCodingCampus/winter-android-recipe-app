package com.surivalcoding.composerecipeapp.presentation.item.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun NoneBorderFilterButton(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean = false,
    onClick: (Boolean) -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = if (isSelected) AppColors.primary_100 else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick(!isSelected)
            }
            .padding(vertical = 7.dp, horizontal = 20.dp)
    ) {
        Text(
            text = text,
            style =
            if (isSelected) AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 11.sp,
                color = AppColors.white
            )
            else AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 11.sp,
                color = AppColors.primary_80
            ),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun NoneBorderFilterButtonPreview() {
    NoneBorderFilterButton(text = "All")
}