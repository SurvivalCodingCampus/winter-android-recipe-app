package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import Recipe
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.ingredientItem.RecipeCard
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SavedRecipesScreen(
    recipe: List<Recipe>,
    onRecipeClick: (Recipe) -> Unit,
    onBookmarkClick: (Recipe) -> Unit
) {
    var recipeList by remember { mutableStateOf(recipe) }
    recipeList = recipe


    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text("Saved recipes", style = AppTextStyles.boldMedium)
        LazyColumn(
            modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = recipeList.size,
                key = { index -> recipe[index].id },  // 각 레시피의 고유 ID를 키로 사용
                contentType = { "recipe" }
            ) { index ->
                RecipeCard(
                    recipe = recipe[index],
                    onClick = { onRecipeClick(recipe[index]) },
                    onClickBookmark = { onBookmarkClick(recipe[index]) },
                    modifier = Modifier
                )
            }
        }
    }
}

@Preview
@Composable
fun SavedRecipesScreenPreview() {

//    SavedRecipesScreen(
//        recipes = dummyRecipes,
//        onRecipeClick = {},
//        onBookmarkClick = {}
//    )
}