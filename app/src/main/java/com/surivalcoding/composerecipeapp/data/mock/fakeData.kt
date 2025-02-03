package com.surivalcoding.composerecipeapp.data.mock

import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.data.model.Ingredient
import com.surivalcoding.composerecipeapp.data.model.Recipe
import com.surivalcoding.composerecipeapp.data.model.RecipeCategory
import com.surivalcoding.composerecipeapp.data.model.SearchFilterOptions
import com.surivalcoding.composerecipeapp.data.model.TimeType
import com.surivalcoding.composerecipeapp.data.model.UserData
import com.surivalcoding.composerecipeapp.data.model.toHomeRecipe
import com.surivalcoding.composerecipeapp.data.model.toNewRecipe
import com.surivalcoding.composerecipeapp.data.model.toSavedRecipe
import com.surivalcoding.composerecipeapp.data.model.toSearchRecipe


val fakeUserData = UserData(
    bookmarkIds = setOf(
        1, 2, 3, 4, 5, 6, 7, 8, 9
    ),
    recentQuery = "",
    searchFilterOptions = SearchFilterOptions(
        time = TimeType.ALL,
        rating = 5,
        category = RecipeCategory.ALL,
    )
)
val fakeIngredients = listOf(
    Ingredient(
        500,
        "Tomatos",
        "https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__",
    )
)

val fakeImageDrawables = listOf(
    R.drawable.img_rounded_classic_greek_salad,
    R.drawable.img_rounded_crunchy_nut_coleaslaw,
    R.drawable.img_rounded_steak_with_tomato
)

val fakeAvatarImage = listOf(
    R.drawable.img_avatar_james,
    R.drawable.img_avatar_laura,
    R.drawable.img_avatar_bella,
    R.drawable.img_avatar_kyle,
)

val fakeRecipe = listOf(
    Recipe(
        id = 1,
        title = "Traditional spare ribs baked",
        cookingMinute = 20,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg",
        rating = 4.0,
        authorName = "Chef John",
        ingredients = listOf(
            Ingredient(
                3,
                "Pork",
                "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg"
            ),
            Ingredient(
                9,
                "Onion",
                "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
            ),
            Ingredient(
                8,
                "Pepper",
                "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
            ),
            Ingredient(
                1,
                "Tomato",
                "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example1"
    ),
    Recipe(
        id = 2,
        title = "Spice roasted chicken with flavored rice",
        cookingMinute = 20,
        postTime = "2025-01-22",
        category = RecipeCategory.ASIAN,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg",
        rating = 4.0,
        authorName = "Mark Kelvin",
        ingredients = listOf(
            Ingredient(
                6,
                "Chicken",
                "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
            ),
            Ingredient(
                4,
                "Rice",
                "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
            ),
            Ingredient(
                8,
                "Pepper",
                "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
            ),
            Ingredient(
                3,
                "Pork",
                "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example2"
    ),
    Recipe(
        id = 3,
        title = "Spicy fried rice mix chicken bali",
        cookingMinute = 20,
        postTime = "2025-01-22",
        category = RecipeCategory.CHINESE,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg",
        rating = 4.0,
        authorName = "Spicy Nelly",
        ingredients = listOf(
            Ingredient(
                6,
                "Chicken",
                "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
            ),
            Ingredient(
                4,
                "Rice",
                "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
            ),
            Ingredient(
                1,
                "Tomato",
                "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example3"
    ),
    Recipe(
        id = 4,
        title = "Ttekbokki",
        cookingMinute = 30,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
        rating = 5.0,
        authorName = "Kim Dahee",
        ingredients = listOf(),
        videoLink = "https://www.youtube.com/watch?v=example4"
    ),
    Recipe(
        id = 5,
        title = "Grilled salmon with avocado salsa",
        cookingMinute = 25,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2020/01/02/01/43/avocado-4734786_1280.jpg",
        rating = 4.5,
        authorName = "Alice Johnson",
        ingredients = listOf(
            Ingredient(
                5,
                "Avocado",
                "https://cdn.pixabay.com/photo/2020/01/02/01/43/avocado-4734786_1280.jpg"
            ),
            Ingredient(
                8,
                "Pepper",
                "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example5"
    ),
    Recipe(
        id = 6,
        title = "Beef Wellington",
        cookingMinute = 45,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/10/22/10/11/beef-wellington-4568239_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
        rating = 5.0,
        authorName = "Gordon Ramsay",
        ingredients = listOf(
            Ingredient(
                2,
                "Beef",
                "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png"
            ),
            Ingredient(
                9,
                "Onion",
                "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example6"
    ),
    Recipe(
        id = 7,
        title = "Classic Margherita Pizza",
        cookingMinute = 15,
        postTime = "2025-01-22",
        category = RecipeCategory.ITALIAN,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg",
        rating = 4.3,
        authorName = "Mario Batali",
        ingredients = listOf(
            Ingredient(
                1,
                "Tomato",
                "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example7"
    ),
    Recipe(
        id = 8,
        title = "Sushi Platter",
        cookingMinute = 60,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
        rating = 4.8,
        authorName = "Jiro Ono",
        ingredients = listOf(
            Ingredient(
                6,
                "Chicken",
                "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
            ),
            Ingredient(
                4,
                "Rice",
                "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example8"
    ),
    Recipe(
        id = 9,
        title = "French Onion Soup",
        cookingMinute = 40,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg",
        rating = 4.6,
        authorName = "Julia Child",
        ingredients = listOf(
            Ingredient(
                9,
                "Onion",
                "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example9"
    ),
    Recipe(
        id = 10,
        title = "Chocolate Lava Cake",
        cookingMinute = 30,
        postTime = "2025-01-22",
        category = RecipeCategory.LUNCH,
        thumbnailUrl = "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
        foodIconUrl = "https://cdn.pixabay.com/photo/2014/11/28/19/10/lump-sugar-549096_1280.jpg",
        rating = 4.9,
        authorName = "Paul Hollywood",
        ingredients = listOf(
            Ingredient(
                7,
                "Sugar",
                "https://cdn.pixabay.com/photo/2014/11/28/19/10/lump-sugar-549096_1280.jpg"
            )
        ),
        videoLink = "https://www.youtube.com/watch?v=example10"
    )
)

val fakeHomeRecipes = fakeRecipe.map { it.toHomeRecipe() }
val fakeSavedRecipe = fakeRecipe.map { it.toSavedRecipe() }
val fakeNewRecipes = fakeRecipe.map { it.toNewRecipe() }
val fakeSearchRecipe = fakeRecipe.map { it.toSearchRecipe() }
