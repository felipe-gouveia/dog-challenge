package com.felipegouveia.dogchallenge.core

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherFactory {
    fun io(): CoroutineDispatcher
}
