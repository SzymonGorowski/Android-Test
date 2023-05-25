package com.example.testapp.screens.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testapp.viewModels.CatFactViewModel
import com.example.testapp.screens.CatFactScreen
import com.example.testapp.screens.JokeScreen
import com.example.testapp.screens.MainScreen
import com.example.testapp.screens.WelcomeScreen
import com.example.testapp.viewModels.JokeViewModel

@Composable
fun NavigationController(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val catFactViewModel: CatFactViewModel = hiltViewModel()
    val jokeViewModel: JokeViewModel = hiltViewModel()
    Surface(modifier = modifier) {
        NavHost(
            navController = navController,
            startDestination = Screen.Welcome.route.name
        ) {
            composable(Screen.Welcome.route.name) {
                WelcomeScreen(navigate = { navController.navigate(it) })
            }
            composable(Screen.Main.route.name) {
                MainScreen(
                    navigateToCatFact = { navController.navigate(it) },
                    navigateToDogFact = { navController.navigate(it) }
                )
            }
            composable(Screen.CatFact.route.name) {
                CatFactScreen(viewModel = catFactViewModel)
            }
            composable(Screen.DogFact.route.name) {
                JokeScreen(viewModel = jokeViewModel)
            }
        }
    }
}