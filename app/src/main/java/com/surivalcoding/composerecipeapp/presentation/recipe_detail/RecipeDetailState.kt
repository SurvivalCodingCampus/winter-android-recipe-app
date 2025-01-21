package com.surivalcoding.composerecipeapp.presentation.saved_recipes.view_model

import Recipe
import com.surivalcoding.composerecipeapp.data.chef.User
import com.surivalcoding.composerecipeapp.data.recipe.review.ReviewDto

data class RecipeDetailState(
    val recipes: List<Recipe> = emptyList(),
    val reviews: List<ReviewDto> = emptyList(),
    val chefProfile: User? = null,
    val isLoading: Boolean = false
)

