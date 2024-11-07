package com.felipegouveia.dogchallenge.data.api

import com.felipegouveia.dogchallenge.data.model.BreedImagesResponse
import com.felipegouveia.dogchallenge.data.model.BreedResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BreedsDataSource {

    /**
     * Returns all breeds from the API
     *
     * @return [BreedResponse] with the list of breeds
     */
    @GET("breeds/list/all")
    suspend fun listBreeds(): BreedResponse

    /**
     * Return multiple random dog image from a breed
     * @param breedName the name of the breed to get the image URLs of
     * @param amount the number of image URLs to get
     *
     * @return [BreedImagesResponse] with the list of image URLs and api result
     */
    @GET("breed/{breedName}/images/random/{amount}")
    suspend fun imagesByBreed(
        @Path("breedName") breedName: String,
        @Path("amount") amount: Int
    ): BreedImagesResponse
}