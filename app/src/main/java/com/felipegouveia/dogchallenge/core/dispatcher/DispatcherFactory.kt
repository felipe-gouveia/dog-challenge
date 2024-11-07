package com.felipegouveia.dogchallenge.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherFactory {
    fun io(): CoroutineDispatcher
}
