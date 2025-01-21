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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.util.shimmerEffect
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipeCardLoadingUI(

) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(    // 전체 화면 규격
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(2f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .shimmerEffect()
            )

            Box(    // 내용이 들어갈 규격 사방으로 10만큼 이격시킨다.
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Column( // 음식 이름과 요리사 이름을 배치하는 레이아웃
                    modifier = Modifier
                        .width(200.dp)
                        .height(54.dp)
                        .align(Alignment.BottomStart)
                ) {
                    RecipeTitleForLoading(
                        modifier = Modifier
                            .shimmerEffect(),
                        title = ""
                    )
                    RecipeChefNameForLoading(
                        modifier = Modifier
                            .shimmerEffect(),
                        chefName = ""
                    )
                }

                Box(    // 평점을 배치하는 레이아웃
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    RecipeRateForLoading(
                        modifier = Modifier
                            .shimmerEffect(),
                        rate = 0.0f
                    )
                }

                Row(    // 타이머 아이콘과 조리시간, 북마크 아이콘을 배치하는 레이아웃
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    RecipeTimerForLoading(
                        modifier = Modifier
                            .shimmerEffect(),
                        cookingTimeMinute = 0
                    )
                    Spacer(
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    RecipeBookMarkForLoading(
                        modifier = Modifier
                            .shimmerEffect()
                    )
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCardLoadingUI()
}

@Composable
fun RecipeTitleForLoading(modifier: Modifier = Modifier, title: String) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(42.dp)
            .shimmerEffect()
    ) {

    }
}

@Composable
fun RecipeChefNameForLoading(modifier: Modifier = Modifier, chefName: String) {
    Box(
        modifier = Modifier
            .width(53.dp)
            .height(12.dp)
            .shimmerEffect()
    ) {

    }

}

@Composable
fun RecipeRateForLoading(modifier: Modifier = Modifier, rate: Float) {
    Row(
        modifier = Modifier
            .width(42.dp)
            .height(18.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .shimmerEffect(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier.padding(horizontal = 1.dp)
        )

        Box(
            modifier = Modifier
                .size(14.dp)
                .shimmerEffect(),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}

@Composable
fun RecipeTimerForLoading(modifier: Modifier = Modifier, cookingTimeMinute: Int) {
    Row(
        modifier = Modifier
            .width(65.dp)
            .height(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(17.dp)
                .shimmerEffect()
        )

        Spacer(
            modifier = Modifier.padding(horizontal = 2.5.dp)
        )

        Box(
            modifier = Modifier
                .width(43.dp)
                .height(17.dp)
                .shimmerEffect(),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}

@Composable
fun RecipeBookMarkForLoading(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .shimmerEffect()
    )
}