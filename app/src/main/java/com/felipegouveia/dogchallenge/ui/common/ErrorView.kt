package com.felipegouveia.dogchallenge.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.felipegouveia.dogchallenge.R
import com.felipegouveia.dogchallenge.ui.theme.DogChallengeTheme
import com.felipegouveia.dogchallenge.ui.theme.Medium

@Composable
fun ErrorView(retry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimatoorView(
            modifier = Modifier.size(250.dp).align(Alignment.CenterHorizontally),
            R.raw.sad_sad_sad_dog
        )

        Spacer(modifier = Modifier.height(Medium))

        Text(
            text = stringResource(id = R.string.error_view_title),
            style = MaterialTheme.typography.titleLarge
        )

        Button(onClick = retry) {
            Text(text = stringResource(id = R.string.error_view_retry))
        }
    }
}

@Preview
@Composable
private fun BreedsErrorViewPreview() {
    DogChallengeTheme {
        ErrorView {}
    }
}
