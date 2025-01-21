package com.surivalcoding.composerecipeapp.data.notification.data_source

import NotificationModel


interface NotificationDataSource{
    suspend fun getNotifications(): List<NotificationModel>
}