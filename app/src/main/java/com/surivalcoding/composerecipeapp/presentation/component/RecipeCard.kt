//package com.surivalcoding.composerecipeapp.presentation.component
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalInspectionMode
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import coil3.compose.AsyncImage
//import com.surivalcoding.composerecipeapp.R
//import com.surivalcoding.composerecipeapp.ui.AppColors
//import com.surivalcoding.composerecipeapp.ui.AppTextStyles
//import java.time.LocalDateTime
//
//data class Recipe(
//    val id: String,
//    val name: String,
//    val authorName: String,
//    val timeTaken: Int,
//    val rate: Float,
//    val circledThumbnailImageUrl: String,
//    val thumbnailImageUrl: String,
//    val isUserSaved: Boolean,
//    val isUserReviewed: Boolean,
//    val isUserRated: Boolean,
//    val isNew: Boolean,
//    val categories: List<String>,
//    val createdAt: LocalDateTime
//)
//
//
//@Composable
//fun RecipeCard(
//    modifier: Modifier = Modifier,
//    recipe: Recipe,
//) {
//    Box(
//        modifier = modifier
//            .width(315.dp)
//            .height(150.dp)
//            .background(
//                color = AppColors.gray4,
//                shape = RoundedCornerShape(12.dp)
//            )
//            .padding(16.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight()
//                    .background(Color.Red)
//            ) {
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    AsyncImage(
//                        model = if (LocalInspectionMode.current) {
//                            R.drawable.ic_launcher_background
//                        } else {
//                            recipe.circledThumbnailImageUrl
//                        },
//                        contentDescription = "Recipe Thumbnail",
//                        modifier = Modifier.size(40.dp),
//                        contentScale = ContentScale.Crop,
//                        placeholder = painterResource(id = R.drawable.ic_launcher_background)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Column {
//                        Text(
//                            text = recipe.name,
//                            style = AppTextStyles.normalTextBold,
//                            color = AppColors.black
//                        )
//                        Text(
//                            text = recipe.authorName,
//                            style = AppTextStyles.smallTextRegular,
//                            color = AppColors.gray1
//                        )
//                    }
//                }
//            }
//            Column(
//                modifier = Modifier
//                    .weight(2f)
//                    .fillMaxHeight()
//                    .background(Color.Blue)
//            ) {
//                Column {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        repeat(5) { index ->
//                            AsyncImage(
//                                model = if (index < recipe.rate.toInt()) R.drawable.ic_star_filled else R.drawable.ic_star_border,
//                                contentDescription = "Star",
//                                modifier = Modifier.size(16.dp),
//                                placeholder = painterResource(id = R.drawable.ic_launcher_background)
//                            )
//                        }
//                    }
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        AsyncImage(
//                            model = R.drawable.ic_time,
//                            contentDescription = "Time",
//                            modifier = Modifier.size(16.dp),
//                            placeholder = painterResource(id = R.drawable.ic_launcher
//                            )
//                        )
//                    }
//                }
//            }
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun RecipeCardPreview() {
//    RecipeCard(
//        recipe = Recipe(
//            id = "1",
//            name = "Spaghetti Carbonara",
//            authorName = "Italian",
//            timeTaken = 30,
//            rate = 4.5f,
//            circledThumbnailImageUrl = "https://via.placeholder.com/40",
//            thumbnailImageUrl = "https://via.placeholder.com/315x150",
//            isUserSaved = true,
//            isUserReviewed = false,
//            isUserRated = true,
//            isNew = false,
//            categories = listOf("Italian", "Pasta"),
//            createdAt = LocalDateTime.now()
//        )
//    )
//}