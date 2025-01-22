package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.surivalcoding.composerecipeapp.ui.AppColors


val items = listOf(
    MainRoute.Home,
    MainRoute.BookMark,
    MainRoute.Notification,
    MainRoute.Profile
)

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    BottomNavigation(
        backgroundColor = AppColors.white,
        contentColor = AppColors.white
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        items.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.screenRoute,
                onClick = {
                    navController.navigate(navItem.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = navItem.icon),
                        contentDescription = null
                    )
                },
                label = null,
                unselectedContentColor = AppColors.gray_4,
                selectedContentColor = AppColors.primary_100
            )
        }
    }
}