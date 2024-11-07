package com.felipegouveia.dogchallenge.domain.model

data class Breed(
    val breedName: String,
    val family: List<BreedFamily>
)

data class BreedFamily(
    val familyName: String
)