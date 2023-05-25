package com.example.testapp.networking

import retrofit2.Response

object ResponseValidator {
    fun <T> validateResponse(response: Response<T>): NetworkResult<T?> {
        return when (response.code()) {
            200 -> NetworkResult.Success(response.body())
            in 300..399 -> NetworkResult.Error(NetworkError.RedirectionError)
            in 400..499 -> NetworkResult.Error(NetworkError.ClientError)
            in 500..599 -> NetworkResult.Error(NetworkError.ServerError)
            else -> NetworkResult.Error(NetworkError.UnknownError)
        }
    }
}