package com.surivalcoding.composerecipeapp.data.chef

import com.surivalcoding.composerecipeapp.data.chef.data_source.UserDataSource
import com.surivalcoding.composerecipeapp.data.chef.data_source.UserDataSourceImpl
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

class UserRepositoryImpl(
    private val userDataSource: UserDataSource = UserDataSourceImpl()
) : UserRepository {
    override suspend fun registerUser(user: User): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun loginByEmail(
        email: String,
        password: String
    ): RResult<User, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun forgetPassword(email: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun loginByProvider(providerType: String): RResult<User, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun followUser(userId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun unFollowUser(userId: String): RResult<Unit, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(userId: Int): RResult<User, CustomError> {
        try {
            val userProfile = userDataSource.getProfiles()

            val filteredResult = userProfile.filter { user -> user.id == userId }[0]

            return RResult.Success(filteredResult)
        } catch (e: Exception) {
            return RResult.Error(CustomError.ServerError.UnknownError(
                details = e.message ?: "알수 없는 에러"
            ))
        }

    }

    override suspend fun getUserByChefName(chefName: String): RResult<User, CustomError> {
        try {
            val userProfile = userDataSource.getProfiles()

            val filteredResult = userProfile.filter { user -> user.name == chefName}[0]

            return RResult.Success(filteredResult)
        } catch (e: Exception) {

            return RResult.Error(CustomError.ServerError.UnknownError(
                details = e.message ?: "알수 없는 에러"
            ))
        }
    }

    override suspend fun getFollowerUserList(userId: String): RResult<List<User>, CustomError> {
        TODO("Not yet implemented")
    }

    override suspend fun getFollowingUserList(userId: String): RResult<List<User>, CustomError> {
        TODO("Not yet implemented")
    }
}