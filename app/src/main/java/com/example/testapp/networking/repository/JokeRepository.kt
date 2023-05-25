package com.example.testapp.networking.repository

import com.example.testapp.networking.ApiService
import com.example.testapp.networking.NetworkError
import com.example.testapp.networking.NetworkResult
import com.example.testapp.networking.ResponseValidator
import com.example.testapp.networking.models.Joke
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface JokeRepository {
    fun getJoke(): Flow<NetworkResult<Joke?>>
}

class JokeRepositoryDefault @Inject constructor(
    private val apiService: ApiService
): JokeRepository {
    override fun getJoke(): Flow<NetworkResult<Joke?>> = flow {
        emit(NetworkResult.Loading())
        runCatching {
            apiService.getJoke(url = "https://official-joke-api.appspot.com/random_joke")
        }.onSuccess { response ->
            emit(ResponseValidator.validateResponse(response))
        }.onFailure {
            emit(NetworkResult.Error(NetworkError.UnknownError))
        }
    }
}