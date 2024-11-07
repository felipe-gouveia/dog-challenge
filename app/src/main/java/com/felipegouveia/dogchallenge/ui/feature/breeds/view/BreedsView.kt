package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.felipegouveia.dogchallenge.ui.common.ErrorView
import com.felipegouveia.dogchallenge.ui.common.LoadingView
import com.felipegouveia.dogchallenge.ui.navigation.Screens
import com.felipegouveia.dogchallenge.ui.state.UiState

@Composable
fun BreedsView(viewModel: BreedsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        AnimatedVisibility(visible = uiState is UiState.Loading) {
            LoadingView()
        }

        AnimatedVisibility(visible = uiState is UiState.Error) {
            ErrorView { viewModel.listBreeds() }
        }
    }
}

fun NavGraphBuilder.breedsViewDestination() {
    composable(route = Screens.BREEDS.name) {
        BreedsView()
    }
}