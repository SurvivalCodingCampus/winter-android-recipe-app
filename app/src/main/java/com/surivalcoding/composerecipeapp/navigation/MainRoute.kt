package com.surivalcoding.composerecipeapp.navigation

import com.surivalcoding.composerecipeapp.R


/*
* 바텀네비게이션바 용 라우트
* */
sealed class MainRoute(
    val id: Int, val icon: Int, val screenRoute: String
) {
    data object Home : MainRoute(1, R.drawable.home_2, HOME)

    data object BookMark : MainRoute(2, R.drawable.inactive, BOOKMARK)

    data object Notification : MainRoute(3, R.drawable.notification_bing, NOTIFICATION)

    data object Profile : MainRoute(4, R.drawable.profile, PROFILE)

    data object Search : MainRoute(5, R.drawable.ic_launcher_foreground, SEARCH)

    companion object {
        const val HOME = "HOME"
        const val BOOKMARK = "BOOKMARK"
        const val NOTIFICATION = "NOTIFICATION"
        const val PROFILE = "PROFILE"
        const val SEARCH = "SEARCH"
    }
}