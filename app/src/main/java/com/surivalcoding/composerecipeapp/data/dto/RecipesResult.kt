package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipesResult(
    val recipes: List<RecipeDto>? = null
)