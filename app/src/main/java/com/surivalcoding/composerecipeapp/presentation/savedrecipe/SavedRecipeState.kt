package com.surivalcoding.composerecipeapp.presentation.savedrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SavedRecipeState(
    val bookMarkList: List<Recipe> = emptyList(),
)