package com.surivalcoding.composerecipeapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.local.mock.MockRecipeData
import com.surivalcoding.composerecipeapp.ui.component.RecipeCard
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.viewmodel.RecipeViewModel

@Composable
fun SavedRecipeListScreen(viewModel: RecipeViewModel, modifier: Modifier = Modifier) {
    val recipes = viewModel.recipes.collectAsState()

    LazyColumn(
        modifier = modifier
            .padding(30.dp, 10.dp)
    ) {
        items(recipes.value) { recipe ->
            RecipeCard(
                imageUrl = recipe.thumbnailUrl,
                title = recipe.title,
                chefName = recipe.chefName,
                rating = recipe.rating.toString(),
                cookTime = recipe.cookingMinute.toString(),
            )
        }
    }
}

@Composable
fun RecipeListScreenStub() {
    val mockRecipes = MockRecipeData.mockRecipes

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp),
            text = "Saved Recipes",
            style = PoppinsBoldTypography.bodyLarge,
        )

        LazyColumn(
            modifier = Modifier
                .padding(30.dp, 10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(mockRecipes) { recipe ->
                RecipeCard(
                    imageUrl = recipe.thumbnailUrl,
                    title = recipe.title,
                    chefName = recipe.chefName,
                    rating = recipe.rating.toString(),
                    cookTime = recipe.cookingMinute.toString()
                )
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RecipeListScreenPreview() {
    RecipeListScreenStub()
}