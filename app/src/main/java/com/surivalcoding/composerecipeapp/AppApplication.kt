package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeRepositoryImpl

class AppApplication : Application() {
    val recipeRepository by lazy {
        RecipeRepositoryImpl(
            RecipeDataSourceImpl()
        )
    }
}