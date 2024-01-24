package com.niko.kmm.newsappdemocomposemultiplatform.di

import io.ktor.client.engine.darwin.Darwin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import com.niko.kmm.newsappdemocomposemultiplatform.data.database.DatabaseDriverFactory
import org.koin.dsl.module

actual fun platformModule() = module {
    single { Darwin.create() }
    single { DatabaseDriverFactory() }
}


/**
 * ViewModels object implements KoinComponent thus able to get any
 * dependency that is listed in platform module we invoke getNewsHomeViewModel()
 * in swift ui to get an object of HomeViewModel
 */

//object ViewModels : KoinComponent {
//    fun getNewsHomeViewModel() = get<NewsHomeViewModel>()
//}