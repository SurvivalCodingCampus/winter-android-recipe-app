package com.surivalcoding.composerecipeapp.data.repository

import ReviewModel
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

// ReviewRepository.kt
interface ReviewRepository {
    suspend fun getReviews(recipeId: String): RResult<List<ReviewModel>, CustomError>
    suspend fun createReview(recipeId: String, review: ReviewModel): RResult<Unit, CustomError>
    suspend fun putReview(reviewId: String, review: ReviewModel): RResult<Unit, CustomError>
    suspend fun deleteReview(reviewId: String): RResult<Unit, CustomError>
    suspend fun getReviewsByRecipeId(recipeId: String): RResult<List<ReviewModel>, CustomError>
}