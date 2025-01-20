package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.model.Recipe

fun RecipeDto.toMapper(): Recipe {
    return Recipe(
        id = id ?: "",
        name = name ?: "",
        authorName = authorName ?: "",
        timeTaken = timeTaken ?: 0,
        rate = rate ?: 0.0f,
        circledThumbnailImageUrl = circledThumbnailImageUrl ?: "",
        thumbnailImageUrl = thumbnailImageUrl ?: "",
        isUserSaved = isUserSaved ?: false,
        isUserReviewed = isUserReviewed ?: false,
        isUserRated = isUserRated ?: false,
        isNew = isNew ?: false,
        categories = categories ?: emptyList(),
        createdAt = createdAt ?: ""
    )
}