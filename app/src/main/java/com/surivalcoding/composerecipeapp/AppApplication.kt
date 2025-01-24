package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.data_source.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.MockUserDataSource
import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.use_case.GetSavedRecipesUseCase

class AppApplication: Application() {
    val getSavedRecipesUseCase: GetSavedRecipesUseCase by lazy {
        GetSavedRecipesUseCase(
            recipeRepository = RecipeRepositoryImpl(MockRecipeDataSourceImpl()),
            bookmarkRepository = BookmarkRepositoryImpl(MockUserDataSource())
        )
    }

//    val recipeRepository: RecipeRepository by lazy {
//        RecipeRepositoryImpl(MockRecipeDataSourceImpl())
//    }
}