package com.surivalcoding.composerecipeapp.util

sealed class ResponseResult<out T> {
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Failure(val error: Throwable) : ResponseResult<Nothing>()
}

// 공통되는 error catching
suspend fun <T> safeCall(call: suspend () -> T): ResponseResult<T> {
    return runCatching {
        call()
    }.fold(  // 성공인경우 T에 대한 Success, 실패인경우 Failure에 error 담음
        onSuccess = { ResponseResult.Success(it) },
        onFailure = {
            ResponseResult.Failure(it)
        }
    )
}