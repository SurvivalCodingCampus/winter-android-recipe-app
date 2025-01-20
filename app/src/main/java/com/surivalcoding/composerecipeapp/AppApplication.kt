package com.surivalcoding.composerecipeapp
import android.app.Application
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.data_source.MockRecipeDataSourceImpl


class AppApplication: Application(){
    private val mockRecipeDataSource by lazy { MockRecipeDataSourceImpl() }
    val recipeRepository by lazy { RecipeRepositoryImpl(mockRecipeDataSource) }
}