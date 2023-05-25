package com.example.testapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
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
import com.example.testapp.viewModels.CatFactViewModel

@Composable
fun CatFactScreen(
    viewModel: CatFactViewModel
) {
    val catFact by viewModel.catFactResult.observeAsState(initial = NetworkResult.Loading())
    Column {
        FactContent(
            image = painterResource(id = R.drawable.cat),
            text = catFact.data?.fact ?: "",
            headerModifier = Modifier.height(300.dp),
            fontSize = 20.sp
        )
        CustomButton(
            title = stringResource(id = R.string.refresh_button_title),
            onClick = { viewModel.refreshButtonTapped() }
        )
    }
}