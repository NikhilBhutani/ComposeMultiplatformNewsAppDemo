package com.niko.kmm.newsappdemocomposemultiplatform.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            networkModule(
                enableNetworkLogs =
                true
            ), dataModule(), domainModule(), platformModule()
        )

    }

fun initKoin() = initKoin { }