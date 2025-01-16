package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class IngredientItem(
    val imageUrl: String,
    val name: String,
    val amount: String
)

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: IngredientItem,
) {

    Row(
        modifier = modifier
            .width(315.dp)
            .height(76.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(AppColors.white)
            .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = modifier
                .width(52.dp)
                .height(52.dp)
                .background(
                    color = AppColors.white
                )
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                model = if (LocalInspectionMode.current) {
                    ColorDrawable(Color.Blue.toArgb())
                } else {
                    ingredient.imageUrl
                },
                contentDescription = " cute squirrel Image",
                placeholder = painterResource(R.drawable.ic_launcher_background)

            )
        }
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = ingredient.name,
            style = AppTextStyles.normalTextBold,
            color = AppColors.black,
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = ingredient.amount,
            style = AppTextStyles.smallTextRegular,
            color = AppColors.gray1,
        )
    }
}


@Preview
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = IngredientItem(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6UK0tNdCncAjF4lqfpwPW-G1qJ7JnBZjuyg&s",
            name = "Tomato",
            amount = "500g"
        )
    )
}