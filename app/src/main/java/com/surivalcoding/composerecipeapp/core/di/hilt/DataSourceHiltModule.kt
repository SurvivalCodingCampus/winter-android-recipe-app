package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.data.data_source.MockUserDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.UserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceHiltModule {

    @Singleton
    @Binds
    abstract fun provideUserDataSource(
        userDataSourceImpl: MockUserDataSourceImpl,
    ): UserDataSource

}