package com.surivalcoding.composerecipeapp.presentation.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object SignIn : Screen("sign_in")
    data object SignUp : Screen("sign_up")
    data object Main : Screen("main")
    data object Home : Screen("home")
    data object SearchRecipes : Screen("search_recipes")
}