package org.example.day19.repository

import org.example.day19.model.Recipe
import org.example.day19.model.User

/**
 * userDataSource 와 recipeDataSource 를 사용하여
 * 프로필 관련 데이터를 가져오는 repository
 */
interface ProfileRepository {

    /**
     * 유저 정보를 가져온다.
     * data source 에서 유저 프로필 정보를 가져온다.
     * @param userId 유저 아이디
     * @return User
     */
    suspend fun getUser(userId: String): User

    /**
     * 유저의 레시피 리스트를 가져온다.
     * data source 에서 유저의 레시피 리스트를 가져온다.
     * @param userId 유저 아이디
     * @return List<com.surivalcoding.composerecipeapp.data.model.Recipe>
     */
    suspend fun getUserRecipes(userId: String): List<Recipe>
}