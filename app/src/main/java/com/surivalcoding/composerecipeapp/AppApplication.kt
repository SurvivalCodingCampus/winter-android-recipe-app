package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.data_source.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl

class AppApplication: Application() {
    val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(MockRecipeDataSourceImpl())
    }
}