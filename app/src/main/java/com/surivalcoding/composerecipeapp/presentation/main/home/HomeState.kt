package com.surivalcoding.composerecipeapp.presentation.main.home

data class HomeState(
    val greeting: String = "",
    val userName: String = "Jega",
    val isLoading: Boolean = false
)