package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.datasource.FakePreferenceDataSource
import com.surivalcoding.composerecipeapp.data.datasource.RecentSearchRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.datasource.UserDataRepositoryImpl
import com.surivalcoding.composerecipeapp.data.mock.savedRecipeMockEngine
import com.surivalcoding.composerecipeapp.data.usecase.GetSavedRecipesUseCase
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class AppApplication : Application() {
    @OptIn(ExperimentalSerializationApi::class)
    val recipeRepository by lazy {
        RecipeRepositoryImpl(
            RecipeDataSourceImpl(
                httpClient = HttpClient(savedRecipeMockEngine) {
                    install(ContentNegotiation) {
                        json(Json {
                            ignoreUnknownKeys = true
                            allowTrailingComma = true
                        })
                    }
                }
            )
        )
    }
    val userDataRepository by lazy {
        UserDataRepositoryImpl(
            FakePreferenceDataSource()
        )
    }
    val recentSearchRecipeRepository by lazy {
        RecentSearchRecipeRepositoryImpl()
    }

    val getSavedRecipesUseCase = GetSavedRecipesUseCase(
        userDataRepository = userDataRepository,
        recipeRepository
    )
}