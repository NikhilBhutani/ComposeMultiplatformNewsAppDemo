package com.niko.kmm.newsappdemocomposemultiplatform.di

import com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase.GetNewsDetailsUseCaseImpl
import com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase.GetNewsUseCaseImpl
import org.koin.dsl.module

fun domainModule() = module {

    single {
        GetNewsUseCaseImpl(get())
    }

    single {
        GetNewsDetailsUseCaseImpl(get())
    }
}