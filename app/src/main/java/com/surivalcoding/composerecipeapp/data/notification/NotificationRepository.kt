package com.surivalcoding.composerecipeapp.data.notification

import NotificationModel
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

interface NotificationRepository {
    suspend fun getNotifications(): RResult<List<NotificationModel>, CustomError>
}