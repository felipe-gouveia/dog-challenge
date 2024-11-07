package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.felipegouveia.dogchallenge.core.dispatcher.DispatcherFactory
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedsUseCase
import com.felipegouveia.dogchallenge.ui.feature.breeds.mapper.toUiModel
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
    private val listBreedsUseCase: ListBreedsUseCase,
    private val dispatcherFactory: DispatcherFactory
) : ViewModel() {

    private val _uiState = MutableStateFlow<BreedsUiState>(BreedsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        listBreeds()
    }

    fun listBreeds() {
        listBreedsUseCase()
            .map { it.toUiModel() }
            .onStart { _uiState.value = BreedsUiState.Loading }
            .onEach { _uiState.value = BreedsUiState.ShowBreeds(it) }
            .catch { _uiState.value = BreedsUiState.Error }
            .flowOn(dispatcherFactory.io())
            .launchIn(viewModelScope)
    }
}
