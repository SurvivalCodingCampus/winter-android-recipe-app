package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.data_source.local.MockBookmarkDatasource
import com.surivalcoding.composerecipeapp.data.data_source.local.MockRecipeDatasource
import com.surivalcoding.composerecipeapp.data.repository.impl.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.impl.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.RemoveFromSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.SearchRecipeUseCase

class AppApplication : Application() {
    // 데이터 소스 초기화
    private val dataSources: DataSources by lazy { DataSources() }

    // 레시피 레포지토리
    val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(dataSources.recipeDatasource)
    }

    // 북마크 레포지토리
    private val bookmarkRepository: BookmarkRepository by lazy {
        BookmarkRepositoryImpl(dataSources.bookmarkDatasource)
    }

    // UseCase 추가
    val getSavedRecipesUseCase by lazy {
        GetSavedRecipesUseCase(bookmarkRepository, recipeRepository)
    }

    val removeFromSavedRecipesUseCase by lazy {
        RemoveFromSavedRecipesUseCase(bookmarkRepository)
    }

    val searchRecipeUseCase by lazy {
        SearchRecipeUseCase(recipeRepository)
    }

    // 데이터 소스를 묶은 클래스
    private class DataSources {
        val recipeDatasource by lazy { MockRecipeDatasource() }
        val bookmarkDatasource by lazy { MockBookmarkDatasource() }
    }
}