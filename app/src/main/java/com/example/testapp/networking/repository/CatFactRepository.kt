package com.example.testapp.networking.repository

import com.example.testapp.networking.ApiService
import com.example.testapp.networking.NetworkError
import com.example.testapp.networking.NetworkResult
import com.example.testapp.networking.ResponseValidator
import com.example.testapp.networking.models.CatFact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

interface CatFactRepository {
    fun getCatFact(): Flow<NetworkResult<CatFact?>>
}

class CatFactRepositoryDefault @Inject constructor(
    private val apiService: ApiService
): CatFactRepository {

    override fun getCatFact(): Flow<NetworkResult<CatFact?>> = flow {
        emit(NetworkResult.Loading())
        runCatching {
            apiService.getCatFact(url = "https://catfact.ninja/fact")
        }.onSuccess { response ->
            emit(ResponseValidator.validateResponse(response))
        }.onFailure {
            emit(NetworkResult.Error(NetworkError.UnknownError))
        }
    }
}