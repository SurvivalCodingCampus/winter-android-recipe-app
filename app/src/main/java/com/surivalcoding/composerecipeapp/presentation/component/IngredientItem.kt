package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class Ingredient(
    val name: String,
    val amount: Int,
    val imageUrl: String
)

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    ingredient: Ingredient
) {
    Box(
        modifier = modifier
            .fillMaxWidth() // 기기 size에 맞게 채우기
            .height(76.dp)
    ) {
        // Background with opacity
        Box(
            modifier = Modifier
                .matchParentSize()
                .alpha(0.5f)
                .background(
                    color = AppColors.gray4,
                    shape = RoundedCornerShape(12.dp)
                )
        )

        // Content without opacity
        Row(
            modifier = Modifier
                .matchParentSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image container
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(
                        color = AppColors.white,
                        shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    model = if (LocalInspectionMode.current) {
                        ColorDrawable(Color.Red.toArgb())
                    } else {
                        ingredient.imageUrl
                    },
                    contentDescription = "재료 이미지",
                    contentScale = ContentScale.Crop
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = ingredient.name,
                    style = AppTextStyles.normalTextBold.copy(
                        color = AppColors.font
                    ),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "${ingredient.amount}g",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray3,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        ingredient = Ingredient(
            name = "Tomatos",
            amount = 500,
            imageUrl = "https://yt3.ggpht.com/a/AATXAJyNMXjhSQGrOzSThQ6YdEw-LmLCTSSNPqU3Wg=s900-c-k-c0xffffffff-no-rj-mo"
        )
    )
}