package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SavedRecipeState(
    val bookMarkList: List<Recipe> = emptyList(),
    val loadingState: LoadingState = LoadingState()
)