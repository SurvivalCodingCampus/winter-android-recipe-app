package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

data class RecipeFilterState(
    val selectedTime: String = Time.All.name,
    val selectedRate: Int = 1,
    val selectedCategory: String = Category.All.name
)