package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.model.Breed
import kotlinx.coroutines.flow.Flow

interface ListBreedsUseCase {
    operator fun invoke(): Flow<List<Breed>>
}