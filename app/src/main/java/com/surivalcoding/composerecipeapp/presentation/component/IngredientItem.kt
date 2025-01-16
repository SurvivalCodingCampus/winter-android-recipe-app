package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.model.Ingredient
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun IngredientItem(
    ingredient: Ingredient,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(315.dp)
            .height(76.dp)
            .background(
                color = AppColors.gray4,
                shape = RoundedCornerShape(size = 12.dp),
            ),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp)
                    .background(
                        color = AppColors.white,
                        shape = RoundedCornerShape(10.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),
                    contentScale = ContentScale.Fit,
                    model = if (LocalInspectionMode.current) {
                        ColorDrawable(Color.BLUE)
                    } else {
                        ingredient.imageUrl
                    },
                    contentDescription = ingredient.name,
                    placeholder = painterResource(R.drawable.ic_launcher_foreground)
                )
            }
            Text(
                text = ingredient.name,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                style = AppTextStyles.normalTextBold.copy(
                    color = AppColors.font
                )
            )
            Text(
                text = "${ingredient.weight}g",
                modifier = Modifier,
                style = AppTextStyles.smallerTextRegular.copy(
                    color = AppColors.gray3,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    val ingredient1 = Ingredient(
        1,
        "https://cdn.jjan.kr/data2/content/image/2009/05/14/.cache/512/20090514062503.jpg",
        "Tomatos",
        500
    )
    val ingredient2 = Ingredient(
        1,
        "https://cafe24.poxo.com/ec01/cloverowner/jNWAR67N/rbqGfE/mXzgXUJ0XZIkbU8NaohJJtT0MrejHF3j7xyJ82Kx4TS6lddKc/UcNkkvLw5qxFiFdFFHpQ==/_/web/product/big/202211/77368e8ea99a68bd609b0fa52d81eb18.png",
        "Banana",
        500
    )
    val ingredient3 = Ingredient(
        1,
        "https://www.korea.kr/goNewsRes/attaches/editor/2019.01/27/20190127224207298_MVBHMYGV.jpg",
        "Fork",
        500
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        IngredientItem(ingredient = ingredient1)
        Spacer(modifier = Modifier.height(10.dp))
        IngredientItem(ingredient = ingredient2)
        Spacer(modifier = Modifier.height(10.dp))
        IngredientItem(ingredient = ingredient3)
    }
}