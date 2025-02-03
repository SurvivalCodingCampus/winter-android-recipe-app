package com.surivalcoding.composerecipeapp.presentation.navigation

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.navigation.NavType
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf


/*
* 바텀네비게이션바 용 라우트
* */
@Serializable
sealed class MainRoute(
    val id: Int, @DrawableRes val icon: Int, val screenRoute: String
) {
    @Serializable
    data object Home : MainRoute(1, R.drawable.home_2, HOME)

    @Serializable
    data object BookMark : MainRoute(2, R.drawable.inactive, BOOKMARK)

    @Serializable
    data object Notification : MainRoute(3, R.drawable.notification_bing, NOTIFICATION)

    @Serializable
    data object Profile : MainRoute(4, R.drawable.profile, PROFILE)

    @Serializable
    data object Search : MainRoute(5, R.drawable.ic_launcher_foreground, SEARCH)

    @Serializable
    data object SearchDetail : MainRoute(6, R.drawable.ic_launcher_foreground, SEARCH_DETAIL)

    companion object {
        const val HOME = "HOME"
        const val BOOKMARK = "BOOKMARK"
        const val NOTIFICATION = "NOTIFICATION"
        const val PROFILE = "PROFILE"
        const val SEARCH = "SEARCH"
        const val SEARCH_DETAIL = "SEARCH_DETAIL"
    }
}


//// RecipeList 형식을 넘기기 위해서 데이터를 직렬화하여 Json 문자열로 bundle에 저장
//// 저장된 문자열을 다시 역직렬화를 통해 data class로 변환하여 return 하는 함수
//// 커스텀 객체에 리스트 형태로 포함되어 있을 경우 Array 타입으로 변환해주는 추가 작업이 필요함
//val RecipeType = object : NavType<Recipe>(isNullableAllowed = false) {
//    override fun get(bundle: Bundle, key: String): Recipe? {
//        return bundle.getString(key)?.let { Json.decodeFromString(it) }
//    }
//
//    override fun parseValue(value: String): Recipe {
//        return Json.decodeFromString(value)
//    }
//
//    override fun put(bundle: Bundle, key: String, value: Recipe) {
//        bundle.putString(key, Json.encodeToString(Recipe.serializer(), value))
//    }
//
//    override fun serializeAsValue(value: Recipe): String {
//        return Json.encodeToString(Recipe.serializer(), value)
//    }
//}