package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.repository.ListBreedImages
import javax.inject.Inject

class ListBreedImagesUseCaseImpl @Inject constructor(
    private val repository: ListBreedImages
) : ListBreedImagesUseCase {
    override operator fun invoke(breedName: String, amount: Int) =
        repository.listBreedImages(breedName, amount)
}
