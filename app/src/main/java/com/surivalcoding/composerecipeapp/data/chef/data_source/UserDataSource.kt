package com.surivalcoding.composerecipeapp.data.chef.data_source

import com.surivalcoding.composerecipeapp.data.chef.User

interface UserDataSource {
    suspend fun registerUser(user: User)
    suspend fun loginByEmail(email: String, password: String): User
    suspend fun getProfiles(): List<User>
}