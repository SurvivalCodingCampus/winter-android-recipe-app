package com.surivalcoding.composerecipeapp.data.chef

import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

interface UserRepository {
    suspend fun registerUser(user: User): RResult<Unit, CustomError>
    suspend fun loginByEmail(email: String, password: String): RResult<User, CustomError>
    suspend fun forgetPassword(email: String): RResult<Unit, CustomError>
    suspend fun loginByProvider(providerType: String): RResult<User, CustomError>
    suspend fun followUser(userId: String): RResult<Unit, CustomError>
    suspend fun unFollowUser(userId: String): RResult<Unit, CustomError>
    suspend fun getUserById(userId: Int): RResult<User, CustomError>
    suspend fun getUserByChefName(chefName: String): RResult<User, CustomError>
    suspend fun getFollowerUserList(userId: String): RResult<List<User>, CustomError>
    suspend fun getFollowingUserList(userId: String): RResult<List<User>, CustomError>
}