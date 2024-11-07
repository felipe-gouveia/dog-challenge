package com.felipegouveia.dogchallenge.ui.navigation

import androidx.navigation.NavController
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel

/**
 * Navigation contract defined at $
 */
fun NavController.navigateToBreedImages(breed: BreedUiModel) {
    navigate("${Screens.BREED_IMAGES.path}/${breed.name}")
}