package com.felipegouveia.dogchallenge.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.felipegouveia.dogchallenge.ui.feature.breeds.view.breedsViewDestination
import com.felipegouveia.dogchallenge.ui.navigation.Screens

@Composable
fun MainView() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.BREEDS.name) {
        breedsViewDestination()
    }
}
