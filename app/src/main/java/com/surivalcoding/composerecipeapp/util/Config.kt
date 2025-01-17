import kotlinx.serialization.json.Json


object Constants {
    const val BASE_URL: String = "https://pixabay.com/api/"
}


fun extractKey(url: String): String {
    val keyRegex = "key=([^&]+)".toRegex()
    return keyRegex.find(url)?.groupValues?.get(1) ?: ""
}

val format = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    prettyPrint = true
    isLenient = true
}

