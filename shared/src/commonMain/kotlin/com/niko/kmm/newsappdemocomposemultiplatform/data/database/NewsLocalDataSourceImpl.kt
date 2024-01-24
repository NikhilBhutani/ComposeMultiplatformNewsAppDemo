package com.niko.kmm.newsappdemocomposemultiplatform.data.database

import com.niko.kmm.newsappdemocomposemultiplatform.data.models.Article
import com.niko.kmm.newsappdemocomposemultiplatform.data.models.Source

class NewsLocalDataSourceImpl(
    databaseDriverFactory: DatabaseDriverFactory
) : NewsLocalDataSource {
    private val newsAppDatabase = NewsAppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = newsAppDatabase.newsAppDatabaseQueries

    override fun addNews(articles: List<Article>) {
        articles.forEach { article ->
            insertArticle(article)
        }
    }

    override fun clearDatabase() {
        dbQuery.removeAllNews()
    }

    override fun selectNewsInfo(title: String): Article {
        val newsTableArticle = dbQuery.selectNewsInfo(title).executeAsOne()

        return Article(
            title = newsTableArticle.title,
            content = newsTableArticle.content,
            description = newsTableArticle.description,
            publishedAt = newsTableArticle.publishedAt,
            source = Source(
                newsTableArticle.sourceId,
                newsTableArticle.sourceName.orEmpty()
            ),
            url = newsTableArticle.url.orEmpty(),
            urlToImage = newsTableArticle.urlToImage,
        )
    }

    private fun insertArticle(article: Article) {
        dbQuery.insertNews(
            title = article.title,
            content = article.content,
            description = article.description,
            publishedAt = article.publishedAt,
            author = article.author,
            url = article.url,
            urlToImage = article.urlToImage.orEmpty(),
            sourceId = article.source.id.orEmpty(),
            sourceName = article.source.name,
        )
    }
}