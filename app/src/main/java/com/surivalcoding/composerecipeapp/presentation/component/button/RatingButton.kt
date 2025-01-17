package com.surivalcoding.composerecipeapp.presentation.component.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun RatingButton(
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    onClick: (Boolean) -> Unit = {},
) {
    val whiteStar = painterResource(R.drawable.star_white)
    val greenStar = painterResource(R.drawable.star_green)

    Row(
        modifier = modifier
            .background(
                color = if (isSelected) AppColors.primary_100 else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else AppColors.primary_80,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick(isSelected)
            }
            .padding(vertical = 5.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text, style = AppTextStyles.smallTextMedium.copy(
                color = if (isSelected) Color.White else AppColors.primary_80
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.width(5.dp))

        Image(
            painter = if (isSelected) whiteStar else greenStar,
            contentDescription = null
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun RatingButtonPreview() {
    var isSelected by remember { mutableStateOf(false) }

    RatingButton(text = "Dinner", isSelected = isSelected) {
        isSelected = !isSelected
    }
}