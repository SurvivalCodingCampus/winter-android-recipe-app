package org.example.day19.repository

import com.surivalcoding.composerecipeapp.data.model.Recipe
import org.example.day19.model.RecipeDetail

interface RecipeRepository {
    /**
     * 필터가 적용된 레시피 검색 결과를 반환한다.
     * @param keyword : 검색할 키워드
     * @param timeTaken : 걸리는 시간 (ex. 10분 미만)
     * @param rate : 평점 (평점이 rate 이상인 것)
     * @param categories : 필터 카테고리
     * @return List<com.surivalcoding.composerecipeapp.data.model.Recipe> : 필터링 된 레시피 결과 값
     */
    suspend fun searchRecipes(keyword: String, timeTaken: Int? = null, rate: Int? = null, categories: List<String>): List<Recipe>

    /**
     * 레시피의 상세 내용을 조회한다.
     * @param recipeId : 조회된 레시피의 ID
     * @return RecipeDetail
     */
    suspend fun getRecipeDetail(recipeId: String): RecipeDetail

    /**
     * 레시피를 저장되어 있지 않다면 저장하고, 저장되어 있다면 저장 취소 한다.
     * @param recipeId : 저장할 레시피 id
     * @param isUserSaved : 현재 저장 상태. true면 저장됨, false면 저장 안 됨
     * @return Boolean : 성공여부. 성공은 true, 실패는 false를 반환
     */
    suspend fun saveRecipe(recipeId: String, isUserSaved: Boolean): Boolean

    /**
     * 저장된 레시피 정보들을 가져온다.
     * @return List<com.surivalcoding.composerecipeapp.data.model.Recipe> : 저장 된 레시피 정보를 반환
     */
    suspend fun getSavedRecipes(): List<Recipe>

    /**
     * 레시피의 별점을 매긴다.
     * @param userId : 로그인 된 유저
     * @param recipeId : 별점 매길 레시피 id
     * @param rating : 별점 레벨
     * @param isUserRated : true면 patch로 처리하고 false면 create 처리
     */
    suspend fun rateRecipe(userId: String, recipeId: String, rating: Int, isUserRated: Boolean)


}