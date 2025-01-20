

interface UserDataSource {
    suspend fun registerUser(user: UserModel)
    suspend fun loginByEmail(email: String, password: String): UserModel
}