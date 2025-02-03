package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import RecipeCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import com.dotlottie.dlplayer.Mode

@Composable
fun SavedRecipeScreen(
    state: SavedRecipesState,
    onRecipeClick: (Recipe) -> Unit = {},
    onBookmarkClick: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Saved recipes",
            style = AppTextStyles.largeTextBold,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                state.isLoading -> {
                    DotLottieAnimation(
                        source = DotLottieSource.Url("https://lottie.host/bb71f4a6-1af3-4f94-8fc1-534aae11ef23/CHz2ZvcxYN.lottie"),
                        autoplay = true,
                        loop = true,
                        speed = 3f,
                        useFrameInterpolation = false,
                        playMode = Mode.FORWARD,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(400.dp)
                    )
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 30.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(state.recipes) { recipe ->
                            RecipeCard(
                                recipe = recipe,
                                //onClick = { onRecipeClick(recipe) },
                                onBookmarkClick = { onBookmarkClick(recipe.id) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedRecipeScreenPreview() {
    SavedRecipeScreen(
        state = SavedRecipesState(
            recipes = listOf(
                Recipe(
                    id = 1,
                    name = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly",
                    image = "https://example.com/image.jpg",
                    rating = 4.0f,
                    time = "11",
                    category = "Chinese",
                    ingredients = emptyList()
                ),
                Recipe(
                    id = 1,
                    name = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly",
                    image = "https://example.com/image.jpg",
                    rating = 4.0f,
                    time = "11",
                    category = "Chinese",
                    ingredients = emptyList()
                ), Recipe(
                    id = 1,
                    name = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly",
                    image = "https://example.com/image.jpg",
                    rating = 4.0f,
                    time = "11",
                    category = "Chinese",
                    ingredients = emptyList()
                ), Recipe(
                    id = 1,
                    name = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly",
                    image = "https://example.com/image.jpg",
                    rating = 4.0f,
                    time = "11",
                    category = "Chinese",
                    ingredients = emptyList()
                ), Recipe(
                    id = 1,
                    name = "Spicy fried rice mix chicken bali",
                    chef = "Spicy Nelly",
                    image = "https://example.com/image.jpg",
                    rating = 4.0f,
                    time = "11",
                    category = "Chinese",
                    ingredients = emptyList()
                )
            )
        )
    )
}