package com.felipegouveia.dogchallenge.data.api.di

import com.felipegouveia.dogchallenge.data.api.BreedsDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BreedsDataSourceModule {

    @Provides
    @Singleton
    fun provideBreedsDataSource(retrofit: Retrofit): BreedsDataSource = retrofit.create(
        BreedsDataSource::class.java
    )
}
