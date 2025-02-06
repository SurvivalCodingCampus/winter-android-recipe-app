package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.LoadingState

data class SearchRecipesState(
    val recipeList: List<Recipe> = emptyList(),
    val filteredRecipeList: List<Recipe> = emptyList(),
    val filterText: String = "",
    val loadingState: LoadingState = LoadingState(),
    val isBottomSheetVisible: Boolean = false,

    val filterState: RecipeFilterState = RecipeFilterState()
)
