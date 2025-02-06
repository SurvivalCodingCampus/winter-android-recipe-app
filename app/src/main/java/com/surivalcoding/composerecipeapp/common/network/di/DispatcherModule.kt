package com.surivalcoding.composerecipeapp.common.network.di

import com.surivalcoding.composerecipeapp.common.network.Dispatcher
import com.surivalcoding.composerecipeapp.common.network.HoDispatchers.Default
import com.surivalcoding.composerecipeapp.common.network.HoDispatchers.IO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}