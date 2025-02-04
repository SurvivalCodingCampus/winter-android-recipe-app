package com.surivalcoding.composerecipeapp.presentation.main.home

import androidx.lifecycle.ViewModel
import com.surivalcoding.composerecipeapp.config.AppConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appConfig: AppConfig
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onSearchClick() {
        // TODO: Implement later
    }

    init {
        _state.update {
            it.copy(greeting = appConfig.greeting)
        }
    }
}