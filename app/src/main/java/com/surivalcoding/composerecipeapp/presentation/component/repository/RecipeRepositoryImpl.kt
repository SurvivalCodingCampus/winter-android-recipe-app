package com.surivalcoding.composerecipeapp.presentation.component.repository

import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.presentation.component.mapper.toRecipe
import com.surivalcoding.composerecipeapp.presentation.component.model.Recipe
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(
    dataSource: RecipeDataSource
) : RecipeRepository {
    private var recipeData = dataSource.getRecipeData().map {
        it.toRecipe()
    }

    override suspend fun getFoodImages(query: String): List<String> {
        delay(1000L)

        return if (query == "") {
            recipeData.map {
                it.foodImage
            }
        } else {
            recipeData.filter {
                it.title.lowercase().contains(query.lowercase())
            }.map {
                it.foodImage
            }
        }
    }

    override suspend fun getRecipeTitles(query: String): List<String> {
        delay(1000L)

        return if (query == "") {
            recipeData.map {
                it.title
            }
        } else {
            recipeData.filter {
                it.title.lowercase().contains(query.lowercase())
            }.map {
                it.title
            }
        }
    }

    override suspend fun getChefNames(query: String): List<String> {
        delay(1000L)

        return if (query == "") {
            recipeData.map {
                it.chefName
            }
        } else {
            recipeData.filter {
                it.title.lowercase().contains(query.lowercase())
            }.map {
                it.chefName
            }
        }
    }

    override suspend fun getCookingTimes(): List<Int> {
        delay(1000L)
        return recipeData.map {
            it.cookingTime
        }
    }

    override suspend fun getRatings(query: String): List<Float> {
        delay(1000L)

        return if (query == "") {
            recipeData.map {
                it.rating
            }
        } else {
            recipeData.filter {
                it.title.lowercase().contains(query.lowercase())
            }.map {
                it.rating
            }
        }
    }

    override fun getDataCount(): Int {
        return recipeData.size
    }

    override fun getSearchedRecipes(query: String): List<Recipe> {
        return if (query == "") {
            recipeData
        } else {
            recipeData.filter {
                it.title.lowercase().contains(query.lowercase())
            }
        }

    }

}