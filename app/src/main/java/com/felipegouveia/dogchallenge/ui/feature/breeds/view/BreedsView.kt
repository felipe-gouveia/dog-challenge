package com.felipegouveia.dogchallenge.ui.feature.breeds.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.felipegouveia.dogchallenge.ui.common.ErrorView
import com.felipegouveia.dogchallenge.ui.common.LoadingView
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel
import com.felipegouveia.dogchallenge.ui.navigation.Screens
import com.felipegouveia.dogchallenge.ui.state.ShowBreeds
import com.felipegouveia.dogchallenge.ui.state.UiState
import com.felipegouveia.dogchallenge.ui.theme.Small

@Composable
fun BreedsView(viewModel: BreedsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        when(uiState) {
            UiState.Error -> ErrorView { viewModel.listBreeds() }
            UiState.Loading -> LoadingView()
            is ShowBreeds -> BreedsListView((uiState as ShowBreeds).content) {}
        }
    }
}

@Composable
fun BreedsListView(breedsUiModel: List<BreedUiModel>, onClick: (BreedUiModel) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = Small)) {
        LazyVerticalGrid(columns = GridCells.Adaptive(168.dp)) {
            items(breedsUiModel) { breed ->
                Spacer(modifier = Modifier.height(Small))
                BreedItem(uiModel = breed, onClick = { onClick(breed) })
            }
        }
    }
}

@Composable
private fun BreedItem(uiModel: BreedUiModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(all = Small)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column {
            Text(
                modifier = Modifier.padding(all = Small),
                text = uiModel.name
            )
        }
    }
}

fun NavGraphBuilder.breedsViewDestination() {
    composable(route = Screens.BREEDS.value) {
        BreedsView()
    }
}
