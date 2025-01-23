package com.surivalcoding.composerecipeapp.data.di

import com.surivalcoding.composerecipeapp.data.datasource.PreferenceDataSource
import com.surivalcoding.composerecipeapp.data.model.UserData
import javax.inject.Inject

class FakePreferenceDataSource2 @Inject constructor() : PreferenceDataSource {
    override val userData = UserData(
        bookmarkIds = listOf(6, 7, 8, 9)
    )
}