package com.felipegouveia.dogchallenge.ui.feature.breeds.state

import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel

sealed class BreedsUiState {
    data class ShowBreeds(val content: List<BreedUiModel>): BreedsUiState()
    data object Loading: BreedsUiState()
    data object Error : BreedsUiState()
}
