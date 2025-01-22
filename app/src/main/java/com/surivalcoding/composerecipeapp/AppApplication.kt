package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.data_source.local.MockRecipeDatasource
import com.surivalcoding.composerecipeapp.data.repository.impl.MockRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class AppApplication : Application() {
    // RecipeDatasource 싱글턴 추가
    private val recipeDatasource by lazy {
        MockRecipeDatasource()
    }

    // RecipeRepository 싱글턴 생성 시 datasource 주입
    val recipeRepository: RecipeRepository by lazy {
        MockRecipeRepositoryImpl(recipeDatasource)
    }
}