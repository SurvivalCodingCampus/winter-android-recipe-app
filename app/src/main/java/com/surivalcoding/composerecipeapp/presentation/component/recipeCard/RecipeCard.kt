package com.surivalcoding.composerecipeapp.presentation.component.ingredientItem

import android.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun RecipeCard() {

    val aspectRatio = 315f / 150f // 원래 비율 계산 (2.1)
    val brush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color.Black.copy(alpha = 0.8f)
        ), startY = 0f, endY = 800f
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(aspectRatio)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = AppColors.Black, shape = RoundedCornerShape(size = 10.dp)),
        contentAlignment = Alignment.BottomStart,
    ) {
        Box(modifier = Modifier
            .drawWithContent {
                drawContent()
                drawRect(brush = brush)
            }
        )
        {
            AsyncImage(
                model = if (LocalInspectionMode.current) {
                    R.drawable.ic_launcher_background
                } else {
                    "https://s3-alpha-sig.figma.com/img/2234/134e/6e53ef9148ab9085bbd1369e270f0bba?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EqiXQQNVRFWuqESZom-1RtDiC9xnbTUwd86cR8JgxmbZsq-Jt-7BUsHJqphUR76SIa1H94xf3gs7-6Ox--ScLe82XIXZGRpAv~s8ovK0RjoEDU8lIIj6H6lPXgKGXFIwFQb3oO6d5SD4~61Vw0F-fX-RJ5Q-Gp86CzooV62~PykTQuptWK~zcSWnzIcus7zB4qLWW7Kqn0Ipb2zMeNjqj2U5Dm69ouwW~mz4Aw22hJQgkw4fzVDzoPIBEWcouxuRgrL4UY8Zb020hZ8yC7AipzhgR4h6fl5zia1qRSZBgHJ~suoyk571P0HZmX0s6tfInaIOnJmPdvGa0kDp3r~qqw__"
                },
                contentDescription = "ingredient picture",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(size = 10.dp))
//                    .background(color = Color.Transparent)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 10.dp, top = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                modifier = Modifier
                    .width(37.dp)
                    .height(16.dp)
                    .background(
                        color = Color(0xFFFFE1B3), shape = RoundedCornerShape(size = 10.dp)
                    )
                    .padding(start = 7.dp, end = 7.dp),
                horizontalArrangement = Arrangement.spacedBy(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "star",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(size = 10.dp))
                        .size(8.dp)

                )
                Text(
                    "4.0", style = AppTextStyles.regularSmaller.copy(
                        fontSize = 8.sp
                    )
                )

            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Box(
                    modifier = Modifier.padding(start = 10.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            "Traditional spare ribs baked", style = AppTextStyles.boldSmall.copy(
                                color = AppColors.White,
                            )
                        )
                        Text(
                            "By Chef John", style = AppTextStyles.regularSmall.copy(
                                color = AppColors.LabelWhite,
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier.padding(start = 10.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Row(
                        modifier = Modifier.padding(top = 3.5.dp, bottom = 3.5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Timer,
                            contentDescription = "Time Icon",
                            tint = AppColors.LabelWhite,
                            modifier = Modifier.size(17.dp)
                        )
                        Text(
                            "20 min", style = AppTextStyles.boldSmall.copy(
                                color = AppColors.LabelWhite,
                            )
                        )

                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(
                                    color = Color.White, shape = RoundedCornerShape(size = 12.dp)
                                ), contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.inactive),
                                contentDescription = "union",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(size = 5.dp))
                                    .padding(4.dp)
                            )
                        }
                    }
                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun RecipieCardPreview() {
    RecipeCard()
}
