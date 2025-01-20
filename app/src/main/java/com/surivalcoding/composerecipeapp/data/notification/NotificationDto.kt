package com.surivalcoding.composerecipeapp.data.notification

import NotificationModel
import NotificationType

data class NotificationDto(
    val id: String = "",
    val type: String = "",
    val message: String = "",
    val isRead: Boolean = false,
    val createdAt: Long = 0,
    val receivedAt: Long? = null
) {
    fun toModel() = NotificationModel(
        id = id,
        type = NotificationType.valueOf(type),
        message = message,
        isRead = isRead,
        createdAt = createdAt,
        receivedAt = receivedAt
    )
}