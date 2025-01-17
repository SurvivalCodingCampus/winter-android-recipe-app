package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientAmountDto(
    val ingredient: IngredientDto?,
    val amount: Int?
)