package com.surivalcoding.composerecipeapp.presentation.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.mock.fakeHomeRecipes
import com.surivalcoding.composerecipeapp.data.mock.fakeNewRecipes
import com.surivalcoding.composerecipeapp.data.mock.fakeUserData
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchField
import com.surivalcoding.composerecipeapp.ui.component.HomeRecipeItem
import com.surivalcoding.composerecipeapp.ui.component.NewRecipeItem
import com.surivalcoding.composerecipeapp.ui.custom.LoadingWheel
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun HomeScreen(
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    HomeScreen(
        homeUiState = homeUiState,
        onSearchClick = onSearchClick,
        onBookmarkClick = { id, bookmarked ->
            viewModel.onAction(HomeUiAction.UpdateUserBookMarked(id, bookmarked))
        },
        onCategoryChange = { category ->
            viewModel.onAction(HomeUiAction.UpdateCategory(category))
        },
        modifier = modifier,
    )
}

@Composable
private fun HomeScreen(
    homeUiState: HomeUiState,
    onSearchClick: () -> Unit,
    onBookmarkClick: (Int, Boolean) -> Unit,
    onCategoryChange: (RecipeCategory) -> Unit,
    modifier: Modifier = Modifier,
) {
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

        when (homeUiState) {
            is HomeUiState.Loaded -> {
                LazyRow(
                    contentPadding = PaddingValues(vertical = 25.dp, horizontal = 30.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(RecipeCategory.entries) { category ->
                        val selected = homeUiState.selectedCategory == category
                        NoPaddingButton(
                            onClick = { onCategoryChange(category) },
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
                    items(homeUiState.homeRecipes) { homeRecipe ->
                        val isBookmarked = homeRecipe.id in homeUiState.bookmarkedIds
                        HomeRecipeItem(
                            homeRecipe = homeRecipe,
                            isBookmarked = isBookmarked,
                            onClick = {},
                            onBookmarkClick = {
                                Log.d("testaaa", "${homeUiState.selectedCategory}")
                                onBookmarkClick(homeRecipe.id, !isBookmarked)
                            },
                            modifier = Modifier
                                .width(150.dp)
                                .height(232.dp)
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
                    items(homeUiState.newRecipes) { newRecipe ->
                        NewRecipeItem(
                            newRecipe = newRecipe,
                            onClick = {},
                            onProfileClick = {},
                            modifier = Modifier
                                .width(252.dp)
                                .height(128.dp)
                        )
                    }
                }
            }

            HomeUiState.Error -> {}
            HomeUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoadingWheel(
                        contentDescription = "home recipe loading"
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    var selectedCategory by remember { mutableStateOf(RecipeCategory.ALL) }
    ComposeRecipeAppTheme {
        HomeScreen(
            homeUiState = HomeUiState.Loaded(
                selectedCategory = selectedCategory,
                bookmarkedIds = fakeUserData.bookmarkIds,
                homeRecipes = fakeHomeRecipes,
                newRecipes = fakeNewRecipes,
            ),
            onBookmarkClick = { _, _ -> },
            onCategoryChange = {},
            onSearchClick = {}
        )
    }
}