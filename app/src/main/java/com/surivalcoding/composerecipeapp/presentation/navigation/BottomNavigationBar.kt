package com.surivalcoding.composerecipeapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
        modifier = Modifier
            .height(80.dp),
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