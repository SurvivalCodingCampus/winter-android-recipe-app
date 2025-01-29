package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RecipeDetailScreenRoot(
    viewModel: RecipeDetailViewModel = hiltViewModel(),
) {
    RecipeDetailScreen(
        state = viewModel.recipeDetailState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}