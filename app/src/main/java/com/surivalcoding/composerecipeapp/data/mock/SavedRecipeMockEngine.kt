package com.surivalcoding.composerecipeapp.data.mock

import com.surivalcoding.composerecipeapp.util.BASE_URL
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf

val savedRecipeMockEngine = MockEngine{ request ->
    when(request.url.toString()){
        BASE_URL -> {
            respond(
                content = fakeSavedRecipes,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        else -> {
            respondError(HttpStatusCode.NotFound)
        }
    }
}

private const val fakeSavedRecipes = """[
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
        "cookingMinute": 20,
        "title": "Traditional spare ribs baked",
        "authorName": "Chef John",
        "rating": 4.0,
        "isBookmarked": true
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
        "cookingMinute": 20,
        "title": "Spice roasted chicken with flavored rice",
        "authorName": "Mark Kelvin",
        "rating": 4.0,
        "isBookmarked": false
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
        "cookingMinute": 20,
        "title": "Spicy fried rice mix chicken bali",
        "authorName": "Spicy Nelly",
        "rating": 4.0,
        "isBookmarked": true
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
        "cookingMinute": 30,
        "title": "Ttekbokki",
        "authorName": "Kim Dahee",
        "rating": 5.0,
        "isBookmarked": false
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
        "cookingMinute": 25,
        "title": "Grilled salmon with avocado salsa",
        "authorName": "Alice Johnson",
        "rating": 4.5,
        "isBookmarked": true
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
        "cookingMinute": 45,
        "title": "Beef Wellington",
        "authorName": "Gordon Ramsay",
        "rating": 5.0,
        "isBookmarked": false
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
        "cookingMinute": 15,
        "title": "Classic Margherita Pizza",
        "authorName": "Mario Batali",
        "rating": 4.3,
        "isBookmarked": true
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
        "cookingMinute": 60,
        "title": "Sushi Platter",
        "authorName": "Jiro Ono",
        "rating": 4.8,
        "isBookmarked": true
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
        "cookingMinute": 40,
        "title": "French Onion Soup",
        "authorName": "Julia Child",
        "rating": 4.6,
        "isBookmarked": false
    },
    {
        "thumbnailUrl": "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
        "cookingMinute": 30,
        "title": "Chocolate Lava Cake",
        "authorName": "Paul Hollywood",
        "rating": 4.9,
        "isBookmarked": true
    }
]
"""