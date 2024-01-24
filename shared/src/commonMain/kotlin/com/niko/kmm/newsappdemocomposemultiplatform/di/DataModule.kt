package com.niko.kmm.newsappdemocomposemultiplatform.di

import com.niko.kmm.newsappdemocomposemultiplatform.data.database.NewsLocalDataSource
import com.niko.kmm.newsappdemocomposemultiplatform.data.database.NewsLocalDataSourceImpl
import com.niko.kmm.newsappdemocomposemultiplatform.data.remote.HomeApi
import com.niko.kmm.newsappdemocomposemultiplatform.data.mapper.DataMapper
import com.niko.kmm.newsappdemocomposemultiplatform.data.remote.NewsRemoteDataSource
import com.niko.kmm.newsappdemocomposemultiplatform.data.remote.NewsRemoteDataSourceImpl
import com.niko.kmm.newsappdemocomposemultiplatform.data.repository.GetNewsRepositoryImpl
import com.niko.kmm.newsappdemocomposemultiplatform.domain.repository.GetNewsRepository
import org.koin.dsl.module

fun dataModule() = module {

    single<NewsRemoteDataSource> {
        NewsRemoteDataSourceImpl(get())
    }

    single<NewsLocalDataSource> {
        NewsLocalDataSourceImpl(get())
    }

    single {
        DataMapper()
    }

    single<GetNewsRepository>{
        GetNewsRepositoryImpl(get(), get(), get())
    }

    single {
        HomeApi(get())
    }
}