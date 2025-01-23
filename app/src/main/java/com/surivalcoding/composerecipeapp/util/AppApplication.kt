package com.surivalcoding.composerecipeapp.util

import android.app.Application
import com.surivalcoding.composerecipeapp.data.datasource.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookMarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetBookMarkListUseCase

class AppApplication : Application() {

    // 사용할 때 의존성 주입
    private val recipeDataSource by lazy { MockRecipeDataSourceImpl() }
    val recipeRepository by lazy { RecipeRepositoryImpl(recipeDataSource) }


    // 북마크
    private val bookMarkRepository by lazy { BookmarkRepositoryImpl(recipeDataSource) }
    val deleteBookMarkUseCase by lazy { DeleteBookMarkUseCase(bookmarkRepository = bookMarkRepository) }
    val getBookMarkListUseCase by lazy { GetBookMarkListUseCase(bookmarkRepository = bookMarkRepository) }
}



