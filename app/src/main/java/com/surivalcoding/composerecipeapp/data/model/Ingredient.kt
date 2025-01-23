package com.surivalcoding.composerecipeapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val quantity: Int,
    val name: String,
    val imageUrl: String,
)
