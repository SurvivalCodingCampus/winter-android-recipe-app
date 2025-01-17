package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.model.Recipe


// RecipeList
@Composable
fun RecipeList(recipeList: List<Recipe>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 30.dp)
    ) {
        items(recipeList) { recipe ->
            RecipeCard(
                imageUrl = recipe.image,
                recipeName = recipe.name,
                chefName = recipe.chef,
                cookingTime = recipe.time,
                rate = recipe.rating
            )
        }
    }
}