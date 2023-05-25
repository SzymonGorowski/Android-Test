package com.example.testapp.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.testapp.screens.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    screen: Screen,
    navController: NavHostController,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(screen.titleID)) },
        navigationIcon = { NavigationIcon(screen = screen, navController = navController) },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Green)
    )
}

@Composable
fun NavigationIcon(screen: Screen, navController: NavHostController) {
    when (screen) {
        Screen.DogFact, Screen.CatFact, Screen.Main -> {
            TopAppBarIcon(Icons.Default.ArrowBack) {
                navController.popBackStack()
            }
        }

        else -> {}
    }
}

@Composable
fun TopAppBarIcon(icon: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null)
    }
}