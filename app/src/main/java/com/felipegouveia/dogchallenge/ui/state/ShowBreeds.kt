package com.felipegouveia.dogchallenge.ui.state

import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel

data class ShowBreeds(val content: List<BreedUiModel>) : UiState()
