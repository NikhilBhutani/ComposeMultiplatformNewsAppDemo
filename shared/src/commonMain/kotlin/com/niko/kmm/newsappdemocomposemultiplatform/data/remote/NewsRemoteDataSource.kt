package com.niko.kmm.newsappdemocomposemultiplatform.data.remote

import com.niko.kmm.newsappdemocomposemultiplatform.data.models.NewsHeadlinesJson

interface NewsRemoteDataSource {
   suspend fun fetchHeadlines(): NewsHeadlinesJson
}