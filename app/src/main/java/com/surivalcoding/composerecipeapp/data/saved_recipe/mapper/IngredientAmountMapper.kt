package com.surivalcoding.composerecipeapp.data.saved_recipe.mapper

import com.surivalcoding.composerecipeapp.data.saved_recipe.dto.IngredientAmountDto
import com.surivalcoding.composerecipeapp.data.saved_recipe.model.Ingredient
import com.surivalcoding.composerecipeapp.data.saved_recipe.model.IngredientAmount

fun IngredientAmountDto.toIngredientAmount() = IngredientAmount(
    ingredient = ingredient?.toIngredient() ?: Ingredient(0, "", ""),
    amount = amount ?: 0
)