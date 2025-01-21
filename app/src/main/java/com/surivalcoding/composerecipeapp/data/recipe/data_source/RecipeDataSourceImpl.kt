package com.surivalcoding.composerecipeapp.data.recipe.data_source

import ApiClient
import Recipe
import RecipeDataSource
import RecipeResponseDto
import format
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import toModel

class RecipeDataSourceImpl(
    private val httpClient: HttpClient = ApiClient().create()
) : RecipeDataSource {
    override suspend fun getSearchRecipes(keyword: String): List<Recipe> {
        val response = httpClient.get("http://192.168.1.55:3000")
        println("${response.status} status ")

        when (response.status) {
            HttpStatusCode.OK -> {
                val result = format.decodeFromString<RecipeResponseDto>(response.bodyAsText())
                return result.recipes.map { recipe -> recipe.toModel() }
            }
            HttpStatusCode.BadGateway -> {
                throw Exception("bad gateway")
            }
            HttpStatusCode.BadRequest -> {
                throw Exception("bad request")
            }

            else -> {
                println("error")
                throw Exception("error")
            }
        }
    }


        override suspend fun createRecipe(recipe: Recipe) {
            TODO("Not yet implemented")
        }

    }