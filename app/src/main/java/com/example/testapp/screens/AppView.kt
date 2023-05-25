package com.example.testapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapp.screens.components.AppBar
import com.example.testapp.screens.navigation.NavigationController
import com.example.testapp.screens.navigation.Screen

@Composable
fun AppView() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Column {
        AppBar(
            screen = Screen.fromRoute(navBackStackEntry?.destination?.route),
            navController = navController
        )
        NavigationController(
                navController = navController,
                modifier = Modifier
        )
    }
}