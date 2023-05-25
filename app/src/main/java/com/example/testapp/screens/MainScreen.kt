package com.example.testapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.testapp.R
import com.example.testapp.screens.components.CustomImage
import com.example.testapp.screens.components.CustomTextButton
import com.example.testapp.screens.components.Header
import com.example.testapp.screens.navigation.Screen

@Composable
fun MainScreen(
    navigateToCatFact: (String) -> Unit,
    navigateToDogFact: (String) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column {
            CustomImage(image = painterResource(id = R.drawable.meme2))
            Header(text = stringResource(id = R.string.main_screen_header_text))
            Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
                CustomTextButton(
                    title = stringResource(id = R.string.main_screen_cat_fact_button_title),
                    onClick = { navigateToCatFact(Screen.CatFact.route.name) }
                )
                CustomTextButton(
                    title = stringResource(id = R.string.main_screen_dog_fact_button_title),
                    onClick = { navigateToDogFact(Screen.DogFact.route.name)}
                )
            }
        }
    }
}