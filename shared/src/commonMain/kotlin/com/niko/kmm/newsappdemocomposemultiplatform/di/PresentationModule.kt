package com.niko.kmm.newsappdemocomposemultiplatform.di

import com.niko.kmm.newsappdemocomposemultiplatform.presentation.NewsHomeViewModel
import dev.icerock.moko.mvvm.compose.ViewModelFactory
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.dsl.module

fun presentationModule() = module {
    single {
        viewModelFactory { NewsHomeViewModel(get()) }
    }
}

object ViewModelsFac : KoinComponent {
    fun getNewsHomeViewModelFactory() = get<ViewModelFactory<NewsHomeViewModel>>()
}