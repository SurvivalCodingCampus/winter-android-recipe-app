package com.surivalcoding.composerecipeapp.presentation.component.datasource

import com.surivalcoding.composerecipeapp.presentation.component.dto.RecipeDto

interface RecipeDataSource {
    fun getRecipeData(): List<RecipeDto>
}