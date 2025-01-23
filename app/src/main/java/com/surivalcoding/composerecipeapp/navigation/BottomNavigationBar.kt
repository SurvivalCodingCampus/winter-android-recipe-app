package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.surivalcoding.composerecipeapp.ui.AppColors




@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentRoute: String?,
    items: List<MainRoute>,
    navController: NavHostController
) {

    BottomNavigation(
        backgroundColor = AppColors.white,
        contentColor = AppColors.white
    ) {


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