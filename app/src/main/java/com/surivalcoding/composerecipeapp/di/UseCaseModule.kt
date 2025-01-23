package com.surivalcoding.composerecipeapp.di

import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookMarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetBookMarkListUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* object로 정의된 모듈은 구체적인 인스턴스를 생성하고 제공하는 방식
* @Provides 어노테이션을 사용하여 의존성 객체를 직접 생성하고 반환 (구체적인 객체를 반환)
* */
@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun bindDeleteBookMarkUseCase(
        bookmarkRepository: BookmarkRepository
    ): DeleteBookMarkUseCase {
        return DeleteBookMarkUseCase(bookmarkRepository)
    }


    @Provides
    @Singleton
    fun bindGetBookMarkListUseCase(
        bookmarkRepository: BookmarkRepository
    ): GetBookMarkListUseCase {
        return GetBookMarkListUseCase(bookmarkRepository)
    }
}