package com.surivalcoding.composerecipeapp
import android.app.Application
import com.surivalcoding.composerecipeapp.data.chef.UserRepositoryImpl
import com.surivalcoding.composerecipeapp.data.chef.data_source.UserDataSourceImpl
import com.surivalcoding.composerecipeapp.data.recipe.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.recipe.data_source.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.recipe.data_source.RecipeDataSourceImpl


class AppApplication: Application(){
    private val mockRecipeDataSource by lazy { MockRecipeDataSourceImpl() }
//    private val recipeDataSource by lazy { RecipeDataSourceImpl() }
    private val userDataSource by lazy {UserDataSourceImpl()}
    val recipeRepository by lazy { RecipeRepositoryImpl(mockRecipeDataSource) }
    val userRepository by lazy { UserRepositoryImpl(userDataSource) }
}