package com.felipegouveia.dogchallenge.data.repository

import com.felipegouveia.dogchallenge.data.api.BreedsDataSource
import com.felipegouveia.dogchallenge.data.mapper.toDomain
import com.felipegouveia.dogchallenge.domain.repository.ListBreedImages
import com.felipegouveia.dogchallenge.domain.repository.ListBreeds
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BreedRepository @Inject constructor(
    private val breedsDataSource: BreedsDataSource
) : ListBreedImages, ListBreeds {

    override fun listBreeds() = flow {
        emit(breedsDataSource.listBreeds().toDomain())
    }

    override fun listBreedImages(breedName: String, amount: Int) = flow {
        emit(breedsDataSource.imagesByBreed(breedName, amount).toDomain())
    }
}
