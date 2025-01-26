package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun NewRecipeItem(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(251.dp)
            .aspectRatio(251f / 127f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .background(
                    color = AppColors.white,
                    shape = RoundedCornerShape(10.dp)
                )
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.align(
                    Alignment.TopStart
                )
            ) {
                Text(
                    modifier = Modifier.width(140.dp),
                    text = "Input Recipe Name Please",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.gray_1,
                        fontSize = 14.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }


            // 왼쪽 하단 프로필 이미지와 셰프 이름
            Row(
                modifier = Modifier.align(
                    Alignment.BottomStart
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AsyncImage(
                    model = R.drawable.profile4,
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )

                Text(
                    text = "By James Milener",
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }

            // 오른쪽 하단 시계 이미지와 쿠킹 타임
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    painter = painterResource(R.drawable.timer),
                    contentDescription = null
                )

                Text(
                    text = "20 mins",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
        ) {
            // 이미지 로드 기능
            AsyncImage(
                model = R.drawable.new_food_1,  // drawable 이미지
                contentDescription = null,
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }


    }
}

@Preview
@Composable
private fun NewRecipeItemPreview() {
    NewRecipeItem()
}