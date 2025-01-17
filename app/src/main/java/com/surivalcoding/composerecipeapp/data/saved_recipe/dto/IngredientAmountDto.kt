package com.surivalcoding.composerecipeapp.data.saved_recipe.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientAmountDto(
    val ingredient: IngredientDto?,
    val amount: Int?
)