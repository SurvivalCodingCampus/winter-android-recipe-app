package com.surivalcoding.composerecipeapp.data.repository

import UserModel
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

interface UserRepository {
    suspend fun registerUser(user: UserModel): RResult<Unit, CustomError>
    suspend fun loginByEmail(email: String, password: String): RResult<UserModel, CustomError>
    suspend fun forgetPassword(email: String): RResult<Unit, CustomError>
    suspend fun loginByProvider(providerType: String): RResult<UserModel, CustomError>
    suspend fun followUser(userId: String): RResult<Unit, CustomError>
    suspend fun unFollowUser(userId: String): RResult<Unit, CustomError>
    suspend fun getUserById(userId: String): RResult<UserModel, CustomError>
    suspend fun getFollowerUserList(userId: String): RResult<List<UserModel>, CustomError>
    suspend fun getFollowingUserList(userId: String): RResult<List<UserModel>, CustomError>
}