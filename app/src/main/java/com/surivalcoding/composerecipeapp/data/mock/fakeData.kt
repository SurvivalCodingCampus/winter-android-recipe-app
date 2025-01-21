package com.surivalcoding.composerecipeapp.data.mock

import com.surivalcoding.composerecipeapp.data.model.Ingredient
import com.surivalcoding.composerecipeapp.data.model.SavedRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe


val fakeIngredients = listOf(
    Ingredient(
        "https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__",
        "Tomatos", 500
    )
)

val fakeSavedRecipe = listOf(
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
        cookingMinute = 20,
        title = "Traditional spare ribs baked",
        authorName = "Chef John",
        rating = 4.0,
        isBookmarked = true
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
        cookingMinute = 20,
        title = "Spice roasted chicken with flavored rice",
        authorName = "Mark Kelvin",
        rating = 4.0,
        isBookmarked = false
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
        cookingMinute = 20,
        title = "Spicy fried rice mix chicken bali",
        authorName = "Spicy Nelly",
        rating = 4.0,
        isBookmarked = true
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
        cookingMinute = 30,
        title = "Ttekbokki",
        authorName = "Kim Dahee",
        rating = 5.0,
        isBookmarked = false
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
        cookingMinute = 25,
        title = "Grilled salmon with avocado salsa",
        authorName = "Alice Johnson",
        rating = 4.5,
        isBookmarked = true
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
        cookingMinute = 45,
        title = "Beef Wellington",
        authorName = "Gordon Ramsay",
        rating = 5.0,
        isBookmarked = false
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
        cookingMinute = 15,
        title = "Classic Margherita Pizza",
        authorName = "Mario Batali",
        rating = 4.3,
        isBookmarked = true
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
        cookingMinute = 60,
        title = "Sushi Platter",
        authorName = "Jiro Ono",
        rating = 4.8,
        isBookmarked = true
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
        cookingMinute = 40,
        title = "French Onion Soup",
        authorName = "Julia Child",
        rating = 4.6,
        isBookmarked = false
    ),
    SavedRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
        cookingMinute = 30,
        title = "Chocolate Lava Cake",
        authorName = "Paul Hollywood",
        rating = 4.9,
        isBookmarked = true
    )
)

val fakeSearchRecipe = listOf(
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
        title = "Traditional spare ribs baked",
        rating = 4.0,
        authorName = "Chef John"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
        title = "Spice roasted chicken with flavored rice",
        rating = 4.0,
        authorName = "Mark Kelvin"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
        title = "Spicy fried rice mix chicken bali",
        rating = 4.0,
        authorName = "Spicy Nelly"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
        title = "Ttekbokki",
        rating = 5.0,
        authorName = "Kim Dahee"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
        title = "Grilled salmon with avocado salsa",
        rating = 4.5,
        authorName = "Alice Johnson"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
        title = "Beef Wellington",
        rating = 5.0,
        authorName = "Gordon Ramsay"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
        title = "Classic Margherita Pizza",
        rating = 4.3,
        authorName = "Mario Batali"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
        title = "Sushi Platter",
        rating = 4.8,
        authorName = "Jiro Ono"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
        title = "French Onion Soup",
        rating = 4.6,
        authorName = "Julia Child"
    ),
    SearchRecipe(
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
        title = "Chocolate Lava Cake",
        rating = 4.9,
        authorName = "Paul Hollywood"
    )
)


val testIds = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)