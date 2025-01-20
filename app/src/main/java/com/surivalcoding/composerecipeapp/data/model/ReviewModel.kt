
data class ReviewModel(
    val id: String,
    val comment: String,
    val thumbsUp: Int = 0,
    val thumbsDown: Int = 0,
    val createdBy: String,  // User ID
    val createdAt: Long,
    val editedAt: Long? = null
)