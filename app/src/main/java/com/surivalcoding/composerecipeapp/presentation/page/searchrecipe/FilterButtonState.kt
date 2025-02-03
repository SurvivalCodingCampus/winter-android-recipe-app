package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import com.surivalcoding.composerecipeapp.domain.model.Ingredient

data class FilterButtonState(
    val time: Time,
    val rate: Int,
    val category: Category
)

enum class Time(val displayName: String) {
    All("All"), NEWEST("Newest"), OLDEST("Oldest"), POPULARITY("Popularity")
}

enum class Category(val displayName: String) {
    All("All"), CEREAL("Cereal"), VEGETABLES("Vegetables"), DINNER("Dinner"),
    CHINESE("Chinese"), LOCAL_DISH("Local Dish"), FRUIT("Fruit"), BREAKFAST("BreakFast"),
    SPANISH("Spanish"), LUNCH("Lunch")
}

enum class ProfileCategory(val displayName: String) {
    RECIPE("Recipe"), VIDEOS("Videos"), TAG("Tag")
}

enum class RecipeDetailCategory(val displayName: String) {
    INGREDIENT("Ingredient"), PROCEDURE("Procedure")
}