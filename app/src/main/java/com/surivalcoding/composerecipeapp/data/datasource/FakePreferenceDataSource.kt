package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.UserData
import javax.inject.Inject

class FakePreferenceDataSource @Inject constructor() : PreferenceDataSource {
    override val userData = UserData(
        bookmarkIds = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    )
}