package com.surivalcoding.composerecipeapp.presentation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.presentation.page.home.HomeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.main.NotificationScreen
import com.surivalcoding.composerecipeapp.presentation.page.profile.ProfileScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.recipe_detail.RecipeDetailScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeScreenRoot
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun MainScreenNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = MainRoute.Home.screenRoute) {
        composable(MainRoute.Home.screenRoute) {
            HomeScreenRoot(
                onSearchRecipeClick = {
                    navController.navigate(MainRoute.Search.screenRoute) {

                        popUpTo(MainRoute.Home.screenRoute) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(MainRoute.BookMark.screenRoute) {
            SavedRecipeScreenRoot()
        }

        composable(MainRoute.Notification.screenRoute) {
            NotificationScreen()
        }

        composable(MainRoute.Profile.screenRoute) {
            ProfileScreenRoot()
        }

        // 검색 화면
        composable(MainRoute.Search.screenRoute) {
            SearchRecipeScreenRoot(onSearchRecipeClick = { recipe ->
                val jsonRecipe = Uri.encode(Json.encodeToString(recipe))
                navController.navigate("${MainRoute.SearchDetail.screenRoute}/$jsonRecipe") {
                    popUpTo(MainRoute.Search.screenRoute) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            })
        }

        // 상세 화면
        composable(
            route = "${MainRoute.SearchDetail.screenRoute}/{recipeDetail}",
            arguments = listOf(navArgument("recipeDetail") { type = NavType.StringType })
        ) { backStackEntry ->
            val jsonRecipe = backStackEntry.arguments?.getString("recipeDetail")
            val recipe = jsonRecipe?.let { Json.decodeFromString<Recipe>(it) }

            recipe?.let {
                RecipeDetailScreenRoot()
            }
        }
    }
}