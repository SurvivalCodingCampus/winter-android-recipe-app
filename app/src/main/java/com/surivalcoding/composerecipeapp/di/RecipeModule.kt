package com.surivalcoding.composerecipeapp.di

import com.surivalcoding.composerecipeapp.data.local.mock.MockRecipeData
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Provides
    @Singleton
    fun provideMockRecipeData(): MockRecipeData {
        return MockRecipeData
    }

    @Provides
    @Singleton
    fun provideMockRecipeRepository(
        mockRecipeData: MockRecipeData
    ): RecipeRepository {
        return RecipeRepositoryImpl(mockRecipeData)
    }
}