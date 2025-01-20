package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.domain.model.Recipe


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


@Composable
fun RecipeListGrid(recipeList: List<Recipe>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(recipeList) { recipe ->
            RecipeCardSquare(
                imageUrl = recipe.image,
                recipeName = recipe.name,
                chefName = recipe.chef,
                rate = recipe.rating
            )
        }
    }
}