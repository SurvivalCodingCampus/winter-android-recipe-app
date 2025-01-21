package com.surivalcoding.composerecipeapp.presentation.recipe_detail

import IngredientDto
import Recipe
import com.surivalcoding.composerecipeapp.data.chef.User
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.component.global.button.BaseButton
import com.surivalcoding.composerecipeapp.presentation.component.ingredientItem.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model.RecipeDetailState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    modifier: Modifier,
    onBackClick: () -> Boolean,
) {
    RecipeDetailScreen(
        state = state, modifier = Modifier, reviewCount = 0, onBackClick = onBackClick
    )
}


@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    modifier: Modifier,
    reviewCount: Int = 0,
    onBackClick: () -> Boolean,
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabItems = listOf("Ingredient", "Procedure")

    val recipe = state.recipes[selectedTabIndex]
    val user = state.chefProfile



    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 30.dp, bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        RecipeCard(
            recipe = recipe,
            modifier = Modifier,
            onClick = { },
            onClickBookmark = {},
            isShowingDetail = false,
        )
        //Recipe Name with reviews
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = recipe.name,
                    style = AppTextStyles.boldNormal.copy(color = AppColors.Black),
                    modifier = Modifier
                        .width(194.dp)
                        .height(41.dp)
                )

                Text(
                    text = "(${reviewCount.toString()} Reviews)",
                    style = AppTextStyles.boldNormal.copy(color = AppColors.Gray4)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    AsyncImage(
                        model = if (LocalInspectionMode.current) {
                            R.drawable.avatar
                        } else {
                            if (user != null) {
                                user.image
                            } else {
                            }
                        },
                        contentDescription = "avatar",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.size(40.dp)
                    )
                    Column(
                        modifier = Modifier, verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        if (user != null) {
                            Text(
                                text = user.name,
                                style = AppTextStyles.boldNormal,
                                modifier = Modifier
                            )
                        }
                        Row {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "rating",
                                modifier = Modifier.size(18.dp),
                                tint = AppColors.Primary100

                            )
                            if (user != null) {
                                Text(text = user.address)
                            }
                        }

                    }
                }


                BaseButton(
                    modifier = Modifier,
                    width = 100.dp,
                    height = 40.dp,
                    text = "Follow",
                    color = AppColors.Primary100,
                    fontStyle = AppTextStyles.regularNormal,
                    iconSize = 0.dp,
                    enabled = true
                ) { }

            }
        }


        TabRow(modifier = Modifier.padding(16.dp),
            tabItems = tabItems,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it })
    }


}


@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    tabItems: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                color = Color.Transparent, shape = RoundedCornerShape(10.dp)
            ), horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        tabItems.forEachIndexed { index, text ->
            TabItem(modifier = Modifier.weight(1f),
                text = text,
                isSelected = index == selectedTabIndex,
                onClick = { onTabSelected(index) })
        }
    }
}

@Composable
private fun TabItem(
    modifier: Modifier = Modifier, text: String, isSelected: Boolean, onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                color = if (isSelected) AppColors.Primary100 else Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = onClick), contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, style = AppTextStyles.regularNormal.copy(
                color = if (isSelected) Color.White else AppColors.Primary100
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun RecipeDetailPreview() {
    val recipe = Recipe(
        id = 30,
        name = "Spicy chicken burger with French fries",
        time = "10 min",
        category = "Itailian",
        image = "http://",
        chef = "steve",
        rating = 3.0,
        ingredients = listOf<IngredientDto>(IngredientDto(1, "a", "b")),
    )

    val user = User(
        id = 1,
        name = "Laura wilson",
        image = "https://",
        address = "Seoul",
    )

    RecipeDetailScreen(RecipeDetailState(recipes = listOf(recipe), chefProfile = user),
        modifier = Modifier,
        onBackClick = {
            true
        })

}