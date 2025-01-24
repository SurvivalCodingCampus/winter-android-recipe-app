package com.surivalcoding.composerecipeapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.mock.fakeNewRecipes
import com.surivalcoding.composerecipeapp.data.mock.fakeRecipeDishes
import com.surivalcoding.composerecipeapp.data.model.NewRecipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.data.model.RecipeDish
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchField
import com.surivalcoding.composerecipeapp.ui.AppIcons
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlin.math.roundToInt

@Composable
fun HomeScreen(
    recipeDishes: List<RecipeDish>,
    newRecipes: List<NewRecipe>,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(RecipeCategory.ALL) }
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp, bottom = 30.dp, start = 30.dp, end = 30.dp)
        ) {
            Column {
                Text(
                    text = "Hello Jega",
                    style = AppTextStyles.largeTextSemiBold,
                    color = AppColors.Black,
                )
                Text(
                    text = "what are you doing today?",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.Gray3,
                )
            }
            Image(
                painter = painterResource(R.drawable.img_avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(AppColors.Secondary100)
            )
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            SearchField(
                enabled = false,
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color.Transparent)
                    .clickable(
                        onClick = onSearchClick
                    )
            )
        }

        LazyRow(
            contentPadding = PaddingValues(vertical = 25.dp, horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(RecipeCategory.entries) { category ->
                val selected = selectedCategory == category
                NoPaddingButton(
                    onClick = { selectedCategory = category },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selected) AppColors.Primary100 else Color.Transparent,
                        contentColor = if (selected) AppColors.White else AppColors.Primary80
                    ),
                    shape = RoundedCornerShape(10.dp),
                    contentPadding = PaddingValues(vertical = 7.dp, horizontal = 20.dp),
                    modifier = Modifier
                ) {
                    Text(
                        text = category.name,
                        style = AppTextStyles.smallerTextSemiBold,
                    )
                }
            }
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            items(recipeDishes) { recipeDish ->
                DishItem(
                    recipeDish = recipeDish,
                    isBookmarked = true
                )
            }
        }

        Text(
            text = "New Recipes",
            style = AppTextStyles.normalTextSemiBold,
            color = AppColors.Black,
            modifier = Modifier.padding(
                PaddingValues(
                    start = 30.dp,
                    top = 20.dp,
                    bottom = 4.dp
                )
            )
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.padding(top = 4.dp)
        ) {
            items(newRecipes) { newRecipe ->
                NewRecipeItem(
                    newRecipe = newRecipe,
                )
            }
        }
    }
}

@Composable
private fun DishItem(
    recipeDish: RecipeDish,
    isBookmarked: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(150.dp)
            .height(232.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(176.dp)
                .background(
                    color = AppColors.Gray4.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(10.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = recipeDish.title,
                style = AppTextStyles.smallTextSemiBold,
                color = AppColors.Gray1,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Time",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.Gray3,
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "${recipeDish.cookingMinute} Mins",
                    style = AppTextStyles.smallerTextSemiBold,
                    color = AppColors.Gray1
                )
            }
            NoPaddingButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = if (isBookmarked) AppColors.Primary80 else AppColors.Gray3,
                    containerColor = AppColors.White
                ),
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(AppIcons.outlinedBookMark),
                    contentDescription = "check bookmark",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(16.dp)
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(recipeDish.foodIconUrl),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(110.dp)
                    .align(Alignment.Center)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .background(
                        color = AppColors.Secondary20,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(vertical = 3.dp, horizontal = 7.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = AppIcons.starRate,
                    contentDescription = "rate score",
                    tint = AppColors.Rating,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "${recipeDish.rating}",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.Black
                )
            }
        }
    }
}

@Composable
fun NewRecipeItem(
    newRecipe: NewRecipe,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(252.dp)
            .height(128.dp)
    ) {
        Card(
            onClick = {},
            colors = CardDefaults.cardColors(
                containerColor = AppColors.White
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x1A000000),
                    ambientColor = Color(0xFF000000)
                )
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = newRecipe.title,
                    style = AppTextStyles.smallTextSemiBold,
                    color = AppColors.Gray1,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.width(140.dp)
                )
                Spacer(Modifier.height(10.dp))
                Row {
                    repeat(newRecipe.rating.roundToInt()) {
                        Icon(
                            imageVector = AppIcons.starRate,
                            contentDescription = "rate score",
                            tint = AppColors.Rating,
                            modifier = Modifier
                                .size(12.dp)
                                .offset(x = (-2).dp)
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(newRecipe.authorAvatarUrl),
                        contentDescription = "author avatar image",
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "By ${newRecipe.authorName}",
                        style = AppTextStyles.smallerTextRegular,
                        color = AppColors.Gray3,
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(
                        painter = painterResource(AppIcons.alarm),
                        contentDescription = "cooking time icon",
                        tint = AppColors.Gray3,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = "${newRecipe.cookingMinute} mins",
                        style = AppTextStyles.smallerTextRegular,
                        color = AppColors.Gray3
                    )
                }
            }
        }
        Image(
            painter = painterResource(newRecipe.foodIconUrl),
            contentDescription = "food image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(88.dp)
                .align(Alignment.TopEnd)
        )
    }
}

//@Preview
//@Composable
//private fun DishItemPreview() {
//    ComposeRecipeAppTheme {
//        DishItem(
//            recipeDish = fakeRecipeDishes[0],
//            isBookmarked = true
//        )
//    }
//}
//

@Preview
@Composable
private fun NewRecipeItemPreview() {
    ComposeRecipeAppTheme {
        NewRecipeItem(
            newRecipe = fakeNewRecipes[0],
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    ComposeRecipeAppTheme {
        HomeScreen(
            recipeDishes = fakeRecipeDishes,
            newRecipes = fakeNewRecipes,
            onSearchClick = {}
        )
    }
}