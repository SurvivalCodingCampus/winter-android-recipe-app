package com.surivalcoding.composerecipeapp.data.saved_recipe.mapper

import com.surivalcoding.composerecipeapp.data.saved_recipe.dto.IngredientDto
import com.surivalcoding.composerecipeapp.data.saved_recipe.model.Ingredient

fun IngredientDto.toIngredient() = Ingredient(
    id = id ?: 0,
    name = name ?: "",
    image = image ?: ""
)