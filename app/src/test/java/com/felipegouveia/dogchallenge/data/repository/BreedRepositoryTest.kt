package com.felipegouveia.dogchallenge.data.repository

import com.felipegouveia.dogchallenge.data.api.BreedsDataSource
import com.felipegouveia.dogchallenge.data.mapper.toDomain
import com.felipegouveia.dogchallenge.data.model.BreedImagesResponse
import com.felipegouveia.dogchallenge.data.model.BreedResponse
import com.felipegouveia.dogchallenge.domain.model.Breed
import com.felipegouveia.dogchallenge.domain.model.BreedImage
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class BreedRepositoryTest {

    private lateinit var breedsDataSource: BreedsDataSource

    private lateinit var underTest: BreedRepository

    @Before
    fun setUp() {
        breedsDataSource = mockk()
        mockkStatic("com.felipegouveia.dogchallenge.data.mapper.BreedMapperKt")
        underTest = BreedRepository(breedsDataSource)
    }

    @Test
    fun `GIVEN value from datasource WHEN list breeds THEN return domain list`() = runTest {
        // given
        val expected = listOf(mockk<Breed>())
        val response = BreedResponse(
            message = mapOf("gaudi" to listOf("cavalier", "king")),
            status = "success"
        )
        coEvery { breedsDataSource.listBreeds() } returns response
        every { response.toDomain() } returns expected

        // when
        val actual = underTest.listBreeds().first()

        // then
        assert(actual == expected)
    }

    @Test
    fun `GIVEN value from datasource WHEN list breed images THEN return domain list`() = runTest {
        // given
        val expected = listOf(mockk<BreedImage>())
        val breedName = "cavalier"
        val amount = 10
        val response = BreedImagesResponse(
            message = listOf("url", "url2"),
            status = "success"
        )
        coEvery { breedsDataSource.imagesByBreed(breedName, amount) } returns response
        every { response.toDomain() } returns expected

        // when
        val actual = underTest.listBreedImages(breedName, amount).first()

        // then
        assert(actual == expected)
    }
}
