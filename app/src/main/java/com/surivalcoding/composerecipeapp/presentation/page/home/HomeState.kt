package com.surivalcoding.composerecipeapp.presentation.page.home

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category

data class HomeState(
    val recipeList: List<Recipe> = emptyList(),
    val filteredRecipeList: List<Recipe> = emptyList(),
    val pickerState: PickerState = PickerState(buttonState = Category.All),
    val newRecipeList: List<Recipe> = emptyList(),
)
