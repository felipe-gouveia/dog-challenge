package com.felipegouveia.dogchallenge.ui.feature.breedimages.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.felipegouveia.dogchallenge.ui.feature.breedimages.model.BreedImagesUiModel
import com.felipegouveia.dogchallenge.ui.navigation.Screens
import com.felipegouveia.dogchallenge.ui.theme.Small

const val BREED_NAME_NAV_ARG = "breedName"
val BREED_IMAGES_ROUTE = "${Screens.BREED_IMAGES.path}/{$BREED_NAME_NAV_ARG}"

@Composable
fun BreedImagesView(viewModel: BreedImagesViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        when(val immutable = uiState) {
            BreedImagesUiState.Error -> ErrorView { viewModel.listBreedImages() }
            BreedImagesUiState.Loading -> LoadingView()
            is BreedImagesUiState.ShowBreedImages -> BreedImagesListView(immutable.content)
        }
    }
}

@Composable
fun BreedImagesListView(uiModel: BreedImagesUiModel) {
    LazyVerticalGrid(columns = GridCells.Adaptive(168.dp)) {
        items(uiModel.images) { imageUrl ->
            BreedImageItem(imageUrl = imageUrl)
        }
    }
}

@Composable
private fun BreedImageItem(imageUrl: String) {
    Text(
        modifier = Modifier.padding(all = Small),
        text = imageUrl
    )
}

fun NavGraphBuilder.breedImagesViewDestination() {
    composable(route = BREED_IMAGES_ROUTE) {
        BreedImagesView()
    }
}