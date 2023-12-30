package com.niko.kmm.newsappdemocomposemultiplatform.di

import com.niko.kmm.newsappdemocomposemultiplatform.presentation.NewsHomeViewModel
import io.ktor.client.engine.android.Android
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule() = module {

    single { Android.create() }
//    viewModel { NewsHomeViewModel(get(), provideDispatcher()) }
}

internal class AndroidDispatcher: Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}

//internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()