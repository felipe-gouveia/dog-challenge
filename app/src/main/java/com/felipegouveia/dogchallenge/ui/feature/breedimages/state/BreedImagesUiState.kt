package com.felipegouveia.dogchallenge.ui.feature.breedimages.state

import com.felipegouveia.dogchallenge.ui.feature.breedimages.model.BreedImagesUiModel

sealed class BreedImagesUiState {
    data class ShowBreedImages(val content: BreedImagesUiModel): BreedImagesUiState()
    data object Loading: BreedImagesUiState()
    data object Error : BreedImagesUiState()
}
