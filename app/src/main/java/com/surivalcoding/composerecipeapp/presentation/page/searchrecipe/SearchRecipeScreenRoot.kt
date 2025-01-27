package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SearchRecipeScreenRoot(
    viewModel: SearchRecipeViewModel = hiltViewModel()
) {
    SearchRecipeScreen(
        state = viewModel.searchRecipeState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}