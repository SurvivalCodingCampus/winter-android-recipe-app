package com.surivalcoding.composerecipeapp.data.model

enum class TimeType(
    val label: String
) {
    ALL("All"),
    NEWEST("Newest"),
    OLDEST("Oldest"),
    POPULARITY("Popularity")
}