package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.mock.fakeRecipe
import com.surivalcoding.composerecipeapp.data.mock.fakeSavedRecipe
import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipeDataSourceImpl @Inject constructor(
    private val httpClient: HttpClient,
) : RecipeDataSource {
    override fun getSearchRecipes(query: String): Flow<List<SearchRecipe>> = flow {
        val normalizedQuery = query.trim().lowercase().replace("\\s+".toRegex(), "")
        emit(fakeSearchRecipe.filter {
            val normalizedTitle = it.title.trim().lowercase().replace("\\s+".toRegex(), "")
            val normalizedAuthorName =
                it.authorName.trim().lowercase().replace("\\s+".toRegex(), "")
            normalizedQuery in normalizedTitle || normalizedQuery in normalizedAuthorName
        })
    }

    override fun getSavedRecipe(ids: List<Int>): Flow<List<SavedRecipe>> = flow {
        emit(fakeSavedRecipe)
    }

    override fun getRecipes(): Flow<List<Recipe>> = flow {
        emit(fakeRecipe)
    }
}