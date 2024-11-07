package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipegouveia.dogchallenge.core.DispatcherFactory
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedsUseCase
import com.felipegouveia.dogchallenge.ui.feature.breeds.mapper.toUiModel
import com.felipegouveia.dogchallenge.ui.state.ShowBreeds
import com.felipegouveia.dogchallenge.ui.state.UiState
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
class BreedsViewModel @Inject constructor(
    private val breedsUseCase: ListBreedsUseCase,
    private val dispatcherFactory: DispatcherFactory
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        listBreeds()
    }

    fun listBreeds() {
        breedsUseCase()
            .map { it.toUiModel() }
            .onStart { _uiState.value = UiState.Loading }
            .onEach { _uiState.value = ShowBreeds(it) }
            .catch { _uiState.value = UiState.Error }
            .flowOn(dispatcherFactory.io())
            .launchIn(viewModelScope)
    }
}