import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    onBookmarkClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(315f / 150f)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Black)
    ) {
        // 이미지 및 그라데이션 오버레이
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // 그라데이션 오버레이
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
            )
        }

        // 컨텐츠
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 상단 평점
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = AppColors.secondary20,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.star),
                            contentDescription = "Rating",
                            modifier = Modifier.size(8.dp)
                        )
                        Text(
                            text = recipe.rating.toString(),
                            style = AppTextStyles.smallerTextRegular.copy(
                                fontSize = 8.sp,
                                color = AppColors.black
                            )
                        )
                    }
                }
            }

            // 하단 정보
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                // 레시피 정보
                Column {
                    Text(
                        text = recipe.name,
                        style = AppTextStyles.smallTextBold.copy(
                            color = Color.White,
                        ),
                        maxLines = 2,
                        modifier = Modifier.width(150.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "By ${recipe.chef}",
                        style = AppTextStyles.smallerTextRegular.copy(
                            color = AppColors.gray4
                        )
                    )
                }

                // 시간 및 북마크
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.timer),
                            contentDescription = "Timer",
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = recipe.time,
                            style = AppTextStyles.smallerTextRegular.copy(
                                color = AppColors.gray4
                            )
                        )
                    }

                    // 북마크 버튼
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color.White,
                                shape = CircleShape
                            )
                            .clickable(onClick = onBookmarkClick),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.inactive),
                            contentDescription = "Bookmark",
                            modifier = Modifier
                                .size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe(
            category = "Indian",
            id = 1,
            name = "Traditional spare ribs baked",
            image = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
            chef = "Chef John",
            time = "20 min",
            rating = 4.0f,
            ingredients = emptyList()
        )
    )
}