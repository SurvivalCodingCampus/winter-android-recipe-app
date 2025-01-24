package com.surivalcoding.composerecipeapp.data.di

import com.surivalcoding.composerecipeapp.data.datasource.PreferenceDataSource
import com.surivalcoding.composerecipeapp.data.mock.fakeUserData
import javax.inject.Inject

class FakePreferenceDataSource2 @Inject constructor() : PreferenceDataSource {
    override val userData = fakeUserData
}