package com.surivalcoding.composerecipeapp.navigation

import androidx.annotation.DrawableRes
import com.surivalcoding.composerecipeapp.presentation.home.navigation.HomeBaseRoute
import com.surivalcoding.composerecipeapp.presentation.home.navigation.HomeRoute
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.navigation.SavedRecipeRoute
import com.surivalcoding.composerecipeapp.ui.AppIcons
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @DrawableRes
    val icon: Int,
    val route: KClass<*>,
    val baseRoute: KClass<*> = route,
) {
    HOME(
        icon = AppIcons.outlinedHome,
        route = HomeRoute::class,
        baseRoute = HomeBaseRoute::class
    ),
    BOOKMARKS(
        icon = AppIcons.outlinedBookMark,
        route = SavedRecipeRoute::class,
    )
}