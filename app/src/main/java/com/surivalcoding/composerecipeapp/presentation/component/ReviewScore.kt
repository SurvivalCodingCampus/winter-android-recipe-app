package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import kotlin.math.round

@Composable
fun ReviewScore(
    rating: Double,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = AppColors.Secondary20,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 7.dp, vertical = 2.dp)
    ) {
        Icon(
            imageVector = CraIcons.star,
            contentDescription = null,
            tint = AppColors.Rating,
            modifier = Modifier.width(10.dp)
        )
        Spacer(Modifier.width(3.dp))
        Text(
            text = "${round(rating * 10) / 10}",
            style = AppTextStyles.smallerTextSmallLabel,
            color = AppColors.Black
        )
    }
}