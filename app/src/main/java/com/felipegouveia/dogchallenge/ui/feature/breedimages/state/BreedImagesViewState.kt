package com.felipegouveia.dogchallenge.ui.feature.breedimages.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.felipegouveia.dogchallenge.ui.common.ErrorView
import com.felipegouveia.dogchallenge.ui.common.LoadingView
import com.felipegouveia.dogchallenge.ui.feature.breedimages.model.BreedImagesUiModel
import com.felipegouveia.dogchallenge.ui.feature.breedimages.view.BreedImagesListView
import com.felipegouveia.dogchallenge.ui.theme.DogChallengeTheme

@Composable
fun BreedImagesViewState(
    uiState: BreedImagesUiState,
    retryAction: () -> Unit
) {
    Column {
        when(uiState) {
            BreedImagesUiState.Error -> ErrorView(retry = retryAction)
            BreedImagesUiState.Loading -> LoadingView()
            is BreedImagesUiState.ShowBreedImages -> BreedImagesListView(uiState.content)
        }
    }
}

@Composable
@Preview
@PreviewLightDark
@PreviewFontScale
private fun BreedImagesViewStatePreview(
    @PreviewParameter(BreedImagesViewStatePreviewProvider::class) uiState: BreedImagesUiState
) {
    DogChallengeTheme {
        BreedImagesViewState(
            uiState = uiState,
            retryAction = { }
        )
    }
}

@Suppress("MaxLineLength")
internal class BreedImagesViewStatePreviewProvider : PreviewParameterProvider<BreedImagesUiState> {
    override val values: Sequence<BreedImagesUiState>
        get() = sequenceOf(
            BreedImagesUiState.Error,
            BreedImagesUiState.Loading,
            BreedImagesUiState.ShowBreedImages(
                content = BreedImagesUiModel(
                    "Cavalier King Charles Spaniel", listOf(
                        "https://instagram.fopo6-2.fna.fbcdn.net/v/t51.29350-15/370256096_1008820930302431_6404287302284806531_n.jpg?stp=dst-jpg_e35_p640x640_sh0.08&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE4MDAuc2RyLmYyOTM1MC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=instagram.fopo6-2.fna.fbcdn.net&_nc_cat=111&_nc_ohc=MIGvf2BcbTgQ7kNvgFAxCZ4&_nc_gid=c0892b3b38b54a29aed2a7676aad78d0&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYAz--Ai6EP-pMv77XeBobFsaOJhVKLf1_ZgUd1uFa_IBA&oe=67340AAE&_nc_sid=d885a2",
                        "https://instagram.fopo6-1.fna.fbcdn.net/v/t51.29350-15/395067134_653608376917951_7770434911758921026_n.jpg?stp=dst-jpg_e35_p640x640_sh0.08&efg=eyJ2ZW5jb2RlX3RhZyI6ImltYWdlX3VybGdlbi4xNDQweDE4MDAuc2RyLmYyOTM1MC5kZWZhdWx0X2ltYWdlIn0&_nc_ht=instagram.fopo6-1.fna.fbcdn.net&_nc_cat=107&_nc_ohc=TwmVxrJOA1cQ7kNvgF7Y66M&_nc_gid=910967b785ec4f9caaab4f02a16140fc&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYBHO_mPCfGSa0AiYeEoffBxIFUSUNgEW7pGvZWya8GNjg&oe=6733EE39&_nc_sid=d885a2",
                        "https://instagram.fopo6-2.fna.fbcdn.net/v/t51.29350-15/321772182_906650600329278_2473309391234282012_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-2.fna.fbcdn.net&_nc_cat=106&_nc_ohc=Qgyp6EbDWF0Q7kNvgHNiId-&_nc_gid=8b411a22525047848bb79d6d0aa49339&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYB1xhQ-5voM5n97b6bxLxgTjCStoYSnroJtV6vS5tmW9g&oe=673419FB&_nc_sid=d885a2",
                        "https://instagram.fopo6-2.fna.fbcdn.net/v/t51.29350-15/323175073_744055013271570_7350868756768321626_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-2.fna.fbcdn.net&_nc_cat=106&_nc_ohc=iKLUgW9QrccQ7kNvgE38wOr&_nc_gid=56133586d9a8498b8b351d10a9094c38&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYD-DWwd9HwbYXtKfyvaoDk7r1MvFDZ1pfEFnPlFxSxvxQ&oe=673419AB&_nc_sid=d885a2",
                        "https://instagram.fopo6-1.fna.fbcdn.net/v/t51.29350-15/312188263_702447361119003_2972365820556120313_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-1.fna.fbcdn.net&_nc_cat=103&_nc_ohc=6vPsP5LJKb0Q7kNvgGwXKL4&_nc_gid=4599a1c976ba424cbf3c5ec17c6661db&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYCBqkq4oOi-Lu0-8z3LSnbCkZsQQ81Oed3FhM0kFna6BQ&oe=6733F804&_nc_sid=d885a2",
                        "https://instagram.fopo6-1.fna.fbcdn.net/v/t51.29350-15/298299077_472101411043861_8883645703183573306_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-1.fna.fbcdn.net&_nc_cat=101&_nc_ohc=HyXfFtEry9gQ7kNvgE6UTnI&_nc_gid=7317697ddc1c484295b4776b2c68f594&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYB483vGsTXtXOQ9gwF7waT1ze-W1iEQZEkqy5qfak-Fjw&oe=6733EC99&_nc_sid=d885a2",
                        "https://instagram.fopo6-2.fna.fbcdn.net/v/t51.29350-15/298193974_864177651225402_2293406057704360375_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-2.fna.fbcdn.net&_nc_cat=106&_nc_ohc=jybP7Hhc9-oQ7kNvgEyzNfQ&_nc_gid=ff8070c8d8ef409cbb9d77d8fed3be8e&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYCfEFhQX-jWYzVx8QbHsOxXGi0Su5jYKH8SQJNXDz_Pug&oe=6734119E&_nc_sid=d885a2",
                        "https://instagram.fopo6-2.fna.fbcdn.net/v/t51.29350-15/297539764_456895346450831_8990487808326284993_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-2.fna.fbcdn.net&_nc_cat=111&_nc_ohc=um06Rfy6OTUQ7kNvgG6ccWG&_nc_gid=fcd38072ec7a4a9e80e801c7639169a0&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYAxVuETul4dNI7VSSChAo8IP2WoofVcTd67VdHCO8F1qQ&oe=67341315&_nc_sid=d885a2",
                        "https://instagram.fopo6-1.fna.fbcdn.net/v/t51.29350-15/311308860_539528031311797_6757800559086174606_n.jpg?stp=dst-jpg_e35&_nc_ht=instagram.fopo6-1.fna.fbcdn.net&_nc_cat=101&_nc_ohc=dvNfAFndceQQ7kNvgFBufqv&_nc_gid=872ac1e7a0314bc7bee9aceb09ec6e84&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYC3FjiY4_0KZFvf81UqZ079wgxQnG-cEyE2WCRHmMfB7g&oe=6733F001&_nc_sid=d885a2",
                        "https://instagram.fopo6-1.fna.fbcdn.net/v/t51.29350-15/289039128_433710348306362_4189875512927146756_n.jpg?stp=dst-jpg_e35_p1080x1080&_nc_ht=instagram.fopo6-1.fna.fbcdn.net&_nc_cat=102&_nc_ohc=Fr9WUZJqXyMQ7kNvgEHYNwW&_nc_gid=83c78344bbe349419a05ae1ff7e783d2&edm=ANTKIIoBAAAA&ccb=7-5&oh=00_AYDdRICNG5vV0hkVWzEpaCyydkVczfY64Y9XGFwu4z3uOA&oe=6733F28B&_nc_sid=d885a2")
                )
            )
        )
}
