package com.surivalcoding.composerecipeapp.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.ui.AppColors

//@Composable
//fun BottomBarPlusFab(modifier: Modifier = Modifier) {
//
//    Scaffold(
//        bottomBar = {
//            BottomAppBar(
//                modifier = Modifier
//                    .height(65.dp)
//                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
//                backgroundColor = AppColors.white,
//                contentColor = AppColors.white,
//                cutoutShape = CircleShape,
//                elevation = 22.dp
//            ) {
//                BottomNavigationBar(navController = navController)
//            }
//        },
//        floatingActionButtonPosition = FabPosition.Center,
//        floatingActionButton = {
//            FloatingActionButton(
//                shape = CircleShape,
//                onClick = {},
//                contentColor = AppColors.white
//            ) {
//                Icon(imageVector = Icons.Filled.Call, contentDescription = "Add icon")
//            }
//        }
//    ) { innerPadding ->
//        MainScreenNavigation()
//    }
//}
