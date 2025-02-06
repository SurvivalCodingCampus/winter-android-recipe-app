package com.surivalcoding.composerecipeapp.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val hoDispatcher: HoDispatchers)

enum class HoDispatchers {
    Default,
    IO,
}