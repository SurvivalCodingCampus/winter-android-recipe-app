data class NotificationModel(
    val id: String,
    val type: NotificationType,
    val message: String,
    val isRead: Boolean = false,
    val createdAt: Long,
    val receivedAt: Long? = null
)


enum class NotificationType {
    LIKE,
    COMMENT,
    FOLLOW,
    SYSTEM
}