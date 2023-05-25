package com.example.testapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.R
import com.example.testapp.networking.NetworkResult
import com.example.testapp.screens.components.CustomButton
import com.example.testapp.screens.components.FactContent
import com.example.testapp.viewModels.JokeViewModel

@Composable
fun JokeScreen(
    viewModel: JokeViewModel
) {
    val joke by viewModel.jokeResult.observeAsState(initial = NetworkResult.Loading())
    Column {
        FactContent(
            image = painterResource(id = R.drawable.dog),
            text = stringResource(id = R.string.joke_screen_header_text),
            fontSize = 18.sp
        )
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = joke.data?.setup ?: "", fontSize = 20.sp)
            Text(text = joke.data?.punchline ?: "", fontSize = 20.sp)
            CustomButton(
                title = stringResource(id = R.string.refresh_button_title), 
                onClick = { viewModel.refreshButtonTapped() }
            )
        }
    }
}