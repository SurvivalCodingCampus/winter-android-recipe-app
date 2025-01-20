package org.example.day19.repository

import org.example.day19.model.LikeStatus
import org.example.day19.model.Review

interface ReviewRepository {
    /**
     * 리뷰 목록을 가져온다.
     * @return List<Review>
     */
    suspend fun getReviews(): List<Review>

    /**
     * 리뷰를 등록한다
     * @param content : 입력할 리뷰 내용
     * @param userId : 현재 로그인 된 유저 id
     * @param recipeId : 리뷰 할 레시피 id
     * @return Review : 작성한 리뷰를 반환한다.
     */
    suspend fun registReview(content: String, userId: String, recipeId: String): Review

    /**
     * 리뷰에 대한 좋아요 / 싫어요 상태 반영한다.
     * @param likeStatus : 현재 like상태 (LIKE = 종아요 누른상태, HATE = 싫어요 누른 상태, NONE = 아무것도 누르지 않은 상태)
     * @param userId : 현재 로그인 된 유저 id
     * @param reviewId : 상태를 업데이트 할 리뷰 id
     * @return LikeStatus : 처리 결과
     */
    suspend fun likeReview(likeStatus: LikeStatus, userId: String, reviewId: String): LikeStatus
}