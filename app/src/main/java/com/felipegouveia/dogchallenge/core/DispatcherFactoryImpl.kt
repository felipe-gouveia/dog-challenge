package com.felipegouveia.dogchallenge.core

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherFactoryImpl @Inject constructor() : DispatcherFactory {
    override fun io() = Dispatchers.IO
}
