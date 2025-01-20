package com.surivalcoding.composerecipeapp.presentation.component.model

data class Recipe(
    val foodImage: String,
    val title: String,
    val chefName: String,
    val rating: Float,
    val cookingTime: Int
)