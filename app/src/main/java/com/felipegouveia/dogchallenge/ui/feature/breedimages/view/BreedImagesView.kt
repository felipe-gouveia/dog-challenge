package com.felipegouveia.dogchallenge.ui.feature.breedimages.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil3.compose.AsyncImage
import com.felipegouveia.dogchallenge.ui.feature.breedimages.model.BreedImagesUiModel
import com.felipegouveia.dogchallenge.ui.feature.breedimages.state.BreedImagesViewState
import com.felipegouveia.dogchallenge.ui.navigation.Screens
import com.felipegouveia.dogchallenge.ui.theme.Medium
import com.felipegouveia.dogchallenge.ui.theme.Small

const val BREED_NAME_NAV_ARG = "breedName"
val BREED_IMAGES_ROUTE = "${Screens.BREED_IMAGES.path}/{$BREED_NAME_NAV_ARG}"

@Composable
fun BreedImagesView(viewModel: BreedImagesViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    BreedImagesViewState(
        uiState = uiState,
        retryAction = viewModel::listBreedImages
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BreedImagesListView(uiModel: BreedImagesUiModel) {
    TopAppBar(title = { Text(text = uiModel.breedName) })
    Spacer(modifier = Modifier.height(Medium))
    LazyVerticalGrid(
        contentPadding = PaddingValues(Small),
        columns = GridCells.Adaptive(168.dp)) {
        items(uiModel.images) { imageUrl ->
            BreedImageItem(imageUrl = imageUrl)
        }
    }
}

@Composable
private fun BreedImageItem(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        modifier = Modifier
            .fillMaxWidth()
            .height(168.dp)
            .clip(CardDefaults.outlinedShape),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

fun NavGraphBuilder.breedImagesViewDestination() {
    composable(route = BREED_IMAGES_ROUTE) {
        BreedImagesView()
    }
}
