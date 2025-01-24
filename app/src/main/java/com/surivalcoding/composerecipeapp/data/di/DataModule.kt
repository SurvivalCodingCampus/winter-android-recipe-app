package com.surivalcoding.composerecipeapp.data.di

import com.surivalcoding.composerecipeapp.data.datasource.FakePreferenceDataSource
import com.surivalcoding.composerecipeapp.data.datasource.PreferenceDataSource
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.repository.RecentSearchRecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.RecentSearchRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepository
import com.surivalcoding.composerecipeapp.data.repository.UserDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindRecipeRepository(
        recipeRepository: RecipeRepositoryImpl
    ): RecipeRepository

    @Binds
    abstract fun bindRecipeDataSource(
        recipeDataSource: RecipeDataSourceImpl
    ): RecipeDataSource

    @Singleton
    @Binds
    abstract fun bindUserDataRepository(
        userDataRepository: UserDataRepositoryImpl
    ): UserDataRepository

    @Binds
    abstract fun bindPreferenceDataSource(
        preferenceDataSource: FakePreferenceDataSource
    ): PreferenceDataSource

    @Binds
    abstract fun bindRecentSearchRecipeRepository(
        recentSearchRecipeRepository: RecentSearchRecipeRepositoryImpl
    ): RecentSearchRecipeRepository
}