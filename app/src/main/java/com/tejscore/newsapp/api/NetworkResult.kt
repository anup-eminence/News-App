package com.tejscore.newsapp.api

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T?) : NetworkResult<T>(data)
    class Error<T>(message: String?, data: T?) : NetworkResult<T>(data, message)
    class Loading<T>(message: String?) : NetworkResult<T>(message = message)
}

enum class Response {
    SUCCESS,
    ERROR,
    LOADING
}
