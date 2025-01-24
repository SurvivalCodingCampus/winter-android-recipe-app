package com.surivalcoding.composerecipeapp.presentation.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.navigation.BottomNavigationBar
import com.surivalcoding.composerecipeapp.navigation.MainRoute
import com.surivalcoding.composerecipeapp.navigation.MainScreenNavigation
import com.surivalcoding.composerecipeapp.ui.AppColors


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    // 상태로 관리해야 UI가 업데이트됨
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val items: List<MainRoute> = listOf(MainRoute.Home, MainRoute.BookMark, MainRoute.Notification, MainRoute.Profile)

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    showBottomBar = when (currentRoute) {
        MainRoute.Search.screenRoute -> false
        else -> true
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(currentRoute = currentRoute, items = items, navController = navController)
            }

        },
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = { },
//                modifier = Modifier.offset(y = ())
//            ) { }
//        },
        backgroundColor = AppColors.white,
        contentColor = AppColors.white,
    ) { innerPadding ->
        MainScreenNavigation(navController = navController)
    }
}