package com.niko.kmm.newsappdemocomposemultiplatform.android

import android.app.Application
import com.niko.kmm.newsappdemocomposemultiplatform.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication

class NewsApp : Application() {

    lateinit var newsKoinApp: KoinApplication

    override fun onCreate() {
        super.onCreate()
        newsKoinApp = initKoin() {
            androidLogger()
            androidContext(this@NewsApp)
        }
    }
}