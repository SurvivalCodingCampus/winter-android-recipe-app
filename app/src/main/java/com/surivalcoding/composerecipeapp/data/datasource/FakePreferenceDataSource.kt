package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.mock.fakeUserData
import javax.inject.Inject

class FakePreferenceDataSource @Inject constructor() : PreferenceDataSource {
    override val userData = fakeUserData
}