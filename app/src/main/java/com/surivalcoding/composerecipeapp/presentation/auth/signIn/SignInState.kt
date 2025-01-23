package com.surivalcoding.composerecipeapp.presentation.auth.signIn

data class SignInState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)