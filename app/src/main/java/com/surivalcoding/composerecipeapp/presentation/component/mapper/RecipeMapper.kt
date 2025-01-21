package com.surivalcoding.composerecipeapp.presentation.component.mapper

import com.surivalcoding.composerecipeapp.presentation.component.dto.RecipeDto
import com.surivalcoding.composerecipeapp.presentation.component.model.Recipe

fun RecipeDto.toRecipe(): Recipe {
    val foodImage = this.image ?: ""
    val title = this.name ?: ""
    val chefName = this.chef ?: ""
    val rating = this.rating ?: 0.0f
    val cookingTime = this.time?.substringBefore(" ")?.toInt() ?: 0

    return Recipe(foodImage, title, chefName, rating.toFloat(), cookingTime)
}