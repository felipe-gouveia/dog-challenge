package com.felipegouveia.dogchallenge.domain.repository


import com.felipegouveia.dogchallenge.domain.model.Breed
import kotlinx.coroutines.flow.Flow

interface ListBreeds {
    fun listBreeds(): Flow<List<Breed>>
}
