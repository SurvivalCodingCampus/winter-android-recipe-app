package com.surivalcoding.composerecipeapp.presentation.saved_recipe

import RecipeCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SavedRecipeScreen(recipes: List<Recipe>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Saved recipes 타이틀
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = "Saved recipes",
                style = AppTextStyles.largeTextBold
                ,
                modifier = Modifier.align(Alignment.Center)  // Box 내에서 중앙 정렬
            )
        }

        // 레시피 리스트
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp), // 카드 간 간격
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(recipes) { recipe ->
                RecipeCard(
                    recipe = recipe,
                    modifier = Modifier
                )
            }
        }
    }
}
@Preview
@Composable
private fun SavedRecipeScreenPreview() {
    SavedRecipeScreen(
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
            )
            ,Recipe(
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
}