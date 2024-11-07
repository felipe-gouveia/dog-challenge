package com.felipegouveia.dogchallenge.domain.repository

import com.felipegouveia.dogchallenge.domain.model.BreedImage
import kotlinx.coroutines.flow.Flow

interface ListBreedImages {
    fun listBreedImages(breedName: String, amount: Int): Flow<List<BreedImage>>
}