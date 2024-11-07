package com.felipegouveia.dogchallenge.domain.usecase.di

import com.felipegouveia.dogchallenge.domain.usecase.ListBreedImagesUseCase
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedsUseCase
import com.felipegouveia.dogchallenge.domain.usecase.ListBreedsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class BreedsUseCasesModule {
    @Binds
    abstract fun provideBreedsUseCase(breedsUseCase: ListBreedsUseCaseImpl): ListBreedsUseCase

    @Binds
    abstract fun provideBreedsImageUseCase(
        breedImagesUseCase: ListBreedImagesUseCase
    ): ListBreedImagesUseCase
}
