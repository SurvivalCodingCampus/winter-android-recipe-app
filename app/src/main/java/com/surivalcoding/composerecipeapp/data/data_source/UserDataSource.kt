package com.surivalcoding.composerecipeapp.data.data_source

import com.surivalcoding.composerecipeapp.data.dto.UserDto

interface UserDataSource {
    suspend fun getAllUsers() : List<UserDto>
}