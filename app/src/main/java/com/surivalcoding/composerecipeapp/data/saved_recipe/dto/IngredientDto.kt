package com.surivalcoding.composerecipeapp.data.saved_recipe.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDto(
    val id: Int?,
    val name: String?,
    val image: String?
)