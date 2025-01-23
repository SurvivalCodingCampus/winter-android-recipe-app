package com.surivalcoding.composerecipeapp.presentation.component.repository

import com.surivalcoding.composerecipeapp.presentation.component.model.Recipe

interface RecipeRepository {
    suspend fun getFoodImages(query: String = ""): List<String>
    suspend fun getRecipeTitles(query: String = ""): List<String>
    suspend fun getChefNames(query: String = ""): List<String>
    suspend fun getCookingTimes(): List<Int>
    suspend fun getRatings(query: String = ""): List<Float>
    fun getDataCount(): Int
    fun getSearchedRecipes(query: String): List<Recipe>
}