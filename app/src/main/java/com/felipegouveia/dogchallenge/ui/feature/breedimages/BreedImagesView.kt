package com.felipegouveia.dogchallenge.ui.feature.breedimages

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.felipegouveia.dogchallenge.ui.navigation.Screens

private const val NAME_NAV_ARG = "breedName"
val BREED_IMAGES_ROUTE = "${Screens.BREED_IMAGES.path}/{$NAME_NAV_ARG}"

@Composable
fun BreedImagesView() {
}

fun NavGraphBuilder.breedImagesViewDestination() {
    composable(route = BREED_IMAGES_ROUTE) {
        BreedImagesView()
    }
}