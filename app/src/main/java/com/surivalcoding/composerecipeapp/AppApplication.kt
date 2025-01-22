package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.datasource.MockRecipeDatasourceImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.repository.MockRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository

class AppApplication : Application() {
    // RecipeDatasource 싱글턴 추가
    private val recipeDatasource by lazy {
        MockRecipeDatasourceImpl()
    }

    // RecipeRepository 싱글턴 생성 시 datasource 주입
    val recipeRepository: RecipeRepository by lazy {
        MockRecipeRepositoryImpl(recipeDatasource)
    }
}