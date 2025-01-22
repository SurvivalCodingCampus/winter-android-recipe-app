package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.mock.fakeSavedRecipe
import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import com.surivalcoding.composerecipeapp.util.createJsonHttpClient
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.ExperimentalSerializationApi

class RecipeDataSourceImpl @OptIn(ExperimentalSerializationApi::class) constructor(
    private val httpClient: HttpClient = createJsonHttpClient()
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
}