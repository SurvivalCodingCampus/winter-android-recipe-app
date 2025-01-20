package com.surivalcoding.composerecipeapp.presentation.component.repository

import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.presentation.component.mapper.toRecipe

class RecipeRepositoryImpl(
    dataSource: RecipeDataSource
) : RecipeRepository {
    private var recipeData = dataSource.getRecipeData().map {
        it.toRecipe()
    }

    override fun getFoodImage(): List<String> {
        return recipeData.map {
            it.foodImage
        }
    }

    override fun getRecipeTitles(): List<String> {
        return recipeData.map {
            it.title
        }
    }

    override fun getChefNames(): List<String> {
        return recipeData.map {
            it.chefName
        }
    }

    override fun getCookingTimes(): List<Int> {
        return recipeData.map {
            it.cookingTime
        }
    }

    override fun getRatings(): List<Float> {
        return recipeData.map {
            it.rating
        }
    }

    override fun getDataCount(): Int {
        return recipeData.size
    }

}