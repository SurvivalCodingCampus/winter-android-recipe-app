package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    imageUrl: String = "",
    name: String,
    weight: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(
                color = AppColors.gray_4,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = AppColors.white,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = name,
            style = AppTextStyles.normalTextBold
        )
        Spacer(modifier = Modifier.weight(1f))


        Text(
            text = "${weight}g",
            style = AppTextStyles.smallTextRegular.copy(
                color = AppColors.gray_3
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(name = "Tomatos", weight = 500, imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJAMgbnzr2F2SJ57dvtr_SMSjDogEwXWJr_g&s")
}