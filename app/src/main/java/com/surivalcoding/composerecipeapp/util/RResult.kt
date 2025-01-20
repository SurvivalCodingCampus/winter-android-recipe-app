package com.surivalcoding.composerecipeapp.util

sealed class RResult<out D, out E> {
    data class Success<out D>(val data: D) : RResult<D, Nothing>()
    data class Error<out E>(val error: E) : RResult<Nothing, E>()
}


sealed class CustomError {
    object NetworkError : CustomError()
    object EmptyQuery : CustomError()

    sealed class ServerError : CustomError() {
        data class BadRequest(val details: String) : ServerError()
        data class InternalServerError(val details: String) : ServerError()
        data class UnknownError(val details: String) : ServerError()
        data class ApiKeyError(val details: String) : ServerError()
        data class IOException(val details: String) : ServerError()
    }

    // 공통 메시지 메서드
    fun toMessage(): String {
        return when (this) {
            is NetworkError -> "네트워크 오류가 발생했습니다."
            is EmptyQuery -> "쿼리가 비어 있습니다."
            is ServerError.BadRequest -> "잘못된 요청: $details"
            is ServerError.InternalServerError -> "서버 내부 오류: $details"
            is ServerError.UnknownError -> "알 수 없는 오류: $details"
            is ServerError.ApiKeyError -> "API 키 오류: $details"
            is ServerError.IOException -> "IOException 오류: $details"
            else -> {
                "알수없는 오류"
            }

        }
    }
}
