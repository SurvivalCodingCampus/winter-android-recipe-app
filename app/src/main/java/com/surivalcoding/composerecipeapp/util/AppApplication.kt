package com.surivalcoding.composerecipeapp.util

import android.app.Application
import com.surivalcoding.composerecipeapp.data.datasource.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl

class AppApplication : Application() {

    // 사용할 때 의존성 주입
    private val recipeDataSource by lazy { MockRecipeDataSourceImpl() }
    val recipeRepository by lazy { RecipeRepositoryImpl(recipeDataSource) }

}