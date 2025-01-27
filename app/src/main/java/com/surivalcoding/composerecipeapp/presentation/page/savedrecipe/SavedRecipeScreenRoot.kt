package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SavedRecipeScreenRoot(
    viewModel: SavedRecipeViewModel = hiltViewModel()
) {
    SavedRecipeScreen(
        state = viewModel.savedRecipeState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}