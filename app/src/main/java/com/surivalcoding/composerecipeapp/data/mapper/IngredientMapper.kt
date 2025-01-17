package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.IngredientDto
import com.surivalcoding.composerecipeapp.data.model.Ingredient

fun IngredientDto.toIngredient() = Ingredient(
    id = id ?: 0,
    name = name ?: "",
    image = image ?: ""
)