package com.felipegouveia.dogchallenge.domain.usecase

import com.felipegouveia.dogchallenge.domain.model.Breed
import com.felipegouveia.dogchallenge.domain.repository.ListBreeds
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ListBreedsUseCaseImplTest {

    private lateinit var repository: ListBreeds

    private lateinit var underTest: ListBreedsUseCaseImpl

    @Before
    fun setUp() {
        repository = mockk()
        underTest = ListBreedsUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN value from repository WHEN list breeds THEN return domain list`() = runTest {
        // given
        val expected = listOf(mockk<Breed>())
        coEvery { repository.listBreeds() } returns flowOf(expected)

        // when
        val actual = underTest().first()

        // then
        assert(actual == expected)
    }
}
