package com.felipegouveia.dogchallenge.ui.feature.breeds.mapper

import com.felipegouveia.dogchallenge.domain.model.Breed
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel

fun List<Breed>.toUiModel(): List<BreedUiModel> =
    map { item ->
        item.toUiModel()
    }

fun Breed.toUiModel() = BreedUiModel(name = breedName)
