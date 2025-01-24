package com.surivalcoding.composerecipeapp.domain.model

data class User(
    val userId: Int,
    val name: String,
    val savedRecipesId: List<Int>,
)