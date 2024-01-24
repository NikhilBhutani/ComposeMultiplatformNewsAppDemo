package com.niko.kmm.newsappdemocomposemultiplatform.data.repository

import com.niko.kmm.newsappdemocomposemultiplatform.data.database.NewsLocalDataSource
import com.niko.kmm.newsappdemocomposemultiplatform.data.mapper.DataMapper
import com.niko.kmm.newsappdemocomposemultiplatform.data.remote.NewsRemoteDataSource
import com.niko.kmm.newsappdemocomposemultiplatform.domain.repository.GetNewsRepository
import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline

class GetNewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource,
    private val dataMapper: DataMapper,
) : GetNewsRepository {
    override suspend fun getHeadlines(): List<NewsHeadline> {
        newsLocalDataSource.clearDatabase()
        newsLocalDataSource.addNews(
            newsRemoteDataSource.fetchHeadlines()
                .articles
        )

        return dataMapper.invoke(newsRemoteDataSource.fetchHeadlines())
    }

    override suspend fun getDetailedNewsOfTitle(title: String): NewsHeadline {
        val article = newsLocalDataSource.selectNewsInfo(title)
        return NewsHeadline(
            author = article.author.orEmpty(),
            content = article.content.orEmpty(),
            title = article.title.orEmpty(),
            description = article.description.orEmpty(),
            source = article.source.name,
            url = article.url,
            urlToImage = article.urlToImage.orEmpty(),
            publishedAt = article.publishedAt,
        )
    }
}