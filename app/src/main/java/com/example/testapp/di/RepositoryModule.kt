package com.example.testapp.di

import com.example.testapp.networking.repository.CatFactRepository
import com.example.testapp.networking.repository.CatFactRepositoryDefault
import com.example.testapp.networking.repository.JokeRepository
import com.example.testapp.networking.repository.JokeRepositoryDefault
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCatFactRepository(repository: CatFactRepositoryDefault): CatFactRepository
    @Binds
    abstract fun bindJokeRepository(repository: JokeRepositoryDefault): JokeRepository
}