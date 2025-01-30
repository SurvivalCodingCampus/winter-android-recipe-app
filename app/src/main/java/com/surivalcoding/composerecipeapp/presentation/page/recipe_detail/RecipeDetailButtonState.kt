package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.RecipeDetailCategory

data class RecipeDetailButtonState(
    val buttonState: RecipeDetailCategory = RecipeDetailCategory.INGREDIENT
)