package com.surivalcoding.composerecipeapp.data.recipe.notification

import NotificationModel
import com.surivalcoding.composerecipeapp.util.CustomError
import com.surivalcoding.composerecipeapp.util.RResult

interface NotificationRepository {
    suspend fun getNotifications(): RResult<List<NotificationModel>, CustomError>
}