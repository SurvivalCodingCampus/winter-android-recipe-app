package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.domain.CancelBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppHiltModule {

//    @Singleton
//    @Provides
//    fun provideCancelBookmarkUseCase(bookmarkRepository: BookmarkRepository): CancelBookmarkUseCase {
//        return CancelBookmarkUseCase(
//            bookmarkRepository = bookmarkRepository
//        )
//    }
//
//    @Singleton
//    @Provides
//    fun provideGetSavedRecipesUseCase(recipeRepository: RecipeRepository, bookmarkUseCase: CancelBookmarkUseCase): GetSavedRecipesUseCase {
//        return GetSavedRecipesUseCase(
//            recipeRepository =  recipeRepository,
//            bookmarkUseCase = bookmarkUseCase
//        )
//    }
}