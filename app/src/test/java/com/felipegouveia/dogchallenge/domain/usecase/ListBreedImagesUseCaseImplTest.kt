package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.model.BreedImage
import com.felipegouveia.dogchallenge.domain.repository.ListBreedImages
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ListBreedImagesUseCaseImplTest {
    private lateinit var repository: ListBreedImages

    private lateinit var underTest: ListBreedImagesUseCaseImpl

    @Before
    fun setUp() {
        repository = mockk()
        underTest = ListBreedImagesUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN value from repository WHEN list breeds THEN return domain list`() = runTest {
        // given
        val expected = listOf(mockk<BreedImage>())
        val breedName = "cavalier"
        val amount = 10
        coEvery { repository.listBreedImages(breedName, amount) } returns flowOf(expected)

        // when
        val actual = underTest(breedName, amount).first()

        // then
        assert(actual == expected)
    }
}
