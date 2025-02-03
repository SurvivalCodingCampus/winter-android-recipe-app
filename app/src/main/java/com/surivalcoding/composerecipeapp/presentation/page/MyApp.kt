package com.surivalcoding.composerecipeapp.presentation.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.presentation.navigation.Route
import com.surivalcoding.composerecipeapp.presentation.page.main.MainScreen
import com.surivalcoding.composerecipeapp.presentation.page.signin.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.page.signup.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.page.splash.SplashScreen

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->

        // 첫 시작 Splash 부터
        NavHost(
            navController = navController,
            startDestination = Route.Splash
        ) {
            composable<Route.Splash> {
                SplashScreen {
                    navController.navigate(Route.SignIn) {
                        popUpTo(Route.Splash) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }

            }

            composable<Route.SignIn> {
                SignInScreen(
                    forgotPassWord = {},
                    signIn = {
                        // MainScreen 이동 처리 필요
                        navController.navigate(Route.Main) {
                            popUpTo(Route.SignIn) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    },
                    googleSignIn = {},
                    facebookSignIn = {},
                    signUp = {
                        navController.navigate(Route.SignUp) {
                            popUpTo(Route.SignIn) {
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable<Route.SignUp> {
                SignUpScreen(
                    signUp = {
                        // SignIn 화면으로
                    },
                    googleSignIn = {},
                    facebookSignIn = {},
                    signIn = {
                        navController.navigate(Route.SignIn) {
                            popUpTo(Route.SignUp) {
                                inclusive = true
                            }
                        }

                    }
                )
            }

            composable<Route.Main> {
                MainScreen()
            }
        }
    }
}