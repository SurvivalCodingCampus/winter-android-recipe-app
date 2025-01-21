package com.surivalcoding.composerecipeapp.data.recipe

import Recipe
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

interface RecipeRepository {
    suspend fun getSearchRecipes(keyword: String): RResult<List<Recipe>, CustomError>
    suspend fun createRecipe(recipe: Recipe): RResult<Unit, CustomError>
    suspend fun getRecipeById(recipeId: String): RResult<Recipe, CustomError>
    suspend fun getRecipes(time: Int? = null, rate: Float? = null, category: String? = null): RResult<List<Recipe>, CustomError>
    suspend fun putRecipeById(recipeId: String, recipe: Recipe): RResult<Unit,CustomError>
    suspend fun deleteRecipeById(recipeId: String): RResult<Unit, CustomError>
    suspend fun thumbsUp(recipeId: String): RResult<Unit,CustomError>
    suspend fun thumbsDown(recipeId: String): RResult<Unit,CustomError>
    suspend fun getRecipeUrlById(recipeId: String): RResult<String, CustomError>
    suspend fun rateRecipeById(recipeId: String, rating: Float): RResult<Unit,CustomError>
    suspend fun getOwnRecipes(): RResult<List<Recipe>, CustomError>
    suspend fun getSavedRecipes(): RResult<List<Recipe>, CustomError>
    suspend fun saveRecipe(recipeId: String): RResult<Unit, CustomError>
    suspend fun unsavedRecipe(recipeId: String): RResult<Unit, CustomError>
    suspend fun checkSavedRecipeIds(): RResult<List<String>, CustomError>
    suspend fun getRecipeDetailByChefName(chefName: String): RResult<Recipe, CustomError>
}

