package com.example.testapp.networking

import com.example.testapp.R

sealed class NetworkError(val description: String) : Throwable() {
    object RedirectionError: NetworkError(R.string.network_error_redirection_error_message.toString())
    object ClientError: NetworkError(R.string.network_error_client_error_message.toString())
    object ServerError: NetworkError(R.string.network_error_server_error_message.toString())
    object UnknownError: NetworkError(R.string.network_error_unknown_error_message.toString())
}
