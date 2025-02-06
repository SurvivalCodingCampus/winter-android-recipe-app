package com.surivalcoding.composerecipeapp.di

import com.surivalcoding.composerecipeapp.BuildConfig
import com.surivalcoding.composerecipeapp.config.AppConfig
import com.surivalcoding.composerecipeapp.config.DevAppConfig
import com.surivalcoding.composerecipeapp.config.ProdAppConfig
import com.surivalcoding.composerecipeapp.data.data_source.BookmarkDatasource
import com.surivalcoding.composerecipeapp.data.data_source.RecipeDatasource
import com.surivalcoding.composerecipeapp.data.data_source.local.MockBookmarkDatasource
import com.surivalcoding.composerecipeapp.data.data_source.local.MockRecipeDatasource
import com.surivalcoding.composerecipeapp.data.repository.impl.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.repository.impl.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.recipe.RemoveFromSavedRecipesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppBindModule {
    @Binds
    abstract fun bindRecipeRepository(
        recipeRepositoryImpl: RecipeRepositoryImpl
    ): RecipeRepository

    @Binds
    abstract fun bindBookmarkRepository(
        bookmarkRepositoryImpl: BookmarkRepositoryImpl
    ): BookmarkRepository
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("appFlavor")
    fun provideAppFlavor(): String {
        return BuildConfig.FLAVOR
    }

    @Provides
    @Singleton
    fun provideAppConfig(
        @Named("appFlavor") flavor: String
    ): AppConfig {
        return when (flavor) {
            "dev" -> DevAppConfig() // dev 환경에 맞는 AppConfig 제공
            "prod" -> ProdAppConfig() // prod 환경에 맞는 AppConfig 제공
            else -> ProdAppConfig() // 기본값 설정
        }
    }

    @Provides
    @Singleton
    fun provideRecipeDatasource(): RecipeDatasource {
        return MockRecipeDatasource()
    }

    @Provides
    @Singleton
    fun provideBookmarkDatasource(): BookmarkDatasource {
        return MockBookmarkDatasource()
    }

    @Provides
    @Singleton
    fun provideGetSavedRecipesUseCase(
        bookmarkRepository: BookmarkRepository,
        recipeRepository: RecipeRepository
    ): GetSavedRecipesUseCase {
        return GetSavedRecipesUseCase(bookmarkRepository, recipeRepository)
    }

    @Provides
    @Singleton
    fun provideRemoveFromSavedRecipesUseCase(
        bookmarkRepository: BookmarkRepository
    ): RemoveFromSavedRecipesUseCase {
        return RemoveFromSavedRecipesUseCase(bookmarkRepository)
    }
}