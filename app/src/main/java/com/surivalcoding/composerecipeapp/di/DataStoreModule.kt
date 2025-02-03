package com.surivalcoding.composerecipeapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.searchDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "search_preferences"
)


// 데이터 스토어 모듈
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {


    @Provides
    @Singleton
    fun provideSearchPreferences(
        @ApplicationContext applicationContext: Context
    ): DataStore<Preferences> {
        return applicationContext.searchDataStore
    }


}