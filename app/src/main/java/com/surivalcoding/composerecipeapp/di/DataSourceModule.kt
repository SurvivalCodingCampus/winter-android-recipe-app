package com.surivalcoding.composerecipeapp.di

import com.surivalcoding.composerecipeapp.data.datasource.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.datasource.RecipeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* abstract class와 @Binds 방식
* 인터페이스 타입과 구현체 간의 바인딩, @Binds 어노테이션으로 구체적인 구현체 주입을 할 수 있게 설정
* */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {


    // 목 데이터 주입
    @Binds
    @Singleton
    abstract fun bindRecipeDataSource(
        recipeDataSourceImpl: MockRecipeDataSourceImpl
    ): RecipeDataSource


}