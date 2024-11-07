package com.felipegouveia.dogchallenge.data.mapper

import com.felipegouveia.dogchallenge.data.model.BreedImagesResponse
import com.felipegouveia.dogchallenge.data.model.BreedResponse
import com.felipegouveia.dogchallenge.domain.model.Breed
import com.felipegouveia.dogchallenge.domain.model.BreedFamily
import com.felipegouveia.dogchallenge.domain.model.BreedImage

/**
 * These mappers are responsible for bridging the data layer to the domain layer
 * while keeping them completely decoupled
 */
fun BreedImagesResponse.toDomain(): List<BreedImage> = message.map {
    BreedImage(image = it)
}

fun BreedResponse.toDomain(): List<Breed> = message.entries.map {
    Breed(
        breedName = it.key,
        family = it.value.map { family ->
            BreedFamily(familyName = "${it.key}-$family")
        }
    )
}
