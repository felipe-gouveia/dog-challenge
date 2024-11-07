package com.felipegouveia.dogchallenge.ui.state

sealed class UiState<out T> {
    data object Loading: UiState<Nothing>()
    data class Success<T>(val content: T) : UiState<T>()
    data object Error : UiState<Nothing>()
}