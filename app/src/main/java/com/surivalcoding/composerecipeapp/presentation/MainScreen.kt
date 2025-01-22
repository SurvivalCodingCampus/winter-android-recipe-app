package com.surivalcoding.composerecipeapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = {},
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = {},
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = {},
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                    selected = false,
                    onClick = {},
                )
            }
        },
        content = {innerPadding ->
            Column(
                modifier.padding(innerPadding),
                verticalArrangement = TODO(),
                horizontalAlignment = TODO(),
                content = TODO()
            )
        }
    )

}