package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.theme.Black
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.surivalcoding.composerecipeapp.ui.theme.Gray2
import com.surivalcoding.composerecipeapp.ui.theme.Gray4
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography
import com.surivalcoding.composerecipeapp.ui.theme.Rating
import com.surivalcoding.composerecipeapp.ui.theme.Secondary20

@Composable
fun RecipeCard(
    imageUrl: String,
    title: String,
    chefName: String,
    rating: String,
    cookTime: String,
    onBookmarkClick: () -> Unit = {},
    isBookmarked: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        AsyncImage(
            model = if (LocalInspectionMode.current) {
                R.drawable.img_food
            } else {
                imageUrl
            },
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(10.dp))
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(RecipeCardGradient)
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .background(Secondary20, RoundedCornerShape(20.dp))
                    .padding(7.dp, 2.dp)
                    .align(Alignment.TopEnd),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .width(12.dp)
                        .align(Alignment.CenterVertically),
                    imageVector = Icons.Filled.Star,
                    contentDescription = "Rating",
                    tint = Rating
                )
                Text(
                    text = rating,
                    style = PoppinsRegularTypography.bodySmall.copy(
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Normal,
                        color = Black
                    )
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = title,
                    style = PoppinsBoldTypography.bodyMedium.copy(
                        color = Color.White
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "By $chefName",
                    style = PoppinsRegularTypography.bodySmall.copy(
                        color = Gray4,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_timer),
                    contentDescription = "Timer",
                    tint = Gray4,
                    modifier = Modifier.size(17.dp)
                )
                Text(
                    text = "$cookTime min",
                    style = PoppinsRegularTypography.bodySmall.copy(
                        color = Gray4,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.padding(start = 4.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White, CircleShape)
                        .padding(4.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_bookmark),
                        contentDescription = "Bookmark",
                        tint = Gray2,
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeCardExample() {
    ComposeRecipeAppTheme {
        RecipeCard(
            imageUrl = "https://url.kr/6lgdsr",
            title = "Traditional Korean Fried Rice",
            chefName = "Chef Felix",
            rating = "4.0",
            cookTime = "20"
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        imageUrl = "https://url.kr/6lgdsr",
        title = "Traditional Korean Fried Ricedsafasdfasfsadadsfasdafdsddssss",
        chefName = "Chef Felix",
        rating = "4.0",
        cookTime = "20"
    )
}