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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.felipegouveia.dogchallenge.R
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel
import com.felipegouveia.dogchallenge.ui.feature.breeds.state.BreedsViewState
import com.felipegouveia.dogchallenge.ui.navigation.Screens
import com.felipegouveia.dogchallenge.ui.navigation.navigateToBreedImages
import com.felipegouveia.dogchallenge.ui.theme.Small

@Composable
fun BreedsView(viewModel: BreedsViewModel = hiltViewModel(), navController: NavHostController) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    BreedsViewState(
        uiState = uiState,
        retryAction = viewModel::listBreeds,
        onBreedClick = navController::navigateToBreedImages
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedsListView(breedsUiModel: List<BreedUiModel>, onClick: (BreedUiModel) -> Unit) {
    TopAppBar(title = { Text(stringResource(R.string.app_name)) })
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

fun NavGraphBuilder.breedsViewDestination(navController: NavHostController) {
    composable(route = Screens.BREEDS.path) {
        BreedsView(navController = navController)
    }
}
