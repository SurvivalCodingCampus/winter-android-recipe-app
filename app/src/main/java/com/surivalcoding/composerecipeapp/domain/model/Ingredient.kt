package com.surivalcoding.composerecipeapp.domain.model

data class Ingredient(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val weight: Int,
)