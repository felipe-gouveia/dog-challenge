package com.felipegouveia.dogchallenge.ui.feature.breedimages.mapper

import com.felipegouveia.dogchallenge.domain.model.BreedImage
import com.felipegouveia.dogchallenge.ui.feature.breedimages.model.BreedImagesUiModel

fun List<BreedImage>.toUiModel(breedName: String) =
    BreedImagesUiModel(
        breedName = breedName,
        images = map { it.image }
    )
