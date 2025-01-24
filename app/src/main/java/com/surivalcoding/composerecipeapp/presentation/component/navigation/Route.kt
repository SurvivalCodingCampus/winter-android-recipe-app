package com.surivalcoding.composerecipeapp.presentation.component.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    object SplashScreen: Route

    @Serializable
    object SignInScreen: Route

    @Serializable
    object SignUpScreen: Route

    @Serializable
    object HomeScreen: Route

    @Serializable
    object SearchScreen: Route
}