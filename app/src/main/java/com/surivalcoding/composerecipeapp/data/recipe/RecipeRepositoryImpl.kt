package com.surivalcoding.composerecipeapp.data.recipe

import Recipe
import RecipeDataSource
import com.surivalcoding.composerecipeapp.data.recipe.data_source.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource = RecipeDataSourceImpl()
) : RecipeRepository {
    override suspend fun getSearchRecipes(keyword: String): RResult<List<Recipe>, CustomError> {
        try {
            val recipes = recipeDataSource.getSearchRecipes(keyword)

            return RResult.Success(recipes)
        } catch (e: Exception) {

            return RResult.Error(CustomError.ServerError.UnknownError(
                details = e.message ?: "알수 없는 에러"
            ))
        }

    }

    override suspend fun createRecipe(recipe: Recipe): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeById(recipeId: String): RResult<Recipe, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipes(
        time: Int?,
        rate: Float?,
        category: String?
    ): RResult<List<Recipe>, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun putRecipeById(
        recipeId: String,
        recipe: Recipe
    ): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteRecipeById(recipeId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun thumbsUp(recipeId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun thumbsDown(recipeId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeUrlById(recipeId: String): RResult<String, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun rateRecipeById(
        recipeId: String,
        rating: Float
    ): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getOwnRecipes(): RResult<List<Recipe>, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedRecipes(): RResult<List<Recipe>, CustomError> {
        try {
            val recipes = recipeDataSource.getSearchRecipes("")

            delay(1000)
            return RResult.Success(recipes)
        } catch (e: Exception) {
            
            return RResult.Error(CustomError.ServerError.UnknownError(
                details = e.message ?: "알수 없는 에러"
            ))
        }
    }

    override suspend fun saveRecipe(recipeId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun unsavedRecipe(recipeId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun checkSavedRecipeIds(): RResult<List<String>, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getRecipeDetailByChefName(chefName: String): RResult<Recipe, CustomError> {
        try {
            val recipes = recipeDataSource.getSearchRecipes("")

            val result = recipes.filter { recipe -> recipe.chef == chefName }[0]

            return RResult.Success(result)
        } catch (e: Exception) {

            return RResult.Error(CustomError.ServerError.UnknownError(
                details = e.message ?: "알수 없는 에러"
            ))
        }
    }


}