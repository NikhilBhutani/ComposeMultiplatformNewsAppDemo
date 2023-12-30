package com.niko.kmm.newsappdemocomposemultiplatform.data.repository

import com.niko.kmm.newsappdemocomposemultiplatform.data.mapper.RemoteDataMapper
import com.niko.kmm.newsappdemocomposemultiplatform.data.remote.NewsRemoteDataSource
import com.niko.kmm.newsappdemocomposemultiplatform.domain.repository.GetNewsRepository
import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline

class GetNewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val remoteDataMapper: RemoteDataMapper,
) : GetNewsRepository {
    override suspend fun getHeadlines(): List<NewsHeadline> {
        return remoteDataMapper.invoke(newsRemoteDataSource.fetchHeadlines())
    }
}