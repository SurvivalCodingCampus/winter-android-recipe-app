package com.surivalcoding.composerecipeapp.presentation.component

import android.app.Application
import com.surivalcoding.composerecipeapp.presentation.component.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.presentation.component.repository.RecipeRepositoryImpl

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }

    val recipeDataSource by lazy { RecipeDataSourceImpl() }
    val recipeRepository by lazy {
        RecipeRepositoryImpl(recipeDataSource)
    }
}