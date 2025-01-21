package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.mock.savedRecipeMockEngine
import com.surivalcoding.composerecipeapp.util.createJsonHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class RecipeRepositoryImplTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: RecipeRepositoryImpl
    private lateinit var httpClient: HttpClient

    @OptIn(ExperimentalSerializationApi::class)
    @Before
    fun setUp() {
        createJsonHttpClient()
        httpClient = HttpClient(savedRecipeMockEngine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    allowTrailingComma = true
                })
            }
        }

        subject = RecipeRepositoryImpl(
            RecipeDataSourceImpl(
                httpClient,
            )
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getSavedRecipes() = testScope.runTest {
        val recipeIds = listOf(1, 2, 3)

        val savedRecipes = subject.getSavedRecipes(recipeIds).first()

        println()
        assertEquals(10, savedRecipes.size)
        assertEquals("Traditional spare ribs baked", savedRecipes[0].title)
        assertEquals("Spice roasted chicken with flavored rice", savedRecipes[1].title)
        assertEquals("Spicy fried rice mix chicken bali", savedRecipes[2].title)
    }
}