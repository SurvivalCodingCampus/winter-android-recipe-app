package org.example.day19.repository

import org.example.day19.data_source.NotificationDataSource
import org.example.day19.model.Notification

interface NotificationRepository {

    /**
     * 모든 알림을 가져온다.
     * isRead가 null이면 모든 알림을 가져오고, true이면 읽은 알림만 가져오고, false이면 안 읽은 알림만 가져온다.
     * @param isRead 읽음 여부
     * @return 알림 리스트
     */
    suspend fun getNotifications(isRead: Boolean? = null): List<Notification>

    /**
     * 알림을 읽음 처리한다.
     * @param id 알림 ID
     * @return 성공 여부
     */
    suspend fun readNotification(id: Int): Boolean

    /**
     * 알림을 삭제한다.
     * @param id 알림 ID
     * @return 성공 여부
     */
    suspend fun deleteNotification(id: Int): Boolean
}