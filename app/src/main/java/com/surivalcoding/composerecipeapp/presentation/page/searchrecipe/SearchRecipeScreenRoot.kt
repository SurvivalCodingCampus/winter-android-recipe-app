package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe

@Composable
fun SearchRecipeScreenRoot(
    onRecipeDetailClick: (Recipe) -> Unit,
    viewModel: SearchRecipeViewModel = hiltViewModel()
) {
    SearchRecipeScreen(
        state = viewModel.searchRecipeState.collectAsStateWithLifecycle().value,
        onAction = { action ->
            when (action) {
                is SearchRecipeAction.SearchRecipeDetail -> {
                    Logger.e("디테일 화면으로 이동해버려!")
                    onRecipeDetailClick(action.recipeDetail)
                }
                else -> viewModel.onAction(action)
            }
        }
    )
}