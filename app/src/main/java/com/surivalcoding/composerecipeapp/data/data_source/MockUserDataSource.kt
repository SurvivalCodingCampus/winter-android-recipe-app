package com.surivalcoding.composerecipeapp.data.data_source

import com.surivalcoding.composerecipeapp.data.dto.UserDto
import com.surivalcoding.composerecipeapp.domain.model.User
import kotlinx.serialization.json.Json

class MockUserDataSource: UserDataSource{
    private val json = """
    [
        {
          "userId": 1,
          "name": "John Doe",
          "savedRecipesId": [1,2,3,4,5,6,7,8,9,10]
        }
    ]
    """.trimIndent()

    override suspend fun getAllUsers(): List<UserDto> {
        return Json.decodeFromString<List<UserDto>>(json)
    }
}