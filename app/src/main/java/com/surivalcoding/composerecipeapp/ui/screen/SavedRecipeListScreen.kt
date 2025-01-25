package com.surivalcoding.composerecipeapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.usecase.GetRecipesUseCase
import com.surivalcoding.composerecipeapp.ui.component.RecipeCard
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.Primary80
import com.surivalcoding.composerecipeapp.ui.viewmodel.RecipeViewModel

@Composable
fun SavedRecipeListScreen() {
    val repository = remember { RecipeRepositoryImpl() }
    val useCase = remember { GetRecipesUseCase(repository) }
    val viewModel = remember { RecipeViewModel(useCase) }

    val recipes = viewModel.recipes.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp),
            text = "Saved Recipes",
            style = PoppinsBoldTypography.bodyLarge,
        )

        if (isLoading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = Primary80
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(30.dp, 10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(recipes.value) { recipe ->
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
}

@Preview(
    showBackground = true
)
@Composable
fun RecipeListScreenPreview() {
    ComposeRecipeAppTheme {
        SavedRecipeListScreen()
    }
}