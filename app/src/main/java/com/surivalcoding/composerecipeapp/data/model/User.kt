package com.surivalcoding.composerecipeapp.data.model

data class User(
    val userId: Int,
    val name: String,
    val savedRecipesId: List<Int>,
)