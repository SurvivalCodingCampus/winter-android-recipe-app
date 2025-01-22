package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.presentation.component.util.shimmerEffect

@Composable
fun RecipeCardLoadingUIForSearch(

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(    // 전체 화면 규격
            modifier = Modifier
                .size(150.dp)
        ) {
            Box( // 배경 이미지
                modifier = Modifier
                    .fillMaxSize(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .shimmerEffect(),
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
                    RecipeTitleForLoading(title = "")
                    RecipeChefNameForLoading(chefName = "")
                }

                Box(    // 평점을 배치하는 레이아웃
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    RecipeRateForLoading(rate = 0.0f)
                }

            }
        }

    }

}
@Preview
@Composable
private fun RecipeCardLoadingUIForSearchPreview() {
    RecipeCardLoadingUIForSearch(

    )
}