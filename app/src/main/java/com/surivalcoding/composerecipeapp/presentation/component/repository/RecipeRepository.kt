package com.surivalcoding.composerecipeapp.presentation.component.repository

interface RecipeRepository {
    fun getFoodImage(): List<String>
    fun getRecipeTitles(): List<String>
    fun getChefNames(): List<String>
    fun getCookingTimes(): List<Int>
    fun getRatings(): List<Float>
    fun getDataCount(): Int
}