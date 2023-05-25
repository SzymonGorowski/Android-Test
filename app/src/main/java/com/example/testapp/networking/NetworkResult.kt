package com.example.testapp.networking

sealed class NetworkResult<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(value: T): NetworkResult<T>(value)
    class Error<T>(error: Throwable?, value: T? = null): NetworkResult<T>(value, error)
    class Loading<T>: NetworkResult<T>()
}