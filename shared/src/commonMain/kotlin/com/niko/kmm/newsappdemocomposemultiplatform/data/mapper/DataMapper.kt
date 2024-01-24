package com.niko.kmm.newsappdemocomposemultiplatform.data.mapper

import com.niko.kmm.newsappdemocomposemultiplatform.data.models.NewsHeadlinesJson
import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline
import org.koin.core.component.KoinComponent

class DataMapper() : KoinComponent {

    operator fun invoke(newsHeadlinesJson: NewsHeadlinesJson): List<NewsHeadline> {
        return newsHeadlinesJson.articles.map {
            NewsHeadline(
                author = it.author.orEmpty(),
                content = it.content.orEmpty(),
                title = it.title,
                description = it.description.orEmpty(),
                source = it.publishedAt,
                url = it.url,
                urlToImage = it.urlToImage.orEmpty(),
                publishedAt = it.source.name
            )

        }
    }
}