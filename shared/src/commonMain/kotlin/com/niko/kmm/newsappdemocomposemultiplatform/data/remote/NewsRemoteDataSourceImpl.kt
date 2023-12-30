package com.niko.kmm.newsappdemocomposemultiplatform.data.remote


import com.niko.kmm.newsappdemocomposemultiplatform.data.models.NewsHeadlinesJson

class NewsRemoteDataSourceImpl(
    private val homeApi: HomeApi
) : NewsRemoteDataSource {

    override suspend fun fetchHeadlines(): NewsHeadlinesJson =
        homeApi.fetchHeadlines()
}