package com.surivalcoding.composerecipeapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val imageUrl: String,
    val name: String,
    val quantity: Int,
)
