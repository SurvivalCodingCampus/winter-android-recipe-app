package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.Icon
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import java.time.LocalDateTime

data class Recipe(
    val id: String,
    val name: String,
    val authorName: String,
    val timeTaken: Int,
    val rate: Float,
    val circledThumbnailImageUrl: String,
    val thumbnailImageUrl: String,
    val isUserSaved: Boolean,
    val isUserReviewed: Boolean,
    val isUserRated: Boolean,
    val isNew: Boolean,
    val categories: List<String>,
    val createdAt: LocalDateTime
)

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
) {
    Box(
        modifier = modifier
            .width(315.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Gray)
    ) {
        // 배경 이미지
        AsyncImage(
            model = recipe.thumbnailImageUrl,
            contentDescription = "Recipe Thumbnail",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            error = painterResource(id = R.drawable.ic_launcher_background) // 오류 시 기본 이미지
        )

        // 내용물
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End, // 오른쪽 정렬
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 평점 (오른쪽 상단)
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.White.copy(alpha = 0.8f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Row(

                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star Icon",
                            tint = Color.Yellow,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "${recipe.rate}",
                            style = AppTextStyles.smallTextRegular,
                            color = AppColors.black,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f)) // 아래쪽으로 밀기

            // 제목 및 작성자 정보
            Text(
                text = recipe.name,
                style = AppTextStyles.normalTextBold,
                color = Color.White
            )
            Text(
                text = "By ${recipe.authorName}",
                style = AppTextStyles.smallTextRegular,
                color = Color.White.copy(alpha = 0.8f)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 시간 및 저장 아이콘
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                        model = R.drawable.ic_time,
                        contentDescription = "Time Icon",
                        modifier = Modifier.size(16.dp),
                        placeholder = painterResource(id = R.drawable.ic_launcher_background),

                    )
                    Text(
                        text = "${recipe.timeTaken} min",
                        style = AppTextStyles.smallTextRegular,
                        color = Color.White,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                // 저장 아이콘
                Icon(
                    painter = painterResource(id = if (recipe.isUserSaved) R.drawable.ic_saved else R.drawable.ic_save),
                    tint = AppColors.gray1,
                    contentDescription = "Save Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe(
            id = "1",
            name = "JMT Egg",
            authorName = "Rami",
            timeTaken = 10,
            rate = 5.0f,
            circledThumbnailImageUrl = "",
            thumbnailImageUrl = "https://png.pngtree.com/png-vector/20231016/ourlarge/pngtree-breakfast-fried-egg-png-image_10198332.png",
            isUserSaved = false,
            isUserReviewed = false,
            isUserRated = true,
            isNew = false,
            categories = listOf("Italian", "Pasta"),
            createdAt = LocalDateTime.now()
        )
    )
}
