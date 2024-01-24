package com.niko.kmm.newsappdemocomposemultiplatform.di

import io.ktor.client.engine.android.Android
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module
import com.niko.kmm.newsappdemocomposemultiplatform.data.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext

actual fun platformModule() = module {

    single { Android.create() }
    single { DatabaseDriverFactory(androidContext()) }
}

internal class AndroidDispatcher : Dispatcher {
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
}

//internal actual fun provideDispatcher(): Dispatcher = AndroidDispatcher()