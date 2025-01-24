package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.UserDto
import com.surivalcoding.composerecipeapp.domain.model.User

fun UserDto.toUser() = User(
    userId = userId ?: 0,
    name = name ?: "",
    savedRecipesId = savedRecipesId ?: emptyList()
)