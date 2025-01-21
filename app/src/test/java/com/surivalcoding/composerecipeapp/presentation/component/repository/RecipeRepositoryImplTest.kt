package com.surivalcoding.composerecipeapp.presentation.component.repository

import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSourceImpl
import org.junit.Assert.*

import org.junit.Test

class RecipeRepositoryImplTest {

    val recipeRepositoryImpl = RecipeRepositoryImpl(RecipeDataSourceImpl())

    @Test
    fun getRecipeTitles() {
        val recipeTitles = recipeRepositoryImpl.getRecipeTitles()

        assertTrue(recipeTitles.size == 10)
    }

    @Test
    fun getChefNames() {
    }

    @Test
    fun getCookingTimes() {
    }

    @Test
    fun getRatings() {
        val recipeRates = recipeRepositoryImpl.getRatings()

        assertTrue(recipeRates.size == 10)

        recipeRates.forEachIndexed { index, value ->
            println("index: $index, value: $value")
        }
    }

    @Test
    fun getDataCount() {
    }
}