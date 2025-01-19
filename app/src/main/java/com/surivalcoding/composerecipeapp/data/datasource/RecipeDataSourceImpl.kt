package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.util.BASE_URL
import com.surivalcoding.composerecipeapp.util.createJsonHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.ExperimentalSerializationApi

class RecipeDataSourceImpl @OptIn(ExperimentalSerializationApi::class) constructor(
    private val httpClient: HttpClient = createJsonHttpClient()
) : RecipeDataSource {
    override fun getSavedRecipe(id:Int): Flow<Recipe> = flow {
        httpClient.use { client ->
            emit(client.get(BASE_URL).body<Recipe>())
        }
    }
}