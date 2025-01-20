package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.model.Recipe

fun RecipeDto.toRecipe() = Recipe(
    category = category ?: "",
    id = id ?: 0,
    name = name ?: "",
    image = image ?: "",
    chef = chef ?: "",
    time = time ?: "",
    rating = rating ?: 0f,
    ingredients = ingredients?.map { it.toIngredientAmount() } ?: emptyList()
)