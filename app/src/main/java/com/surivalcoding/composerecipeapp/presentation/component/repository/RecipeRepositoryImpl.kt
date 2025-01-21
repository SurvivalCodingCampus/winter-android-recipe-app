package com.surivalcoding.composerecipeapp.presentation.component.repository

import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.presentation.component.mapper.toRecipe
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(
    dataSource: RecipeDataSource
) : RecipeRepository {
    private var recipeData = dataSource.getRecipeData().map {
        it.toRecipe()
    }

    override suspend fun getFoodImage(): List<String> {
        delay(1000L)

        return recipeData.map {
            it.foodImage
        }
    }

    override suspend fun getRecipeTitles(): List<String> {
        delay(1000L)
        return recipeData.map {
            it.title
        }
    }

    override suspend fun getChefNames(): List<String> {
        delay(1000L)
        return recipeData.map {
            it.chefName
        }
    }

    override suspend fun getCookingTimes(): List<Int> {
        delay(1000L)
        return recipeData.map {
            it.cookingTime
        }
    }

    override suspend fun getRatings(): List<Float> {
        delay(1000L)
        return recipeData.map {
            it.rating
        }
    }

    override fun getDataCount(): Int {

        return recipeData.size
    }

}