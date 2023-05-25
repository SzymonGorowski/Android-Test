package com.example.testapp.networking

import com.example.testapp.networking.models.CatFact
import com.example.testapp.networking.models.Joke
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getCatFact(@Url url: String): Response<CatFact>

    @GET
    suspend fun getJoke(@Url url: String): Response<Joke>
}