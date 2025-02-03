package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

sealed interface UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent
}