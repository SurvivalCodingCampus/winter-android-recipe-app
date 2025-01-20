package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    imageUrl: String,
    recipeName: String,
    chefName: String,
    cookingTime: String,
    rate: Double,
) {
    val timerImage = painterResource(R.drawable.timer)
    val bookMarkImage = painterResource(R.drawable.union)
    val starImage = painterResource(R.drawable.star)

    Box(
        modifier = Modifier
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .aspectRatio(2f),
        contentAlignment = Alignment.TopStart,
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = recipeName,
                    modifier = Modifier.width(200.dp),
                    maxLines = 2,
                    style = AppTextStyles.smallTextBold.copy(
                        fontSize = 14.sp, color = AppColors.white
                    )
                )

                Text(
                    text = "By $chefName",
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 8.sp, color = AppColors.white
                    )
                )
            }


            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(painter = timerImage, contentDescription = null)

                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = cookingTime,
                    style = AppTextStyles.smallTextRegular.copy(color = AppColors.gray_4)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    Modifier
                        .size(24.dp)
                        .background(color = AppColors.white, shape = RoundedCornerShape(50.dp))
                ) {
                    Image(
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.Center)
                            .padding(1.dp),
                        painter = bookMarkImage, contentDescription = null
                    )
                }
            }

            Row(
                modifier = Modifier
                    .background(
                        color = AppColors.secondary20,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .align(Alignment.TopEnd)
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
                        fontSize = 8.sp, color = AppColors.black
                    ),
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQUz5gqcxMEygqQkJE73k0VMxYmoNDLOoNzA&s",
        recipeName = "Traditional spare ribs\nbaked",
        chefName = "By Chef John",
        cookingTime = "20 min",
        rate = 4.0
    )
}