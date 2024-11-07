package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.repository.ListBreeds
import javax.inject.Inject

class ListBreedsUseCaseImpl @Inject constructor(
    private val repository: ListBreeds
) : ListBreedsUseCase {
    override operator fun invoke() = repository.listBreeds()
}
