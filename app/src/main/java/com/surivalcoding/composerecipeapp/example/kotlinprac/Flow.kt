package com.surivalcoding.composerecipeapp.example.kotlinprac

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val character = GameCharacter("용사")
    val data = character.experienceFlow()


}

class GameCharacter(val name: String) {
    // 레벨업 이벤트를 발생시키는 flow
    fun experienceFlow() = flow {
        println("flow 시작")
        var level = 1
        while (level <= 5) {
            delay(1000L)
            emit(level++)
        }
    }
}