package com.surivalcoding.composerecipeapp.data.local.mock

import com.surivalcoding.composerecipeapp.domain.model.RecipeItem

object MockRecipeData {
    val mockRecipes = listOf(
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
            cookingMinute = 20,
            title = "Traditional spare ribs baked",
            chefName = "Chef John",
            rating = 4.0,
            isBookmarked = true
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
            cookingMinute = 20,
            title = "Spice roasted chicken with flavored rice",
            chefName = "Mark Kelvin",
            rating = 4.0,
            isBookmarked = false
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
            cookingMinute = 20,
            title = "Spicy fried rice mix chicken bali",
            chefName = "Spicy Nelly",
            rating = 4.0,
            isBookmarked = true
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
            cookingMinute = 30,
            title = "Ttekbokki",
            chefName = "Kim Dahee",
            rating = 5.0,
            isBookmarked = false
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
            cookingMinute = 25,
            title = "Grilled salmon with avocado salsa",
            chefName = "Alice Johnson",
            rating = 4.5,
            isBookmarked = true
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
            cookingMinute = 45,
            title = "Beef Wellington",
            chefName = "Gordon Ramsay",
            rating = 5.0,
            isBookmarked = false
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
            cookingMinute = 15,
            title = "Classic Margherita Pizza",
            chefName = "Mario Batali",
            rating = 4.3,
            isBookmarked = true
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
            cookingMinute = 60,
            title = "Sushi Platter",
            chefName = "Jiro Ono",
            rating = 4.8,
            isBookmarked = true
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
            cookingMinute = 40,
            title = "French Onion Soup",
            chefName = "Julia Child",
            rating = 4.6,
            isBookmarked = false
        ),
        RecipeItem(
            thumbnailUrl = "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
            cookingMinute = 30,
            title = "Chocolate Lava Cake",
            chefName = "Paul Hollywood",
            rating = 4.9,
            isBookmarked = true
        )
    )
}