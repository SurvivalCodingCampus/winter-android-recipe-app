data class ReviewDto(
    val id: String = "",
    val comment: String = "",
    val thumbsUp: Int = 0,
    val thumbsDown: Int = 0,
    val createdBy: String = "",
    val createdAt: Long = 0,
    val editedAt: Long? = null
) {
    fun toModel() = ReviewModel(
        id = id,
        comment = comment,
        thumbsUp = thumbsUp,
        thumbsDown = thumbsDown,
        createdBy = createdBy,
        createdAt = createdAt,
        editedAt = editedAt
    )
}