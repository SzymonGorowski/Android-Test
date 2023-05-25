package com.example.testapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.networking.NetworkResult
import com.example.testapp.networking.models.CatFact
import com.example.testapp.networking.models.Joke
import com.example.testapp.networking.repository.CatFactRepository
import com.example.testapp.networking.repository.JokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatFactViewModel @Inject constructor(
    private val catFactRepository: CatFactRepository
    ): ViewModel() {
    private val _catFactResult = MutableLiveData<NetworkResult<CatFact?>>()
    val catFactResult: LiveData<NetworkResult<CatFact?>> get() = _catFactResult

    init {
        getCatFact()
    }

    fun refreshButtonTapped() {
        getCatFact()
    }

    private fun getCatFact() = viewModelScope.launch {
        catFactRepository.getCatFact().collect() {
            _catFactResult.value = it
        }
    }
}