package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.lifecycle.ViewModel
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedsUseCase
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel
import com.felipegouveia.dogchallenge.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BreedsViewModel @Inject constructor(
    private val breedsUseCase: ListBreedsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<BreedUiModel>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun listBreeds() {
        // TODO: add fetch of data and populate uiState
    }
}