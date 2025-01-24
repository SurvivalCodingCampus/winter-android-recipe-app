package com.surivalcoding.composerecipeapp.presentation.sign_up

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SignUpState(
    val recipes: List<Recipe> = emptyList(),
    val query: String = "",
    val isSearching: Boolean = false,
    val searchScreenText: String = "Recent Search",
    val searchResultCount: Int = 0,
    val isLoading: Boolean = false,
)