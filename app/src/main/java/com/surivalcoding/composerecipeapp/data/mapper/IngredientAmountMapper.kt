package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.IngredientAmountDto
import com.surivalcoding.composerecipeapp.data.model.Ingredient
import com.surivalcoding.composerecipeapp.data.model.IngredientAmount

fun IngredientAmountDto.toIngredientAmount() = IngredientAmount(
    ingredient = ingredient?.toIngredient() ?: Ingredient(0, "", ""),
    amount = amount ?: 0
)