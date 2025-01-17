package com.surivalcoding.composerecipeapp.example.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = mutableIntStateOf(0)
    val count: State<Int> = _count

    fun increase() {
        _count.intValue++
    }

    fun decrease() {
        _count.intValue--
    }

    fun reset() {
        _count.intValue = 0
    }
}