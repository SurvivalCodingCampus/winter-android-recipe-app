package com.surivalcoding.composerecipeapp.example.numbercorrect

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random


// 상태 변수가 3개
class NumberGuessViewModel : ViewModel() {
//    private var _numberText = MutableStateFlow("")
//    val numberText = _numberText.asStateFlow()
//
//
//    private var _guessText = MutableStateFlow<String?>(null)
//    var guessText = _guessText.asStateFlow()
//
//    private var _isCorrect = MutableStateFlow(false)
//    val isCorrect = _isCorrect.asStateFlow()


    private var _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    private val number = Random.nextInt(10)

    /*
    * update
    * Thread - safe
    * 동시성 문제 방지
    * 특히 코루틴이나 다중 스레드 환경에서 중요
    * */
    fun onNumberTextChange(newText: String) {
        _state.update {
            it.copy(
                numberText = newText
            )
        }
    }

    fun onGuessClick() {
        val guess = _state.value.numberText.toIntOrNull()

        _state.update {
            it.copy(
                guessText = when {
                    guess == null -> "숫자를 입력해주세요"
                    guess < number -> "Up"
                    guess > number -> "Down"
                    else -> "정답"
                },
                isCorrect = guess == number,
                numberText = "",
            )
        }

    }


}