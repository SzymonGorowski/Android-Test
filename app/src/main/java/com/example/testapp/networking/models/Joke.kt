package com.example.testapp.networking.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Joke(
    @SerializedName("type")
    val type: String,
    @SerializedName("setup")
    val setup: String,
    @SerializedName("punchline")
    val punchline: String,
    @SerializedName("id")
    val id: Int
)