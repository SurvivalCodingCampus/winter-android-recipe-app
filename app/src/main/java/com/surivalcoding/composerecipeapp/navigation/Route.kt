package com.surivalcoding.composerecipeapp.navigation

import kotlinx.serialization.Serializable

@Serializable
object Main

@Serializable
object RecipeRouter

sealed interface Route {

    @Serializable
    object Splash : Route

    @Serializable
    object Home: Route


    @Serializable
    object Recipe : Route

    @Serializable
    object Notification: Route

    @Serializable
    object SignIn : Route

    @Serializable
    object SignUp : Route

    @Serializable
    object Profile: Route

    @Serializable
    data class RecipeDetail(val userId: Int, val chefName: String) : Route

    @Serializable
    data class User(val userId: Int, val chefName: String) : Route

    @Serializable
    object RecentlySearchRecipe : Route
}
