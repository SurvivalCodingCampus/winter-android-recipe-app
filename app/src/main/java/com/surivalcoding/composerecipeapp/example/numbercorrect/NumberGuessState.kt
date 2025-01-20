package com.surivalcoding.composerecipeapp.example.numbercorrect

data class NumberGuessState(
    val numberText: String = "",
    val guessText: String? = null,
    val isCorrect: Boolean = false,
)
