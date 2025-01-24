package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RatingMark(
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
    rate: Double,
) {
    val starImage = painterResource(R.drawable.star)
    Row(
        modifier = modifier
            .background(
                color = AppColors.secondary20,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 7.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Image(
            painter = starImage,
            modifier = Modifier
                .size(8.dp)
                .offset(y = ((-0.5).dp)),
            contentDescription = null,
        )

        Text(
            text = rate.toString(),
            style = AppTextStyles.smallTextRegular.copy(
                fontSize = fontSize, color = AppColors.black
            ),
        )
    }
}
