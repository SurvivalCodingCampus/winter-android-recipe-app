package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class UserDataRepositoryImpl(
    private val preferenceDataSource: PreferenceDataSource
) : UserDataRepository {
    private val _userData: MutableStateFlow<UserData> =
        MutableStateFlow(preferenceDataSource.userData)

    override val userData: Flow<UserData> = _userData
    override fun setRecipeBookmarked(id: Int, bookmarked: Boolean) {
        _userData.update {
            it.copy(
                bookmarkIds = if (bookmarked) it.bookmarkIds + id else it.bookmarkIds - id
            )
        }
    }

}