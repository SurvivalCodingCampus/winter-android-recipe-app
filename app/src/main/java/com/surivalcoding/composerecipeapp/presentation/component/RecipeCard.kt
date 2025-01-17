package com.surivalcoding.composerecipeapp.presentation.component

import AppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

data class Recipe(
    val name: String,
    val authorName: String,
    val timeTaken: Int,
    val rate: Float,
    val thumbnailImageUrl: String,
    val isUserSaved: Boolean,
)

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(16.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color.Gray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    )
    {

/*        AsyncImage(
            model = recipe.thumbnailImageUrl,
            contentDescription = "Recipe Background Image",
            modifier = Modifier
                .fillMaxSize()
                ,contentScale = ContentScale.Crop
        )*/

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight(), // Column의 높이를 Row에 맞게 확장
                verticalArrangement = Arrangement.Bottom // Column 내부에서 하단에 고정
            ) {
                Text(
                    text = recipe.name,
                    style = AppTextStyles.normalTextBold.copy(
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                    ),

                    )
                Text(
                    text = "By ${recipe.authorName}",
                    style = AppTextStyles.normalTextBold.copy(
                        color = AppColors.gray4,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.W400,
                    ),
                )
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .width(37.dp)
                    .height(16.dp)
                    .background(color = AppColors.secondary20, shape = RoundedCornerShape(20.dp))
            ) {

                Icon(
                    modifier = modifier.size(8.dp),
                    imageVector = Icons.Default.Star,
                    tint = AppColors.rating,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = recipe.rate.toString(),
                    style = AppTextStyles.normalTextRegular.copy(
                        color = AppColors.black,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.W400
                    )
                )

            }
        }


    }
}

@Preview
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe(
            name = "Traditional spare ribs\nbaked",
            authorName = "Chef John",
            timeTaken = 20,
            rate = 4.5F,
            thumbnailImageUrl = "https://s3-alpha-sig.figma.com/img/2234/134e/6e53ef9148ab9085bbd1369e270f0bba?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EqiXQQNVRFWuqESZom-1RtDiC9xnbTUwd86cR8JgxmbZsq-Jt-7BUsHJqphUR76SIa1H94xf3gs7-6Ox--ScLe82XIXZGRpAv~s8ovK0RjoEDU8lIIj6H6lPXgKGXFIwFQb3oO6d5SD4~61Vw0F-fX-RJ5Q-Gp86CzooV62~PykTQuptWK~zcSWnzIcus7zB4qLWW7Kqn0Ipb2zMeNjqj2U5Dm69ouwW~mz4Aw22hJQgkw4fzVDzoPIBEWcouxuRgrL4UY8Zb020hZ8yC7AipzhgR4h6fl5zia1qRSZBgHJ~suoyk571P0HZmX0s6tfInaIOnJmPdvGa0kDp3r~qqw__",
            isUserSaved = true

        ),
    )

}