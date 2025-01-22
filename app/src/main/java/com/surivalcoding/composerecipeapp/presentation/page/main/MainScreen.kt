package com.surivalcoding.composerecipeapp.presentation.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.navigation.BottomNavigationBar
import com.surivalcoding.composerecipeapp.navigation.MainScreenNavigation
import com.surivalcoding.composerecipeapp.ui.AppColors


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        backgroundColor = AppColors.white,
        contentColor = AppColors.white,
    ) { innerPadding ->
        MainScreenNavigation(navController = navController)
    }
}