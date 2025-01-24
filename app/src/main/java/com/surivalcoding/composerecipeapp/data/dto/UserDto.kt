package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
class UserDto(
    val userId: Int? = null,
    val name: String? = null,
    val savedRecipesId: List<Int>? = null
)