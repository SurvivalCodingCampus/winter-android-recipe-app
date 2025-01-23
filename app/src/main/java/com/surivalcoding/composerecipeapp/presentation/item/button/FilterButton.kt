package com.surivalcoding.composerecipeapp.presentation.item.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun FilterButton(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: (Boolean) -> Unit = {},
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = if (isSelected) AppColors.primary_100 else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else AppColors.primary_80,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable {
                onClick(isSelected)
            }
            .padding(vertical = 5.dp, horizontal = 10.dp)
    ) {
        Text(text = text, color = if (isSelected) Color.White else AppColors.primary_80)
    }
}


@Preview(showBackground = true)
@Composable
private fun FilterButtonPreview() {
    var isSelected by remember { mutableStateOf(false) }
    FilterButton(text = "Text", isSelected = isSelected) {
        isSelected = !isSelected
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterButtonPreviewPressed() {
    var isSelected by remember { mutableStateOf(false) }
    FilterButton(text = "Text", isSelected = true) {
        isSelected = !isSelected
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingButtonPreview () {
    var isSelected by remember { mutableStateOf(false) }
    RatingButton(text = "5", isSelected = isSelected) {
        isSelected = !isSelected
    }

}


@Preview(showBackground = true)
@Composable
private fun RatingButtonPreviewPressed () {
    var isSelected by remember { mutableStateOf(false) }
    RatingButton(text = "5", isSelected = true) {
        isSelected = !isSelected
    }

}