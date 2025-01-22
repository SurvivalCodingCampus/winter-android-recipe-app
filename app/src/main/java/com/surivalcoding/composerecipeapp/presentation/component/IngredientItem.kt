package com.surivalcoding.composerecipeapp.presentation.component

import AppColors
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class Ingredient(
    val imageUrl: String,
    val name: String,
    val amount: String
)

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: Ingredient
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(AppColors.gray4, RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
        ) {
            AsyncImage(
                model = if (LocalInspectionMode.current) {
                    ColorDrawable(Color.Red.toArgb())
                } else {
                    ingredient.imageUrl
                },
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        shape = RoundedCornerShape(20.dp),
                        color = Color.White
                    ),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = ingredient.name,
                style = AppTextStyles.normalTextBold
            )
        }

        Text(
            text = ingredient.amount,
            color = AppColors.gray3,
            style = AppTextStyles.normalTextRegular
        )
    }
}

@Preview
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient(
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa3PJcdEEAKyts8YRBBBeXy-nffLrGDYlI_w&s",
            name = "Tomatos",
            amount = "500g"
        )
    )

}