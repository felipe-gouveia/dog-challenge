package com.felipegouveia.dogchallenge.ui.feature.breeds.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.felipegouveia.dogchallenge.ui.common.ErrorView
import com.felipegouveia.dogchallenge.ui.common.LoadingView
import com.felipegouveia.dogchallenge.ui.feature.breeds.model.BreedUiModel
import com.felipegouveia.dogchallenge.ui.feature.breeds.view.BreedsListView
import com.felipegouveia.dogchallenge.ui.theme.DogChallengeTheme

@Composable
fun BreedsViewState(
    uiState: BreedsUiState,
    retryAction: () -> Unit,
    onBreedClick: (BreedUiModel) -> Unit
) {
    Column {
        when (uiState) {
            BreedsUiState.Error -> ErrorView(retry = retryAction)
            BreedsUiState.Loading -> LoadingView()
            is BreedsUiState.ShowBreeds -> BreedsListView(uiState.content, onClick = onBreedClick)
        }
    }
}

@Composable
@Preview
@PreviewLightDark
@PreviewFontScale
private fun BreedsViewStatePreview(
    @PreviewParameter(BreedsUiStatePreviewProvider::class) uiState: BreedsUiState
) {
    DogChallengeTheme {
        BreedsViewState(
            uiState = uiState,
            retryAction = { },
            onBreedClick = { }
        )
    }
}

internal class BreedsUiStatePreviewProvider : PreviewParameterProvider<BreedsUiState> {
    override val values: Sequence<BreedsUiState>
        get() = sequenceOf(
            BreedsUiState.Error,
            BreedsUiState.Loading,
            BreedsUiState.ShowBreeds(
                content = listOf(
                    BreedUiModel("Cavalier King Charles Spaniel"),
                    BreedUiModel("Pug"),
                    BreedUiModel("Bulldog"),
                    BreedUiModel("Husky"),
                    BreedUiModel("Poodle")
                )
            )
        )
}
