package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.felipegouveia.dogchallenge.ui.common.ErrorView
import com.felipegouveia.dogchallenge.ui.common.LoadingView
import com.felipegouveia.dogchallenge.ui.state.UiState

@Preview
@Composable
fun BreedsView(viewModel: BreedsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState(initial = UiState.Loading)

    Column {
        AnimatedVisibility(
            visible = uiState is UiState.Loading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LoadingView()
        }

        AnimatedVisibility(visible = uiState is UiState.Error, enter = fadeIn(), exit = fadeOut()) {
            ErrorView { viewModel.listBreeds() }
        }
    }
}