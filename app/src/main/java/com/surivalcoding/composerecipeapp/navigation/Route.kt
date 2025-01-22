package com.surivalcoding.composerecipeapp.navigation

import kotlinx.serialization.Serializable


// 각 이동 라우트 지정
sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SignUp : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data object Main : Route
}