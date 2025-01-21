package com.surivalcoding.composerecipeapp.presentation.component.repository

interface RecipeRepository {
    suspend fun getFoodImage(): List<String>
    suspend fun getRecipeTitles(): List<String>
    suspend fun getChefNames(): List<String>
    suspend fun getCookingTimes(): List<Int>
    suspend fun getRatings(): List<Float>
    fun getDataCount(): Int
}