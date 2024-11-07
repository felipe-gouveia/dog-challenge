package com.felipegouveia.dogchallenge.ui.feature.breedimages.view

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipegouveia.dogchallenge.core.dispatcher.DispatcherFactory
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedImagesUseCase
import com.felipegouveia.dogchallenge.ui.feature.breedimages.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class BreedImagesViewModel @Inject constructor(
    private val listBreedImagesUseCase: ListBreedImagesUseCase,
    private val dispatcherFactory: DispatcherFactory,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow<BreedImagesUiState>(BreedImagesUiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val breedName by lazy { savedStateHandle.get<String>(BREED_NAME_NAV_ARG).orEmpty() }

    init {
        listBreedImages()
    }

    fun listBreedImages() {
        listBreedImagesUseCase(breedName)
            .map { it.toUiModel(breedName) }
            .onStart { _uiState.value = BreedImagesUiState.Loading }
            .catch { _uiState.value = BreedImagesUiState.Error }
            .onEach { _uiState.value = BreedImagesUiState.ShowBreedImages(content = it) }
            .flowOn(dispatcherFactory.io())
            .launchIn(viewModelScope)
    }
}
