package com.surivalcoding.composerecipeapp.config

import javax.inject.Inject

/*
환경별로 다른 설정값을 제공하기 위한 인터페이스와 구현체
*/
interface AppConfig {
    val greeting: String
}

class DevAppConfig @Inject constructor() : AppConfig {
    override val greeting: String = "Hello"
}

class ProdAppConfig @Inject constructor() : AppConfig {
    override val greeting: String = "안녕하세요"
}