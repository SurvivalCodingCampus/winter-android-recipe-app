package com.surivalcoding.composerecipeapp.presentation.component.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipesResponse(
    val recipes: List<RecipeDto>
)

// Ingredient DTO
@Serializable
data class IngredientDto(
    val id: Int?,
    val name: String?,
    val image: String?,
)

@Serializable
data class IngredientWithAmountDto(
    val ingredient: IngredientDto? = null,
    val amount: Int? = null
)

// Recipe DTO
@Serializable
data class RecipeDto(
    val id: Int?,
    val category: String?,
    val name: String?,
    val image: String?,
    val chef: String?,
    val time: String?,
    val rating: Double?,
    val ingredients: List<IngredientWithAmountDto>? = null
)
