package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDto(
    val id: Int?,
    val name: String?,
    val image: String?
)