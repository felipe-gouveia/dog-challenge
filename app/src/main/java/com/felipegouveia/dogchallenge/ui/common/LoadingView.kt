package com.felipegouveia.dogchallenge.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipegouveia.dogchallenge.R
import com.felipegouveia.dogchallenge.ui.theme.DogChallengeTheme
import com.felipegouveia.dogchallenge.ui.theme.Large

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimatoorView(
            modifier = Modifier.size(250.dp).align(Alignment.CenterHorizontally),
            R.raw.loading_dog
        )
        Spacer(modifier = Modifier.height(Large))
        Text(text = stringResource(id = R.string.loading_view_title))
    }
}

@Preview
@Composable
private fun BreedsLoadingViewPreview() {
    DogChallengeTheme {
        LoadingView()
    }
}
