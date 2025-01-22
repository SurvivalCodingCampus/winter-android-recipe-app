package com.surivalcoding.composerecipeapp.presentation.navigation

import com.surivalcoding.composerecipeapp.R

sealed class BottomNavItem(
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
) {
    data object Home : BottomNavItem(
        route = "home",
        selectedIcon = R.drawable.ic_home_focused,
        unselectedIcon = R.drawable.ic_home
    )
    data object SavedRecipes : BottomNavItem(
        route = "saved_recipes",
        selectedIcon = R.drawable.ic_bookmark_focused,
        unselectedIcon = R.drawable.ic_bookmark
    )
    data object RecipeWrite : BottomNavItem(
        route = "recipe_write",
        selectedIcon = R.drawable.ic_plus,
        unselectedIcon = R.drawable.ic_plus
    )
    data object Notification : BottomNavItem(
        route = "notification",
        selectedIcon = R.drawable.ic_notification_focused,
        unselectedIcon = R.drawable.ic_notification
    )
    data object Profile : BottomNavItem(
        route = "profile",
        selectedIcon = R.drawable.ic_profile_focused,
        unselectedIcon = R.drawable.ic_profile
    )

    companion object {
        val items = listOf(
            Home,
            SavedRecipes,
            RecipeWrite,
            Notification,
            Profile
        )
    }
}