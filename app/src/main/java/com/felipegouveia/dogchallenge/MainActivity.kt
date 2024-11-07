package com.felipegouveia.dogchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.felipegouveia.dogchallenge.ui.MainView
import com.felipegouveia.dogchallenge.ui.theme.DogChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogChallengeTheme {
                MainView()
            }
        }
    }
}
