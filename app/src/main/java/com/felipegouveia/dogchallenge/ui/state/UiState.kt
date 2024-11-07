package com.felipegouveia.dogchallenge.ui.state

sealed class UiState {
    data object Loading: UiState()
    data object Error : UiState()
}
