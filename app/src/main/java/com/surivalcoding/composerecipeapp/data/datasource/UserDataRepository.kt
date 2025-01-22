package com.surivalcoding.composerecipeapp.data.datasource

import com.surivalcoding.composerecipeapp.data.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    val userData: Flow<UserData>
    fun setRecipeBookmarked(id: Int, bookmarked: Boolean)
}