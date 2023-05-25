package com.example.testapp.networking.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CatFact(
    @SerializedName("fact")
    val fact: String,
    @SerializedName("length")
    val length: Int
)