package com.surivalcoding.composerecipeapp.data.model

data class UserData(
    val bookmarkIds: Set<Int>,
    val recentQuery: String,
    val searchFilterOptions: SearchFilterOptions,
)