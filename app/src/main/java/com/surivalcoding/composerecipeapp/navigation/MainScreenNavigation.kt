package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.page.main.HomeScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.NotificationScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.ProfileScreen
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchRecipeScreen


@Composable
fun MainScreenNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = MainRoute.Home.screenRoute) {
        composable(MainRoute.Home.screenRoute) {
            HomeScreen {
                navController.navigate(MainRoute.Search.screenRoute) {
                    popUpTo(MainRoute.Home.screenRoute) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }
        }

        composable(MainRoute.BookMark.screenRoute) {
            SavedRecipeScreen()
        }

        composable(MainRoute.Notification.screenRoute) {
            NotificationScreen()
        }

        composable(MainRoute.Profile.screenRoute) {
            ProfileScreen()
        }

        composable(MainRoute.Search.screenRoute) {
            SearchRecipeScreen()
        }
    }
}