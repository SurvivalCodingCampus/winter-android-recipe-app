


interface ReviewDataSource {
    suspend fun getReviews(recipeId: String): List<ReviewModel>
    suspend fun createReview(recipeId: String, review: ReviewModel)
}
