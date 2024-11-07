package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.model.BreedImage
import kotlinx.coroutines.flow.Flow

interface ListBreedImagesUseCase {
    suspend operator fun invoke(breedName: String, amount: Int = 10): Flow<List<BreedImage>>
}
