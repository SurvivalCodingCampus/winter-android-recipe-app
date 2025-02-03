package com.surivalcoding.composerecipeapp.di

import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.SavedRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.SearchPreferencesRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import com.surivalcoding.composerecipeapp.domain.repository.SearchPreferencesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBookMarkRepository(
        bookmarkRepositoryImpl: BookmarkRepositoryImpl
    ): BookmarkRepository

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository

    @Binds
    @Singleton
    abstract fun bindSavedRecipeRepository(
        savedRecipeRepositoryImpl: SavedRecipeRepositoryImpl
    ): SavedRecipeRepository

    @Binds
    @Singleton
    abstract fun bindSearchPreferencesRepository(
        searchPreferencesRepositoryImpl: SearchPreferencesRepositoryImpl
    ): SearchPreferencesRepository
}