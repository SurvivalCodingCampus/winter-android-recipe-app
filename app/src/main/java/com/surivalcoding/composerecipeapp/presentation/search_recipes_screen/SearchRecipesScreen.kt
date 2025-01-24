package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.component.SearchInputField
import com.surivalcoding.composerecipeapp.presentation.component.SearchRecipeCard
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SearchRecipesScreen(
    modifier: Modifier = Modifier,
    state: SearchRecipeState = SearchRecipeState(),
    onValueChange: (String) -> Unit = {},
    waitSavedRecipes: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            // TopBar에 Text와 SearchInput 배치
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 54.dp, start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                Text(
                    text = "Search recipes",
                    style = AppTextStyles.mediumTextBold.copy(
                        color = AppColors.font
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    SearchInputField(
                        modifier = Modifier.weight(255f),
                        onValueChange = onValueChange,
                        placeholder = "Search recipe",
                        value = state.query,
                    )

                    Button(
                        modifier = Modifier
                            .size(40.dp)
                            .weight(40f)
                            .background(
                                color = AppColors.primary100,
                                shape = RoundedCornerShape(size = 10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                        ),

                        contentPadding = PaddingValues(0.dp),
                        onClick = {},
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = R.drawable.filter_icon),
                            contentDescription = null,
                            tint = AppColors.white,
                        )
                    }
                }

            }
        },
        content = { paddingValues ->
            // Content 영역에 LazyColumn 배치
            Box(
                modifier = Modifier
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier.padding(top = 20.dp, start = 30.dp, end = 30.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = state.searchScreenText,
                            style = AppTextStyles.mediumTextBold.copy(
                                color = AppColors.font
                            ),
                        )
                        if(state.isSearching) {
                            Text(
                                text = "${state.searchResultCount} results",
                                style = AppTextStyles.smallerTextRegular.copy(
                                    fontSize = 11.sp,
                                    lineHeight = 17.sp,
                                    color = AppColors.gray3
                                ),
                            )
                        }
                    }

                    if (state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .size(200.dp),
                            color = AppColors.primary80,
                            strokeWidth = 10.dp
                        )
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .background(color = AppColors.white)
                                .padding(top = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                        ) {
                            items(state.recipes) { recipe ->
                                SearchRecipeCard(
                                    recipe = recipe,
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
private fun SearchRecipesScreenPreview() {
    val recipe1 = Recipe(
        "Italian",
        1,
        "Traditional spare ribs baked",
        "https://www.foodnews.news/data/photos/20210728/art_16261398155074_8642d5.jpg",
        "Chef John",
        "20 min",
        4.0,
        emptyList(),
    )
    val recipes = listOf(
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1,
        recipe1
    )

    SearchRecipesScreen(
        state = SearchRecipeState(recipes)
    )
}