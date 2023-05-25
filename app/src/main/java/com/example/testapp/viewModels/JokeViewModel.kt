package com.example.testapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.networking.NetworkResult
import com.example.testapp.networking.models.Joke
import com.example.testapp.networking.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokeViewModel @Inject constructor(
    private val jokeRepository: JokeRepository
): ViewModel() {
    private val _jokeResult = MutableLiveData<NetworkResult<Joke?>>()
    val jokeResult: LiveData<NetworkResult<Joke?>> get() = _jokeResult

    init {
        getJoke()
    }

    fun refreshButtonTapped() {
        getJoke()
    }

    private fun getJoke() = viewModelScope.launch {
        jokeRepository.getJoke().collect() {
            _jokeResult.value = it
        }
    }
}