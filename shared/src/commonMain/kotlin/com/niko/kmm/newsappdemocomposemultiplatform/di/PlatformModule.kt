package com.niko.kmm.newsappdemocomposemultiplatform.di

import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.Module

interface Dispatcher{
    val io: CoroutineDispatcher
}

internal expect fun platformModule(): Module
