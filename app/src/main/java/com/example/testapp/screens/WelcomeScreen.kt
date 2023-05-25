package com.example.testapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.screens.components.CustomButton
import com.example.testapp.screens.components.CustomImage
import com.example.testapp.screens.components.Header
import com.example.testapp.screens.navigation.Screen

@Composable
fun WelcomeScreen(navigate: (String) -> Unit) {
    Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.secondaryContainer) {
        Column {
            CustomImage(image = painterResource(id = R.drawable.meme1))
            Spacer(modifier = Modifier.size(30.dp))
            Header(text = stringResource(id = R.string.welcome_screen_header_text))
            Spacer(modifier = Modifier.weight(1f))
            CustomButton(
                title = stringResource(id = R.string.welcome_screen_start_button_title),
                onClick = { navigate(Screen.Main.route.name) }
            )
        }
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(navigate = {})
}