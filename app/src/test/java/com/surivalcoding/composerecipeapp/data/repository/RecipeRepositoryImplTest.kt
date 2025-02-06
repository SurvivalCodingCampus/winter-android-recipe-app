package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.mock.savedRecipeMockEngine
import com.surivalcoding.composerecipeapp.util.createJsonHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.junit.Before

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
}