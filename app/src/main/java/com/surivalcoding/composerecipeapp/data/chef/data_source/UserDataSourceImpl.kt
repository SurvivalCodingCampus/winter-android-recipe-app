package com.surivalcoding.composerecipeapp.data.chef.data_source

import ApiClient
import com.surivalcoding.composerecipeapp.data.chef.User
import com.surivalcoding.composerecipeapp.data.chef.UserResponseDto
import com.surivalcoding.composerecipeapp.data.chef.toModel
import format
import io.ktor.client.HttpClient

class UserDataSourceImpl(
    private val httpClient: HttpClient = ApiClient().create()
) : UserDataSource {
    override suspend fun registerUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun loginByEmail(email: String, password: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun getProfiles(): List<User> {
//        val response = httpClient.get("http://192.168.1.55:3000")
//
//        when (response.status) {
//            HttpStatusCode.OK -> {
//                val result = format.decodeFromString<List<UserModel>>(response.bodyAsText())
//                return result
//            }
//
//            HttpStatusCode.BadGateway -> {
//                throw Exception("bad gateway")
//            }
//
//            HttpStatusCode.BadRequest -> {
//                throw Exception("bad request")
//            }
//
//            else -> {
//                println("error")
//                throw Exception("error")
//            }
//        }

        val chefData = """
          { "profiles": [ { "id": 1, "name": "Chef John", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Lagos, Nigeria" }, { "id": 2, "name": "Mark Kelvin", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Abuja, Nigeria" }, { "id": 3, "name": "Spicy Nelly", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Ibadan, Nigeria" }, { "id": 4, "name": "Kim Dahee", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Seoul, South Korea" }, { "id": 5, "name": "Alice Johnson", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "New York, USA" }, { "id": 6, "name": "Gordon Ramsay", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "London, UK" }, { "id": 7, "name": "Mario Batali", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Rome, Italy" }, { "id": 8, "name": "Jiro Ono", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Tokyo, Japan" }, { "id": 9, "name": "Julia Child", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "Paris, France" }, { "id": 10, "name": "Paul Hollywood", "image": "https://cdn.pixabay.com/photo/2022/10/19/01/02/woman-7531315_1280.png", "address": "London, UK" } ] }""".trimIndent()


        val result = format.decodeFromString<UserResponseDto>(chefData)

        return result.profiles.map { user -> user.toModel() }
    }

}