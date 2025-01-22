package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

//@Composable
/*fun RecipeCard(modifier: Modifier = Modifier) {
    val foodImageUrl =
        "https://s3-alpha-sig.figma.com/img/2234/134e/6e53ef9148ab9085bbd1369e270f0bba?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EqiXQQNVRFWuqESZom-1RtDiC9xnbTUwd86cR8JgxmbZsq-Jt-7BUsHJqphUR76SIa1H94xf3gs7-6Ox--ScLe82XIXZGRpAv~s8ovK0RjoEDU8lIIj6H6lPXgKGXFIwFQb3oO6d5SD4~61Vw0F-fX-RJ5Q-Gp86CzooV62~PykTQuptWK~zcSWnzIcus7zB4qLWW7Kqn0Ipb2zMeNjqj2U5Dm69ouwW~mz4Aw22hJQgkw4fzVDzoPIBEWcouxuRgrL4UY8Zb020hZ8yC7AipzhgR4h6fl5zia1qRSZBgHJ~suoyk571P0HZmX0s6tfInaIOnJmPdvGa0kDp3r~qqw__"
    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(top = 50.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = if (LocalInspectionMode.current) {
                ColorDrawable(Color.Black.toArgb())
            } else {
                foodImageUrl
            },
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(150.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(150.dp)
                .background(color = Color.Transparent, shape = RoundedCornerShape(20.dp))
        ) {    // Spacer로 패딩 잡아줬으니 height값은 잡아줄 필요가 없다.
            Spacer(
                modifier = Modifier
                    .weight(0.03f)
            )


            Column(
                modifier = Modifier
                    .weight(0.63f)
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(0.57f)
                )
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .width(150.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = "Traditional spare ribs baked",
                        softWrap = true,
                        fontSize = 14.sp,
                        color = Color.White,
                        maxLines = 2,
                    )
                    Text(
                        modifier = Modifier,
                        text = "By Chef John",
                        fontSize = 8.sp,
                        textAlign = TextAlign.Center,
                        color = AppColors.gray,
                    )
                }

                Spacer(
                    modifier = Modifier
                        .weight(0.12f)
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.63f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(0.07f)
                )

                Row(
                    modifier = Modifier
                        .weight(0.12f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(
                        modifier = Modifier
                            .weight(0.61f)
                    )
                    Row(
                        modifier = Modifier
                            .weight(0.15f)
                            .fillMaxHeight(1f)
                            .background(
                                shape = RoundedCornerShape(10.dp),
                                color = AppColors.lightyello
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(
                            modifier = Modifier
                                .weight(0.19f)
                        )
                        Box(
                            modifier = Modifier
                                .weight(0.3f)
                        ) {
                            // 별
                            Icon(
                                modifier = Modifier,
                                imageVector = Icons.Sharp.Star,
                                contentDescription = null,
                                tint = AppColors.goldyello,
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .weight(0.03f)
                        )
                        Box(
                            modifier = Modifier
                                .weight(0.4f),
                            contentAlignment = Alignment.Center
                        ) {
                            // 평점
                            Text(text = "4.0", fontSize = 8.sp)
                        }
                        Spacer(
                            modifier = Modifier
                                .weight(0.18f)
                        )
                    }

                }


                Spacer(
                    modifier = Modifier
                        .weight(0.5f)
                )
                Row(
                    modifier = Modifier
                        .weight(0.16f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row() {
                        Box(
                            modifier = Modifier
                                .width(17.dp)
                                .height(17.dp)
                        ) {
                            // 시계 아이콘
                            Icon(
                                modifier = Modifier,
                                imageVector = Icons.Outlined.Alarm,
                                contentDescription = null,
                                tint = AppColors.gray,
                            )
                        }
                        Spacer(
                            modifier = Modifier
                                .padding(horizontal = 2.5.dp)
                        )
                        Box(
                            modifier = Modifier
                                .width(38.dp)
                                .height(17.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // 시간
                            Text(
                                text = "20 min",
                                color = AppColors.gray,
                                fontSize = 11.sp
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                    )
                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(color = Color.White)
                            .width(24.dp)
                            .height(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(16.dp)
                                .height(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            // 북마크
                            Icon(
                                modifier = Modifier,
                                imageVector = Icons.Rounded.BookmarkBorder,
                                contentDescription = null,
                                tint = AppColors.primary,
                            )
                        }

                    }

                }
                Spacer(
                    modifier = Modifier
                        .weight(0.1f)
                )
            }


            Spacer(
                modifier = Modifier
                    .weight(0.03f)
            )
        }
    }
}*/

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    foodImage: String,
    title: String,
    chefName: String,
    rate: Float,
    cookingTimeMinute: Int,
) {

    val foodImageUrl = foodImage

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(    // 전체 화면 규격
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(2f)
        ) {
            AsyncImage( // 배경 이미지
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(10.dp)),
                model = if (LocalInspectionMode.current) {
                    ColorDrawable(Color.Black.toArgb())
                } else {
                    foodImageUrl
                },
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Box(    // 내용이 들어갈 규격 사방으로 10만큼 이격시킨다.
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Column( // 음식 이름과 요리사 이름을 배치하는 레이아웃
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.BottomStart)
                ) {
                    RecipeTitle(title = title)
                    RecipeChefName(chefName = chefName)
                }

                Box(    // 평점을 배치하는 레이아웃
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    RecipeRate(rate = rate)
                }

                Row(    // 타이머 아이콘과 조리시간, 북마크 아이콘을 배치하는 레이아웃
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    RecipeTimer(cookingTimeMinute = cookingTimeMinute)
                    Spacer(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                    )
                    RecipeBookMark()
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    /*RecipeCard(
        title = "Traditional spare ribs baked",
        chefName = "John",
        rate = 4.0f,
        cookingTimeMinute = 20,
    )*/
}

@Composable
fun RecipeTitle(modifier: Modifier = Modifier, title: String) {
    Text(
        modifier = Modifier
            .width(150.dp),
        text = title,
        style = AppTextStyles.smallTextBold,
        fontSize = 14.sp,
        color = AppColors.white,
        maxLines = 2,
        //lineHeight = 19.sp,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun RecipeChefName(modifier: Modifier = Modifier, chefName: String) {
    Text(
        modifier = Modifier
            .height(12.dp),
        text = "By $chefName",
        style = AppTextStyles.smallerTextLabel,
        fontSize = 8.sp,
        color = AppColors.gray_04
    )
}

@Composable
fun RecipeRate(modifier: Modifier = Modifier, rate: Float) {
    Row(
        modifier = Modifier
            .width(42.dp)
            .height(18.dp)
            .background(color = AppColors.lightyello, shape = RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(10.dp),
            imageVector = Icons.Rounded.Star,
            colorFilter = ColorFilter.tint(AppColors.Secondary_100),
            contentDescription = null
        )

        Spacer(
            modifier = Modifier
                .padding(horizontal = 1.dp)
        )

        Box(
            modifier = Modifier
                .size(14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = rate.toString(),
                style = AppTextStyles.smallerTextLabel,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun RecipeTimer(modifier: Modifier = Modifier, cookingTimeMinute: Int) {
    Row(
        modifier = Modifier
            .width(65.dp)
            .height(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(17.dp),
            painter = painterResource(R.drawable.timer),
            colorFilter = ColorFilter.tint(AppColors.gray_04),
            contentDescription = null
        )

        Spacer(
            modifier = Modifier
                .padding(horizontal = 2.5.dp)
        )

        Box(
            modifier = Modifier
                .width(43.dp)
                .height(17.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$cookingTimeMinute min",
                style = AppTextStyles.smallerTextRegular,
                color = AppColors.gray_04,
            )
        }
    }
}

@Composable
fun RecipeBookMark(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.bookmark),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}