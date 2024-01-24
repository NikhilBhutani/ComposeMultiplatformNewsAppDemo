package com.niko.kmm.newsappdemocomposemultiplatform.di

import com.niko.kmm.newsappdemocomposemultiplatform.presentation.details.NewsDetailsViewModel
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.home.NewsHomeViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object ViewModelsFac : KoinComponent {
    fun getNewsHomeViewModelFactory() = viewModelFactory { NewsHomeViewModel(get()) }
    fun getNewsDetailViewModelFactory() = viewModelFactory { NewsDetailsViewModel(get()) }
}