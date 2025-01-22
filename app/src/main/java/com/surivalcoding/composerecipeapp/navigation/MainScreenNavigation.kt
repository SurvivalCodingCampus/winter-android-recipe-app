package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.page.main.BookMarkScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.HomeScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.NotificationScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.ProfileScreen


@Composable
fun MainScreenNavigation(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = MainRoute.Home.screenRoute) {
        composable(MainRoute.Home.screenRoute) {
            HomeScreen()
        }

        composable(MainRoute.BookMark.screenRoute) {
            BookMarkScreen()
        }

        composable(MainRoute.Notification.screenRoute) {
            NotificationScreen()
        }

        composable(MainRoute.Profile.screenRoute) {
            ProfileScreen()
        }
    }
}