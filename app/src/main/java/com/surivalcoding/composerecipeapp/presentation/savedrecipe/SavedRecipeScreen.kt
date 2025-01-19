package com.surivalcoding.composerecipeapp.presentation.savedrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.composerecipeapp.data.mock.fakeSavedRecipe
import com.surivalcoding.composerecipeapp.presentation.component.RectangleRecipeCard
import com.surivalcoding.composerecipeapp.ui.component.LoadingWheel
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SavedRecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: SavedRecipeViewModel = viewModel(factory = SavedRecipeViewModel.Factory)
) {
    val savedRecipeUiState: SavedRecipeUiState by viewModel.recipeUiState.collectAsStateWithLifecycle()

    SavedRecipeScreen(
        title = "Saved Recipes",
        savedRecipeUiState = savedRecipeUiState,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedRecipeScreen(
    title: String,
    savedRecipeUiState: SavedRecipeUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = title,
                    style = AppTextStyles.mediumTextSemiBold
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            ),
            expandedHeight = 27.dp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        when (savedRecipeUiState) {
            is SavedRecipeUiState.Success -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    items(savedRecipeUiState.recipes) { recipe ->
                        RectangleRecipeCard(
                            savedRecipe = recipe,
                            contentDescription = recipe.title,
                        )
                    }
                    item{
                        Spacer(Modifier.height(80.dp))
                    }
                }
            }

            is SavedRecipeUiState.Error -> {}
            is SavedRecipeUiState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    LoadingWheel(
                        contentDescription = "Saved Recipes 불러오는 중",
                        modifier = Modifier.size(120.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SavedRecipeScreenPreview() {
    ComposeRecipeAppTheme {
        SavedRecipeScreen(
            title = "Saved Recipes",
            savedRecipeUiState = SavedRecipeUiState.Success(fakeSavedRecipe)
        )
    }
}