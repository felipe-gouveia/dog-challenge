package com.felipegouveia.dogchallenge.data.repository.di

import com.felipegouveia.dogchallenge.data.repository.BreedRepository
import com.felipegouveia.dogchallenge.domain.repository.ListBreedImages
import com.felipegouveia.dogchallenge.domain.repository.ListBreeds
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BreedRepositoryModule {
    @Binds
    abstract fun provideListBreedImages(repository: BreedRepository): ListBreedImages

    @Binds
    abstract fun provideListBreeds(repository: BreedRepository): ListBreeds
}
